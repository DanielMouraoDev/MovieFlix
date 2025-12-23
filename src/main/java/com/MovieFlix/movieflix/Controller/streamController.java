package com.MovieFlix.movieflix.Controller;

import com.MovieFlix.movieflix.Controller.Request.streamingRequest;
import com.MovieFlix.movieflix.Controller.Response.streamingResponse;
import com.MovieFlix.movieflix.Entity.streaming;
import com.MovieFlix.movieflix.Mapper.streamingMapper;
import com.MovieFlix.movieflix.Service.streamingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class streamController {

    private final streamingService streamingService;

    @GetMapping
    public ResponseEntity<List<streamingResponse>> getAllStreamings() {
        List<streamingResponse> streamings = streamingService.findAll()
                .stream()
                .map(streamingMapper::tostreamingResponse)
                .toList();

        return ResponseEntity.ok(streamings);
    }

    @PostMapping
    public ResponseEntity<streamingResponse> saveStreaming(@Valid @RequestBody streamingRequest request) {
        streaming newStreaming = streamingMapper.tostreaming(request);
        streaming savedStreaming = streamingService.save(newStreaming);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(streamingMapper.tostreamingResponse(savedStreaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<streamingResponse> getStreamingById(@PathVariable Long id) {
        return streamingService.findById(id)
                .map(stream -> ResponseEntity.ok(streamingMapper.tostreamingResponse(stream)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStreamingById(@PathVariable Long id) {
        streamingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}