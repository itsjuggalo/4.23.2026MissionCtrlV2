package L0;

import android.graphics.Rect;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I0.b f4993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f4994b;

    public k(I0.b _bounds, float f8) {
        AbstractC2304t.f(_bounds, "_bounds");
        this.f4993a = _bounds;
        this.f4994b = f8;
    }

    public final Rect a() {
        return this.f4993a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC2304t.b(k.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC2304t.d(obj, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
        k kVar = (k) obj;
        return AbstractC2304t.b(this.f4993a, kVar.f4993a) && this.f4994b == kVar.f4994b;
    }

    public int hashCode() {
        return (this.f4993a.hashCode() * 31) + Float.hashCode(this.f4994b);
    }

    public String toString() {
        return "WindowMetrics(_bounds=" + this.f4993a + ", density=" + this.f4994b + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(Rect bounds, float f8) {
        this(new I0.b(bounds), f8);
        AbstractC2304t.f(bounds, "bounds");
    }
}
