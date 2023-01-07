import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//TODO: Add Check box https://www.youtube.com/watch?v=GwxvLzQoMYM
public class CheckBoxFrame extends JFrame implements ActionListener {


    private final CleanerController cleaner = new CleanerController();
    private final JButton button = new JButton();
    private final JCheckBox checkBoxDeleteTemp = new JCheckBox();
    private final JCheckBox checkBoxDeleteAdminTemp = new JCheckBox();

    private boolean tempDeleted = false;
    private boolean tempAdminDeleted = false;

    public CheckBoxFrame() throws HeadlessException {
        this.setTitle("MiniCleaner");


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        button.setText("Clean");
        button.addActionListener(this);

        checkBoxDeleteTemp.setText("Clear temp files from here " + cleaner.getTempPath());
        checkBoxDeleteTemp.setFont(new Font("Consolas",Font.PLAIN,15));

        checkBoxDeleteAdminTemp.setText("Clear temp files from here " + cleaner.getAdminTempPath());
        checkBoxDeleteAdminTemp.setFont(new Font("Consolas",Font.PLAIN,15));

        this.add(checkBoxDeleteTemp);
        this.add(checkBoxDeleteAdminTemp);

        this.add(new JLabel("To delete more files, run this program as administration", SwingConstants.CENTER),BorderLayout.CENTER);
        this.add(button);


        this.pack();
        this.setVisible(true);
        this.setSize(700,700);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            if (!checkBoxDeleteTemp.isSelected() && !checkBoxDeleteAdminTemp.isSelected()){
                JOptionPane.showMessageDialog(null,"You should choose at least one of them");
            }
            if (checkBoxDeleteTemp.isSelected()){
                cleaner.cleanTempPath();
                tempDeleted = true;


            }
            if (checkBoxDeleteAdminTemp.isSelected()){
                cleaner.cleanAdminTempPath();
                tempDeleted = true;

            }
        }
        if (tempDeleted || tempAdminDeleted){
            JOptionPane.showMessageDialog(null,"The files was deleted!");
            tempDeleted = false;
            tempAdminDeleted = false;
        }

    }
}
