/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

/**
 *
 * @author gabri
 */
public class BasketballCards {
    String name;
    int shot;
    int layup;
    int dunk;
    int defense;
    int handles;
    
    public BasketballCards(String name, int shot, int layup,int dunk, int handles, int defense){
        this.name = name;
        this.shot = shot;
        this.layup = layup;
        this.dunk = dunk;
        this.handles = handles;  
        this.defense = defense;
               
    }

    @Override
    public String toString() {
        return "-----" + this.getName() + "-----" + "\n" + "Shot = " + this.getShot() + "\n" + "Layup = " + this.getLayup() + "\n" + "Dunk = " + this.getDunk() + "\n" + "Handles = " + this.getHandles() + "\n" + "Defense = " + this.getDefense();   
    };
 
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShot() {
        return shot;
    }

    public void setShot(int shot) {
        this.shot = shot;
    }

    public int getLayup() {
        return layup;
    }

    public void setLayup(int layup) {
        this.layup = layup;
    }
    
    public int getDunk(){
        return dunk;
    }
    
    public void setDunk(int dunk){
        this.dunk = dunk;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHandles() {
        return handles;
    }

    public void setHandles(int handles) {
        this.handles = handles;
    }
    
    void playerApresentation(){
        System.out.println("-----" + getName() + "------");
        System.out.println("Shot: " + getShot());
        System.out.println("Layup: " + getLayup());
        System.out.println("Handles: " + getHandles());
        System.out.println("Defense: " + getDefense());
    }
    
}
