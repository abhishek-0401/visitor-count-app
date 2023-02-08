package com.example.visitorcountapp.service;

import com.example.visitorcountapp.model.Count;
import com.example.visitorcountapp.model.Visit;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class UrlHitService {
    static int counter=0;
    static Map<String,Integer> map=new HashMap<>();
    public Count countFun(){
        Count count =new Count(++counter);
        return count;
    }
    public Visit getVisits(String username) {

        int count=map.getOrDefault(username,0)+1;
        map.put(username,count);

        Visit visit=new Visit(username,count);
        return visit;
    }
}
