package com.nikolian;

import java.util.ArrayList;
import java.util.Random;

public class DataModel {

    private Random random = new Random();
    private static ArrayList<Integer> totalIds = new ArrayList<Integer>();

    public int setNewId(){
       int newId = Math.abs(random.nextInt());

       if(!totalIds.contains(newId)) {
           totalIds.add(newId);
       } else {
           setNewId();
       }
        return newId;
    }
}
