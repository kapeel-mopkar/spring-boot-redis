package com.psl.caching.repo;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.psl.caching.models.Item;

@Repository
public class ItemRepository {

    public static final String KEY = "ITEM";
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    public ItemRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    /*Getting a specific item by item id from table*/
    public Item getItem(int itemId){
        return (Item) hashOperations.get(KEY,itemId);
    }

    /*Adding an item into redis database*/
    public void addItem(Item item){
        hashOperations.put(KEY,item.getId(),item);
    }
    /*delete an item from database*/
    public void deleteItem(int id){
        hashOperations.delete(KEY,id);
    }

    /*update an item from database*/
    public void updateItem(Item item){
        addItem(item);
    }
}