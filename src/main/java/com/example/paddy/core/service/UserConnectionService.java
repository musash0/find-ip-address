package com.example.paddy.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.paddy.core.dao.UserConnectionDao;
import com.example.paddy.core.model.UserConnection;

@Transactional
@Service
public class UserConnectionService {

    @Autowired
    private UserConnectionDao userConnectionDao;

    public UserConnectionDao getUserConnectionDao() {
        return userConnectionDao;
    }

    public void setUserConnectionDao(UserConnectionDao userConnectionDao) {
        this.userConnectionDao = userConnectionDao;
    }

    public List<UserConnection> getAllConnections() {
        return userConnectionDao.getAllConnections();
    }

    public void saveConnection(UserConnection userConnection) {
        userConnectionDao.saveConnection(userConnection);
    }

}
