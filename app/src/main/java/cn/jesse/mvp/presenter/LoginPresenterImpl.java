package cn.jesse.mvp.presenter;

import cn.jesse.mvp.bean.UserBean;
import cn.jesse.mvp.biz.UserBiz;
import cn.jesse.mvp.biz.UsrBizImpl;
import cn.jesse.mvp.listener.OnLoginListener;
import cn.jesse.mvp.view.LoginView;

/**
 * Created by jesse on 15-6-24.
 */
public class LoginPresenterImpl implements LoginPresenter, OnLoginListener{
    private UserBiz userBiz;
    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView){
        this.loginView = loginView;
        userBiz = new UsrBizImpl(this);
    }

    @Override
    public void login() {
        UserBean login = new UserBean();
        login.setUsername(loginView.getUsername());
        login.setPassword(loginView.getPassword());
        userBiz.login(login);
    }

    @Override
    public void clear() {
        loginView.clearPassword();
        loginView.clearUsername();
    }

    @Override
    public void loginStatus(boolean status) {
        String msg;
        if (status)
            msg = "login succeed";
        else
            msg = "login failed";
        loginView.showMsg(msg);
    }
}