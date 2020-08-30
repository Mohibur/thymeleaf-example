package thymeleaf.thymeleaf.resolvers;

import java.util.Map;

import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.AbstractConfigurableTemplateResolver;
import org.thymeleaf.templateresource.ITemplateResource;

import thymeleaf.thymeleaf.MyTemplateResource;

public class CSSTemplateResolver extends AbstractConfigurableTemplateResolver {
	public CSSTemplateResolver() {
		setTemplateMode(TemplateMode.CSS);
		setPrefix("/templates/static/css/");
		setSuffix(".css");
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
