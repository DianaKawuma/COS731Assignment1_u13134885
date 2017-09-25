package com.cos731.bellisimo.service.request;

import com.cos731.bellisimo.Request;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateFoodItemRequest extends Request{
    private static final long serialVersionUID = -3412424054853591807L;
    private String itemName;

    private Long price;

    private String photolink;

    private String category;

    private String categoryType;
}
