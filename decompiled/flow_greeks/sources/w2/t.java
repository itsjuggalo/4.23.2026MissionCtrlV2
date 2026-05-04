package w2;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t2.b f23661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f23662b;

    public t(t2.b _bounds, float f10) {
        kotlin.jvm.internal.t.f(_bounds, "_bounds");
        this.f23661a = _bounds;
        this.f23662b = f10;
    }

    public final Rect a() {
        return this.f23661a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.t.b(t.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
        t tVar = (t) obj;
        return kotlin.jvm.internal.t.b(this.f23661a, tVar.f23661a) && this.f23662b == tVar.f23662b;
    }

    public int hashCode() {
        return (this.f23661a.hashCode() * 31) + Float.hashCode(this.f23662b);
    }

    public String toString() {
        return "WindowMetrics(_bounds=" + this.f23661a + ", density=" + this.f23662b + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t(Rect bounds, float f10) {
        this(new t2.b(bounds), f10);
        kotlin.jvm.internal.t.f(bounds, "bounds");
    }
}
