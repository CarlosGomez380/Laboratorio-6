package edu.eci.cvds.servlet;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "guessBean")
@ApplicationScoped
public class BackBeanSession{
    
    int number;
    int tries;
    int prize;
    String status;
    
    public BackBeanSession(){
        number = (int)(Math.random());
        tries=0;
        prize=100000;
        status= "hasn't won";
    }
    
    public void guess(int numberGuess){
        if (numberGuess== number){
            status = "has won";
            
        }else{
            prize= prize-10000;
        }
        tries+=1;    
    }
    
    public void restart(){
        number = (int)(Math.random());
        tries=0;
        prize=100000;
        status= "hasn't won";
    }
    public int getNumber(){
        return number;
    }
    
    public int getTry(){
        return tries;
    }
    
    public int getPrize(){
        return prize;
    }
    
    public String getStatus(){
        return status;
    }
}
