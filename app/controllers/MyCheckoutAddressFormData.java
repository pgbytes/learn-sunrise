package controllers;

import com.commercetools.sunrise.shoppingcart.checkout.address.DefaultCheckoutAddressFormData;
import io.sphere.sdk.carts.Cart;
import io.sphere.sdk.models.Address;
import play.data.validation.Constraints;

public class MyCheckoutAddressFormData extends DefaultCheckoutAddressFormData {

    @Constraints.Required
    private String mobileShipping;

    public String getMobileShipping() {
        return mobileShipping;
    }

    public void setMobileShipping(String mobileShipping) {
        this.mobileShipping = mobileShipping;
    }

    @Override
    public Address toShippingAddress() {
        return super.toShippingAddress().withMobile(mobileShipping);
    }

    @Override
    public void setData(Cart cart) {
        super.setData(cart);
        if (cart.getShippingAddress() != null) {
            this.mobileShipping = cart.getShippingAddress().getMobile();
        }
    }
}
