package B0;

import y0.C1414b;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1414b f84a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f85b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f86c;

    public c(C1414b c1414b, b bVar, b bVar2) {
        this.f84a = c1414b;
        this.f85b = bVar;
        this.f86c = bVar2;
        int i = c1414b.f11616c;
        int i6 = c1414b.f11614a;
        int i7 = i - i6;
        int i8 = c1414b.f11615b;
        if (i7 == 0 && c1414b.f11617d - i8 == 0) {
            throw new IllegalArgumentException("Bounds must be non zero");
        }
        if (i6 != 0 && i8 != 0) {
            throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!c.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        c cVar = (c) obj;
        return kotlin.jvm.internal.j.a(this.f84a, cVar.f84a) && kotlin.jvm.internal.j.a(this.f85b, cVar.f85b) && kotlin.jvm.internal.j.a(this.f86c, cVar.f86c);
    }

    public final int hashCode() {
        return this.f86c.hashCode() + ((this.f85b.hashCode() + (this.f84a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return c.class.getSimpleName() + " { " + this.f84a + ", type=" + this.f85b + ", state=" + this.f86c + " }";
    }
}
