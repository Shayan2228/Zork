package com.bayviewglen.zork;

import java.util.Scanner;

public class Fighting {
	//no weapon = 35 damage, weapon = 50 damage
	
	private int enemyHealth = 100;
	private int yourHealth = 100;
	private int damage;
	private int enemyDamage = 25;
	private Scanner in;
	public Fighting(boolean w,boolean f, String enemy) {
		if(w) { damage = 40; }
		else if (f) { damage = 20; }
		else {damage = 15;}
		in = new Scanner(System.in);
		attacked(enemy);
	}
	
	
	
	public void attacked(String enemy) {
		System.out.println(enemy + " attacks you for 10 damage" + "\nResponse A) Attack\nResponse B) Block\nResponse C) Run Away");
		yourHealth -= 10;
		
		boolean runAway = false;
		while(!runAway && enemyHealth > 0 && yourHealth > 0) {
			String r = in.nextLine();
			if(r.equals("Attack")) {
				System.out.println("You dealt " + damage + " damage");
				enemyHealth -= damage;
			}
			else if(r.equals("Block")) {
				// nothing happens
			}
			else if(r.equals("Run Away")) {
				double run = Math.random();
				if(run<0.51) {runAway=true;}
			}
			else
				System.out.println("Response A) Attack\nResponse B) Block\nResponse C) Run Away");
		
			if (!runAway && enemyHealth > 0 && yourHealth > 0) {
				double run = Math.random();
				if(run<0.51) {
					System.out.println(enemy + "They step right infront of you and attacks you" + "\nResponse A) Attack\nResponse B) Block\nResponse C) Run Away");
					yourHealth -= 25;
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
