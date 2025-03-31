package sistema_de_regas;

import sistema_de_regas.regas.*;
import sistema_de_regas.usuario.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        Tipo tipo = escolherPlanta(ler);
        if(tipo == null){
            System.out.println("Escolha invalida");
        }

        Planta planta = new Planta(tipo, "cacto", LocalDate.now().minusDays(30));
        planta.add(new Usuario());

        planta.regar();
        planta.regar();
    }
    
    private static Tipo escolherPlanta(Scanner ler) {
        System.out.println("SELECIONE O TIPO DA PLANTA A SER CADASTRADA");
        System.out.println("1. Cacto");
        System.out.println("2. Suculenta");
        System.out.println("3. Anturio");
        System.out.println("4. Filodendro");
        System.out.println("5. Zamioculca");
        System.out.println("6. Ficus");
        System.out.println("7. Costela de Adao");
        System.out.println("8. Begonia");
        System.out.println("9. Samambaia");
        System.out.println("10. Lirio da paz");
        System.out.println("11. Orquidea");
        System.out.println("12. Outro");
        
        int x = ler.nextInt();
        
        return switch (x) {
            case 1, 2 -> new Xerofita();
            case 3, 4, 5, 6, 7, 8 -> new Mesofita();
            case 9, 10, 11 -> new Hidrofita();
            default -> new naoIdentificada();
        };
    }
}