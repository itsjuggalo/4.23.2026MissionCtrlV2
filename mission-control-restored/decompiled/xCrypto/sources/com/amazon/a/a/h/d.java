package com.amazon.a.a.h;

/* JADX INFO: loaded from: classes.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f8471a = new com.amazon.a.a.o.c("MetricsManagerImpl");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f8472b = new b();

    @Override // com.amazon.a.a.h.c
    public synchronized void a(a aVar) {
        try {
            if (com.amazon.a.a.o.c.f8809a) {
                f8471a.a("Recording Metric: " + aVar);
            }
            this.f8472b.a(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.amazon.a.a.h.c
    public synchronized b a() {
        if (this.f8472b.a()) {
            return this.f8472b;
        }
        b bVar = this.f8472b;
        this.f8472b = new b();
        return bVar;
    }
}
