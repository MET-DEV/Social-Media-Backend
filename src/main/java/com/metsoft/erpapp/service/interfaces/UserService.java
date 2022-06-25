package com.metsoft.erpapp.service.interfaces;

import com.metsoft.erpapp.dto.AssignRoleToUserDto;
import com.metsoft.erpapp.dto.RegisterDto;

import com.metsoft.erpapp.service.responseModel.Response;


public interface UserService {
    Response save(RegisterDto registerDto);
    Response delete(int id);
    Response findAll();
    Response findById(int id);
    Response assignRoleToUser(AssignRoleToUserDto assignRoleToUser);
}
