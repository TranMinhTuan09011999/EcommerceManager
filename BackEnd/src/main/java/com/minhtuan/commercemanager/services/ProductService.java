package com.minhtuan.commercemanager.services;

import com.minhtuan.commercemanager.model.DTO.ProductDTO;
import com.minhtuan.commercemanager.model.ImageDetail;
import com.minhtuan.commercemanager.model.Product;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> getAllProducts();
    public List<ProductDTO> getProductPromotion();
    public Product getProductById(long id);
    public ProductDTO getProductByName(String name);
    public List<ImageDetail> getImageId(Integer imageId);
}
