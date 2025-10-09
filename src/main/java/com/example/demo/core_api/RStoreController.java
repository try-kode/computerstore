package com.example.demo.core_api;

import com.example.demo.model.Store;
import com.example.demo.request.CreateStoreRequest;
import com.example.demo.serviceImp.StoreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
public class RStoreController {

    @Autowired
    StoreServiceImp storeServiceImp;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody CreateStoreRequest storeRequest){
        Store store = new Store();
        store.setStoreName(storeRequest.getStoreName());
        store.setDescription(storeRequest.getDescription());
        store.setAddress(storeRequest.getAddress());
        storeServiceImp.createStore(store);
        return ApiResponseStructure.singleResponse("Created", store, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll(){
        List<Store> storeList = storeServiceImp.getAllStores();
        return ApiResponseStructure.singleResponse("Success", storeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            Store store = storeServiceImp.getStoreById(id);
            return ApiResponseStructure.singleResponse("Success", store, HttpStatus.OK);
        } catch (Exception e){
            return ApiResponseStructure.singleResponse(e.getMessage(), null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody CreateStoreRequest createStoreRequest){
        try {
            Store store = storeServiceImp.getStoreById(id);
            store.setStoreName(createStoreRequest.getStoreName());
            store.setDescription(createStoreRequest.getDescription());
            store.setAddress(createStoreRequest.getAddress());
            storeServiceImp.updateStoreById(id, store);
            return ApiResponseStructure.singleResponse("Updated", store, HttpStatus.OK);
        } catch (Exception e){
            return ApiResponseStructure.singleResponse(e.getMessage(), null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try {
            Store store = storeServiceImp.getStoreById(id);
            storeServiceImp.deleteStoreById(id);
            return ApiResponseStructure.singleResponse("Deleted", store, HttpStatus.OK);
        } catch (Exception e){
            return ApiResponseStructure.singleResponse(e.getMessage(), null, HttpStatus.NOT_FOUND);
        }

    }
}
