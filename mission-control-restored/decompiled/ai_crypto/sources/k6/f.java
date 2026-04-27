package k6;

import H5.g;
import g6.C;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends C {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReferenceArray f18244e;

    public f(long j7, f fVar, int i7) {
        super(j7, fVar, i7);
        this.f18244e = new AtomicReferenceArray(e.f18243f);
    }

    @Override // g6.C
    public int n() {
        return e.f18243f;
    }

    @Override // g6.C
    public void o(int i7, Throwable th, g gVar) {
        r().set(i7, e.f18242e);
        p();
    }

    public final AtomicReferenceArray r() {
        return this.f18244e;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f14269c + ", hashCode=" + hashCode() + ']';
    }
}
