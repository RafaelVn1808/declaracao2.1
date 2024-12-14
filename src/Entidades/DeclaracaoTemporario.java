package Entidades;

import java.time.LocalDate;
import java.time.Period;

public class DeclaracaoTemporario extends Declaracao {

    private String cargo;

    public DeclaracaoTemporario(String nome, Integer matricula, Integer vinculo, LocalDate datainicio, LocalDate datafim, String cargo) {
        super(nome, matricula, vinculo, datainicio, datafim);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String toString() {
        Period periodo = calcularPeriodo();
        long diasTotais = calcularDiasTotais();
        StringBuilder declaracao = new StringBuilder();

        declaracao.append("\n\n\n                                                        DECLARAÇÃO DE TEMPO DE SERVIÇO \n\n\n")
                .append("Declaramos para os devidos fins que o Sr(a) " + getNome() + ", ")
                .append(" cadastrado sob a matrícula n° " + getMatricula() + "/" + getVinculo() + " foi servidor no período de ")
                .append(getDatainicioFormatada() + " a " + getDatafimFormatada() + ",\n como " + getCargo() + ", ")
                .append(" totalizando " + diasTotais + " (" + converterNumeroParaExtenso(diasTotais) + ") dias, ")
                .append("equivalentes a " + periodo.getYears() + " (" + converterNumeroParaExtenso(periodo.getYears()) + ") ano(s), ")
                .append(periodo.getMonths() + " (" + converterNumeroParaExtenso(periodo.getMonths()) + ") mês(es) e ")
                .append(periodo.getDays() + " (" + converterNumeroParaExtenso(periodo.getDays()) + ") dia(s) de tempo de serviço.\n\n")
                .append("                                                                                                           Belém, " + getCurrentDate());

        return declaracao.toString();
    }
}