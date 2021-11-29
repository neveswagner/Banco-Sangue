package br.com.bancosanguecitel.dto;

public class CandidatoPossivelDoadoresPorReceptorDTO {
    public String tipo_sanguineo;
    public Long quantidadePossivelDoadores;

    public CandidatoPossivelDoadoresPorReceptorDTO(String tipo_sanguineo, Long quantidadePossivelDoadores) {
        this.tipo_sanguineo = tipo_sanguineo;
        this.quantidadePossivelDoadores = quantidadePossivelDoadores;
    }
}
