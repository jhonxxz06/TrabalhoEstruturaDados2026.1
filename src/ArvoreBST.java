public class ArvoreBST {
    private No raiz;

    public boolean estaVazia() { 
        return raiz == null; 
    }

    public boolean inserir(Contato novoContato) { 
        if (buscar(novoContato.getNome()) != null) return false; // Evita nomes repetidos
        raiz = inserirRecursivo(raiz, novoContato); 
        return true; 
    }


    private No inserirRecursivo(No noAtual, Contato novoContato) {
        if (noAtual == null) {
            return new No(novoContato); 
        }

        int ordemAlfabetica = novoContato.getNome().compareToIgnoreCase(noAtual.contato.getNome());
        
        if (ordemAlfabetica < 0) {
            noAtual.esquerdo = inserirRecursivo(noAtual.esquerdo, novoContato); 
        }
        else if (ordemAlfabetica > 0) {
            noAtual.direito = inserirRecursivo(noAtual.direito, novoContato);  
        }
        return noAtual;
    }

    
    public Contato buscar(String nomeParaBuscar) { 
        No noEncontrado = buscarRecursivo(raiz, nomeParaBuscar); 
        return noEncontrado == null ? null : noEncontrado.contato; 
    }

    private No buscarRecursivo(No noAtual, String nomeParaBuscar) {
        if (noAtual == null)
            return null;
        
        int ordemAlfabetica = nomeParaBuscar.compareToIgnoreCase(noAtual.contato.getNome());
        
        if (ordemAlfabetica == 0)
            return noAtual;
        
        
        return ordemAlfabetica < 0 ? buscarRecursivo(noAtual.esquerdo, nomeParaBuscar) : buscarRecursivo(noAtual.direito, nomeParaBuscar);
    }

    public void remover(String nomeParaRemover) { 
        raiz = removerRecursivo(raiz, nomeParaRemover); 
    }

    private No removerRecursivo(No noAtual, String nomeParaRemover) {
        if (noAtual == null) return null;
        
        int ordemAlfabetica = nomeParaRemover.compareToIgnoreCase(noAtual.contato.getNome());
        
        if (ordemAlfabetica < 0) {
            noAtual.esquerdo = removerRecursivo(noAtual.esquerdo, nomeParaRemover);
        }
        else if (ordemAlfabetica > 0) {
            noAtual.direito = removerRecursivo(noAtual.direito, nomeParaRemover);
        }
        else {
            
            if (noAtual.esquerdo == null)
                return noAtual.direito;
            if (noAtual.direito == null)
                return noAtual.esquerdo;

            noAtual.contato = encontrarMinimo(noAtual.direito).contato;
            noAtual.direito = removerRecursivo(noAtual.direito, noAtual.contato.getNome());
        }
        return noAtual;
    }

    public Contato primeiro() { 
        return raiz == null ? null : encontrarMinimo(raiz).contato; 
    }

    private No encontrarMinimo(No noAtual) { 
        return noAtual.esquerdo == null ? noAtual : encontrarMinimo(noAtual.esquerdo); 
    }

    public Contato ultimo() { 
        return raiz == null ? null : encontrarMaximo(raiz).contato; 
    }

    private No encontrarMaximo(No noAtual) { 
        return noAtual.direito == null ? noAtual : encontrarMaximo(noAtual.direito); 
    }

    public int quantidade() { 
        return calcularQuantidadeRecursivo(raiz); 
    }

    private int calcularQuantidadeRecursivo(No noAtual) { 
        return noAtual == null ? 0 : 1 + calcularQuantidadeRecursivo(noAtual.esquerdo) + calcularQuantidadeRecursivo(noAtual.direito); 
    }

    public int altura() { 
        return calcularAlturaRecursivo(raiz); 
    }

    private int calcularAlturaRecursivo(No noAtual) { 
        return noAtual == null ? -1 : 1 + Math.max(calcularAlturaRecursivo(noAtual.esquerdo), calcularAlturaRecursivo(noAtual.direito)); 
    }

    public void exibirEmOrdem() { 
        System.out.println("\n--- EM ORDEM ---"); 
        int[] indexador = {0}; 
        percursoEmOrdem(raiz, indexador); 
    }

    private void percursoEmOrdem(No noAtual, int[] indexador) { 
        if (noAtual != null) { 
            percursoEmOrdem(noAtual.esquerdo, indexador); 
            System.out.println("[" + (++indexador[0]) + "]\n" + noAtual.contato); 
            percursoEmOrdem(noAtual.direito, indexador); 
        } 
    }

    public void exibirPreOrdem() { 
        System.out.println("\n--- PRÉ-ORDEM ---"); 
        int[] indexador = {0}; 
        percursoPreOrdem(raiz, indexador); 
    }

    private void percursoPreOrdem(No noAtual, int[] indexador) { 
        if (noAtual != null) { 
            System.out.println("[" + (++indexador[0]) + "]\n" + noAtual.contato); 
            percursoPreOrdem(noAtual.esquerdo, indexador); 
            percursoPreOrdem(noAtual.direito, indexador); 
        } 
    }

    public void exibirPosOrdem() { 
        System.out.println("\n--- PÓS-ORDEM ---"); 
        int[] indexador = {0}; 
        percursoPosOrdem(raiz, indexador); 
    }

    private void percursoPosOrdem(No noAtual, int[] indexador) { 
        if (noAtual != null) { 
            percursoPosOrdem(noAtual.esquerdo, indexador); 
            percursoPosOrdem(noAtual.direito, indexador); 
            System.out.println("[" + (++indexador[0]) + "]\n" + noAtual.contato); 
        } 
    }
}
