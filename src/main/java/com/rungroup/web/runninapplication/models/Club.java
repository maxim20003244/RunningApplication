package com.rungroup.web.runninapplication.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clubs")
public class Club {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String photoUrl;
    private LocalDateTime createOn;
    private LocalDateTime updateOn;

@OneToMany(mappedBy = "club" , cascade = CascadeType.REMOVE)
    private List<Event> event = new ArrayList<>();
@ManyToOne
    @JoinColumn(name="created_by" , nullable = false)
   private UserEntity createdBy;



}
