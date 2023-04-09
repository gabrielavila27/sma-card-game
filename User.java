/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

/**
 *
 * @author gabri
 */
public class User {
    String name;
    int wins;
    int losses;
   
    public User(String name){
        this.wins = 0;
        this.losses = 0;
        this.name = name;
    }

    @Override
    public String toString() {
        return "name=" + name + ", wins=" + wins + ", losses=" + losses;
    }



    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
