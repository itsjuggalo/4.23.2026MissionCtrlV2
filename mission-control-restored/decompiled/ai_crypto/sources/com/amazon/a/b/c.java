package com.amazon.a.b;

/* JADX INFO: loaded from: classes.dex */
public class c extends com.amazon.a.a.n.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f10049a = new com.amazon.a.a.o.c("LicenseKillTask");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c f10050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.i.e f10051c;

    private boolean b() {
        return this.f10050b.b(com.amazon.a.a.m.c.f9766b);
    }

    private com.amazon.a.a.i.c c() {
        com.amazon.a.a.i.c cVar = (com.amazon.a.a.i.c) this.f10050b.a(com.amazon.a.a.m.c.f9767c);
        if (cVar == null) {
            return e.f10057e;
        }
        if (com.amazon.a.a.o.c.f9994a) {
            f10049a.a("Fetched failure content from store: " + cVar);
        }
        this.f10050b.c(com.amazon.a.a.m.c.f9767c);
        return cVar;
    }

    @Override // com.amazon.a.a.n.a
    public void a() {
        if (com.amazon.a.a.o.c.f9994a) {
            f10049a.a("License Kill Task Executing!!!");
        }
        if (b()) {
            f10049a.c("license verification succeeded");
            return;
        }
        if (com.amazon.a.a.o.c.f9994a) {
            f10049a.a("License Kill Task determined app is not licensed, killing app");
        }
        if (m()) {
            n();
        }
        this.f10051c.a((com.amazon.a.a.i.b) new com.amazon.a.a.i.g(c()));
    }
}
