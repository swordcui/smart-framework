package org.smart4j.framework.helper;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Request;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;


/**
 * 控制器助手类
 */
public final class ControllerHelper {
    /**
     * 用于存放请求与处理器的映射关系（简称Action Map)
     */
    private static final Map<Request,Handler> ACTION_MAP =new HashMap<Request, Handler>();

    static {
        //获取所有的Controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            //遍历这些Controller类
            for (Class<?> controllerClass : controllerClassSet) {
                Method[] methods = controllerClass.getDeclaredMethods();
                //获取Controller类中的方法
                if (ArrayUtil.isNotEmpty(methods)) {
                    //判断当前方法是否带有Action注解
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(Action.class)) {
                            //从Action中获取URL映射规则
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            //获取URL映射规则
                            if (mapping.matches("\\w+:/\\w*")) {
                                String [] array = mapping.split(":");
                                if (ArrayUtil.isNotEmpty(array) && array.length ==2) {
                                    //获取请求方法与请求路径
                                    String requestMethod = array [0];
                                    String requestPath = array [1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass,method);
                                    //初始化Action Map
                                    ACTION_MAP.put(request,handler);
                                }
                            }
                        }
                    }
                }
            }


        }
    }

    /**
     * 获取Handler
     */
     public static Handler getHandler(String requestMethod, String requestPath) {
         Request request = new Request(requestMethod,requestPath);
         return ACTION_MAP.get(request);
     }
}
