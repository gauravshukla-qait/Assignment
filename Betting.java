import java.util.Scanner;

/*You are involved in a betting game whose rules are as follows :
a) if you win a round, the bet amount will be added to your sum and next bet amount will be $1;
b) if you lose a round, the bet amount will be reduced from your total sum and next bet will be twice the previous.
c) game ends when all the rounds are complete or you dont have sufficient sum.
Initially, you are given with a string of the form “WLWWL” where W indicates a win and L indicates a loss and initial sum. 
Initial bet amount will be $1.
You need to find the amount at the end of the game.
Function prototypes and main was given for both questions*/


public class Betting {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String result = scan.nextLine();
		int sum = scan.nextInt();
		int initialBetAmount = 1;
		int betAmount = initialBetAmount;
		int totalGames = result.length();
		
		for(int gameno = 0; gameno < totalGames; gameno++) {
			if(checkIfPlayerHaveSufficientMoney(sum, betAmount)) {
				char betResult = result.charAt(gameno);
				if(betResult == 'W') {
					sum += betAmount;
					betAmount = 1;
//					System.out.println(sum+" "+betAmount);
				}
				else {
					sum -= betAmount;
					betAmount *= 2;
//					System.out.println(sum+" "+betAmount);
				}
			}
			else
				break;
		}
		System.out.println(sum);
		scan.close();
	}

	private static boolean checkIfPlayerHaveSufficientMoney(int sum, int betAmount) {
		if(betAmount <= sum)
			return true;
		return false;
	}


}
