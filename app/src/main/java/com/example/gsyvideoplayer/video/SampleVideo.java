package com.example.gsyvideoplayer.video;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gsyvideoplayer.R;
import com.example.gsyvideoplayer.model.SwitchVideoModel;
import com.example.gsyvideoplayer.view.SwitchVideoTypeDialog;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuyu on 2016/12/7.
 * 알아 채다
 * 이 플레이어의 데모 구성은 전체 화면 플레이어로 전환합니다.
 * 이것은 전체 화면 재생 디스플레이만큼 간단합니다. 
 * 크기 화면 스위치를 수행 해야하는 경우 여기에서 비디오 전체 화면에서 비디오 전체 화면의 사용자 정의 구성을 기억하십시오.
 */

public class SampleVideo extends StandardGSYVideoPlayer {

    private TextView mMoreScale;

    private TextView mSwitchSize;

    private TextView mChangeRotate;

    private TextView mChangeTransform;

    private List<SwitchVideoModel> mUrlList = new ArrayList<>();

    //데이터 소스 유형을 전환하는 것을 기억하십시오
    private int mType = 0;

    private int mTransformSize = 0;

    //데이터 원본
    private int mSourcePosition = 0;

    private String mTypeText = "기준";

    /**
     * 1.5.0시작 조인, 다른 레이아웃 구별이 필요한 경우 과부하가 필요합니다.
     */
    public SampleVideo(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }

    public SampleVideo(Context context) {
        super(context);
    }

    public SampleVideo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init(Context context) {
        super.init(context);
        initView();
    }

