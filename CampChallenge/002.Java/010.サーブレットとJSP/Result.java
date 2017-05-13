package org.camp.sample;

import java.io.Serializable;
import java.util.Date;

public class ResultData implements Serializable{
    private String luck;
    
    public ResultData(){}
    
    public String getLuck(){
        return luck;
    }
    
    public void setLuck(String luck){
    this.luck = luck;
    }
}
