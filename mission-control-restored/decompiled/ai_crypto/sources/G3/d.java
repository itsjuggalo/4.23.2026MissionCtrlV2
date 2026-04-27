package G3;

import G3.p;

/* JADX INFO: loaded from: classes.dex */
public final class d extends p.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f2433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p.c.a f2434b;

    public d(q qVar, p.c.a aVar) {
        if (qVar == null) {
            throw new NullPointerException("Null fieldPath");
        }
        this.f2433a = qVar;
        if (aVar == null) {
            throw new NullPointerException("Null kind");
        }
        this.f2434b = aVar;
    }

    @Override // G3.p.c
    public q c() {
        return this.f2433a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p.c)) {
            return false;
        }
        p.c cVar = (p.c) obj;
        return this.f2433a.equals(cVar.c()) && this.f2434b.equals(cVar.h());
    }

    @Override // G3.p.c
    public p.c.a h() {
        return this.f2434b;
    }

    public int hashCode() {
        return ((this.f2433a.hashCode() ^ 1000003) * 1000003) ^ this.f2434b.hashCode();
    }

    public String toString() {
        return "Segment{fieldPath=" + this.f2433a + ", kind=" + this.f2434b + "}";
    }
}
