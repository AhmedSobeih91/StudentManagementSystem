package com.test.studentsmanagementsystem.Services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.studentsmanagementsystem.DTO.Course_DTO_Request;
import com.test.studentsmanagementsystem.entity.Course;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CourseService implements InterfaceCourseService {

    private Session session = null;
    private Transaction transaction = null;

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int insert(Course_DTO_Request DTOrequest) {
        try {
            Course course = new Course();
            course.setCourse_name(DTOrequest.getCourse_name());
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
            return 1;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Course_DTO_Request DTOrequest) {
        try {
            Course course = new Course();
            course.setId(DTOrequest.getId());
            course.setCourse_name(DTOrequest.getCourse_name());
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(course);
            transaction.commit();
            return 1;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try {
            Course course = Find(id);
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(course);
            transaction.commit();
            return 1;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Course Find(int id) {
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, id);
            return course;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Course> findAll() {
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            String query = "select * from Course";
            SQLQuery course = session.createSQLQuery(query);
            List<Course> list = course.list();
            return list;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
