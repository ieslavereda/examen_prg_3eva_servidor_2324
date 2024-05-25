package es.ieslavereda.examen_prg_3eva_servidor_2324.service;

import es.ieslavereda.examen_prg_3eva_servidor_2324.repository.HouseRepository;
import es.ieslavereda.examen_prg_3eva_servidor_2324.repository.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class HouseService {
    @Autowired
    HouseRepository houseRepository;

    public House getHouseById(int id) throws SQLException{
        return houseRepository.getHouseById(id);
    }

    public List<House> getAllHouses() throws SQLException {
        return houseRepository.getAllHouses();
    }

    public House deleteHouseById(int id) throws SQLException {
        return houseRepository.deleteHouseById(id);
    }

    public House updateHouse(House house) throws SQLException {
        return houseRepository.updateHouse(house);
    }

    public House addHouse(House house) throws SQLException {
        return houseRepository.addHouse(house);
    }


}
