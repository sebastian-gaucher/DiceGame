import java.util.Random;
import java.util.Scanner;

public class DiceGame {
	private static String[][] Language;
	private static int Lang = 0;
	public static void main(String[] args) {
		int die1;
		int die2;
		String[] playerChoices;
		Language = initLang();
		String LangChoice = getInput("enter language:\n[0]English\n[1]Hawaiian pidgen\n[2]Chinese");
		Lang = Integer.parseInt(LangChoice);
		die1 = roll();
		die2 = roll();
		String choice;
		choice = getInput(Language[Lang][0]);
		choice = choice.toLowerCase();
		int count = 0;
		String playerCount = getInput(Language[Lang][1]);
		count = Integer.parseInt(playerCount);
		playerChoices = new String[count];
		while(choice.equals(Language[Lang][2])) {
			
			for(int c= 0; c < count; c++) {
			playerChoices[c] = getInput(Language[Lang][3]+(c+1)+Language[Lang][4]);
			
			}
			System.out.println(Language[Lang][5]+die1+Language[Lang][6]+die2);
			//Start a new loop here.
			for(int c=0; c<count;c++) {
				if(didIWin(die1,die2,playerChoices[c]))
				{
					System.out.println(Language[Lang][7]+(c+1)+Language[Lang][8]);
				}else
				{
					System.out.println(Language[Lang][9]+(c+1)+Language[Lang][10]);
				}
			}
			
			choice = getInput(Language[Lang][11]);
			choice = choice.toLowerCase();
			die1 = roll();
			die2 = roll();
		}
	}
	private static boolean didIWin(int die1, int die2, String choice)
	{
		if (choice.equals("0") && (die1 + die2) %2== 0 ) 
		{
			return true;
		}else if (choice.equals("1") && (die1 + die2) %2 == 1) 
		{
			return true;
		}
		
		return false;
	}
	
	
	private static int roll()
	{
		return roll(6,1);
	}
	private static int roll(int sides,int start) {
		Random roller = new Random();
		return roller.nextInt(sides)+start;
	}
	private static String getInput(String text) {
		Scanner input = new Scanner(System.in);
		String choice = "";
		try 
		{
			System.out.println(text);
			choice = input.nextLine();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return choice;
	}
	private static String [][] initLang(){
		String [][] temp = new String[][]{
			{"Do you want to play?\nYes\nNo","How many players are there?",
			"yes","Player ",": \n[0] Even\n[1] Odd",
			"Die 1: ","\nDie 2: ","Player "," wins!","Player ",
			" loses!","Do you want to play?\nYes\nNo"	},
			
			{"you like try?\nYessah\nNo","how many buggahs?",
			"yessah","buggah ",": \n[0] Even\n[1] Odd",
			"Die 1: ","\nDie 2: ","buggah "," winnah!","buggah ",
			" no need win!","you like try again?\nYessah\nNo"}
		};
		return temp;
	}
	private static boolean isInputInteger(String input) {
		boolean isAnInteger = true;
		for(int c = 0; c < input.length();c++) {
			char letter = input.charAt(c);
			//'-' is 45 '0 - 9' 48 - 57
			if(c!=0 &&!(letter >= 48 && letter<= 57))
			{
				isAnInteger = false;
			}else if(letter != 45 && !(letter >= 48 && letter <= 57))
			{
				isAnInteger = false;
			}
		}
		return isAnInteger;
	}
}
