package pokers;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JToggleButton;
public class Kaulins extends JToggleButton{
        private int n;
        public Kaulins(){
            n=new Random().nextInt(6)+1;
        }
        @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawString(n+"",15,15);
    }
    public void mest(){
        n=new Random().nextInt(6)+1;
        repaint();
    }
    public int getN(){
        return n;
    }
}
