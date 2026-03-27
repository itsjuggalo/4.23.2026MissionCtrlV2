package k3;

import h3.C1875k;
import java.util.Map;
import p3.C2548b;

/* JADX INFO: renamed from: k3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2277k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C2548b f20379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C2277k f20380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C2278l f20381c;

    /* JADX INFO: renamed from: k3.k$a */
    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f20382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f20383b;

        public a(c cVar, boolean z7) {
            this.f20382a = cVar;
            this.f20383b = z7;
        }

        @Override // k3.C2277k.c
        public void a(C2277k c2277k) {
            c2277k.e(this.f20382a, true, this.f20383b);
        }
    }

    /* JADX INFO: renamed from: k3.k$b */
    public interface b {
        boolean a(C2277k c2277k);
    }

    /* JADX INFO: renamed from: k3.k$c */
    public interface c {
        void a(C2277k c2277k);
    }

    public C2277k() {
        this(null, null, new C2278l());
    }

    public boolean a(b bVar) {
        return b(bVar, false);
    }

    public boolean b(b bVar, boolean z7) {
        for (C2277k c2277k = z7 ? this : this.f20380b; c2277k != null; c2277k = c2277k.f20380b) {
            if (bVar.a(c2277k)) {
                return true;
            }
        }
        return false;
    }

    public void c(c cVar) {
        for (Object obj : this.f20381c.f20385a.entrySet().toArray()) {
            Map.Entry entry = (Map.Entry) obj;
            cVar.a(new C2277k((C2548b) entry.getKey(), this, (C2278l) entry.getValue()));
        }
    }

    public void d(c cVar) {
        e(cVar, false, false);
    }

    public void e(c cVar, boolean z7, boolean z8) {
        if (z7 && !z8) {
            cVar.a(this);
        }
        c(new a(cVar, z8));
        if (z7 && z8) {
            cVar.a(this);
        }
    }

    public C1875k f() {
        if (this.f20380b == null) {
            return this.f20379a != null ? new C1875k(this.f20379a) : C1875k.O();
        }
        AbstractC2279m.f(this.f20379a != null);
        return this.f20380b.f().K(this.f20379a);
    }

    public Object g() {
        return this.f20381c.f20386b;
    }

    public boolean h() {
        return !this.f20381c.f20385a.isEmpty();
    }

    public boolean i() {
        C2278l c2278l = this.f20381c;
        return c2278l.f20386b == null && c2278l.f20385a.isEmpty();
    }

    public void j(Object obj) {
        this.f20381c.f20386b = obj;
        n();
    }

    public C2277k k(C1875k c1875k) {
        C2548b c2548bP = c1875k.P();
        C2277k c2277k = this;
        while (c2548bP != null) {
            C2277k c2277k2 = new C2277k(c2548bP, c2277k, c2277k.f20381c.f20385a.containsKey(c2548bP) ? (C2278l) c2277k.f20381c.f20385a.get(c2548bP) : new C2278l());
            c1875k = c1875k.S();
            c2548bP = c1875k.P();
            c2277k = c2277k2;
        }
        return c2277k;
    }

    public String l(String str) {
        C2548b c2548b = this.f20379a;
        String strB = c2548b == null ? "<anon>" : c2548b.b();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(strB);
        sb.append("\n");
        sb.append(this.f20381c.a(str + "\t"));
        return sb.toString();
    }

    public final void m(C2548b c2548b, C2277k c2277k) {
        boolean zI = c2277k.i();
        boolean zContainsKey = this.f20381c.f20385a.containsKey(c2548b);
        if (zI && zContainsKey) {
            this.f20381c.f20385a.remove(c2548b);
        } else if (zI || zContainsKey) {
            return;
        } else {
            this.f20381c.f20385a.put(c2548b, c2277k.f20381c);
        }
        n();
    }

    public final void n() {
        C2277k c2277k = this.f20380b;
        if (c2277k != null) {
            c2277k.m(this.f20379a, this);
        }
    }

    public String toString() {
        return l("");
    }

    public C2277k(C2548b c2548b, C2277k c2277k, C2278l c2278l) {
        this.f20379a = c2548b;
        this.f20380b = c2277k;
        this.f20381c = c2278l;
    }
}
