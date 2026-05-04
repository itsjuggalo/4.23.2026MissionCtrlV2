package j9;

import j9.p;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f14226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f14227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p.b f14228f;

    public a(int i10, String str, List list, p.b bVar) {
        this.f14225c = i10;
        if (str == null) {
            throw new NullPointerException("Null collectionGroup");
        }
        this.f14226d = str;
        if (list == null) {
            throw new NullPointerException("Null segments");
        }
        this.f14227e = list;
        if (bVar == null) {
            throw new NullPointerException("Null indexState");
        }
        this.f14228f = bVar;
    }

    @Override // j9.p
    public String d() {
        return this.f14226d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f14225c == pVar.f() && this.f14226d.equals(pVar.d()) && this.f14227e.equals(pVar.h()) && this.f14228f.equals(pVar.g())) {
                return true;
            }
        }
        return false;
    }

    @Override // j9.p
    public int f() {
        return this.f14225c;
    }

    @Override // j9.p
    public p.b g() {
        return this.f14228f;
    }

    @Override // j9.p
    public List h() {
        return this.f14227e;
    }

    public int hashCode() {
        return ((((((this.f14225c ^ 1000003) * 1000003) ^ this.f14226d.hashCode()) * 1000003) ^ this.f14227e.hashCode()) * 1000003) ^ this.f14228f.hashCode();
    }

    public String toString() {
        return "FieldIndex{indexId=" + this.f14225c + ", collectionGroup=" + this.f14226d + ", segments=" + this.f14227e + ", indexState=" + this.f14228f + "}";
    }
}
