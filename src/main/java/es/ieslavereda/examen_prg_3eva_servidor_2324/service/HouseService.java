package es.ieslavereda.examen_prg_3eva_servidor_2324.service;

import es.ieslavereda.examen_prg_3eva_servidor_2324.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService {
    @Autowired
    HouseRepository houseRepository;



}
