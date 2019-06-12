import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Deck d = new Deck();
        d.shuffle();

        Card dealerCard1 = d.hit();
        Card dealerCard2 = d.hit();
        System.out.println("Dealer is starting with a " +dealerCard1.name+ " and another card that you don't know.");
        int dealerPoints=dealerCard1.value+dealerCard2.value;


        Card card1 = d.hit();
        Card card2 = d.hit();
        int points= card1.value+card2.value;

        System.out.println("You are starting with a " +card1.name+ " and a " +card2.name + ". You have " + points+" points.");

        while(d.gameOnPlayer) {

            if((card1.value+card2.value)==21){
                System.out.println("You got blackjack! You Win!!");
                d.gameOnPlayer = false;
                break;
            }

            Scanner sc = new Scanner(System.in);
            System.out.println("Would you like to hit? (yes or no)");
            String selection = sc.nextLine();

            if (selection.equals("yes")) {
                Card current = d.hit();
                System.out.println("You got a " + current.name);
                points += current.value;
                System.out.println("You have " + points + " points now.");
            } else {
                System.out.println("You have chosen to remain at " + points + " points.");
                d.gameOnPlayer = false;
                break;
            }

            if(points>=21){

                if(points==21){
                    System.out.println("You Won!!!");
                }else{System.out.println("Aw you busted...");}
                d.gameOnPlayer=false;
                break;
            }

        }

        System.out.println("Dealer has a " +dealerCard1.name+ " and an unknown card.");

        while(d.gameOnDealer){

            if(points<=21 && (card1.value+card2.value)!=21){

                Card current = d.hit();
                dealerPoints+=current.value;

                if(dealerPoints<=17){
                    System.out.println("Dealer got a: " + current.name + ". They now have "+(dealerPoints-dealerCard2.value)+" visible points.");
                }else{
                    System.out.println("Dealer has decided not to hit");
                    d.gameOnDealer=false;
                    break;
                }
                if(dealerPoints>=21){
                    if(dealerPoints==21){
                        System.out.println("Dealer got 21. You lose:(");
                    }else{
                        System.out.println("Dealer busted! They have "+ dealerPoints+". You Win!");
                    }
                    d.gameOnDealer=false;
                    break;
                }

            }else{
                System.out.println("Dealer has won! They had " + dealerPoints + " points.");
                d.gameOnDealer=false;
                break;
            }

                System.out.println("You have " + points + " points. The dealer has " + dealerPoints + " points.");


        }

        if(dealerPoints<=21 && points<=21){
            if(dealerPoints>=points){
                System.out.println("Dealer has won!");
            }else{
                System.out.println("You won!!");
            }
        }


    }




}
