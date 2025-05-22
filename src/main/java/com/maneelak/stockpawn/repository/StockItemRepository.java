package com.maneelak.stockpawn.repository;

import com.maneelak.stockpawn.entity.StockItem;
import com.maneelak.stockpawn.entity.StockType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockItemRepository extends JpaRepository<StockItem, Long> {

    //ค้นหาด้วยชื่อ
    List<StockItem> findByItemNameContainingIgnoreCase(String keyword);

    //ค้นหาตามประเภท
    List<StockItem> findByType(StockType type);

    //ค้นหาตามน้ำหนักขั้นต่ำ/สูงสุด
    List<StockItem> findByWeightValueBetween(Double min, Double max);

    //หาสินค้าที่เหลือน้อยกว่าX
    List<StockItem> findByQuantityLessThan(Integer quantityThreshold);
}
