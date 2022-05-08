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
            // FIXME: 08.05.22 Sonuncu seife olanda ozunu nece aparacaq? 3 page 20 Item isdiyirse 110 Itemlik list nece page edilecek?
        }
        this.page = list.subList(startIndex,endIndex);
    }

}
