package br.com.bancosanguecitel.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "candidato")
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String rg;
    private LocalDate data_nasc;
    private String sexo;
    private String mae;
    private String pai;
    private Double altura;
    private Double peso;
    private String tipo_sanguineo;

    @OneToOne(targetEntity = Endereco.class, mappedBy = "candidato", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Endereco endereco;

    @OneToOne(targetEntity = Contato.class, mappedBy = "candidato", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Contato contato;

    public Candidato() {
    }

    public Candidato(Long id, String nome, String cpf, String rg, LocalDate data_nasc, String sexo, String mae, String pai, Double altura, Double peso, String tipo_sanguineo, Endereco endereco, Contato contato) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
        this.mae = mae;
        this.pai = pai;
        this.altura = altura;
        this.peso = peso;
        this.tipo_sanguineo = tipo_sanguineo;
        this.endereco = endereco;
        this.contato = contato;
    }

    public double getImc() {
        return this.peso / Math.pow(this.altura, 2);
    }

    public Integer getDiferencaAnos(){
        LocalDateTime currentDateAndTime = LocalDateTime.now();
        Period periodBetween = Period.between(getData_nasc(), LocalDate.from(currentDateAndTime));
        return periodBetween.getYears();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(LocalDate data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getTipo_sanguineo() {
        return tipo_sanguineo;
    }

    public void setTipo_sanguineo(String tipo_sanguineo) {
        this.tipo_sanguineo = tipo_sanguineo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }


    public void setData_nasc(String data_nasc, DateTimeFormatter formatter) {


    }
}
