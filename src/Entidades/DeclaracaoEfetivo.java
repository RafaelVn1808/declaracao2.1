package Entidades;

import java.time.LocalDate;
import java.time.Period;

public class DeclaracaoEfetivo extends Declaracao {

    private Integer numberPort;
    private LocalDate dataPtDt;
    private LocalDate dataDoe;
    private Integer numberDoe;
    private String cargo;
    private LocalDate posse;

    public DeclaracaoEfetivo(String nome, Integer matricula, Integer vinculo, LocalDate datainicio, LocalDate datafim,
                             Integer numberPort, LocalDate dataPtDt, LocalDate dataDoe, Integer numberDoe, String cargo,
                             LocalDate posse) {
        super(nome, matricula, vinculo, datainicio, datafim);
        this.numberPort = numberPort;
        this.dataPtDt = dataPtDt;
        this.dataDoe = dataDoe;
        this.numberDoe = numberDoe;
        this.cargo = cargo;
        this.posse = posse;
    }

    public DeclaracaoEfetivo(String nome, Integer matricula, Integer vinculo, LocalDate datainicio, LocalDate datafim,
                             LocalDate dataPtDt, LocalDate dataDoe, Integer numberDoe, String cargo, LocalDate posse) {
        super(nome, matricula, vinculo, datainicio, datafim);
        this.dataPtDt = dataPtDt;
        this.dataDoe = dataDoe;
        this.numberDoe = numberDoe;
        this.cargo = cargo;
        this.posse = posse;
    }

    public String dataPtDtFormatada() {
        return dataPtDt != null ? dataPtDt.format(FORMATTER) : "Data não informada";
    }

    public String dataDoeFormatada() {
        return dataDoe != null ? dataDoe.format(FORMATTER) : "Data não informada";
    }

    public String posseFormatada() {
        return posse != null ? posse.format(FORMATTER) : "Data não informada";
    }

    @Override
    public String toString() {
        Period periodo = calcularPeriodo();
        long diasTotais = calcularDiasTotais();
        StringBuilder declaracao = new StringBuilder();


        if (numberPort != null) {
            declaracao.append("\n\n\n                                                    DECLARAÇÃO DE TEMPO DE SERVIÇO \n\n\n")
                    .append("Declaramos para os devidos fins que o Sr. " + getNome() + ",")
                    .append(" cadastrado sob a matrícula n° "+ getMatricula() + "/" + getVinculo() + " é servidor Efetivo desta Policia Científica do Pará. ")
                    .append("\n Foi nomeado pela portaria nº "+ numberPort + " de " + dataPtDtFormatada() + "-GAB, publicado no diário oficial DOE "+ numberDoe  + " de " + dataDoeFormatada() + ", ")
                    .append("tomou posse e entrou em exercício do cargo de " + cargo +" em "+ posseFormatada() + ",\n conta no período compreendido de ")
                    .append( getDatainicioFormatada() + " a " + getDatafimFormatada() + " com " + calcularDiasTotais() + " (" + converterNumeroParaExtenso(calcularDiasTotais()) + " dias, ")
                    .append("equivalentes a " + periodo.getYears() + "(" + converterNumeroParaExtenso(periodo.getYears()) + ") ano(s), " +
                            periodo.getMonths() + "(" + converterNumeroParaExtenso(periodo.getMonths()) + ") mese(s) e " + periodo.getDays()
                            + "(" + converterNumeroParaExtenso(periodo.getDays()) +") dia(s) de tempo de serviço.\n\n")
                    .append("                                                                                           Belém, " + getCurrentDate());
        } else {
            declaracao.append("\n\n\n                                                    DECLARAÇÃO DE TEMPO DE SERVIÇO \n\n\n")
                    .append("Declaramos para os devidos fins que o Sr. " + getNome() + ",")
                    .append("cadastrado sob a matrícula n° "+ getMatricula() + "/" + getVinculo() + " é servidor Efetivo desta Policia Científica do Pará. ")
                    .append("\n Foi nomeado através do Decreto Governamental de  " + dataPtDtFormatada() + "publicado no diário oficial D.O.E "+ numberDoe  + " de " + dataDoeFormatada()  + ", ")
                    .append("tomou posse e entrou em exercício do cargo de " + cargo +" em "+ posseFormatada() + ",\n conta no período compreendido de ")
                    .append( getDatainicioFormatada() + " a " + getDatafimFormatada() + " com " + calcularDiasTotais() + "(" + converterNumeroParaExtenso(calcularDiasTotais()) + " dias, ")
                    .append("equivalentes a " + periodo.getYears() + " (" + converterNumeroParaExtenso(periodo.getYears()) + ") ano(s), " +
                            periodo.getMonths() + "(" + converterNumeroParaExtenso(periodo.getMonths()) + ") mese(s) e " + periodo.getDays()
                            + "(" + converterNumeroParaExtenso(periodo.getDays()) +") dia(s) de tempo de serviço.\n\n")
                    .append("                                                                                           Belém, " + getCurrentDate());

        }

        return declaracao.toString();
    }
}

