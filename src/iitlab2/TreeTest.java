package iitlab2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ToolTipManager;

public class TreeTest implements ActionListener {
	FileTreeModel fileTreeModel;
	JComboBox<String> comboBox;
	

	public void actionPerformed(ActionEvent ae) {
		Object newSelection = comboBox.getSelectedItem();
		fileTreeModel.setRoot(newSelection.toString());
	}

	static public void main(String args[]) {
		(new TreeTest()).run();
	}

	public void run() {
		JFrame f = new JFrame("Directory list");
		f.setPreferredSize(new Dimension(500, 500));
		comboBox = new JComboBox<String>();
		Iterable<Path> rootDirs = FileSystems.getDefault().getRootDirectories();
		for (Path dir : rootDirs) {
			comboBox.addItem(dir.toString());
		}
		fileTreeModel = new FileTreeModel();
		fileTreeModel.setRoot(comboBox.getItemAt(0));
		JTree tree = new JTree(fileTreeModel);
		ToolTipManager.sharedInstance().registerComponent(tree);
		tree.setCellRenderer(new FileTreeRenderer());
		JScrollPane scrollPane = new JScrollPane(tree);
		comboBox.addActionListener(this);
		f.add(comboBox, BorderLayout.NORTH);
		f.add(scrollPane, BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
}
