package Q;

import android.graphics.Rect;
import android.view.Gravity;

/* JADX INFO: renamed from: Q.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0677s {
    public static void a(int i7, int i8, int i9, Rect rect, Rect rect2, int i10) {
        Gravity.apply(i7, i8, i9, rect, rect2, i10);
    }

    public static int b(int i7, int i8) {
        return Gravity.getAbsoluteGravity(i7, i8);
    }
}
