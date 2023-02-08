package com.example.visitorcountapp.controller;

import com.example.visitorcountapp.model.Count;
import com.example.visitorcountapp.model.Visit;
import com.example.visitorcountapp.service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/visitor-count-app")
public class UrlHitController {
    @Autowired
    private UrlHitService urlService;

    public UrlHitController(UrlHitService urlService) {
        this.urlService=urlService;
    }
//    http://localhost:8080/api/v1/visitor-count-app/count
    @GetMapping("/count")
    public Count simpleCount(){
        return urlService.countFun();
    }
//    http://localhost:8080/api/v1/visitor-count-app/username/abhishek/count
    @GetMapping("/username/{username}/count")
    public Visit getCount(@PathVariable String username) {
        Visit visit=urlService.getVisits(username);
        return visit;
    }
}
