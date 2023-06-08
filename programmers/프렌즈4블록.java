package programmers;
import java.util.*;

public class 프렌즈4블록 {
    class Solution {
        public boolean stop = false;
        public int solution(int m, int n, String[] board) {
            int answer = 0;
            char[][] map = new char[board.length][board[0].length()];
            for(int i=0; i<map.length; i++) {
                map[i] = board[i].toCharArray();
            }

            while (!stop) {
                map = update(map);
            }

            for(int i=0; i<map.length; i++) {
                for(int j=0; j<map[0].length; j++) {
                    if (map[i][j] == 'e') {
                        answer++;
                    }
                }
            }

            return answer;
        }

        public char[][] update(char[][] board) {
            LinkedList<int[]> position = new LinkedList<>();
            for(int i=0; i<board.length-1; i++) {
                for(int j=0; j<board[0].length-1; j++) {
                    if (board[i][j]==board[i+1][j] && board[i][j]==board[i][j+1] && board[i][j]==board[i+1][j+1] && board[i][j] != 'e') {
                        position.add(new int[]{i,j});
                    }
                }
            }

            if (position.size() == 0) {
                stop = true;
                return board;
            }

            for(int i=0; i<position.size(); i++) {
                int x = position.get(i)[0];
                int y = position.get(i)[1];
                board[x][y] = 'e';
                board[x+1][y] = 'e';
                board[x][y+1] = 'e';
                board[x+1][y+1] = 'e';
            }

            for(int i=0; i<board[0].length; i++) {
                LinkedList<String> notEmpty = new LinkedList<>();
                for(int j=0; j<board.length; j++) {
                    if(board[j][i] != 'e') {
                        notEmpty.add(String.valueOf(board[j][i]));
                    }
                }

                for(int j=0; j<board.length-notEmpty.size(); j++) {
                    board[j][i] = 'e';
                }
                for(int j=board.length-notEmpty.size(); j<board.length; j++) {
                    board[j][i] = notEmpty.get(j-board.length+notEmpty.size()).charAt(0);
                }
            }

            return board;
        }
    }
}
