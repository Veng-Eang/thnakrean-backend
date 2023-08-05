package com.thnakrean.backend.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface PageUtil {
    int DEFAULT_PAGE_SIZE = 6;
    int DEFAULT_PAGE_NUMBER = 1;
    String PAGE_LIMIT = "size";
    String PAGE_NUMBER = "page";
    static Pageable getPageable(int pageNumer, int pageSize) {
        if(pageNumer < DEFAULT_PAGE_NUMBER) {
            pageNumer=DEFAULT_PAGE_NUMBER;
        }
        if(pageSize<1) {
            pageSize= DEFAULT_PAGE_SIZE;
        }
        Pageable pageable= PageRequest.of(pageNumer-1, pageSize);
        return pageable;
    }
}
