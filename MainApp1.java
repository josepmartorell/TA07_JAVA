import java.util.Hashtable;
import javax.swing.JOptionPane;

public class MainApp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hashtable<String, Float> diccionarioAlumnos = new Hashtable<String, Float>();
		String nombreAlumno;
		float notasAlumno[];
		float media;
		boolean nuevoAlumno = false;

		do {
			// POR CADA ALUMNO PEDIMOS INTRODUCIR LAS NOTAS DE 4 EVALUACIONES CALCULAMOS LA MEDIA 		
			nombreAlumno = introducirNombre();
			notasAlumno = introducirNotas();
			media = calcularMedia(notasAlumno); 
			
			// GUARDAMOS LA INFORMACIÓN EN UN DICCIONARIO (CLAVE (STRING) ALUMNO / VALOR (FLOAT) NOTA PONDERADA)	
			diccionarioAlumnos = guardarDatos(nombreAlumno, media);
			
			// MOSTRAMOS POR PANTALLA LA INFORMACIÓN CONTENIDA EN LA FICHA DEL ALUMNO
			mostrarDatos(diccionarioAlumnos);
			
			// CUADRO DE OPCIONES QUE NOS PREGUNTA SI QUEREMOS SEGUIR INGRESANDO UN SIGUIENTE ALUMNO O SALIR DE LA APLICACIÓN
			nuevoAlumno = mostrarOpcion();
			
		}while(nuevoAlumno != false);
			
	}
		
	public static String introducirNombre() {
		
		String nombreAlumno = JOptionPane.showInputDialog(null, "Introduzca el nombre del alumno a ingresar", 
				"CURSO PROGRAMACIÓN", JOptionPane.INFORMATION_MESSAGE);
		if (nombreAlumno == null) {
			System.out.println("CANCELADO");
			System.exit(0);
		}
		return nombreAlumno;
		}
			
	public static float[] introducirNotas() {
		
		String numTrimestre[]= {"primer","segundo","tercer","cuarto"};
		float array[] = new float[4];
		float parsedData = 0;
		
		for (int i = 0; i < array.length; i++) {
			String userData = JOptionPane.showInputDialog(null, "Introduzca la nota del "+numTrimestre[i]+" trimestre", 
					"CURSO PROGRAMACIÓN", JOptionPane.INFORMATION_MESSAGE);
			if (userData != null) {
				parsedData = Float.parseFloat(userData);
				array[i] = parsedData;
			}else {
				System.out.println("CANCELADO");
				System.exit(0);
			}
		}
		return array;
		
	}
	
	public static float calcularMedia(float array[]) {
		
		float acumulado = 0;		
		for (int i = 0; i < array.length; i++) {
			acumulado += array[i];
		}	
		float media = acumulado / array.length;
		
		return media;
		
	}
	
	public static Hashtable<String, Float> guardarDatos(String nombreAlumno, float media) {
		
		Hashtable<String, Float> diccionario = new Hashtable<String, Float>();
		diccionario.put(nombreAlumno, media);
		
		return diccionario;
		
	}
	
	public static void mostrarDatos(Hashtable<String, Float> diccionario) {
		
		JOptionPane.showMessageDialog(null, diccionario.toString().replace("{", "NOMBRE ALUMNO/A:\n").replace("}", "").replace("=", "\nMEDIA PONDERADA:\n"), "CURSO PROGRAMACIÓN", JOptionPane.INFORMATION_MESSAGE);	
	}
	
	public static boolean mostrarOpcion() {
		
		boolean semaforo = false;
		
		int n = JOptionPane.showConfirmDialog(null, "Desea ingresar un nuevo alumno/a?","CURSO PROGRAMACIÓN",JOptionPane.YES_NO_OPTION);
		
		if (n == JOptionPane.YES_OPTION) {
			semaforo = true;
		
		} else if (n == JOptionPane.NO_OPTION) {
		
		} else {
			
		}
		return semaforo;
				
	}
	

}
