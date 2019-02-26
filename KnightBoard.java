public class KnightBoard{
  private int[][] board;
  private int[] moves1;
  private int[] moves2;
  public KnightBoard(int rows, int cols){
    if (rows <= 0 || cols <= 0)
    throw new IllegalArgumentException();
    board = new int[rows][cols];
    for (int r = 0; r < board.length; r++){
      for (int c =0; c < board[0].length; c++){
        board[r][c] = 0;// fills board
      }
    }
    moves1 = new int[] {1, 1, -1, -1, 2, 2, -2, -2};// places all possible moves into integer arrays;
    moves2 = new int[] {2, -2, 2, -2, 1, -1, 1, -1};

  }

private void clear(){
  for (int r =0; r<board.length;r++){
    for (int c=0; c<board[0].length; c++){
      board[r][c]=0;
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
        else if (board[r][c] < 10){
          str+=" " + board[r][c] + " ";
        }
      else{
        str+= board[r][c] + " ";
      }

    }
    str+="\n";
  }
  return str;
}

public boolean solve(int row, int col){
  for (int r =0; r < board.length; r++){
    for (int c =0; c < board[0].length; c++){
      if (board[r][c] != 0)
        throw new IllegalStateException();
    }
  }
  if (row < 0 || col < 0 ||row >= board.length|| col >= board[0].length){
      throw new IllegalArgumentException();
    }
    return solveH(row, col, 1);

}


private boolean canAdd(int row, int col, int level){
  if (row >= board.length || col >= board[0].length || row <0 || col<0 || board[row][col] != 0){
    return false;//checking conditions
  }
   board[row][col] = level;//if true then specified spot is assigned a number
  return true;

  }

  private boolean removeKnight(int row, int col){
    if (row >= board.length || col >= board[0].length || row <0 || col<0 || board[row][col]== 0){
      return false;
    }
board[row][col] = 0;//remove knight will help with backtracking to solve
return true;
  }

private boolean solveH(int row, int col, int level){
  if (row >= board.length || col >= board[0].length  || row < 0 || col < 0){
    return false;
  }
  if (level > board.length * board[0].length ){
    return true;
  }
  for (int i = 0; i < moves1.length; i++){
    if (canAdd(row, col, level)){
      if (solveH(row + moves1[i], col + moves2[i], level +1)){// run through all possible combinations of moves
        return true;
      }
      else removeKnight(row, col);// if no possible moves, backtrack
    }

    }
    return false;
  }

  public int countSolutions(int row, int col){
    if (row >= board.length || col >= board[0].length  || row < 0 || col < 0){
      throw new IllegalArgumentException();
    }
    for (int r =0; r < board.length; r++){
      for (int c =0; c < board[0].length; c++){
        if (board[r][c] != 0)
          throw new IllegalStateException();
      }
    }
    return countHelper(row, col, 1);
  }

  private int countHelper(int row, int col, int level){
    int count = 0;
    if (level > board.length*board[0].length){
      return 1;
    }
    for (int i = 0; i < moves1.length; i++){
        if (canAdd(row, col, level)){
          count += countHelper(row + moves1[i], col + moves2[i], level+1);
          removeKnight(row, col);
        }
  }
  return count;
}

public static void main(String[] args) {
  KnightBoard test = new KnightBoard(3, 9);
  System.out.println(test.solve(0,0));
  test.clear();
  System.out.println(test.countSolutions(0,0));
  System.out.println(test);
}
}
