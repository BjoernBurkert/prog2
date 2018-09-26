package aufgabe5;
 
import java.awt.Color;
/**
 *
 * @author bj721bur
 */
public class aufgabe5b {
    static final int MIN_DELTA = 20;
    static final Color BROWN = new Color(204,102,0);
    static final Color GREEN = new Color(124,183,55);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        StdDraw.setXscale(-20, +20);
        StdDraw.setYscale(-12, +20);
       StdDraw.show(0);
        //drawPythagorasTree(2, 0, Math.random() % MIN_LAENGE, 0, 30);
        drawPythagorasTree(0, 0, 1, 0, 30);
       StdDraw.show(0);
    }
   
    static void drawPythagorasTree(double x, double y, double w,
            double gamma, double delta){
       
        double c = w * Math.cos(Math.toRadians(gamma));
        double s = w * Math.sin(Math.toRadians(gamma));
        double u = w * Math.cos(Math.toRadians(delta));
        double v = w * Math.sin(Math.toRadians(delta));
               
        double h = Math.random() * w + w;
        double ch = h * Math.cos(Math.toRadians(gamma));
        double sh = h * Math.sin(Math.toRadians(gamma));
       
        double ax;
        double ay;        
        double bx;
        double by;
        double cx;
        double cy;
        double dx;
        double dy;
       
        double ex;
        double ey;
       
        if(w < 0.15){
            StdDraw.setPenColor(GREEN);
           
            ax = x;
            ay = y;        
            bx = ax + c;
            by = ay + s;
            cx = ax + c - s;
            cy = ay + s + c;
            dx = ax - s;
            dy = ay + c;
       
            ex = dx + (u * Math.cos(Math.toRadians(delta + gamma)));
            ey = dy + (u * Math.sin(Math.toRadians(delta + gamma)));
 
 
           StdDraw.line(ax, ay, dx, dy);
           StdDraw.line(bx, by, cx, cy);
           
        }else{
            StdDraw.setPenColor(BROWN);  
 
            ax = x;
            ay = y;        
            bx = ax + c;
            by = ay + s;
            cx = ax + c - sh;
            cy = ay + s + ch;
            dx = ax - sh;
            dy = ay + ch;
       
            ex = dx + (u * Math.cos(Math.toRadians(delta + gamma)));
            ey = dy + (u * Math.sin(Math.toRadians(delta + gamma)));
 
 
           StdDraw.line(ax, ay, dx, dy);
           StdDraw.line(bx, by, cx, cy);
       
        }
       
        if(w >=0.03){
        drawPythagorasTree(dx, dy, u, gamma + delta, Math.random() % MIN_DELTA * 100);
       
        drawPythagorasTree(ex, ey, v, gamma + delta -90, Math.random() % MIN_DELTA * 100);
        }
       
    }
       
    }