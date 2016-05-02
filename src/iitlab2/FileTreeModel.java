import java.util.*;
import java.io.File;

import javax.swing.event.*;
import javax.swing.tree.*;

class FileTreeModel implements TreeModel {
	ArrayList<TreeModelListener> listeners;
	FileWrap root;

	public FileTreeModel() {
		listeners = new ArrayList<TreeModelListener>();
	}

	public void addTreeModelListener(TreeModelListener l) {
		listeners.add(l);
	}

	public void removeTreeModelListener(TreeModelListener l) {
		listeners.remove(l);
	}

	public Object getChild(Object parent, int index) {
		FileWrap p = (FileWrap) parent;
		File[] dm = p.listFiles();
		Arrays.sort(dm);
		FileWrap[] wraps = new FileWrap[dm.length];
		for (int i = 0; i < dm.length; i++) {
			wraps[i] = new FileWrap(dm[i]);
		}
		return wraps[index];
	}

	public int getChildCount(Object parent) {
		FileWrap fw = (FileWrap) parent;
		if (fw.isDirectory()) {
			File[] directoryMembers = fw.listFiles();
			return directoryMembers.length;
		} else
			return 0;
	}

	public int getIndexOfChild(Object parent, Object child) {
		FileWrap parentFW = (FileWrap) parent;
		FileWrap childFW = (FileWrap) child;
		File[] members = parentFW.listFiles();
		int index = -1;
		for (int i = 0; i < members.length; i++) {
			if (members[i].getAbsoluteFile().equals(childFW.getAbsoluteFile())) {
				index = i;
				break;
			}
		}
		return index;
	}

	public FileWrap getRoot() {
		return root;
	}

	public void setRoot(String rootName) {
		this.root = new FileWrap(new File(rootName));
		FileWrap[] path = { this.root };
		TreeModelEvent e = new TreeModelEvent(this, path);
		for (TreeModelListener tml : listeners) {
			tml.treeStructureChanged(e);
		}
	}

	public boolean isLeaf(Object node) {
		return ((FileWrap) node).isFile();
	}

	public void valueForPathChanged(TreePath path, Object newValue) {
	}

}
