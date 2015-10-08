package ch6;

/*There is an 8 * 8 chessboard in which two diagonally oppositive corners have been cut off , you are given 31 
 * dominos, and a single domino can cover exactly two squares. Can you use the 31 dominos to cover the entire board?
 */
public class Solution03 {
/* No, we cann't use the 31 dominos to cover the entire board.
 * Assume we paint the 8 * 8 chessboard with color black and white, the same color is not adjancent to each other.
 * If we cut off the two diagonally oppositive corners, then there will be left 30 one color and 32 other colors,
 * while a single domino can cover one white and one black board , then 31 dominos can cover 31 white squares and 31
 *  black squares
 * However, there are only 30 black and 32 white squares (or 32 black and 30 white squares), so the 31 dominos can not
 * cover the entire board
 */
}
