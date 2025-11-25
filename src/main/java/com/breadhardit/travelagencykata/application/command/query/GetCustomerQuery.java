package com.breadhardit.travelagencykata.application.command.query;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GetCustomerQuery {
    @Builder.Default
    String passport = "";
    @Builder.Default
    String id = "";

}
