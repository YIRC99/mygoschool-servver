package yirc.mygoschool.sensitiveWord;

import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Version v1.0
 * @DateTime 2024/3/25 0:02
 * @Description TODO
 * @Author 一见如初
 */
@Component
public class SensitiveWordService {

    @Autowired
    private SensitiveWordBs sensitiveWordBs;

    /**
     * 更新词库
     *
     * 每次数据库的信息发生变化之后，首先调用更新数据库敏感词库的方法。
     * 如果需要生效，则调用这个方法。
     *
     * 说明：重新初始化不影响旧的方法使用。初始化完成后，会以新的为准。
     */
    public void refresh() {
        // 每次数据库的信息发生变化之后，首先调用更新数据库敏感词库的方法，然后调用这个方法。
        sensitiveWordBs.init();
    }
}
