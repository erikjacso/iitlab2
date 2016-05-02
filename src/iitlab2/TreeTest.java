package iitlab2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ToolTipManager;


public class TreeTest implements ActionListener {

		JComboBox rolldown = new JComboBox();
	    FileTreeModel ftm;
	    public void actionPerformed(ActionEvent ae) {
		double d = Double.parseDouble(tf.getText());

	    static public void main(String args[]) {
		(new TreeTest()).run();
	    }
	    public void run() {
		
	    JFrame f = new JFrame("JTree Example");
		ftm = new FileTreeModel();
		JTree tree = new JTree(ftm);
		ToolTipManager.sharedInstance().registerComponent(tree);
		tree.setCellRenderer(new FileTreeRenderer());
		JScrollPane scrollPane = new JScrollPane(tree);
		
		f.addActionListener(this);
		f.add(tf, BorderLayout.SOUTH);
		f.add(scrollPane, BorderLayout.CENTER);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.pack();
		f.show();
	    
}
