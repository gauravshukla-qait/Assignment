import java.util.Scanner;

public class Dice {

	int sides;
	
	public Dice(int sides) {
		this.sides = sides;
	}
	
	public String onRolling() {
		Integer r = (int) (Math.random() * (sides)) + 1;
		if(sides == 2) {
			if(r == 1)
				return "heads";
			else
				return "tails";
		}
		return r.toString();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter the no of faces of dice: ");
		Scanner sc = new Scanner(System.in);
		int sides = sc.nextInt();
		if(sides <= 1)
			System.out.println("no of face cannot be less than 2. Try Again.");
		else {
			Dice dice  = new Dice(sides);
			System.out.println(dice.onRolling());

		}
	}

}
