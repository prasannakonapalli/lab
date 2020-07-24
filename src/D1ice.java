import java.util.Scanner;

public class D1ice {
	static int dice1;
	static int dice2;
	static String con;
	static int diceTotal;
	static int numberOfRolls = 1;

	public static void main(String[] args) {
		System.out.println("Welcome to the Grand Circus Casino");
		System.out.println();

		rollTheDice();
	}

	// Rooll the dice
	public static void rollTheDice() {

		// int numberOfRolls = 1;
		Scanner scr = new Scanner(System.in);
		try {

			do {

				System.out.println("How many sides should each die have: ");
				int sides = scr.nextInt();

				if (sides > 1 && sides <= 6) {
					System.out.println("Roll " + numberOfRolls + ":");
					numberOfRolls += 1;

					System.out.println(generateRandomDieRoll(sides));

					displayMessage();
				} else {
					throw new Exception();
				}

				System.out.println("Roll again (y/n)?");
				con = scr.next();
				if (con.equalsIgnoreCase("y")) {
					rollTheDice();
				} else if (con.equalsIgnoreCase("n")) {
					// break;
					System.exit(0);

				} else {
					throw new Exception();
				}

			} while (doYouWantToContinue());

		} catch (Exception e) {
			System.out.println("****************************************");
			System.out.println("invalid input");
		}
		// scr.close();

	}

// satic method - generateRandomDieRoll
	public static String generateRandomDieRoll(int sides) {
		dice1 = (int) (Math.random() * sides + 1);
		dice2 = (int) (Math.random() * sides + 1);

		return dice1 + "\n" + dice2;
	}

// challenge
	public static void displayMessage() {

		/*
		 * if ((dice1 == 2) && (dice2 == 5)) System.out.println("Craps!"); else if
		 * ((dice1 == 6) && (dice2 == 6)) System.out.println("Box cars!"); else if
		 * ((dice1 == 1) && (dice2 == 1)) System.out.println("Snake eyes!");
		 */
		diceTotal = dice1 + dice2;

		if (diceTotal == 12) {
			System.out.println("Box cars!");
			System.out.println("craps!");
		} else if (diceTotal == 2) {
			System.out.println("Snake eyes!");
			System.out.println("craps!");
		} else if (diceTotal == 3) {
			System.out.println("Craps!");

		}
	}

// doYouWantToContinue
	public static boolean doYouWantToContinue() {
		if (con.equalsIgnoreCase("y") || con.equalsIgnoreCase("n")) {
			return true;
		}
		return false;
	}

}
