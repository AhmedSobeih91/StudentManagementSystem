package com.test.studentsmanagementsystem.Services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.studentsmanagementsystem.DTO.Teacher_DTO_Request;
import com.test.studentsmanagementsystem.entity.Course;
import com.test.studentsmanagementsystem.entity.Teacher;
import java.util.ArrayList;
import org.hibernate.SessionFactory;

public class TeacherService implements InterfaceTeacherService {

    private Session session = null;
    private Transaction transaction = null;

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int insert(Teacher_DTO_Request DTOrequest) {
        try {

            CourseService courseService = new CourseService();
            List<Course> coursesList = new ArrayList<>();
            if (DTOrequest.getCourseId()!= null) {
                for (int courseId : DTOrequest.getCourseId()) {
                    Course course = courseService.Find(courseId);
                    coursesList.add(course);
                }
            }
            Teacher teacher = new Teacher();
            teacher.setTeacherName(DTOrequest.getTeacherName());
            teacher.setAddress(DTOrequest.getAddress());
            teacher.setPhone_number(DTOrequest.getPhone_number());
            teacher.setEmail(DTOrequest.getEmail());
            teacher.setCourse(coursesList);
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(teacher);
            transaction.commit();
            return 1;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Teacher_DTO_Request DTOrequest) {
        try {

            CourseService courseService = new CourseService();
            List<Course> coursesList = new ArrayList<>();
            if (DTOrequest.getCourseId()!= null) {
                for (int courseId : DTOrequest.getCourseId()) {
                    Course course = courseService.Find(courseId);
                    coursesList.add(course);
                }
            }
            Teacher teacher = new Teacher();
            teacher.setId(DTOrequest.getId());
            teacher.setTeacherName(DTOrequest.getTeacherName());
            teacher.setAddress(DTOrequest.getAddress());
            teacher.setPhone_number(DTOrequest.getPhone_number());
            teacher.setEmail(DTOrequest.getEmail());
            teacher.setCourse(coursesList);

            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(teacher);
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
            Teacher teacher = Find(id);
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(teacher);
            transaction.commit();
            return 1;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Teacher Find(int id) {
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            Teacher teacher = session.get(Teacher.class, id);
            return teacher;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Teacher> findAll() {
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            String query = "select * from Teacher";
            SQLQuery teacher = session.createSQLQuery(query);
            List<Teacher> list = teacher.list();
            return list;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
