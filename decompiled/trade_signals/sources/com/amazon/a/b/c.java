package com.amazon.a.b;

/* JADX INFO: loaded from: classes.dex */
public class c extends com.amazon.a.a.n.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f14160a = new com.amazon.a.a.o.c("LicenseKillTask");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c f14161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.i.e f14162c;

    private boolean b() {
        return this.f14161b.b(com.amazon.a.a.m.c.f13877b);
    }

    private com.amazon.a.a.i.c c() {
        com.amazon.a.a.i.c cVar = (com.amazon.a.a.i.c) this.f14161b.a(com.amazon.a.a.m.c.f13878c);
        if (cVar == null) {
            return e.f14168e;
        }
        if (com.amazon.a.a.o.c.f14105a) {
            f14160a.a("Fetched failure content from store: " + cVar);
        }
        this.f14161b.c(com.amazon.a.a.m.c.f13878c);
        return cVar;
    }

    @Override // com.amazon.a.a.n.a
    public void a() {
        if (com.amazon.a.a.o.c.f14105a) {
            f14160a.a("License Kill Task Executing!!!");
        }
        if (b()) {
            f14160a.c("license verification succeeded");
            return;
        }
        if (com.amazon.a.a.o.c.f14105a) {
            f14160a.a("License Kill Task determined app is not licensed, killing app");
        }
        if (m()) {
            n();
        }
        this.f14162c.a((com.amazon.a.a.i.b) new com.amazon.a.a.i.g(c()));
    }
}
