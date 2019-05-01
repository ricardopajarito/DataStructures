
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int V,E;
        Scanner sc=new Scanner(System.in);
        System.out.println("Dame el numero de Vertices");
        V=sc.nextInt();
        System.out.println("Dame el numero de aristas");
        E=sc.nextInt();
        Vertice aristas=new Vertice(V,E);

        for(int i=0;i<E;i++){
            System.out.println("-------Arista-----");
            System.out.print("\nDe Vertice: ");
            int origen = sc.nextInt();
            System.out.print("\nA Vertice:");
            int destino=sc.nextInt();
            System.out.print("\nPeso: ");
            int peso=sc.nextInt();
            aristas.insertar(origen,destino,peso);
        }
        aristas.CaminoMinimo();
    }

}