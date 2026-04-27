package io.flutter.plugin.platform;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public final class d extends P3.h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public C0704a f7143k;

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        C0704a c0704a = this.f7143k;
        if (c0704a != null) {
            io.flutter.view.k kVar = c0704a.f7136a;
            if (kVar == null ? false : kVar.e(motionEvent, true)) {
                return true;
            }
        }
        return super.onHoverEvent(motionEvent);
    }
}
