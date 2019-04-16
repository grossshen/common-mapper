package tech.poorguy.commonmapper.enume;

import org.springframework.core.env.Environment;
import tk.mybatis.mapper.util.Assert;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 13:26
 */
public enum EnvironmentEnum {

    PROD,//生产
    FE,//联调
    QA,//测试
    STG;//仿真

    public static boolean isProdEnv(Environment env) {
        Assert.notNull(env, "env parameter should not be null.");

        return EnvironmentEnum.PROD.name().equalsIgnoreCase(env.getProperty("spring.profiles.active"));
    }

    @Override
    public String toString() {
        return this.name();
    }

}
