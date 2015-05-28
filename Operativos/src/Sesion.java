import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Sesion implements Runnable {

	private String padre;
	private Usuario tipoUsuario ;
	 PrintWriter pw;
	 int numBlogs;
	
	
	public Sesion(Usuario tipoUsuario,String padre, PrintWriter pw,int numBlogs) {
		super();
		this.padre = padre;
		this.tipoUsuario = tipoUsuario;
		this.pw = pw;
		this.numBlogs= numBlogs;
	}

	private synchronized void imprimir(){
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
	}
	
	
	public void accionUsuarios(Usuario u) throws InterruptedException{
		
switch(u){
	case T1: 	
    	int random;
    	int idBlog = 0;
		int numSesion=(int)(Math.random()*9999);
		
		int estado = 1; // Start Reading New Blog
		while(estado != -1){
		 Thread.sleep (8000); // simula la actividad que hace el lector en el estado
		 switch (estado){
		 case 1:
			 random=(int)(Math.random()*100);
			 	if (random <= 21){
			 		int a=-1;
			 		boolean t=true;
			 		while(t){
			 		if((a=(int)(Math.random()*numBlogs))!=idBlog){
			 		idBlog=a;
			 		t=false;
			 		}
			 		}
			 		
			 		Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion+" - "+this.tipoUsuario+" - "+" Start Reading Blog "+idBlog);
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion+" - "+this.tipoUsuario+" - "+" Start Reading Blog "+idBlog);
			 	}else{
			 		estado = 2;
			 		Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion+" - "+this.tipoUsuario+" - "+" Continue Reading Blog");
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion+" - "+this.tipoUsuario+" - "+" Continue Reading Blog");
			 	}
			 	break;
		 case 2:
			 random=(int)(Math.random()*100);
			 if (random <= 76){
				 estado = 1;
				 int a=-1;
			 		boolean t=true;
			 		while(t){
			 		if((a=(int)(Math.random()*numBlogs))!=idBlog){
			 		idBlog=a;
			 		t=false;
			 		}
			 		}
				 Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion+" - "+this.tipoUsuario+" - "+" Start Reading Blog "+idBlog);
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion+" - "+this.tipoUsuario+" - "+" Start Reading Blog "+idBlog);
			 }else if(random <=92){ // 76 + 16
				 Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion+" - "+this.tipoUsuario+" - "+" Continue Reading Blog");
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion+" - "+this.tipoUsuario+" - "+" Continue Reading Blog");
			 }else{ // exit
				 estado = -1;
				 Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion+" - "+this.tipoUsuario+" - "+" Exit!");
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion+" - "+this.tipoUsuario+" - "+" Exit!");
			 	}
			 break;
			 case 3:
		 // En este caso el lector tipo 1 no hace comentarios así que no llega a este estado.
		 // pero el usuario tipo 3 si requiere de codificación en este caso. SE puede hacer un
		 //algoritmo general para todos que lea las entradas de la matriz.
		 }
		}
		break;
	case T2:
		int random1;
    	int idBlog1=0;
		int numSesion1=(int)(Math.random()*999);
		
		int estado1 = 1; // Start Reading New Blog
		while(estado1 != -1){
		 Thread.sleep (2000); // simula la actividad que hace el lector en el estado
		 switch (estado1){
		 case 1:
			 random1=(int)(Math.random()*100);
			 if (random1 <= 50){
				 estado1 = 1;
				 int a=-1;
			 		boolean t=true;
			 		while(t){
			 		if((a=(int)(Math.random()*numBlogs))!=idBlog1){
			 		idBlog1=a;
			 		t=false;
			 		}
			 		}
				 Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion1+" - "+this.tipoUsuario+" - "+" Start Reading Blog "+idBlog1);
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion1+" - "+this.tipoUsuario+" - "+" Start Reading Blog "+idBlog1);
			 }else if(random1 <=99){ // 76 + 16
				 estado1 = -1;
				 Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion1+" - "+this.tipoUsuario+" - "+" Exit!");
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion1+" - "+this.tipoUsuario+" - "+" Exit!");
			 }else{ 
				 estado1 = 2;
				 Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion1+" - "+this.tipoUsuario+" - "+" Continue Reading Blog");
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion1+" - "+this.tipoUsuario+" - "+" Continue Reading Blog");
			 	}
			 	break;
		 case 2:
			 random1=(int)(Math.random()*100);
			 if (random1 <= 32){
				 estado1 = 1;
				 int a=-1;
			 		boolean t=true;
			 		while(t){
			 		if((a=(int)(Math.random()*numBlogs))!=idBlog1){
			 		idBlog1=a;
			 		t=false;
			 		}
			 		}
				 Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion1+" - "+this.tipoUsuario+" - "+" Start Reading Blog "+idBlog1);
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion1+" - "+this.tipoUsuario+" - "+" Start Reading Blog "+idBlog1);
			 }else if(random1 <=76){ // 76 + 16
				 estado1 = -1;
				 Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion1+" - "+this.tipoUsuario+" - "+" Exit!");
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion1+" - "+this.tipoUsuario+" - "+" Exit!");
			 }else{ 
				 Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion1+" - "+this.tipoUsuario+" - "+" Continue Reading Blog");
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion1+" - "+this.tipoUsuario+" - "+" Continue Reading Blog");
			 	}
			 break;
			 case 3:
		 // En este caso el lector tipo 1 no hace comentarios así que no llega a este estado.
		 // pero el usuario tipo 3 si requiere de codificación en este caso. SE puede hacer un
		 //algoritmo general para todos que lea las entradas de la matriz.
		 }
		}
		break;
	case T3:
		int random11;
    	int idBlog11=0;
		int numSesion11=(int)(Math.random()*9999);
		
		int estado11 = 1; // Start Reading New Blog
		while(estado11 != -1){
		 Thread.sleep (3000); // simula la actividad que hace el lector en el estado
		 switch (estado11){
		 case 1:
			 random11=(int)(Math.random()*100);
			 if (random11 <= 63){ //-CONTINUE READING THE SAME BLOG
				 estado11=2;
				 Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Continue Reading Blog");
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Continue Reading Blog");
			 }else if(random11 <=84){ // 63 + 21  --MAKE COMMENTS
				 estado11=3;
				 Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Make Comments in Blog");
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Make Comments in Blog");
			 }else if(random11 <=98){//84+14 -START READING A BLOG
				 estado11 = 1;
				 int a=-1;
			 		boolean t=true;
			 		while(t){
			 		if((a=(int)(Math.random()*numBlogs))!=idBlog11){
			 		idBlog1=a;
			 		t=false;
			 		}
			 		}
				 Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Start Reading Blog "+idBlog11);
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Start Reading Blog "+idBlog11);
			 	}else {//exit
			 		estado11 = -1;
					 Calendar cal = Calendar.getInstance();
				    	cal.getTime();
				    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Exit!");
					System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Exit!");
			 	}
			 	break;
		 case 2:
			 random11=(int)(Math.random()*100);
			 if (random11 <= 33){ //-MAKE COMMENTS
				 estado11=3;
				 Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Make Comments in Blog");
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Make Comments in Blog");
			 }else if(random11 <=64){ // 33 + 31  --START READING NEW BLOG
				 estado11 = 1;
				 int a=-1;
			 		boolean t=true;
			 		while(t){
			 		if((a=(int)(Math.random()*numBlogs))!=idBlog11){
			 		idBlog1=a;
			 		t=false;
			 		}
			 		}
				 Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Start Reading Blog "+idBlog11);
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Start Reading Blog "+idBlog11);
			 }else if(random11 <=94){//64+30 - CONTINUE READING THE SAME BLOG
				 estado11=2;
				 Calendar cal = Calendar.getInstance();
			    	cal.getTime();
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Continue Reading Blog");
				System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Continue Reading Blog");
			 	}else {//exit
			 		estado11 = -1;
					 Calendar cal = Calendar.getInstance();
				    	cal.getTime();
				    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Exit!");
					System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Exit!");
			 	}
			 break;
			 case 3:
				 random11=(int)(Math.random()*100);
				 if (random11 <= 76){ //-MAKE COMMENTS
					 estado11=3;
					 Calendar cal = Calendar.getInstance();
				    	cal.getTime();
				    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Make Comments in Blog");
					System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Make Comments in Blog");
				 }else if(random11 <=99){ // 76 + 23  --START READING NEW BLOG
					 estado11 = 1;
					 int a=-1;
				 		boolean t=true;
				 		while(t){
				 		if((a=(int)(Math.random()*numBlogs))!=idBlog11){
				 		idBlog1=a;
				 		t=false;
				 		}
				 		}
					 Calendar cal = Calendar.getInstance();
				    	cal.getTime();
				    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Start Reading Blog "+idBlog11);
					System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Start Reading Blog "+idBlog11);
				 }else {//exit
				 		estado11 = -1;
						 Calendar cal = Calendar.getInstance();
					    	cal.getTime();
					    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					 	pw.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Exit!");
						System.out.println(sdf.format(cal.getTime())+" - "+padre+" - "+numSesion11+" - "+this.tipoUsuario+" - "+" Exit!");
				 	}
				 break;	
		 }
		}
		break;
		
}
}
	
	@Override
	public void run() {
		//this.imprimir();
		try {
			this.accionUsuarios(tipoUsuario);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
