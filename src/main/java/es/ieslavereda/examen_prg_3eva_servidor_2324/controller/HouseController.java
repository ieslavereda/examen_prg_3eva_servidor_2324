package es.ieslavereda.examen_prg_3eva_servidor_2324.controller;

import es.ieslavereda.examen_prg_3eva_servidor_2324.repository.model.House;
import es.ieslavereda.examen_prg_3eva_servidor_2324.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class HouseController {
    @Autowired
    HouseService houseService;

    @GetMapping("house/{id}")
    public ResponseEntity<?> getHouseById(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(houseService.getHouseById(id), HttpStatus.OK);
        } catch (SQLException e){
            return sendError(e);
        }
    }

    @DeleteMapping("house/{id}")
    public ResponseEntity<?> deleteHouseById(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(houseService.deleteHouseById(id), HttpStatus.OK);
        } catch (SQLException e){
            return sendError(e);
        }
    }

    @GetMapping("house/")
    public ResponseEntity<?> getAllHouses(){
        try {
            return new ResponseEntity<>(houseService.getAllHouses(), HttpStatus.OK);
        } catch (SQLException e){
            return sendError(e);
        }
    }

    @PostMapping("house/")
    public ResponseEntity<?> addHouse(@RequestBody House house){
        try {
            return new ResponseEntity<>(houseService.addHouse(house), HttpStatus.OK);
        } catch (SQLException e){
            return sendError(e);
        }
    }

    @PutMapping("house/")
    public ResponseEntity<?> updateHouse(@RequestBody House house){
        try {
            return new ResponseEntity<>(houseService.updateHouse(house), HttpStatus.OK);
        } catch (SQLException e){
            return sendError(e);
        }
    }

    private ResponseEntity<Map<String, Object>> sendError(SQLException e) {
        Map<String,Object> response = new HashMap<>();
        response.put("code", e.getErrorCode());
        response.put("message", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
