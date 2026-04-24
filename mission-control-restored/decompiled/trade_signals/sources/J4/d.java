package J4;

import u7.C2814g;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2814g f4572d = C2814g.g(":status");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2814g f4573e = C2814g.g(":method");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C2814g f4574f = C2814g.g(":path");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C2814g f4575g = C2814g.g(":scheme");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C2814g f4576h = C2814g.g(":authority");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C2814g f4577i = C2814g.g(":host");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C2814g f4578j = C2814g.g(":version");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2814g f4579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2814g f4580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4581c;

    public d(String str, String str2) {
        this(C2814g.g(str), C2814g.g(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f4579a.equals(dVar.f4579a) && this.f4580b.equals(dVar.f4580b);
    }

    public int hashCode() {
        return ((527 + this.f4579a.hashCode()) * 31) + this.f4580b.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", this.f4579a.X(), this.f4580b.X());
    }

    public d(C2814g c2814g, String str) {
        this(c2814g, C2814g.g(str));
    }

    public d(C2814g c2814g, C2814g c2814g2) {
        this.f4579a = c2814g;
        this.f4580b = c2814g2;
        this.f4581c = c2814g.R() + 32 + c2814g2.R();
    }
}
