package z4;

import u5.AbstractC1245b;

/* JADX INFO: renamed from: z4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1473b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u5.j f11782d;
    public static final u5.j e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final u5.j f11783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final u5.j f11784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final u5.j f11785h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u5.j f11786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u5.j f11787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11788c;

    static {
        u5.j jVar = u5.j.f10527d;
        f11782d = AbstractC1245b.e(":status");
        e = AbstractC1245b.e(":method");
        f11783f = AbstractC1245b.e(":path");
        f11784g = AbstractC1245b.e(":scheme");
        f11785h = AbstractC1245b.e(":authority");
        AbstractC1245b.e(":host");
        AbstractC1245b.e(":version");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1473b(String str, String str2) {
        this(AbstractC1245b.e(str), AbstractC1245b.e(str2));
        u5.j jVar = u5.j.f10527d;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1473b) {
            C1473b c1473b = (C1473b) obj;
            if (this.f11786a.equals(c1473b.f11786a) && this.f11787b.equals(c1473b.f11787b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f11787b.hashCode() + ((this.f11786a.hashCode() + 527) * 31);
    }

    public final String toString() {
        return a3.d.k(this.f11786a.s(), ": ", this.f11787b.s());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1473b(u5.j jVar, String str) {
        this(jVar, AbstractC1245b.e(str));
        u5.j jVar2 = u5.j.f10527d;
    }

    public C1473b(u5.j jVar, u5.j jVar2) {
        this.f11786a = jVar;
        this.f11787b = jVar2;
        this.f11788c = jVar2.d() + jVar.d() + 32;
    }
}
