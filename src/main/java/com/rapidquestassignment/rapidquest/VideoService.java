package com.rapidquestassignment.rapidquest;

import com.rapidquestassignment.rapidquest.VideoRepository;
import com.rapidquestassignment.rapidquest.models.Subtitle;
import com.rapidquestassignment.rapidquest.models.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public Long uploadVideo(MultipartFile videoFile, List<Subtitle> subtitles) throws IOException {
        Video video = new Video();
        video.setVideoPath(saveVideo(videoFile));
        video.setSubtitles(subtitles);
        videoRepository.save(video);
        return video.getId();
    }

    public Video getVideoById(Long videoId) {
        return videoRepository.findById(videoId).orElse(null);
    }

    private String saveVideo(MultipartFile videoFile) throws IOException {
        // Implement video saving logic here (e.g., save to a specific folder)
        // For simplicity, we'll return a placeholder path.
        return "/path/to/videos/" + videoFile.getOriginalFilename();
    }
}
