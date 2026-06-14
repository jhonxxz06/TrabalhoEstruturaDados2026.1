public class Contato {
    private final String nome, telefone, email, cidade;

    public Contato(String nome, String telefone, String email, String cidade) {
        this.nome = nome; 
        this.telefone = telefone; 
        this.email = email; 
        this.cidade = cidade;
    }

    public String getNome() { return nome; }
    
    @Override
    public String toString() {
        return String.format("Nome    : %s\nTelefone: %s\nE-mail  : %s\nCidade  : %s\n", nome, telefone, email, cidade);
    }
}
