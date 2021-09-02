package MetodosSort;

public class Merge {

    int consultasVetor = 0;

    public void merge(int vetor[], int inicio, int meio, int fim) {
        int i, p1, p2;
        int vetAux[] = new int[fim + 1];                                        // Cria novo Vetor Auxiliar com tamanho do vetor + 1 

        p1 = inicio;                                                            // indicador do array da metade esquerda
        p2 = meio + 1;                                                          // indicador do array da metade direita
        i = inicio;                                                             // indicador do array aux[] a conter juncao
        
        // 
        while (p1 <= meio && p2 <= fim) {
            consultasVetor++;            // Enquanto de para comparar
            if (vetor[p1] <= vetor[p2]) {
                vetAux[i++] = vetor[p1++];  // Escolher o menor e adicionar
            } else {
                vetAux[i++] = vetor[p2++];
            }
        }
        
        // Adicionar os itens restantes do vetor principal
        while (p1 <= meio) {
          //  consultasVetor++;
            vetAux[i++] = vetor[p1++];             // Adiciona a primeira parte
        }
        while (p2 <= fim) {
           // consultasVetor++;
            vetAux[i++] = vetor[p2++];             // Adiciona a segunda parte
        }

        
        for (i = inicio; i <= fim; i++) {
            vetor[i] = vetAux[i];  // Copiar array aux[] para v[]
        }
    }

    // Ordenar o vetor principal entre as posicoes inicio e fim
    public void ordenar(int vetor[], int inicio, int fim) {
        int meio;
        
        if (inicio < fim) {                                                     // Termina quando o tamanhanho do vetor < 2
            //consultasVetor++;
            meio = (inicio + fim) / 2;                                          // Calcular ponto medio
            
            //consultasVetor++;
            ordenar(vetor, inicio, meio);                                       // Ordenar metade da esquerda
            
            //consultasVetor++;
            ordenar(vetor, meio + 1, fim);                                      // Ordenar metade direita
            
            //consultasVetor++;
            merge(vetor, inicio, meio, fim);                                    // Combinar duas metades ordenadas
            //consultasVetor++;
        }
    }

}
