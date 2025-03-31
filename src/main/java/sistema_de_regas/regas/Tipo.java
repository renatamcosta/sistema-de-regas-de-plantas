package sistema_de_regas.regas;

import java.time.LocalDate;

public interface Tipo {
    void regar();
    void RegistrarUltimaRega(LocalDate ultimaRega);
    
    LocalDate proximaRega();
}
