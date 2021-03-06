/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.backend.client.api;

import com.example.backend.client.model.Note;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-14T08:46:52.779-04:00[America/New_York]")
@Api(value = "Note", description = "the Note API")
public interface NoteApi {

    /**
     * POST /note
     * Adds a new Note.
     *
     * @param note The note to be created. (required)
     * @return OK (status code 200)
     */
    @ApiOperation(value = "", nickname = "addNote", notes = "Adds a new Note.", response = Note.class, tags={ "note", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Note.class) })
    @PostMapping(
        value = "/note",
        produces = "*/*",
        consumes = "application/json"
    )
    ResponseEntity<Note> addNote(@ApiParam(value = "The note to be created." ,required=true )   @RequestBody Note note);


    /**
     * DELETE /note/{id}
     * Deletes a note by id.
     *
     * @param id The UUID of the note to delete. (required)
     * @return OK (status code 200)
     */
    @ApiOperation(value = "", nickname = "deleteNote", notes = "Deletes a note by id.", tags={ "note", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK") })
    @DeleteMapping(
        value = "/note/{id}"
    )
    ResponseEntity<Void> deleteNote(@ApiParam(value = "The UUID of the note to delete.",required=true) @PathVariable("id") String id);


    /**
     * GET /note/{id}
     * Retrives a note by id.
     *
     * @param id The UUID of the note to retrieve. (required)
     * @return OK (status code 200)
     */
    @ApiOperation(value = "", nickname = "getNote", notes = "Retrives a note by id.", response = Note.class, tags={ "note", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Note.class) })
    @GetMapping(
        value = "/note/{id}",
        produces = "*/*"
    )
    ResponseEntity<Note> getNote(@ApiParam(value = "The UUID of the note to retrieve.",required=true) @PathVariable("id") String id);


    /**
     * GET /version
     * Returns the current API version
     *
     * @return OK (status code 200)
     */
    @ApiOperation(value = "", nickname = "getVersion", notes = "Returns the current API version", response = String.class, tags={ "note", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class) })
    @GetMapping(
        value = "/version",
        produces = "*/*"
    )
    ResponseEntity<String> getVersion();

}
