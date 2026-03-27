package androidx.activity;

import android.view.View;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {
    public static final void a(View view, s onBackPressedDispatcherOwner) {
        AbstractC2304t.f(view, "<this>");
        AbstractC2304t.f(onBackPressedDispatcherOwner, "onBackPressedDispatcherOwner");
        view.setTag(t.f10362b, onBackPressedDispatcherOwner);
    }
}
