package com.gb.postupaylo.quarter.two.homework3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phoneBookMap = new HashMap<>();

    public void add(String secondName, String phoneNumber){
        boolean personExist = phoneBookMap.containsKey(secondName);
        if (personExist && phoneBookMap.get(secondName).contains(phoneNumber)){
            throw new IllegalArgumentException(String.format("%s already possess this %s phone number", secondName, phoneNumber));
        }

        if (personExist)
        {
            phoneBookMap.get(secondName).add(phoneNumber);
        }
        else {
            List<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            phoneBookMap.put(secondName, numbers);
        }
    }

    public List<String> get(String secondName){
        return phoneBookMap.get(secondName);
    }
}
