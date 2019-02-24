public class Driver{
  public static void main(String[] args){
    KnightBoard k; 
    System.out.println("-------------------------------------------------");
    for (int i = 1; i <= 7; i++){
      for (int c = i; c <= 7; c++){
        System.out.println("" + i + "x" + c);
        System.out.println();
        k = new KnightBoard(i, c);
        System.out.println(k.solve(0, 0));
        System.out.println();
        System.out.println(k);
        System.out.println("-------------------------------------------------");
      }
    }
  }
}
