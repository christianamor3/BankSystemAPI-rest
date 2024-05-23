package BankApplication.BankApplication.Model.Service.Interfaces;

import BankApplication.BankApplication.Model.Domain.User;
import BankApplication.BankApplication.Model.Dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save (User user);

    UserDto findById(long id);

    List<UserDto> findAll();

    UserDto updateName(long id, UserDto userDto);

    String deleteById(long id);

    String deleteAll();




}
