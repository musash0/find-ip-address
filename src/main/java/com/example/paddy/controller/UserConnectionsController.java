package com.example.paddy.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.paddy.core.model.UserConnection;
import com.example.paddy.core.service.UserConnectionService;

@Controller("/web-task")
public class UserConnectionsController {

    @Autowired
    private UserConnectionService userConnectionService;

    @RequestMapping(value = "/connections-list")
    public ModelAndView showConnections() {
        ModelAndView model = new ModelAndView("connections-list");
        model.addObject("connectionsList", userConnectionService.getAllConnections());
        model.addObject("connection", new UserConnection());
        return model;
    }

    @RequestMapping(value = "/connection")
    public ModelAndView saveConnection(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("connection");
        model.addObject("msg", "Connection was added");

        UserConnection userConnection = new UserConnection();
        userConnection.setBrowserName(request.getHeader("User-Agent"));
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null) {
            ipAddress = request.getHeader("X_FORWARDED_FOR");
            if (ipAddress == null) {
                ipAddress = request.getRemoteAddr();
            }
        }
        userConnection.setIpAddress(ipAddress);
        userConnection.setTime(new Timestamp(new Date().getTime()));
        userConnectionService.saveConnection(userConnection);

        return model;
    }

    public UserConnectionService getUserConnectionService() {
        return userConnectionService;
    }

    public void setUserConnectionService(UserConnectionService userConnectionService) {
        this.userConnectionService = userConnectionService;
    }
}
