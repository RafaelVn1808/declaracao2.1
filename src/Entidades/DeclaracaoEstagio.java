package Entidades;

import java.time.LocalDate;


public class DeclaracaoEstagio extends Declaracao {

    private String curso;

    public DeclaracaoEstagio(String nome, Integer matricula, Integer vinculo, LocalDate datainicio, LocalDate datafim, String curso) {
        super(nome, matricula, vinculo, datainicio, datafim);
        this.curso = curso;
    }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public long calcularHorasTotais() {
        long diasTotais = calcularDiasTotais();
        return (long) ((diasTotais / 30.0) * 120);
    }

    @Override
    public String toString() {
        long horasTotais = calcularHorasTotais();
        StringBuilder declaracao = new StringBuilder();

        declaracao.append("\n\n\n                                         DECLARAÇÃO DE CARGA HORÁRIA DE ESTÁGIO\n\n\n")
                .append("Declaramos para os devidos fins que o(a) estagiário(a) " + getNome() + " matriculado no curso de " + getCurso() + ", \n ")
                .append("cadastrado sob matrícula " + getMatricula() + "/" + getVinculo() + ", no período de ")
                .append(getDatainicioFormatada() + " a " + getDatafimFormatada() + ", exerceu suas atividades ")
                .append("totalizando " + horasTotais + " (" + converterNumeroParaExtenso(horasTotais) + ") horas de estagio nesta Autarquia.\n\n")
                .append("                                                                                                Belém, " + getCurrentDate());

        return declaracao.toString();
    }
}
