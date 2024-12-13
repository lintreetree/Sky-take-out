package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

import java.util.List;

public interface SetmealService{


    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDTO
     */
    void saveWithDish(SetmealDTO setmealDTO);

    /**
     *  套餐分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);


    /**
     * 套餐批量删除
     * @param ids
     */
    void deleteBatch(List<Long> ids);


    /**
     * search meal and linked dish data by ID
     * @param id
     * @return
     */
    SetmealVO getByIdWithDish(Long id);


    /**
     * update meal
     * @param setmealDTO
     */
    void update(SetmealDTO setmealDTO);


    /**
     * meal start or stop selling
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);
}
