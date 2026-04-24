package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class C implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f5635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public E f5636b;

    public C(E e) {
        this.f5635a = e;
        if (e.l()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f5636b = e.o();
    }

    public static void e(Object obj, Object obj2) {
        C0479o0 c0479o0 = C0479o0.f5773c;
        c0479o0.getClass();
        c0479o0.a(obj.getClass()).a(obj, obj2);
    }

    public final E b() {
        E eC = c();
        eC.getClass();
        if (E.k(eC, true)) {
            return eC;
        }
        throw new C0();
    }

    public final E c() {
        if (!this.f5636b.l()) {
            return this.f5636b;
        }
        E e = this.f5636b;
        e.getClass();
        C0479o0 c0479o0 = C0479o0.f5773c;
        c0479o0.getClass();
        c0479o0.a(e.getClass()).b(e);
        e.m();
        return this.f5636b;
    }

    public final Object clone() {
        C c6 = (C) this.f5635a.h(5);
        c6.f5636b = c();
        return c6;
    }

    public final void d() {
        if (this.f5636b.l()) {
            return;
        }
        E eO = this.f5635a.o();
        e(eO, this.f5636b);
        this.f5636b = eO;
    }
}
