package yirc.mygoschool.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import yirc.mygoschool.Dto.CarshareorderDto;
import yirc.mygoschool.Dto.PageInfoCar;
import yirc.mygoschool.domain.Carshareorder;
import com.baomidou.mybatisplus.extension.service.IService;
import yirc.mygoschool.domain.PageInfo;
import yirc.mygoschool.domain.Userinfo;

import java.util.List;

/**
* @author 一见如初
* @description 针对表【carshareorder(拼车订单表)】的数据库操作Service
* @createDate 2024-03-01 15:19:17
*/
public interface CarshareorderService extends IService<Carshareorder> {

    boolean isSavePhoneOrWeChat(Carshareorder carshareorder);

    boolean SaveWeChatImg(Carshareorder carshareorder);


    Page<CarshareorderDto> listByPage(PageInfoCar pageInfo, boolean isAdmin);


    Carshareorder selectForUpdate(Long orderid);

    List<CarshareorderDto> getReceiveByUserId(Userinfo user);

    List<CarshareorderDto> getUpOrderByUserId(Userinfo user);

    boolean MyUpdateById(Carshareorder order);

    boolean MyDeleteOrderById(Carshareorder order);
}
