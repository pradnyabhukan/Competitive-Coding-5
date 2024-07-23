//TC: O(mn)
//SC: O(max(m,n))
class Solution {
    private boolean checkSubBoard(char[][] board, int startRow, int startCol) {
        HashSet<Character> elements = new HashSet<>();
        for(int i = startRow ; i<startRow + 3 ; i++) {
            for(int j = startCol ; j<startCol + 3 ; j++) {
                if(elements.contains(board[i][j])) {
                    return false;
                } 
                if(board[i][j] != '.' ) {
                    elements.add(board[i][j]);
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0 ; i<m ; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            for(int j=0 ; j<n ; j++) {
                if(row.contains(board[i][j]) || col.contains(board[j][i])) {
                    return false;
                } 
                if(board[i][j] != '.' ) {
                    row.add(board[i][j]);
                }
                if(board[j][i] != '.' ) {
                    col.add(board[j][i]);
                }
            }
        }

        for(int i=0 ; i<m ; i=i+3) {
            for(int j=0 ; j<n ; j=j+3) {
                boolean bool = checkSubBoard(board, i, j);
                if(!bool)   return false;
            }
        }
        return true;
    }
}