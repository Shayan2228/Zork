package com.bayviewglen.zork;

import java.util.Scanner;

public class Fighting {
	//no weapon = 35 damage, weapon = 50 damage
	String [] enemies = {"Guards", "Vampires"};
	private int enemyHealth;
	private int vampireHealth = 70;
	private int guardHealth = 120;
	private int yourHealth = 100;
	private int damage;
	private int enemyDamage;
	private int vampireDamage = 30;
	private int guardDamage = 20;
	private int numHealthPotions;
	private int healthPotionHealAmount = 30;
	private Scanner in;
	public Fighting(boolean w,boolean f, String enemy) {
		if(w) { damage = 50; }
		else if (f) { damage = 35; }
		else {damage = 15;}
		in = new Scanner(System.in);
		attacked(enemy);
	}
	
	public void enemy (String [] enemies) {
		int x = (int)Math.random()*2;
		if (enemies[x].equals("Guards")) {
			enemyHealth = guardHealth;
			enemyDamage = guardDamage;
		}
		else {
			enemyHealth = vampireHealth;
			enemyDamage = vampireDamage;
		}
		
		
	}
	
	public void attacked(String enemy) {
		System.out.println(enemy + " attacks you for" + enemyDamage + "damage" + "\nResponse A) Attack\nResponse B) Block\nResponse C)Drink Health Potion\nResponse D) Run Away");
		yourHealth -= enemyDamage;
		
		boolean runAway = false;
		while(!runAway && enemyHealth > 0 && yourHealth > 0) {
			String r = in.nextLine();
			if(r.equals("Attack")) {
				enemyHealth -= damage;
				System.out.println("You dealt " + damage + " damage" + "," + " The enemy's health is now" + enemyHealth + ".");
				System.out.println("The enemy attacks you for " + enemyDamage + "damage" );
				yourHealth -= enemyDamage;
			}
			else if(r.equals("Block")) {
				System.out.println("You blocked his attack");
				// nothing happens
			}
			else if(r.equals("Run Away")) {
				double run = Math.random();
				if(run<0.51) {runAway=true;}
				
				else if (r.equals("Drink Health Potion")) {
					if (numHealthPotions > 0) {
						yourHealth += healthPotionHealAmount;	
						numHealthPotions--;
						System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount + "." 
						+ "\n\t> You now have " + yourHealth + "health left."
						+ "\n\t> You have" + numHealthPotions + "health potions left.\n");
					}
					else {
						System.out.println("\t> You have no health potions left");
					}
				}
			}
			else
				System.out.println("\nResponse A) Attack\nResponse B) Block\nResponse C)Drink Health Potion\nResponse D) Run Away");
		
			if (!runAway && enemyHealth > 0 && yourHealth > 0) {
				double run = Math.random();
				if(run<0.51) {
					System.out.println(enemy + "They step right infront of you and attacks you" + "\nResponse A) Attack\nResponse B) Block\nResponse C) Run Away");
					yourHealth -= enemyDamage;
				}else {
					System.out.println(enemy + " attacks you but misses" + "\nResponse A) Attack\nResponse B) Block\nResponse C) Run Away");
				
				}
			}
		}
	}
	public boolean enemyDead() {
		if(enemyHealth<=0) {
			System.out.println("You have killed the enemy!");
			return true;
		}
		return false;
	}
}
