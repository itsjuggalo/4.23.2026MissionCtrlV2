package m8;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r8.b f16104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f16105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f16106c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f16107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f16108b;

        public a(c cVar, boolean z10) {
            this.f16107a = cVar;
            this.f16108b = z10;
        }

        @Override // m8.k.c
        public void a(k kVar) {
            kVar.e(this.f16107a, true, this.f16108b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        boolean a(k kVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c {
        void a(k kVar);
    }

    public k(r8.b bVar, k kVar, l lVar) {
        this.f16104a = bVar;
        this.f16105b = kVar;
        this.f16106c = lVar;
    }

    public boolean a(b bVar) {
        return b(bVar, false);
    }

    public boolean b(b bVar, boolean z10) {
        for (k kVar = z10 ? this : this.f16105b; kVar != null; kVar = kVar.f16105b) {
            if (bVar.a(kVar)) {
                return true;
            }
        }
        return false;
    }

    public void c(c cVar) {
        for (Object obj : this.f16106c.f16110a.entrySet().toArray()) {
            Map.Entry entry = (Map.Entry) obj;
            cVar.a(new k((r8.b) entry.getKey(), this, (l) entry.getValue()));
        }
    }

    public void d(c cVar) {
        e(cVar, false, false);
    }

    public void e(c cVar, boolean z10, boolean z11) {
        if (z10 && !z11) {
            cVar.a(this);
        }
        c(new a(cVar, z11));
        if (z10 && z11) {
            cVar.a(this);
        }
    }

    public j8.l f() {
        if (this.f16105b == null) {
            return this.f16104a != null ? new j8.l(this.f16104a) : j8.l.G();
        }
        m.f(this.f16104a != null);
        return this.f16105b.f().v(this.f16104a);
    }

    public Object g() {
        return this.f16106c.f16111b;
    }

    public boolean h() {
        return !this.f16106c.f16110a.isEmpty();
    }

    public boolean i() {
        l lVar = this.f16106c;
        return lVar.f16111b == null && lVar.f16110a.isEmpty();
    }

    public void j(Object obj) {
        this.f16106c.f16111b = obj;
        n();
    }

    public k k(j8.l lVar) {
        r8.b bVarK = lVar.K();
        k kVar = this;
        while (bVarK != null) {
            k kVar2 = new k(bVarK, kVar, kVar.f16106c.f16110a.containsKey(bVarK) ? (l) kVar.f16106c.f16110a.get(bVarK) : new l());
            lVar = lVar.S();
            bVarK = lVar.K();
            kVar = kVar2;
        }
        return kVar;
    }

    public String l(String str) {
        r8.b bVar = this.f16104a;
        String strB = bVar == null ? "<anon>" : bVar.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(strB);
        sb2.append("\n");
        sb2.append(this.f16106c.a(str + "\t"));
        return sb2.toString();
    }

    public final void m(r8.b bVar, k kVar) {
        boolean zI = kVar.i();
        boolean zContainsKey = this.f16106c.f16110a.containsKey(bVar);
        if (zI && zContainsKey) {
            this.f16106c.f16110a.remove(bVar);
            n();
        } else {
            if (zI || zContainsKey) {
                return;
            }
            this.f16106c.f16110a.put(bVar, kVar.f16106c);
            n();
        }
    }

    public final void n() {
        k kVar = this.f16105b;
        if (kVar != null) {
            kVar.m(this.f16104a, this);
        }
    }

    public String toString() {
        return l("");
    }

    public k() {
        this(null, null, new l());
    }
}
