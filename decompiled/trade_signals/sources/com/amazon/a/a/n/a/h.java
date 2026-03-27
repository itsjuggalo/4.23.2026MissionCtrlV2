package com.amazon.a.a.n.a;

import com.amazon.d.a.j;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f13973b = new com.amazon.a.a.o.c("KiwiCommand");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.amazon.a.a.j.a f13974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f13975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f13976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f13977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, Object> f13978g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f13980i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private h f13981j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private h f13982k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.amazon.a.b.f f13979h = new com.amazon.a.b.f();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f13983l = false;

    public h(com.amazon.a.a.j.a aVar, String str, String str2, String str3, String str4) {
        this.f13974c = aVar;
        this.f13975d = str3;
        this.f13976e = str;
        this.f13977f = str2;
        HashMap map = new HashMap();
        this.f13978g = map;
        map.put(com.amazon.a.a.o.b.f14024B, str3);
        map.put(com.amazon.a.a.o.b.f14031I, str4);
        this.f13980i = true;
        this.f13981j = null;
        this.f13982k = null;
    }

    public h a(boolean z7) {
        this.f13983l = z7;
        return this;
    }

    @Override // com.amazon.a.a.n.a.a
    public String a_() {
        return this.f13976e;
    }

    @Override // com.amazon.a.a.n.a.a
    public Map<String, Object> b() {
        return this.f13978g;
    }

    public abstract boolean b(j jVar);

    @Override // com.amazon.a.a.n.a.a
    public String c() {
        return this.f13977f;
    }

    @Override // com.amazon.a.a.n.a.a
    public boolean d() {
        return true;
    }

    public boolean i() {
        return this.f13983l;
    }

    public com.amazon.a.a.j.a j() {
        return this.f13974c;
    }

    public String k() {
        return this.f13975d;
    }

    public void l() {
        com.amazon.a.a.a(this);
    }

    private void a(com.amazon.a.a.i.c cVar) {
        if (cVar == null) {
            return;
        }
        com.amazon.a.a.i.a aVar = new com.amazon.a.a.i.a(cVar);
        com.amazon.a.a.i.e eVarA = com.amazon.a.a.a();
        if (eVarA == null) {
            f13973b.b("Prompt manager is null. Cannot show prompt dropping request");
        } else {
            eVarA.a((com.amazon.a.a.i.b) aVar);
        }
    }

    @Override // com.amazon.a.a.n.a.a
    public void b(com.amazon.a.a.d.b bVar) {
        h hVar;
        if ("UNHANDLED_EXCEPTION".equals(bVar.a()) && com.amazon.a.a.o.b.ah.equals(this.f13977f) && (hVar = this.f13982k) != null) {
            hVar.a(this.f13983l);
            this.f13982k.l();
            return;
        }
        try {
            c(bVar);
        } catch (Exception e8) {
            f13973b.a("Error calling onResult: " + e8);
        }
        if (this.f13980i) {
            a(this.f13979h.a(bVar));
        }
        if (this.f13983l) {
            return;
        }
        this.f13974c.c();
    }

    public void c(com.amazon.a.a.d.b bVar) {
    }

    public void a(h hVar) {
        this.f13981j = hVar;
    }

    public void b(h hVar) {
        this.f13982k = hVar;
    }

    @Override // com.amazon.a.a.n.a.a
    public void a(com.amazon.d.a.h hVar) {
        String str;
        h hVar2;
        f13973b.a("onFailure: result = " + hVar);
        if (hVar != null && (str = (String) hVar.f().get(com.amazon.a.a.o.b.an)) != null && str.equalsIgnoreCase("1.0") && (hVar2 = this.f13982k) != null) {
            hVar2.a(this.f13983l);
            this.f13982k.l();
            return;
        }
        try {
            b(hVar);
        } catch (Exception e8) {
            f13973b.a("Error calling onResult: " + e8);
        }
        if (this.f13980i) {
            a(new com.amazon.a.a.i.c(hVar.b(), hVar.c(), hVar.d(), hVar.e()));
        }
        if (this.f13983l) {
            return;
        }
        this.f13974c.c();
    }

    public void b(com.amazon.d.a.h hVar) {
    }

    @Override // com.amazon.a.a.n.a.a
    public void a(j jVar) {
        boolean zB;
        h hVar;
        String str = (String) jVar.b().get(com.amazon.a.a.o.b.f14054f);
        f13973b.a("onSuccess: result = " + jVar + ", errorMessage: " + str);
        if (com.amazon.a.a.o.f.a(str)) {
            try {
                zB = b(jVar);
            } catch (Exception e8) {
                f13973b.a("Error calling onResult: " + e8);
                zB = false;
            }
            if (zB && (hVar = this.f13981j) != null) {
                hVar.l();
                return;
            } else {
                if (this.f13983l) {
                    return;
                }
                if (zB) {
                    this.f13974c.b();
                    return;
                }
            }
        } else if (this.f13983l) {
            return;
        }
        this.f13974c.c();
    }

    public void b(boolean z7) {
        this.f13980i = z7;
    }

    public void a(String str, Object obj) {
        this.f13978g.put(str, obj);
    }
}
