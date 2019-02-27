import java.util.ArrayList;

public class KnightBoard{
  int[][] data;
  int[] xmoves = {1,1,2,2,-1,-1,-2,-2};
  int[] ymoves = {2,-2,1,-1,2,-2,1,-1};
  //int[] totalmoves = {1,2,1,-2,2,1,2,-1,-1,2,-1,-2,-2,1,-2,-1};
  int[][] datamoves;

  public KnightBoard(int startingRows,int startingCols){
    if (startingCols <= 0 || startingRows <= 0){
      throw new IllegalArgumentException();
    }
    data = new int[startingRows][startingCols];
    datamoves = new int[startingRows][startingCols];
    clearBoard();
    findMoves();
  }

  private void clearBoard(){
    for (int r = 0; r < data.length; r++){
      for (int c = 0; c < data[0].length; c++){
        data[r][c] = 0;
        datamoves[r][c] = 0;
      }
    }
  }

  public String toString(){
    String ans = "";
    for (int i = 0; i < data.length; i++){
      for (int c = 0; c < data[0].length; c++){
        if (data[i][c] < 10){
          if (data[i][c] == 0){
              ans += "__";
          }else{
              ans += " " + data[i][c];
          }
        }else{
          ans += data[i][c];
        }
        if (c < data[0].length - 1){
          ans += " ";
        }
      }
      if (i < data.length - 1){
        ans += "\n";
      }
    }
    return ans;
  }

  public boolean solve(int startingRow, int startingCol){
    int count = 0;
    for (int i = 0; i < data.length; i++){
      for (int c = 0; c < data[0].length; c++){
        if (data[i][c] != 0){
          count++;
        }
      }
    }
    if (count > 0){
      throw new IllegalStateException();
    }
    if (startingCol < 0 || startingRow < 0 || startingCol >= data[0].length || startingRow >= data.length){
      throw new IllegalArgumentException();
    }
    //return solveH(startingRow, startingCol, 1);
    return solveO(startingRow, startingCol, 1);
  }

  private boolean solveO(int row, int col, int moveNumber){
    if (moveNumber > data.length * data[0].length){
      addKnight(row, col, moveNumber);
      return true;
    }else{
      optimizeX(xmoves);
      optimizeY(ymoves);
      if (addKnight(row, col, moveNumber)){
        for (int i = 0; i <= 7; i++){
          if (solveO(row + xmoves[i], col + ymoves[i], moveNumber + 1)){
            return true;
          }
        }
        removeKnight(row, col);
      }
    }
    return false;
  }

  private void findMoves(){
    for (int r = 0; r < data.length; r++){
      for (int c = 0; c < data[0].length; c++){
        int value = 0;
        for (int i = 0; i <= 7; i++){
          if (addKnight(r + xmoves[i], c + ymoves[i], 1)){
            value++;
            removeKnight(r + xmoves[i], c + ymoves[i]);
          }
        }
        datamoves[r][c] = value;
      }
    }
  }

  private boolean solveH(int row ,int col, int moveNumber){
    if (moveNumber > data.length * data[0].length){
      addKnight(row, col, moveNumber);
      return true;
    }else{
      if (addKnight(row, col, moveNumber)){
        for (int i = 0; i <= 7; i++){
          if (solveH(row + xmoves[i], col + ymoves[i], moveNumber + 1)){
            return true;
          }
        }
        removeKnight(row, col);
      }
    }
    return false;
  }

  public int countSolutions(int startingRow, int startingCol){
    int count = 0;
    for (int i = 0; i < data.length; i++){
      for (int c = 0; c < data[0].length; c++){
        if (data[i][c] != 0){
          count++;
        }
      }
    }
    if (count > 0){
      throw new IllegalStateException();
    }
    if (startingCol < 0 || startingRow < 0 || startingCol >= data[0].length || startingRow >= data.length){
      throw new IllegalArgumentException();
    }
    return countH(startingRow, startingCol, 1, 0, 0) / 8;
  }

  private int countH(int row, int col, int moveNumber, int oldrow, int oldcol){
    int counter = 0;
    if (moveNumber > data.length * data[0].length){
      removeKnight(oldrow, oldcol);
      return 1;
    }else{
      if (addKnight(row, col, moveNumber)){
        for (int i = 0; i <= 7; i++){
          counter += countH(row + xmoves[i], col + ymoves[i], moveNumber + 1, row, col);
        }
        removeKnight(row, col);
      }
    }
    return counter;
  }

  private boolean addKnight(int row, int col, int moveNumber){
    if (col < 0 || row < 0 || col >= data[0].length || row >= data.length){
      return false;
    }
    if (data[row][col] == 0){
      data[row][col] = moveNumber;
      return true;
    }
    return false;
  }
  
  private boolean removeKnight(int row, int col){
    if (col < 0 || row < 0 || col >= data[0].length || row >= data.length){
      return false;
    }
    if (data[row][col] != 0){
      data[row][col] = 0;
      return true;
    }
    return false;
  }

  public static void runTest(int i){

    KnightBoard b;
    int[]m =   {4,5,5,5,5};
    int[]n =   {4,5,4,5,5};
    int[]startx = {0,0,0,1,2};
    int[]starty = {0,0,0,1,2};
    int[]answers = {0,304,32,56,64};
    if(i >= 0 ){
      try{
        int correct = answers[i];
        b = new KnightBoard(m[i%m.length],n[i%m.length]);
  
        int ans  = b.countSolutions(startx[i],starty[i]);
  
        if(correct==ans){
          System.out.println("PASS board size: "+m[i%m.length]+"x"+n[i%m.length]+" "+ans);
        }else{
          System.out.println("FAIL board size: "+m[i%m.length]+"x"+n[i%m.length]+" "+ans+" vs "+correct);
        }
      }catch(Exception e){
        System.out.println("FAIL Exception case: "+i);
  
      }
    }
  }

  public static void main(String[] args){
    for (int i = 0; i <= 4; i++){
      runTest(i);
    }
  }
}
