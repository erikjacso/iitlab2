package iitlab2;

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

class FileTreeRenderer extends DefaultTreeCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8688598660161050823L;

    public Component getTreeCellRendererComponent(
            JTree tree,
            Object value,
            boolean sel,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {

        super.getTreeCellRendererComponent(
                tree, value, sel,
                expanded, leaf, row,
                hasFocus);
        
		FileWrap fileWrap = (FileWrap) value;
		setToolTipText("(" + fileWrap.length() + " bytes )");
			return this;
	}
}
