package pruebas;

import controladores.ControladorClinica;
import controladores.ControladorMascota;
import model.Clinica;
import model.Mascota;

public class prueba1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControladorClinica cc=new ControladorClinica();
//		for(Clinica c :cc.findAll()) {
//			System.out.println(c.toString());
//		}
//		Clinica c1=new Clinica();
//		c1.setNombre("Prueba");
//		c1.setDireccion("funciona porfavo");
//		c1.setCodcli(10);
////		cc.crearClinica(c1);
//		cc.borrarClinica(c1);
//		cc.borrarClinica(c1);
//		for(Clinica c :cc.findAll()) {
//			System.out.println(c.toString());
//		}
//		try {
//		Clinica c2=cc.findByPK(2);
//		System.out.println("estoymalito"+c2.toString()) ;
//		}catch(NullPointerException npe) {
//			System.out.println("Ese codigo no existe");
//		}
//
//
//		try {
//			Clinica c3=cc.findByNombre("Clinica veterinaria Mar de Alboran");
//			System.out.println("estoymalito2"+c3.toString()) ;
//			}catch(NullPointerException npe) {
//				System.out.println("Ese codigo no existe");
//			}
//		
//		Clinica c5=new Clinica();
//		c5.setNombre("Si no existe pk crea la clinica");
//		cc.modificarClinica(c5);
		
		
		
		//ahora mascotas
		ControladorMascota cm=new ControladorMascota();
		for(Mascota m: cm.findAll()) {
			System.out.println(m.toString());
		}
	}

}
