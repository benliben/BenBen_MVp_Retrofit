package com.android.benben.my_benben;

import android.os.Bundle;
import android.widget.Toast;

import com.android.benben.retrofitlibrary.ActionRequest;
import com.android.benben.retrofitlibrary.model.BaseModel;
import com.android.benben.retrofitlibrary.model.MoveModel;
import com.android.benben.retrofitlibrary.MyRetrofitUtil;
import com.android.benben.retrofitlibrary.net.NetWork;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.buttonPanel)
    public void onViewClicked() {
        showDialog("提示", "加载中，请稍后....");
        beginService().watchMove(NetWork.KEY, "杀生")
                .compose(MyRetrofitUtil.<BaseModel<MoveModel>>applySchedulers())
                .subscribe(MyRetrofitUtil.newSubscriber(this,MainActivity.this, new ActionRequest<BaseModel<MoveModel>>() {
                    @Override
                    public void onError(String errorMsg, int statusCode) {
                        hindDialog();
                        Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void finished() {
                        hindDialog();
                        Toast.makeText(MainActivity.this, "结束", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void call(BaseModel<MoveModel> moveModelBaseModel) {
                        hindDialog();
                        Toast.makeText(MainActivity.this, "成功"+moveModelBaseModel.getResult().getAct(), Toast.LENGTH_LONG).show();
                    }
                }));
    }
}
