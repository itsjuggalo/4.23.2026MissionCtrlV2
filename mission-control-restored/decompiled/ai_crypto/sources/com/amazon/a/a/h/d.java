package com.amazon.a.a.h;

/* JADX INFO: loaded from: classes.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f9656a = new com.amazon.a.a.o.c("MetricsManagerImpl");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f9657b = new b();

    @Override // com.amazon.a.a.h.c
    public synchronized void a(a aVar) {
        try {
            if (com.amazon.a.a.o.c.f9994a) {
                f9656a.a("Recording Metric: " + aVar);
            }
            this.f9657b.a(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.amazon.a.a.h.c
    public synchronized b a() {
        if (this.f9657b.a()) {
            return this.f9657b;
        }
        b bVar = this.f9657b;
        this.f9657b = new b();
        return bVar;
    }
}
