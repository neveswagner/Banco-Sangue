package br.com.bancosanguecitel.service.impl;

import br.com.bancosanguecitel.dto.*;
import br.com.bancosanguecitel.model.Candidato;
import br.com.bancosanguecitel.model.Endereco;
import br.com.bancosanguecitel.repository.CandidatoRepository;
import br.com.bancosanguecitel.repository.EnderecoRepository;
import br.com.bancosanguecitel.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CandidatoServiceImpl implements CandidatoService {

    @Autowired
    CandidatoRepository candidatoRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Override
    public List<CandidatoQuantidadePorEstadoDTO> CandidatosPorEstado() {
        List<Endereco> estados = enderecoRepository.findAll();

        List<CandidatoQuantidadePorEstadoDTO> candidatoQuantidadePorEstadoDTO = new ArrayList<>();

        Map<String, Long> countEstado = estados.stream()
                .collect(Collectors.groupingBy(c -> c.getEstado(), Collectors.counting()));

        countEstado.forEach((estado, quantidade) -> {
            candidatoQuantidadePorEstadoDTO.add(new CandidatoQuantidadePorEstadoDTO(estado, quantidade));
        });
        return candidatoQuantidadePorEstadoDTO;
    }

    @Override
    public List<CandidatoPercentualObesoPorSexoDTO> PercentualObesisadePorSexo() {
        List<Candidato> candidatos = candidatoRepository.findAll();

        double percentualObesosPorSexoTotalObesos = candidatos.stream()
                .filter(c -> (c.getImc() > 30)).count();

        double percentualObesosPorSexoMasculino = candidatos.stream()
                .filter(c -> (c.getSexo().equals("Masculino") && c.getImc() > 30)).count();

        double percentualObesosPorSexoFeminino = candidatos.stream()
                .filter(c -> (c.getSexo().equals("Feminino") && c.getImc() > 30)).count();

        if (percentualObesosPorSexoTotalObesos > 0) {
            percentualObesosPorSexoMasculino = percentualObesosPorSexoMasculino * 100 / percentualObesosPorSexoTotalObesos;
            percentualObesosPorSexoFeminino = percentualObesosPorSexoFeminino * 100 / percentualObesosPorSexoTotalObesos;
        }

        List<CandidatoPercentualObesoPorSexoDTO> candidatoPercentualObesoPorSexoDTOS = new ArrayList<>();
        candidatoPercentualObesoPorSexoDTOS.add(new CandidatoPercentualObesoPorSexoDTO("Masculino", Math.round(percentualObesosPorSexoMasculino)));
        candidatoPercentualObesoPorSexoDTOS.add(new CandidatoPercentualObesoPorSexoDTO("Feminino", Math.round(percentualObesosPorSexoFeminino)));

        return  candidatoPercentualObesoPorSexoDTOS;
    }

    @Override
    public List<CandidatoImcMedioPorFaixaIdadeDTO> ImcMedioPorFaixaIdade() {
        List<Candidato> candidatos = candidatoRepository.findAll();


        double mediaIdadeEntre0A10Anos = candidatos.stream()
                .filter(c -> (c.getDiferencaAnos() >= 0 && c.getDiferencaAnos() <= 10))
                .mapToDouble(c -> c.getImc()).average().orElse(0.0);

        double mediaIdadeEntre11A20Anos = candidatos.stream()
                .filter(c -> (c.getDiferencaAnos() >= 11 && c.getDiferencaAnos() <= 20))
                .mapToDouble(c -> c.getImc()).average().orElse(0.0);

        double mediaIdadeEntre21A30Anos = candidatos.stream()
                .filter(c -> (c.getDiferencaAnos() >= 21 && c.getDiferencaAnos() <= 30))
                .mapToDouble(c -> c.getImc()).average().orElse(0.0);

        double mediaIdadeEntre31A40Anos = candidatos.stream()
                .filter(c -> (c.getDiferencaAnos() >= 31 && c.getDiferencaAnos() <= 40))
                .mapToDouble(c -> c.getImc()).average().orElse(0.0);

        double mediaIdadeEntre41A50Anos = candidatos.stream()
                .filter(c -> (c.getDiferencaAnos() >= 41 && c.getDiferencaAnos() <= 50))
                .mapToDouble(c -> c.getImc()).average().orElse(0.0);

        double mediaIdadeEntre51A60Anos = candidatos.stream()
                .filter(c -> (c.getDiferencaAnos() >= 51 && c.getDiferencaAnos() <= 60))
                .mapToDouble(c -> c.getImc()).average().orElse(0.0);

        double mediaIdadeEntre61A69Anos = candidatos.stream()
                .filter(c -> (c.getDiferencaAnos() >= 61 && c.getDiferencaAnos() <= 70))
                .mapToDouble(c -> c.getImc()).average().orElse(0.0);

        List<CandidatoImcMedioPorFaixaIdadeDTO> candidatoImcMedioPorFaixaIdadeDTOS = new ArrayList<>();
        candidatoImcMedioPorFaixaIdadeDTOS.add(new CandidatoImcMedioPorFaixaIdadeDTO("0 a 10", Math.round(mediaIdadeEntre0A10Anos)));
        candidatoImcMedioPorFaixaIdadeDTOS.add(new CandidatoImcMedioPorFaixaIdadeDTO("11 a 20", Math.round(mediaIdadeEntre11A20Anos)));
        candidatoImcMedioPorFaixaIdadeDTOS.add(new CandidatoImcMedioPorFaixaIdadeDTO("21 a 30", Math.round(mediaIdadeEntre21A30Anos)));
        candidatoImcMedioPorFaixaIdadeDTOS.add(new CandidatoImcMedioPorFaixaIdadeDTO("31 a 40", Math.round(mediaIdadeEntre31A40Anos)));
        candidatoImcMedioPorFaixaIdadeDTOS.add(new CandidatoImcMedioPorFaixaIdadeDTO("41 a 50", Math.round(mediaIdadeEntre41A50Anos)));
        candidatoImcMedioPorFaixaIdadeDTOS.add(new CandidatoImcMedioPorFaixaIdadeDTO("51 a 60", Math.round(mediaIdadeEntre51A60Anos)));
        candidatoImcMedioPorFaixaIdadeDTOS.add(new CandidatoImcMedioPorFaixaIdadeDTO("61 a 69", Math.round(mediaIdadeEntre61A69Anos)));

        return candidatoImcMedioPorFaixaIdadeDTOS;

    }

    @Override
    public List<CandidatoMediaIdadePorTipoSanguineoDTO> MediaIdadePorTipoSanguineo() {
        List<Candidato> candidatos = candidatoRepository.findAll();
        List<CandidatoMediaIdadePorTipoSanguineoDTO> candidatoMediaIdadePorTipoSanguineoDTOS = new ArrayList<>();

        Map<String, Double> mediaIdadePorTipoSanguineo = candidatos.stream()
                .collect(Collectors.groupingBy(Candidato::getTipo_sanguineo, Collectors.averagingInt(c -> c.getDiferencaAnos())));

        mediaIdadePorTipoSanguineo.forEach((tipo_sanguineo, mediaIdade) -> {
            candidatoMediaIdadePorTipoSanguineoDTOS.add(new CandidatoMediaIdadePorTipoSanguineoDTO(tipo_sanguineo, (double) Math.round(mediaIdade)));
        });
        return candidatoMediaIdadePorTipoSanguineoDTOS;
    }

    @Override
    public List<CandidatoPossivelDoadoresPorReceptorDTO> PossivelDoadoresPorReceptor() {
        List<Candidato> candidatos = candidatoRepository.findAll();
        List<CandidatoPossivelDoadoresPorReceptorDTO> candidatoPossivelDoadoresPorReceptorDTOS = new ArrayList<>();


        Long APositivo = candidatos.stream()
                .filter(c -> c.getDiferencaAnos() >= 16 &&
                        c.getDiferencaAnos() <= 69 &&
                        c.getPeso() >= 50.00 &&
                        (c.getTipo_sanguineo().equals("A+") || c.getTipo_sanguineo().equals("AB+"))).count();

        Long ANegativo = candidatos.stream()
                .filter(c -> c.getDiferencaAnos() >= 16 &&
                        c.getDiferencaAnos() <= 69 &&
                        c.getPeso() >= 50.00 &&
                        (c.getTipo_sanguineo().equals("A+") || c.getTipo_sanguineo().equals("A-") || c.getTipo_sanguineo().equals("AB+") || c.getTipo_sanguineo().equals("AB-"))).count();

        Long BPositivo = candidatos.stream()
                .filter(c -> c.getDiferencaAnos() >= 16 &&
                        c.getDiferencaAnos() <= 69 &&
                        c.getPeso() >= 50.00 &&
                        (c.getTipo_sanguineo().equals("B+") || c.getTipo_sanguineo().equals("AB+"))).count();

        Long BNegativo = candidatos.stream()
                .filter(c -> c.getDiferencaAnos() >= 16 &&
                        c.getDiferencaAnos() <= 69 &&
                        c.getPeso() >= 50.00 &&
                        (c.getTipo_sanguineo().equals("B+") || c.getTipo_sanguineo().equals("B-") || c.getTipo_sanguineo().equals("AB+") || c.getTipo_sanguineo().equals("AB-"))).count();

        Long ABPositivo = candidatos.stream()
                .filter(c -> c.getDiferencaAnos() >= 16 &&
                        c.getDiferencaAnos() <= 69 &&
                        c.getPeso() >= 50.00 &&
                        (c.getTipo_sanguineo().equals("AB+"))).count();

        Long ABNegativo = candidatos.stream()
                .filter(c -> c.getDiferencaAnos() >= 16 &&
                        c.getDiferencaAnos() <= 69 &&
                        c.getPeso() >= 50.00 &&
                        (c.getTipo_sanguineo().equals("AB+") || c.getTipo_sanguineo().equals("AB-"))).count();

        Long OPositivo = candidatos.stream()
                .filter(c -> c.getDiferencaAnos() >= 16 &&
                        c.getDiferencaAnos() <= 69 &&
                        c.getPeso() >= 50.00 &&
                        (c.getTipo_sanguineo().equals("A+") || c.getTipo_sanguineo().equals("B+") || c.getTipo_sanguineo().equals("O+") || c.getTipo_sanguineo().equals("AB+"))).count();

        Long ONegativo = candidatos.stream()
                .filter(c -> c.getDiferencaAnos() >= 16 &&
                        c.getDiferencaAnos() <= 69 &&
                        c.getPeso() >= 50.00 &&
                        (c.getTipo_sanguineo().equals("A+") || c.getTipo_sanguineo().equals("B+") || c.getTipo_sanguineo().equals("O+") || c.getTipo_sanguineo().equals("AB+") ||
                                c.getTipo_sanguineo().equals("A-") || c.getTipo_sanguineo().equals("B-") || c.getTipo_sanguineo().equals("O-") || c.getTipo_sanguineo().equals("AB-"))).count();

        candidatoPossivelDoadoresPorReceptorDTOS.add(new CandidatoPossivelDoadoresPorReceptorDTO("A +", APositivo));
        candidatoPossivelDoadoresPorReceptorDTOS.add(new CandidatoPossivelDoadoresPorReceptorDTO("A -", ANegativo));
        candidatoPossivelDoadoresPorReceptorDTOS.add(new CandidatoPossivelDoadoresPorReceptorDTO("B +", BPositivo));
        candidatoPossivelDoadoresPorReceptorDTOS.add(new CandidatoPossivelDoadoresPorReceptorDTO("B -", BNegativo));
        candidatoPossivelDoadoresPorReceptorDTOS.add(new CandidatoPossivelDoadoresPorReceptorDTO("AB +", ABPositivo));
        candidatoPossivelDoadoresPorReceptorDTOS.add(new CandidatoPossivelDoadoresPorReceptorDTO("AB -", ABNegativo));
        candidatoPossivelDoadoresPorReceptorDTOS.add(new CandidatoPossivelDoadoresPorReceptorDTO("O +", OPositivo));
        candidatoPossivelDoadoresPorReceptorDTOS.add(new CandidatoPossivelDoadoresPorReceptorDTO("O -", ONegativo));

        return candidatoPossivelDoadoresPorReceptorDTOS;

    }




}
