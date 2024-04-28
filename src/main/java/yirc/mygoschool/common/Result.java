package yirc.mygoschool.common;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import yirc.mygoschool.Utils.MyUtil;
import yirc.mygoschool.exception.CustomException;

import java.io.Serializable;

@Data
@Slf4j
public class Result implements Serializable {
    private Integer code;
    private String message;
    public Object data;

    private static ApplicationContext context;

    public static void setApplicationContext(ApplicationContext ctx) {
        context = ctx;
    }

    public static Result success(Object data) {
        MyUtil myUtil = context.getBean(MyUtil.class);
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setData(data);
        result.setMessage("成功");
        // 数据加密
        try {
//            var text = myUtil.encrypt(data);
        } catch (Exception e) {
            log.error("数据加密报错 请联系开发者"+ e.getMessage());
            return Result.error("数据放回报错 请联系开发者");
        }
        return result;
    }

    public static Result success(Object data, Integer code) {
        Result result = new Result();
        result.setCode(code);
        result.setData(data);
        result.setMessage("成功");
        return result;
    }

    public static Result error(String message){
        Result result = new Result();
        result.setCode(ResultCode.ERROR);
        result.setData(message);
        result.message = message;
        return result;
    }

    public static Result error(String message, Integer code){
        Result result = new Result();
        result.setCode(code);
        result.setData(null);
        result.message = message;
        return result;
    }

}
