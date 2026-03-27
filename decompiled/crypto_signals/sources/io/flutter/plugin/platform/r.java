package io.flutter.plugin.platform;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public final class r extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0704a f7205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f7206b;

    public r(Context context, C0704a c0704a, View view) {
        super(context);
        this.f7205a = c0704a;
        this.f7206b = view;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        io.flutter.view.k kVar = this.f7205a.f7136a;
        if (kVar == null) {
            return false;
        }
        return kVar.a(this.f7206b, view, accessibilityEvent);
    }
}
