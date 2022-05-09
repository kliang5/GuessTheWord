////Name: Kexin Nicole Liang
//Student Number:  260828103

// do NOT touch the following import statement
import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
    
    private static final String[] words = {"perfect", "country", "pumpkin", "special", "freedom", "picture", "husband", 
        "monster", "seventy", "nothing", "sixteen", "morning", "journey", "history", "amazing", "dolphin", "teacher", 
        "forever", "kitchen", "holiday", "welcome", "diamond", "courage", "silence", "someone", "science", "revenge", 
        "harmony", "problem","awesome", "penguin", "youtube", "blanket", "musical", "thirteen", "princess", "assonant", 
        "thousand", "language", "chipotle", "business", "favorite", "elephant", "children", "birthday", "mountain", 
        "football", "kindness", "abdicate", "treasure", "strength", "together", "memories", "darkness", "sandwich", 
        "calendar", "marriage", "building", "function", "squirrel", "tomorrow", "champion", "sentence", "daughter", 
        "hospital", "identical", "chocolate", "beautiful", "happiness", "challenge", "celebrate", "adventure", 
        "important", "consonant", "dangerous", "irregular", "something", "knowledge", "pollution", "wrestling", 
        "pineapple", "adjective", "secretary", "ambulance", "alligator", "congruent", "community", "different", 
        "vegetable", "influence", "structure", "invisible", "wonderful", "nutrition", "crocodile", "education", 
        "beginning", "everything", "basketball", "weathering", "characters", "literature", "perfection", "volleyball", 
        "homecoming", "technology", "maleficent", "watermelon", "appreciate", "relaxation", "abominable", "government", 
        "strawberry", "retirement", "television", "silhouette", "friendship", "loneliness", "punishment", "university", 
        "confidence", "restaurant", "abstinence", "blackboard", "discipline", "helicopter", "generation", "skateboard", 
        "understand", "leadership", "revolution"};  
    
    // this method takes an integer as input and returns a radom String from the array above. 
    // you can use it, but do NOT modified neither the method NOR the above array. 
    public static String getRandomWord(int seed) {
        Random gen = new Random(seed);
        int randomIndex = gen.nextInt(words.length);
        return words[randomIndex];
    }
    
    // a method that takes a char as an input 
    //and returns true if it is a lower case English letter
    //and returns false otherwise
    public static boolean isValidGuess(char a) {
    	//use if statement to check whether the input is a lower case English letter
    	if(a=='a'||a=='b'||a=='c'||a=='d'||a=='e'||a=='f'||a=='g'||a=='h'
    			||a=='i'||a=='j'||a=='k'||a=='l'||a=='m'||a=='n'||a=='o'||a=='p'
    			||a=='q'||a=='r'||a=='s'||a=='t'||a=='u'||a=='v'||a=='w'||a=='x'||a=='y'||a=='z') {
    		return true;
    	}else {
    		return false;
    	}    	
    } 
    
    // a method that takes a String as input and 
    //returns an array of integers with the size of the number of the elements in the String provided 
    public static int[] generateArrayOfGuesses(String word) {
    	//create an array
    	int[] guess=new int [word.length()];
    	//initialize the array
    	for(int i=0;i<guess.length;i++) {
    		guess[i]=0;
    	}
    	return guess;
    }
    
    //a method that takes a String (represents the secret word to be guessed), 
    //an array of integer (represents the guess made by player) and a char(represents player's last guess)
    //and returns true if the char guessed is in the secret word 
    //and update the array by assigning the value 1 to the element with the same position as the char in secret word
    public static boolean checkAndUpdate(String word, int[]guess, char last) {
    	int trueOrFalse=0;
    	//check whether the char is in the secret word
    	// and update the array
    	for(int i=0; i< word.length();i++) {
    		if(word.charAt(i)==last) {
    			guess[i]=1;
    			trueOrFalse=1;
    		}
    	}
    	// returns boolean after all the elements are checked
    	if(trueOrFalse==1) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    //a method that takes a String (represents the secret word to be guessed), 
    //an array of integer (represents the guess made by player) and a char(represents player's last guess)
    // and returns a String represents the sequence of characters the players can see after the last guess
    public static String getWordToDisplay(String word, int[]guess, char last) {
    	String see="";
    	
    	 //use for loops to check all characters in the secret word 
    	//if it matches with the last guess, replace by same letter upper case
    	//if it has been previously guessed, keep the same
    	//if it has not been guessed yet, replace by'-'   	
    	for(int i=0; i< word.length(); i++) {
    		if(word.charAt(i)==last) {
    			see=see+(""+word.charAt(i)).toUpperCase();
    		}else if(guess[i]==1){
    			see=see+word.charAt(i);
    		}else {
    			see+='-';
    		}
    	}
    	return see;
    	}
    
    //a method that takes an array of integer represents the guesses
    //and returns true if all elements are equal to 1(all guessed)
    //and false otherwise
    public static boolean isWordGuessed(int[]guess) {
    	int guessedNumber=0;
    	//use for loops to check whether all elements are equal to 1
    	for(int i=0;i<guess.length;i++) {
    		if(guess[i]==1) {
    			guessedNumber++;
    		}
    	}
    	if(guessedNumber==guess.length) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    //a method that takes an integer as input and
    //stimulates the game of "Guess the word!"
    public static void play(int begin) {
    	//generate a random secret word to be guessed using getRandomWord method
    	String secretWord=getRandomWord(begin);
    	//generate the corresponding array using generateArrayOfGuesses method
    	int[]toBeGuessed=generateArrayOfGuesses(secretWord);
    	Scanner read= new Scanner(System.in);
    	
        //display a welcome message and show the length of the word players should guess
    	//and show the player's total lives(10) to guess the entire word 
    	System.out.println("Welcome to \"Guess the Word!\" ");
    	int lives=10;
    	System.out.println("You secret word has been generated. It has "+secretWord.length()+" characters."
    			+ "You have "+lives+" lives. Good luck!");
    	System.out.println();
    	
    	//the game begins
    	//use while loops and isWordGuessed method to display the circulation 
    	//until all the characters have been guessed
    	 
    	while(!isWordGuessed(toBeGuessed)) {
    		//display the current number of lives and asking for the next guess 
    	System.out.println("You have "+ lives+" lives left. Please enter a character:");
    	//read the player's guess(input) using Scanner
    	String last=read.nextLine();
    	
    	//use if statement to check whether the guess has only one single character 
    	if(last.length()!=1) {
    		System.out.println("You can only enter one single character. Try again!");
    		System.out.println();
    		continue;
    	}
    	//use if statement and isValidGuess method to check whether 
    	//the guess is valid(a lower case English alphabet)
    	if(!isValidGuess(last.charAt(0))) {
    		System.out.println("The character must be a lower case letter of the English alphabet. Try again!");
    		System.out.println();
    		continue;
    	}
    	
    	//use if statement and checkAndUpdate method to check 
    	//whether the guess is correct and update the array
    	//if the guess is not correct, loose one life
    	if(checkAndUpdate(secretWord,toBeGuessed,last.charAt(0))) {	
    		System.out.println("Good job! The secret word contains the character \'"+last.charAt(0)+"\'");
    	}else {
    		lives--;
    		System.out.println("There's no such character. Try again!");
    	}
    	//using getWordToDisplay method to display the current string 
    	//containing all the characters have been guessed
    	System.out.println(getWordToDisplay(secretWord,toBeGuessed,last.charAt(0)));
    	System.out.println();
    	
    	//use if statement to check whether the lives has left
    	//if the lives is 0, end the loop and display the message
    	if(lives==0) {
    		System.out.println("You have no lives left, better luck next time! The secret word was: \""+secretWord+"\"");
    		break;
    	}
    	
    	}
    	//use if statement to check if all the characters have been guessed successfully
    	//display the congratulation message
    	if(isWordGuessed(toBeGuessed)) {
    		System.out.println("Congratulations you guessed the secret word!");
    	}
    	read.close();
    } 
    	 
    
    public static void main(String[] args) {
    	//check the written methods whether work
    	//int[]num= {1,1,1,1,1,1,1,0,1};
    	//System.out.println(getWordToDisplay("pineapple",num,'t'));
        //System.out.println(getWordToDisplay("pineapple",num,'i'));
        //System.out.println(getWordToDisplay("pineapple",num,'p'));
        //System.out.println(getWordToDisplay("pineapple",num,'e'));
    	//for(int i=0; i<num.length;i++) {
	    //System.out.print(num[i]);
		//}
    	//System.out.println(isWordGuessed(num));
    	
    	//display the info:
    	play(56);
    	
    	 
         
    }
       
}
