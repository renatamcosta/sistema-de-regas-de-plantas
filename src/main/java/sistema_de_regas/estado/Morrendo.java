package sistema_de_regas.estado;

import sistema_de_regas.Planta;

import java.time.LocalDate;

public class Morrendo implements Estado{
    public Morrendo(Planta planta) {
        this.planta = planta;
        planta.notifica("Planta esta morrendo! Atenção!");
    }
    private Planta planta;
    @Override
    public void regar(){
        System.out.println("Regou");
        planta.trocaEstado(new Seca(planta));
        planta.setDataDaUltimaRega(LocalDate.now());
    }

}
