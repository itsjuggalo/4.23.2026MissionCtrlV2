package io.flutter.plugin.platform;

import android.view.Surface;
import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class m {
    public static /* synthetic */ Surface c(SurfaceControl surfaceControl) {
        return new Surface(surfaceControl);
    }

    public static /* bridge */ /* synthetic */ SurfaceControl.Transaction d(Object obj) {
        return (SurfaceControl.Transaction) obj;
    }
}
