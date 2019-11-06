package com.yunhang.marketing_system.service;

import com.yunhang.marketing_system.entity.CustomerInfo;
import com.yunhang.marketing_system.utils.date.DateShiftUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.marketing_system.mapper.CustomerInfoMapper;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author 杨春路
 * @data 2019/10/29 17:29
 */
@Service
public class CustomerInfoService {

    @Resource
    private CustomerInfoMapper customerInfoMapper;

    /**
     * 添加客户信息，所有人都可以添加
     */
    public int addCustomer(CustomerInfo customer) throws ParseException {
        customer.setCustomerCreatetime(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        customer.setCustomerFailuretime(DateShiftUtil.dateshit("yyyy-MM-dd HH:mm:ss",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()),+7));
        return customerInfoMapper.insertSelective(customer);
    }

    /**
     * 更新客户信息，所有人都可更新
     *
     * @param customer
     * @return
     */
    public int updateCustomer(CustomerInfo customer) {
        return customerInfoMapper.updateByPrimaryKeySelective(customer);
    }

    /**
     * 删除客户信息，仅管理员可以操作
     *
     * @param customerId
     * @return
     */
    public int deleteCustomer(int customerId) {
        return customerInfoMapper.deleteByPrimaryKey(customerId);
    }

    /**
     * 查询所有客户信息，所有角色都有权限
     *
     * @return
     */
    public List<CustomerInfo> queryAllCustomer() {

        return customerInfoMapper.selectAll();
    }

    /**
     * 查询单个客户信息ById，所有角色都有权限
     */
    public CustomerInfo queryCustomerById(int customerId) {
        return customerInfoMapper.selectByPrimaryKey(customerId);
    }

    public List<CustomerInfo>  queryCustomerByUserId(int userId) {

        List<CustomerInfo> list=customerInfoMapper.selectCustomerByUserId(userId);
        return list;

    }
}

