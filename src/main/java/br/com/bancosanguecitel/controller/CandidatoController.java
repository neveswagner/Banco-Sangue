package br.com.bancosanguecitel.controller;

import br.com.bancosanguecitel.dto.*;
import br.com.bancosanguecitel.repository.CandidatoRepository;
import br.com.bancosanguecitel.repository.ContatoRepository;
import br.com.bancosanguecitel.service.CandidatoService;
import br.com.bancosanguecitel.service.SourceDataService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Api(value = "API REST Banco de Sangue")
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidatoController {

    @Autowired
    CandidatoRepository candidatoRepository;

    @Autowired
    CandidatoService candidatoService;


    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    SourceDataService sourceDataService;


    @ApiOperation(value = "Importa Dados dos Candidatos", hidden = true)
    @RequestMapping("/carregaDados")
    public void CarregaDados() {
        sourceDataService.CarregaDados();

    }

    @ApiOperation(value = "Retornaorna uma lista de candidatos por estado UF", notes = "Lista de Candidatos por Estado")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Lista de Estados Encontrada"),})
    @GetMapping("/candidatosPorEstados")
    public ResponseEntity<List<CandidatoQuantidadePorEstadoDTO>> CandidatosPorEstado() {
        return new ResponseEntity(candidatoService.CandidatosPorEstado(), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna uma lista com o percentual de obesos por genero", notes = "Lista de Percentual de Obesos por Gênero")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Lista de Percentual de Obesos por Gênero Encontrada"),})
    @GetMapping("/percentualObesosPorSexo")
    public ResponseEntity<List<CandidatoPercentualObesoPorSexoDTO>> PercentualObesisadePorSexo() {
        return new ResponseEntity(candidatoService.PercentualObesisadePorSexo(), HttpStatus.OK);

    }

    @ApiOperation(value = "Retorna uma lista com a média de IMC por faixa de Idade", notes = "Lista de Média de IMC por Faixa de Idade")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Lista de Média de IMC por Faixa de Idade Encontrada"),})
    @GetMapping("/imcMedioPorFaixaIdade")
    public ResponseEntity<List<CandidatoImcMedioPorFaixaIdadeDTO>> ImcMedioPorFaixaIdade() {
        return new ResponseEntity(candidatoService.ImcMedioPorFaixaIdade(), HttpStatus.OK);

    }

    @ApiOperation(value = "Retorna uma lista com a média de idade por tipo sanguineo", notes = "Lista de Média de Idade por Tipo Sanguineo")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Lista de Média de Idade por Tipo Sanguineo Encontrada"),})
    @GetMapping("/mediaIdadePorTipoSanguineo")
    public ResponseEntity<List<CandidatoMediaIdadePorTipoSanguineoDTO>> MediaIdadePorTipoSanguineo() {
        return new ResponseEntity(candidatoService.MediaIdadePorTipoSanguineo(), HttpStatus.OK);

    }

    @ApiOperation(value = "Retorna uma lista de possíveis doadores por tipo sanguineo do receptor")
    @GetMapping("/possivelDoadoresPorReceptor")
    public ResponseEntity<List<CandidatoMediaIdadePorTipoSanguineoDTO>> PossivelDoadoresPorReceptor() {
        return new ResponseEntity(candidatoService.PossivelDoadoresPorReceptor(), HttpStatus.OK);


    }


}
