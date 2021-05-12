package com.feuersoft.ecommerce.dto;

import com.sun.istack.NotNull;
import lombok.Data;

/**
 * Created by ffeuerbacher on 5/10/2021
 */

@Data
public class PurchaseResponse {

    @NotNull
    private final String orderTrackingNumber;
}
