import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.util.ElementScanner6;
/**
 * A deck of cards in order by suit(spades, hearts, clubs, diamonds)
 * and by rank within each suit, with the restriction that the cards
 * must be laid out face down in a row, and the only allowed 
 * operations are to check the values of two cards and swap by sorting
 * 
 * @author Nikhil ravi teja
 */
class Card {
    int face; // declaring face
    String suite; //declaring Suite

    //Constructor Card
    Card (int face, String suite){
        this.face = face;
        this.suite = suite;
    }

    //tostring Method
    public String toString() {
        return (this.suite +" "+ this.face);
    }

    //Compareto Method
    public int compareTo(Card card) {
        
        if(this.suite.compareTo(card.suite) > 0){
            return 1;
        }
        else if(this.suite.compareTo(card.suite) < 0){
            return -1;
        }
        else{
            if (this.face > card.face) {
                return 1;
            }
            else if (this.face < card.face) {
                return -1;
            }
            else return 0;
        }
    }

}

class Sorting {
    //Using Insertion Sort
    public Card[] insertionSort(Card[] arr) {
        Card temp;
        int j;
        for(int i = 1; i < arr.length; i++) {
            j = i-1;
            temp = arr[i];

            while(j >= 0 && arr[j].compareTo(temp) > 0) {
                arr[j+1] = arr[j];
                j = j-1;
            }

            arr[j+1] = temp;
        }
        return arr;
    }
}

public class CardDeck {
    // The main method
    public static void main(String[] args) {
        
        Card[] obj = new Card[52];
        int[] faceValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        String[] suiteValue = {"S", "H", "C", "D"};

        //Initializing size
        int size = 0;
        //Iterating for loops for mapping
        for (int i = 0; i < suiteValue.length; i++) {
            for (int j = 0; j < faceValue.length; j++) {
                obj[size++] = new Card(faceValue[j], suiteValue[i]);
            }
        }
        //Create obj to call sort
        Sorting sort = new Sorting();
        // System.out.println(Arrays.toString(obj));
        List<Card> cardDeck = Arrays.asList(obj);
        //TO shuffle the Array
        Collections.shuffle(cardDeck);
        //Printing CardDeck size after shuffling
        System.out.println("size : "+ cardDeck.size());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        //elements in correct order
        cardDeck.toArray(obj);
        //creating CA and inseting the sorted cards
        Card[] CA = sort.insertionSort(obj);
        System.out.println("After ISort : "+Arrays.toString(CA));
        //Creating new obj named aftersortCards
        Card[] afterSortCards = new Card[52];
        // initialising a size
        int nsize=0;
        
        System.out.println("================================================================================================================================");
        
        for (int a = 39; a < 52; a++) {
            afterSortCards[nsize++] = CA[a];
        }

        for (int b = 26; b < 39; b++) {
            afterSortCards[nsize++] = CA[b];
        }

        for (int c=0;c<13;c++){
            afterSortCards[nsize++] = CA[c];
        }

        for (int d=13;d<26;d++){
            afterSortCards[nsize++] = CA[d];
        }
        System.out.println("In a Sorted Order : "+Arrays.toString(afterSortCards));
    }
}
