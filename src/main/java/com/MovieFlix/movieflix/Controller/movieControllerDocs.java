package com.MovieFlix.movieflix.Controller;

import com.MovieFlix.movieflix.Controller.Request.movieRequest;
import com.MovieFlix.movieflix.Controller.Response.movieResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "Movie", description = "Recurso responsavel pelo gerenciamento dos filmes.")
public interface movieControllerDocs {

    @Operation(summary = "Buscar filmes", description = "Método responsável por retornar todos os filmes cadastrados.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna todos os filmes cadastrados.",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = movieResponse.class))))
    })
    ResponseEntity<List<movieResponse>> findAllMovies();

    @Operation(summary = "Buscar filme por ID", description = "Método responsável por retornar um filme específico pelo seu ID.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Filme encontrado com sucesso.",
                    content = @Content(schema = @Schema(implementation = movieResponse.class))),
            @ApiResponse(responseCode = "404", description = "Filme não encontrado.")
    })
    ResponseEntity<movieResponse> findMovieById(@PathVariable Long id);

    @Operation(summary = "Buscar filmes por categoria", description = "Método responsável por retornar filmes de uma categoria específica.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna a lista de filmes da categoria.",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = movieResponse.class))))
    ResponseEntity<List<movieResponse>> findMoviesByCategoryId(@RequestParam Long category);

    @Operation(summary = "Salvar filme", description = "Método responsavel por realizar o salvamento de um novo filme",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Filme salvo com sucesso",
                    content = @Content(schema = @Schema(implementation = movieResponse.class))),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados.")
    })
    ResponseEntity<movieResponse> createMovie(@RequestBody movieRequest request);

    @Operation(summary = "Atualizar filme", description = "Método responsável por atualizar os dados de um filme existente.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Filme atualizado com sucesso.",
                    content = @Content(schema = @Schema(implementation = movieResponse.class))),
            @ApiResponse(responseCode = "404", description = "Filme não encontrado.")
    })
    ResponseEntity<movieResponse> updateMovie(@RequestBody movieRequest request);

    @Operation(summary = "Deletar filme", description = "Método responsável por remover um filme do banco de dados.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Filme deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Filme não encontrado.")
    })
    ResponseEntity<Void> deleteMovie(@PathVariable Long id);
}
