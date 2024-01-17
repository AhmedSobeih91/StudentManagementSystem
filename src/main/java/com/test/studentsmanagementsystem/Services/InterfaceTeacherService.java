
package com.test.studentsmanagementsystem.Services;

import com.test.studentsmanagementsystem.DTO.Teacher_DTO_Request;
import com.test.studentsmanagementsystem.entity.Teacher;
import java.util.List;


public interface InterfaceTeacherService {
    public int insert(Teacher_DTO_Request DTOrequest);
    public int update(Teacher_DTO_Request DTOrequest);
    public int delete(int id);
    public Teacher Find(int id);
    public List<Teacher> findAll();
    
}
