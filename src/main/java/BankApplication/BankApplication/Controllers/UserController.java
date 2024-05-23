package BankApplication.BankApplication.Controllers;


import BankApplication.BankApplication.Model.Domain.User;
import BankApplication.BankApplication.Model.Dto.UserDto;
import BankApplication.BankApplication.Model.Service.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping ("/save")
    public ResponseEntity<UserDto> saveUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @GetMapping ("/find/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping ("/findAll")
    public ResponseEntity<List<UserDto>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateName(@PathVariable long id, @RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.updateName(id, userDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById (@PathVariable long id){
        return ResponseEntity.ok(userService.deleteById(id));
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll(){
        return ResponseEntity.ok(userService.deleteAll());
    }

}
