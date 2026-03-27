package io.flutter.plugin.platform;

import android.view.Surface;

/* JADX INFO: loaded from: classes3.dex */
public interface PlatformViewRenderTarget {
    int getHeight();

    long getId();

    Surface getSurface();

    int getWidth();

    boolean isReleased();

    void release();

    void resize(int i4, int i5);

    default void scheduleFrame() {
    }
}
