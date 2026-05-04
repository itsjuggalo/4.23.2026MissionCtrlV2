package wg;

import java.util.concurrent.atomic.AtomicReferenceArray;
import sg.a0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends a0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f24119e;

    public k(long j10, k kVar, int i10) {
        super(j10, kVar, i10);
        this.f24119e = new AtomicReferenceArray(j.f24118f);
    }

    @Override // sg.a0
    public int r() {
        return j.f24118f;
    }

    @Override // sg.a0
    public void s(int i10, Throwable th, gd.i iVar) {
        v().set(i10, j.f24117e);
        t();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f20378c + ", hashCode=" + hashCode() + ']';
    }

    public final /* synthetic */ AtomicReferenceArray v() {
        return this.f24119e;
    }
}
