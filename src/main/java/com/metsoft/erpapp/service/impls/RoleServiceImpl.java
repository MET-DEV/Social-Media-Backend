package com.metsoft.erpapp.service.impls;

import com.metsoft.erpapp.model.dbModel.Role;
import com.metsoft.erpapp.repository.RoleRepository;
import com.metsoft.erpapp.service.interfaces.RoleService;
import com.metsoft.erpapp.service.responseModel.Response;
import com.metsoft.erpapp.service.responseModel.SuccessDataResponse;
import com.metsoft.erpapp.service.responseModel.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Response save(Role role) {
        roleRepository.save(role);
        return new SuccessResponse(true,"Role saved");
    }

    @Override
    public Response update(Role role) {
        return null;
    }

    @Override
    public Response delete(int id) {
        return null;
    }

    @Override
    public Response findAll() {
        return new SuccessDataResponse<List<Role>>(true,"Roles Listed",roleRepository.findAll());
    }

    @Override
    public Response findById() {
        return null;
    }
}
