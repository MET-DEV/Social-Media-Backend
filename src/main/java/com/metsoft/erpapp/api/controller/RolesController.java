package com.metsoft.erpapp.api.controller;

import com.metsoft.erpapp.model.dbModel.Role;
import com.metsoft.erpapp.service.interfaces.RoleService;
import com.metsoft.erpapp.service.responseModel.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/roles/")
public class RolesController {
    private RoleService roleService;

    @Autowired
    public RolesController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    public Response findAll(){
        return roleService.findAll();
    }
    @PostMapping("")
    public Response save(@RequestBody Role role){
        return roleService.save(role);
    }
}
