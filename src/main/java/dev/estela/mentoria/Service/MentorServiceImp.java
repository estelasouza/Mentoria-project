package dev.estela.mentoria.Service;

import dev.estela.mentoria.Exception.ResourceNotFoundException;
import dev.estela.mentoria.Model.Mentorship;
import dev.estela.mentoria.Repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MentorServiceImp implements MentorService {

    @Autowired
    private MentorRepository mentorRepo;

    @Override
    public List<Mentorship> getAllMentors(Pageable page){
        return mentorRepo.findAll(page).toList();
    }

    @Override
    public  Mentorship getMentorById(int id) {
        Optional<Mentorship> mentor = mentorRepo.findById(id);
        if( mentor.isPresent()){
            return mentor.get();
        }
        throw new ResourceNotFoundException("Mentor not found for the id"+ id);
    }

    @Override
    public void deleteMentorById(int id){
        Mentorship user = getMentorById(id);
        mentorRepo.deleteById(user.getId());
    }

    @Override
    public Mentorship saveMentor(Mentorship mentor){
        return mentorRepo.save(mentor);
    }

    @Override
    public Mentorship updatedMentor(int id, Mentorship mentor){
        Mentorship getMentor = getMentorById(id);

        getMentor.setName(mentor.getName() != null ? mentor.getName() : getMentor.getName());
        getMentor.setText(mentor.getText() != null ? mentor.getText() : getMentor.getText());
        return mentorRepo.save(getMentor);
    }

    @Override
    public List<Mentorship> readByName(String name, Pageable page){
        return mentorRepo.findByNameContaining(name,page).toList();
    }

    @Override
    public  List<Mentorship> readByDate(Date startDate, Date endDate, Pageable page){

        if (startDate == null){
            startDate = new Date(0);
        }
        if (endDate  == null){
            endDate = new Date(System.currentTimeMillis());
        }

        Page<Mentorship> pages = mentorRepo.findByDateBetween(startDate,endDate,page);
        return pages.toList();

    }
}
