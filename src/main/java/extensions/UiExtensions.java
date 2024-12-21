package extensions;

import com.google.inject.Guice;
import com.google.inject.Injector;
import modules.GuiceModule;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class UiExtensions implements BeforeEachCallback, AfterEachCallback {

    private Injector injector;

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        injector = Guice.createInjector(new GuiceModule());
        injector.injectMembers(context.getTestInstance().get());
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {

    }
}
