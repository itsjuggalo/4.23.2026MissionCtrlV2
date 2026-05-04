package vc;

import cc.i;
import java.util.concurrent.atomic.AtomicReference;
import wc.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends AtomicReference implements i, kh.c, fc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ic.d f23366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.d f23367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ic.a f23368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ic.d f23369d;

    public c(ic.d dVar, ic.d dVar2, ic.a aVar, ic.d dVar3) {
        this.f23366a = dVar;
        this.f23367b = dVar2;
        this.f23368c = aVar;
        this.f23369d = dVar3;
    }

    @Override // cc.i, kh.b
    public void b(kh.c cVar) {
        if (g.k(this, cVar)) {
            try {
                this.f23369d.accept(this);
            } catch (Throwable th) {
                gc.b.b(th);
                cVar.cancel();
                onError(th);
            }
        }
    }

    @Override // fc.b
    public boolean c() {
        return get() == g.CANCELLED;
    }

    @Override // kh.c
    public void cancel() {
        g.a(this);
    }

    @Override // fc.b
    public void dispose() {
        cancel();
    }

    @Override // kh.b
    public void onComplete() {
        Object obj = get();
        g gVar = g.CANCELLED;
        if (obj != gVar) {
            lazySet(gVar);
            try {
                this.f23368c.run();
            } catch (Throwable th) {
                gc.b.b(th);
                yc.a.q(th);
            }
        }
    }

    @Override // kh.b
    public void onError(Throwable th) {
        Object obj = get();
        g gVar = g.CANCELLED;
        if (obj == gVar) {
            yc.a.q(th);
            return;
        }
        lazySet(gVar);
        try {
            this.f23367b.accept(th);
        } catch (Throwable th2) {
            gc.b.b(th2);
            yc.a.q(new gc.a(th, th2));
        }
    }

    @Override // kh.b
    public void onNext(Object obj) {
        if (c()) {
            return;
        }
        try {
            this.f23366a.accept(obj);
        } catch (Throwable th) {
            gc.b.b(th);
            ((kh.c) get()).cancel();
            onError(th);
        }
    }

    @Override // kh.c
    public void request(long j10) {
        ((kh.c) get()).request(j10);
    }
}
