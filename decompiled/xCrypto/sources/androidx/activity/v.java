package androidx.activity;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {
    public static final void a(View view, s onBackPressedDispatcherOwner) {
        kotlin.jvm.internal.r.f(view, "<this>");
        kotlin.jvm.internal.r.f(onBackPressedDispatcherOwner, "onBackPressedDispatcherOwner");
        view.setTag(t.f6319b, onBackPressedDispatcherOwner);
    }
}
