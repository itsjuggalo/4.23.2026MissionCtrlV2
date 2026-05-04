package a3;

import android.view.DisplayCutout;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f60a = new o();

    public final int a(DisplayCutout displayCutout) {
        kotlin.jvm.internal.t.f(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetBottom();
    }

    public final int b(DisplayCutout displayCutout) {
        kotlin.jvm.internal.t.f(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetLeft();
    }

    public final int c(DisplayCutout displayCutout) {
        kotlin.jvm.internal.t.f(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetRight();
    }

    public final int d(DisplayCutout displayCutout) {
        kotlin.jvm.internal.t.f(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetTop();
    }
}
