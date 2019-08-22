package to.adapt.demo.assetlinks.config;

import org.jetbrains.annotations.NotNull;

import io.wcm.wcm.commons.util.Template;
import io.wcm.wcm.commons.util.TemplatePathInfo;

/**
 * List of templates with special handling in code.
 */
public enum AppTemplate implements TemplatePathInfo {

  /**
   * Structure element
   */
  ADMIN_STRUCTURE_ELEMENT("/apps/assetlinksdemo/core/templates/admin/structureElement"),

  /**
   * Redirect
   */
  ADMIN_REDIRECT("/apps/assetlinksdemo/core/templates/admin/redirect"),

  /**
   * Content page
   */
  CONTENTPAGE("/conf/assetlinksdemo/settings/wcm/templates/contentpage"),

  /**
   * Home page
   */
  HOMEPAGE("/conf/assetlinksdemo/settings/wcm/templates/homepage");

  private final String templatePath;
  private final String resourceType;

  AppTemplate(String templatePath) {
    this.templatePath = templatePath;
    this.resourceType = Template.getResourceTypeFromTemplatePath(templatePath);
  }

  AppTemplate(String templatePath, String resourceType) {
    this.templatePath = templatePath;
    this.resourceType = resourceType;
  }

  /**
   * Template path
   * @return Path
   */
  @Override
  public @NotNull String getTemplatePath() {
    return templatePath;
  }

  /**
   * Resource type
   * @return Path
   */
  @Override
  public String getResourceType() {
    return resourceType;
  }

}
