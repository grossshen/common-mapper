package tech.poorguy.commonmapper.enume;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 14:01
 */
public enum ApiStyleEnum {
    NONE;
    public static boolean isValid(String name) {
        for (ApiStyleEnum callSource : ApiStyleEnum.values()) {
            if (callSource.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}