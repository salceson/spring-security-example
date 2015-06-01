package com.example.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Michał Ciołczyk
 */
@Controller
public class ApplicationController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String mainPage() {
        return "main";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/app/admin")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/app/user")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String userPage() {
        return "user";
    }
}
