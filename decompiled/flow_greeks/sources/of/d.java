package of;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ef.c f18114b;

    public d(String str) {
        if (str == null) {
            a(7);
        }
        this.f18113a = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r9) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: of.d.a(int):void");
    }

    public static d b(ef.b bVar) {
        if (bVar == null) {
            a(1);
        }
        return new d(h(bVar));
    }

    public static d c(ef.c cVar) {
        if (cVar == null) {
            a(4);
        }
        d dVar = new d(cVar.a().replace(com.amazon.a.a.o.c.a.b.f4610a, '/'));
        dVar.f18114b = cVar;
        return dVar;
    }

    public static d d(String str) {
        if (str == null) {
            a(0);
        }
        return new d(str);
    }

    public static String h(ef.b bVar) {
        if (bVar == null) {
            a(2);
        }
        ef.c cVarF = bVar.f();
        String strReplace = bVar.g().a().replace(com.amazon.a.a.o.c.a.b.f4610a, '$');
        if (!cVarF.c()) {
            strReplace = cVarF.a().replace(com.amazon.a.a.o.c.a.b.f4610a, '/') + "/" + strReplace;
        }
        if (strReplace == null) {
            a(3);
        }
        return strReplace;
    }

    public ef.c e() {
        return new ef.c(this.f18113a.replace('/', com.amazon.a.a.o.c.a.b.f4610a));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f18113a.equals(((d) obj).f18113a);
    }

    public String f() {
        String str = this.f18113a;
        if (str == null) {
            a(10);
        }
        return str;
    }

    public ef.c g() {
        int iLastIndexOf = this.f18113a.lastIndexOf("/");
        if (iLastIndexOf != -1) {
            return new ef.c(this.f18113a.substring(0, iLastIndexOf).replace('/', com.amazon.a.a.o.c.a.b.f4610a));
        }
        ef.c cVar = ef.c.f8784d;
        if (cVar == null) {
            a(9);
        }
        return cVar;
    }

    public int hashCode() {
        return this.f18113a.hashCode();
    }

    public String toString() {
        return this.f18113a;
    }
}
