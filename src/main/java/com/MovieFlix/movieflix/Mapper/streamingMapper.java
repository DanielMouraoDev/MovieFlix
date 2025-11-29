package com.MovieFlix.movieflix.Mapper;

import com.MovieFlix.movieflix.Controller.Request.streamingRequest;
import com.MovieFlix.movieflix.Controller.Response.streamingResponse;
import com.MovieFlix.movieflix.Entity.streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class streamingMapper {

    public static streaming tostreaming(streamingRequest request) {
        return streaming
                .builder()
                .name(request.name())
                .build();
    }

    public static streamingResponse tostreamingResponse(streaming streaming) {
        return streamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}




