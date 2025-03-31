package sistema_de_regas;

import sistema_de_regas.estado.Estado;
import sistema_de_regas.estado.Morrendo;
import sistema_de_regas.estado.Saudavel;
import sistema_de_regas.estado.Seca;
import sistema_de_regas.regas.Tipo;
import sistema_de_regas.usuario.Observable;
import sistema_de_regas.usuario.Observer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Planta implements Observable {
    private Tipo tipoPlanta;
    private  String nome;
    private Estado estado;
    private LocalDate dataDaUltimaRega;
    private List<Observer> observers = new ArrayList<>();

    public Planta(Tipo tipoPlanta, String nome, LocalDate dataDaUltimaRega) {
        this.tipoPlanta = tipoPlanta;
        this.nome = nome;
        this.dataDaUltimaRega = dataDaUltimaRega;

        var diasSemRega = dataDaUltimaRega.until(LocalDate.now(), ChronoUnit.DAYS);

        if (diasSemRega > 15) {
            this.estado = new Morrendo(this);
        } else if (diasSemRega > 5) {
            this.estado = new Seca(this);
        } else {
            this.estado = new Saudavel(this);
        }
    }

    public void trocaEstado(Estado estado){
        this.estado = estado;
    }
    public Tipo getTipoPlanta() {
        return tipoPlanta;
    }

    public LocalDate getDataDaUltimaRega() {
        return dataDaUltimaRega;
    }

    public void setDataDaUltimaRega(LocalDate data) {
        dataDaUltimaRega = data;
    }

    public void regar() {
        this.estado.regar();
    }

    @Override
    public void add(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifica(String mensagem) {
        this.observers.forEach(obs -> obs.receberUpdate(mensagem));
    }
}
