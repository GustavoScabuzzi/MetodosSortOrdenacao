package MetodosSort;

public class Heap {

    int consultasVetor = 0;

    public int getConsultasVetor() {
        return consultasVetor;
    }

    public void buildMaxHeap(int vetor[]) {

        //constroi a arvore maxheap
        for (int i = vetor.length / 2 - 1; i >= 0; i--) {                       //iniciando no valor do ultimo pai
            maxHeap(vetor, i, vetor.length);                                    // executa maxHeap passando o valor do pai
        }
    }

    // metodo para ordenacao pela forma do Heap 
    public void maxHeap(int vetor[], int pai, int tamanhoDoVetor) {

        int esquerda = 2 * pai + 1;                                             // Encontra o elemento da esquerda
        int direita = esquerda + 1;                                             // Encontra o elemento da Direita

        if (esquerda < tamanhoDoVetor) {                                        // se o elemento da esquerda for menor que o tamanho do vetor
            consultasVetor++;
            if (direita < tamanhoDoVetor && vetor[esquerda] < vetor[direita]) { // se o elemento da direita foi menor que o tamanhao do vetor e 
                                                                                // vetor[filho esquerdo] for menor que vetor[filho direito 
                consultasVetor++;
                esquerda = direita;                                             // filho da esquerda recebe o da direita
            }

            if (vetor[esquerda] > vetor[pai]) {                                 // se o vetor[filho da esquerda for maior vetor[pai]
                consultasVetor++;
                troca(vetor, esquerda, pai);                                    // ocorrera a troca dos elementos
                maxHeap(vetor, esquerda, tamanhoDoVetor);                       // Refaz o Heap com o valor da esquerda 
            }
        }
    }

    // Trocar o valor da esquerda pai e vice e versa
    public void troca(int vetor[], int esquerda, int pai) {
        int aux = vetor[esquerda];                                              // AUX recebe vetor em esquerda
        vetor[esquerda] = vetor[pai];                                           // vetor na posicao [esquerda] recebe o vetor em [pai]
        vetor[pai] = aux;                                                       // e o vetor em pai recebe o AUX que é o valor do vetor na esquerda
    }

}
