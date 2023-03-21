package com.gpmall.user.converter;

import com.gpmall.user.dto.AddAddressRequest;
import com.gpmall.user.dto.AddressDto;
import com.gpmall.user.dal.entitys.Address;
import com.gpmall.user.dto.UpdateAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @Description //TODO
 * @Date 2023/3/21 9:14
 * @Author hy
 **/
@Mapper(componentModel = "spring")
public interface AddressConverter {
    @Mappings({})
    AddressDto address2List(Address addresses);

    /*@Mappings({})
    AddressDto address2Res(Address address);*/

    List<AddressDto> address2List(List<Address> addresses);

    @Mappings({})
    Address req2Address(AddAddressRequest request);

    @Mappings({})
    Address req2Address(UpdateAddressRequest request);
}
