import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class converter {
    private JLabel JInput;
    private JTextField inputTextField;
    private JLabel JCurrencyType;
    private JComboBox<String> currencyBox;
    private JPanel currencyType;
    private JLabel JMDField;
    private JTextField resultField;
    private JButton convertButton;
    private JButton clearButton;

    //options for combo box
    String[] currencyOptions = {"USD", "CAN", "EURO"};
    private JPanel panel1;

    //set conversions as final so cant change
    private final Double canRate = 97.50;
    private final Double usRate = 129.02;
    private final Double euroRate = 164.33;
    private Double jamEquiv;

    //constructor
    public converter() {
        JFrame frame = new JFrame();
        panel1 = new JPanel();
        frame.add(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Currency Converter");
        frame.pack();
        frame.setVisible(true);
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputTextField.getText();

                //test if input field is blank and show error
                if(input.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "You cannot leave the input field blank!");
                    return;
                }
                int selectedIndex = currencyBox.getSelectedIndex();
                Double amt;
                try {
                    amt = Double.parseDouble(input);

                    switch (selectedIndex)
                    {
                        case 0 : jamEquiv = usRate * amt;
                            break;
                        case 1 : jamEquiv = canRate * amt;
                            break;
                        case 2 : jamEquiv = euroRate * amt;
                            break;
                    }
                    String str = String.format("%.2f", jamEquiv);
                    resultField.setText(str);


                    panel1.updateUI();
                    frame.revalidate();
                    //JOptionPane.showMessageDialog(null, str);
                }
                catch(NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "You MUST input only numbers!");

                }
            }
        });
        //clear fields and reset combo box to default
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputTextField.setText(" ");
                resultField.setText(" ");
                currencyBox.setSelectedIndex(0);
            }
        });
    }


    //call converter and run program
    public static void main(String[] args) {
        new converter();
    }
}
