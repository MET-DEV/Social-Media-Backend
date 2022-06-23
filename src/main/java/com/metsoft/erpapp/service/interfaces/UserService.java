package com.metsoft.erpapp.service.interfaces;

import com.metsoft.erpapp.model.dbModel.User;
import com.metsoft.erpapp.service.responseModel.Response;


public interface UserService {
    Response save(User user);
    Response delete(int id);
    Response findAll();
    Response findById(int id);
}
