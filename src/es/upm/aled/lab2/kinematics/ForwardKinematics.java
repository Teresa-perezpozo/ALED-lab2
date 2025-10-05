package es.upm.aled.lab2.kinematics;

import java.awt.Graphics;

import es.upm.aled.lab2.gui.Node;

/**
 * This class implements a forward kinematics algorithm using recursion. It
 * expects a tree of Segments (defined by its length and angle with respect to
 * the previous Segment in the tree) and returns a tree of Nodes (defined by
 * their absolute coordinates in a 2-dimensional space).
 * 
 * @author rgarciacarmona
 */
public class ForwardKinematics {

	/**
	 * Returns a tree of Nodes to be used by SkeletonPanel to draw the position of
	 * an exoskeleton. This method is the public facade to a recursive method that
	 * builds the result from a tree of Segments defined by their angle and length,
	 * and the relationship between them (which Segment is children of which).
	 * 
	 * @param root    The root of the tree of Segments.
	 * @param originX The X coordinate for the origin point of the tree.
	 * @param originY The Y coordinate for the origin point of the tree.
	 * @return The tree of Nodes that represent the exoskeleton position in absolute
	 *         coordinates.
	 */
	// Public method: returns the root of the position tree
	public Node n;
	public static Node computePositions(Segment root, double originX, double originY) {
		
		/*Node n = new Node(originX,originY);
		computePositions(root, originX, originY, 0);
		
		return n;
		*/    return computePositions(root, originX, originY, 0);

				}
	/*
	 * private void drawSkeleton(Graphics g, double parentX, double parentY, Node node) {
		// TODO: Ponga comentarios en este método
		g.fillOval((int) node.getX() - 4, (int) node.getY() - 4, 8, 8);
		g.drawLine((int) parentX, (int) parentY, (int) node.getX(), (int) node.getY());
		//caso base
		if (node.getChildren().size() == 0) {
			return;
		}
		//paso recursivo
		for (Node child : node.getChildren()) {
			drawSkeleton(g, node.getX(), node.getY(), child);
		}
	}
	 */

	// Private helper method that implements the recursive algorithm
	private static Node computePositions(Segment link, double baseX, double baseY, double accumulatedAngle) {
		long startTime = System.nanoTime();

		double xFinal=baseX+link.getLength()*Math.cos(accumulatedAngle+link.getAngle());
		double yFinal=baseY+link.getLength()*Math.sin(accumulatedAngle+link.getAngle());
		double angleFinal=accumulatedAngle+link.getAngle();
		
		
		// caso base:que el segmento que analicemos no tenga hijos
		if (link.getChildren().size()==0) {
			Node n = new Node(xFinal, yFinal);
			return n;
		}
		
		//paso recursivo
		
	    Node currentNode = new Node(xFinal, yFinal);

		for (Segment child : link.getChildren()) {
			Node childNode = computePositions(child, xFinal, yFinal,angleFinal);
	        currentNode.addChild(childNode);

		}
		long runningTime = System.nanoTime() - startTime;
		System.out.println("Tiempo de computePositions para un segmento con "
		+ link.getChildren().size() + " hijos: "
		+ runningTime + " nanosegundos");

		return currentNode;
	}
}