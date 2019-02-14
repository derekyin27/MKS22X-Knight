public class KnightBoard{
  private int[][] board;
  public KnightBoard(int startingRows, int startingCols){
    if (startingRows <= 0 || startingCols <= 0)
    throw new IllegalArgumentException();
    board = new int[startingRows][startingCols];
    for (int r = 0; r < board.length; r++){
      for (int c =0; c < board[0].length; c++){
        board[r][c] = 0;
      }
    }
  }

public String toString(){
  String str = "";
  for (int r =0; r < board.length; r++){
    for (int c=0; c < board[0].length; c++){
      if (board[r][c] == 0){
        str+= "_ ";
      }
        else if (board[r][c] >= 10){
          str+=board[r][c];
        }
      else{
        str+= board[r][c] + " ";
      }

    }
    str+="\n";
  }
  return str;
}

public boolean solve(int startingRow, int startingCol){
  for (int r =0; r < board.length; r++){
    for (int c =0; c < board[0].length; c++){
      if (board[r][c] != 0)
        throw new IllegalStateException();
    }
  }
  if (startingRow < 0 || startingRow >= board.length || startingCol < 0 || startingCol >= board[0].length){
    throw new IllegalArgumentException();
  }else {
    return solveH(startingRow, startingCol, 1);
  }
}

private boolean solveH(int row, int col, int level){
  if (level == board.length * board[0].length){
    return true;
  }
  if (row >= board.length || col >= board[0].length || row <0 || col<0){
    return false;
  }
  else if (board[row][col] == 0){
    board[row][col] = level;
    return solveH(row+1, col+2, level+1) ||
    solveH(row+1, col-2, level+1) ||
    solveH(row-1, col-2, level+1) ||
    solveH(row-1, col+2, level+1) ||
    solveH(row+2, col+1, level+1) ||
    solveH(row+2, col-1, level+1) ||
    solveH(row-2, col+1, level+1) ||
    solveH(row-2, col-1, level+1);
  }
  return true;

}
public static void main(String[] args) {
  KnightBoard test = new KnightBoard(10, 10);
  System.out.println(test.solve(0,0));
  System.out.println(test);
}
}
