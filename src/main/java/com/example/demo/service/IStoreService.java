package com.example.demo.service;

import com.example.demo.model.Store;

import java.util.List;

public interface IStoreService {

    Store createStore(Store store);
    List<Store> getAllStores();
    Store getStoreById(Long storeId);
    Store deleteStoreById(Long storeId);
    Store updateStoreById(Long storeId, Store store);
}
