package V0;

import android.view.DisplayCutout;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f5249a = new m();

    public final int a(DisplayCutout displayCutout) {
        r.f(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetBottom();
    }

    public final int b(DisplayCutout displayCutout) {
        r.f(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetLeft();
    }

    public final int c(DisplayCutout displayCutout) {
        r.f(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetRight();
    }

    public final int d(DisplayCutout displayCutout) {
        r.f(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetTop();
    }
}
