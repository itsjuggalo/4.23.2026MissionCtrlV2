package io.flutter.plugin.platform;

import K4.r;
import android.content.Context;
import android.view.MotionEvent;

/* JADX INFO: renamed from: io.flutter.plugin.platform.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2006c extends K4.r {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C2004a f16757g;

    public C2006c(Context context, int i7, int i8, C2004a c2004a) {
        super(context, i7, i8, r.b.overlay);
        this.f16757g = c2004a;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        C2004a c2004a = this.f16757g;
        if (c2004a == null || !c2004a.a(motionEvent, true)) {
            return super.onHoverEvent(motionEvent);
        }
        return true;
    }
}
