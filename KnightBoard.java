public class KnightBoard{
  int[][] data;

  public KnightBoard(int startingRows,int startingCols){
    if (startingCols < 0 || startingRows < 0){
      throw new IllegalArgumentException();
    }
    data = new int[startingRows][startingCols];
    for (int r = 0; r < startingRows; r++){
      for (int c = 0; c < startingCols; c++){
        data[r][c] = 0;
      }
    }
  }

}
