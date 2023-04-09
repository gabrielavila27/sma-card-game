/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

/**
 *
 * @author gabri
 */
public class Queue {
    Object[] array;
    int first, last, size;
    public Queue(int amount){
        this.first = 0;
        this.last = 0;
        this.size = 0;
        this.array = new Object[amount];
    }
    
    public boolean isEmpty(){
        if (this.size == 0){
            return true;
        } else{
            return false;
        }
    }
    
    boolean isFull(){
    if(this.size == this.array.length){
        return true;
    } else{
        return false;
    }}
    
    void add(Object element){
        if (this.isFull()){
            System.out.println("You can't add a element! Queue is full!");
        } else{
            this.array[last] = element;
            this.last = (this.last + 1) % this.array.length;
            this.size ++;
            System.out.println("Element has been queued");
        }
    }
    
    void removeElement(){
        if(isEmpty()){
            System.out.println("There are no elements to remove");
        } else{
            this.array[first] = null;
            this.first = (this.first + 1) % this.array.length;
            this.size--;
            System.out.println("Element has been unqueued");
        }
    }
    
    Object getFirst(){
        if (this.isEmpty()){
            return null;
        } else{
        return this.array[first];
        }
    }
    
    void printQueue(){
        for (int c = this.first; c < this.size; c++){
            System.out.println(this.array[c]);
        }
        
        for (int i = 0; i < this.last; i++){
            System.out.println(this.array[i]);
        }
    }
}
