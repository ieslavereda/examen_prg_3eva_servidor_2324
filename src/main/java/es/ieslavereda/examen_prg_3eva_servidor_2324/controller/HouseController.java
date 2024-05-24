package es.ieslavereda.examen_prg_3eva_servidor_2324.controller;

import es.ieslavereda.examen_prg_3eva_servidor_2324.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class HouseController {
    @Autowired
    HouseService houseService;



}
