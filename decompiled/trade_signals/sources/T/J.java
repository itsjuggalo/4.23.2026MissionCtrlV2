package T;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public abstract class J {

    public static class a {
        public static boolean a(ViewParent viewParent, View view, float f8, float f9, boolean z7) {
            return viewParent.onNestedFling(view, f8, f9, z7);
        }

        public static boolean b(ViewParent viewParent, View view, float f8, float f9) {
            return viewParent.onNestedPreFling(view, f8, f9);
        }

        public static void c(ViewParent viewParent, View view, int i8, int i9, int[] iArr) {
            viewParent.onNestedPreScroll(view, i8, i9, iArr);
        }

        public static void d(ViewParent viewParent, View view, int i8, int i9, int i10, int i11) {
            viewParent.onNestedScroll(view, i8, i9, i10, i11);
        }

        public static void e(ViewParent viewParent, View view, View view2, int i8) {
            viewParent.onNestedScrollAccepted(view, view2, i8);
        }

        public static boolean f(ViewParent viewParent, View view, View view2, int i8) {
            return viewParent.onStartNestedScroll(view, view2, i8);
        }

        public static void g(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f8, float f9, boolean z7) {
        try {
            return a.a(viewParent, view, f8, f9, z7);
        } catch (AbstractMethodError e8) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e8);
            return false;
        }
    }

    public static boolean b(ViewParent viewParent, View view, float f8, float f9) {
        try {
            return a.b(viewParent, view, f8, f9);
        } catch (AbstractMethodError e8) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e8);
            return false;
        }
    }

    public static void c(ViewParent viewParent, View view, int i8, int i9, int[] iArr, int i10) {
        if (viewParent instanceof InterfaceC0937t) {
            ((InterfaceC0937t) viewParent).f(view, i8, i9, iArr, i10);
            return;
        }
        if (i10 == 0) {
            try {
                a.c(viewParent, view, i8, i9, iArr);
            } catch (AbstractMethodError e8) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e8);
            }
        }
    }

    public static void d(ViewParent viewParent, View view, int i8, int i9, int i10, int i11, int i12, int[] iArr) {
        if (viewParent instanceof InterfaceC0938u) {
            ((InterfaceC0938u) viewParent).a(view, i8, i9, i10, i11, i12, iArr);
            return;
        }
        iArr[0] = iArr[0] + i10;
        iArr[1] = iArr[1] + i11;
        if (viewParent instanceof InterfaceC0937t) {
            ((InterfaceC0937t) viewParent).b(view, i8, i9, i10, i11, i12);
            return;
        }
        if (i12 == 0) {
            try {
                a.d(viewParent, view, i8, i9, i10, i11);
            } catch (AbstractMethodError e8) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e8);
            }
        }
    }

    public static void e(ViewParent viewParent, View view, View view2, int i8, int i9) {
        if (viewParent instanceof InterfaceC0937t) {
            ((InterfaceC0937t) viewParent).d(view, view2, i8, i9);
            return;
        }
        if (i9 == 0) {
            try {
                a.e(viewParent, view, view2, i8);
            } catch (AbstractMethodError e8) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e8);
            }
        }
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i8, int i9) {
        if (viewParent instanceof InterfaceC0937t) {
            return ((InterfaceC0937t) viewParent).c(view, view2, i8, i9);
        }
        if (i9 != 0) {
            return false;
        }
        try {
            return a.f(viewParent, view, view2, i8);
        } catch (AbstractMethodError e8) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e8);
            return false;
        }
    }

    public static void g(ViewParent viewParent, View view, int i8) {
        if (viewParent instanceof InterfaceC0937t) {
            ((InterfaceC0937t) viewParent).e(view, i8);
            return;
        }
        if (i8 == 0) {
            try {
                a.g(viewParent, view);
            } catch (AbstractMethodError e8) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e8);
            }
        }
    }
}
