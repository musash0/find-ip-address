package com.example.paddy.core.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.paddy.core.model.UserConnection;

@Repository
public class UserConnectionDao {

    public UserConnectionDao() {

    }

    @Autowired
    private SessionFactory sessionFactory;

    public void saveConnection(UserConnection con) {
        sessionFactory.getCurrentSession().saveOrUpdate(con);
    }

    public List<UserConnection> findConnections(Timestamp sDate, Timestamp eDate) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(UserConnection.class);
        criteria.add(Restrictions.ge("time", sDate));
        criteria.add(Restrictions.le("time", eDate));
        return criteria.list();
    }

    public List<UserConnection> getAllConnections() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(UserConnection.class);
        return criteria.list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
