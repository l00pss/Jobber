package com.jobber.ws.model.filter;

import com.jobber.ws.util.response.SimplePageable;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
public class JPage <T>{
    private  List<T> page;

    public JPage(LinkedList<T> list, SimplePageable simplePageable){
        int startIndex= simplePageable.startIndex();
        int endIndex = simplePageable.endIndex();

        if(simplePageable.getPage()==(list.size() / simplePageable.getSize()) + 1
                && list.size() % simplePageable.getSize() != 0)
        {

        }
        this.page = list.subList(startIndex,endIndex);
    }

}
