package com.salci_study.restful_web_services.user;

import com.salci_study.restful_web_services.HelloWorldController;
import jakarta.validation.Valid;
import org.aspectj.bridge.Message;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    //GET /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();

    }


    //GET /users/1
    @GetMapping("/users/{user_id}")
    public EntityModel<User> retrieveUser(@PathVariable Integer user_id) {

        User usr = service.findOne(user_id.intValue());

        if(usr==null)
            throw new UserNotFoundException("id:"+user_id);

        EntityModel<User>  entityModel = EntityModel.of(usr);

        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;

    }

    //GET /users/1
    @DeleteMapping("/users/{user_id}")
    public User deleteUser(@PathVariable Integer user_id) {

        User usr = service.deleteOne(user_id.intValue());

        if(usr==null)
            throw new UserNotFoundException("id:"+user_id);

        return usr;

    }

    //POST /users
    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody  User user){
       User usr = service.save(user);
      //  URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return new ResponseEntity<User>(usr, HttpStatus.CREATED);
        //Headerda location geliyor.
    }



}
