package com.amazon.a.b;

import android.app.Application;
import com.amazon.d.a.j;
import java.security.PublicKey;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.amazon.a.a.n.a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f8847b = new com.amazon.a.a.o.c("VerifyApplicationEntitlmentTask");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f8848c = new f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.h.c f8849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private Application f8850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.n.b f8851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c f8852g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.o.b.b f8853h;

    @Override // com.amazon.a.a.n.a.a
    public void a(j jVar) throws com.amazon.a.b.a.a {
        g gVar = new g(jVar.b());
        b bVarA = a(gVar, this.f8853h.a());
        if (bVarA == null) {
            return;
        }
        a(gVar, bVarA);
        a(bVarA);
        this.f8849d.a(new com.amazon.a.b.b.a());
        this.f8851f.a(com.amazon.a.a.n.b.d.BACKGROUND, new i());
    }

    @Override // com.amazon.a.a.n.a.a
    public String a_() {
        return "get_license";
    }

    @Override // com.amazon.a.a.n.a.a
    public Map<String, Object> b() {
        return null;
    }

    @Override // com.amazon.a.a.n.a.a
    public String c() {
        return "1.0";
    }

    @Override // com.amazon.a.a.n.a.a
    public boolean d() {
        return this.f8852g.a(com.amazon.a.a.m.c.f8581b) == null;
    }

    @Override // com.amazon.a.a.n.a.a
    public void b(com.amazon.a.a.d.b bVar) {
        com.amazon.a.a.i.c cVarA = this.f8848c.a(bVar);
        if (cVarA == null && com.amazon.a.a.o.c.f8810b) {
            f8847b.b("No mapping specified for exception: " + bVar, bVar);
        }
        this.f8852g.a(com.amazon.a.a.m.c.f8582c, cVarA);
        this.f8852g.a(com.amazon.a.a.m.c.f8583d, bVar.getClass().getName());
    }

    private b a(g gVar, PublicKey publicKey) {
        return new b(new com.amazon.a.a.o.b.f(gVar.c(), publicKey));
    }

    private void a(b bVar) {
        f8847b.a("License Verification succeeded!");
        this.f8852g.a(com.amazon.a.a.m.c.f8581b, new com.amazon.a.a.m.a(bVar, bVar.d()) { // from class: com.amazon.a.b.a.1
            @Override // com.amazon.a.a.e.a
            public void d() {
                this.f8444a.a(com.amazon.a.a.n.b.d.COMMAND, new a());
            }
        });
    }

    private void a(g gVar, b bVar) throws com.amazon.a.b.a.a {
        com.amazon.a.a.o.d.c cVar = new com.amazon.a.a.o.d.c();
        cVar.a(gVar.a(), bVar.b(), (com.amazon.a.a.o.d.b) h.CUSTOMER_ID);
        cVar.a(gVar.b(), bVar.c(), (com.amazon.a.a.o.d.b) h.DEVICE_ID);
        cVar.a(bVar.e(), this.f8850e.getPackageName(), (com.amazon.a.a.o.d.b) h.PACKAGE_NAME);
        cVar.a(bVar.d(), new Date(), (com.amazon.a.a.o.d.b) h.EXPIRATION);
        if (cVar.a()) {
            throw new com.amazon.a.b.a.a(cVar);
        }
    }

    @Override // com.amazon.a.a.n.a.a
    public void a(com.amazon.d.a.h hVar) {
        com.amazon.a.a.i.c cVar = new com.amazon.a.a.i.c(hVar.b(), hVar.c(), hVar.d(), hVar.e());
        f8847b.a("onFailure: " + cVar);
        this.f8852g.a(com.amazon.a.a.m.c.f8582c, cVar);
    }
}
