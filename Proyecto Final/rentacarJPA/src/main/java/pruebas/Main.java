package pruebas;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.RollbackException;

import controladores.ControladorClinica;
import controladores.ControladorMascota;
import controladores.ControladorVeterinario;
import model.Clinica;
import model.Mascota;
import model.Veterinario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControladorClinica cc = new ControladorClinica();
		ControladorMascota cm = new ControladorMascota();
		ControladorVeterinario cv = new ControladorVeterinario();
		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			// opciones
			System.out.println("1: Mostrar Listas");
			System.out.println("2: Añadir Clinica/Mascota/Veterinario");
			System.out.println("3: Borrar Clinica/Mascota/Veterinario");
			System.out.println("4: Modificar Clinica/Mascota/Veterinario");
			System.out.println("0: Cerrar programa");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				imprimirListas();
				break;
			case 2:
				crearObjeto();
				break;
			case 3:
				borrarObjeto();
				break;
			case 4:
				modificarObjeto();
			}
		} while (opcion != 0);
		System.out.println("Cerrando Programa");
	}

	private static void imprimirListas() {
		Scanner sc = new Scanner(System.in);
		int opcion;
		do {

			System.out.println("¿Que lista desea imprimir?");
			System.out.println("1: Lista de Clinicas veterinarias");
			System.out.println("2: Lista de mascotas");
			System.out.println("3: Lista de veterinarios");
			System.out.println("0: Volver atras");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				imprimirListaClinicas();
				break;
			case 2:
				imprimirListaMascotas();
				break;

			case 3:
				imprimirListaVeterinarios();
				break;
			case 0:
				System.out.println("Volviendo al menu principal");
				break;
			default:
				System.out.println("Si desea volver al menu principal pulse 0");
			}

		} while (opcion != 0);
	}

	private static void imprimirListaClinicas() {
		ControladorClinica cc = new ControladorClinica();
		for (Clinica c : cc.findAll()) {
			System.out.println(c.toString());
		}
	}

	private static void imprimirListaMascotas() {
		ControladorMascota cm = new ControladorMascota();
		for (Mascota m : cm.findAll()) {
			System.out.println(m.toString());
		}
	}

	private static void imprimirListaVeterinarios() {
		ControladorVeterinario cv = new ControladorVeterinario();
		for (Veterinario v : cv.findAll()) {
			System.out.println(v.toString());
		}
	}

	private static void crearObjeto() {
		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("1: Introducir Clinica");
			System.out.println("2: Introducir Mascota");
			System.out.println("3: Introducir Veterinario");
			System.out.println("0: Volver al menu principal");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				crearClinica();
				break;
			case 2:
				crearMascota();
				break;
			case 3:
				crearVeterinario();
				break;
			case 0:
				System.out.println("Volviendo al menu principal");
				break;
			default:
				System.out.println("Si desea volver al menu principal pulse 0");
			}
		} while (opcion != 0);
	}

	private static void crearClinica() {
		ControladorClinica cc = new ControladorClinica();
		Clinica c = new Clinica();
		Scanner sc = new Scanner(System.in);
		System.out.println("------Introduciendo clinica en la base de datos-------");
		System.out.println("Introduce el nombre de la clinica");
		c.setNombre(sc.nextLine());
		System.out.println("Introduce la direccion:");
		c.setDireccion(sc.nextLine());
		System.out.println("Introduce la especialidad");
		c.setEspecialidad(sc.nextLine());
		try {
			cc.crearClinica(c);
		} catch (RollbackException re) {
			System.out.println("La clinica que se desea borrar tiene mascotas o veterinarios asociados");
		}

	}

	private static void crearMascota() {
		ControladorMascota cm = new ControladorMascota();
		Mascota m = new Mascota();
		Scanner sc = new Scanner(System.in);
		System.out.println("-----Introduciendo Mascota en la base de datos-------");
		System.out.println("Introduce el nombre de la mascota");
		m.setNombre(sc.nextLine());
		System.out.println("Introduce el telefono del dueño");
		m.setTelefono(sc.nextLine());
		System.out.println("Introduce la raza de la mascota");
		m.setRaza(sc.nextLine());
		System.out.println("introduzca una breve descripcion de la mascota");
		m.setDescrip(sc.nextLine());
		System.out.println("Introduzca el codigo de la clinica  que se le va a asignar a la mascota");
		Clinica c = new Clinica();
		c.setCodcli(sc.nextInt());
		m.setClinica(c);
		try {
			cm.crearMascota(m);
		} catch (RollbackException re) {
			System.out.println(
					"El codigo introducido de la clinica no existe y no se a podido realizar la operacion, volviendo al menu principal");
		}
	}

	private static void crearVeterinario() {
		ControladorVeterinario cv = new ControladorVeterinario();
		Veterinario v = new Veterinario();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduciendo Veterinario en la base de datos-------");
		System.out.println("Introduce el nombre del veterinario");
		v.setNombre(sc.nextLine());
		System.out.println("Introduce el apellido");
		v.setApellido(sc.nextLine());
		System.out.println("Introduce la direccion");
		v.setDomicilio(sc.nextLine());
		System.out.println("Introduce el NIF");
		v.setNif(sc.nextLine());
		System.out.println("introduce el telefono");
		v.setTelefono(sc.nextLine());
		System.out.println("Introduzca el codigo de la clinica  que se le va a asignar al veterinario");
		Clinica c = new Clinica();
		c.setCodcli(sc.nextInt());
		v.setClinica(c);
		try {
			cv.crearVeterinario(v);
		} catch (RollbackException re) {
			System.out.println(
					"El codigo introducido de la clinica no existe y no se a podido realizar la operacion, volviendo al menu principal");
		}
	}

	private static void borrarObjeto() {
		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("1: Eliminar Clinica");
			System.out.println("2: Eliminar Mascota");
			System.out.println("3: Eliminar Veterinario");
			System.out.println("0: Volver al menu principal");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				borrarClinica();
				break;
			case 2:
				borrarMascota();
				break;
			case 3:
				borrarVeterinario();
				break;
			case 0:
				System.out.println("Volviendo al menu principal");
				break;
			default:
				System.out.println("Si desea volver al menu principal pulse 0");
			}
		} while (opcion != 0);
	}

	private static void borrarClinica() {
		ControladorClinica cc = new ControladorClinica();
		Clinica c = new Clinica();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el codigo de la clinica que se desea borrar");
		c.setCodcli(sc.nextInt());

		cc.borrarClinica(c);

	}

	private static void borrarMascota() {
		ControladorMascota cm = new ControladorMascota();
		Scanner sc = new Scanner(System.in);
		Mascota m = new Mascota();
		System.out.println("introduce el codigo de la mascota que se desea borrar");
		m.setCodmas(sc.nextInt());
		cm.borrarMascota(m);
	}

	private static void borrarVeterinario() {
		ControladorVeterinario cv = new ControladorVeterinario();
		Scanner sc = new Scanner(System.in);
		Veterinario v = new Veterinario();
		System.out.println("Introduce el codigo del veterinario que se desea borrar");
		v.setCodvet(sc.nextInt());
		cv.borrarVeterinario(v);
	}

	private static void modificarObjeto() {
		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("1: Modificar Clinica");
			System.out.println("2: Modificar Mascota");
			System.out.println("3: Modificar Veterinario");
			System.out.println("0: Volver al menu principal");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				modificarClinica();
				break;
			case 2:
				modificarMascota();
				break;
			case 3:
				modificarVeterinario();
				break;
			case 0:
				System.out.println("Volviendo al menu principal");
				break;
			default:
				System.out.println("Si desea volver al menu principal pulse 0");
			}
		} while (opcion != 0);
	}

	private static void modificarClinica() {
		ControladorClinica cc = new ControladorClinica();
		Scanner sc = new Scanner(System.in);
		System.out.println("introduzca el codigo de la clinica");
		try {
			Clinica c = cc.findByPK(sc.nextInt());

			if (c == null) {
				System.out.println("el codigo de clinica introducido no existe");
			} else {
				System.out.println("Introduzca el nombre de la clinica");
				c.setNombre(sc.nextLine());
				System.out.println("Introduzca la direccion de la clinica");
				c.setDireccion(sc.nextLine());
				System.out.println("Introduzca la especialidad de la clinica");
				c.setEspecialidad(sc.nextLine());
				
				cc.modificarClinica(c);
			}
		} catch (InputMismatchException ime) {
			System.out.println("Solo se puede introducir numero");
		}
	}

	private static void modificarMascota() {
		ControladorMascota cm = new ControladorMascota();
		ControladorClinica cc = new ControladorClinica();
		Scanner sc = new Scanner(System.in);
		System.out.println("introduzca el codigo de la mascota");
		try {
			Mascota m = cm.findByPK(sc.nextInt());

			if (m == null) {
				System.out.println("El codigo de la mascota introducido no existe");
			} else {
				System.out.println("Introduce el nombre de la mascota");
				m.setNombre(sc.nextLine());
				System.out.println("Introduce el telefono del dueño");
				m.setTelefono(sc.nextLine());
				System.out.println("Introduce la raza de la mascota");
				m.setRaza(sc.nextLine());
				System.out.println("introduzca una breve descripcion de la mascota");
				m.setDescrip(sc.nextLine());
				Clinica c = new Clinica();
				do {
					System.out.println("Introduzca el codigo de la clinica  que se le va a asignar a la mascota");
				
					c.setCodcli(sc.nextInt());
					if(cc.findByPK(c.getCodcli())==null) {
						System.out.println("El codigo de la clinica introducido no existe");
					}
				}while(cc.findByPK(c.getCodcli())==null);
				m.setClinica(c);
				cm.modificarMascota(m);
			}
		} catch (InputMismatchException ime) {
			System.out.println("Solo se puede introducir numero en los codigos");
		}
		
	}

	private static void modificarVeterinario() {
		ControladorVeterinario cv = new ControladorVeterinario();
		ControladorClinica cc = new ControladorClinica();
		Scanner sc = new Scanner(System.in);
		System.out.println("introduzca el codigo de la mascota");
		try {
			Veterinario v = cv.findByPK(sc.nextInt());

			if (v == null) {
				System.out.println("El codigo del veterinario introducido no existe");
			} else {
				System.out.println("Introduce el nombre del veterinario");
				v.setNombre(sc.nextLine());
				System.out.println("Introduce el telefono del veterinario");
				v.setTelefono(sc.nextLine());
				System.out.println("Introduce el apellido");
				v.setApellido(sc.nextLine());
				System.out.println("introduzca el domicilio del veterinario");
				v.setDomicilio(sc.nextLine());
				System.out.println("introduzca el nif");
				v.setNif(sc.nextLine());
				Clinica c = new Clinica();
				do {
					System.out.println("Introduzca el codigo de la clinica  que se le va a asignar al veterinario");
				
					c.setCodcli(sc.nextInt());
					if(cc.findByPK(c.getCodcli())==null) {
						System.out.println("El codigo de la clinica introducido no existe");
					}
				}while(cc.findByPK(c.getCodcli())==null);
				v.setClinica(c);
				cv.modificarVeterinario(v);
			}
		} catch (InputMismatchException ime) {
			System.out.println("Solo se puede introducir numero en los codigos");
		}
	}

}
