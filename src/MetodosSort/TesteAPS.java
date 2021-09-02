
package MetodosSort;

import java.util.Scanner;

public class TesteAPS {

    public static void main(String[] args) {
        Ordenacao ord = new Ordenacao();
        int vetteste[] = {510, 471, 1, 490, 69, 487, 336};
        int media = 0;
        
        System.out.print("Digite a quantidade de itens no vetor: ");
        Scanner tec = new Scanner(System.in);
        int num = tec.nextInt();
        
        int vetor[] = ord.criarVetor(num);
        System.out.println("");
        System.out.println("");
        
        
        //OK    ord.radixSort(vetor);
        //OK    ord.selection(vetor);
        //OK    ord.insertion(vetor);
        //OK    ord.count(vetor);
        //OK    ord.bubble(vetor);
        //    ord.bucket(vetor);
        
        /*para teste de media comparacoes HeapSort
            for (int i = 0; i < 100; i++) {
                int vetor[] = ord.criarVetor(num);
                ord.heap(vetor);
                //valor = ord.compaHeap;
            }
            media = ord.compaHeap;
            System.out.println("valor da media " +valor);
        */
        
        //ord.merge(vetteste);
        //ord.quick(vetteste);
        
        tec.close();
        
        
    }
    
}
