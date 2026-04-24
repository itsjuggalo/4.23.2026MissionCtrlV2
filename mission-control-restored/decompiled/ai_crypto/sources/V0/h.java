package V0;

import android.graphics.Point;
import android.view.Display;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f5248a = new h();

    public final void a(Display display, Point point) {
        r.f(display, "display");
        r.f(point, "point");
        display.getRealSize(point);
    }
}
