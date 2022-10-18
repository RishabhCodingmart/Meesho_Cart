package com.Rishabh.ecommerce_cartlist.service;

import com.Rishabh.ecommerce_cartlist.common.ApiResponse;
import com.Rishabh.ecommerce_cartlist.entity.Cart;
import com.Rishabh.ecommerce_cartlist.entity.CartItem;
import com.Rishabh.ecommerce_cartlist.error.CartNotFound_Exception;
import com.Rishabh.ecommerce_cartlist.repository.Cart_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Cart_Service_Impl implements Cart_Service{

    private final Cart_Repository cart_repository;
    @Autowired
    public Cart_Service_Impl(Cart_Repository cart_repository) {this.cart_repository = cart_repository;}
    @Override
    public ApiResponse saveCart(Cart cart) {
        ApiResponse apiResponse=new ApiResponse();
        cart=cart_repository.save(cart);
        apiResponse.setData(cart);
        return apiResponse;
    }

    @Override
    public ApiResponse fetchCartList() throws CartNotFound_Exception {
        ApiResponse apiResponse=new ApiResponse();
        List<Cart> list=cart_repository.findAll();
        if(list.isEmpty()){
            throw new CartNotFound_Exception("No cart details are present");
        }
        apiResponse.setData(list);
        return apiResponse;
    }

    @Override
    public ApiResponse fetchCartListById(Long cart_id) throws CartNotFound_Exception {
        ApiResponse apiResponse=new ApiResponse();
        Optional<Cart> cart=cart_repository.findById(cart_id);
        if(!cart.isPresent()){
            throw new CartNotFound_Exception("Cart not available");
        }
        apiResponse.setData(cart);
        return apiResponse;
    }

    @Override
    public ApiResponse deleteCart() {
        ApiResponse apiResponse=new ApiResponse();
        cart_repository.deleteAll();
        String s="All Cart records deleted";
        apiResponse.setData(s);
        return apiResponse;
    }

    @Override
    public ApiResponse deleteCartById(Long cart_id) {
        ApiResponse apiResponse=new ApiResponse();
        cart_repository.deleteById(cart_id);
        String s="Cart record deleted";
        apiResponse.setData(cart_id+" "+s);
        return apiResponse;
    }
}
