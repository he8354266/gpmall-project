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
        return null;
    }

    @Override
    public AddAddressResponse createAddress(AddAddressRequest request) {
        return null;
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
