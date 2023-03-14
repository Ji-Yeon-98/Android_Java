package com.example.broadcastreceiverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

public class NetworkReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // 네트워크 상태값 받아오기
        if(WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(intent.getAction())){
            NetworkInfo info = (NetworkInfo) intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO); //네트워크 정보 받아옴
            NetworkInfo.DetailedState state = info.getDetailedState(); //상세값
            if(state == NetworkInfo.DetailedState.CONNECTED){ //네트워크 연결 상태이면
                MainActivity.tv_state.setText("네트워크 연결 완료");
            }else if(state == NetworkInfo.DetailedState.DISCONNECTED){ //네트워크 연결 해제이면
                MainActivity.tv_state.setText("네트워크 연결 해제");
            }
        }
    }
}
