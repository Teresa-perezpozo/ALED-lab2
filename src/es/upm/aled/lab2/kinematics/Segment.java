package es.upm.aled.lab2.kinematics;

import java.util.ArrayList;
import java.util.List;

// TODO: Implemente la clase
public class Segment {

	private double length;
	private double angle;
	List<Segment> children = new ArrayList<>();
	
	public Segment(double length, double angle) {
		this.length=length;
		this.angle = angle;
		
	}
	
	public double getLength() {
		return this.length;
	}
	public double getAngle () {
		return this.angle;
	}
	public void setAngle(double angle){
		this.angle=angle;
	}
	public List<Segment> getChildren(){
		return children;
	}
	public void addChild(Segment child) {
		children.add(child);
	}
	
	
	
}
