package c5;

import java.util.concurrent.atomic.AtomicReference;
import k5.AbstractC2283a;

/* JADX INFO: renamed from: c5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1255b extends AtomicReference implements P4.l, S4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.d f13475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.d f13476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V4.a f13477c;

    public C1255b(V4.d dVar, V4.d dVar2, V4.a aVar) {
        this.f13475a = dVar;
        this.f13476b = dVar2;
        this.f13477c = aVar;
    }

    @Override // P4.l
    public void a() {
        lazySet(W4.b.DISPOSED);
        try {
            this.f13477c.run();
        } catch (Throwable th) {
            T4.b.b(th);
            AbstractC2283a.q(th);
        }
    }

    @Override // P4.l
    public void b(S4.b bVar) {
        W4.b.m(this, bVar);
    }

    @Override // S4.b
    public void dispose() {
        W4.b.a(this);
    }

    @Override // S4.b
    public boolean g() {
        return W4.b.b((S4.b) get());
    }

    @Override // P4.l
    public void onError(Throwable th) {
        lazySet(W4.b.DISPOSED);
        try {
            this.f13476b.accept(th);
        } catch (Throwable th2) {
            T4.b.b(th2);
            AbstractC2283a.q(new T4.a(th, th2));
        }
    }

    @Override // P4.l
    public void onSuccess(Object obj) {
        lazySet(W4.b.DISPOSED);
        try {
            this.f13475a.accept(obj);
        } catch (Throwable th) {
            T4.b.b(th);
            AbstractC2283a.q(th);
        }
    }
}
