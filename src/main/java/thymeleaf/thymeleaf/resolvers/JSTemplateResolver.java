package thymeleaf.thymeleaf.resolvers;

import java.util.Map;

import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.AbstractConfigurableTemplateResolver;
import org.thymeleaf.templateresource.ITemplateResource;

import thymeleaf.thymeleaf.MyTemplateResource;

public class JSTemplateResolver extends AbstractConfigurableTemplateResolver {
	public JSTemplateResolver() {
		setTemplateMode(TemplateMode.JAVASCRIPT);
		setPrefix("/templates/static/js/");
		setSuffix(".js");
		setCacheTTLMs(Long.valueOf(3600000L));
		setCacheable(true);
	}

	@Override
	protected ITemplateResource computeTemplateResource(IEngineConfiguration configuration, String ownerTemplate,
			String template, String resourceName, String characterEncoding,
			Map<String, Object> templateResolutionAttributes) {

		return new MyTemplateResource(resourceName, characterEncoding);
	}
}
