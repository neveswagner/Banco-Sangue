package br.com.bancosanguecitel.dto;

public class CandidatoMediaIdadePorTipoSanguineoDTO {

    public String tipo_sanguineo;
    public Double mediaIdade;

    public CandidatoMediaIdadePorTipoSanguineoDTO(String tipo_sanguineo, Double mediaIdade) {
        this.tipo_sanguineo = tipo_sanguineo;
        this.mediaIdade = mediaIdade;
    }
}
