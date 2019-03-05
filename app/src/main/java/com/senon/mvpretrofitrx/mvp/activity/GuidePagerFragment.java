package com.senon.mvpretrofitrx.mvp.activity;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.activity.fragment.LazyLoadFragment;
import com.senon.mvpretrofitrx.mvp.activity.ui.GuidePagerActivity;
import com.senon.mvpretrofitrx.mvp.activity.videoguide.FullScreenVideoView;
import com.senon.mvpretrofitrx.mvp.utils.AppDate;
import com.senon.mvpretrofitrx.mvp.utils.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GuidePagerFragment extends LazyLoadFragment implements
        MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    @BindView(R.id.videoview_guide)
    FullScreenVideoView videoviewGuide;
    Unbinder unbinder;
    private int curPage;
    private boolean mHasPaused;

    @Override
    protected int setContentView() {
        return R.layout.fragment_guide_pager;
    }

    @Override
    protected void stopLoad() {
        super.stopLoad();
        if (videoviewGuide != null) {
            videoviewGuide.stopPlayback();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

    @Override
    protected void lazyLoad() {
        if (getArguments() == null) {
            return;
        }
        videoviewGuide = findViewById(R.id.videoview_guide);
        int videoRes = getArguments().getInt("res");
        curPage = getArguments().getInt("page");
        videoviewGuide.setOnPreparedListener(this);
        videoviewGuide.setVideoPath("android.resource://" +
                getActivity().getPackageName() + "/" + videoRes);

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        if (videoviewGuide != null) {
            videoviewGuide.requestFocus();
            videoviewGuide.seekTo(0);
            videoviewGuide.start();
            videoviewGuide.setOnCompletionListener(this);
        }
        return;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mHasPaused) {
            if (videoviewGuide != null) {
                videoviewGuide.seekTo(curPage);
                videoviewGuide.resume();
            }
        }
        return;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (videoviewGuide != null) {
            curPage = videoviewGuide.getCurrentPosition();
        }
        mHasPaused = true;
    }

    public void onDestroy() {
        super.onDestroy();
        if (videoviewGuide != null) {
            videoviewGuide.stopPlayback();
        }
        return;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        ((GuidePagerActivity)getActivity()).next(curPage);
        String userName = SpUtil.getString(getActivity(),AppDate.userName,"");
        if ("".equals(userName)) {
            startActivity(new Intent(getActivity(), LoginActivity.class));
        } else {
            startActivity(new Intent(getActivity(), mainActivity.class));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
}
