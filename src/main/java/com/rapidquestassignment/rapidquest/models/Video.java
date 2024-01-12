package com.rapidquestassignment.rapidquest.models;

import com.rapidquestassignment.rapidquest.models.Subtitle;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String videoPath;

    @ElementCollection
    private List<Subtitle> subtitles;
}
