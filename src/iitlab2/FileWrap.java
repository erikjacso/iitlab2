import java.io.File;

public class FileWrap {
	private File value;
	
	public FileWrap(File f){
		this.value=f;
	}

	public File getAbsoluteFile() {
		return value.getAbsoluteFile();
	}

	public String getAbsolutePath() {
		return value.getAbsolutePath();
	}

	public boolean isDirectory() {
		return value.isDirectory();
	}

	public boolean isFile() {
		return value.isFile();
	}

	public long length() {
		return value.length();
	}

	public String toString() {
		return value.getName();
	}

	public File[] listFiles() {
		return value.listFiles();
	}
	
}
