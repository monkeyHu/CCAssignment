package ch6;

/*You have a basketball hoop and someone says that you can play one of two games
 * Game1 : You get onet shot to make the hoop
 * Game 2: You get three shots and you have to make two of three shots
 * if p is the probability of masking a particular shot, for which values of p should you pock one game of other?
 */
public class Solution02 {
/* For game 1, the winning probability is p.
 * For game 2, we should at least make two of three shots to win
 * the probability of making three shot is p^3
 * the probability of making two shot is 3*p(1-p)
 * the winning probability is p^3 + 3*p(1-p)
 * If the winning probability of game 1 and game 2 is the same, then 
 * If P(Game 1)  > P(Game 2)
 * p > p ^ 3 + 3 *ги1-p)*p^2  => 2p^2 - 3p + 1 > 0 => (2p-1)*(p-1) > 0, since p < 1, so p - 1 < 0,
 * so 2p - 1 < 0 => p < 0.5
 * So if 0 < p < 0.5, we should play Game 1
 * if 0.5 < p < 1, we should paly Game 2
 * if p = 0, 0.5,1, P(Game 1) = P(Game 2), it doesn't matter which game we paly
 * 
 */
}
