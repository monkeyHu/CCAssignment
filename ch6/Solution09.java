package ch6;

/*There are 100 closed lockers in hallway. A man begins by openning all 100 lockers. Next, he closes every second 
 * locker. Then, onn his third pass, he toggles every third locker. This process continues for 100 passes, such that on each
 * pass i, the man toggles every ith locker. After his 100th pass in the hallway, in which he toggles only locker #100, how 
 * many locker are open.
 */
public class Solution09 {
/*First, we know that a door n is toggled once for each fractor of n. For example, 8 is toggled on rounds 1, 2 , 4,8
 * Then, we know if the door n are open, then they are toggles odd number times. which means the number of fractors
 * of n is odd.
 * Then, Since pair n's factors by their complements. For example, if n = 16, 1 * 16 = 16, 2 * 8 = 16, 4 * 4= 16,
 * so door 16 is toggled 5 times, it is open after 100th pass.
 * So we can conlcude that, the number fractors is odd if n is a perfect square, there are 10 perfect square which is
 *  less or equal than 100. They are {1*1,2*2,3*3,4*4,5*5,6*6,7*7,8*8,9*9,10*10)
 *  
 * Therefore, there are 10 lockers are open.
 * 
 */
}
