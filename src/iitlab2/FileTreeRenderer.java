package iitlab2;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class FileTreeRenderer extends DefaultTreeCellRenderer {
	public Component getTreeCellRendererComponent(
						JTree tree,
						Object value,
						boolean sel,
						boolean expanded,
						boolean leaf,
						int row,
						boolean hasFocus
			){
		super.getTreeCellRendererComponent(
					tree, value, sel,
					expanded, leaf, row,
					hasFocus);
		FileWrap ft = (FileWrap) value;
		setToolTipText("("+ft.length()+")");
		return this;
	}
}
