package com.example.googlemapexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    // 어떤 동작 or 사용자 인터페이스의 일부를 나타냄
    // 여러 개의 프래그먼트를 결합해 하나의 액티비티에 결합
    private FragmentManager fragmentManager;
    private MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();
        mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);

    }

    //구글 맵이 준비가 되면 호출되는 메소드
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        // 지도에 핀을 꼽는다.
        LatLng location = new LatLng(37.485284, 126.901451); //위도, 경도
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("구로디지털단지역"); // 명칭 이름
        markerOptions.snippet("전철역"); //세부적인 내용
        markerOptions.position(location);
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16)); // 실제 마커를 카메라로 비춰야됨 : 위치, 몇 배 줌

    }
}
