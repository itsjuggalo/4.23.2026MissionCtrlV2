package D;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public abstract class H {
    public static boolean a(ViewParent viewParent, View view, float f6, float f7, boolean z6) {
        return viewParent.onNestedFling(view, f6, f7, z6);
    }

    public static boolean b(ViewParent viewParent, View view, float f6, float f7) {
        return viewParent.onNestedPreFling(view, f6, f7);
    }

    public static void c(ViewParent viewParent, View view, int i, int i6, int[] iArr) {
        viewParent.onNestedPreScroll(view, i, i6, iArr);
    }

    public static void d(ViewParent viewParent, View view, int i, int i6, int i7, int i8) {
        viewParent.onNestedScroll(view, i, i6, i7, i8);
    }

    public static void e(ViewParent viewParent, View view, View view2, int i) {
        viewParent.onNestedScrollAccepted(view, view2, i);
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i) {
        return viewParent.onStartNestedScroll(view, view2, i);
    }

    public static void g(ViewParent viewParent, View view) {
        viewParent.onStopNestedScroll(view);
    }
}
