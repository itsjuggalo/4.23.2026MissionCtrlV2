package io.flutter.embedding.android;

import android.app.Activity;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class WindowInfoRepositoryCallbackAdapterWrapper {
    final v2.a adapter;

    public WindowInfoRepositoryCallbackAdapterWrapper(v2.a aVar) {
        this.adapter = aVar;
    }

    public void addWindowLayoutInfoListener(Activity activity, Executor executor, s0.a aVar) {
        this.adapter.b(activity, executor, aVar);
    }

    public void removeWindowLayoutInfoListener(s0.a aVar) {
        this.adapter.c(aVar);
    }
}
