package edu.eci.cvds.servlet;

import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "guessBean")
@SessionScoped
public class BackBeanSession{
    
    int number;
    int tries;
    int prize;
    String status;
    ArrayList<Integer> tryNumbers;
    int lastElement; 
    
    public BackBeanSession(){
        int min=1;
        int max=100;
        int range= max- min +1;
        number = (int)(Math.random()* range)+min;
        tries=0;
        prize=100000;
        status= "hasn't won";
        tryNumbers =  new ArrayList<>();
        
    }
    
    public void guess(int numberGuess){
        System.out.println(number);
        System.out.println(numberGuess);
        if (numberGuess == number){
            status = "has won";
            
            
        }else{
            prize= prize-10000;
            tries+=1;
            tryNumbers.add(numberGuess);
        }
            
    }
    
    public void restart(){
        number = (int)(Math.random());
        tries=0;
        prize=100000;
        status= "hasn't won";
        tryNumbers.clear();
    }
    public int getNumber(){
        return number;
    }
    
    public void setNumber(int number){
        this.number=number;
    }
    
    public int getTries(){
        return tries;
    }
    
    public void setTries(int tries){
        this.tries=tries;
    }
    
    public int getPrize(){
        return prize;
    }
    
    public void setPrize(int prize){
        this.prize=prize;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status=status;
    }
    
    public ArrayList getTryNumbers(){
        return tryNumbers;
    }
    
    public void setTryNumbers(ArrayList tryNumbers){
        this.tryNumbers=tryNumbers;
    }
    
    
}
