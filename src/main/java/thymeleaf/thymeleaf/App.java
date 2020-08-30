package thymeleaf.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import thymeleaf.thymeleaf.resolvers.CSSTemplateResolver;
import thymeleaf.thymeleaf.resolvers.HTMLTemplateResolver;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		final Context ctx = new Context();
		TemplateEngine templateEngine = new TemplateEngine();

		templateEngine.addTemplateResolver(new HTMLTemplateResolver());
		// templateEngine.addTemplateResolver(new CSSTemplateResolver());
		// templateEngine.addTemplateResolver(new JSTemplateResolver());
		List<String> messages = new ArrayList<String>();
		messages.add("Hello");
		messages.add("Lazy");
		messages.add("World");
		ctx.setVariable("msgs", messages);
		System.out.println(templateEngine.process("hello.html", ctx));
		System.out.println("---------------------------------------------------------");
		
		TemplateEngine templateEngineCss = new TemplateEngine();
		templateEngineCss.addTemplateResolver(new CSSTemplateResolver());
		Context context = new Context();
		context.setVariable("fontSize", 10);
		System.out.println(templateEngineCss.process("main", context));
	}
}
