package sistema_de_regas.estado;

import sistema_de_regas.Planta;

import java.time.LocalDate;

public class Saudavel implements Estado{
    public Saudavel(Planta planta) {
        this.planta = planta;
        planta.notifica("Planta esta Saúdavel! Muito bem!");
    }

    private Planta planta;
    @Override
    public void regar(){
        System.out.println("Regou");
        planta.setDataDaUltimaRega(LocalDate.now());
    }
}
