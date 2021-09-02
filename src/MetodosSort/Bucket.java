package MetodosSort;

import java.util.ArrayList;

public class Bucket {

    int consultasVetor = 0;

    public int getConsultasVetor() {
        return consultasVetor;
    }

    public void bubbleArray(ArrayList<Integer> array) {
        consultasVetor = 0;
        //Utiliza o metodo Bubble com a chamada de um ArrayList e ordena a mesma
        for (int i = array.size() - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                consultasVetor++;
                if (array.get(j) > array.get(j + 1)) {
                    int aux = array.get(j);                     // AUX armazena o valor 
                    array.set(j, array.get(j + 1));             // array na posicao j, recebe o valor do array na posicao j+1
                    array.set(j + 1, aux);                      // array na posicao j+1, recebe o AUX
                }
            }
        }
    }

    //Metodo para imprimir a Matriz de vetores
    public void printMatriz(ArrayList[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Array" + i + ": ");
            if (matriz[i].isEmpty()) {                          // Se o Array na posicao i estiver vazio
                System.out.print("-");                          // Entao insere um "-" para melhor visualizacao
            }

            for (int j = 0; j < matriz[i].size(); j++) {
                System.out.print(matriz[i].get(j) + "    ");    // Imprime o valor atual do Array[i]
            }
            System.out.println("");
        }
    }

}
