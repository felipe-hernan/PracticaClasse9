
package com.clase.ClaseCurso.Controller;

import com.clase.ClaseCurso.Cliente.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {
    @GetMapping
    public String presentacion(){
        return "Clase de practica 9";
    }
    
    
    @GetMapping("/hola")
    public String decirHola(@RequestParam String nombre,
                                            @RequestParam int edad,
                                            @RequestParam String profesion){
        return "Hello World. Tu nombre es: "+nombre+" Tu edad es: "+edad+" Tu profesion es: "+profesion;
    }
    
    @PostMapping("/cliente")
    public void nuevoCliente(@RequestBody Cliente cli){
            System.out.println("Datos cliente: "+cli.getNombre()+" Apellido: "+cli.getApellido());
    }
    
    @GetMapping("/cliente/traer")
    @ResponseBody
    public List<Cliente> traerClientes(){
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(new Cliente(1L,"Dario","Posadas"));
        listaClientes.add(new Cliente(2L,"Alberto","Rojas"));
        listaClientes.add(new Cliente(3L,"Victor","Ruiz"));
        listaClientes.add(new Cliente(4L,"Alejandro","Bautista"));
        
        return listaClientes;
    }
    @GetMapping("/pruebaresponse")
    ResponseEntity<String> traerRespuestas(){
        return new ResponseEntity<>("Esto es un mensaje Response Entity",HttpStatus.OK);
    }
    
}
