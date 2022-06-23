package com.metsoft.erpapp.service.impls;

import com.metsoft.erpapp.model.dbModel.User;
import com.metsoft.erpapp.repository.UserRepository;
import com.metsoft.erpapp.service.interfaces.UserService;
import com.metsoft.erpapp.service.responseModel.Response;
import com.metsoft.erpapp.service.responseModel.SuccessDataResponse;
import com.metsoft.erpapp.service.responseModel.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Response save(User user) {
        return new SuccessResponse(true,"User saved");
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
}
