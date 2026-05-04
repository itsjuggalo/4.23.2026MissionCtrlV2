package vc;

import cc.i;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import wc.g;
import xc.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class d extends AtomicInteger implements i, kh.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kh.b f23370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xc.c f23371b = new xc.c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f23372c = new AtomicLong();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f23373d = new AtomicReference();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f23374e = new AtomicBoolean();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f23375f;

    public d(kh.b bVar) {
        this.f23370a = bVar;
    }

    @Override // cc.i, kh.b
    public void b(kh.c cVar) {
        if (this.f23374e.compareAndSet(false, true)) {
            this.f23370a.b(this);
            g.c(this.f23373d, this.f23372c, cVar);
        } else {
            cVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // kh.c
    public void cancel() {
        if (this.f23375f) {
            return;
        }
        g.a(this.f23373d);
    }

    @Override // kh.b
    public void onComplete() {
        this.f23375f = true;
        h.a(this.f23370a, this, this.f23371b);
    }

    @Override // kh.b
    public void onError(Throwable th) {
        this.f23375f = true;
        h.b(this.f23370a, th, this, this.f23371b);
    }

    @Override // kh.b
    public void onNext(Object obj) {
        h.c(this.f23370a, obj, this, this.f23371b);
    }

    @Override // kh.c
    public void request(long j10) {
        if (j10 > 0) {
            g.b(this.f23373d, this.f23372c, j10);
            return;
        }
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j10));
    }
}
