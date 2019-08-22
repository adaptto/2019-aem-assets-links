package to.adapt.demo.assetlinks.components;

import static com.day.cq.commons.jcr.JcrConstants.JCR_TITLE;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import com.day.cq.wcm.api.Page;

/**
 * Navigation component that collects in-page links for one-pager.
 */
@Model(adaptables = SlingHttpServletRequest.class)
public class OnePagerNavigation {

  @Inject
  private Page currentPage;

  private List<NavigationItem> items;

  @PostConstruct
  private void activate() {
    items = new ArrayList<>();
    Resource content = currentPage.getContentResource("root/content");
    if (content != null) {
      for (Resource section : content.getChildren()) {
        String id = section.getName();
        String title = section.getValueMap().get(JCR_TITLE, String.class);
        if (StringUtils.isNotEmpty(title)) {
          items.add(new NavigationItem(id, title));
        }
      }
    }
  }

  /**
   * @return Navigation items
   */
  public List<NavigationItem> getItems() {
    return this.items;
  }

  /**
   * Navigation item
   */
  public static final class NavigationItem {

    private final String id;
    private final String title;

    private NavigationItem(String id, String title) {
      this.id = id;
      this.title = title;
    }

    public String getId() {
      return this.id;
    }

    public String getTitle() {
      return this.title;
    }

  }

}
