package com.rapidquestassignment.rapidquest.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Embeddable
public class Subtitle {
    private double timestamp;
    private String text;
}
