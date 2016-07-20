package controllers;

import com.commercetools.sunrise.common.models.ProductVariantBean;
import com.commercetools.sunrise.common.models.ProductVariantBeanFactory;
import io.sphere.sdk.products.ProductProjection;
import io.sphere.sdk.products.ProductVariant;

public class MyProductVariantBeanFactory extends ProductVariantBeanFactory {

    @Override
    public ProductVariantBean create(ProductProjection product, ProductVariant variant) {
        final MyProductVariantBean bean = new MyProductVariantBean();
        initialize(bean, product, variant);
        bean.setAvailable(true);
        return bean;
    }
}
