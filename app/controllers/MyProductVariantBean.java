package controllers;

import com.commercetools.sunrise.common.models.ProductVariantBean;

public class MyProductVariantBean extends ProductVariantBean {

    private boolean available;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
