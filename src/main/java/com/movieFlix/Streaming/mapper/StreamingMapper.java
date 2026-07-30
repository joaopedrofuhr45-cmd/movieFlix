package com.movieFlix.Streaming.mapper;



import com.movieFlix.Streaming.EntityJpaStreaming;
import com.movieFlix.Streaming.dto.request.StreamingRequest;
import com.movieFlix.Streaming.dto.response.StreamingResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {
    public static EntityJpaStreaming toEntityJpaStreaming(StreamingRequest request){
        return EntityJpaStreaming
                .builder()
                .name(request.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(EntityJpaStreaming response){
        return StreamingResponse
                .builder()
                .id(response.getId())
                .name(response.getName())
                .build();
    }
}