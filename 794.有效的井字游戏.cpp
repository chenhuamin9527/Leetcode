/*
 * @lc app=leetcode.cn id=794 lang=cpp
 *
 * [794] 有效的井字游戏
 *
 * https://leetcode-cn.com/problems/valid-tic-tac-toe-state/description/
 *
 * algorithms
 * Medium (34.19%)
 * Likes:    63
 * Dislikes: 0
 * Total Accepted:    13.4K
 * Total Submissions: 36.2K
 * Testcase Example:  '["O  ","   ","   "]'
 *
 * 给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。
 * 
 * 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
 * 
 * 以下是井字游戏的规则：
 * 
 * 
 * 玩家轮流将字符放入空位（' '）中。
 * 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
 * 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：board = ["O  ","   ","   "]
 * 输出：false
 * 解释：玩家 1 总是放字符 "X" 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：board = ["XOX"," X ","   "]
 * 输出：false
 * 解释：玩家应该轮流放字符。
 * 
 * 示例 3：
 * 
 * 
 * 输入：board = ["XXX","   ","OOO"]
 * 输出：false
 * 
 * 
 * Example 4:
 * 
 * 
 * 输入：board = ["XOX","O O","XOX"]
 * 输出：true
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * board.length == 3
 * board[i].length == 3
 * board[i][j] 为 'X'、'O' 或 ' '
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    bool validTicTacToe(vector<string>& board) {
        int xCount = 0, oCount = 0;
        // 统计X和O字符的出现次数
        for (string & row : board) {
            for (char c : row) {
                xCount = (c == 'X') ? (xCount + 1) : xCount;
                oCount = (c == 'O') ? (oCount + 1) : oCount;
            }
        }
        // 如果第一个玩家获胜，由于第一个玩家是先手，则次数游戏板中"X"的数量比"O"的数量多1。
        // 如果第二个玩家获胜，则"X"的数量与"O"的数量相同。
        if (oCount != xCount && oCount != xCount - 1) {
            return false;
        }
        if (win(board, 'X') && oCount != xCount - 1) {
            return false;
        }
        if (win(board, 'O') && oCount != xCount) {
            return false;
        }
        return true;
    }

    // 判断胜利的条件
    // 同一行 || 同一列 || 对角线上都是同一字符时胜利
    bool win(vector<string>& board, char p) {
        for (int i = 0; i < 3; ++i) {
            if (p == board[i][0] && p == board[i][1] && p == board[i][2]) {
                return true;
            }
            if (p == board[0][i] && p == board[1][i] && p == board[2][i]) {
                return true;
            }
        }
        if (p == board[0][0] && p == board[1][1] && p == board[2][2]) {
            return true;
        }
        if (p == board[0][2] && p == board[1][1] && p == board[2][0]) {
            return true;
        }
        return false;
    }
};

// @lc code=end

