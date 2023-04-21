package com.zerobase.fastlms.admin.model;

import lombok.Data;

@Data
public class CategoryInput {

    String categoryName;
    long Id;
    int sortValue;
    boolean usingYn;


}
