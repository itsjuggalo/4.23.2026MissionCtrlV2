package M3;

import H3.l;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static void a(View view, int i8, int i9, int i10, int i11) {
        l.d("\tdesired (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
        if (view.getVisibility() == 8) {
            i8 = 0;
            i9 = 0;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i8, i10), View.MeasureSpec.makeMeasureSpec(i9, i11));
        l.d("\tactual (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public static void b(View view, int i8, int i9) {
        a(view, i8, i9, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public static void c(View view, int i8, int i9) {
        a(view, i8, i9, Integer.MIN_VALUE, 1073741824);
    }

    public static void d(View view, int i8, int i9) {
        a(view, i8, i9, 1073741824, Integer.MIN_VALUE);
    }
}
