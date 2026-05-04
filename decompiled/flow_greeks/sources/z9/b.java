package z9;

import android.view.View;
import u9.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static void a(View view, int i10, int i11, int i12, int i13) {
        l.d("\tdesired (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
        if (view.getVisibility() == 8) {
            i10 = 0;
            i11 = 0;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, i12), View.MeasureSpec.makeMeasureSpec(i11, i13));
        l.d("\tactual (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public static void b(View view, int i10, int i11) {
        a(view, i10, i11, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public static void c(View view, int i10, int i11) {
        a(view, i10, i11, Integer.MIN_VALUE, 1073741824);
    }

    public static void d(View view, int i10, int i11) {
        a(view, i10, i11, 1073741824, Integer.MIN_VALUE);
    }
}
