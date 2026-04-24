package D;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import com.cryptosignals.ap.android.R;
import w.C1264c;

/* JADX INFO: renamed from: D.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0019t {
    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static V b(View view, V v2, Rect rect) {
        WindowInsets windowInsetsB = v2.b();
        if (windowInsetsB != null) {
            return V.c(view.computeSystemWindowInsets(windowInsetsB, rect), view);
        }
        rect.setEmpty();
        return v2;
    }

    public static boolean c(View view, float f6, float f7, boolean z6) {
        return view.dispatchNestedFling(f6, f7, z6);
    }

    public static boolean d(View view, float f6, float f7) {
        return view.dispatchNestedPreFling(f6, f7);
    }

    public static boolean e(View view, int i, int i6, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i, i6, iArr, iArr2);
    }

    public static boolean f(View view, int i, int i6, int i7, int i8, int[] iArr) {
        return view.dispatchNestedScroll(i, i6, i7, i8, iArr);
    }

    public static ColorStateList g(View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode h(View view) {
        return view.getBackgroundTintMode();
    }

    public static float i(View view) {
        return view.getElevation();
    }

    public static V j(View view) {
        if (!I.f201d || !view.isAttachedToWindow()) {
            return null;
        }
        try {
            Object obj = I.f198a.get(view.getRootView());
            if (obj == null) {
                return null;
            }
            Rect rect = (Rect) I.f199b.get(obj);
            Rect rect2 = (Rect) I.f200c.get(obj);
            if (rect == null || rect2 == null) {
                return null;
            }
            int i = Build.VERSION.SDK_INT;
            M l6 = i >= 30 ? new L() : i >= 29 ? new K() : new J();
            l6.c(C1264c.a(rect.left, rect.top, rect.right, rect.bottom));
            l6.d(C1264c.a(rect2.left, rect2.top, rect2.right, rect2.bottom));
            V vB = l6.b();
            vB.f219a.l(vB);
            vB.f219a.d(view.getRootView());
            return vB;
        } catch (IllegalAccessException e) {
            Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
            return null;
        }
    }

    public static String k(View view) {
        return view.getTransitionName();
    }

    public static float l(View view) {
        return view.getTranslationZ();
    }

    public static float m(View view) {
        return view.getZ();
    }

    public static boolean n(View view) {
        return view.hasNestedScrollingParent();
    }

    public static boolean o(View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean p(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void q(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void r(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void s(View view, float f6) {
        view.setElevation(f6);
    }

    public static void t(View view, boolean z6) {
        view.setNestedScrollingEnabled(z6);
    }

    public static void u(View view, InterfaceC0010j interfaceC0010j) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, interfaceC0010j);
        }
        if (interfaceC0010j == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC0018s(view, interfaceC0010j));
        }
    }

    public static void v(View view, String str) {
        view.setTransitionName(str);
    }

    public static void w(View view, float f6) {
        view.setTranslationZ(f6);
    }

    public static void x(View view, float f6) {
        view.setZ(f6);
    }

    public static boolean y(View view, int i) {
        return view.startNestedScroll(i);
    }

    public static void z(View view) {
        view.stopNestedScroll();
    }
}
