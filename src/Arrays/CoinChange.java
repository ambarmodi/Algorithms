package Arrays;

import java.util.Collections;
import java.util.*;

public class CoinChange {
	public static void main(String[] args) {
		int[] coins = new int[] {186,419,83,408};
		int amount = 6249;

		int change = coinChange(coins, amount);
		System.out.println(change);
	}

	/**
	 * Inspired by leetcode's solution f Dynamic Programming
	 */
	public static int coinChange(int[] coins, int amount) {

		// Treating the zero index as unnecessary here i.e. amtCount[amount]
		// should be the answer.
		int[] amtCount = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			//IMP: Don't initialize to Integer.MAX_VALUE as +1 will make it negative
			amtCount[i] = amount+1;
		}

		for (int amt = 1; amt <= amount; amt++) {
			for (int coin : coins) {
				if (coin <= amt)
					amtCount[amt] = Math.min(amtCount[amt], amtCount[amt - coin] + 1);
			}
		}
		return (amtCount[amount] >amount)  ? -1 : amtCount[amount];
	}
	
	//-----------------------X---------------------
	/**
	 * Below approach will not work in all cases
	 */
	public static int coinChangeIncorrect(int[] c, int amount) {
		List<Integer> coins = new ArrayList<Integer>();
		for(int i : c) coins.add(i);
		
		Collections.sort(coins,Collections.reverseOrder());
		
        int j=0,result=0;
        while(amount!=0) {
        	while(j<coins.size() && amount/coins.get(j) ==0) {
        		j++;
        	}
        	if(j==coins.size()) return -1;
        	result += amount/coins.get(j);
        	amount= amount%coins.get(j);
        	j++;
        }
		return result;
	}
	//-----------------------X---------------------
}
