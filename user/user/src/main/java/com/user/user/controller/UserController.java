package com.user.User.controller;

import com.user.User.model.UserInfo;
import com.user.User.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/pops")
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @PostMapping("/create")
    public ResponseEntity<UserInfo>createProduct(@RequestBody UserInfo userInfo) {
        UserInfo productInfo1=userRepo.save(userInfo);
        return ResponseEntity.ok().body(productInfo1);

    }
    @GetMapping("/getp")
    public ResponseEntity<List<UserInfo>>getAllUserInfo()
    {
        List<UserInfo> userData=userRepo.findAll();
        return ResponseEntity.ok().body(userData);
    }
    @PostMapping("/id/{id}")
    public ResponseEntity<Optional<UserInfo>> getById(@PathVariable Long id) {
        Optional<UserInfo> userInfo = userRepo.findById(id);
        if (userInfo.isPresent()) {
            return ResponseEntity.ok().body(userInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        userRepo.deleteById(id);
        return ResponseEntity.ok().body("deleted");

    }
}
