package com.amazon.a.b;

/* JADX INFO: loaded from: classes.dex */
public class c extends com.amazon.a.a.n.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f8864a = new com.amazon.a.a.o.c("LicenseKillTask");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c f8865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.i.e f8866c;

    private boolean b() {
        return this.f8865b.b(com.amazon.a.a.m.c.f8581b);
    }

    private com.amazon.a.a.i.c c() {
        com.amazon.a.a.i.c cVar = (com.amazon.a.a.i.c) this.f8865b.a(com.amazon.a.a.m.c.f8582c);
        if (cVar == null) {
            return e.f8872e;
        }
        if (com.amazon.a.a.o.c.f8809a) {
            f8864a.a("Fetched failure content from store: " + cVar);
        }
        this.f8865b.c(com.amazon.a.a.m.c.f8582c);
        return cVar;
    }

    @Override // com.amazon.a.a.n.a
    public void a() {
        if (com.amazon.a.a.o.c.f8809a) {
            f8864a.a("License Kill Task Executing!!!");
        }
        if (b()) {
            f8864a.c("license verification succeeded");
            return;
        }
        if (com.amazon.a.a.o.c.f8809a) {
            f8864a.a("License Kill Task determined app is not licensed, killing app");
        }
        if (m()) {
            n();
        }
        this.f8866c.a((com.amazon.a.a.i.b) new com.amazon.a.a.i.g(c()));
    }
}
