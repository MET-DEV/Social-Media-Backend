package com.metsoft.erpapp.service.interfaces;

import com.metsoft.erpapp.model.dbModel.Role;
import com.metsoft.erpapp.service.responseModel.Response;

public interface RoleService {
    Response save(Role role);
    Response update(Role role);
    Response delete(int id);
    Response findAll();
    Response findById();
}
