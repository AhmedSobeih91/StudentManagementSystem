package com.test.studentsmanagementsystem.Services;

import com.test.studentsmanagementsystem.DTO.Course_DTO_Request;
import com.test.studentsmanagementsystem.entity.Course;
import java.util.List;

public interface InterfaceCourseService {

    public int insert(Course_DTO_Request DTOrequest);

    public int update(Course_DTO_Request DTOrequest);

    public int delete(int id);

    public Course Find(int id);

    public List<Course> findAll();

}
