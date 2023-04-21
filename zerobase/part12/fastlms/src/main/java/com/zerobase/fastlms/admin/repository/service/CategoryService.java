package com.zerobase.fastlms.admin.repository.service;

import com.zerobase.fastlms.admin.dto.CategoryDto;
import com.zerobase.fastlms.admin.model.CategoryInput;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> list();

    /**카테고리 추가
     *
     * @param categoryName
     * @return
     */
    boolean add(String categoryName);

    /**카테고리 업데이트
     *
     * @param parameter
     * @return
     */
    boolean update(CategoryInput parameter);

    /** 카테고리 삭제
     *
     * @param id
     * @return
     */
    boolean del(long id);
}
