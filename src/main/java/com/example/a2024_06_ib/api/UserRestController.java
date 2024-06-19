package com.example.a2024_06_ib.api;

import com.example.a2024_06_ib.model.MovieBean;
import com.example.a2024_06_ib.model.UserBean;
import com.example.a2024_06_ib.services.MoviesService;
import com.example.a2024_06_ib.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private MoviesService moviesService;

    //http://localhost:8080/users/directAccessReactive
    @GetMapping ("/directAccessReactive")
    public Mono<MovieBean> directAccessReactive() {
        System.out.println("/directAccessReactive");



        return moviesService.getMoviesByIdAsync(1L);
    }

    //http://localhost:8080/users/eurekaAccess
    @GetMapping ("/eurekaAccess")
    public MovieBean eurekaAccess() {
        System.out.println("/eurekaAccess");

        return moviesService.getMoviesByIdLoadBalancing(1L);
    }

    //http://localhost:8080/users/eurekaAccessReactive
    @GetMapping ("/eurekaAccessReactive")
    public Mono<MovieBean> eurekaAccessReactive () {
        System.out.println("/eurekaAccessReactive ");

        return moviesService.getMoviesByIdLoadBalancingAndWebFlux(1L);
    }

    //http://localhost:8080/users
//Json Attendu : {"pseudo": "toto", "message": 12}
    @PostMapping
    public ResponseEntity<UserBean> createUser(@RequestBody UserBean user) {
        System.out.println("/saveMessage : " + user);
        UserService.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //http://localhost:8080/users
    @GetMapping
    public ArrayList<UserBean> getUsers() {
        return UserService.load();
    }

    //http://localhost:8080/users/5
    @GetMapping  ("/{id}")
    public ResponseEntity<UserBean> getUser(@PathVariable Long id) {
        var user = UserService.findById(id);
        if(user == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    //http://localhost:8080/users
//Json Attendu : {"pseudo": "toto", "message": 12}
    @PutMapping   ("/{id}")
    public ResponseEntity<UserBean> updateUser(@PathVariable Long id, @RequestBody UserBean user){
        var userbdd = UserService.findById(id);
        if(userbdd == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        else {
            UserService.save(user)          ;
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    //http://localhost:8080/users
//Json Attendu : {"pseudo": "toto", "message": 12}
    @DeleteMapping   ("/{id}")
    public void deleteUser(@PathVariable Long id, HttpServletResponse response){
        if(UserService.deleteById(id)){
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
        else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }
    }
}
