package se.liu.ida.geoza435.tddc69.project.resources;

import java.io.InputStream;
import java.net.URL;

/**
 * Utility class for getting resources from either the resources directory or
 * the corresponding directory in the jar file.
 */
public final class ResourceManagager {
	private ResourceManagager() {}

	public static URL getURL(String file) {
		return ResourceManagager.class.getResource(file);
	}

	public static InputStream getStream(String file) {
		return ResourceManagager.class.getResourceAsStream(file);
	}
}
