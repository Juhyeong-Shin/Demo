package com.example.demo.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")   //사용자 호출 api 공통적으로 붙이기
public class AdminUserController {
    private UserDaoService service;

    //service 어노테이션
    public AdminUserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {   //전체 사용자 검색
        return service.findAll();
    }

    //get / users / 1 or / users/10
    @GetMapping("/users/{id}")
    public MappingJacksonValue retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id","name","joinDate","ssn");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo",filter);

        MappingJacksonValue mapping= new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping;
    }
}
//    @PostMapping("/users")
//    public void createUser(@RequestBody User user) {
//        User savedUser = service.save(user);
//    }

