package com.amazon.a.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c extends com.amazon.a.a.n.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f4658a = new com.amazon.a.a.o.c("LicenseKillTask");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c f4659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.i.e f4660c;

    private boolean b() {
        return this.f4659b.b(com.amazon.a.a.m.c.f4393b);
    }

    private com.amazon.a.a.i.c c() {
        com.amazon.a.a.i.c cVar = (com.amazon.a.a.i.c) this.f4659b.a(com.amazon.a.a.m.c.f4394c);
        if (cVar == null) {
            return e.f4666e;
        }
        if (com.amazon.a.a.o.c.f4603a) {
            f4658a.a("Fetched failure content from store: " + cVar);
        }
        this.f4659b.c(com.amazon.a.a.m.c.f4394c);
        return cVar;
    }

    @Override // com.amazon.a.a.n.a
    public void a() {
        if (com.amazon.a.a.o.c.f4603a) {
            f4658a.a("License Kill Task Executing!!!");
        }
        if (b()) {
            f4658a.c("license verification succeeded");
            return;
        }
        if (com.amazon.a.a.o.c.f4603a) {
            f4658a.a("License Kill Task determined app is not licensed, killing app");
        }
        if (m()) {
            n();
        }
        this.f4660c.a((com.amazon.a.a.i.b) new com.amazon.a.a.i.g(c()));
    }
}
