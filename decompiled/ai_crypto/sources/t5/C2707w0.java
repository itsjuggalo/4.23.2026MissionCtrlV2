package t5;

import r5.C2587c;
import r5.S;

/* JADX INFO: renamed from: t5.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2707w0 extends S.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2587c f24212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r5.Z f24213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r5.a0 f24214c;

    public C2707w0(r5.a0 a0Var, r5.Z z7, C2587c c2587c) {
        this.f24214c = (r5.a0) H2.m.o(a0Var, "method");
        this.f24213b = (r5.Z) H2.m.o(z7, "headers");
        this.f24212a = (C2587c) H2.m.o(c2587c, "callOptions");
    }

    @Override // r5.S.g
    public C2587c a() {
        return this.f24212a;
    }

    @Override // r5.S.g
    public r5.Z b() {
        return this.f24213b;
    }

    @Override // r5.S.g
    public r5.a0 c() {
        return this.f24214c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2707w0.class != obj.getClass()) {
            return false;
        }
        C2707w0 c2707w0 = (C2707w0) obj;
        return H2.i.a(this.f24212a, c2707w0.f24212a) && H2.i.a(this.f24213b, c2707w0.f24213b) && H2.i.a(this.f24214c, c2707w0.f24214c);
    }

    public int hashCode() {
        return H2.i.b(this.f24212a, this.f24213b, this.f24214c);
    }

    public final String toString() {
        return "[method=" + this.f24214c + " headers=" + this.f24213b + " callOptions=" + this.f24212a + "]";
    }
}
