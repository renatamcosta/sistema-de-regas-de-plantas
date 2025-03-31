package sistema_de_regas.estado;

import sistema_de_regas.Planta;

import java.time.LocalDate;

public class Seca implements Estado{

    public Seca(Planta planta) {
        this.planta = planta;
        planta.notifica("Planta esta seca! Atenção!");
    }
    private Planta planta;
    @Override
    public void regar(){
        System.out.println("Regou");
        planta.trocaEstado(new Saudavel(planta));
        planta.setDataDaUltimaRega(LocalDate.now());
    }
}
