package com.example.demo.serviceImp;

import com.example.demo.model.Store;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class StoreServiceImp implements IStoreService {

    @Autowired
    StoreRepository storeRepository;

    @Override
    public Store createStore(Store store) {
        store.setUuid(UUID.randomUUID().toString());
        return storeRepository.save(store);
    }

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Store getStoreById(Long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(()->new RuntimeException("The store not found"));
    }

    @Override
    public Store deleteStoreById(Long storeId) {
        Store curr = storeRepository.findById(storeId)
                .orElseThrow(()->new RuntimeException("The store not found"));
        storeRepository.deleteById(storeId);
        return curr;
    }

    @Override
    public Store updateStoreById(Long storeId, Store store) {
        Store curr = storeRepository.findById(storeId)
                .orElseThrow(()->new RuntimeException("The store not found"));
        curr.setStoreName(store.getStoreName());
        curr.setDescription(store.getDescription());
        curr.setAddress(store.getAddress());
        curr.setModifiedDate(new Date());
        return storeRepository.save(curr);
    }
}
