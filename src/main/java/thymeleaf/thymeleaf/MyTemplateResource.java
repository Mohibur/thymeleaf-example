package thymeleaf.thymeleaf;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.thymeleaf.templateresource.ITemplateResource;

import org.thymeleaf.util.StringUtils;
import org.thymeleaf.util.Validate;

public class MyTemplateResource implements ITemplateResource {
	private final String path;
	private final String characterEncoding;

	public MyTemplateResource(final String path, final String characterEncoding) {

		super();
		Validate.notEmpty(path, "Resource Path cannot be null or empty");
		final String cleanPath = TemplateResourceUtils.cleanPath(path);
		this.path = (cleanPath.charAt(0) != '/' ? ("/" + cleanPath) : cleanPath);
		this.characterEncoding = characterEncoding;
	}

	public String getDescription() {
		return this.path;
	}

	public String getBaseName() {
		return TemplateResourceUtils.computeBaseName(this.path);
	}

	public Reader reader() throws IOException {

		final InputStream inputStream = this.getClass().getResourceAsStream(this.path);
		if (inputStream == null) {
			throw new FileNotFoundException(String.format("ServletContext resource \"%s\" does not exist", this.path));
		}

		if (!StringUtils.isEmptyOrWhitespace(this.characterEncoding)) {
			return new BufferedReader(
					new InputStreamReader(new BufferedInputStream(inputStream), this.characterEncoding));
		}

		return new BufferedReader(new InputStreamReader(new BufferedInputStream(inputStream)));

	}

	public ITemplateResource relative(final String relativeLocation) {

		Validate.notEmpty(relativeLocation, "Relative Path cannot be null or empty");

		final String fullRelativeLocation = TemplateResourceUtils.computeRelativeLocation(this.path, relativeLocation);
		return new MyTemplateResource(fullRelativeLocation, this.characterEncoding);

	}

	public boolean exists() {
		return (this.getClass().getResource(this.path) != null);

	}
}
