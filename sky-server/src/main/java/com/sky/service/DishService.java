package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

public interface DishService {


    public void saveWithFlavor(DishDTO dishDTO);

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);


    /**
     * 菜品批量删除
     * @param ids
     */
    void deleteBatch(List<Long> ids);


    /**
     * 根据id查询菜品和对应的口味数据
     * @param id
     * @return
     */
    DishVO getByIdWithFlavor(Long id);


    /**
     * 根据id修改菜品基本信息和口味数据
     * @param dishDTO
     */
    void updateWithFlavor(DishDTO dishDTO);


    /**
     * 菜品启用禁用
     * @param status
     * @param id
     */
    void StartOrStop(Integer status, Long id);


    /**
     * 根据categoryId查询dish
     * @param categoryId
     * @return
     */
    List<Dish> list(Long categoryId);
}
