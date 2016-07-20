package controllers;

import com.commercetools.sunrise.framework.ControllerComponent;
import com.commercetools.sunrise.hooks.ProductProjectionSearchFilterHook;
import io.sphere.sdk.products.search.ProductProjectionSearch;

public class ProductAvailabilityComponent implements ControllerComponent, ProductProjectionSearchFilterHook {
    @Override
    public ProductProjectionSearch filterQuery(ProductProjectionSearch search) {
        return search.plusQueryFilters(product -> product.allVariants().scopedPrice().currentValue().centAmount()
        .isGreaterThanOrEqualTo(50000L));
    }
}
