package se.liu.ida.geoza435.tddc69.project.resources;

import java.io.InputStream;
import java.net.URL;

public class ResourceManagager {
	public static URL getURL(String file) {
		return ResourceManagager.class.getResource(file);
	}

	public static InputStream getStream(String file) {
		return ResourceManagager.class.getResourceAsStream(file);
	}
}
