package to.adapt.demo.assetlinks.config.impl;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.osgi.service.component.annotations.Component;

import com.day.cq.wcm.api.Page;

import io.wcm.handler.link.spi.LinkHandlerConfig;
import io.wcm.handler.link.type.MediaLinkType;
import io.wcm.wcm.commons.util.Template;

import to.adapt.demo.assetlinks.config.AppTemplate;

/**
 * Link handler configuration.
 */
@Component(service = LinkHandlerConfig.class)
public class LinkHandlerConfigImpl extends LinkHandlerConfig {

  @Override
  public boolean isValidLinkTarget(@NotNull Page page) {
    return !Template.is(page, AppTemplate.ADMIN_STRUCTURE_ELEMENT);
  }

  @Override
  public boolean isRedirect(@NotNull Page page) {
    return Template.is(page, AppTemplate.ADMIN_REDIRECT);
  }

  @Override
  public @Nullable String getLinkRootPath(@NotNull Page page, @NotNull String linkTypeId) {
    if (StringUtils.equals(linkTypeId, MediaLinkType.ID)) {
      return MediaHandlerConfigImpl.DAM_ROOT;
    }
    return super.getLinkRootPath(page, linkTypeId);
  }

}
