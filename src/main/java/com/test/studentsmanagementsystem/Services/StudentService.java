package com.test.studentsmanagementsystem.Services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.studentsmanagementsystem.DTO.Student_DTO_Request;
import com.test.studentsmanagementsystem.entity.Course;
import com.test.studentsmanagementsystem.entity.Quiz;
import com.test.studentsmanagementsystem.entity.Student;
import java.util.ArrayList;
import org.hibernate.SessionFactory;

public class StudentService implements InterfaceStudentService {

    private Session session = null;
    private Transaction transaction = null;

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int insert(Student_DTO_Request DTOrequest) {
        try {
            CourseService courseService = new CourseService();
            List<Course> coursesList = new ArrayList<>();
            if (DTOrequest.getCourse() != null) {
                for (int courseId : DTOrequest.getCourse()) {
                    Course course = courseService.Find(courseId);
                    coursesList.add(course);
                }
            }

            QuizService quizService = new QuizService();
            List<Quiz> quizesList = new ArrayList<>();
            if (DTOrequest.getQuiz() != null) {
                for (int quizId : DTOrequest.getQuiz()) {
                    Quiz quiz = quizService.Find(quizId);
                    quizesList.add(quiz);
                }
            }

            Student student = new Student();
            student.setFristname(DTOrequest.getFristname());
            student.setLastname(DTOrequest.getLastname());
            student.setAddress(DTOrequest.getAddress());
            student.setPhone_number(DTOrequest.getPhone_number());
            student.setEmail(DTOrequest.getEmail());
            student.setQuez(quizesList);
            student.setCours(coursesList);

            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            return 1;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Student_DTO_Request DTOrequest) {
        try {
             CourseService courseService = new CourseService();
            List<Course> coursesList = new ArrayList<>();
            if (DTOrequest.getCourse() != null) {
                for (int courseId : DTOrequest.getCourse()) {
                    Course course = courseService.Find(courseId);
                    coursesList.add(course);
                }
            }

            QuizService quizService = new QuizService();
            List<Quiz> quizesList = new ArrayList<>();
            if (DTOrequest.getQuiz() != null) {
                for (int quizId : DTOrequest.getQuiz()) {
                    Quiz quiz = quizService.Find(quizId);
                    quizesList.add(quiz);
                }
            }
            Student student = new Student();
            student.setId(DTOrequest.getId());
            student.setFristname(DTOrequest.getFristname());
            student.setLastname(DTOrequest.getLastname());
            student.setAddress(DTOrequest.getAddress());
            student.setPhone_number(DTOrequest.getPhone_number());
            student.setEmail(DTOrequest.getEmail());
            student.setQuez(quizesList);
            student.setCours(coursesList);

            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(student);
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
            Student student = Find(id);
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();

            return 1;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Student Find(int id) {
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            Student student = (Student) session.get(Student.class, id);
            return student;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        try {

            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            String query = "select * from student";
            SQLQuery student = session.createSQLQuery(query);
            List<Student> list = student.list();
            return list;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
