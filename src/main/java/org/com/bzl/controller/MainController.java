package org.com.bzl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author menoly
 * @date : 2019/2/15 下午5:08
 */

@RestController
public class MainController {

    @GetMapping
    public String index() {
        return "hello";
    }
}
