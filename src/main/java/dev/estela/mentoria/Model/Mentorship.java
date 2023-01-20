package dev.estela.mentoria.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mentors")
public class Mentorship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, message = "Name must be at least 3 characters ")
    public  String name;
    @NotNull
    public String text;

    @NotNull(message = "Date must not be null")
    private Date date;

    @Column(name = "created_at", nullable = false,updatable = false)
    @CreationTimestamp
    public Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    public Timestamp updatedAt;


}
