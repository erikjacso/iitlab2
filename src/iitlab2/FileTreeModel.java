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

	public Object getChild(Object parent, int index) {
		FileWrap file = (FileWrap)parent;
		if (file==null) 
			return null;
		File[] tmp = file.listFiles();
		Arrays.sort(tmp);
		FileWrap result = new FileWrap(tmp[index]);
		return result;
	}

	public int getChildCount(Object parent) {
		try {
			FileWrap file = (FileWrap) parent;
			if (file==null || !file.isDirectory()) 
				return 0;
			File tmp[] = file.listFiles();
			return tmp.length;
		} catch (Exception e){
			System.out.println(e.getMessage());
			return 0;
		}

	}

	public int getIndexOfChild(Object parent, Object child) {
		FileWrap file = (FileWrap) parent;
		FileWrap childwrap = (FileWrap) child;
		if (file==null) 
			return -1;
		File[] tmp = file.listFiles();
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
		root = new FileWrap(new File(rootName));
		FileWrap[] path = { root };
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

	@Override
	public void addTreeModelListener(TreeModelListener l) {
		listeners.add(l);
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		listeners.remove(l);
	}
	
	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		
	}

}
