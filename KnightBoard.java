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
        board[r][c] = 0;
      }
    }
    moves1 = new int[] {1, 1, -1, -1, 2, 2, -2, -2};
    moves2 = new int[] {2, -2, 2, -2, 1, -1, 1, -1};
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
  if (row < 0 || row >= board.length || col < 0 || col >= board[0].length){
    throw new IllegalArgumentException();
  }else {
    board[row][col] =1;
    return solveH(row, col, 2);
  }
}

/*private boolean solveH(int row, int col, int level){
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
  return false;


*/

private boolean canAdd(int row, int col, int level){
  if (row >= board.length || col >= board[0].length || row <0 || col<0 || board[row][col] != 0){
    return false;
  }
board[row][col] = level;
  return true;

  }

private boolean solveH(int rows, int cols, int level){
  if (level > board.length * board[0].length ){
    return true;
  }
  if (rows >= board.length || cols >= board[0].length  || rows <0 || cols<0){
    return false;
  }
  for (int i = 0; i < moves1.length; i++){
    if (canAdd(rows + moves1[i], cols + moves2[i], level)){
      if (solveH(rows + moves1[i], cols + moves2[i], level + 1)){
        return true;
      }
      board[rows + moves1[i]][cols + moves1[i]] = 0;
    }


  }
  return false;
}
public static void main(String[] args) {
  KnightBoard test = new KnightBoard(5, 5);
  System.out.println(test.solve(3, 3));
  System.out.println(test);
}
}
