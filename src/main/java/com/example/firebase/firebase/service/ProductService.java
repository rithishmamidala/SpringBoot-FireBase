package com.example.firebase.firebase.service;

import com.example.firebase.firebase.entity.Product;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.protobuf.Api;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class ProductService {
    private static final String COLLECTION_NAME = "products" ;

    public String saveProduct (Product product) throws ExecutionException, InterruptedException {

        Firestore dbFireStorage = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> colletionApiFuture=    dbFireStorage.collection(COLLECTION_NAME).document(product.getName()).set(product);

        return  colletionApiFuture.get().getUpdateTime().toString();

    }

    public Product getProduct(String name) throws ExecutionException, InterruptedException {
        Firestore dbFireStorage = FirestoreClient.getFirestore();
       DocumentReference documentReference =    dbFireStorage.collection(COLLECTION_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();
        Product product = null;
        if(document.exists()) {
            product = document.toObject(Product.class);
            return product;
        }
        else
        {
            return null;
        }


    }
    public String updateProduct (Product product) throws ExecutionException, InterruptedException {

        Firestore dbFireStorage = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> colletionApiFuture=    dbFireStorage.collection(COLLECTION_NAME).document(product.getName()).set(product);

        return  colletionApiFuture.get().getUpdateTime().toString();

    }
    public String deleteProduct (String name) throws ExecutionException, InterruptedException {

        Firestore dbFireStorage = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> colletionApiFuture=    dbFireStorage.collection(COLLECTION_NAME).document(name).delete();

        return  "Deleted Successfully";

    }

}
