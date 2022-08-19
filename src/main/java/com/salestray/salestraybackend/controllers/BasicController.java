package com.salestray.salestraybackend.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * interface with basic controller functions
 *
 * @param <T>
 */
public interface BasicController<T> {

    /**
     * get all the objects as a list
     *
     * @return all objects
     */
    @ResponseBody List<T> all();

    /**
     * Create a new object in the db
     *
     * @param t object to be saved
     * @return saved object
     */
    default @ResponseBody T add(@RequestBody T t) {
        return null;
    };

    /**
     * delete any given object from the db
     */
    void delete(Long id);

    /**
     * update object in the db
     *
     * @param t updating object
     * @return updated object
     */
    @ResponseBody T update(@RequestBody T t);

    /**
     * Get Object from db using given id
     * @param id given id
     * @return object retrieved from the db
     */
    @ResponseBody T getById(@RequestParam Long id);
}
