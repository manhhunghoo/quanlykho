package com.example.quanlykhodemo.demo.controllers;

import com.example.quanlykhodemo.demo.models.Product;
import com.example.quanlykhodemo.demo.models.ResponseObject;
import com.example.quanlykhodemo.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/danhsachkho")
    List<Product> getAllProducts() {
        return repository.findAll();
    }

    @GetMapping("/danhsachkho/{maxe}")
    ResponseEntity<ResponseObject> findById(@PathVariable String maxe) {
        Optional<Product> foundProduct = repository.findById(maxe);
        if (foundProduct.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Tim thay thanh cong", foundProduct));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("FALSE", "Khong tim thay ma xe =" + maxe, ""));
        }
    }

    // Insert san pham vao
    // nho la RAW va JSON
    @PostMapping("/nhapvaokho")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct) {
        Optional<Product> foundProducts = repository.findById(newProduct.getMaxe());
        if (foundProducts.isPresent())
        {
            int tong = foundProducts.get().getSoluong() + newProduct.getSoluong();
            foundProducts.get().setSoluong(tong);
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("OK", "San pham da ton tai va da tang so luong len", ""));
        }
        return ResponseEntity.status((HttpStatus.OK)).body(
                new ResponseObject("OK", "Insert san pham thanh cong", repository.save(newProduct))
        );
    }

    // update neu tim thay khong thi se insert nhu cai moi
    @PutMapping("/suasolieu")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable String maxe) {
        Product updateProduct = repository.findById(maxe)
                .map(product -> {
                    product.setMaxe(newProduct.getMaxe());
                    product.setTenxe(newProduct.getMaxe());
                    product.setGiaxe(newProduct.getGiaxe());
                    product.setMakho(newProduct.getMakho());
                    product.setSoluong(newProduct.getSoluong());
                    return repository.save(product);
                }).orElseGet(() -> {
                    return repository.save(newProduct);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Update san pham thanh cong", repository.save(newProduct)));
    }
    @DeleteMapping("/xoadulieu/{maxe}")
    ResponseEntity<ResponseObject> deleteProduct (@PathVariable String maxe)
    {
        boolean exist = repository.existsById(maxe);
        if(exist){
            repository.deleteById(maxe);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK","Delete thanh cong",""));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("faild","Khong tim thay san pham de xoa","")
        );
    }
    @PostMapping("/xuatkho")
    ResponseEntity<ResponseObject> xuatkho(@RequestParam(value = "maxe",required = true) String maxe,
                                           @RequestParam(value = "soluong",required = true) int soluong)
    {
        Optional<Product> foundProduct = repository.findById(maxe);
        if (foundProduct.isPresent()) {
            int hieu = foundProduct.get().getSoluong() - soluong;
            foundProduct.get().setSoluong(hieu);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Da xuat thanh cong: "+soluong+" va con lai :"+hieu, foundProduct));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("FALSE", "Khong tim thay ma xe =" + maxe, ""));
        }
    }

}
