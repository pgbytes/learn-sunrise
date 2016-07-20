package controllers;

import com.commercetools.sunrise.common.contexts.RequestScoped;
import com.commercetools.sunrise.productcatalog.productdetail.SunriseProductDetailController;
import com.commercetools.sunrise.productcatalog.productsuggestions.ProductSuggestionsControllerComponent;
import io.sphere.sdk.products.ProductProjection;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@RequestScoped
public class ProductDetailController extends SunriseProductDetailController {

    // TODO Show product by product ID and variant ID instead
    // http://localhost:9000/en/harris-wharf-blazer-abp3131-cream-M0E20000000DT1S.html
    // http://localhost:9000/en/3a2c70f5-3fad-495b-bdc0-379c6ba7d723/1.html

    @Inject
    public void setSuggestionsComponent(final ProductSuggestionsControllerComponent component) {
        registerControllerComponent(component);
    }

    // TODO Show not found product on not found variant

    @Override
    protected CompletionStage<Result> handleNotFoundVariant(ProductProjection product) {
        return CompletableFuture.completedFuture(notFoundProductResult());
    }

    // TODO Show proper not found message with given slug and SKU


    @Override
    protected Result notFoundProductResult() {
        return notFound("Product with slug " + productSlug().orElse(null) + "and sku: " + variantSku().orElse(null));
    }
}
