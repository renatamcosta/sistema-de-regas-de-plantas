package sistema_de_regas.usuario;

public interface Observable {
    void add(Observer observer);
    void remove(Observer observer);
    void notifica(String mensagem);
}
