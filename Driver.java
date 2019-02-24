public class Driver{
  public static void main(String[] args){
    KnightBoard k; 
    System.out.println("-------------------------------------------------");
    //System.out.println(k);
    for (int i = 1; i <= 4; i++){
      for (int c = i; c <= 4; c++){
        System.out.println("" + i + "x" + c);
        System.out.println();
        k = new KnightBoard(i, c);
        System.out.println(k.countSolutions(0, 0));
        System.out.println("-------------------------------------------------");
      }
    }
  }
}
