package org.smart4j.framework;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;
import java.util.HashMap;
import javax.jws.WebService;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;
import org.smart4j.framework.helper.BeanHelper;
import org.smart4j.framework.helper.ConfigHelper;
import org.smart4j.framework.helper.ControllerHelper;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.ReflectionUtil;
import org.smart4j.framework.util.JsonUtil;
import org.smart4j.framework.util.StreamUtil;
import org.smart4j.framework.util.CodecUtil;
import org.smart4j.framework.util.StringUtil;


/**
 * 请求转发器
 */

@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        //初始化相关Helper类
        HelperLoader.init();
        //获取ServletContext对象（用于注册Servlet)
        ServletContext servletContext = getServletConfig().getServletContext();
        //注册处理JSP的Servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
        //注册处理静态资源的默认Servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*")
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求方法与路径
        String requestMethod = request.getMethod().toLowerCase();
        String requestPath = request.getPathInfo();
    }
}
