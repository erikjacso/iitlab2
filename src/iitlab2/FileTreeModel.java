package iitlab2;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class FileTreeModel implements TreeModel{
	FileWrap root;
	ArrayList<TreeModelListener> listeners;
	
	public FileTreeModel(){
		listeners = new ArrayList<TreeModelListener>();
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {
		listeners.add(l);
		
	}
	@Override
	public Object getChild(Object parent, int index) {
		FileWrap ft = (FileWrap)parent;
		if (ft==null) 
			return null;
		File[] tmp = ft.listFiles();
		Arrays.sort(tmp);
		FileWrap result = new FileWrap(tmp[index]);
		return result;
	}

	@Override
	public int getChildCount(Object parent) {
		FileWrap ft = (FileWrap) parent;
		if (ft==null || !ft.isDirectory()) 
			return 0;
		File tmp[] = ft.listFiles();
		return tmp.length;
	}

	@Override
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

	@Override
	public Object getRoot() {
		return root;
	}

	@Override
	public boolean isLeaf(Object node) {
		FileWrap ft = (FileWrap)node;
		if (ft.isDirectory())
			return false;
		return true;
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		listeners.remove(l);
		
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
		
	}
	public void setRoot(FileWrap f){
		
	}

}
