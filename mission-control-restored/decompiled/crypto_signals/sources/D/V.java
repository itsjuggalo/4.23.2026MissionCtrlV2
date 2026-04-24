package D;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.util.Objects;
import w.C1264c;

/* JADX INFO: loaded from: classes.dex */
public final class V {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final V f218b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final U f219a;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f218b = T.f215l;
        } else {
            f218b = U.f216b;
        }
    }

    public V(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.f219a = new T(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.f219a = new Q(this, windowInsets);
        } else if (i >= 28) {
            this.f219a = new P(this, windowInsets);
        } else {
            this.f219a = new O(this, windowInsets);
        }
    }

    public static C1264c a(C1264c c1264c, int i, int i6, int i7, int i8) {
        int iMax = Math.max(0, c1264c.f10677a - i);
        int iMax2 = Math.max(0, c1264c.f10678b - i6);
        int iMax3 = Math.max(0, c1264c.f10679c - i7);
        int iMax4 = Math.max(0, c1264c.f10680d - i8);
        return (iMax == i && iMax2 == i6 && iMax3 == i7 && iMax4 == i8) ? c1264c : C1264c.a(iMax, iMax2, iMax3, iMax4);
    }

    public static V c(WindowInsets windowInsets, View view) {
        windowInsets.getClass();
        V v2 = new V(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            Field field = C.f194a;
            V vA = AbstractC0020u.a(view);
            U u6 = v2.f219a;
            u6.l(vA);
            u6.d(view.getRootView());
        }
        return v2;
    }

    public final WindowInsets b() {
        U u6 = this.f219a;
        if (u6 instanceof N) {
            return ((N) u6).f212c;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof V)) {
            return false;
        }
        return Objects.equals(this.f219a, ((V) obj).f219a);
    }

    public final int hashCode() {
        U u6 = this.f219a;
        if (u6 == null) {
            return 0;
        }
        return u6.hashCode();
    }

    public V() {
        this.f219a = new U(this);
    }
}
