package R0;

import Q.W;
import android.graphics.Rect;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O0.b f4665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final W f4666b;

    public k(O0.b _bounds, W _windowInsetsCompat) {
        r.f(_bounds, "_bounds");
        r.f(_windowInsetsCompat, "_windowInsetsCompat");
        this.f4665a = _bounds;
        this.f4666b = _windowInsetsCompat;
    }

    public final Rect a() {
        return this.f4665a.f();
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
        return r.b(this.f4665a, kVar.f4665a) && r.b(this.f4666b, kVar.f4666b);
    }

    public int hashCode() {
        return (this.f4665a.hashCode() * 31) + this.f4666b.hashCode();
    }

    public String toString() {
        return "WindowMetrics( bounds=" + this.f4665a + ", windowInsetsCompat=" + this.f4666b + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ k(Rect rect, W w7, int i7, AbstractC2148j abstractC2148j) {
        if ((i7 & 2) != 0) {
            w7 = new W.b().a();
            r.e(w7, "Builder().build()");
        }
        this(rect, w7);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(Rect bounds, W insets) {
        this(new O0.b(bounds), insets);
        r.f(bounds, "bounds");
        r.f(insets, "insets");
    }
}
