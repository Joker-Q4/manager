package com.sau.controller;

import com.sau.entity.Admin;
import com.sau.entity.Page;
import com.sau.entity.RequestToMethodItem;
import com.sau.global.JsonTools;
import com.sau.service.AdminService;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminLoginController {

    @Resource
    AdminService adminService;

    @RequestMapping("/login")
    public Map<String, Object> login(
            HttpServletRequest httpServletRequest,
            @RequestParam(defaultValue = "") String account,
            @RequestParam(defaultValue = "") String password){
        if(account.isEmpty() || password.isEmpty())
            return JsonTools.toResult(false, "用户名或密码不能为空");
        Admin admin = adminService.getAdmin(account);
        if(admin == null)
            return JsonTools.toResult(false, "数据库查无此人");
        if(password.equalsIgnoreCase(admin.getPassword())){
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("admin", admin);
            return JsonTools.toResult(true, "登录成功");
        }
        return JsonTools.toResult(false, "密码不正确");
    }

    @RequestMapping("/register")
    public Map<String, Object> register(
            HttpServletRequest httpServletRequest,
            @RequestParam(defaultValue = "") String account,
            @RequestParam(defaultValue = "") String password){
        if(account.isEmpty() || password.isEmpty())
            return JsonTools.toResult(false, "用户名或密码不能为空");
        if(adminService.getAdmin(account) != null)
            return JsonTools.toResult(false, "数据库已有此账号");
        Admin admin = new Admin(account, password);
        if(adminService.addAdmin(admin)){
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("admin", admin);
            return JsonTools.toResult(true, "添加成功");
        }
        return JsonTools.toResult(false, "添加失败");
    }


    @RequestMapping(value = "/getAllUrl")
    public Map<String, Object> getAllUrl(
            HttpServletRequest request,
            @RequestParam(defaultValue = Page.PAGE_INDEX) String page,
            @RequestParam(defaultValue = Page.PAGE_SIZE) String limit)
    {
        ServletContext servletContext = request.getSession().getServletContext();
        if (servletContext == null) {
            return null;
        }
        WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        //请求url和处理方法的映射
        List<RequestToMethodItem> requestToMethodItemList = new ArrayList<>();
        //获取所有的RequestMapping
        assert appContext != null;
        Map<String, HandlerMapping> allRequestMappings = BeanFactoryUtils.beansOfTypeIncludingAncestors(appContext,
                HandlerMapping.class, true, false);
        int i = 1;
        for (HandlerMapping handlerMapping : allRequestMappings.values()) {
            //本项目只需要RequestMappingHandlerMapping中的URL映射
            if (handlerMapping instanceof RequestMappingHandlerMapping) {
                RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping) handlerMapping;
                Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
                for (Map.Entry<RequestMappingInfo, HandlerMethod> requestMappingInfoHandlerMethodEntry : handlerMethods.entrySet()) {
                    RequestMappingInfo requestMappingInfo = requestMappingInfoHandlerMethodEntry.getKey();
                    HandlerMethod mappingInfoValue = requestMappingInfoHandlerMethodEntry.getValue();
                    RequestMethodsRequestCondition methodCondition = requestMappingInfo.getMethodsCondition();
                    String requestType = methodCondition.getMethods().stream().map(String::valueOf).collect(Collectors.joining(","));
                    PatternsRequestCondition patternsCondition = requestMappingInfo.getPatternsCondition();
                    String requestUrl = patternsCondition.getPatterns().stream().map(String::valueOf).collect(Collectors.joining(","));
                    String controllerName = mappingInfoValue.getBeanType().getSimpleName();
                    String requestMethodName = mappingInfoValue.getMethod().getName();
                    Class<?>[] methodParamTypes = mappingInfoValue.getMethod().getParameterTypes();
                    RequestToMethodItem item = new RequestToMethodItem(i, requestUrl, requestType, controllerName, requestMethodName,
                            methodParamTypes);
                    i++;
                    requestToMethodItemList.add(item);
                }
            }
        }
        final int size = requestToMethodItemList.size();
        final int pageTemp = Integer.parseInt(page);
        final int limitTemp = Integer.parseInt(limit);
        try {
            int left = (pageTemp-1)*limitTemp;
            int right = pageTemp*limitTemp;
            if(right > size)
                right = size;
            List<RequestToMethodItem> tempList = requestToMethodItemList.subList(left, right);
            return JsonTools.toResult(0, "成功", size, tempList);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonTools.toResult(0, "成功", size, requestToMethodItemList);
        }
    }

    @RequestMapping("/loginout")
    public void loginout(
            HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("admin");
    }
}
