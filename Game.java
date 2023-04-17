/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author gabri
 */
public class Game{
    User playerOne;
    User playerCpu; //= new User("CPU");
    List <BasketballCards> playerOneDeck; //= new ArrayList();
    List <BasketballCards> playerCpuDeck; //= new ArrayList();
    Random random;// = new Random();
    Queue winnerCard;// = new Queue(6);
    Stack winnerPlayer;// = new Stack(6);

    public Game() {
        this.playerCpu = new User("CPU");
        this.playerOneDeck = new ArrayList();
        this.playerCpuDeck = new ArrayList();
        this.random = new Random();
        this.winnerCard = new Queue(5);
        this.winnerPlayer = new Stack(5);
    }
    
  
   
    void shuffleCards(){
//        System.out.println("shuffling the deck...");
        List <BasketballCards> shuffleDeck = new ArrayList(4);
        BasketballCards curry= new BasketballCards("Stephen Curry", 99, 98, 64, 99,85);
        BasketballCards lebron= new BasketballCards("Lebron James", 93, 97,99,94, 97);
        BasketballCards durant= new BasketballCards("Kevin Durant", 99, 98,95,95, 90);
        BasketballCards luka= new BasketballCards("Luka Doncic", 95, 95, 93, 95, 88);
        BasketballCards giannis= new BasketballCards("Giannis Antetokounmpo", 84, 97, 97, 92, 92);
        BasketballCards kawai= new BasketballCards("Kawai Leonard", 95, 94, 97, 94, 98);
        shuffleDeck.add(curry);
        shuffleDeck.add(lebron);
        shuffleDeck.add(durant);
        shuffleDeck.add(luka);
        shuffleDeck.add(giannis);
        shuffleDeck.add(kawai);

        // Shuffling the ArrayList Elements
        Collections.shuffle(shuffleDeck);
        playerOneDeck.add(shuffleDeck.get(0));
        playerOneDeck.add(shuffleDeck.get(1));
        playerOneDeck.add(shuffleDeck.get(2));
        playerCpuDeck.add(shuffleDeck.get(3));
        playerCpuDeck.add(shuffleDeck.get(4));
        playerCpuDeck.add(shuffleDeck.get(5));
    }
    
    void start() throws InterruptedException{
        Scanner inp = new Scanner(System.in);
        System.out.println( "Welcome to the basketball version of the Super Mega Awesome card game!");
        System.out.println("To get started please tell us your name: ");
        String input = inp.nextLine();
        this.playerOne = new User(input);
        System.out.println("Thank you for your company "+ input + "!");
        System.out.println("Now it's time to shuffle the cards ");
        Thread.sleep(1000);
        System.out.println("");
        System.out.println("Shuffling the cards...");
    }
    
