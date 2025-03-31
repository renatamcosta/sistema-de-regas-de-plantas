package sistema_de_regas.usuario;

public class Usuario implements Observer {

    @Override
    public void receberUpdate(String mensagem) {
        System.out.println(mensagem);
    }
}
