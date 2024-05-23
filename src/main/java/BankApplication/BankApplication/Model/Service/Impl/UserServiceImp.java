package BankApplication.BankApplication.Model.Service.Impl;

import BankApplication.BankApplication.Exceptions.UsersNotFoundException;
import BankApplication.BankApplication.Model.Domain.User;
import BankApplication.BankApplication.Model.Dto.UserDto;
import BankApplication.BankApplication.Model.Repository.UserRepository;
import BankApplication.BankApplication.Model.Service.Interfaces.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public UserDto save(User user) {

        return toDto(userRepo.save(user));
    }

    @Override
    public UserDto findById(long id) {
        Optional<User> user = userRepo.findById(id);

        if (user.isEmpty()){
            throw new EntityNotFoundException();
        } else {
            return toDto(user.get());
        }
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepo.findAll();

        if (users.isEmpty() || users.size()==0){
            throw new UsersNotFoundException("Users not found");
        } else {
            return users.stream().map(this::toDto).toList();
        }
    }

    @Override
    public UserDto updateName(long id, UserDto userDto) {
        Optional<User> user = userRepo.findById(id);

        if (user.isEmpty()){
            throw new EntityNotFoundException("User not found");
        } else {
            user.get().setName(userDto.getName());
            userRepo.save(user.get());

            return toDto(user.get());
        }
    }

    @Override
    public String deleteById(long id) {
        Optional<User> user = userRepo.findById(id);

        if (user.isEmpty()){
            throw new EntityNotFoundException("User not found");
        } else {
            userRepo.deleteById(id);
            return "User deleted";
        }
    }

    @Override
    public String deleteAll() {
        List<User> users = userRepo.findAll();

        if (users.isEmpty() || users.size()==0){
            throw new UsersNotFoundException("Users not found");
        } else {
            userRepo.deleteAll(users);
            return "All users deleted";
        }
    }

    UserDto toDto(User user) {

        UserDto userDto = new UserDto();

        userDto.setUser_id(user.getUser_id());
        userDto.setName(user.getName());

        return userDto;
    }
}
