package G3;

import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public final class r implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f2457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f2458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v f2459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v f2460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s f2461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f2462g;

    public enum a {
        HAS_LOCAL_MUTATIONS,
        HAS_COMMITTED_MUTATIONS,
        SYNCED
    }

    public enum b {
        INVALID,
        FOUND_DOCUMENT,
        NO_DOCUMENT,
        UNKNOWN_DOCUMENT
    }

    public r(k kVar) {
        this.f2457b = kVar;
        this.f2460e = v.f2475b;
    }

    public static r q(k kVar, v vVar, s sVar) {
        return new r(kVar).m(vVar, sVar);
    }

    public static r r(k kVar) {
        b bVar = b.INVALID;
        v vVar = v.f2475b;
        return new r(kVar, bVar, vVar, vVar, new s(), a.SYNCED);
    }

    public static r s(k kVar, v vVar) {
        return new r(kVar).n(vVar);
    }

    public static r t(k kVar, v vVar) {
        return new r(kVar).o(vVar);
    }

    @Override // G3.h
    public r a() {
        return new r(this.f2457b, this.f2458c, this.f2459d, this.f2460e, this.f2461f.clone(), this.f2462g);
    }

    @Override // G3.h
    public boolean b() {
        return this.f2458c.equals(b.FOUND_DOCUMENT);
    }

    @Override // G3.h
    public boolean c() {
        return this.f2462g.equals(a.HAS_COMMITTED_MUTATIONS);
    }

    @Override // G3.h
    public boolean e() {
        return this.f2462g.equals(a.HAS_LOCAL_MUTATIONS);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f2457b.equals(rVar.f2457b) && this.f2459d.equals(rVar.f2459d) && this.f2458c.equals(rVar.f2458c) && this.f2462g.equals(rVar.f2462g)) {
            return this.f2461f.equals(rVar.f2461f);
        }
        return false;
    }

    @Override // G3.h
    public boolean f() {
        return e() || c();
    }

    @Override // G3.h
    public v g() {
        return this.f2460e;
    }

    @Override // G3.h
    public s getData() {
        return this.f2461f;
    }

    @Override // G3.h
    public k getKey() {
        return this.f2457b;
    }

    public int hashCode() {
        return this.f2457b.hashCode();
    }

    @Override // G3.h
    public C2105D i(q qVar) {
        return getData().i(qVar);
    }

    @Override // G3.h
    public boolean j() {
        return this.f2458c.equals(b.NO_DOCUMENT);
    }

    @Override // G3.h
    public boolean k() {
        return this.f2458c.equals(b.UNKNOWN_DOCUMENT);
    }

    @Override // G3.h
    public v l() {
        return this.f2459d;
    }

    public r m(v vVar, s sVar) {
        this.f2459d = vVar;
        this.f2458c = b.FOUND_DOCUMENT;
        this.f2461f = sVar;
        this.f2462g = a.SYNCED;
        return this;
    }

    public r n(v vVar) {
        this.f2459d = vVar;
        this.f2458c = b.NO_DOCUMENT;
        this.f2461f = new s();
        this.f2462g = a.SYNCED;
        return this;
    }

    public r o(v vVar) {
        this.f2459d = vVar;
        this.f2458c = b.UNKNOWN_DOCUMENT;
        this.f2461f = new s();
        this.f2462g = a.HAS_COMMITTED_MUTATIONS;
        return this;
    }

    public boolean p() {
        return !this.f2458c.equals(b.INVALID);
    }

    public String toString() {
        return "Document{key=" + this.f2457b + ", version=" + this.f2459d + ", readTime=" + this.f2460e + ", type=" + this.f2458c + ", documentState=" + this.f2462g + ", value=" + this.f2461f + '}';
    }

    public r u() {
        this.f2462g = a.HAS_COMMITTED_MUTATIONS;
        return this;
    }

    public r v() {
        this.f2462g = a.HAS_LOCAL_MUTATIONS;
        this.f2459d = v.f2475b;
        return this;
    }

    public r w(v vVar) {
        this.f2460e = vVar;
        return this;
    }

    public r(k kVar, b bVar, v vVar, v vVar2, s sVar, a aVar) {
        this.f2457b = kVar;
        this.f2459d = vVar;
        this.f2460e = vVar2;
        this.f2458c = bVar;
        this.f2462g = aVar;
        this.f2461f = sVar;
    }
}
