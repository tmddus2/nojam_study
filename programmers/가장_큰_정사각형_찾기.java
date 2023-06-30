package programmers;

public class 가장_큰_정사각형_찾기 {
    class Solution
    {
        public int solution(int [][]board)
        {
            int answer = Integer.MIN_VALUE;

            for(int i=0; i<board.length; i++) {
                for(int j=0; j<board[0].length; j++) {
                    if (i-1>=0 && j-1>=0 && board[i][j]==1) {
                        board[i][j] = Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1])+1;
                        answer = Math.max(answer, board[i][j]);
                    }
                }
            }
            if (answer == Integer.MIN_VALUE) {
                if (board.length <= 2 || board[0].length <=2) {
                    for(int i=0; i<board.length; i++) {
                        for(int j=0; j<board[0].length; j++) {
                            if (board[i][j] == 1) {
                                return 1;
                            }
                        }
                    }
                }
                return 0;
            }
            return answer*answer;
        }


    }
}
