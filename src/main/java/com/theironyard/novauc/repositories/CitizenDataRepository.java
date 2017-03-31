package com.theironyard.novauc.repositories;


import com.theironyard.novauc.entities.CitizenData;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Created by souporman on 3/17/17.
 */
public interface CitizenDataRepository extends CrudRepository<CitizenData,Integer> {
    List<CitizenData> findByThreatBool(boolean threat);
    List<CitizenData> findByNraBool(boolean nra);


//
//    @Query("SELECT g FROM CitizenData g WHERE g.name LIKE ?1%")
//    List<CitizenData> findByNameStartsWith(String name);



}
