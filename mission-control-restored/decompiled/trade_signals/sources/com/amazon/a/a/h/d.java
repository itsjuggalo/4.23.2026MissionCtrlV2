package com.amazon.a.a.h;

/* JADX INFO: loaded from: classes.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f13767a = new com.amazon.a.a.o.c("MetricsManagerImpl");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f13768b = new b();

    @Override // com.amazon.a.a.h.c
    public synchronized b a() {
        if (this.f13768b.a()) {
            return this.f13768b;
        }
        b bVar = this.f13768b;
        this.f13768b = new b();
        return bVar;
    }

    @Override // com.amazon.a.a.h.c
    public synchronized void a(a aVar) {
        try {
            if (com.amazon.a.a.o.c.f14105a) {
                f13767a.a("Recording Metric: " + aVar);
            }
            this.f13768b.a(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }
}
