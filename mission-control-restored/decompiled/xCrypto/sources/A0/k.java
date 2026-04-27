package A0;

import H.L;
import android.graphics.Rect;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import x0.C1913b;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1913b f44a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final L f45b;

    public k(C1913b _bounds, L _windowInsetsCompat) {
        r.f(_bounds, "_bounds");
        r.f(_windowInsetsCompat, "_windowInsetsCompat");
        this.f44a = _bounds;
        this.f45b = _windowInsetsCompat;
    }

    public final Rect a() {
        return this.f44a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!r.b(k.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        r.d(obj, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
        k kVar = (k) obj;
        return r.b(this.f44a, kVar.f44a) && r.b(this.f45b, kVar.f45b);
    }

    public int hashCode() {
        return (this.f44a.hashCode() * 31) + this.f45b.hashCode();
    }

    public String toString() {
        return "WindowMetrics( bounds=" + this.f44a + ", windowInsetsCompat=" + this.f45b + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ k(Rect rect, L l4, int i4, AbstractC1585j abstractC1585j) {
        if ((i4 & 2) != 0) {
            l4 = new L.b().a();
            r.e(l4, "Builder().build()");
        }
        this(rect, l4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(Rect bounds, L insets) {
        this(new C1913b(bounds), insets);
        r.f(bounds, "bounds");
        r.f(insets, "insets");
    }
}
