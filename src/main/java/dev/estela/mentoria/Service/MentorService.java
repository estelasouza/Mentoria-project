package dev.estela.mentoria.Service;

import dev.estela.mentoria.Model.Mentorship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface MentorService {

    List<Mentorship> getAllMentors(Pageable page);

    Mentorship getMentorById(int id);

    void deleteMentorById(int id);

    Mentorship saveMentor(Mentorship mentor);

    Mentorship updatedMentor(int id, Mentorship mentor);

    List<Mentorship> readByName(String name, Pageable page);


    List<Mentorship> readByDate(Date startDate, Date endDate, Pageable page);
}
