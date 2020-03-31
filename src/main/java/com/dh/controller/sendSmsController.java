package com.dh.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient;

@Controller
public class sendSmsController {

	/**
     * 发送短信验证码
     * @param number接收手机号码
     */
    @RequestMapping("/sendSms")
    @ResponseBody
    public Object sendSms(HttpServletRequest request, String number) {
        try {
            JSONObject json = null;
            //生成6位验证码
            String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
            //发送短信
			ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com",
					"101688",
					"8285c0a8-1ab5-42b1-ad38-a452bac406df");
			String result = client.send(number, "您的验证码为:" + verifyCode + "，该码有效期为5分钟，该码只能使用一次!");
            json = JSONObject.parseObject(result);
			System.out.println("------------------" + json.get("data"));
			// json.put("code", 0);
            if(json.getIntValue("code") != 0)//发送短信失败
                return "fail";

            //将验证码存到session中,同时存入创建时间
            //以json存放，这里使用的是阿里的fastjson
            HttpSession session = request.getSession();
            json = new JSONObject();
            json.put("verifyCode", verifyCode);
            json.put("createTime", System.currentTimeMillis());
            // 将认证码存入SESSION
            request.getSession().setAttribute("verifyCode", json);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	/**
	 * 注册
	 */
	@RequestMapping("/register")
	@ResponseBody
	public Object register(HttpServletRequest request, String userId, String password, String number,
			String verifyCode) {
		JSONObject json = (JSONObject) request.getSession().getAttribute("verifyCode");
		if (!json.getString("verifyCode").equals(verifyCode)) {
			return "验证码错误";
		}
		if ((System.currentTimeMillis() - json.getLong("createTime")) > 1000 * 60 * 5) {
			return "验证码过期";
		}
		// 将用户信息存入数据库
		// 这里省略
		return "success";
	}

}
