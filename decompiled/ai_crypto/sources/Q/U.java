package Q;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public abstract class U {

    public static class a {
        public static boolean a(ViewParent viewParent, View view, float f7, float f8, boolean z7) {
            return viewParent.onNestedFling(view, f7, f8, z7);
        }

        public static boolean b(ViewParent viewParent, View view, float f7, float f8) {
            return viewParent.onNestedPreFling(view, f7, f8);
        }

        public static void c(ViewParent viewParent, View view, int i7, int i8, int[] iArr) {
            viewParent.onNestedPreScroll(view, i7, i8, iArr);
        }

        public static void d(ViewParent viewParent, View view, int i7, int i8, int i9, int i10) {
            viewParent.onNestedScroll(view, i7, i8, i9, i10);
        }

        public static void e(ViewParent viewParent, View view, View view2, int i7) {
            viewParent.onNestedScrollAccepted(view, view2, i7);
        }

        public static boolean f(ViewParent viewParent, View view, View view2, int i7) {
            return viewParent.onStartNestedScroll(view, view2, i7);
        }

        public static void g(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f7, float f8, boolean z7) {
        try {
            return a.a(viewParent, view, f7, f8, z7);
        } catch (AbstractMethodError e7) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e7);
            return false;
        }
    }

    public static boolean b(ViewParent viewParent, View view, float f7, float f8) {
        try {
            return a.b(viewParent, view, f7, f8);
        } catch (AbstractMethodError e7) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e7);
            return false;
        }
    }

    public static void c(ViewParent viewParent, View view, int i7, int i8, int[] iArr, int i9) {
        if (viewParent instanceof C) {
            ((C) viewParent).f(view, i7, i8, iArr, i9);
            return;
        }
        if (i9 == 0) {
            try {
                a.c(viewParent, view, i7, i8, iArr);
            } catch (AbstractMethodError e7) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e7);
            }
        }
    }

    public static void d(ViewParent viewParent, View view, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
        if (viewParent instanceof D) {
            ((D) viewParent).a(view, i7, i8, i9, i10, i11, iArr);
            return;
        }
        iArr[0] = iArr[0] + i9;
        iArr[1] = iArr[1] + i10;
        if (viewParent instanceof C) {
            ((C) viewParent).b(view, i7, i8, i9, i10, i11);
            return;
        }
        if (i11 == 0) {
            try {
                a.d(viewParent, view, i7, i8, i9, i10);
            } catch (AbstractMethodError e7) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e7);
            }
        }
    }

    public static void e(ViewParent viewParent, View view, View view2, int i7, int i8) {
        if (viewParent instanceof C) {
            ((C) viewParent).d(view, view2, i7, i8);
            return;
        }
        if (i8 == 0) {
            try {
                a.e(viewParent, view, view2, i7);
            } catch (AbstractMethodError e7) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e7);
            }
        }
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i7, int i8) {
        if (viewParent instanceof C) {
            return ((C) viewParent).c(view, view2, i7, i8);
        }
        if (i8 != 0) {
            return false;
        }
        try {
            return a.f(viewParent, view, view2, i7);
        } catch (AbstractMethodError e7) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e7);
            return false;
        }
    }

    public static void g(ViewParent viewParent, View view, int i7) {
        if (viewParent instanceof C) {
            ((C) viewParent).e(view, i7);
            return;
        }
        if (i7 == 0) {
            try {
                a.g(viewParent, view);
            } catch (AbstractMethodError e7) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e7);
            }
        }
    }
}
