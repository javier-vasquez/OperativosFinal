import java.io.PrintWriter;
import java.util.List;



public class Maquina implements Runnable {
	private TipoUsuario tipoUsuario;
	 PrintWriter pw;
	 int numBlogs;
		private int numSesiones;
	

	public Maquina(TipoUsuario tipoUsuario, PrintWriter pw,int numBlogs,int numSesiones) {
		super();
		this.tipoUsuario = tipoUsuario;
		this.pw = pw;
		this.numBlogs=numBlogs;
		this.numSesiones=numSesiones;
	}



	@Override
    public void run() {
		for(int i=0;i<this.numSesiones;i++){
			Usuario sesion= new Usuario(tipoUsuario,Thread.currentThread().getName(),pw,numBlogs);
			Thread s1 = new Thread(sesion, "Sesion "+i);
			s1.start();
		}
    }


}
