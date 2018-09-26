package aufgabe5;
import java.awt.Color;
/**
 *
 * @author bj721bur
 */
public class aufgabe5a {
 
    static final public double DELTA = 30;
    static final Color BROWN = new Color(204,102,0);
    static final Color GREEN = new Color(124,183,55);
    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
       
        StdDraw.setXscale(-6, +6);
        StdDraw.setYscale(-1, +11);
        StdDraw.show(0);
        drawPythagorasTree(0, 5, 1.5, 0);
        StdDraw.show(0);
       
    }
   
    static void drawPythagorasTree(double x, double y, double w, double gamma){
        if(w < 0.05){
            StdDraw.setPenColor(GREEN);
        }else{
            StdDraw.setPenColor(BROWN);  
        }
       
        double c = w * Math.cos(Math.toRadians(gamma));
        double s = w * Math.sin(Math.toRadians(gamma));
       
        double u = w * Math.cos(Math.toRadians(DELTA));
        double v = w * Math.sin(Math.toRadians(DELTA));
               
       
        double ax = x;
        double ay = y;        
        double bx = ax + c;
        double by = ay + s;
        double cx = ax + c - s;
        double cy = ay + s + c;
        double dx = ax - s;
        double dy = ay + c;
       
        double ex = dx + (u * Math.cos(Math.toRadians(DELTA + gamma)));
        double ey = dy + (u * Math.sin(Math.toRadians(DELTA + gamma)));
       
//        double[] xSquare = {cx, dx, ax, bx};
//        double[] ySquare = {cy, dy, ay, by};
//        StdDraw.polygon(xSquare, ySquare);
//            
//        double[] xTriangle = {dx, cx, ex};
//        double[] yTriangle = {dy, cy, ey};
//        StdDraw.polygon(xTriangle, yTriangle);
        			//ax, ay, dx, dy
        StdDraw.line(ax, ay, dx, dy);
        StdDraw.line(bx, by, cx, cy);
       
        if(w >=0.03){
        drawPythagorasTree(dx, dy, u, gamma + DELTA);
       
        drawPythagorasTree(ex, ey, v, gamma + DELTA - 90);
        }
       
    }
}