package com.bayviewglen.zork;

import java.util.Scanner;

public class Vampire {

	private String vampireDialouge[] = {
			"Hsssss, you see a black figure jump out and scratch at you, it lands on the ground and shows it's fangs" };
	String [] vampire = {"Vampire"};
	private int vampireHealth = 70;
	private int vampireDamage = 30;
	private int damage;
	private int yourHealth = 100;
	private int numHealthPotions;
	private int healthPotionHealAmount = 30;
	private String yourResponse[] = { " Yes ", " No" };
	private String[] currentPlayAgain;
	private Scanner in;
	public void Vampire(boolean w, boolean f, String guard, Boolean isAttacked) {
		
		if (w) {
			damage = 50;
		} else if (f) {
			damage = 35;
		} else {
			damage = 15;
		}

	}

private void vampireAttacked(String[] vampire2, Boolean isAttacked) {
	in = new Scanner(System.in);
	vampireAttacked(vampire, isAttacked);		
	}

public void vampireAttacked(String Vampires) {
	System.out.println(Vampires + " attacks you for " + vampireDamage/* enemyDamageType(enemy) */ + " damage "
			+ "\nResponse A) Attack\nResponse B) Block\nResponse C) Drink Health Potion\nResponse D) Run Away");
	yourHealth -= vampireDamage;

	boolean runAway = false;
	while (!runAway && vampireHealth > 0 && yourHealth > 0) {
		String r = in.nextLine();
		if (r.equals("Attack")) {
			vampireHealth -= damage;
			System.out.println(
					"You dealt " + damage + " damage" + "," + " The enemy's health is now" + vampireHealth + ".");
			System.out.println("The enemy attacks you for " + vampireDamage + "damage");
			yourHealth -= vampireDamage;
		} else if (r.equals("Block")) {
			System.out.println("You blocked his attack");
			// nothing happens
		} else if (r.equals("Run Away")) {
			double run = Math.random();
			if (run < 0.51) {
				runAway = true;
			}

			else if (r.equals("Drink Health Potion")) {
				if (numHealthPotions > 0) {
					yourHealth += healthPotionHealAmount;
					numHealthPotions--;
					System.out.println("\t> You drink a health potion, healing yourself for "
							+ healthPotionHealAmount + "." + "\n\t> You now have " + yourHealth + "health left."
							+ "\n\t> You have" + numHealthPotions + "health potions left.\n");
				} else {
					System.out.println("\t> You have no health potions left");
				}
			}
		} else
			System.out.println(
					"\nResponse A) Attack\nResponse B) Block\nResponse C)Drink Health Potion\nResponse D) Run Away");

		if (!runAway && vampireHealth > 0 && yourHealth > 0) {
			double run = Math.random();
			if (run < 0.51) {
				System.out.println(Vampires + "They step right infront of you and attacks you"
						+ "\nResponse A) Attack\nResponse B) Block\nResponse C)Drink Health Potion\nResponse D) Run Away");
				yourHealth -= vampireDamage;
			} else {
				System.out.println(Vampires + " attacks you but misses"
						+ "\nResponse A) Attack\nResponse B) Block\nResponse C)Drink Health Potion\nResponse D) Run Away");
			}
		}
	}
}
	public boolean playerDead() {
		if (yourHealth <= 0) {
			System.out.println("You have died, would you like to play again?");
			currentPlayAgain = yourResponse;
			System.out.println(yourResponse[0] + "\nA) Yes" + currentPlayAgain[0] + "\nB) No");
			Scanner ok = new Scanner(System.in);
			String startNewGame = in.nextLine();
			int start = -1;

			if (startNewGame.equals("A")) {
				System.out.println(yourResponse[0]);
				Game g = new Game();
				g.play();
			} else if (startNewGame.equals("B")) {
				System.out.println(currentPlayAgain[1]);
				System.exit(0);
			}
			return false;
		}
		return false;
	}
}