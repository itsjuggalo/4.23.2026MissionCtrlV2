package io.flutter.plugin.platform;

import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
public interface g {
    void a(int i, int i6);

    long b();

    int getHeight();

    Surface getSurface();

    int getWidth();

    void release();

    default void scheduleFrame() {
    }
}
