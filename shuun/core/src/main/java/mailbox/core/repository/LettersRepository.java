package mailbox.core.repository;

import mailbox.core.domain.Letters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LettersRepository extends JpaRepository<Letters, Long> {

    @Query("SELECT p FROM Letters p order by p.letterIdx desc ")
    List<Letters> findAllDesc();


}
