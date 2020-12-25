package com.example.demo.controller;

import com.example.demo.model.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class AddressBookResource {
    ConcurrentHashMap<String, Contact> contacts=new ConcurrentHashMap<>();

    //Getting all the contact from the list
    @GetMapping("/")
    public List<Contact> getContact(){
        return new ArrayList<Contact>(contacts.values());
    }

    //Getting the contact by ID
    @GetMapping("/{id}")
    public Contact getContact(@PathVariable String id){
        return contacts.get(id);
    }

    //Adding contact to the list
    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact){
        contacts.put(contact.getId(), contact);
        return contact;
    }

}
