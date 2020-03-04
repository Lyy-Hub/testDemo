import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liYueYang on 2020/1/9.
 */
public class TestLogger {
    private static final Logger log = LoggerFactory.getLogger(TestLogger.class);
    private static final Logger log2 = LoggerFactory.getLogger("special");

    public static void main(String[] args) {
        log2.info("测试main方法打印日志到指定文件");
    }
}
