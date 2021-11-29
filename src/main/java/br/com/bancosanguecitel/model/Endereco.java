package br.com.bancosanguecitel.model;

import br.com.bancosanguecitel.dto.CandidatoQuantidadePorEstadoDTO;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String cep;
    private  String endereco;
    private  Integer numero;
    private  String bairro;
    private  String cidade;
    private  String estado;


      @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
      @JoinColumn(name="id_candidato" ,nullable=false)
      private Candidato candidato;

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Endereco() {}

    public Endereco(Long id, String cep, String endereco, Integer numero, String bairro, String cidade, String estado, Candidato candidato) {
        this.id = id;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.candidato = candidato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String rua) {
        this.endereco = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", candidato=" + candidato +
                '}';
    }
}
