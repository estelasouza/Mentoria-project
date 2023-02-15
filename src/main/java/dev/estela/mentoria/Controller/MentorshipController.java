package dev.estela.mentoria.Controller;

import dev.estela.mentoria.Model.Mentorship;
import dev.estela.mentoria.Service.MentorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class MentorshipController {

    @Autowired
    private MentorService mentorService;

    @GetMapping("/mentor")
    public List<Mentorship> getAllMentors(Pageable page){

        return mentorService.getAllMentors(page);
    }

    @GetMapping("/mentor/{id}")
    public Mentorship  getMentorsById(@PathVariable("id") int id ){
        return mentorService.getMentorById(id);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/mentor")
    public void deleteMentorById(@RequestParam("id") int id){
        mentorService.deleteMentorById(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/mentor")
    public Mentorship saveMentor(@Valid @RequestBody Mentorship mentor){
        return mentorService.saveMentor(mentor);
    }

    @PutMapping("/mentor/{id}")
    public Mentorship updatedMentor(@RequestBody Mentorship updateMentor, @PathVariable("id") int id){
        return mentorService.updatedMentor(id,updateMentor);
    }

    @GetMapping("/mentor")
    public List<Mentorship> getMentorByName(@RequestParam String name, Pageable page){
        return mentorService.readByName(name, page);
    }


    @GetMapping("/mentor")
    public  List<Mentorship> getAllMentorByDate(
            @RequestParam(required = false) Date startDate, @RequestParam(required = false) Date endDate, Pageable page
    ){
        return mentorService.readByDate(startDate,endDate,page);
    }

}
