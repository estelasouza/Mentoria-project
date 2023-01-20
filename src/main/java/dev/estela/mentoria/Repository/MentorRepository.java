package dev.estela.mentoria.Repository;

import dev.estela.mentoria.Model.Mentorship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MentorRepository extends JpaRepository<Mentorship, Integer> {
    Page<Mentorship> findByName(String name, Pageable page);

    Page<Mentorship> findByDateBetween(Date startDate, Date endDate, Pageable page);

    Page<Mentorship> findByNameContaining(String keyword, Pageable page);
//    public fn
}
