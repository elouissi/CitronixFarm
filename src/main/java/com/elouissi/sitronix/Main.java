package com.elouissi.sitronix;

import java.util.ArrayList;
import java.util.List;

public class Main {

        public List<List<String>> groupAnagrams(String[] strs) {
            List<String> tna = new ArrayList<>();
            List<String> bat = new ArrayList<>();
            List<String> tea = new ArrayList<>();
            for(String element : strs){
                if(element.contains("a") && element.contains("n")
                        && element.contains("t")){
                    tna.add(element);
                }else if(element.contains("a") && element.contains("b")
                        && element.contains("t")){
                    bat.add(element);
                }else{
                    tea.add(element);
                }
            }
            List<List<String>> nestedList = new ArrayList<>();
            nestedList.add(tna);
            nestedList.add(tea);
            nestedList.add(bat);
            return nestedList  ;







    }

}
