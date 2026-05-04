package j9;

import j9.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends p.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f14234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p.c.a f14235b;

    public d(q qVar, p.c.a aVar) {
        if (qVar == null) {
            throw new NullPointerException("Null fieldPath");
        }
        this.f14234a = qVar;
        if (aVar == null) {
            throw new NullPointerException("Null kind");
        }
        this.f14235b = aVar;
    }

    @Override // j9.p.c
    public q c() {
        return this.f14234a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p.c) {
            p.c cVar = (p.c) obj;
            if (this.f14234a.equals(cVar.c()) && this.f14235b.equals(cVar.h())) {
                return true;
            }
        }
        return false;
    }

    @Override // j9.p.c
    public p.c.a h() {
        return this.f14235b;
    }

    public int hashCode() {
        return ((this.f14234a.hashCode() ^ 1000003) * 1000003) ^ this.f14235b.hashCode();
    }

    public String toString() {
        return "Segment{fieldPath=" + this.f14234a + ", kind=" + this.f14235b + "}";
    }
}
