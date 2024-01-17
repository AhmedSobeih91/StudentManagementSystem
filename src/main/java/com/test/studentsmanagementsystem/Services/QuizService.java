package com.test.studentsmanagementsystem.Services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.studentsmanagementsystem.DTO.Quiz_DTO_Request;
import com.test.studentsmanagementsystem.entity.Course;
import com.test.studentsmanagementsystem.entity.Quiz;
import org.hibernate.SessionFactory;

public class QuizService implements InterfaceQuizService {

    private Session session = null;
    private Transaction transaction = null;

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int insert(Quiz_DTO_Request DTOrequest) {
        try {
            CourseService courseService = new CourseService();
            Course course = courseService.Find(DTOrequest.getId());
            Quiz quiz = new Quiz();
            quiz.setQuiz_name(DTOrequest.getQuiz_name());
            quiz.setQuiz_time(DTOrequest.getQuiz_datetime());
            quiz.setQuiz_duration(DTOrequest.getQuiz_duration());
            quiz.setQuiz_score(DTOrequest.getQuiz_score());
            quiz.setCourse(course);
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(quiz);
            transaction.commit();
            return 1;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Quiz_DTO_Request DTOrequest) {
        try {
            CourseService courseService = new CourseService();
            Course course = courseService.Find(DTOrequest.getId());
            Quiz quiz = new Quiz();
            quiz.setId(DTOrequest.getId());
            quiz.setQuiz_name(DTOrequest.getQuiz_name());
            quiz.setQuiz_time(DTOrequest.getQuiz_datetime());
            quiz.setQuiz_duration(DTOrequest.getQuiz_duration());
            quiz.setQuiz_score(DTOrequest.getQuiz_score());
            quiz.setCourse(course);
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(quiz);
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
            Quiz quiz = Find(id);
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(quiz);
            transaction.commit();
            return 1;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Quiz Find(int id) {
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            Quiz quiz = session.get(Quiz.class, id);
            return quiz;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Quiz> findAll() {
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            String query = "select * from Quiz";
            SQLQuery quiz = session.createSQLQuery(query);
            List<Quiz> list = quiz.list();
            return list;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
