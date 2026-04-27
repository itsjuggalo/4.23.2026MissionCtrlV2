package com.amazon.a.a.n.a;

import com.amazon.d.a.j;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f8677b = new com.amazon.a.a.o.c("KiwiCommand");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.amazon.a.a.j.a f8678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f8680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f8681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, Object> f8682g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f8684i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private h f8685j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private h f8686k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.amazon.a.b.f f8683h = new com.amazon.a.b.f();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8687l = false;

    public h(com.amazon.a.a.j.a aVar, String str, String str2, String str3, String str4) {
        this.f8678c = aVar;
        this.f8679d = str3;
        this.f8680e = str;
        this.f8681f = str2;
        HashMap map = new HashMap();
        this.f8682g = map;
        map.put(com.amazon.a.a.o.b.f8728B, str3);
        map.put(com.amazon.a.a.o.b.f8735I, str4);
        this.f8684i = true;
        this.f8685j = null;
        this.f8686k = null;
    }

    public h a(boolean z4) {
        this.f8687l = z4;
        return this;
    }

    @Override // com.amazon.a.a.n.a.a
    public String a_() {
        return this.f8680e;
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
        return this.f8687l;
    }

    public com.amazon.a.a.j.a j() {
        return this.f8678c;
    }

    public String k() {
        return this.f8679d;
    }

    public void l() {
        com.amazon.a.a.a(this);
    }

    public void a(h hVar) {
        this.f8685j = hVar;
    }

    public void b(h hVar) {
        this.f8686k = hVar;
    }

    @Override // com.amazon.a.a.n.a.a
    public String c() {
        return this.f8681f;
    }

    public void a(String str, Object obj) {
        this.f8682g.put(str, obj);
    }

    @Override // com.amazon.a.a.n.a.a
    public Map<String, Object> b() {
        return this.f8682g;
    }

    private void a(com.amazon.a.a.i.c cVar) {
        if (cVar == null) {
            return;
        }
        com.amazon.a.a.i.a aVar = new com.amazon.a.a.i.a(cVar);
        com.amazon.a.a.i.e eVarA = com.amazon.a.a.a();
        if (eVarA == null) {
            f8677b.b("Prompt manager is null. Cannot show prompt dropping request");
        } else {
            eVarA.a((com.amazon.a.a.i.b) aVar);
        }
    }

    public void b(boolean z4) {
        this.f8684i = z4;
    }

    @Override // com.amazon.a.a.n.a.a
    public void b(com.amazon.a.a.d.b bVar) {
        h hVar;
        if ("UNHANDLED_EXCEPTION".equals(bVar.a()) && com.amazon.a.a.o.b.ah.equals(this.f8681f) && (hVar = this.f8686k) != null) {
            hVar.a(this.f8687l);
            this.f8686k.l();
            return;
        }
        try {
            c(bVar);
        } catch (Exception e4) {
            f8677b.a("Error calling onResult: " + e4);
        }
        if (this.f8684i) {
            a(this.f8683h.a(bVar));
        }
        if (this.f8687l) {
            return;
        }
        this.f8678c.c();
    }

    @Override // com.amazon.a.a.n.a.a
    public void a(j jVar) {
        boolean zB;
        h hVar;
        String str = (String) jVar.b().get(com.amazon.a.a.o.b.f8758f);
        f8677b.a("onSuccess: result = " + jVar + ", errorMessage: " + str);
        if (com.amazon.a.a.o.f.a(str)) {
            try {
                zB = b(jVar);
            } catch (Exception e4) {
                f8677b.a("Error calling onResult: " + e4);
                zB = false;
            }
            if (zB && (hVar = this.f8685j) != null) {
                hVar.l();
                return;
            } else {
                if (this.f8687l) {
                    return;
                }
                if (zB) {
                    this.f8678c.b();
                    return;
                } else {
                    this.f8678c.c();
                    return;
                }
            }
        }
        if (this.f8687l) {
            return;
        }
        this.f8678c.c();
    }

    @Override // com.amazon.a.a.n.a.a
    public void a(com.amazon.d.a.h hVar) {
        String str;
        h hVar2;
        f8677b.a("onFailure: result = " + hVar);
        if (hVar != null && (str = (String) hVar.f().get(com.amazon.a.a.o.b.an)) != null && str.equalsIgnoreCase("1.0") && (hVar2 = this.f8686k) != null) {
            hVar2.a(this.f8687l);
            this.f8686k.l();
            return;
        }
        try {
            b(hVar);
        } catch (Exception e4) {
            f8677b.a("Error calling onResult: " + e4);
        }
        if (this.f8684i) {
            a(new com.amazon.a.a.i.c(hVar.b(), hVar.c(), hVar.d(), hVar.e()));
        }
        if (this.f8687l) {
            return;
        }
        this.f8678c.c();
    }
}
