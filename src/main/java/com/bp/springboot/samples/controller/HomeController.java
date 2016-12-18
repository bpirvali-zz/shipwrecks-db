package com.bp.springboot.samples.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by behzad.pirvali on 11/18/16.
 */
@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Welcome to Shipwrecks-db!";
    }
}
