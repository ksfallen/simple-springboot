package com.simple.common.base;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yhml.core.base.bean.BaseParamBean;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author Jfeng
 * @date 2017/10/11
 */
@Service
public abstract class BaseService<T extends BaseParamBean> {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected Mapper<T> mapper;

    public int insert(T entity) {
        return mapper.insertSelective(entity);
    }

    public int update(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public T findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public int deleteById(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public T findOne(T record) {
        return record == null ? null : mapper.selectOne(record);
    }

    /**
     * 查询全表 不推荐使用
     *
     * @return
     */
    public List<T> findAll() {
        return mapper.selectAll();
    }

    public int count(T record) {
        return mapper.selectCount(record);
    }

    /**
     * 带条件查询
     *
     * @param record
     * @return
     */
    public List<T> findListBy(T record) {
        return mapper.select(record);
    }

    /**
     * 带条件分页查询,  默认 10 条
     *
     * @param record
     * @return
     */
    public List<T> findListPageBy(T record) {
        startPage(record);
        return mapper.select(record);
    }

    /**
     * 无条件分页查询, 默认 10 条
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<T> findListPageBy(int pageNum, int pageSize) {
        startPage(pageNum, pageSize);
        return mapper.selectAll();
    }

    /**
     * 使用 example 进行查询
     *
     * @param example
     * @return
     */
    public List<T> findListPageByExample(Object example, int pageNum, int pageSize) {
        startPage(pageNum, pageSize);
        return mapper.selectByExample(example);
    }

    /**
     * 使用 example 进行查询
     *
     * @param example
     * @return
     */
    public List<T> findListByExample(Object example) {
        return mapper.selectByExample(example);
    }

    private void startPage(T reocrd) {
        if (reocrd == null) {
            return;
        }
        startPage(reocrd.getPageNum(), reocrd.getPageSize(), reocrd.getOrderBy());
    }

    private void startPage(int pageNum, int pageSize) {
        startPage(pageNum, pageSize, null);
    }

    private void startPage(int pageNum, int pageSize, String orderBy) {
        if (pageNum != 0 && pageSize != 0) {
            PageHelper.startPage(pageNum, pageSize);
        }

        PageHelper.orderBy(StringUtils.isNotBlank(orderBy) ? orderBy : null);
    }

}
