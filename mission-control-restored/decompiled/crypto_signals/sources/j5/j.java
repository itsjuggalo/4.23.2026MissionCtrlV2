package j5;

import f5.r;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes.dex */
public final class j extends r {
    public final /* synthetic */ AtomicReferenceArray e;

    public j(long j4, j jVar, int i) {
        super(j4, jVar, i);
        this.e = new AtomicReferenceArray(i.f7778f);
    }

    @Override // f5.r
    public final int g() {
        return i.f7778f;
    }

    @Override // f5.r
    public final void h(int i, I4.i iVar) {
        this.e.set(i, i.e);
        i();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f6531c + ", hashCode=" + hashCode() + ']';
    }
}
