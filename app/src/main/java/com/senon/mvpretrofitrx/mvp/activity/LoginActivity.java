package com.senon.mvpretrofitrx.mvp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.base.BaseActivity;
import com.senon.mvpretrofitrx.mvp.contract.LoginC;
import com.senon.mvpretrofitrx.mvp.entity.A_login;
import com.senon.mvpretrofitrx.mvp.entity.A_regsin;
import com.senon.mvpretrofitrx.mvp.entity.Login;
import com.senon.mvpretrofitrx.mvp.presenter.LoginPresenter;
import com.senon.mvpretrofitrx.mvp.utils.AppDate;
import com.senon.mvpretrofitrx.mvp.utils.SpUtil;
import com.senon.mvpretrofitrx.mvp.utils.ToastUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

public class LoginActivity extends BaseActivity<LoginC.View,
        LoginC.Presenter> implements LoginC.View {


    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_psd)
    EditText etPsd;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.tv_forgetPsd)
    TextView tvForgetPsd;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginC.Presenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public LoginC.View createView() {
        return this;
    }


    @Override
    public void init() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    HashMap<String, String> map = new HashMap<>();



    String tag = "登录";

    @Override
    public void loginresult(String date) {
        A_login login = new Gson().fromJson(date, A_login.class);
        ToastUtil.showShortToast(login.getErrorMsg());
        if (login.getErrorCode()==0){
            SpUtil.putString(this, AppDate.userName, login.getData().getUsername());
            startActivity(new Intent(this,mainActivity.class));
            Log.i(tag, "name  " + login.getData().getUsername());
        }else {
            Toast.makeText(this,login.getErrorMsg(),Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void regsingresult(String date) {
        A_regsin  regsin  =new A_regsin();
        Log.i(tag,"msg  "+regsin.getErrorMsg());
        if (regsin.getErrorCode()==0){
            SpUtil.putString(this, AppDate.userName, regsin.getData().getUsername());
            startActivity(new Intent(this,mainActivity.class));
        }else {
            Toast.makeText(this,regsin.getErrorMsg(),Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void setMsg(String msg) {

    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }


    @OnClick({R.id.bt_login, R.id.tv_forgetPsd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                String name = etAccount.getText().toString();
                String pas = etPsd.getText().toString();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pas)) {
                    getPresenter().login( name,  pas, true, true);
                }else {
                    ToastUtil.showShortToast("账号或密码不能为红");
                }
                break;
            case R.id.tv_forgetPsd:
                String name2 = etAccount.getText().toString();
                String pas2 = etPsd.getText().toString();
                if (!TextUtils.isEmpty(name2) && !TextUtils.isEmpty(pas2)) {
                    map.clear();
                    map.put("username", name2);
                    map.put("password", pas2);
                    map.put("repassword", pas2);
                    getPresenter().regsin( map, true, true);
                }else {
                    ToastUtil.showShortToast("账号或密码不能为红");
                }
                break;
        }
    }
}
