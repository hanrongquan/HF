package org.com.bzl.service.board.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnlineVideo {
    public OnlineVideo(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    private String videoUrl;
}
