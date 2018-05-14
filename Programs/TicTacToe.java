package com.lokesh;

import java.util.Scanner;

public class TicTacToe {
	 class lokesh
	{
		
	}
	public static void main(String args[]) {
		//TicTacToe ttt = new TicTacToe();
		String ticTacToe[][] = new String[3][3];
		for (int row = 0; row < ticTacToe.length; row++) {
			for (int column = 0; column < ticTacToe.length; column++) {
				ticTacToe[row][column] = "" + row + column;
			}
		}
		boolean flag1=false,flag2=false,flag3=false;
		int player=0;
		
		System.out.println("Consider the below printed text as a 3X3 matrix with row and column numbers. For eg: If you type 00 it will be replaced by O or X based on the player");
		Scanner ipread = new Scanner(System.in);
		outer:
		do
		{		
		System.out.println("\nPlayer "+(player+1)+" Enter your input or Press 'e' to Exit");
		printTicTacToe(ticTacToe);		
		String ipString = ipread.next();
		flag1=checkPlayerInput(ipString,ticTacToe);
		if(flag1==true)
		{
			TicTacToe.insertInput(ticTacToe, ipString, player);
			flag2=TicTacToe.checkForDiagonal(ticTacToe, ipString);
			if(flag2==true)
			{
				printTicTacToe(ticTacToe);
				System.out.println("Player "+(player+1)+" Wins");
				break outer;
			}
			flag2=TicTacToe.checkForColumn(ticTacToe, ipString);
			if(flag2==true)
			{
				printTicTacToe(ticTacToe);
				System.out.println("Player "+(player+1)+" Wins");
				break outer;
			}
			flag2=TicTacToe.checkForRow(ticTacToe, ipString);
			if(flag2==true)
			{
				printTicTacToe(ticTacToe);
				System.out.println("Player "+(player+1)+" Wins");
				break outer;
			}
			TicTacToe.checkDrawMatch(ticTacToe);
			player=(player+1)%2;
		}		
		}while(flag2==false);
		ipread.close();
	}

	static void printTicTacToe(String[][] ticTacToe) {
		for (int row = 0; row < ticTacToe.length; row++) {
			for (int column = 0; column < ticTacToe.length; column++) {
				System.out.print(ticTacToe[row][column] + "  ");
			}
			System.out.println("\n");
		}
	}

	static boolean checkPlayerInput(String inputString, String[][] ticTacToe) {
		boolean flag1 = false, flag2 = false, flag3 = false;
		if(inputString.equals("e"))
			{
				System.exit(0);
			}
		if (inputString.length() == 2) {
			flag1 = true;
			if (inputString.charAt(0) >= '0' && inputString.charAt(0) <= '2' && inputString.charAt(1) >= '0' && inputString.charAt(1) <= '2') {	
				flag2 = true;
				if (ticTacToe[inputString.charAt(0)-'0'][inputString.charAt(1)-'0'].equals(inputString)) {						
					flag3 = true;
				} else {
					flag3 = false;
					System.out.println();
					System.out.println("That poststion already has  "
							+ ticTacToe[ inputString.charAt(0)-'0'][inputString.charAt(1)-'0']);
				}
			} else {
				System.out.println("Hey hacker :P   Just type the correct Row and Column number");
				flag2 = false;

			}
		} else {
			System.out.println("Hey hacker :P  Just type the correct Row and Column number");
			flag1 = false;
		}

		return flag1 && flag2 && flag3;
	}
	
	static boolean checkForDiagonal(String[][] ticTacToe, String ipString)
	{
		
		if((ticTacToe[0][0]==ticTacToe[1][1])&&(ticTacToe[1][1]==ticTacToe[2][2]))
		{
			return true;
		}
		else if((ticTacToe[0][2]==ticTacToe[1][1])&&(ticTacToe[1][1]==ticTacToe[2][0]))
		{
			return true;
		}
		return false;
		
	}
	
	static boolean checkForColumn(String[][] ticTacToe, String ipString)
	{
		int column = ipString.charAt(1)-'0';
		if((ticTacToe[0][column]==ticTacToe[1][column])&&(ticTacToe[1][column]==ticTacToe[2][column]))
		{
			return true;
		}
		return false;
	}
	
	static boolean checkForRow(String[][] ticTacToe, String ipString)
	{
		int row = ipString.charAt(0)-'0';
		if((ticTacToe[row][0]==ticTacToe[row][1])&&(ticTacToe[row][1]==ticTacToe[row][2]))
		{
			return true;
		}
		return false;
	}
	static void insertInput(String[][] ticTacToe, String ipString, int player)
	{
		if(player==0)
		{
			ticTacToe[ipString.charAt(0)-'0'][ipString.charAt(1)-'0']="O";
		}
		else
		{
			ticTacToe[ipString.charAt(0)-'0'][ipString.charAt(1)-'0']="X";
		}
	}
	static void checkDrawMatch(String[][] ticTacToe)
	{
		int row=0,col=0;
		outer:
		for( row=0; row<3; row++)
		{
			for( col=0; col<3; col++)
			{
				
				if(ticTacToe[row][col].equals(""+row+col)) {					
					break outer;
				}
			}
		}
		if(row==3&&col==3) {
			System.out.println("Match Draw");
			System.exit(0);
			}
	}
}