package com.example.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Client;
import com.example.demo.model.User;
import com.example.demo.repository.clientRepo;
import com.example.demo.repository.userRepo;

@Controller
public class RController {
    
    @Autowired
    userRepo UserRepo;

    @Autowired
    clientRepo ClientRepo;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/user/{requestedId}")
    ResponseEntity<User> getUser(@PathVariable Integer requestedId){
        Optional<User> requestedUser = UserRepo.findById(requestedId);
        System.out.println(requestedUser.get().toString());
        return ResponseEntity.ok(requestedUser.get());
    }


    // @GetMapping("/user")
    // String postTest(){
    //     return "form";
    // }

    // @GetMapping("/form_page")
    // String tesst(@RequestParam("passwd") String passwd,@RequestParam("username") String username){
    //     System.out.println(passwd);
    //     return "gi.html";
    // }

    @PostMapping("/register")
    ResponseEntity<User> saveRegister(@RequestParam("password") String password,@RequestParam("username") String username) throws URISyntaxException{
        User user = new User(username, password);
        User use = UserRepo.save(user);
        URI uriOfUser = new URI("/register/"+user.getId());
        
        return ResponseEntity.created(uriOfUser).build();
    }

    @GetMapping("/register")
    String getRegisterPage() throws URISyntaxException{
        return "form.html";  //redirect:/form.html
    }

    @GetMapping("/Client/{RequestedId}")
    ResponseEntity<Client>  getClient(@PathVariable int RequestedId){
        Optional<Client> cll = ClientRepo.findById(RequestedId);
        if(!cll.isPresent())
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        return new ResponseEntity<>(cll.get(),HttpStatus.OK);
    }

    
    @PostMapping("/Client") //changing it to PostMapping
    ResponseEntity<Client> postClient(@RequestParam String companyName, @RequestParam String contactName, @RequestParam String phoneNumber ) throws URISyntaxException{
        Client cl = new Client(companyName, contactName, phoneNumber);
        Client cll = ClientRepo.save(cl);
        URI uriOfClient = new URI("/register/"+cll.getId());
        System.out.println(cl.toString());

        return ResponseEntity.created(uriOfClient).build();
    }
}
