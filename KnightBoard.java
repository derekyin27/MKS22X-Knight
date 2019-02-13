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
        str+= "0 ";
      }
    }
    str+="\n";
  }
  return str;
}

public static void main(String[] args) {
  KnightBoard test = new KnightBoard(7, 7);
  System.out.println(test);
}
}
