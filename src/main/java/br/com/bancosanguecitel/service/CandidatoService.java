package br.com.bancosanguecitel.service;

import br.com.bancosanguecitel.dto.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CandidatoService {

    List<CandidatoQuantidadePorEstadoDTO> CandidatosPorEstado();

    List<CandidatoPercentualObesoPorSexoDTO> PercentualObesisadePorSexo();

    List<CandidatoImcMedioPorFaixaIdadeDTO> ImcMedioPorFaixaIdade();

    List<CandidatoMediaIdadePorTipoSanguineoDTO> MediaIdadePorTipoSanguineo();

    List<CandidatoPossivelDoadoresPorReceptorDTO> PossivelDoadoresPorReceptor();


}
