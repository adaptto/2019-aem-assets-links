package to.adapt.demo.assetlinks.components;

import static com.day.cq.commons.jcr.JcrConstants.JCR_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import to.adapt.demo.assetlinks.components.OnePagerNavigation.NavigationItem;
import to.adapt.demo.assetlinks.testcontext.AppAemContext;

@ExtendWith(AemContextExtension.class)
class OnePagerNavigationTest {

  private final AemContext context = AppAemContext.newAemContext();

  @BeforeEach
  void setUp() throws Exception {
    context.currentPage(context.create().page("/content/site1/en"));
  }

  @Test
  @SuppressWarnings("null")
  void testWithItems() {
    context.build().resource(context.currentPage().getContentResource().getPath() + "/root/content")
        .siblingsMode()
        .resource("section1", JCR_TITLE, "Section 1")
        .resource("section2")
        .resource("section3", JCR_TITLE, "Section 3");

    OnePagerNavigation underTest = context.request().adaptTo(OnePagerNavigation.class);
    List<NavigationItem> items = underTest.getItems();

    assertEquals(2, items.size());
    assertEquals("section1", items.get(0).getId());
    assertEquals("Section 1", items.get(0).getTitle());
    assertEquals("section3", items.get(1).getId());
    assertEquals("Section 3", items.get(1).getTitle());
  }

  @Test
  @SuppressWarnings("null")
  void testWithoutItems() {
    OnePagerNavigation underTest = context.request().adaptTo(OnePagerNavigation.class);
    List<NavigationItem> items = underTest.getItems();

    assertEquals(0, items.size());
  }

}
