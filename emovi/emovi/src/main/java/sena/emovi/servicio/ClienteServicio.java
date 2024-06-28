package sena.emovi.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import sena.emovi.modelo.cliente;
import sena.emovi.repositorio.ClienteRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ClienteServicio implements IClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;


    @Override
    public  List<cliente> ListarCliente() {
        return clienteRepositorio.findAll();
    }

    @Override
    public cliente buscarClientePorId(Integer idCliente){
        cliente Cliente= clienteRepositorio.findById(idCliente).orElse(null);
        return Cliente;
    }


    @Override
    public cliente guardarCliente(cliente Cliente){
        return clienteRepositorio.save(Cliente);
    }

    @Override
    public void eliminarCliente(cliente Cliente) {
        clienteRepositorio.delete(Cliente);

    }


}








