public class KnightBoard{
  int[][] data;

  public KnightBoard(int startingRows,int startingCols){
    if (startingCols < 0 || startingRows < 0){
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
    return "";
  }
}
