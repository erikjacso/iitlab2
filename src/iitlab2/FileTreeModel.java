package iitlab2;

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
		FileWrap ft = (FileWrap)parent;
		if (ft==null) 
			return null;
		File[] tmp = ft.listFiles();
		Arrays.sort(tmp);
		FileWrap result = new FileWrap(tmp[index]);
		return result;
	}

	public int getChildCount(Object parent) {
		FileWrap ft = (FileWrap) parent;
		if (ft==null || !ft.isDirectory()) 
			return 0;
		File tmp[] = ft.listFiles();
		return tmp.length;
	}

	public int getIndexOfChild(Object parent, Object child) {
		FileWrap ft = (FileWrap) parent;
		FileWrap childwrap = (FileWrap) child;
		if (ft==null) 
			return -1;
		File[] tmp = ft.listFiles();
		Arrays.sort(tmp);
		for (int i=0; i<tmp.length; i++){
			if(childwrap.getPath().equals(tmp[i].getPath()))
				return i;
		}
		return 0;
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
		FileWrap ft = (FileWrap)node;
		if (ft.isDirectory())
			return false;
		return true;
	}

	public void valueForPathChanged(TreePath path, Object newValue) {
	}

}
