package com.example.lab2_gtics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;


@Controller
public class TareaController {
    @GetMapping("/")
    public String home() {
        return "formulario";
    }
    @PostMapping(value="/crearBingo")
    public String CrearTarjeta(@RequestParam String tamano,
                               @RequestParam String numtarjetas){

        int tam= Integer.parseInt(tamano);
        ArrayList<String[][]> listaCartillas= new ArrayList<>();

        String [][] cartilla = new String[tam][tam];
        for(int i=0;i<numtarjetas;i++){
            for (int i = 0; i< cartilla.length; i++) {
                for (int j = 0; j < cartilla[0].length; j++) {
                    int numero = (int) (Math.random() * 99);
                    cartilla[i][j] = String.valueOf(numero);
                }
            }
            listaCartillas.add(cartilla);
        }
        @GetMapping("/juegoBingo")
        public String juegoDeBingo(Model model) {
            model.addAtribute("listaCsrtillas",listaCartillas);
            /*no funcionaba el model :c*/
            return "juego";
        }
    }




}
