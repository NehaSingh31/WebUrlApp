package com.example.WebUrlApp;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {
LinkedHashMap<Integer,String> linkedHashmap=new LinkedHashMap<>();
int count=0;
@RequestMapping(value = "/storeurl", method = RequestMethod.POST)
public void  storeUrl(@RequestBody String string) {
	 try {
         new URL(string).toURI();
         linkedHashmap.put(count++, string);
     }
     catch (Exception e) {
         System.out.println("Not valid URL");
     }
}
@RequestMapping(value = "/get", method = RequestMethod.GET)
public int  getCount(@RequestBody String string) {
	Integer countIncrease=-1;
	for (Entry<Integer, String> entry : linkedHashmap.entrySet()) {
        if (entry.getValue().equals(string)) {
            countIncrease=entry.getKey()+1;
            return countIncrease;
        }
    }
	return -1;
}
@RequestMapping(value = "/count", method = RequestMethod.GET)
public int returnCount(@RequestBody String string) {
	return count;
}
@RequestMapping(value = "/list", method = RequestMethod.GET)
public Map<Integer, String> returnList() {
	return linkedHashmap;
}
}
