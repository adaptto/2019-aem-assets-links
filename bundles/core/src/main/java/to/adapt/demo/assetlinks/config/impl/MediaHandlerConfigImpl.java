package to.adapt.demo.assetlinks.config.impl;

import org.jetbrains.annotations.NotNull;
import org.osgi.service.component.annotations.Component;

import com.day.cq.wcm.api.Page;

import io.wcm.handler.media.spi.MediaHandlerConfig;

/**
 * Media handler configuration.
 */
@Component(service = MediaHandlerConfig.class)
public class MediaHandlerConfigImpl extends MediaHandlerConfig {

  static final String DAM_ROOT = "/content/dam/assetlinksdemo";

  @Override
  public boolean useAdobeStandardNames() {
    // use standard names for asset references as used by the core components
    return true;
  }

  @Override
  public @NotNull String getDamRootPath(@NotNull Page page) {
    return DAM_ROOT;
  }

}
