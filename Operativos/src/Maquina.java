import java.io.PrintWriter;



public class Maquina implements Runnable {
	private Usuario tipoUsuario;
	 PrintWriter pw;
	 int numBlogs;
	

	public Maquina(Usuario tipoUsuario, PrintWriter pw,int numBlogs) {
		super();
		this.tipoUsuario = tipoUsuario;
		this.pw = pw;
		this.numBlogs=numBlogs;
	}



	@Override
    public void run() {
		
			Sesion sesion= new Sesion(tipoUsuario,Thread.currentThread().getName(),pw,numBlogs);
			Thread s1 = new Thread(sesion, "Sesion_");
			s1.start();
    }


}
