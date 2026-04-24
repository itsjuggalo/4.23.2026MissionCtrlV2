package io.flutter.plugin.platform;

import android.view.Surface;

/* JADX INFO: renamed from: io.flutter.plugin.platform.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2018o {
    void a(int i7, int i8);

    int getHeight();

    long getId();

    Surface getSurface();

    int getWidth();

    void release();

    default void scheduleFrame() {
    }
}
