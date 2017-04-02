package com.theironyard.novauc.controllers;

import org.springframework.security.authentication.jaas.SecurityContextLoginModule;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by souporman on 3/31/17.
 */

@Controller
public class DefaultController {

    @RequestMapping(value="/")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth==null)
            return "login";
        return "home";
    }

    @RequestMapping(value="/login")
    public String login(String username,String password,HttpServletRequest request, HttpServletResponse response) throws Exception{


//        Subject user = new Subject(username,password);
//        new SecurityContextLoginModule().initialize(user,CallbackHandler.class ,response);
        // new SecurityContextLogoutHandler().logout(request, response, auth);
        //I THOUGHT I COULD CREATE AN AUTHENTIC USER IN THIS FASHION I CANNOT;
//        auth.inMemoryAuthentication().withUser(username).password(password).roles("USER");
        return "home";
    }

    @RequestMapping(value = "/format")
    public String format() {
        return "<h1>WELCOME FROM THE CIA!</h1>" +
                "Use the following Commands:<br><br>" +
                "GET ALL USERS: /citizen<br>" +
                "GET USER BY ID: /getOneCitizen?id=[id]<br>" +
                "DELETE USER: /deleteCitizen?id=[id]<br><br><br><br>";
    }

    @RequestMapping(value="/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        request.setAttribute("logout","logout");
        return "login";
    }

}
