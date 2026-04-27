package io.flutter.embedding.android;

import android.app.Activity;
import java.util.concurrent.Executor;
import z0.C1969a;

/* JADX INFO: loaded from: classes3.dex */
public class WindowInfoRepositoryCallbackAdapterWrapper {
    final C1969a adapter;

    public WindowInfoRepositoryCallbackAdapterWrapper(C1969a c1969a) {
        this.adapter = c1969a;
    }

    public void addWindowLayoutInfoListener(Activity activity, Executor executor, G.a aVar) {
        this.adapter.b(activity, executor, aVar);
    }

    public void removeWindowLayoutInfoListener(G.a aVar) {
        this.adapter.c(aVar);
    }
}