    private void initView() {
        mMoreScale = (TextView) findViewById(R.id.moreScale);
        mSwitchSize = (TextView) findViewById(R.id.switchSize);
        mChangeRotate = (TextView) findViewById(R.id.change_rotate);
        mChangeTransform = (TextView) findViewById(R.id.change_transform);

        //선명도 전환
        mMoreScale.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mHadPlay) {
                    return;
                }
                if (mType == 0) {
                    mType = 1;
                } else if (mType == 1) {
                    mType = 2;
                } else if (mType == 2) {
                    mType = 3;
                } else if (mType == 3) {
                    mType = 4;
                } else if (mType == 4) {
                    mType = 0;
                }
                resolveTypeUI();
            }
        });

        //비디오 정의를 전환하십시오
        mSwitchSize.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showSwitchDialog();
            }
        });

        //회전 재생 각도
        mChangeRotate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mHadPlay) {
                    return;
                }
                if ((mTextureView.getRotation() - mRotate) == 270) {
                    mTextureView.setRotation(mRotate);
                    mTextureView.requestLayout();
                } else {
                    mTextureView.setRotation(mTextureView.getRotation() + 90);
                    mTextureView.requestLayout();
                }
            }
        });

        //거울 회전
        mChangeTransform.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mHadPlay) {
                    return;
                }
                if (mTransformSize == 0) {
                    mTransformSize = 1;
                } else if (mTransformSize == 1) {
                    mTransformSize = 2;
                } else if (mTransformSize == 2) {
                    mTransformSize = 0;
                }
                resolveTransform();
            }
        });

    }

    /**
     * 치수가 변경 될 때 재 처리해야합니다
     */
    @Override
    public void onSurfaceSizeChanged(Surface surface, int width, int height) {
        super.onSurfaceSizeChanged(surface, width, height);
        resolveTransform();
    }

    @Override
    public void onSurfaceAvailable(Surface surface) {
        super.onSurfaceAvailable(surface);
        resolveRotateUI();
        resolveTransform();
    }

    /**
     * 처리 미러 회전
     * 그것이 일시 중지 될 때 주목하십시오
     */
    protected void resolveTransform() {
        switch (mTransformSize) {
            case 1: {
                Matrix transform = new Matrix();
                transform.setScale(-1, 1, mTextureView.getWidth() / 2, 0);
                mTextureView.setTransform(transform);
                mChangeTransform.setText("左右镜像");
                mTextureView.invalidate();
            }
            break;
            case 2: {
                Matrix transform = new Matrix();
                transform.setScale(1, -1, 0, mTextureView.getHeight() / 2);
                mTextureView.setTransform(transform);
                mChangeTransform.setText("上下镜像");
                mTextureView.invalidate();
            }
            break;
            case 0: {
                Matrix transform = new Matrix();
                transform.setScale(1, 1, mTextureView.getWidth() / 2, 0);
                mTextureView.setTransform(transform);
                mChangeTransform.setText("旋转镜像");
                mTextureView.invalidate();
            }
            break;
        }
    }


    /**
     * 설정 재생 URL
     *
     * @param url           URL을 재생하십시오
     * @param cacheWithPlay 그것이 잠시 여부
     * @param title         title
     * @return
     */
    public boolean setUp(List<SwitchVideoModel> url, boolean cacheWithPlay, String title) {
        mUrlList = url;
        return setUp(url.get(mSourcePosition).getUrl(), cacheWithPlay, title);
    }

    /**
     * 설정 재생 URL
     *
     * @param url           URL을 재생하십시오
     * @param cacheWithPlay 그것이 잠시 여부
     * @param cachePath     캐시 경로, M3U8 또는 HLS 인 경우 false로 설정하십시오.
     * @param title         title
     * @return
     */
    public boolean setUp(List<SwitchVideoModel> url, boolean cacheWithPlay, File cachePath, String title) {
        mUrlList = url;
        return setUp(url.get(mSourcePosition).getUrl(), cacheWithPlay, cachePath, title);
    }

    @Override
    public int getLayoutId() {
        return R.layout.sample_video;
    }


    /**
     * 해당 처리 매개 변수 논리는 전체 화면에서 전체 화면 플레이어에 할당됩니다.
     *
     * @param context
     * @param actionBar
     * @param statusBar
     * @return
     */
    @Override
    public GSYBaseVideoPlayer startWindowFullscreen(Context context, boolean actionBar, boolean statusBar) {
        SampleVideo sampleVideo = (SampleVideo) super.startWindowFullscreen(context, actionBar, statusBar);
        sampleVideo.mSourcePosition = mSourcePosition;
        sampleVideo.mType = mType;
        sampleVideo.mTransformSize = mTransformSize;
        sampleVideo.mUrlList = mUrlList;
        sampleVideo.mTypeText = mTypeText;
        //sampleVideo.resolveTransform();
        sampleVideo.resolveTypeUI();
        //sampleVideo.resolveRotateUI();
        // 이 플레이어의 데모 구성은 전체 화면 플레이어로 전환합니다.
        // 전체 화면 디스플레이만큼 간단합니다. 
        // 크기 화면 스위치를 수행 해야하는 경우 여기에서 비디오 전체 화면의 전체 화면의 사용자 정의 구성을 기억하십시오.
        // 예를 들어, 이와 같은 것으로,
        // 슈퍼 슈퍼의 구현을 참조하십시오
        return sampleVideo;
    }

    /**
     * 전체 화면이 도입되면 해당 처리 매개 변수 논리가 비 플레이어로 되돌아갑니다.
     *
     * @param oldF
     * @param vp
     * @param gsyVideoPlayer
     */
    @Override
    protected void resolveNormalVideoShow(View oldF, ViewGroup vp, GSYVideoPlayer gsyVideoPlayer) {
        super.resolveNormalVideoShow(oldF, vp, gsyVideoPlayer);
        if (gsyVideoPlayer != null) {
            SampleVideo sampleVideo = (SampleVideo) gsyVideoPlayer;
            mSourcePosition = sampleVideo.mSourcePosition;
            mType = sampleVideo.mType;
            mTransformSize = sampleVideo.mTransformSize;
            mTypeText = sampleVideo.mTypeText;
            setUp(mUrlList, mCache, mCachePath, mTitle);
            resolveTypeUI();
        }
    }

    /**
     * 旋转逻辑
     */
    private void resolveRotateUI() {
        if (!mHadPlay) {
            return;
        }
        mTextureView.setRotation(mRotate);
        mTextureView.requestLayout();
    }

    /**
     * 줌
     * 알아 채다，GSYVideoType.setShowType앱이 다시 시작되지 않으면 강제로 전역 정적 항목입니다.
     */
    private void resolveTypeUI() {
        if (!mHadPlay) {
            return;
        }
        if (mType == 1) {
            mMoreScale.setText("16:9");
            GSYVideoType.setShowType(GSYVideoType.SCREEN_TYPE_16_9);
        } else if (mType == 2) {
            mMoreScale.setText("4:3");
            GSYVideoType.setShowType(GSYVideoType.SCREEN_TYPE_4_3);
        } else if (mType == 3) {
            mMoreScale.setText("전체 화면");
            GSYVideoType.setShowType(GSYVideoType.SCREEN_TYPE_FULL);
        } else if (mType == 4) {
            mMoreScale.setText("치아 화면");
            GSYVideoType.setShowType(GSYVideoType.SCREEN_MATCH_FULL);
        } else if (mType == 0) {
            mMoreScale.setText("기본 비율");
            GSYVideoType.setShowType(GSYVideoType.SCREEN_TYPE_DEFAULT);
        }
        changeTextureViewShowType();
        if (mTextureView != null)
            mTextureView.requestLayout();
        mSwitchSize.setText(mTypeText);
    }

    /**
     * 팝업 스위칭 선명도
     */
    private void showSwitchDialog() {
        if (!mHadPlay) {
            return;
        }
        SwitchVideoTypeDialog switchVideoTypeDialog = new SwitchVideoTypeDialog(getContext());
        switchVideoTypeDialog.initList(mUrlList, new SwitchVideoTypeDialog.OnListItemClickListener() {
            @Override
            public void onItemClick(int position) {
                final String name = mUrlList.get(position).getName();
                if (mSourcePosition != position) {
                    if ((mCurrentState == GSYVideoPlayer.CURRENT_STATE_PLAYING
                            || mCurrentState == GSYVideoPlayer.CURRENT_STATE_PAUSE)) {
                        final String url = mUrlList.get(position).getUrl();
                        onVideoPause();
                        final long currentPosition = mCurrentPosition;
                        getGSYVideoManager().releaseMediaPlayer();
                        cancelProgressTimer();
                        hideAllWidget();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                setUp(url, mCache, mCachePath, mTitle);
                                setSeekOnStart(currentPosition);
                                startPlayLogic();
                                cancelProgressTimer();
                                hideAllWidget();
                            }
                        }, 500);
                        mTypeText = name;
                        mSwitchSize.setText(name);
                        mSourcePosition = position;
                    }
                } else {
                    Toast.makeText(getContext(), "已经是 " + name, Toast.LENGTH_LONG).show();
                }
            }
        });
        switchVideoTypeDialog.show();
    }


}
