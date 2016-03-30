/*
 * Copyright 2012 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.examples.youtubeapidemo;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import android.os.Bundle;
import android.util.Log;

/**
 * A simple YouTube Android API demo application which shows how to create a simple application that
 * displays a YouTube Video in a {@link YouTubePlayerView}.
 * <p/>
 * Note, to use a {@link YouTubePlayerView}, your activity must extend {@link YouTubeBaseActivity}.
 */
public class PlayerViewDemoActivity extends YouTubeFailureRecoveryActivity implements YouTubePlayer.PlaybackEventListener, YouTubePlayer.PlayerStateChangeListener {

    private static final String TAG = PlayerViewDemoActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playerview_demo);

        YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(DeveloperKey.DEVELOPER_KEY, this);
    }

    private YouTubePlayer mYouTubePlayer;

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                        boolean wasRestored) {
        if (!wasRestored) {
            player.cueVideo("mH9kYn4L8TI");
            player.setPlaybackEventListener(this);
            player.setPlayerStateChangeListener(this);
            mYouTubePlayer = player;
        }

        Log.d(TAG, "current Timestamp---" + player.getCurrentTimeMillis());
    }

    @Override
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }

    @Override
    public void onPlaying() {
        Log.d(TAG, "onPlaying---" + (mYouTubePlayer != null ? mYouTubePlayer.getCurrentTimeMillis() : "null"));
    }

    @Override
    public void onPaused() {
        Log.d(TAG, "onPaused---" + (mYouTubePlayer != null ? mYouTubePlayer.getCurrentTimeMillis() : "null"));
    }

    @Override
    public void onStopped() {
        Log.d(TAG, "onStopped---" + (mYouTubePlayer != null ? mYouTubePlayer.getCurrentTimeMillis() : "null"));
    }

    @Override
    public void onBuffering(boolean b) {
        Log.d(TAG, "onBuffering---" + (mYouTubePlayer != null ? mYouTubePlayer.getCurrentTimeMillis() : "null"));
    }

    @Override
    public void onSeekTo(int i) {
        Log.d(TAG, "onSeekTo---" + (mYouTubePlayer != null ? mYouTubePlayer.getCurrentTimeMillis() : "null"));
    }

    @Override
    public void onLoading() {
        Log.d(TAG, "onLoading---" + (mYouTubePlayer != null ? mYouTubePlayer.getCurrentTimeMillis() : "null"));
    }

    @Override
    public void onLoaded(String s) {
        Log.d(TAG, "onLoaded---" + (mYouTubePlayer != null ? mYouTubePlayer.getCurrentTimeMillis() : "null"));
    }

    @Override
    public void onAdStarted() {
        Log.d(TAG, "onAdStarted---" + (mYouTubePlayer != null ? mYouTubePlayer.getCurrentTimeMillis() : "null"));
    }

    @Override
    public void onVideoStarted() {
        Log.d(TAG, "onVideoStarted---" + (mYouTubePlayer != null ? mYouTubePlayer.getCurrentTimeMillis() : "null"));
    }

    @Override
    public void onVideoEnded() {
        Log.d(TAG, "onVideoEnded---" + (mYouTubePlayer != null ? mYouTubePlayer.getCurrentTimeMillis() : "null"));
    }

    @Override
    public void onError(YouTubePlayer.ErrorReason errorReason) {
        Log.d(TAG, "onPlaying---" + errorReason.toString());
    }
}
