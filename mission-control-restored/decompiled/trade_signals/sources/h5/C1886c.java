package h5;

import P4.i;
import i5.EnumC1933g;
import java.util.concurrent.atomic.AtomicReference;
import k5.AbstractC2283a;

/* JADX INFO: renamed from: h5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1886c extends AtomicReference implements i, x7.c, S4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.d f18700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.d f18701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V4.a f18702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final V4.d f18703d;

    public C1886c(V4.d dVar, V4.d dVar2, V4.a aVar, V4.d dVar3) {
        this.f18700a = dVar;
        this.f18701b = dVar2;
        this.f18702c = aVar;
        this.f18703d = dVar3;
    }

    @Override // x7.b
    public void a() {
        Object obj = get();
        EnumC1933g enumC1933g = EnumC1933g.CANCELLED;
        if (obj != enumC1933g) {
            lazySet(enumC1933g);
            try {
                this.f18702c.run();
            } catch (Throwable th) {
                T4.b.b(th);
                AbstractC2283a.q(th);
            }
        }
    }

    @Override // x7.b
    public void c(Object obj) {
        if (g()) {
            return;
        }
        try {
            this.f18700a.accept(obj);
        } catch (Throwable th) {
            T4.b.b(th);
            ((x7.c) get()).cancel();
            onError(th);
        }
    }

    @Override // x7.c
    public void cancel() {
        EnumC1933g.a(this);
    }

    @Override // P4.i, x7.b
    public void d(x7.c cVar) {
        if (EnumC1933g.m(this, cVar)) {
            try {
                this.f18703d.accept(this);
            } catch (Throwable th) {
                T4.b.b(th);
                cVar.cancel();
                onError(th);
            }
        }
    }

    @Override // S4.b
    public void dispose() {
        cancel();
    }

    @Override // S4.b
    public boolean g() {
        return get() == EnumC1933g.CANCELLED;
    }

    @Override // x7.c
    public void i(long j8) {
        ((x7.c) get()).i(j8);
    }

    @Override // x7.b
    public void onError(Throwable th) {
        Object obj = get();
        EnumC1933g enumC1933g = EnumC1933g.CANCELLED;
        if (obj == enumC1933g) {
            AbstractC2283a.q(th);
            return;
        }
        lazySet(enumC1933g);
        try {
            this.f18701b.accept(th);
        } catch (Throwable th2) {
            T4.b.b(th2);
            AbstractC2283a.q(new T4.a(th, th2));
        }
    }
}
