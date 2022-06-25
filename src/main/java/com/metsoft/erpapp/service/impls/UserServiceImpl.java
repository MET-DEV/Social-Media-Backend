package com.metsoft.erpapp.service.impls;


import com.metsoft.erpapp.dto.AssignRoleToUserDto;
import com.metsoft.erpapp.dto.RegisterDto;
import com.metsoft.erpapp.model.dbModel.Role;
import com.metsoft.erpapp.model.dbModel.User;
import com.metsoft.erpapp.repository.RoleRepository;
import com.metsoft.erpapp.repository.UserRepository;
import com.metsoft.erpapp.service.interfaces.UserService;
import com.metsoft.erpapp.service.responseModel.Response;
import com.metsoft.erpapp.service.responseModel.SuccessDataResponse;
import com.metsoft.erpapp.service.responseModel.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private BCryptPasswordEncoder passEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder passEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passEncoder = passEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }


    @Override
    public Response save(RegisterDto registerDto) {
        User user=adjustDefaultUser(registerDto);
        userRepository.save(user);
        return new  SuccessResponse(true,"User saved");
    }

    @Override
    public Response delete(int id) {
        return new SuccessResponse(true,"User Deleted");
    }

    @Override
    public Response findAll() {
        return new SuccessDataResponse<List<User>>(true,"Users Listed",userRepository.findAll());
    }

    @Override
    public Response findById(int id) {
        return new SuccessDataResponse<Optional<User>>(true,"User Found",userRepository.findById(id));
    }

    @Override
    public Response assignRoleToUser(AssignRoleToUserDto assignRoleToUser) {
        User user=userRepository.findById(assignRoleToUser.getUser_id()).get();
        Role role=roleRepository.findById(assignRoleToUser.getRole_id()).get();
        user.getRoles().add(role);
        userRepository.save(user);
        return new SuccessResponse(true,"Role added");
    }


    private User adjustDefaultUser(RegisterDto registerDto){
        User user=registerDto.registerDtoToUser(registerDto);
        Role defaultRole=roleRepository.findByName("USER");
        user.setRoles(new HashSet<>());
        user.getRoles().add(defaultRole);
        user.setPassword(user.getPassword());
        user.setDate(LocalDateTime.now());
        user.setEnabled(false);
        user.setPassword(passEncoder.encode(user.getPassword()));
        return user;
    }







    /**
    private Response saveUserWithRole(User user){
        int roleId=user.getRoles().stream().findFirst().get().getId();
        user.setRoles(new HashSet<>());
        roleRepository.findById(roleId).map(role -> {
            user.getRoles().add(role);
            userRepository.save(user);
            return new SuccessResponse(true,"User saved");
        });
        return new ErrorResponse(false,"role not assign");
    }**/
}
