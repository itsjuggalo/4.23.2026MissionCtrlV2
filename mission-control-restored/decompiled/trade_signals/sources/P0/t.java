package P0;

import android.graphics.Point;
import android.view.Display;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f6276a = new t();

    public final Point a(Display display) {
        AbstractC2304t.f(display, "display");
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }
}
