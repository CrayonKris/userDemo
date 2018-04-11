package cn.com.bonc.util;

/**
 * 判断参数是否为空
 */
public class IsEmpty {
    public boolean isEmpty(String prop){
                if(prop==null||"".equals(prop)){
                    return true;
        }
        return false;
    }
}
