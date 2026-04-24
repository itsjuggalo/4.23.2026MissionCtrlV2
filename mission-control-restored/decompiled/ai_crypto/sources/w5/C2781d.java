package w5;

import w6.C2795h;

/* JADX INFO: renamed from: w5.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2781d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2795h f24969d = C2795h.j(":status");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2795h f24970e = C2795h.j(":method");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C2795h f24971f = C2795h.j(":path");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C2795h f24972g = C2795h.j(":scheme");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C2795h f24973h = C2795h.j(":authority");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C2795h f24974i = C2795h.j(":host");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C2795h f24975j = C2795h.j(":version");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2795h f24976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2795h f24977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f24978c;

    public C2781d(String str, String str2) {
        this(C2795h.j(str), C2795h.j(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2781d)) {
            return false;
        }
        C2781d c2781d = (C2781d) obj;
        return this.f24976a.equals(c2781d.f24976a) && this.f24977b.equals(c2781d.f24977b);
    }

    public int hashCode() {
        return ((527 + this.f24976a.hashCode()) * 31) + this.f24977b.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", this.f24976a.N(), this.f24977b.N());
    }

    public C2781d(C2795h c2795h, String str) {
        this(c2795h, C2795h.j(str));
    }

    public C2781d(C2795h c2795h, C2795h c2795h2) {
        this.f24976a = c2795h;
        this.f24977b = c2795h2;
        this.f24978c = c2795h.H() + 32 + c2795h2.H();
    }
}
