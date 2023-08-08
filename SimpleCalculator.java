import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator implements ActionListener {        //ActionListener interface receives action events
    
    //declaration of swing components
    JFrame frame;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton deciButton, delButton, clrButton, equalButton, negativeButton;
    JTextField textfield;
    JPanel panel;

    //declaration of required variables
    double n1, n2, result;
    char operation;

    Font font = new Font("Times New Roman",Font.BOLD,25);      //create new font from specified name, style, size 
    Border border1 = BorderFactory.createLineBorder(Color.BLUE, 3);    //Creates a line border with the specified color and width

    //Constructor of SimpleCalculator
    SimpleCalculator() {

        frame = new JFrame();         //create an instance of JFrame
        frame.setTitle("Simple Calculator");        //add title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //exit the application on closing
        frame.setSize(420, 560);            //define  the size of frame
        frame.getContentPane().setBackground(new Color(0,1,9));    //adding background color
        frame.setLayout(null);      //using no layout manager
        frame.setResizable(false);      //not permitting the user to change size of frame

        textfield = new JTextField();          //create an instance of JTextfield
        textfield.setBounds(50, 50, 300, 60);     //defining plot(location) points and dimensions of textfield
        textfield.setBackground(Color.WHITE);      //adding background color
        textfield.setFont(font);          //defining font style of text
        textfield.setBorder(border1);     //inserting border
        textfield.setVisible(true);    //making the textfield visible 
        textfield.setEditable(false);       //disables the editing of textfield using user's keyboard

        // create instances of JButton
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        clrButton = new JButton("Clear");
        delButton = new JButton("Delete");
        deciButton = new JButton(".");
        equalButton = new JButton("=");
        negativeButton = new JButton("(-)");
       
        //assigning functional buttons to the array functionButton[]
        functionButtons[0] = delButton;
        functionButtons[1] = addButton;
        functionButtons[2] = subButton;
        functionButtons[3] = mulButton;
        functionButtons[4] = divButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = clrButton;
        functionButtons[7] = deciButton;
        functionButtons[8] = negativeButton;

        //setting common attributes for functionButtons[] and numberButtons[]

        for(int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(new Color(135,206,235));
        }

        for(int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }

        clrButton.setBounds(50, 430, 100, 50);
        equalButton.setBounds(160, 430, 80, 50);
        delButton.setBounds(250, 430, 100,50);

        panel = new JPanel();         //create new instance of JPanel
        panel.setBounds(50, 120, 300, 300);      //defining plot(location) points and dimensions of panel
        panel.setLayout(new GridLayout(4,4,10,10));   //using grid layout manager
        panel.setBackground(new Color(0,1,9));      //adding background color to panel
        
        //adding buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(deciButton);
        panel.add(numberButtons[0]);
        panel.add(negativeButton);
        panel.add(divButton);


        //adding various other components to frame
        frame.add(panel);
        frame.add(clrButton);
        frame.add(equalButton);
        frame.add(delButton);
        frame.add(textfield);

        frame.setVisible(true);  //enabling the visibility or appearance of frame

    }
    public static void main(String[] args) {
        SimpleCalculator calci = new SimpleCalculator();     //create new instance of SimpleCalculator

    }

    //overriding actionPerformed method of ActionListener interface to perform appropriate actions on specific action events
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i< 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));     //for displaying the number entered
            }
        }

        if(e.getSource() == deciButton)
            textfield.setText(textfield.getText().concat("."));     //for adding decimal point 

        if(e.getSource() == negativeButton) {                           //for inserting negative sign
            double temp = Double.parseDouble(textfield.getText());      
            temp *= -1;
            textfield.setText(String.valueOf(temp));        
        }

        if(e.getSource() == addButton) {
            n1 = Double.parseDouble(textfield.getText());       //parse the data into double format
            operation = '+';
            textfield.setText("");
        }

        if(e.getSource() == subButton) {
            n1 = Double.parseDouble(textfield.getText());
            operation = '-';
            textfield.setText("");
        }

        if(e.getSource() == mulButton) {
            n1 = Double.parseDouble(textfield.getText());
            operation = '*';
            textfield.setText("");
        }

        if(e.getSource() == divButton) {
            n1 = Double.parseDouble(textfield.getText());
            operation = '/';
            textfield.setText("");
        }

        if(e.getSource() == equalButton) {                 //for displaying result after performing required arithmetic operations
            n2 = Double.parseDouble(textfield.getText());
            switch(operation) {
                case '+':    result = n1 + n2;    break;
                case '-':    result = n1 - n2;    break;
                case '*':    result = n1 * n2;    break;
                case '/':    result = n1 / n2;    break;
            }
            textfield.setText(String.valueOf(result));
            n1 = result;
        }

        if(e.getSource() == clrButton) {        
            textfield.setText("");             //all-clears the textfield
        }

        if(e.getSource() == delButton) {          //for deleting the previously entered digit
            String str = textfield.getText();
            textfield.setText("");
            for(int i = 0; i < str.length()-1; i++) {
                textfield.setText(textfield.getText()+str.charAt(i));
            }
        }
    }
}
