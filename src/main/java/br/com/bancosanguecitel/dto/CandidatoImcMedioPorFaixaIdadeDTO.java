package br.com.bancosanguecitel.dto;

public class CandidatoImcMedioPorFaixaIdadeDTO {

    public String faixaIdade;
    public Double mediaIMC;

    public CandidatoImcMedioPorFaixaIdadeDTO(String faixaIdade, double round) {
        this.faixaIdade = faixaIdade;
        this.mediaIMC = round;
    }

}
