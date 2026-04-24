package M2;

import K2.C0355c;
import K2.S;

/* JADX INFO: renamed from: M2.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0452w0 extends S.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0355c f2661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final K2.Z f2662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final K2.a0 f2663c;

    public C0452w0(K2.a0 a0Var, K2.Z z4, C0355c c0355c) {
        this.f2663c = (K2.a0) Z1.m.o(a0Var, "method");
        this.f2662b = (K2.Z) Z1.m.o(z4, "headers");
        this.f2661a = (C0355c) Z1.m.o(c0355c, "callOptions");
    }

    @Override // K2.S.g
    public C0355c a() {
        return this.f2661a;
    }

    @Override // K2.S.g
    public K2.Z b() {
        return this.f2662b;
    }

    @Override // K2.S.g
    public K2.a0 c() {
        return this.f2663c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0452w0.class == obj.getClass()) {
            C0452w0 c0452w0 = (C0452w0) obj;
            if (Z1.i.a(this.f2661a, c0452w0.f2661a) && Z1.i.a(this.f2662b, c0452w0.f2662b) && Z1.i.a(this.f2663c, c0452w0.f2663c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Z1.i.b(this.f2661a, this.f2662b, this.f2663c);
    }

    public final String toString() {
        return "[method=" + this.f2663c + " headers=" + this.f2662b + " callOptions=" + this.f2661a + "]";
    }
}
