package io.flutter.plugin.platform;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class y implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f7217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x f7218b;

    public y(View view, x xVar) {
        this.f7217a = view;
        this.f7218b = xVar;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        x xVar = this.f7218b;
        if (xVar == null) {
            return;
        }
        xVar.run();
        this.f7218b = null;
        this.f7217a.post(new x(this, 1));
    }
}
