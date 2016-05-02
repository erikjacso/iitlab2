import java.awt.BorderLayout;
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
	JComboBox<String> cb;
	FileTreeModel ftm;

	public void actionPerformed(ActionEvent ae) {
		Object newSelection = cb.getSelectedItem();
		ftm.setRoot(newSelection.toString());
	}

	static public void main(String args[]) {
		(new TreeTest()).run();
	}

	public void run() {
		JFrame f = new JFrame("JTree Example");
		cb = new JComboBox<String>();
		Iterable<Path> rootDirs = FileSystems.getDefault().getRootDirectories();
		for (Path dir : rootDirs) {
			cb.addItem(dir.toString());
		}
		ftm = new FileTreeModel();
		ftm.setRoot(cb.getItemAt(0));
		JTree tree = new JTree(ftm);
		ToolTipManager.sharedInstance().registerComponent(tree);
		tree.setCellRenderer(new FileTreeRenderer());
		JScrollPane scrollPane = new JScrollPane(tree);
		cb.addActionListener(this);
		f.add(cb, BorderLayout.NORTH);
		f.add(scrollPane, BorderLayout.CENTER);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.pack();
		f.show();
	}
}
