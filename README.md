
![](./img/home_logo.png)

## 기준으로[IJKPlayer](https://github.com/Bilibili/ijkplayer)（兼容系统MediaPlayer与EXOPlayer2），实现了多功能的视频播放器。 (请仔细阅读下方各项说明，大多数问题可在下方找到解答)。

> ## [클론이 너무 느리거나 그림이 볼 수없는 경우 코드 클라우드 주소에서 다운로드하려고 시도 할 수 있습니다.](https://gitee.com/CarGuo/GSYVideoPlayer)

类型 | 功能
-------- | ---
**缓存**|**빵이 버퍼링됩니다[AndroidVideoCache](https://github.com/danikula/AndroidVideoCache)；ExoPlayer使用SimpleCache。**
**协议**|**h263\4\5、Https、concat、rtsp、hls、rtmp、crypto、mpeg等等。[（ijk模式格式支持）](https://github.com/CarGuo/GSYVideoPlayer/blob/master/doc/DECODERS.md)**
**滤镜**|**간단한 필터 (모자이크, 흑백, 색상 여과, 가우스, 흐림, 흐림 등), 애니메이션, (워터 마크, 다중 재생 등).**
** 프레임 ** | ** 비디오 첫 번째 프레임, 비디오 프레임 스크린 샷 기능, 비디오 GIF 기능을 생성합니다.**
** 플레이 ** | ** 목록 재생, 연속 재생, 중력 회전 및 수동 회전, 비디오 자체는 속성, 빠른 방송 및 느린 방송, 네트워크 비디오 로딩 속도를 회전합니다.**
** 이미지 ** | ** 조정 표시비 : 기본값, 16 : 9, 4 : 3, 충전; 재생 중에 회전 스크린 각 (0,90,180,270). 미러 회전. **
** 핵 ** | ** ijkplayer, exoplayer, mediaplayer 스위치, 맞춤 커널 **
** 레이아웃 ** | ** 전체 화면 및 비 전체 화면 두 개의 레이아웃 두 세트, 순수한 재생 지원, 자전 가능성, 상속 가능, 상속 가능한 사용자 정의. **
** PLAY ** | ** 당신의 일종재 재종, 다람 동시 재종, 비디 오빠 **
** 창 ** | ** 작은 창, 다중 양식 (바탕 화면 포함), 재생. **
** 광고 ** | ** 트레드 광고, 광고 지원을 건너 뛰고, 중간에 광고 능력을 삽입하십시오. **
** 자막 ** | ** [EXO2 모드는 자체 특정 증가 플러그인 지원] (https://github.com/carguo/gsyvideoplayer/tree/master/app/src/main/java/com/example/gsyvideoplayer를 지원합니다. / exosubtitle). **
** 대시 ** | ** exo2 모드 지원 대시 **
** 더 ** | ** 검정색 화면이없는 정면 및 후면 블록 스위칭; 다른 선명도의 지원을 조정하십시오; 완벽한 스위칭 지원; 전체 화면 잠금 / 잠금 해제 기능; 진행률 막대 작은 창 미리보기 (테스트). **
** 사용자 정의 ** | ** 렌더링 레이어, 사용자 정의 관리, 사용자 정의 재생 레이어 (제어 계층), 사용자 정의 캐시 레이어를 사용자 정의합니다. **
[![](https://jitpack.io/v/CarGuo/GSYVideoPlayer.svg)](https://jitpack.io/#CarGuo/GSYVideoPlayer)
[![Build Status](https://app.travis-ci.com/CarGuo/GSYVideoPlayer.svg?branch=master)](https://app.travis-ci.com/CarGuo/GSYVideoPlayer)
[![Github Actions](https://github.com/CarGuo/GSYVideoPlayer/workflows/CI/badge.svg)](https://github.com/CarGuo/GSYVideoPlayer/actions)

[]()
[![GitHub stars](https://img.shields.io/github/stars/CarGuo/GSYVideoPlayer.svg)](https://github.com/CarGuo/GSYVideoPlayer/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/CarGuo/GSYVideoPlayer.svg)](https://github.com/CarGuo/GSYVideoPlayer/network)
[![GitHub issues](https://img.shields.io/github/issues/CarGuo/GSYVideoPlayer.svg)](https://github.com/CarGuo/GSYVideoPlayer/issues)
[![GitHub license](https://img.shields.io/github/license/CarGuo/GSYVideoPlayer.svg)](https://github.com/CarGuo/GSYVideoPlayer/blob/master/LICENSE)


| 공공 번호 | Nugget | Zhi | CSDN |
|---------|---------|--------- |---------|---------|
| GSYTech  |  [点我](https://juejin.im/user/582aca2ba22b9d006b59ae68/posts)    |   [点我](https://www.zhihu.com/people/carguo)       |   [点我](https://blog.csdn.net/ZuoYueLiang)  |   [点我](https://www.jianshu.com/u/6e613846e1ea)


![](http://img.cdn.guoshuyu.cn/WeChat-Code)

### [--------------Demo APK 下载地址---------------](https://github.com/CarGuo/GSYVideoPlayer/releases)
## 1, Dependence 사용

#### 7.0 릴리스 시작 AnnDroidX, 지원 버전을 사용하여 다음을 참조하십시오 : [--- 릴리스 업데이트 설명 - 입구] (https://github.com/carguo/gsyvideoplayer/blob/master/doc /update_version.md).


### 1, JITPACK 소개 방법 (권장, jCenter가 곧 가깝게됩니다)


#### 첫째, Project에서 해결 된 Build.Gradle
```
allprojects {
    repositories {
		...
        maven { url 'https://jitpack.io' }
        maven { url "https://maven.aliyun.com/repository/public" }
    }
}
```

**你可以选择下面三种的其中一种，在module下的build.gradle添加。**

#### A、直接引入
```
 //完整版引入
 implementation 'com.github.CarGuo.GSYVideoPlayer:GSYVideoPlayer:v8.1.9-release-jitpack'
```

#### B、添加java和你想要的so支持：

```
 implementation 'com.github.CarGuo.GSYVideoPlayer:gsyVideoPlayer-java:v8.1.9-release-jitpack'

 //是否需要ExoPlayer模式
 implementation 'com.github.CarGuo.GSYVideoPlayer:GSYVideoPlayer-exo2:v8.1.9-release-jitpack'

 //根据你的需求ijk模式的so
 implementation 'com.github.CarGuo.GSYVideoPlayer:gsyVideoPlayer-arm64:v8.1.9-release-jitpack'
 implementation 'com.github.CarGuo.GSYVideoPlayer:gsyVideoPlayer-armv7a:v8.1.9-release-jitpack'
 implementation 'com.github.CarGuo.GSYVideoPlayer:gsyVideoPlayer-armv5:v8.1.9-release-jitpack'
 implementation 'com.github.CarGuo.GSYVideoPlayer:gsyVideoPlayer-x86:v8.1.9-release-jitpack'
 implementation 'com.github.CarGuo.GSYVideoPlayer:gsyVideoPlayer-x64:v8.1.9-release-jitpack'
```
#### C, 지원 기타 형식 프로토콜 (MPEG, RTSP, CONCAT, CRYPTO 프로토콜)

A, B 정상적인 버전 지원 263/264/265 등, MPEG 인코딩에 대한 화면이 없습니다.
c 도입 된 도입은 MPEG 인코딩 및 기타 보충 프로토콜을 지원하지만 그래서 패키지는 크다.

```
 구현 'com.github.carguo.gsyvideoplayer : gsyvideoplayer-java : v8.1.9-release-jitpack'

 / / exoplayer 모드가 필요합니까?
 구현 'com.github.carguo.gsyvideoplayer : gsyvideoplayer-exo2 : v8.1.9-release-jitpack'

 // 더 많은 ijk의 코드 지원
 구현 'com.github.carguo.gsyvideoplayer : gsyvideoplayer-ex_so : v8.1.9-release-jitpack'

```

#### の 中 的 中 の 中 (문서 및 데모를 참조하십시오)

```

// exoplayer 커널, 지원 형식의 지원
PlayerFactory.SetPlayManager (exo2playermanager.class);
// 시스템 커널 모드
PlayerFactory.SetPlayManager (SystemPlayerManager.class);
// ijk core, 기본 모드
PlayerFactory.setPlayManager (ijkplayermanager.class);
// exo 캐시 모드, 지원 M3U8, EXO 만 지원
cachefactory.setCacheManager (ExoplayerCacheManager.Class);
// 에이전트 캐시 모드, 모든 모드 지원, M3U8 등을 지원하지 마십시오.
cachefactory.setCacheManager (ProxyCacheManager.class);



// 스위치 렌더링 모드
gsyvideoType.SetShowType (gsyvideoType.screen_match_full);
/ / 기본 표시 비율
gsyvideoType.Screen_Type_Default = 0;
// 16 : 9.
gsyvideoType.Screen_Type_16_9 = 1;
// 4 : 3.
gsyvideoType.Screen_Type_4_3 = 2;
/ / 전체 화면 컷 디스플레이, 일반 coverimageView를 표시하려면 FrameLayout이 상위 레이아웃으로 사용됩니다.
gsyvideotype.screen_type_full = 4;
/ / 전체 화면 스트레치 디스플레이,이 속성을 사용할 때 Surface_Container는 FrameLayout을 사용하는 것이 좋습니다.
gsyvideotype.screen_match_full = -4;
/ ***
 * 사용자 정의 디스플레이 비율에서 screen_type_custom
 * @param screenscaleratio는 16 : 9
 * /
공중 정적 void setscreenscaleratio (float screenscaleratio)
//스위치 드로잉 모드
GSYVideoType.setRenderType(GSYVideoType.SUFRACE);
GSYVideoType.setRenderType(GSYVideoType.GLSURFACE);
GSYVideoType.setRenderType(GSYVideoType.TEXTURE);


//ijk 닫기 로그
IjkPlayerManager.setLogLevel(IjkMediaPlayer.IJK_LOG_SILENT);


//exoplayer自定义MediaSource
ExoSourceManager.setExoMediaSourceInterceptListener(new ExoMediaSourceInterceptListener() {
    @Override
    public MediaSource getMediaSource(String dataSource, boolean preview, boolean cacheEnable, boolean isLooping, File cacheDir) {
        //맞춤형 MediaSource.
        return null;
    }
});

```

### [--- 更多依赖方式请点击 - ](https://github.com/CarGuo/GSYVideoPlayer/blob/master/doc/DEPENDENCIES.md)

## 二、其他推荐

### * 我所在的技术社区：[掘金](https://juejin.cn/user/817692379985752/posts)
### * QQ群，有兴趣的欢迎（平时吹水吐槽多，因为人数饱和，就是日常瞎扯）：174815284 。
### * [Flutter Github客户端](https://github.com/CarGuo/gsy_github_app_flutter) 、[React Native Github客户端](https://github.com/CarGuo/GSYGithubAPP) 、 [Weex Github客户端](https://github.com/CarGuo/GSYGithubAPPWeex) 、 [原生 Kotlin Github客户端](https://github.com/CarGuo/GSYGithubAPPKotlin)
### * [RxFFmpeg Android 的音视频编辑工具](https://github.com/microshow/RxFFmpeg)
### * [oarplayer Rtmp播放器,基于MediaCodec与srs-librtmp,不依赖ffmpeg](https://github.com/qingkouwei/oarplayer)



## 三、文档Wiki

文档 | 传送门
-------- | ---
**使用说明**|***[--- 简单使用，快速上手文档](https://github.com/CarGuo/GSYVideoPlayer/blob/master/doc/USE.md)***
**建议阅读**|***[--- 移动开发者必知的音视频基础知识](https://mp.weixin.qq.com/s/HjSdmAsHuvixCH_EWdvk3Q)***
**项目解析说明**|***[--- 项目解析说明、包含项目架构和解析](https://github.com/CarGuo/GSYVideoPlayer/blob/master/doc/GSYVIDEO_PLAYER_PROJECT_INFO.md)***
接口文档入口|**[--- 使用说明、接口文档 - 入口](https://github.com/CarGuo/GSYVideoPlayer/wiki)**
**问题集锦入口**|***[--- 问题集锦 - 入口（大部分你遇到的问题都在这里解决） ](https://github.com/CarGuo/GSYVideoPlayer/blob/master/doc/QUESTION.md)***
编码格式|**[--- IJK so文件配置格式说明](https://github.com/CarGuo/GSYVideoPlayer/blob/master/doc/DECODERS.md)**
编译自定义SO|**[--- IJKPlayer编译自定义SO - 入口](https://github.com/CarGuo/GSYVideoPlayer/blob/master/doc/BUILD_SO.md)**
版本更新说明|**[--- 版本更新说明 - 入口](https://github.com/CarGuo/GSYVideoPlayer/blob/master/doc/UPDATE_VERSION.md)**
compileSdk 太高|--- **[#3514](https://github.com/CarGuo/GSYVideoPlayer/issues/3514)**




![框架图](./img/StructureChart2.jpg)

## 四、运行效果

* ### 1、打开一个播放(旋转、镜像、填充)
<img src="./img/11.gif" width="240px" height="426px"/>

* ### 2、列表/详情模式(动画、旋转、小窗体)

<div>
<img src="./img/22.gif" width="240px" height="426px"/>
<img src="./img/33.gif" width="240px" height="426px"/>
<img src="./img/44.gif" width="240px" height="426px"/>
</div>

* ### 3、弹幕
<img src="./img/55.gif" width="240px" height="426px"/>

* ### 4、滤镜和GL动画
<img src="./img/09.gif"/>

* ### 6、背景铺满模糊播放

<img src="./img/99.png" width="426px" height="240px"/>

* ### 7、进度条小窗口预览
<img src="./img/07.gif" height="240px"/>

## 五、近期版本

### v8.1.9-release-jitpack(2022-02-14)
* fix #3496
* exo support rtsp

### v8.1.8-release-jitpack(2021-11-12)

* fix #3484 orientation
* update gradle
* Update dependencies (#3450)

* update something

### v8.1.7-release-jitpack(2021-11-12)

* update something

### v8.1.6-jitpack(2021-09-13)

* 增加支持横屏幕全屏和竖屏变化，屏幕不旋转，[SimpleActivity](./app/src/main/java/com/example/gsyvideoplayer/simple/SimpleActivity.java) [SimpleDetailActivityMode2](./app/src/main/java/com/example/gsyvideoplayer/simple/SimpleDetailActivityMode2.java)
* 修复设置了超时，重试后失效的问题
* 增加针对某些dataBinding的场景， 当context detach activity被回收会出现。
* exo player 2.14.2
* fix DataSource error


### 非 androidx 版本为 6.0.3 以下版本。更多兼容版本请查阅版本更新。

### 更多版本请查阅：[版本更新说明](https://github.com/CarGuo/GSYVideoPlayer/blob/master/doc/UPDATE_VERSION.md)

## 六、关于Issues

```
提问题前可先查阅上方文档和说明，请在Demo中复现问题。

问题说明：

1、说明那个Demo中哪个页面。
2、问题显现和重现步骤。
3、补充问题的视频流url，截图。
4、补充问题的机型，android版本。
```

## 七、混淆

```
-keep class com.shuyu.gsyvideoplayer.video.** { *; }
-dontwarn com.shuyu.gsyvideoplayer.video.**
-keep class com.shuyu.gsyvideoplayer.video.base.** { *; }
-dontwarn com.shuyu.gsyvideoplayer.video.base.**
-keep class com.shuyu.gsyvideoplayer.utils.** { *; }
-dontwarn com.shuyu.gsyvideoplayer.utils.**
-keep class tv.danmaku.ijk.** { *; }
-dontwarn tv.danmaku.ijk.**

-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, java.lang.Boolean);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
```

## 温馨提示

#### [如果克隆太慢，可尝试从码云地址下载](https://gitee.com/CarGuo/GSYVideoPlayer)

```
关于自定义和出现问题的请先看问题集锦、demo、issue。

多了解一些音视频的基础常识，对容器，音视频编码，ffmpeg先做一些了解，以及mediacodec等的不同。
尽量少出现为什么别的能播的问题哟。

播放器的可自定义还是挺高的，定制请参考demo，多看源码。现在的功能有些多，demo也在不断的更新。

一些新功能和项目结构也在不断的调整。

欢迎提出问题，谢谢。

```

## 依赖大小参考
建议使用ndk过滤，详细参考 [参考第四条 ： 4、NDK的so支持](http://www.jianshu.com/p/86e4b336c17d)
![](https://ooo.0o0.ooo/2017/06/15/5941f343a39f5.png)




## 非常感谢您的支持


#### 撸码不易，如果对你有所帮助，欢迎您的赞赏

![](http://img.cdn.guoshuyu.cn/thanks.jpg)



### GSY新书：[《Flutter开发实战详解》](https://item.jd.com/12883054.html)上架啦：[京东](https://item.jd.com/12883054.html) / [当当](http://product.dangdang.com/28558519.html)

[![](http://img.cdn.guoshuyu.cn/WechatIMG65.jpeg)](https://item.jd.com/12883054.html)




## License

```
IJKPlayer 및 AndroidVideoCacche 관련 프로토콜을 참조하십시오.
이 프로젝트는 Jiecao에서 시작했으며 직접 재구성하기 위해 직접 변경되었습니다.
때로는 변수가 있고 메소드 이름은 조금 jiaozi 그림자가있을 수도 있지만 기본적으로 새로운 프로젝트입니다.
```
