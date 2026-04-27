package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: renamed from: androidx.fragment.app.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1145w {
    public AbstractComponentCallbacksC1139p b(Context context, String str, Bundle bundle) {
        return AbstractComponentCallbacksC1139p.instantiate(context, str, bundle);
    }

    public abstract View c(int i8);

    public abstract boolean d();
}
