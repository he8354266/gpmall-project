package com.gpmall.user.services;

import com.gpmall.user.IAddressService;
import com.gpmall.user.constants.SysRetCodeConstants;
import com.gpmall.user.converter.AddressConverter;
import com.gpmall.user.dal.entitys.Address;
import com.gpmall.user.dal.persistence.AddressMapper;
import com.gpmall.user.dto.*;
import com.gpmall.user.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description //TODO
 * @Date 2023/3/28 10:17
 * @Author hy
 **/
@Slf4j
@Service
public class AddressServiceImpl implements IAddressService {
    @Resource
    private AddressMapper addressMapper;

    @Resource
    private AddressConverter converter;

    @Override
    public AddressListResponse addressList(AddressListRequest request) {
        //TODO 地址信息做缓存处理
        AddressListResponse response = new AddressListResponse();
        try {
            request.requestCheck();
            Example example = new Example(Address.class);
            example.createCriteria().andEqualTo("userId", request.getUserId());
            List<Address> addresses = addressMapper.selectByExample(example);
            response.setAddressDtos(converter.address2List(addresses));
            response.setCode(SysRetCodeConstants.SUCCESS.getCode());
            response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("AddressServiceImpl.addressList occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public AddressDetailResponse addressDetail(AddressDetailRequest request) {
        AddressDetailResponse response = new AddressDetailResponse();
        try {
            request.requestCheck();
            Address address = addressMapper.selectByPrimaryKey(request.getAddressId());
            response.setAddressDto(converter.address2List(address));
            response.setCode(SysRetCodeConstants.SUCCESS.getCode());
            response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("AddressServiceImpl.addressDetail occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public AddAddressResponse createAddress(AddAddressRequest request) {
        log.error("AddressServiceImpl.createAddress request :" + request);
        AddAddressResponse response = new AddAddressResponse();
        try {
            request.requestCheck();
        } catch (Exception e) {
            log.error("AddressServiceImpl.createAddress occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return null;
    }

    /**
     * @return void
     * @Description //地址只能有一个是默认的
     * @Param [boolean, java.lang.Long]
     * @Date 2023/3/28 10:41
     * @Author hy
     **/
    private void checkAddressDefaultUnique(boolean isDefault, Long userId) {
        if (isDefault) {
            Example example = new Example(Address.class);
            example.createCriteria().andEqualTo("userId", userId);
            List<Address> addresses = addressMapper.selectByExample(example);
        }
    }

    @Override
    public UpdateAddressResponse updateAddress(UpdateAddressRequest request) {
        return null;
    }

    @Override
    public DeleteAddressResponse deleteAddress(DeleteAddressRequest request) {
        return null;
    }
}
