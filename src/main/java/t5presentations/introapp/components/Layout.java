package t5presentations.introapp.components;

import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.PersistentLocale;

import java.util.Locale;

/**
 * Layout component for pages of application introapp.
 */
@Import(stylesheet = "context:layout/layout.css")
public class Layout {
    /**
     * The page title, for the <title> element and the <h1>element.
     */
    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String title;

    @Property
    private String pageName;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String sidebarTitle;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private Block sidebar;

    @Inject
    @Symbol(SymbolConstants.SUPPORTED_LOCALES)
    private String supportedLocales;

    @Property
    private String localeName;

    @Inject
    private AssetSource assetSource;

    @Inject
    private ComponentResources resources;

    @Inject
    private PersistentLocale persistentLocale;

    public String getClassForPageName() {
        return resources.getPageName().equalsIgnoreCase(pageName) ? "current_page_item"
                : null;
    }

    public String[] getPageNames() {
        return new String[]{"Index", "Games", "About"};
    }

    public String[] getLocaleNames() {
        return supportedLocales.split(",");
    }

    public Asset getFlagAsset() {
        return assetSource.getContextAsset(String.format("/flags/%s.png",
                localeName), null);
    }

    public String getLocaleDescription() {
        Locale locale = new Locale(localeName);

        return locale.getDisplayLanguage(locale);
    }

    void onActionFromSelectLocale(String localeName) {
        persistentLocale.set(new Locale(localeName));
    }
}
