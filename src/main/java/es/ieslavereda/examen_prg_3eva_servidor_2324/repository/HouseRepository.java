package es.ieslavereda.examen_prg_3eva_servidor_2324.repository;

import es.ieslavereda.examen_prg_3eva_servidor_2324.repository.model.House;
import es.ieslavereda.examen_prg_3eva_servidor_2324.repository.model.IHouseRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HouseRepository implements IHouseRepository {


    @Override
    public House getHouseById(int id) throws SQLException {
        House house = null;
        String query = "select * from house where id=?";
        try(Connection connection=MyDataSource.getMySQLDataSorce().getConnection();
            PreparedStatement ps = connection.prepareCall(query)
        ){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                house = new House(rs.getInt(1),rs.getString(2),rs.getInt(3));
            }
        }
        return house;
    }

    @Override
    public List<House> getAllHouses() throws SQLException {
        List<House> houses = new ArrayList<>();
        String query = "{call getAllHouses()}";
        try(Connection connection=MyDataSource.getMySQLDataSorce().getConnection();
            CallableStatement cs = connection.prepareCall(query)){
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                houses.add(new House(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
        }
        return houses;
    }

    @Override
    public House deleteHouseById(int id) throws SQLException {
        House house = getHouseById(id);
        if (house!=null){
            String query = "delete from house where id=?";
            try(Connection connection=MyDataSource.getMySQLDataSorce().getConnection();
                PreparedStatement ps = connection.prepareCall(query)
            ){
                ps.setInt(1,id);
                ps.executeUpdate();
            }
        }
        return house;
    }

    @Override
    public House updateHouse(House house) throws SQLException {
        House house1 = getHouseById(house.getId());
        if (house1!=null){
            String query = "update house set name = ?, points = ? where id=?";
            try(Connection connection=MyDataSource.getMySQLDataSorce().getConnection();
                PreparedStatement ps = connection.prepareCall(query)
            ){
                ps.setString(1, house.getName());
                ps.setInt(2,house.getPoints());
                ps.setInt(3,house.getId());
                ps.executeUpdate();
                house1.setName(house.getName());
                house1.setPoints(house.getPoints());
            }
        }
        return house1;
    }

    @Override
    public House addHouse(House house) throws SQLException {
        String query = "{?=call createHouse(?,?)}";
        House house1 = null;
        try(Connection connection=MyDataSource.getMySQLDataSorce().getConnection();
            CallableStatement cs = connection.prepareCall(query)){
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setString(2, house.getName());
            cs.setInt(3,house.getPoints());
            cs.execute();
            house1 = new House(cs.getInt(1),house.getName(),house.getPoints());
        }
        return house1;
    }
}
