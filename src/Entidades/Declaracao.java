package Entidades;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Declaracao {

    protected static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String nome;
    private Integer matricula;
    private Integer vinculo;
    private LocalDate datainicio;
    private LocalDate datafim;

    public Declaracao() {}

    public Declaracao(String nome, Integer matricula, Integer vinculo, LocalDate datainicio, LocalDate datafim) {
        this.nome = nome;
        this.matricula = matricula;
        this.vinculo = vinculo;
        this.datainicio = datainicio;
        this.datafim = datafim;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getMatricula() { return matricula; }
    public void setMatricula(Integer matricula) { this.matricula = matricula; }

    public Integer getVinculo() { return vinculo; }
    public void setVinculo(Integer vinculo) { this.vinculo = vinculo; }

    public LocalDate getDatainicio() { return datainicio; }
    public void setDatainicio(LocalDate datainicio) { this.datainicio = datainicio; }

    public LocalDate getDatafim() { return datafim; }
    public void setDatafim(LocalDate datafim) { this.datafim = datafim; }


    public String getDatainicioFormatada() {
        return datainicio != null ? datainicio.format(FORMATTER) : "Data não informada";
    }

    public String getDatafimFormatada() {
        return datafim != null ? datafim.format(FORMATTER) : "Data não informada";
    }

    public long calcularDiasTotais() {
        return ChronoUnit.DAYS.between(datainicio, datafim);
    }

    public Period calcularPeriodo() {
        return Period.between(datainicio, datafim);
    }

    public static String converterNumeroParaExtenso(long numero) {
        if (numero == 0) return "zero";

        String[] unidades = {"", "um", "dois", "três", "quatro", "cinco",
                "seis", "sete", "oito", "nove"};
        String[] dezenas = {"", "", "vinte", "trinta", "quarenta", "cinquenta",
                "sessenta", "setenta", "oitenta", "noventa"};
        String[] especiais = {"dez", "onze", "doze", "treze", "quatorze", "quinze",
                "dezesseis", "dezessete", "dezoito", "dezenove"};
        String[] centenas = {"", "cem", "duzentos", "trezentos", "quatrocentos", "quinhentos",
                "seiscentos", "setecentos", "oitocentos", "novecentos"};

        StringBuilder resultado = new StringBuilder();

        if (numero >= 1000) {
            long milhar = numero / 1000;
            resultado.append(converterNumeroParaExtenso(milhar)).append(" mil");
            numero %= 1000;
            if (numero > 0) resultado.append(" e ");
        }

        if (numero >= 100) {
            long centena = numero / 100;
            if (centena == 1 && numero % 100 == 0) {
                resultado.append("cem");
            } else {
                resultado.append(centenas[(int) centena]);
            }
            numero %= 100;
            if (numero > 0) resultado.append(" e ");
        }

        if (numero >= 20) {
            long dezena = numero / 10;
            resultado.append(dezenas[(int) dezena]);
            numero %= 10;
            if (numero > 0) resultado.append(" e ");
        } else if (numero >= 10) {
            resultado.append(especiais[(int) (numero - 10)]);
            numero = 0;
        }

        if (numero > 0) {
            resultado.append(unidades[(int) numero]);
        }

        return resultado.toString().trim();
    }

    public String getCurrentDate() {
        return LocalDate.now().format(FORMATTER);
    }
}
