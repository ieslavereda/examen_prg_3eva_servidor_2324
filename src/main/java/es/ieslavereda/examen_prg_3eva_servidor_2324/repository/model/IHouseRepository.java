package es.ieslavereda.examen_prg_3eva_servidor_2324.repository.model;

import java.sql.SQLException;
import java.util.List;

public interface IHouseRepository {
    House getHouseById(int id) throws SQLException;
    List<House> getAllHouses() throws SQLException;
    House deleteHouseById(int id) throws SQLException;
    House updateHouse(House house) throws SQLException;
    House addHouse(House house) throws SQLException;
}
