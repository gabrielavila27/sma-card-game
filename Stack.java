/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

/**
 *
 * @author gabri
 */
public class Stack {
    Object[] array;
    int top;
    int length;
    // isEmpty, isFull, Stackup, pop
    public Stack(int length){
        this.length = length;
        this.top = -1;
        this.array = new Object[length];
    }
    
    public boolean isEmpty(){
        return this.top == -1;
    }
    
    public boolean isFull(){
        return this.top >= this.length;
    }
    
    void push(Object element){
        if (isFull()){
            System.out.println("You cannot stack up a element! The stack is full");
        } else{
            this.top ++;
            this.array[top] = element;
            System.out.println("Element was successfully stacked");
        }
    }
    
    void pop(){
        Object unstacked = null;
        if (isEmpty()){
            System.out.println("The stack is already empty");
        } else{
            unstacked = this.array[top];
            this.array[top] = null;
            top--;
            System.out.println("Element unstacked " + unstacked);
        }
    }
    
    public Object topElement(){
        if(isEmpty()){
            return null;
        } else{
            return this.array[top];
        }
    }
    
    public void stackPrint(){
        for (int c = 0; c < this.length; c++){
            System.out.println( this.array[c]);
        }
    }    
}
