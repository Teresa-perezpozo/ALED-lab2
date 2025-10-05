package es.upm.aled.lab2.kinematics;

import java.util.ArrayList;
import java.util.List;

import es.upm.aled.lab2.gui.Node;
/*esta clase representa los segmentos del exoesqueleto, contiene atributos como 
 * su longitud o como el ángulo que mantiene con su padre. Además también contiene una lista
 * children que son los segmentos que cuelgan de cada segmento, es decir, los children del segmento
 * tronco, serán las piernas, y los children de estas, serán los pies
 */
public class Segment {
	private double lenght;
	private double angle;
	private List<Segment> children;
	public Segment (double lenght, double angle) {
		this.lenght = lenght;
		this.angle = angle;
		this.children = new ArrayList<>();
	}
	//pasa la longitud del segmento en elque estemos
	public double getLength() {
		return lenght;
	}
	//devuelve e lánguloque tiene con su esgmento antecesor
	public double getAngle() {
		return angle;
	}
	
	public void setAngle(double a1) {
		angle = a1;
	}
	//devueelve todos los segmentos que tenga por debajo
	public List<Segment> getChildren() {
		return children;
	}
	//añade un segmento mas si no existe ya, sino entraríamos en un bucle cuando hagamos recursividad
	public void addChild(Segment child) {
		if (!children.contains(child))
			children.add(child);
	}

}
