package com.example.teamproject.service.product;

import com.example.teamproject.domain.dao.product.ProductDAO;
import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServieceImpl{
    private final ProductDAO productDAO;

    // 판매 상품 등록
    public void register(ProductVO productVO) {
        productDAO.register(productVO);
    }

    // 판매 상품 수정
    public int modify(ProductVO productVO) {
        return productDAO.modify(productVO);
    }

    // 판매 상품 삭제
    public int remove(Long bno) {
        return productDAO.remove(bno);
    }

    // 판매 상품 상세
    public ProductVO read(Long bno) {
        return productDAO.read(bno);
    }

    // 판매 상품 목록
    public List<ProductVO> getList(Criteria criteria) {
        return productDAO.getList(criteria);
    }

    public int getTotal(){return productDAO.getTotal();}
}

