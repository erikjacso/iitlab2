package iitlab2;

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

class FileTreeRenderer extends DefaultTreeCellRenderer {

	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {

		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
				row, hasFocus);
		FileWrap fw = (FileWrap) value;
		setToolTipText("(" + fw.length() + " bytes )");
		return this;
	}
}
