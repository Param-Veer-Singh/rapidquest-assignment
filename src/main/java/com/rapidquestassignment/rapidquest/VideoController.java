package com.rapidquestassignment.rapidquest;

import com.rapidquestassignment.rapidquest.models.Subtitle;
import com.rapidquestassignment.rapidquest.models.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile videoFile,
                                              @RequestParam("subtitles") List<Subtitle> subtitles) throws IOException {
        Long videoId = videoService.uploadVideo(videoFile, subtitles);
        return ResponseEntity.ok("Video uploaded successfully. Video ID: " + videoId);
    }

    @GetMapping("/subtitles/{videoId}")
    public ResponseEntity<Video> getSubtitles(@PathVariable Long videoId) {
        Video video = videoService.getVideoById(videoId);
        if (video == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(video);
    }
}
