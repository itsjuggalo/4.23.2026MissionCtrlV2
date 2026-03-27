package h7;

import d7.A;
import java.util.concurrent.atomic.AtomicReferenceArray;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends A {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f18744e;

    public k(long j8, k kVar, int i8) {
        super(j8, kVar, i8);
        this.f18744e = new AtomicReferenceArray(j.f18743f);
    }

    @Override // d7.A
    public int r() {
        return j.f18743f;
    }

    @Override // d7.A
    public void s(int i8, Throwable th, InterfaceC2711i interfaceC2711i) {
        v().set(i8, j.f18742e);
        t();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f17024c + ", hashCode=" + hashCode() + ']';
    }

    public final /* synthetic */ AtomicReferenceArray v() {
        return this.f18744e;
    }
}
