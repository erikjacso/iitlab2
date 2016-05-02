package iitlab2;
import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class FileTreeRenderer extends DefaultTreeCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		setToolTipText("("+ft.length()+" B )");
		return this;
	}
}