package vc;

import lc.f;
import wc.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements lc.a, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lc.a f23356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public kh.c f23357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f23358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f23359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f23360e;

    public a(lc.a aVar) {
        this.f23356a = aVar;
    }

    @Override // cc.i, kh.b
    public final void b(kh.c cVar) {
        if (g.m(this.f23357b, cVar)) {
            this.f23357b = cVar;
            if (cVar instanceof f) {
                this.f23358c = (f) cVar;
            }
            if (c()) {
                this.f23356a.b(this);
                a();
            }
        }
    }

    public boolean c() {
        return true;
    }

    @Override // kh.c
    public void cancel() {
        this.f23357b.cancel();
    }

    @Override // lc.i
    public void clear() {
        this.f23358c.clear();
    }

    public final void e(Throwable th) {
        gc.b.b(th);
        this.f23357b.cancel();
        onError(th);
    }

    public final int f(int i10) {
        f fVar = this.f23358c;
        if (fVar == null || (i10 & 4) != 0) {
            return 0;
        }
        int iH = fVar.h(i10);
        if (iH != 0) {
            this.f23360e = iH;
        }
        return iH;
    }

    @Override // lc.i
    public boolean isEmpty() {
        return this.f23358c.isEmpty();
    }

    @Override // lc.i
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // kh.b
    public void onComplete() {
        if (this.f23359d) {
            return;
        }
        this.f23359d = true;
        this.f23356a.onComplete();
    }

    @Override // kh.b
    public void onError(Throwable th) {
        if (this.f23359d) {
            yc.a.q(th);
        } else {
            this.f23359d = true;
            this.f23356a.onError(th);
        }
    }

    @Override // kh.c
    public void request(long j10) {
        this.f23357b.request(j10);
    }

    public void a() {
    }
}
