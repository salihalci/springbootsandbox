package com.salci_study.restful_web_services.user;

import com.salci_study.restful_web_services.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAResource {

    private UserDaoService service;
    private UserRepository repository;

    public UserJPAResource(UserDaoService service,UserRepository repository) {

        this.service = service;
        this.repository = repository;
    }

    //GET /users
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return repository.findAll();

    }


    //GET /users/1
    @GetMapping("/jpa/users/{user_id}")
    public EntityModel<User> retrieveUser(@PathVariable Integer user_id) {

        Optional<User> usr = repository.findById(user_id.intValue());

        if(usr.isEmpty())
            throw new UserNotFoundException("id:"+user_id);

        EntityModel<User>  entityModel = EntityModel.of(usr.get());

        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;

    }

    //GET /users/1
    @DeleteMapping("/jpa/users/{user_id}")
    public void deleteUser(@PathVariable Integer user_id) {

        repository.deleteById(user_id.intValue());

    }

    //POST /users
    @PostMapping("/jpa/users")
    public ResponseEntity createUser(@Valid @RequestBody  User user){
       User usr = repository.save(user);

      //  URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return new ResponseEntity<User>(usr, HttpStatus.CREATED);
        //Headerda location geliyor.
    }



}
