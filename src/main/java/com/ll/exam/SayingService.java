package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SayingService {
    private List<Saying> listOfSaying;
    private int lastId;

    SayingService() {
        listOfSaying = new ArrayList<>();
        lastId = 1;
    }

    public Saying findId(int paramId) {
        for (Saying saying : listOfSaying) {
            if (saying.id == paramId)
                return saying;
        }
        return null;
    }


    public List<Saying> findAll() {
        return listOfSaying;
    }

    public Saying addSaying(String content, String author) {
        Saying saying = new Saying(content, author, lastId);
        listOfSaying.add(saying);
        lastId++;
        return saying;
    }

    public void remove(int paramId) {
        Saying sayingToDelete = findId(paramId);
        listOfSaying.remove(sayingToDelete);
    }

    public void editById(int paramId, String content, String author) {
        Saying sayingToEdit = findId(paramId);
        sayingToEdit.author = author;
        sayingToEdit.saying = content;
    }





}