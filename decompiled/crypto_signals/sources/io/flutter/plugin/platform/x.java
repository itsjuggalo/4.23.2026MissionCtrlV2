package io.flutter.plugin.platform;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7216b;

    public /* synthetic */ x(Object obj, int i) {
        this.f7215a = i;
        this.f7216b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7215a) {
            case 0:
                E0.i iVar = (E0.i) this.f7216b;
                ((View) iVar.f375b).postDelayed((k) iVar.f376c, 128L);
                break;
            default:
                y yVar = (y) this.f7216b;
                yVar.f7217a.getViewTreeObserver().removeOnDrawListener(yVar);
                break;
        }
    }
}
