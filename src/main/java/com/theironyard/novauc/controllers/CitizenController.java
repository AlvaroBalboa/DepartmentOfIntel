package com.theironyard.novauc.controllers;

import com.theironyard.novauc.entities.CitizenData;
import com.theironyard.novauc.repositories.CitizenDataRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Created by souporman on 3/17/17.
 */
@RestController
@Api(value="citizenArchive", description="Operations pertaining to the threat factors in citizens")
public class CitizenController {

    @Autowired
    CitizenDataRepository citizenData;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String threat,String nra, String search) {
        List<CitizenData> purchaseList;
        if (threat!=null) {
            purchaseList = citizenData.findByThreatBool(Boolean.valueOf(threat));
            model.addAttribute("citizens", purchaseList);
        }else if(nra!=null){
            purchaseList = citizenData.findByNraBool(Boolean.valueOf(nra));
            model.addAttribute("citizens", purchaseList);
        }else if(search!=null){
//            purchaseList = citizenData.findByNameStartsWith(search);
//            model.addAttribute("citizens", purchaseList);
        }else {
            purchaseList = (List) citizenData.findAll();
            model.addAttribute("citizens", purchaseList);
        }
        return "home.html";
    }

    //THESE ARE THE BASIC 3 THAT ARE GETTING AND POSTING AND PUTTING/REPLACING
    @RequestMapping(path = "/citizen", method = RequestMethod.GET)
    public List<CitizenData> getCitizens() {
        return (List<CitizenData>) citizenData.findAll();
    }

    @RequestMapping(path = "/citizen", method = RequestMethod.POST)
    public void addCitizen(@RequestBody CitizenData citizen) {
        citizenData.save(citizen);
    }
    @RequestMapping(path = "/citizen", method = RequestMethod.PUT)
    public void updateCitizen(@RequestBody CitizenData citizen) {
        citizenData.save(citizen);
    }

    @RequestMapping(path = "/citizen/{id}", method = RequestMethod.DELETE)
    public void deleteCitizen(@PathVariable("id") int id) {
        citizenData.delete(id);
    }

    @RequestMapping(path = "/citizen/{id}", method = RequestMethod.GET)
    public CitizenData getCitizen(@PathVariable("id") int id) {
        return citizenData.findOne(id);
    }

    @PostConstruct
    void enterCitizens() throws IOException {
        Path pathToCitizen = Paths.get("citizen.csv");
        Scanner citizenReader = new Scanner(pathToCitizen);
        if(citizenData.count()==0) {
            while (citizenReader.hasNext()) {
                String lineC = citizenReader.nextLine();
                String[] attributes = lineC.split(",");
                CitizenData citizen = new CitizenData(attributes[0].trim(), attributes[1].trim(), Boolean.valueOf(attributes[2].trim()), Boolean.valueOf(attributes[3].trim()), Integer.parseInt(attributes[4].trim()));
                citizenData.save(citizen);
            }
        }
    }


}
