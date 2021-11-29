package br.com.bancosanguecitel.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contato")
public class Contato implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String telefone_fixo;
    private String celular;
    private String email;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="id_contato" ,nullable=false)
    private Candidato candidato;

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Contato(){

    }

    public Contato(Long id, String telefone_fixo, String celular, String email, Candidato candidato) {
        this.id = id;
        this.telefone_fixo = telefone_fixo;
        this.celular = celular;
        this.email = email;
        this.candidato = candidato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone_fixo() {
        return telefone_fixo;
    }

    public void setTelefone_fixo(String telefone_fixo) {
        this.telefone_fixo = telefone_fixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", telefone_fixo='" + telefone_fixo + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", candidato=" + candidato +
                '}';
    }
}
