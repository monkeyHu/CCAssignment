package ch6;

/*You have 20 bottles of pills. 19 bottles have 1.0 gram pills, but one has 1.1 gram pills. Given a scale that provide
 * an exact measurement, only use the scale once, find the heavy bottle
 */
public class Solution01 {
/*First, label the bottles for Bottle#1, Bottle#2....Bottle#20
 * Then, take one pill from Bottle#1, 2 pills from Bottle#2, 3 pills from Bottle#3.... 20 pills from Bottle#20
 *if Bottle#1 has 1.1 gram pills, then the total weight of those pills would be
 *£¨1+2+3+4+5+6+¡£¡£¡£¡££©+1*(1.1-0.1) = 210.1
 *if Bottle#2 has 1.1 gram pills, then the total weight of those pills would be
 *210 + 2*0.1 = 210.2
 *.¡£¡£
 *if Bottle#13 has 1.1 gram pills, then the total weight of those pills would be
 *210 +¡¡13*0.1 = 211.3
 *From the above, we can conclude that the lable of the bottle is
 *NumberedBottle = (totalWeight - 210)*10
 */
}
