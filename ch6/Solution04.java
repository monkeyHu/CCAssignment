package ch6;

/*There are three ants on different vertices of a triangle, find the probbability of collision if they start walking
 * on the sides of the triangle, Assume that each ant randomly picks a direction, whith either direction being
 * equally likely to be chosen and they walk at a same spped.
 * Similarly, find the probability of collusion with n ants on an n-vertex polygon
 */
public class Solution04 {
/*For three ants on different vertices of a triangle, if they all walk in the same direction, there won't be collision
 * So the probability of all ants walk clockwise p1 = (1/2)^3
 * the probability of all ants walk counterClockwise p2 = (1/2)^3
 * So the probability of collision p = 1 - p1 - p2 = 1 - 2*((1/2)^3) = 1 - (1/2)^2 = 3/4
 * 
 * For n ants on an n-vertex polygon
 * the probabolity of collision p = 1 - (1/2)^(n-1)
 */
}
