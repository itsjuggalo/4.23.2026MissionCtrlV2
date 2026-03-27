package P0;

import android.view.DisplayCutout;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f6275a = new s();

    public final int a(DisplayCutout displayCutout) {
        AbstractC2304t.f(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetBottom();
    }

    public final int b(DisplayCutout displayCutout) {
        AbstractC2304t.f(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetLeft();
    }

    public final int c(DisplayCutout displayCutout) {
        AbstractC2304t.f(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetRight();
    }

    public final int d(DisplayCutout displayCutout) {
        AbstractC2304t.f(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetTop();
    }
}
