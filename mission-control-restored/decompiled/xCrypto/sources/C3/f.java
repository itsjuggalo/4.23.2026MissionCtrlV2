package C3;

import Z2.i;
import java.util.concurrent.atomic.AtomicReferenceArray;
import y3.C;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends C {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReferenceArray f286e;

    public f(long j4, f fVar, int i4) {
        super(j4, fVar, i4);
        this.f286e = new AtomicReferenceArray(e.f285f);
    }

    @Override // y3.C
    public int n() {
        return e.f285f;
    }

    @Override // y3.C
    public void o(int i4, Throwable th, i iVar) {
        r().set(i4, e.f284e);
        p();
    }

    public final AtomicReferenceArray r() {
        return this.f286e;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f15955c + ", hashCode=" + hashCode() + ']';
    }
}
