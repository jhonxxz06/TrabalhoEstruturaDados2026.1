public class No {
    ListaContato contato;
    No esquerdo;
    No direito;

    public No(ListaContato contato) {
        this.contato = contato;
        this.esquerdo = null;
        this.direito = null;
    }
}
