import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Main {
	private List<TipoUsuario> tipoUsuariosMaquinas;
	private List<Integer> numSesiones;
	private int runtime;
	private int numBlogs;
	Thread m1 = null;
	List<Thread> l= new ArrayList<Thread>();
	

	public Main(List<TipoUsuario> tipoUsuariosMaquinas, List<Integer> numSesiones,int numBlogs,int runtime) {
		super();
		this.tipoUsuariosMaquinas = tipoUsuariosMaquinas;
		this.numSesiones = numSesiones;
		this.numBlogs=numBlogs;
		this.runtime= runtime;
	}


	public void iniciar() throws IOException, InterruptedException{
		
	    

	    FileWriter fichero=new FileWriter("Traza.txt");
	    PrintWriter pw = new PrintWriter(fichero);
	    System.out.println("Crea el archivo");
		
	    
	    pw.println("Se Generaron "+tipoUsuariosMaquinas.size()+" Maquinas");
	    
	    for(int i=0;i<tipoUsuariosMaquinas.size();i++){
	    pw.println("La maquina "+i+" genero:"+numSesiones.get(i)+" de tipo "+tipoUsuariosMaquinas.get(i));
	    }
	    
		for(int i=0;i<tipoUsuariosMaquinas.size();i++){
			
			Maquina maquina = new Maquina(tipoUsuariosMaquinas.get(i),pw,numBlogs,numSesiones.get(i));
	        l.add(new Thread(maquina, "Maquina_"+i));
	        l.get(i).start();
		}
       
       
        Thread.sleep(runtime*1000);
    	   for(int k=0;k<l.size();k++){
    		  l.get(k).interrupt();
    	   }
    	fichero.close();
    	System.out.println("Cierra el archivo");
    	System.exit(0);
	}
	
	
}
