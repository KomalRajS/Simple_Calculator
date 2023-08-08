import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

class MyFrame extends JFrame implements ActionListener{
    JButton button1;
    JLabel label;
    MyFrame() {
        //ImageIcon image = new ImageIcon("ps.png");
        ImageIcon imageIcon = new ImageIcon("ps.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back

        Border border = BorderFactory.createLineBorder(Color.blue, 3);
        Border border_b = BorderFactory.createEtchedBorder(Color.BLUE,Color.CYAN);
       
        label = new JLabel();
        label.setText("Let's solve the problem");
        label.setIcon(imageIcon);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setForeground(Color.blue);
        label.setFont(new Font("Times New Roman",Font.PLAIN,25));
        label.setBackground(Color.black);
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBorder(border);
        label.setBounds(250, 250, 250, 250);
        label.setVisible(false);

        button1 = new JButton("Start");
        button1.setBounds(100, 200, 100, 50);
        button1.addActionListener(this);
        button1.setFocusable(false);
        button1.setFont(new Font("Comic Sans",Font.BOLD,15));
        button1.setForeground(Color.DARK_GRAY);
        button1.setBackground(Color.LIGHT_GRAY);
        button1.setBorder(border_b);
       
        this.setTitle("Title");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setVisible(true);
        this.setBackground(Color.gray);
        this.add(button1);
        this.add(label);
        this.getContentPane().setBackground(new Color(105,105,105));
        this.setLayout(null);
        //this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        label.setVisible(true);
        System.out.println("Clicked start");
        button1.setEnabled(false);
    }
}

public class Main_gui1 {
    public static void main(String[] args) {
         new MyFrame();
    }
}