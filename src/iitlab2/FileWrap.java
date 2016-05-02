package iitlab2;

import java.io.File;

public class FileWrap {
	private File file;

	public FileWrap(File f) {
		this.file = f;
	}

	public boolean isDirectory() {
		return file.isDirectory();
	}

	public long length() {
		return file.length();
	}

	public String toString() {
		return file.getName();
	}

	public File[] listFiles() {
		return file.listFiles();
	}

	public String getPath() {
		return file.getPath();
	}

	public boolean isFile() {
		return file.isFile();
	}

}
