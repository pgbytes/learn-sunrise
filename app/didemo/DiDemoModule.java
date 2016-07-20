package didemo;

import com.commercetools.sunrise.common.categorytree.CategoryTreeInNewProvider;
import com.commercetools.sunrise.common.contexts.RequestScoped;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import io.sphere.sdk.categories.CategoryTree;
import play.Configuration;
import play.inject.ConfigurationProvider;

import javax.inject.Singleton;

public class DiDemoModule extends AbstractModule {
    @Override
    protected void configure() {
        // CLASS
//        bind(InjectionSubject.class).in(Singleton.class);
        bind(InjectionSubject.class).in(RequestScoped.class);

        // SUBCLASS
//        bind(SubclassInjectionSubject.class).in(Singleton.class);
        bind(SubclassInjectionSubject.class).in(RequestScoped.class);

        bind(Configuration.class).to(new MyConfiguration.class);
        bind(Configuration.class).toInstance(new MyConfiguration.class);
        bind(Configuration.class).toProvider(ConfigurationProvider.class);

        // Inject with annotation
        bind(CategoryTree.class).annotatedWith(Names.named("new")).toProvider(CategoryTreeInNewProvider.class).in(Singleton.class);

    }
}

/**
 * Request Scope - instantiates the class on every request.
 * Singleton - only once
 * default scope -> prototype scope
 */
