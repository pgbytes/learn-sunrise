package controllers;

import com.commercetools.sunrise.common.contexts.RequestScoped;
import com.commercetools.sunrise.shoppingcart.checkout.address.CheckoutAddressFormData;
import com.commercetools.sunrise.shoppingcart.checkout.address.SunriseCheckoutAddressController;

@RequestScoped
public class CheckoutAddressController extends SunriseCheckoutAddressController {

    @Override
    public Class<? extends CheckoutAddressFormData> getFormDataClass() {
        return MyCheckoutAddressFormData.class;
    }
}
