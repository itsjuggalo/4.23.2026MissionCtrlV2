package io.flutter.plugin.platform;

import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: renamed from: io.flutter.plugin.platform.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2004a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public io.flutter.view.e f16725a;

    public boolean a(MotionEvent motionEvent, boolean z7) {
        io.flutter.view.e eVar = this.f16725a;
        if (eVar == null) {
            return false;
        }
        return eVar.L(motionEvent, z7);
    }

    public boolean b(View view, View view2, AccessibilityEvent accessibilityEvent) {
        io.flutter.view.e eVar = this.f16725a;
        if (eVar == null) {
            return false;
        }
        return eVar.v(view, view2, accessibilityEvent);
    }

    public void c(io.flutter.view.e eVar) {
        this.f16725a = eVar;
    }
}
