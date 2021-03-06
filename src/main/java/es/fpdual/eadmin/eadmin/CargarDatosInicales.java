package es.fpdual.eadmin.eadmin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.modelo.EstadoExpediente;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;

@Component
public class CargarDatosInicales implements ApplicationRunner{
	private final RepositorioDocumento repositorioDocumento;
	private final RepositorioExpediente repositorioExpediente;
	private static final Date FECHA = new Date();
	
	@Autowired
	public CargarDatosInicales(RepositorioDocumento repositorioDocumento,RepositorioExpediente repositorioExpediente) {
		this.repositorioDocumento = repositorioDocumento;
		this.repositorioExpediente = repositorioExpediente;
	}

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.repositorioDocumento.altaDocumento(new Documento(1, "Documento1", FECHA, FECHA, true, EstadoDocumento.ACTIVO));
		this.repositorioDocumento.altaDocumento(new Documento(2, "Documento2", FECHA, FECHA, false, EstadoDocumento.APROBADO));
		this.repositorioDocumento.altaDocumento(new Documento(3, "Documento3", FECHA, FECHA, true, EstadoDocumento.ELIMINADO));
		this.repositorioDocumento.altaDocumento(new Documento(4, "Documento4", FECHA, FECHA, false, EstadoDocumento.APROBADO));
		this.repositorioDocumento.altaDocumento(new Documento(5, "Documento5", FECHA, FECHA, true, EstadoDocumento.ELIMINADO));
		this.repositorioDocumento.modificarDocumento(new Documento(2, "Documento2", FECHA, FECHA, true, EstadoDocumento.ACTIVO));
		this.repositorioDocumento.modificarDocumento(new Documento(4, "Documento4", FECHA, FECHA, true, EstadoDocumento.ACTIVO));
		this.repositorioDocumento.eliminarDocumento(1);
		this.repositorioDocumento.eliminarDocumento(3);
		this.repositorioDocumento.eliminarDocumento(5);
		this.repositorioDocumento.escribirDocumentoFichero();
		this.repositorioExpediente.almacenarExpediene(new Expediente(1, "Expediente1", FECHA, FECHA, FECHA, true, EstadoExpediente.INICIADO, null));
		this.repositorioExpediente.almacenarExpediene(new Expediente(2, "Expediente2", FECHA, FECHA, FECHA, false, EstadoExpediente.INICIADO, null));
		this.repositorioExpediente.almacenarExpediene(new Expediente(3, "Expediente3", FECHA, FECHA, FECHA, true, EstadoExpediente.INICIADO, null));
		this.repositorioExpediente.almacenarExpediene(new Expediente(4, "Expediente4", FECHA, FECHA, FECHA, false, EstadoExpediente.INICIADO, null));
		this.repositorioExpediente.almacenarExpediene(new Expediente(5, "Expediente5", FECHA, FECHA, FECHA, true, EstadoExpediente.INICIADO, null));
		this.repositorioExpediente.modificarExpediente(new Expediente(2, "Expediente2", FECHA, FECHA, FECHA, true, EstadoExpediente.INICIADO, null));
		this.repositorioExpediente.modificarExpediente(new Expediente(4, "Expediente4", FECHA, FECHA, FECHA, true, EstadoExpediente.INICIADO, null));
		this.repositorioExpediente.eliminarExpediente(1);
		this.repositorioExpediente.eliminarExpediente(3);
		this.repositorioExpediente.eliminarExpediente(5);
		this.repositorioExpediente.escribirExpedienteFichero();
		
		
	}

}
