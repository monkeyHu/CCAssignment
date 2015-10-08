package ch6;
/*Blue-Eyed Island, Find how many days will it take the blue-eyed people to leave*/
public class Solution06 {
/*Assume there are n people have blue eyes, Let's start with the Base Case and then Build approach
 * For case n = 1, only one person has blue eyes
 * the blue-eyed person will look around and realize that no one else has blue eyes, Since he knows that at least
 * one person has blue eyes, he must conclude that it it he who has blue eyes, therefore, he would take the flight 
 * that evening
 * For case n = 2, two people have blue eyes
 * The two blue-eyed people see each other, but are unsure whether n is 1 or 2, They know if n = 1, the blue-eyed
 * people will leave on the first night, therefore, if the other blue-eyed person is still there, he must decude that
 * c = 2, which means that he himself has blue eyes. Both men would then leave on the second night
 * For case n > 2
 * As we increse n, we can see that this logic continues apply. If n = 3 ,then those three people will immediately 
 * know that there either 2 or 3 people with blue eyes, if there are two people, then those two people would have left
 * on the second night. So when the others are still around after that nightm each person would conclude that n = 3
 * and that they have blue eyes too, they would leave that night.
 * 
 * This smae pattern extends up through any value of n. Therefore, if n men have blue eyes, it will take n nights for
 * those blue-eyed men to leave, and all will leave on the same night.
 * 
 */
}
