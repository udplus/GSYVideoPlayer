package com.example.gsyvideoplayer;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gsyvideoplayer.databinding.ActivityListVideoBinding;
import com.example.gsyvideoplayer.databinding.ActivityMainBinding;
import com.example.gsyvideoplayer.simple.SimpleActivity;
import com.example.gsyvideoplayer.utils.JumpUtils;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.player.IjkPlayerManager;
import com.shuyu.gsyvideoplayer.player.PlayerFactory;
import com.shuyu.gsyvideoplayer.player.SystemPlayerManager;
import com.shuyu.gsyvideoplayer.utils.Debuger;

import permissions.dispatcher.PermissionUtils;
import tv.danmaku.ijk.media.exo2.Exo2PlayerManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ActivityMainBinding binding;

    final String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View rootView = binding.getRoot();
        setContentView(rootView);

        Debuger.enable();

        binding.openBtn.setOnClickListener(this);
        binding.listBtn.setOnClickListener(this);
        binding.listBtn2.setOnClickListener(this);
        binding.listDetail.setOnClickListener(this);
        binding.clearCache.setOnClickListener(this);
        binding.recycler.setOnClickListener(this);
        binding.recycler2.setOnClickListener(this);
        binding.recycler2.setOnClickListener(this);
        binding.listDetailList.setOnClickListener(this);
        binding.webDetail.setOnClickListener(this);
        binding.danmakuVideo.setOnClickListener(this);
        binding.fragmentVideo.setOnClickListener(this);
        binding.moreType.setOnClickListener(this);
        binding.inputType.setOnClickListener(this);
        binding.openBtnEmpty.setOnClickListener(this);
        binding.openControl.setOnClickListener(this);
        binding.openFilter.setOnClickListener(this);
        binding.openBtnPick.setOnClickListener(this);
        binding.openBtnAuto.setOnClickListener(this);
        binding.openScroll.setOnClickListener(this);
        binding.openWindow.setOnClickListener(this);
        binding.openBtnAd.setOnClickListener(this);
        binding.openBtnMulti.setOnClickListener(this);
        binding.openBtnAd2.setOnClickListener(this);
        binding.openListAd.setOnClickListener(this);
        binding.openCustomExo.setOnClickListener(this);
        binding.openSimple.setOnClickListener(this);
        binding.openSwitch.setOnClickListener(this);
        binding.mediaCodec.setOnClickListener(this);
        binding.detailNormalActivity.setOnClickListener(this);
        binding.detailDownloadActivity.setOnClickListener(this);
        binding.detailAudioActivity.setOnClickListener(this);
        binding.detailSubtitleActivity.setOnClickListener(this);
        binding.changeCore.setOnClickListener(this);
        binding.viewPager2Activity.setOnClickListener(this);


        boolean hadPermission = PermissionUtils.hasSelfPermissions(this, permissions);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !hadPermission) {
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            requestPermissions(permissions, 1110);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean sdPermissionResult = PermissionUtils.verifyPermissions(grantResults);
        if (!sdPermissionResult) {
            Toast.makeText(this, "SD 카드 사용 권한을 얻지 못하면 지역 비디오를 재생할 수 없습니다.", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onClick(View view) {
        Log.e("################# ","################# ");
        switch (view.getId()) {
            case R.id.open_simple:
                //간단한 놀이
                startActivity(new Intent(this, SimpleActivity.class));
                break;
            case R.id.open_btn:
                //직접 연주
                JumpUtils.goToVideoPlayer(this, binding.openBtn);
                break;
            case R.id.list_btn:
                //일반 목록 재생, 전체 화면 만 지원하지만 화면 중력 회전을 지원하지 않고 슬라이딩 후에도 보류하지 마십시오.
                JumpUtils.goToVideoPlayer(this);
                break;
            case R.id.list_btn_2:
                //전체 화면 중력 회전 지원, 슬라이딩 후에는 파괴되지 않습니다.
                JumpUtils.goToVideoPlayer2(this);
                break;
            case R.id.recycler:
                //recycler的demo
                JumpUtils.goToVideoRecyclerPlayer(this);
                break;
            case R.id.recycler_2:
                //recycler的demo
                JumpUtils.goToVideoRecyclerPlayer2(this);
                break;
            case R.id.list_detail:
                //전체 화면을 회전하기위한 세부 사항 모드
                JumpUtils.goToDetailPlayer(this);
                break;
            case R.id.list_detail_list:
                //연속 목록을 재생하십시오
                JumpUtils.goToDetailListPlayer(this);
                break;
            case R.id.web_detail:
                //정상적인 플레이, 미리보기
                JumpUtils.gotoWebDetail(this);
                break;
            case R.id.danmaku_video:
                //슬라이더 비디오를 재생하십시오
                JumpUtils.gotoDanmaku(this);
                break;
            case R.id.fragment_video:
                //슬라이더 비디오를 재생하십시오
                JumpUtils.gotoFragment(this);
                break;
            case R.id.more_type:
                //해상도, 회전 등과 같은 여러 유형의 세부 사항으로 건너 뜁니다.
                JumpUtils.gotoMoreType(this);
                break;
            case R.id.input_type:
                JumpUtils.gotoInput(this);
                break;
            case R.id.open_btn_empty:
                JumpUtils.goToPlayEmptyControlActivity(this, binding.openBtnEmpty);
                break;
            case R.id.open_control:
                JumpUtils.gotoControl(this);
                break;
            case R.id.open_filter:
                JumpUtils.gotoFilter(this);
                break;
            case R.id.open_btn_pick:
                //원활한 스위치
                JumpUtils.goToVideoPickPlayer(this, binding.openBtn);
                break;
            case R.id.open_btn_auto:
                //자동 재생 목록
                JumpUtils.goToAutoVideoPlayer(this);
                break;
            case R.id.open_scroll:
                //자동 재생 목록
                JumpUtils.goToScrollDetailPlayer(this);
                break;
            case R.id.open_window:
                //멀티 양식의 서스펜션 창
                JumpUtils.goToScrollWindow(this);
                break;
            case R.id.open_btn_ad:
                //공시 하다
                JumpUtils.goToVideoADPlayer(this);
                break;
            case R.id.open_btn_multi:
                //다중 동시 재생
                JumpUtils.goToMultiVideoPlayer(this);
                break;
            case R.id.open_btn_ad2:
                //다중 동시 재생
                JumpUtils.goToVideoADPlayer2(this);
                break;
            case R.id.open_list_ad:
                //다중 동시 재생
                JumpUtils.goToADListVideoPlayer(this);
                break;
            case R.id.open_custom_exo:
                //다중 동시 재생
                JumpUtils.goToDetailExoListPlayer(this);
                break;
            case R.id.open_switch:
                JumpUtils.goToSwitch(this);
                break;
            case R.id.media_codec:
                JumpUtils.goMediaCodec(this);
                break;
            case R.id.detail_normal_activity:
                JumpUtils.goToDetailNormalActivity(this);
                break;
            case R.id.detail_download_activity:
                JumpUtils.goToDetailDownloadActivity(this);
                break;
            case R.id.detail_subtitle_activity:
                JumpUtils.goToGSYExoSubTitleDetailPlayer(this);
                break;
            case R.id.detail_audio_activity:
                JumpUtils.goToDetailAudioActivity(this);
                break;
            case R.id.view_pager2_activity:
                JumpUtils.goToViewPager2Activity(this);
                break;
            case R.id.change_core:
                i += 1;
                if (i % 3 == 0) {
                    PlayerFactory.setPlayManager(IjkPlayerManager.class);
                    binding.changeCore.setText("IJK 핵심");
                } else if (i % 3 == 1) {
                    PlayerFactory.setPlayManager(Exo2PlayerManager.class);
                    binding.changeCore.setText("EXO 핵심");
                } else if (i % 3 == 2) {
                    PlayerFactory.setPlayManager(SystemPlayerManager.class);
                    binding.changeCore.setText("系统 핵심");
                }
                break;
            case R.id.clear_cache:
                //캐시를 정리하십시오
                GSYVideoManager.instance().clearAllDefaultCache(MainActivity.this);
                //String url = "https://res.exexm.com/cw_145225549855002";
                //GSYVideoManager.clearDefaultCache(MainActivity.this, url);
                break;
        }
    }
}
