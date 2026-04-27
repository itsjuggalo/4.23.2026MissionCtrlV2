package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: renamed from: androidx.fragment.app.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0834w {
    public AbstractComponentCallbacksC0828p b(Context context, String str, Bundle bundle) {
        return AbstractComponentCallbacksC0828p.instantiate(context, str, bundle);
    }

    public abstract View c(int i4);

    public abstract boolean d();
}
