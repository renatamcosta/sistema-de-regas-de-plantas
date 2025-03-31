package sistema_de_regas.regas;

import java.time.LocalDate;

public class naoIdentificada implements Tipo {
    private LocalDate ultimaRega;
    private final int periodoEntreRegas = 7; //FAZER METODO PARA CALCULAR DIAS DE ACORDO COM O AMBIENTE
    
    @Override
    public void regar() {
        ultimaRega = LocalDate.now();
    }

    @Override
    public void RegistrarUltimaRega(LocalDate ultimaRega) {
        this.ultimaRega = ultimaRega;
    }

    @Override
    public LocalDate proximaRega() {
        return ultimaRega.plusDays(periodoEntreRegas);
    }
    
}
