package ch6;
/*There is a builing of 100 floors, if an egg drops from the Nth floor or above it, it will break. If it's dropped from
 * any floor below, it will not break. You are given two eggs, find N while minimizing the number of drops
 * for the worst case
 */
public class Solution08 {
/* Since we want to minimize the number of drops for the worst case.
 * We can create a system for dropping Egg1 such that the number of total drops is as
 * consistent as possible.Assume the number of drops is N
 * Then if EggA drop X times, EggB should drop N-X times to find the drop floor
 * Therefor EggA must start at floor X, then go up by X-1,X-2..until it goes to 100
 * So we can obtian 
 * X + (X - 1) + (X - 2) + ....+ 1 = 100
 * X * (X + 1) = 100
 * => X= 13.65
 * Since X is integer, if X is 13, then the last drop will be at floor 91, floor 92 to 100 has benn
 * checked, so in worst case , we need 9 more drops. The total drops will be 22.
 * if X is 14, then the last drop will be at floor 99, one more drop can check the droped floor
 * the total drop will be 15 for the worst case
 * So X should be 14
 * 
 */
}
