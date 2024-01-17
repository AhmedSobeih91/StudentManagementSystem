
package com.test.studentsmanagementsystem.Services;

import com.test.studentsmanagementsystem.DTO.Student_DTO_Request;
import com.test.studentsmanagementsystem.entity.Student;
import java.util.List;


public interface InterfaceStudentService {
    public int insert(Student_DTO_Request DTOrequest);
    public int update(Student_DTO_Request DTOrequest);
    public int delete(int id);
    public Student Find(int id);
    public List<Student> findAll();
}
