package j9;

import bb.d0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f14258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f14259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v f14260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v f14261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s f14262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f14263g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        HAS_LOCAL_MUTATIONS,
        HAS_COMMITTED_MUTATIONS,
        SYNCED
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b {
        INVALID,
        FOUND_DOCUMENT,
        NO_DOCUMENT,
        UNKNOWN_DOCUMENT
    }

    public r(k kVar) {
        this.f14258b = kVar;
        this.f14261e = v.f14278b;
    }

    public static r p(k kVar, v vVar, s sVar) {
        return new r(kVar).l(vVar, sVar);
    }

    public static r q(k kVar) {
        b bVar = b.INVALID;
        v vVar = v.f14278b;
        return new r(kVar, bVar, vVar, vVar, new s(), a.SYNCED);
    }

    public static r r(k kVar, v vVar) {
        return new r(kVar).m(vVar);
    }

    public static r s(k kVar, v vVar) {
        return new r(kVar).n(vVar);
    }

    @Override // j9.h
    public r a() {
        return new r(this.f14258b, this.f14259c, this.f14260d, this.f14261e, this.f14262f.clone(), this.f14263g);
    }

    @Override // j9.h
    public boolean b() {
        return this.f14259c.equals(b.FOUND_DOCUMENT);
    }

    @Override // j9.h
    public boolean c() {
        return this.f14263g.equals(a.HAS_COMMITTED_MUTATIONS);
    }

    @Override // j9.h
    public boolean d() {
        return this.f14263g.equals(a.HAS_LOCAL_MUTATIONS);
    }

    @Override // j9.h
    public boolean e() {
        return d() || c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f14258b.equals(rVar.f14258b) && this.f14260d.equals(rVar.f14260d) && this.f14259c.equals(rVar.f14259c) && this.f14263g.equals(rVar.f14263g)) {
            return this.f14262f.equals(rVar.f14262f);
        }
        return false;
    }

    @Override // j9.h
    public v f() {
        return this.f14261e;
    }

    @Override // j9.h
    public s getData() {
        return this.f14262f;
    }

    @Override // j9.h
    public k getKey() {
        return this.f14258b;
    }

    @Override // j9.h
    public d0 h(q qVar) {
        return getData().i(qVar);
    }

    public int hashCode() {
        return this.f14258b.hashCode();
    }

    @Override // j9.h
    public boolean i() {
        return this.f14259c.equals(b.NO_DOCUMENT);
    }

    @Override // j9.h
    public boolean j() {
        return this.f14259c.equals(b.UNKNOWN_DOCUMENT);
    }

    @Override // j9.h
    public v k() {
        return this.f14260d;
    }

    public r l(v vVar, s sVar) {
        this.f14260d = vVar;
        this.f14259c = b.FOUND_DOCUMENT;
        this.f14262f = sVar;
        this.f14263g = a.SYNCED;
        return this;
    }

    public r m(v vVar) {
        this.f14260d = vVar;
        this.f14259c = b.NO_DOCUMENT;
        this.f14262f = new s();
        this.f14263g = a.SYNCED;
        return this;
    }

    public r n(v vVar) {
        this.f14260d = vVar;
        this.f14259c = b.UNKNOWN_DOCUMENT;
        this.f14262f = new s();
        this.f14263g = a.HAS_COMMITTED_MUTATIONS;
        return this;
    }

    public boolean o() {
        return !this.f14259c.equals(b.INVALID);
    }

    public r t() {
        this.f14263g = a.HAS_COMMITTED_MUTATIONS;
        return this;
    }

    public String toString() {
        return "Document{key=" + this.f14258b + ", version=" + this.f14260d + ", readTime=" + this.f14261e + ", type=" + this.f14259c + ", documentState=" + this.f14263g + ", value=" + this.f14262f + '}';
    }

    public r u() {
        this.f14263g = a.HAS_LOCAL_MUTATIONS;
        this.f14260d = v.f14278b;
        return this;
    }

    public r v(v vVar) {
        this.f14261e = vVar;
        return this;
    }

    public r(k kVar, b bVar, v vVar, v vVar2, s sVar, a aVar) {
        this.f14258b = kVar;
        this.f14260d = vVar;
        this.f14261e = vVar2;
        this.f14259c = bVar;
        this.f14263g = aVar;
        this.f14262f = sVar;
    }
}
