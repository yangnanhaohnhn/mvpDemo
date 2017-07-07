package cn.jesse.mvp.biz;

import cn.jesse.mvp.bean.UserBean;
import cn.jesse.mvp.listener.OnLoginListener;

/**
 * Created by jesse on 15-6-24.
 */
public class UsrBizImpl implements UserBiz{
    private OnLoginListener listener;

    public UsrBizImpl(OnLoginListener listener){
        this.listener = listener;
    }

    @Override
    public void login(UserBean login) {
        boolean status = false;
        String username,password;
        username = login.getUsername();
        password = login.getPassword();
        if (username != null && "asdf".equals(username))
            if (password != null && "123".equals(password))
                status = true;
        listener.loginStatus(status);
    }
}
