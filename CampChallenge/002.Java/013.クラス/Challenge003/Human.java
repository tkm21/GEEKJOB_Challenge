
package org.camp.blackjack;


import java.util.*;

abstract class Human {
    protected ArrayList<String> myCards = new ArrayList<String>();
    
    abstract public int open(ArrayList<String> cd);
    abstract public void setCards(ArrayList<String> cd);
    abstract public boolean checkSum(ArrayList<String> cd);
    
}