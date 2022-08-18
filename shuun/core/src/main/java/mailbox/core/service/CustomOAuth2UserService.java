package mailbox.core.service;

import lombok.RequiredArgsConstructor;
import mailbox.core.config.auth.dto.OAuthAttributes;
import mailbox.core.config.auth.dto.SessionUser;
import mailbox.core.domain.user.User;
import mailbox.core.domain.user.Role;
import mailbox.core.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest
                .getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint().
                getUserNameAttributeName();
        OAuthAttributes attributes = OAuthAttributes.of(registrationId,
                userNameAttributeName,
                oAuth2User.getAttributes());

        String email;
        Map<String, Object> response = oAuth2User.getAttributes();

        if(registrationId.equals("naver")){
            Map<String, Object> hash = (Map<String, Object>) response.get("resoponse");
            email = (String) hash.get("email");
        }
        else if(registrationId.equals("google")){
            email = (String)response.get("email");
        }
        else{
            throw new OAuth2AuthenticationException("올바른 접근이 아닙니다.");
        }


        User user = saveOrUpdate(attributes);
        httpSession.setAttribute("user", new SessionUser(user));


//        Optional<User> optionalUser = userRepository.findByEmail(email);
//
//        if(optionalUser.isPresent()){
//            user = optionalUser.get();
//        }
//        else{
//            user = new User();
//            user.setEmail(email);
//            user.setRole(Role.USER);
//            userRepository.save(user);
//        }
//        httpSession.setAttribute("user", user);
//
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRole().toString())),
                oAuth2User.getAttributes(),
                attributes.getNameAttributeKey()
        );
    }

    private User saveOrUpdate(OAuthAttributes attributes){
        User user = userRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName(), attributes.getEmail()))
                .orElse(attributes.toEntity());

        return userRepository.save(user);
    }
}
