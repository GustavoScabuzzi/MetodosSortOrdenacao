/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodosSort;

public class Quick {
      int consultaVetores = 0;

    public void quickSort(int[] vetor, int inicio, int fim) {
             if (inicio < fim) {
                    int posicaoPivo = separar(vetor, inicio, fim);
                    quickSort(vetor, inicio, posicaoPivo - 1);
                    quickSort(vetor, posicaoPivo + 1, fim);
             }
       }
    private int separar(int[] vetor, int inicio, int fim) {
             int pivo = vetor[inicio];
             int i = inicio + 1, f = fim;
             while (i <= f) {
                 consultaVetores++;
                    if (vetor[i] <= pivo){
                        consultaVetores++;
                           i++;}
                    else if (pivo < vetor[f]){
                        consultaVetores++;
                        f--;
                    }
                    else {
                           int troca = vetor[i];
                           vetor[i] = vetor[f];
                           vetor[f] = troca;
                           i++;
                           f--;
                    }
             }
             vetor[inicio] = vetor[f];
             vetor[f] = pivo;
             return f;
       }
    
   public void mostrarVetor(int vetor []){
        for (int i : vetor) {
            System.out.print("[" + i + "] - ");
        }
        System.out.println("\nConsultas:" + consultaVetores);
    }
}
