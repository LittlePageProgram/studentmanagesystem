package com.electricpower.studentmanagesystem.service;

import com.electricpower.studentmanagesystem.dao.AdministratorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    AdministratorDao administratorDao;

    public boolean loginAdmin(String name, String password) {
        if(administratorDao.getAdminByName(name).getPasswd().equals(password)){
            return true;
        }else {
            return false;
        }
    }
}
