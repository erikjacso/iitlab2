package iitlab2;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;

public class FileWrap {
	private File value;
	
	public FileWrap(File f){
		value = f;
	}


	public boolean canExecute() {
		return value.canExecute();
	}

	public boolean canRead() {
		return value.canRead();
	}

	public boolean canWrite() {
		return value.canWrite();
	}

	public int compareTo(File arg0) {
		return value.compareTo(arg0);
	}

	public boolean createNewFile() throws IOException {
		return value.createNewFile();
	}

	public boolean delete() {
		return value.delete();
	}

	public void deleteOnExit() {
		value.deleteOnExit();
	}

	public boolean equals(Object arg0) {
		return value.equals(arg0);
	}

	public boolean exists() {
		return value.exists();
	}

	public File getAbsoluteFile() {
		return value.getAbsoluteFile();
	}

	public String getAbsolutePath() {
		return value.getAbsolutePath();
	}

	public File getCanonicalFile() throws IOException {
		return value.getCanonicalFile();
	}

	public String getCanonicalPath() throws IOException {
		return value.getCanonicalPath();
	}

	public long getFreeSpace() {
		return value.getFreeSpace();
	}

	public String getName() {
		return value.getName();
	}

	public String getParent() {
		return value.getParent();
	}

	public File getParentFile() {
		return value.getParentFile();
	}

	public String getPath() {
		return value.getPath();
	}

	public long getTotalSpace() {
		return value.getTotalSpace();
	}

	public long getUsableSpace() {
		return value.getUsableSpace();
	}

	public int hashCode() {
		return value.hashCode();
	}

	public boolean isAbsolute() {
		return value.isAbsolute();
	}

	public boolean isDirectory() {
		return value.isDirectory();
	}

	public boolean isFile() {
		return value.isFile();
	}

	public boolean isHidden() {
		return value.isHidden();
	}

	public long lastModified() {
		return value.lastModified();
	}

	public long length() {
		return value.length();
	}

	public String[] list() {
		return value.list();
	}

	public String[] list(FilenameFilter arg0) {
		return value.list(arg0);
	}

	public File[] listFiles() {
		return value.listFiles();
	}

	public File[] listFiles(FileFilter arg0) {
		return value.listFiles(arg0);
	}

	public File[] listFiles(FilenameFilter arg0) {
		return value.listFiles(arg0);
	}

	public boolean mkdir() {
		return value.mkdir();
	}

	public boolean mkdirs() {
		return value.mkdirs();
	}

	public boolean renameTo(File arg0) {
		return value.renameTo(arg0);
	}

	public boolean setExecutable(boolean arg0, boolean arg1) {
		return value.setExecutable(arg0, arg1);
	}

	public boolean setExecutable(boolean arg0) {
		return value.setExecutable(arg0);
	}

	public boolean setLastModified(long arg0) {
		return value.setLastModified(arg0);
	}

	public boolean setReadOnly() {
		return value.setReadOnly();
	}

	public boolean setReadable(boolean arg0, boolean arg1) {
		return value.setReadable(arg0, arg1);
	}

	public boolean setReadable(boolean arg0) {
		return value.setReadable(arg0);
	}

	public boolean setWritable(boolean arg0, boolean arg1) {
		return value.setWritable(arg0, arg1);
	}

	public boolean setWritable(boolean arg0) {
		return value.setWritable(arg0);
	}

	public Path toPath() {
		return value.toPath();
	}

	@Override
	public String toString() {
		return value.getName();
	}

	public URI toURI() {
		return value.toURI();
	}

}
