package io.flutter.plugin.platform;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class v implements io.flutter.view.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T2.v f7214a;

    public v(T2.v vVar) {
        this.f7214a = vVar;
    }

    @Override // io.flutter.view.o
    public final void onTrimMemory(int i) {
        if (i != 80 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        this.f7214a.f3010c = true;
    }
}
