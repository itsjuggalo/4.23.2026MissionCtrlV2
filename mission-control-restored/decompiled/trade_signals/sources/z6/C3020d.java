package z6;

/* JADX INFO: renamed from: z6.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C3020d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q6.c f24808b;

    public C3020d(String str) {
        if (str == null) {
            a(7);
        }
        this.f24807a = str;
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
        throw new UnsupportedOperationException("Method not decompiled: z6.C3020d.a(int):void");
    }

    public static C3020d b(q6.b bVar) {
        if (bVar == null) {
            a(1);
        }
        return new C3020d(h(bVar));
    }

    public static C3020d c(q6.c cVar) {
        if (cVar == null) {
            a(4);
        }
        C3020d c3020d = new C3020d(cVar.a().replace(com.amazon.a.a.o.c.a.b.f14112a, '/'));
        c3020d.f24808b = cVar;
        return c3020d;
    }

    public static C3020d d(String str) {
        if (str == null) {
            a(0);
        }
        return new C3020d(str);
    }

    public static String h(q6.b bVar) {
        if (bVar == null) {
            a(2);
        }
        q6.c cVarF = bVar.f();
        String strReplace = bVar.g().a().replace(com.amazon.a.a.o.c.a.b.f14112a, '$');
        if (!cVarF.c()) {
            strReplace = cVarF.a().replace(com.amazon.a.a.o.c.a.b.f14112a, '/') + "/" + strReplace;
        }
        if (strReplace == null) {
            a(3);
        }
        return strReplace;
    }

    public q6.c e() {
        return new q6.c(this.f24807a.replace('/', com.amazon.a.a.o.c.a.b.f14112a));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f24807a.equals(((C3020d) obj).f24807a);
    }

    public String f() {
        String str = this.f24807a;
        if (str == null) {
            a(10);
        }
        return str;
    }

    public q6.c g() {
        int iLastIndexOf = this.f24807a.lastIndexOf("/");
        if (iLastIndexOf != -1) {
            return new q6.c(this.f24807a.substring(0, iLastIndexOf).replace('/', com.amazon.a.a.o.c.a.b.f14112a));
        }
        q6.c cVar = q6.c.f22660d;
        if (cVar == null) {
            a(9);
        }
        return cVar;
    }

    public int hashCode() {
        return this.f24807a.hashCode();
    }

    public String toString() {
        return this.f24807a;
    }
}
