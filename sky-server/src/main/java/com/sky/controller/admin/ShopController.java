package com.sky.controller.admin;


import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api(tags = "店铺相关接口")
@Slf4j
public class ShopController {

    public static final String KEY = "SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * Setting Store Business Status
     * @param status
     * @return
     */
    @PutMapping("/{status}")
    @ApiOperation("Setting Store Business Status")
    public Result setStatus(@PathVariable Integer status){
        log.info("Setting Store Business Status:{}", status == 1 ?"营业中": "打烊中");
        redisTemplate.opsForValue().set(KEY, status);
        return Result.success(status);
    }

    /**
     * Getting store business status
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("Getting store business status")
    public Result<Integer> getStatus(){
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        log.info("Getting Store Business Status:{}", status == 1 ? "营业中": "打烊中");
        return Result.success(status);
    }
}
