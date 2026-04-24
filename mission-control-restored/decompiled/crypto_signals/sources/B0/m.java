package B0;

import D.V;
import y0.C1414b;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1414b f107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V f108b;

    public m(C1414b c1414b, V _windowInsetsCompat) {
        kotlin.jvm.internal.j.e(_windowInsetsCompat, "_windowInsetsCompat");
        this.f107a = c1414b;
        this.f108b = _windowInsetsCompat;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!m.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
        m mVar = (m) obj;
        return kotlin.jvm.internal.j.a(this.f107a, mVar.f107a) && kotlin.jvm.internal.j.a(this.f108b, mVar.f108b);
    }

    public final int hashCode() {
        return this.f108b.hashCode() + (this.f107a.hashCode() * 31);
    }

    public final String toString() {
        return "WindowMetrics( bounds=" + this.f107a + ", windowInsetsCompat=" + this.f108b + ')';
    }
}
