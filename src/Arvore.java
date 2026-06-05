public class Arvore {
    private No raiz;

    public Arvore(){
        this.raiz = null;
    }

    public void inserir(ListaContato novoContato){
        raiz = inserirRecursivo(raiz, novoContato);
    }
    private No inserirRecursivo(No atual, ListaContato novoContato) {
        if(atual == null) {
            return new No(novoContato);
        }

        int comparacao = novoContato.getNome().compareToIgnoreCase(String.valueOf(atual.contato));

        if(comparacao < 0) {
            atual.esquerdo = inserirRecursivo(atual.esquerdo, novoContato);
        }
        else if (comparacao > 0){
            atual.direito = inserirRecursivo(atual.direito, novoContato);
        }
        else {
            atual.contato = novoContato;
        }
        return atual;
    }

    public ListaContato buscarNome(String nomeProcurado) {
        return buscarRecursivo(raiz, nomeProcurado);
    }
    private ListaContato buscarRecursivo(No atual, String nomeProcurado) {
        if (atual == null) {
            return null;
        }

        int comparacao = nomeProcurado.compareToIgnoreCase(atual.contato.getNome());

        if (comparacao == 0) {
            return atual.contato;
        }
        return comparacao < 0
                ? buscarRecursivo(atual.esquerdo, nomeProcurado)
                : buscarRecursivo(atual.direito, nomeProcurado);
    }

    public void listarEmOrdemAlfabetica() {
        listarEmOrdemRecursivo(raiz);
    }

    private void listarEmOrdemRecursivo(No atual) {
        if (atual != null) {
            listarEmOrdemRecursivo(atual.esquerdo);
            System.out.println(atual.contato);
            listarEmOrdemRecursivo(atual.direito);
        }
    }

    public void listarContatosPreOrdem() {
        listarEmPreOrdemRecursivo(this.raiz);
    }

    private void listarEmPreOrdemRecursivo(No atual) {
        if (atual != null) {
            System.out.println(atual.contato);

            listarEmPreOrdemRecursivo(atual.esquerdo);

            listarEmPreOrdemRecursivo(atual.direito);
        }
    }

    public void listarContatosPosOrdem() {
        listarEmpPosOrdemRecursivo(this.raiz);
    }

    private void listarEmpPosOrdemRecursivo(No atual) {
        if (atual != null) {

            listarEmpPosOrdemRecursivo(atual.esquerdo);

            listarEmPreOrdemRecursivo(atual.direito);

            System.out.println(atual.contato);
        }
    }

}
