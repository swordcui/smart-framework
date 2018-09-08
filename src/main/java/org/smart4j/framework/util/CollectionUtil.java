package org.smart4j.framework.util;

import java.util.Collection;
import org.apache.commons.collections4.CollectionUtils;

public final class CollectionUtil {


    /**
     *判断容器是否为非空
     */
    public static boolean isNotEmpty(Collection<?> coll){
        return !CollectionUtils.isEmpty(coll);
    }

    /**
     * 判断容易为空
     */
    public static boolean isEmpty(Collection<?>coll) {
        return CollectionUtils.isEmpty(coll);
    }
}
