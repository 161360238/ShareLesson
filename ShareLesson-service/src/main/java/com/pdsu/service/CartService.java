package com.pdsu.service;

import com.pdsu.pojo.Lesson;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/21
 * @Description: com.pdsu.service
 * @version: 1.0
 */
public interface CartService {

    /**
     * 加入购物车
     *
     * @param lid
     * @return
     */
    int addCart(String lid, String uid, String cartKey);

    /**
     * 用户查看购物车
     *
     * @param uid
     * @return
     */
    List<Lesson> showCart(String uid, String cartKey);

    /**
     * 删除购物车中的商品
     *
     * @param uid
     * @param cartKey
     * @param lid
     * @return
     */
    int delectCart(String uid, String cartKey, String lid);
}
