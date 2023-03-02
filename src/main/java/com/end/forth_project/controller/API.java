package com.end.forth_project.controller;

import com.end.forth_project.entity.car.Car;
import com.end.forth_project.entity.car.repo.CarRepository;
import com.end.forth_project.entity.token.Token;
import com.end.forth_project.entity.token.repo.TokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
public class API {
    private final CarRepository carRepository;
    private final TokenRepository tokenRepository;

//    @Autowired
//    public API(CarRepository carRepository, TokenRepository tokenRepository) {
//        this.carRepository = carRepository;
//        this.tokenRepository = tokenRepository;
//    }

    @PostMapping(path = "/car/create")
    public void createCar(@RequestBody Car car){
        carRepository.save(car);
    }

    @PostMapping(path = "/token/create")
    public void createToken(@RequestBody Token token){
        tokenRepository.save(token);
    }

    @GetMapping(path = "/car/read")
    public ResponseEntity readCar(){
        return new ResponseEntity<>(carRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/token/read")
    public ResponseEntity readToken(){
        return new ResponseEntity<>(tokenRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(path = "/car/update/{id}")
    public void updateCar(@RequestBody Car carr,@RequestParam Long id){
        Car car = carRepository.findById(id).get();
        car.setName(carr.getName());
        carRepository.save(car);
    }

    @PutMapping(path = "/car/update/{token}")
    public void updateToken(@RequestBody Token token, @RequestParam String token2){
        Token token1 = tokenRepository.findById(token2).get();
        token1.setToken(token.getToken());
        tokenRepository.save(token1);
    }

}
