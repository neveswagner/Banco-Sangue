package br.com.bancosanguecitel.service.impl;

import br.com.bancosanguecitel.dto.CandidatoSourceDataDTO;
import br.com.bancosanguecitel.model.Candidato;
import br.com.bancosanguecitel.model.Contato;
import br.com.bancosanguecitel.model.Endereco;
import br.com.bancosanguecitel.repository.CandidatoRepository;
import br.com.bancosanguecitel.repository.ContatoRepository;
import br.com.bancosanguecitel.repository.EnderecoRepository;
import br.com.bancosanguecitel.service.SourceDataService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Service
public class SourceDataServiceImpl implements SourceDataService {

    @Autowired
    CandidatoRepository candidatoRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ContatoRepository contatoRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void CarregaDados() {

        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.json"));
            CandidatoSourceDataDTO[] candidatoDto = gson.fromJson(br, CandidatoSourceDataDTO[].class);
            for (CandidatoSourceDataDTO i : candidatoDto) {

                Candidato candidato = new Candidato();
                Endereco endereco = new Endereco();
                Contato contato = new Contato();

                candidato.setNome(i.getNome());
                candidato.setCpf(i.getCpf());
                candidato.setRg(i.getRg());
                candidato.setData_nasc(LocalDate.parse(i.getData_nasc(), formatter));
                candidato.setSexo(i.getSexo());
                candidato.setMae(i.getMae());
                candidato.setPai(i.getPai());
                candidato.setAltura(i.getAltura());
                candidato.setPeso(i.getPeso());
                candidato.setTipo_sanguineo(i.getTipo_sanguineo());


                endereco.setCandidato(candidato);
                endereco.setCep(i.getCep());
                endereco.setEndereco(i.getEndereco());
                endereco.setNumero(i.getNumero());
                endereco.setBairro(i.getBairro());
                endereco.setCidade(i.getCidade());
                endereco.setEstado(i.getEstado());


                contato.setCandidato(candidato);
                contato.setTelefone_fixo(i.getTelefone_fixo());
                contato.setCelular(i.getCelular());
                contato.setEmail(i.getEmail());

                candidatoRepository.save(candidato);
                enderecoRepository.save(endereco);
                contatoRepository.save(contato);

            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

}
