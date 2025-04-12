package leetcode6.leetcode.editor.cn;

/**
 * 79:单词搜索
 */
public class 单词搜索79 {
    public static void main(String[] args) {
        Solution solution = new 单词搜索79().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (exist(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean exist(char[][] board, String word, int index, int i, int j) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
                return false;
            }

            if (index == word.length() - 1) {
                return true;
            }

            board[i][j] = '\0';
            boolean res = exist(board, word, index + 1, i + 1, j) ||
                exist(board, word, index + 1, i - 1, j) ||
                exist(board, word, index + 1, i, j + 1) ||
                exist(board, word, index + 1, i, j - 1);
            board[i][j] = word.charAt(index);
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}