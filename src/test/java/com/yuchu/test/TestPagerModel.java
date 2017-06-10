package com.yuchu.test;
import java.util.ArrayList;   
import java.util.List;

import com.yuchu.utils.PageModel;   
  
public class TestPagerModel {   
    public static void main(String[] args) {   
        List<String> list = new ArrayList<String>();   
        list.add("a");   
        list.add("b");   
        list.add("c");   
        list.add("d");   
        list.add("e");   
        list.add("f");   
        list.add("g");   
        list.add("h");   
        list.add("h");   
        list.add("i");   
        list.add("j");   
        list.add("k");   
        list.add("l");   
        list.add("m");   
        PageModel pm = new PageModel(list, 5);   
          
        List sublist = pm.getObjects(3);   
        for(int i = 0; i < sublist.size(); i++) {   
            System.out.println(sublist.get(i));   
        }   
        //System.out.println(sublist.get(0));   
    }   
  
}  