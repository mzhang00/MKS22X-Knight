public class KnightBoard{
  int[][] data;
  int[] xmoves = {1,1,2,2,-1,-1,-2,-2};
  int[] ymoves = {2,-2,1,-1,2,-2,1,-1};

  public KnightBoard(int startingRows,int startingCols){
    if (startingCols <= 0 || startingRows <= 0){
      throw new IllegalArgumentException();
    }
    data = new int[startingRows][startingCols];
    clearBoard();
  }

  public void clearBoard(){
    for (int r = 0; r < data.length; r++){
      for (int c = 0; c < data[0].length; c++){
        data[r][c] = 0;
      }
    }
  }

  public String toString(){
    String ans = "";
    int count = 1;
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
    return solveH(startingRow, startingCol, 1);
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
}
