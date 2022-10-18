package com.Rishabh.ecommerce_cartlist.service;

import com.Rishabh.ecommerce_cartlist.common.ApiResponse;
import com.Rishabh.ecommerce_cartlist.entity.CartItem;
import com.Rishabh.ecommerce_cartlist.error.CartItemNotFound_Exception;

import java.util.List;
import java.util.Optional;

public interface CartItem_Service {
    public ApiResponse saveCartItem(CartItem cartItem);

    public ApiResponse fetchCartItemList() throws CartItemNotFound_Exception;

    public ApiResponse fetchCartItemListById(Long id) throws CartItemNotFound_Exception;

    public ApiResponse deleteCartItemsById(Long id);

    public ApiResponse deleteCartItems();

    public ApiResponse updateCartItem(Long id, CartItem cartItem);
}
