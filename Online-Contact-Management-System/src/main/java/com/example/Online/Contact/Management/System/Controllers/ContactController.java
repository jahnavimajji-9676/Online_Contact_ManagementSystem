package com.example.Online.Contact.Management.System.Controllers;


import com.example.Online.Contact.Management.System.Models.Contacts;
import com.example.Online.Contact.Management.System.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/addUsers")
    public ResponseEntity<Map<String, String>> adsUsers(@RequestBody Contacts c){
        Contacts c1=contactRepository.save(c);
        Map<String,String> response=new HashMap<>();
        response.put("status","Successfull");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/viewallUsers")
    public ResponseEntity<List<Contacts>> viewAllUsers()
    {
        List<Contacts> vdata=contactRepository.findAll();
        return ResponseEntity.ok(vdata);
    }

    @PostMapping("/deleteUser")
    public ResponseEntity<Map<String,String>> deleteUser(@RequestBody Contacts pt2){
        contactRepository.deleteUser(pt2.getEmail());
        Map<String,String> response=new HashMap<>();
        response.put("Status" , "Successfull");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateUser")
    public ResponseEntity<Map<String,String>> updateUser(@RequestBody Contacts pt3){
        contactRepository.updateUser(pt3.getPhono());
        Map<String,String> response=new HashMap<>();
        response.put("Status" , "Successfull");
        return ResponseEntity.ok(response);
    }




}
