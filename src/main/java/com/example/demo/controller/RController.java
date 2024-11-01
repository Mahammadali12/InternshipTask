package com.example.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Client;
import com.example.demo.model.User;
import com.example.demo.repository.ClientRepo;
import com.example.demo.repository.UserRepo;

@Controller
public class RController {
    
    @Autowired
    UserRepo userRepo;

    @Autowired
    ClientRepo clientRepo;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/user/{requestedId}")
    ResponseEntity<User> getUser(@PathVariable Integer requestedId){
        Optional<User> requestedUser = userRepo.findById(requestedId);
        System.out.println(requestedUser.get().toString());
        return ResponseEntity.ok(requestedUser.get());
    }

    @PostMapping("/register")
    ResponseEntity<User> saveRegister(@RequestParam("password") String password,@RequestParam("username") String username) throws URISyntaxException{
        User user = new User(username, password);
        user = userRepo.save(user);
        System.out.println("---------------------------------------");
        System.out.println("USER WAS CREATED");
        System.out.println(user.toString());
        System.out.println("----------------------------------------");
        URI uriOfUser = new URI("/user/" + user.getId());
        
        return ResponseEntity.created(uriOfUser).build();
    }

    @GetMapping("/register")
    String getRegisterPage() throws URISyntaxException{
        return "form.html";  //redirect:/form.html
    }

    @GetMapping("/client/{RequestedId}")
    ResponseEntity<Client>  getClient(@PathVariable int RequestedId){
        Optional<Client> client = clientRepo.findById(RequestedId);
        if(!client.isPresent())
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        return new ResponseEntity<>(client.get(),HttpStatus.OK);
    }

    @GetMapping("/client")
    String getClientCreationPage(){
        return "client.html"; //redirect:form.html
    }

    
    @PostMapping("/client") 
    ResponseEntity<Client> postClient(@RequestParam String companyName, @RequestParam String contactName, @RequestParam String phoneNumber ) throws URISyntaxException{
        Client cl = new Client(companyName, contactName, phoneNumber);
        Client client = clientRepo.save(cl);
        System.out.println("-------------------------------");
        System.out.println("CLIENT WAS CREATED");
        System.out.println(client.toString());
        System.out.println("-------------------------------");
        URI uriOfClient = new URI("/client/" + client.getId());

        return ResponseEntity.created(uriOfClient).build();
    }
}
