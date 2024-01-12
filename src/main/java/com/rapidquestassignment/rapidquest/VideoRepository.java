package com.rapidquestassignment.rapidquest;

import com.rapidquestassignment.rapidquest.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
}
