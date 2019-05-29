package com.bayviewglen.zork;

import java.util.Scanner;

public class Guards {
	private String guard1Response[] = {" A higher ranking guard, mind yourself", "Help, i woke up here and can't get out", "Back off, before i deal with you", ""};
	private String guard2Response[] = {" No one" ,"You must help me, i have to leave this freak house"," How can you speak, you're made out of stone", ""};
	private String guard3Response[] = {" Who's house is this, and why is it so big", "I'm getting seriously tired of you people", "I am not criminal scum, i just want to get out of here", ""};
	private String guard4Response[] = {" I am one step away from the exit, just let me go"," You wanted me so bad, well here i am" ," I am so tired of you annoying freak men, just move out of my way or i'll have to move you", ""};
	private String guard1Anwser[] = {" Guard: blasphemous animal, who do you think you are trying to trick me", " Guard: Prepare to die", " Guard: Dirty rat, prepare to meet your fate", "Must've been a mouse"};
    private String guard2Anwser[] = {" Guard: You fancy yourself funny? Prepare to meet your fate", " Guard: I do not have to help anyone, you are a trespasser on private property and will be dealt with now",  " Guard: You pay attention to irrelevant things criminal, prepare to meet your maker", " Guard: Must've been the wind"};
    private String guard3Anwser[] = {" Guard: You are in Vlad's house, and it is large in size due to Vlad's family's fortune that has lasted thousands of years. Now, you will be the latest edition to his guardians",  " Guard: Well you dirty little animal, as it seems, i am tired of you trespassers as well",  " Guard: Then you shouldn't have trespassed  into this house in the first place", "Must be losing my mind, always hearing these little noises"};
    private String guard4Anwser[] = {" Guard: Petty little thief, trying to squirm your way through, this might have worked on others but won't work on me" , " Guard: Yes, i see that, and you will meet your maker shortly",  " Guard: I'll cut your tongue for speaking so sharp at me",  " Guard: Need my ears checked, all these little noises i keep hear"};
    private String currentGuardResponse[];
	private String currentGuardAnswer[];
	private String guardDialogue[] = {"\nGuard: Who goes there", "\nGuard: What's that, who walks there, speak at once", "\nGuard: Stop right there criminal scum", " \nGuard: Well Well, look who it is"};
	private int guard;
	public Guards(int g) {
		guard = g;
		if(g==1) {
			currentGuardResponse = guard1Response;
			currentGuardAnswer = guard1Anwser;
		} 
		else if(g==2) {
		currentGuardResponse = guard2Response;
		currentGuardAnswer = guard2Anwser;
		}
		else if(g==3) {
		currentGuardResponse = guard3Response;
		currentGuardAnswer = guard3Anwser;
		}
		else if(g==4) {
		currentGuardResponse = guard4Response;
		currentGuardAnswer = guard4Anwser;
		}
				
	}
	
	public boolean start(int g) {
		System.out.print(guardDialogue[g-1] + "\nResponse A)" + currentGuardResponse[0] + "\nResponse B ) " + currentGuardResponse[1] + "\nResponse C ) " + currentGuardResponse[2] + "\nResponse D ) " + currentGuardResponse[3]);
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		int resp = -1;
		
		if (response.equals("A")) {
			System.out.println(currentGuardAnswer[0]);
			return true;
		}else if (response.equals("B")) {
			System.out.println(currentGuardAnswer[1]);
			return true;
		}else if (response.equals("C")) {
			System.out.println(currentGuardAnswer[2]);
			return true;
		}else if (response.equals("D")) {
			System.out.println(currentGuardAnswer[3]);
			return false;
		}
		/*
		for(int i = 0; i < currentGuardResponse.length-1; i++) {
			if(currentGuardResponse[i].startsWith(response)) {
				System.out.println(currentGuardAnswer[i]);
				resp = i;
				break;
			}
		}
		*/
		if(guard == 4) {
			return true;
		}
		else if(resp != -1)
			return resp < 3;
		else 
			return false;
		
	}
}