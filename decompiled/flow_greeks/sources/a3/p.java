package a3;

import android.graphics.Point;
import android.view.Display;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f61a = new p();

    public final Point a(Display display) {
        kotlin.jvm.internal.t.f(display, "display");
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }
}
