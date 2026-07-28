package com.movieFLix.Streaming;


import com.movieFLix.Streaming.dto.request.StreamingRequest;
import com.movieFLix.Streaming.dto.response.StreamingResponse;
import com.movieFLix.Streaming.mapper.StreamingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/movieFlix/Streaming")
@RequiredArgsConstructor
public class StreamingController {
    private StreamingService streamingService;

    @GetMapping("/movieFlix/Streaming")
    public ResponseEntity<List<StreamingResponse>> getAllStreamings() {
        List<StreamingResponse> streamings = streamingService.findAllStreamings().stream().map(StreamingMapper::toStreamingResponse).toList();
        return ResponseEntity.ok(streamings);
    }

    @PostMapping("/movieFlix/Streaming")
    public ResponseEntity<StreamingResponse> create(@RequestBody StreamingRequest request) {
        EntityJpaStreaming entityJpaStreaming = StreamingMapper.toEntityJpaStreaming(request);
        EntityJpaStreaming savedStreaming = streamingService.createStreaming(entityJpaStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStreaming));
    }
}