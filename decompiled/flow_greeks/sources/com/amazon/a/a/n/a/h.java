package com.amazon.a.a.n.a;

import com.amazon.d.a.j;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f4489b = new com.amazon.a.a.o.c("KiwiCommand");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.amazon.a.a.j.a f4490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f4492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f4493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, Object> f4494g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f4496i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private h f4497j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private h f4498k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.amazon.a.b.f f4495h = new com.amazon.a.b.f();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f4499l = false;

    public h(com.amazon.a.a.j.a aVar, String str, String str2, String str3, String str4) {
        this.f4490c = aVar;
        this.f4491d = str3;
        this.f4492e = str;
        this.f4493f = str2;
        HashMap map = new HashMap();
        this.f4494g = map;
        map.put(com.amazon.a.a.o.b.B, str3);
        map.put(com.amazon.a.a.o.b.I, str4);
        this.f4496i = true;
        this.f4497j = null;
        this.f4498k = null;
    }

    public h a(boolean z10) {
        this.f4499l = z10;
        return this;
    }

    @Override // com.amazon.a.a.n.a.a
    public String a_() {
        return this.f4492e;
    }

    public void b(com.amazon.d.a.h hVar) {
    }

    public abstract boolean b(j jVar);

    public void c(com.amazon.a.a.d.b bVar) {
    }

    @Override // com.amazon.a.a.n.a.a
    public boolean d() {
        return true;
    }

    public boolean i() {
        return this.f4499l;
    }

    public com.amazon.a.a.j.a j() {
        return this.f4490c;
    }

    public String k() {
        return this.f4491d;
    }

    public void l() {
        com.amazon.a.a.a(this);
    }

    public void a(h hVar) {
        this.f4497j = hVar;
    }

    public void b(h hVar) {
        this.f4498k = hVar;
    }

    @Override // com.amazon.a.a.n.a.a
    public String c() {
        return this.f4493f;
    }

    public void a(String str, Object obj) {
        this.f4494g.put(str, obj);
    }

    @Override // com.amazon.a.a.n.a.a
    public Map<String, Object> b() {
        return this.f4494g;
    }

    private void a(com.amazon.a.a.i.c cVar) {
        if (cVar == null) {
            return;
        }
        com.amazon.a.a.i.a aVar = new com.amazon.a.a.i.a(cVar);
        com.amazon.a.a.i.e eVarA = com.amazon.a.a.a();
        if (eVarA == null) {
            f4489b.b("Prompt manager is null. Cannot show prompt dropping request");
        } else {
            eVarA.a((com.amazon.a.a.i.b) aVar);
        }
    }

    public void b(boolean z10) {
        this.f4496i = z10;
    }

    @Override // com.amazon.a.a.n.a.a
    public void b(com.amazon.a.a.d.b bVar) {
        h hVar;
        if ("UNHANDLED_EXCEPTION".equals(bVar.a()) && com.amazon.a.a.o.b.f4547ah.equals(this.f4493f) && (hVar = this.f4498k) != null) {
            hVar.a(this.f4499l);
            this.f4498k.l();
            return;
        }
        try {
            c(bVar);
        } catch (Exception e10) {
            f4489b.a("Error calling onResult: " + e10);
        }
        if (this.f4496i) {
            a(this.f4495h.a(bVar));
        }
        if (this.f4499l) {
            return;
        }
        this.f4490c.c();
    }

    @Override // com.amazon.a.a.n.a.a
    public void a(j jVar) {
        boolean zB;
        h hVar;
        String str = (String) jVar.b().get(com.amazon.a.a.o.b.f4552f);
        f4489b.a("onSuccess: result = " + jVar + ", errorMessage: " + str);
        if (com.amazon.a.a.o.f.a(str)) {
            try {
                zB = b(jVar);
            } catch (Exception e10) {
                f4489b.a("Error calling onResult: " + e10);
                zB = false;
            }
            if (zB && (hVar = this.f4497j) != null) {
                hVar.l();
                return;
            } else {
                if (this.f4499l) {
                    return;
                }
                if (zB) {
                    this.f4490c.b();
                    return;
                } else {
                    this.f4490c.c();
                    return;
                }
            }
        }
        if (this.f4499l) {
            return;
        }
        this.f4490c.c();
    }

    @Override // com.amazon.a.a.n.a.a
    public void a(com.amazon.d.a.h hVar) {
        String str;
        h hVar2;
        f4489b.a("onFailure: result = " + hVar);
        if (hVar != null && (str = (String) hVar.f().get(com.amazon.a.a.o.b.an)) != null && str.equalsIgnoreCase("1.0") && (hVar2 = this.f4498k) != null) {
            hVar2.a(this.f4499l);
            this.f4498k.l();
            return;
        }
        try {
            b(hVar);
        } catch (Exception e10) {
            f4489b.a("Error calling onResult: " + e10);
        }
        if (this.f4496i) {
            a(new com.amazon.a.a.i.c(hVar.b(), hVar.c(), hVar.d(), hVar.e()));
        }
        if (this.f4499l) {
            return;
        }
        this.f4490c.c();
    }
}
