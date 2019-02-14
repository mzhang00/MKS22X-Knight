public class KnightBoard{
  int[][] data;

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
        if (c < data.length - 1){
          ans += " ";
        }
      }
      if (i < data[0].length - 1){
        ans += "\n";
      }
    }
    return ans;
  }

}
