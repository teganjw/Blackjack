import java.util.*;

public class Deck {

    boolean gameOnPlayer = true;
    boolean gameOnDealer = true;

    Card[] deck = new Card[52];
    String[] types = new String[]{"jack", "queen", "king"};

    public Deck(){
            makeDeck();
    }

    public void makeDeck(){
        int counter = 0;
        String name;
        int value;

        for(int i = 1; i<5; i++) {
            for (int j = 1; j < 14; j++) {

                if(j==1){
                    name = "ace";
                    value = 11;
                }
                else if(j>=11){
                    name = types[j-11];
                    value = 10;
                }
                else {
                    name = Integer.toString(j);
                    value = j;
                }

                deck[counter] = new Card(name,value);
                counter++;
            }
        }


    }

    public void shuffle() {
        Collections.shuffle(Arrays.asList(this.deck));
    }

    int count = 0;

    public Card hit(){
        count++;
        return deck[count-1];
    }


}
