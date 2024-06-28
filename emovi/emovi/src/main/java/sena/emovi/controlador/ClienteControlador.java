package sena.emovi.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.emovi.exeption.RecursoNoEncontradExeption;
import sena.emovi.modelo.cliente;
import sena.emovi.servicio.ClienteServicio;
import sena.emovi.servicio.IClienteServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("emobi-app")
@CrossOrigin(value = "http://localhost:3000")

public class ClienteControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(ClienteControlador.class);

    @Autowired
    private IClienteServicio clienteServicio;

    @GetMapping("/clientes")
    public List<cliente> obtenerClientes(){
        var clientes = clienteServicio.ListarCliente();
        clientes.forEach((Cliente ->  logger.info(Cliente.toString())));
        return clientes;

    }

    @PostMapping("/clientes")
    public  cliente agregarCliente(@RequestBody cliente Cliente){
        logger.info("Cliente a agregar:"+ Cliente);
        return clienteServicio.guardarCliente(Cliente);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<cliente>
    obtenerClientePorId(@PathVariable Integer id) {
        cliente Cliente = clienteServicio.buscarClientePorId(id);
        if (Cliente == null)
            throw  new RecursoNoEncontradExeption("No se encontro el id:" + id);
        return ResponseEntity.ok(Cliente);
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<cliente> actualizarCliente( @PathVariable Integer  id,
                                                      @RequestBody cliente clienteRecibido){
        cliente Cliente = clienteServicio.buscarClientePorId(id);
        if (Cliente == null)
            throw  new RecursoNoEncontradExeption("El id recibido No Existe" + id);
        Cliente.setNombre(clienteRecibido.getNombre());
        Cliente.setCorreo(clienteRecibido.getCorreo());
        Cliente.setCelular(clienteRecibido.getCelular());
        Cliente.setTiposervicio(clienteRecibido.getTiposervicio());
        Cliente.setTipovehiculo(clienteRecibido.getTipovehiculo());
        Cliente.setFecha(clienteRecibido.getFecha());
        clienteServicio.guardarCliente(Cliente);
        return  ResponseEntity.ok(Cliente);



    }
    @DeleteMapping ("/cliente/{id}")
    public ResponseEntity<Map<String,Boolean>>
        eliminarCliente(@PathVariable Integer id){
        cliente Cliente = clienteServicio.buscarClientePorId(id);
        if (Cliente == null)
            throw new RecursoNoEncontradExeption("El id recibido No Existe:" + id);
        clienteServicio.eliminarCliente(Cliente);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return  ResponseEntity.ok(respuesta);
    }





}








    //http://localhost:8080/emovi-app/clientes




