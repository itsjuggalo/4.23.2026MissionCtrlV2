package io.flutter.embedding.android;

import android.app.Activity;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class WindowInfoRepositoryCallbackAdapterWrapper {
    final K0.a adapter;

    public WindowInfoRepositoryCallbackAdapterWrapper(K0.a aVar) {
        this.adapter = aVar;
    }

    public void addWindowLayoutInfoListener(Activity activity, Executor executor, S.a aVar) {
        this.adapter.b(activity, executor, aVar);
    }

    public void removeWindowLayoutInfoListener(S.a aVar) {
        this.adapter.c(aVar);
    }
}
