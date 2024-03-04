package com.github.makewheels;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wechat")
public class WeChatController {
    @RequestMapping("login")
    public String login() {
        VideoMoveJob videoMoveJob = new VideoMoveJob();
        return "login";
    }
}
