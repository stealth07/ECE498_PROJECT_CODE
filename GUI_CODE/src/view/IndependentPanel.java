package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import model.Command;
import model.Status;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class IndependentPanel extends JPanel {
	
    public ArrayList<JTextField> indePayloadStatus;
    public ArrayList<JToggleButton> enableBtn;
    public ArrayList<JComboBox> optionBox;
    public final ButtonGroup enableGroup = new ButtonGroup();
    public JButton btnSend;
    public JButton btnAbort; 
    public int selectedSlot = 0;
    public int optionSelected = 1;
    private boolean enable1 = false;
    private boolean enable2 = false;
    private boolean enable3 = false;
    private boolean abort = false;
    
	public JTextField textField;

    /**
     * Create the panel.
     */
    public IndependentPanel(boolean debug) {
    	setOpaque(false);
        setBackground(Color.WHITE);
        //setBackground(darkGray);
     
        enableBtn = new ArrayList<JToggleButton>();
        indePayloadStatus = new ArrayList<JTextField>();
        
        indePayloadStatus.add(new JTextField("Payload 1:"));
        indePayloadStatus.get(0).setFont(new Font("Tahoma", Font.BOLD, 14));
        indePayloadStatus.get(0).setEditable(false);
        indePayloadStatus.get(0).setColumns(10);
        add(indePayloadStatus.get(0));
       
        indePayloadStatus.add(new JTextField("Payload 2:"));
        indePayloadStatus.get(1).setFont(new Font("Tahoma", Font.BOLD, 14));
        indePayloadStatus.get(1).setEditable(false);
        indePayloadStatus.get(1).setColumns(10);
        add(indePayloadStatus.get(1));
        
        indePayloadStatus.add(new JTextField("Payload 3:"));
        indePayloadStatus.get(2).setFont(new Font("Tahoma", Font.BOLD, 14));
        indePayloadStatus.get(2).setEditable(false);
        indePayloadStatus.get(2).setColumns(10);
        add(indePayloadStatus.get(2));
        
        enableBtn.add(new JToggleButton("Enabled"));
        enableGroup.add(enableBtn.get(0));
        enableBtn.get(0).setFont(new Font("Tahoma", Font.BOLD, 16));
        add(enableBtn.get(0));
        
        enableBtn.add(new JToggleButton("Disabled"));
        enableGroup.add(enableBtn.get(1));
        enableBtn.get(1).setFont(new Font("Tahoma", Font.BOLD, 16));
        add(enableBtn.get(1));
        
        enableBtn.add(new JToggleButton("Disabled"));
        enableGroup.add(enableBtn.get(2));
        enableBtn.get(2).setFont(new Font("Tahoma", Font.BOLD, 16));
        add(enableBtn.get(2));
        
        optionBox = new ArrayList<JComboBox>();
        
        optionBox.add(new JComboBox());
        optionBox.get(0).setFont(new Font("Tahoma", Font.BOLD, 16));
        optionBox.get(0).setModel( new DefaultComboBoxModel<Object>(new String[] { "Option 1", "Option 2", "Option 3", "Option 4", "Option 5" }));
        add(optionBox.get(0));
        
        optionBox.add(new JComboBox());
        optionBox.get(1).setFont(new Font("Tahoma", Font.BOLD, 16));
        optionBox.get(1).setModel( new DefaultComboBoxModel<Object>(new String[] { "Option 1", "Option 2", "Option 3", "Option 4", "Option 5" }));
        add(optionBox.get(1));
        
        optionBox.add(new JComboBox());
        optionBox.get(2).setFont(new Font("Tahoma", Font.BOLD, 16));
        optionBox.get(2).setModel( new DefaultComboBoxModel<Object>(new String[] { "Option 1", "Option 2", "Option 3", "Option 4", "Option 5" }));
        add(optionBox.get(2));
        setLayout(new GridLayout(0, 3, 0, 0));
        
        JLabel label = new JLabel("");
        add(label);
        
        JLabel label_1 = new JLabel("");
        label_1.setIcon(null);
        add(label_1);
        
        JLabel label_2 = new JLabel("");
        add(label_2);
        
        if(!debug){
	        JLabel label_3 = new JLabel("");
	        add(label_3);
        }
        JLabel lblBlank_8 = new JLabel("");
        add(lblBlank_8);
        if(debug){
	        textField = new JTextField();
	        textField.setEnabled(false);
	        textField.setEditable(false);
	        add(textField);
	        textField.setColumns(10);
        }
        JLabel lblBlank_10 = new JLabel("");
        add(lblBlank_10);
        
        JLabel lblBlank_11 = new JLabel("");
        add(lblBlank_11);
        
        btnSend = new JButton("Send Command");
        btnSend.setOpaque(false);
        btnSend.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		
        	}
        });
        btnSend.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnSend.setBackground(Status.skyblue);
        add(btnSend);
        
        JLabel lblBlank_12 = new JLabel("");
        add(lblBlank_12);
        
        JLabel lblBlank_13 = new JLabel("");
        add(lblBlank_13);
        
        btnAbort = new JButton("Abort");
        btnAbort.setOpaque(false);
        btnAbort.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnAbort.setBackground(Status.lightYellow);
        add(btnAbort);
        
        JLabel lblBlank_14 = new JLabel("");
        lblBlank_14.setBackground(SystemColor.controlDkShadow);
        add(lblBlank_14);
        
        enableBtn.get(0).addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkSelectedSlot();
        		updateEnabledSelection();
        		System.out.println(selectedSlot);
        	}
        });
        enableBtn.get(1).addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkSelectedSlot();
        		updateEnabledSelection();
        		System.out.println(selectedSlot);
        	}
        });
        enableBtn.get(2).addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		checkSelectedSlot();
        		updateEnabledSelection();
        		System.out.println(selectedSlot);
        	}
        });
        updateEnabledSelection();
    }
	
    public int checkSelectedSlot(){
            if(enableBtn.get(0).isSelected()){
                    selectedSlot = 1; return 1;
            }
            if(enableBtn.get(1).isSelected()){
                    selectedSlot = 2; return 2;
            }
            if(enableBtn.get(2).isSelected()){
                    selectedSlot = 3; return 3;
            }
            return 0;
    }
	
    public void updateEnabledSelection(){
        switch (selectedSlot){
            case 1:
                    enable1 = !enable1;
                    if(enable1){enableBtn.get(0).setText("Enabled"); 
	                    indePayloadStatus.get(0).setEnabled(true);
	                    optionBox.get(0).setEnabled(true);
	                    optionSelected = optionBox.get(0).getSelectedIndex();
	                    enableBtn.get(0).setBackground(Status.green);
                    }else{
                    	enableBtn.get(0).setText("Disabled");
                    	indePayloadStatus.get(0).setEnabled(false);
	                    optionBox.get(0).setEnabled(false);
	                    optionSelected = optionBox.get(0).getSelectedIndex();
	                    enableBtn.get(0).setBackground(Status.red);	
	                }
                    break;
            case 2:
                    enable2 = !enable2;
                    if(enable2){enableBtn.get(1).setText("Enabled"); 
	                    indePayloadStatus.get(1).setEnabled(true);
	                    optionBox.get(1).setEnabled(true);
	                    optionSelected = optionBox.get(1).getSelectedIndex();
	                    enableBtn.get(1).setBackground(Status.green);
	                }else{
	                	enableBtn.get(1).setText("Disabled");
	                	indePayloadStatus.get(1).setEnabled(false);
	                    optionBox.get(1).setEnabled(false);
	                    optionSelected = optionBox.get(1).getSelectedIndex();
	                    enableBtn.get(1).setBackground(Status.red);	
	                }
                    break;
            case 3:
                    enable3 = !enable3;
                    if(enable3){enableBtn.get(2).setText("Enabled"); 
	                    indePayloadStatus.get(2).setEnabled(true);
	                    optionBox.get(2).setEnabled(true);
	                    optionSelected = optionBox.get(2).getSelectedIndex();
	                    enableBtn.get(2).setBackground(Status.green);
	                }else{
	                	enableBtn.get(2).setText("Disabled");
	                	indePayloadStatus.get(2).setEnabled(false);
	                    optionBox.get(2).setEnabled(false);
	                    optionSelected = optionBox.get(2).getSelectedIndex();
	                    enableBtn.get(2).setBackground(Status.red);	
	                }
                    break;
             default:
            	 enableBtn.get(0).setText("Disabled"); 
                 enableBtn.get(1).setText("Disabled"); 
                 enableBtn.get(2).setText("Disabled");
                 indePayloadStatus.get(0).setEnabled(false);
                 indePayloadStatus.get(1).setEnabled(false);
                 indePayloadStatus.get(2).setEnabled(false);
                 optionBox.get(0).setEnabled(false);
                 optionBox.get(1).setEnabled(false);
                 optionBox.get(2).setEnabled(false);
                 optionSelected = optionBox.get(0).getSelectedIndex();
                 enableBtn.get(0).setBackground(Status.red);
                 enableBtn.get(1).setBackground(Status.red);
                 enableBtn.get(2).setBackground(Status.red);
            	 break;
        }
        updateStatus(false);
    }
    
    public void updateStatus(boolean abort){
    	 Status.module.get(0).enabled = enable1;
         Status.module.get(1).enabled = enable2;
         Status.module.get(2).enabled = enable3;
         if(!abort){
            if(enable1) Status.module.get(0).command = optionBox.get(0).getSelectedIndex() + 1;
            else Status.module.get(0).command = Command.NO_COMMAND;
            if(enable2) Status.module.get(1).command = optionBox.get(1).getSelectedIndex() + 1;
            else Status.module.get(1).command = Command.NO_COMMAND;
            if(enable3) Status.module.get(2).command = optionBox.get(2).getSelectedIndex() + 1;
            else Status.module.get(2).command = Command.NO_COMMAND;
         }else{
            if(enable1) Status.module.get(0).abort = 8;
            if(enable2) Status.module.get(1).abort = 8;
            if(enable3) Status.module.get(2).abort = 8;
            Status.module.get(0).command = Command.NO_COMMAND;
            Status.module.get(1).command = Command.NO_COMMAND;
            Status.module.get(2).command = Command.NO_COMMAND;
         }
        indePayloadStatus.get(0).setText("Payload 1:  "+ Status.module.get(0).idString());
     	indePayloadStatus.get(1).setText("Payload 2:  "+ Status.module.get(1).idString());
     	indePayloadStatus.get(2).setText("Payload 3:  "+ Status.module.get(2).idString());
    }
    
    public boolean[] checkEnabled(){
    	boolean[] enabled = {false, false, false};
		
    	enabled[0] = enable3;
    	enabled[1] = enable2;
    	enabled[2] = enable1;
    	
    	return enabled;
    }

}
