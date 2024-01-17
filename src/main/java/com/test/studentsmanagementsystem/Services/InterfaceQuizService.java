
package com.test.studentsmanagementsystem.Services;

import com.test.studentsmanagementsystem.DTO.Quiz_DTO_Request;
import com.test.studentsmanagementsystem.entity.Quiz;
import java.util.List;


public interface InterfaceQuizService {
    public int insert(Quiz_DTO_Request DTOrequest);
    public int update(Quiz_DTO_Request DTOrequest);
    public int delete(int id);
    public Quiz Find(int id);
    public List<Quiz> findAll();
    
}
