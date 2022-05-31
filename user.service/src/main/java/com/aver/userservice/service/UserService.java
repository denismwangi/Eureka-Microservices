package com.aver.userservice.service;

import com.aver.userservice.VO.Department;
import com.aver.userservice.VO.ResponseTemplateVO;
import com.aver.userservice.entity.User;
import com.aver.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    RestTemplate restTemplate;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public ResponseTemplateVO getUserWithDepartmnet(Long id) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findUserById(id);
        Department department = restTemplate.
                getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),
                        Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
