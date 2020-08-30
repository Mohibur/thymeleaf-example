package thymeleaf.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import thymeleaf.thymeleaf.resolvers.CSSTemplateResolver;
import thymeleaf.thymeleaf.resolvers.HTMLTemplateResolver;
import thymeleaf.thymeleaf.resolvers.RawTemplateResolver;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		processHtml();
		processCss();
		processRaw();

	}

	private static void processCss() {
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.addTemplateResolver(new CSSTemplateResolver());
		Context context = new Context();
		context.setVariable("fontSize", 10);
		System.out.println(templateEngine.process("main", context));
		System.out.println("---------------------------------------------------------");
	}

	private static List<String> messages() {
		List<String> ret = new ArrayList<String>();
		ret.add("Hello");
		ret.add("Lazy");
		ret.add("World");
		return ret;
	}

	private static void processHtml() {
		final Context context = new Context();
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.addTemplateResolver(new HTMLTemplateResolver());
		context.setVariable("msgs", messages());
		System.out.println(templateEngine.process("hello.html", context));
		System.out.println("---------------------------------------------------------");

	}

	private static void processRaw() {
		Context context = new Context();
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.addTemplateResolver(new RawTemplateResolver());
		context.setVariable("packageName", "common.style");
		context.setVariable("msgs", messages());
		System.out.println(templateEngine.process("main", context));
		System.out.println("---------------------------------------------------------");
	}
}
