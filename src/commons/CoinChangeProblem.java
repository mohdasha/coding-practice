package commons;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CoinChangeProblem {

	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static int minCoins(int[] coins, int sum) {
		
		if(sum == 0)
			return 0;
		
		if(sum < 0)
			return Integer.MAX_VALUE;
		int minCoins = Integer.MAX_VALUE;
		
		for(int i=0; i<coins.length; i++) {
			int res = minCoins(coins, sum - coins[i]);
			
			if(res != Integer.MAX_VALUE)
				minCoins = Math.min(minCoins, res+1);
		}
		
		return minCoins;
		
	}

	public static int getMinCoinsIterative(int[] coins, int sum) {

		int[] memo = new int[sum + 1];

		Arrays.fill(memo, sum + 1);

		memo[0] = 0;

		for (int i = 1; i <= sum; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0)
					memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1);
			}
		}

		return memo[sum];

	}

    public static int getMinCoinsRecursive(int[] coins, int amount, int[] memo) {
        if (amount < 0)
            return -1;
        if (amount == 0)
			return 0;

        if (memo[amount] != 0)
            return memo[amount];

        int minCoins = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int change = getMinCoinsRecursive(coins, amount - coins[i], memo);

            if (change >= 0 && change < minCoins)
                minCoins = change + 1;
		}

        memo[amount] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        return memo[amount];
	}

	public static int getWays(int[] coins, int sum) {
		if (sum == 0)
			return 1;
		if (sum < 0)
			return 0;

		int ways = 0;
		for (int i = 0; i < coins.length; i++) {
			ways += getWays(coins, sum - coins[i]);
		}

		return ways;
	}

	public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};

//		[186,419,83,408]
//		6249
        int sum = 6249;

		int[] memo = new int[sum + 1];
        memo[0] = 0;
		logger.log(Level.INFO, "Min Coins: {0}", getMinCoinsRecursive(coins, sum, memo));

	}
}