    void battle() throws InterruptedException{
        while(true){
            //Stop condition
            if(playerOneDeck.isEmpty() && this.playerCpuDeck.isEmpty()){
                System.out.println(" ");
                System.out.println("Error! You must Shuffle the deck and ask for the cards before starting the battle. Try again.");
                System.exit(0);
                break;
            }else if(this.playerOneDeck.isEmpty()){
                Thread.sleep(1000);
                System.out.println(" ");
                System.out.println("CPU won!");
                System.out.println("Game over");
                System.out.println(" ");
                Thread.sleep(1500);
                System.out.println(this.playerOne.toString());
                System.out.println(this.playerCpu.toString());
                Thread.sleep(1500);
                System.out.println(" ");
                System.out.println("Round Winners(Cards): ");
                this.winnerCard.printQueue();
                System.out.println(" ");
                Thread.sleep(1500);
                System.out.println("Round Winners(Players): ");
                this.winnerPlayer.stackPrint();
                break;
            } else if(this.playerCpuDeck.isEmpty()){
                System.out.println(" ");
                Thread.sleep(1000);
                System.out.println("You won!");
                System.out.println("CPU defeated!");
                System.out.println(" ");
                Thread.sleep(1500);
                System.out.println(this.playerOne.toString());
                System.out.println(this.playerCpu.toString());
                System.out.println(" ");
                Thread.sleep(1500);
                System.out.println("Round winners(Cards): ");
                this.winnerCard.printQueue();
                System.out.println("");
                Thread.sleep(1500);
                System.out.println("Round Winners(Players): ");
                this.winnerPlayer.stackPrint();
                break;
            } else{
                try{
                Scanner input = new Scanner(System.in);
                //Printing player's deck
                System.out.println(" ");
                Thread.sleep(1000);
                System.out.println("Your cards are: ");
                for (int c = 0; c < this.playerOneDeck.size(); c++){
                    System.out.println(this.playerOneDeck.get(c));
                    System.out.println(" ");
                    Thread.sleep(1000);
                }
                System.out.println("The card on the line is: ");
                System.out.println(this.playerOneDeck.get(0));
                System.out.println("");
                //First menu
                Thread.sleep(1000);
                System.out.println("Now it's time to choose the attribute of the card that you want to compare with your opponent's one.");
                System.out.println("Press [0] for Shot");
                System.out.println("Press [1] for Layup");
                System.out.println("Press [2] for Dunk");
                System.out.println("Press [3] for Handles");
                System.out.println("Press [4] for defense");
                System.out.println("Your answer: ");
                int playerInputAttribute = input.nextInt();              
                //Switch case
               
                        if(playerInputAttribute == 0){
                            int w = random.nextInt(this.playerCpuDeck.size());
                            if(this.playerOneDeck.get(0).getShot() > this.playerCpuDeck.get(w).getShot()){
                                Thread.sleep(1000);
                                System.out.println(this.playerOneDeck.get(0));
                                System.out.println("      VS");
                                Thread.sleep(1000);
                                System.out.println(this.playerCpuDeck.get(w));
                                System.out.println(" ");
                                Thread.sleep(2000);
                                System.out.println("Round winner = " + this.playerOne.getName() + " congratulations!");
                                System.out.println("Round loser = " + this.playerCpu.getName());
                                System.out.println("Cpu = -1 Card");
                                this.playerOne.wins++; 
                                this.playerCpu.losses++;
                                this.winnerCard.add(playerOneDeck.get(0).getName());
                                this.winnerPlayer.push(playerOne.getName());
                                playerCpuDeck.remove(w);                            
                            } else if(this.playerOneDeck.get(0).getShot() < this.playerCpuDeck.get(w).getShot()){
                                Thread.sleep(1000);
                                System.out.println(this.playerOneDeck.get(0));
                                System.out.println("      VS");
                                Thread.sleep(1000);
                                System.out.println(this.playerCpuDeck.get(w));
                                System.out.println(" ");
                                Thread.sleep(2000);
                                System.out.println("Round winner = " + this.playerCpu.getName());
                                System.out.println("Round loser = " + this.playerOne.getName());
                                System.out.println(this.playerOne.getName() + " = -1 Card");
                                this.playerOne.losses++;
                                this.playerCpu.wins++;
                                this.winnerCard.add(playerCpuDeck.get(w).getName());
                                this.winnerPlayer.push(this.playerCpu.getName());
                                playerOneDeck.remove(0);
                            } else{
                                System.out.println(this.playerOneDeck.get(0));
                                System.out.println("      VS");
                                System.out.println(this.playerCpuDeck.get(w));
                                System.out.println(" ");
                                System.out.println("Draw!");
                            }
                        } else if(playerInputAttribute == 1){
                            int w = random.nextInt(this.playerCpuDeck.size());
                            if(this.playerOneDeck.get(0).getLayup() > this.playerCpuDeck.get(w).getLayup()){
                                Thread.sleep(1000);
                                System.out.println(this.playerOneDeck.get(0));
                                System.out.println("      VS");
                                Thread.sleep(1000);
                                System.out.println(this.playerCpuDeck.get(w));
                                System.out.println(" ");
                                Thread.sleep(2000);
                                System.out.println("Round winner = " + this.playerOne.getName() + " congratulations!");
                                System.out.println("Round loser = " + this.playerCpu.getName());
                                System.out.println("Cpu = -1 Card");
                                this.playerOne.wins++; 
                                this.playerCpu.losses++;
                                this.winnerCard.add(playerOneDeck.get(0).getName());
                                this.winnerPlayer.push(playerOne.getName());
                                playerCpuDeck.remove(w);                            
                            } else if(this.playerOneDeck.get(0).getLayup() < this.playerCpuDeck.get(w).getLayup()){
                                Thread.sleep(1000);
                                System.out.println(this.playerOneDeck.get(0));
                                System.out.println("      VS");
                                Thread.sleep(1000);
                                System.out.println(this.playerCpuDeck.get(w));
                                System.out.println(" ");
                                Thread.sleep(2000);
                                System.out.println("Round winner = " + this.playerCpu.getName());
                                System.out.println("Round loser = " + this.playerOne.getName());
                                System.out.println(this.playerOne.getName() + " = -1 Card");
                                this.playerOne.losses++;
                                this.playerCpu.wins++;
                                this.winnerCard.add(playerCpuDeck.get(w).getName());
                                this.winnerPlayer.push(this.playerCpu.getName());
                                playerOneDeck.remove(0);
                            } else{
                                System.out.println(this.playerOneDeck.get(0));
                                Thread.sleep(1000);
                                System.out.println("      VS");
                                Thread.sleep(1000);
                                System.out.println(this.playerCpuDeck.get(w));
                                System.out.println(" ");
                                Thread.sleep(2000);
                                System.out.println("Draw!");
                            }
                        } else if (playerInputAttribute == 2){
                            int w = random.nextInt(this.playerCpuDeck.size());
                            if(this.playerOneDeck.get(0).getDunk() > this.playerCpuDeck.get(w).getDunk()){
                                Thread.sleep(1000);
                                System.out.println(this.playerOneDeck.get(0));
                                System.out.println("      VS");
                                Thread.sleep(1000);
                                System.out.println(this.playerCpuDeck.get(w));
                                System.out.println(" ");
                                Thread.sleep(2000);
                                System.out.println("Round winner = " + this.playerOne.getName() + " congratulations!");
                                System.out.println("Round loser = " + this.playerCpu.getName());
                                System.out.println("Cpu = -1 Card");
                                this.playerOne.wins++; 
                                this.playerCpu.losses++;
                                this.winnerCard.add(playerOneDeck.get(0).getName());
                                this.winnerPlayer.push(playerOne.getName());
                                playerCpuDeck.remove(w);                            
                            } else if(this.playerOneDeck.get(0).getDunk() < this.playerCpuDeck.get(w).getDunk()){
                                Thread.sleep(1000);
                                System.out.println(this.playerOneDeck.get(0));
                                System.out.println("      VS");
                                Thread.sleep(1000);
                                System.out.println(this.playerCpuDeck.get(w));
                                System.out.println(" ");
                                Thread.sleep(2000);
                                System.out.println("Round winner = " + this.playerCpu.getName());
                                System.out.println("Round loser = " + this.playerOne.getName());
                                System.out.println(this.playerOne.getName() + " = -1 Card");
                                this.playerOne.losses++;
                                this.playerCpu.wins++;
                                this.winnerCard.add(playerCpuDeck.get(w).getName());
                                this.winnerPlayer.push(this.playerCpu.getName());
                                playerOneDeck.remove(0);
                            } else{
                                Thread.sleep(1000);
                                System.out.println(this.playerOneDeck.get(0));
                                System.out.println("      VS");
                                Thread.sleep(1000);
                                System.out.println(this.playerCpuDeck.get(w));
                                System.out.println(" ");
                                Thread.sleep(2000);
                                System.out.println("Draw!");}
                        } else if(playerInputAttribute == 3){
                                int w = random.nextInt(this.playerCpuDeck.size());
                            if(this.playerOneDeck.get(0).getHandles() > this.playerCpuDeck.get(w).getHandles()){
                                Thread.sleep(1000);
                                System.out.println(this.playerOneDeck.get(0));
                                System.out.println("      VS");
                                Thread.sleep(1000);
                                System.out.println(this.playerCpuDeck.get(w));
                                System.out.println(" ");
                                Thread.sleep(2000);
                                System.out.println("Round winner = " + this.playerOne.getName() + " congratulations!");
                                System.out.println("Round loser = " + this.playerCpu.getName());
                                System.out.println("Cpu = -1 Card");
                                this.playerOne.wins++; 
                                this.playerCpu.losses++;
                                this.winnerCard.add(playerOneDeck.get(0).getName());
                                this.winnerPlayer.push(playerOne.getName());
                                playerCpuDeck.remove(w);                            
                            } else if(this.playerOneDeck.get(0).getHandles() < this.playerCpuDeck.get(w).getHandles()){
                                Thread.sleep(1000);
                                System.out.println(this.playerOneDeck.get(0));
                                System.out.println("      VS");
                                Thread.sleep(1000);
                                System.out.println(this.playerCpuDeck.get(w));
                                System.out.println(" ");
                                Thread.sleep(2000);
                                System.out.println("Round winner = " + this.playerCpu.getName());
                                System.out.println("Round loser = " + this.playerOne.getName());
                                System.out.println(this.playerOne.getName() + " = -1 Card");
                                this.playerOne.losses++;
                                this.playerCpu.wins++;
                                this.winnerCard.add(playerCpuDeck.get(w).getName());
                                this.winnerPlayer.push(this.playerCpu.getName());
                                playerOneDeck.remove(0);
                            } else{
                                Thread.sleep(1000);
                                System.out.println(this.playerOneDeck.get(0));
                                System.out.println("      VS");
                                Thread.sleep(1000);
                                System.out.println(this.playerCpuDeck.get(w));
                                System.out.println(" ");
                                Thread.sleep(2000);
                                System.out.println("Draw!");}
                                }
                        else if(playerInputAttribute == 4){
                            int w = random.nextInt(this.playerCpuDeck.size());
                            if(this.playerOneDeck.get(0).getDefense() > this.playerCpuDeck.get(w).getDefense()){
                                Thread.sleep(1000);
                                System.out.println(this.playerOneDeck.get(0));
                                System.out.println("      VS");
                                Thread.sleep(1000);
                                System.out.println(this.playerCpuDeck.get(w));
                                System.out.println(" ");
                                Thread.sleep(2000);
                                System.out.println("Round winner = " + this.playerOne.getName() + " congratulations!");
                                System.out.println("Round loser = " + this.playerCpu.getName());
                                System.out.println("Cpu = -1 Card");
                                this.playerOne.wins++; 
                                this.playerCpu.losses++;
                                this.winnerCard.add(playerOneDeck.get(0).getName());
                                this.winnerPlayer.push(playerOne.getName());
                                playerCpuDeck.remove(w);                            
                            } else if(this.playerOneDeck.get(0).getDefense() < this.playerCpuDeck.get(w).getDefense()){
                                Thread.sleep(1000);
                                System.out.println(this.playerOneDeck.get(0));
                                System.out.println("      VS");
                                Thread.sleep(1000);
                                System.out.println(this.playerCpuDeck.get(w));
                                System.out.println(" ");
                                Thread.sleep(2000);
                                System.out.println("Round winner = " + this.playerCpu.getName());
                                System.out.println("Round loser = " + this.playerOne.getName());
                                System.out.println(this.playerOne.getName() + " = -1 Card");
                                this.playerOne.losses++;
                                this.playerCpu.wins++;
                                this.winnerCard.add(playerCpuDeck.get(w).getName());
                                this.winnerPlayer.push(this.playerCpu.getName());
                                playerOneDeck.remove(0);
                            } else{
                                Thread.sleep(1000);
                                System.out.println(this.playerOneDeck.get(0));
                                System.out.println("      VS");
                                Thread.sleep(1000);
                                System.out.println(this.playerCpuDeck.get(w));
                                System.out.println(" ");
                                Thread.sleep(2000);
                                System.out.println("Draw!");}
                        }
                        else{
                            System.out.println("Error! You must enter an integer number from 0 to 4.Try again.");
                         
                        
                    };
                    }catch(InputMismatchException e){
                        System.out.println("Error! You must enter an integer number from 0 to 4. Try again.");

                    }
                }
                
          
            }
        }
    }
