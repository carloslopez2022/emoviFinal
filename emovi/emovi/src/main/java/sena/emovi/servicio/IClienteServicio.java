package sena.emovi.servicio;

import sena.emovi.modelo.cliente;

import java.util.List;

public interface IClienteServicio {
        public List<cliente> ListarCliente() ;


        public cliente buscarClientePorId(Integer idCliente);

         public cliente guardarCliente(cliente Cliente);

         public void eliminarCliente(cliente Cliente);

}






