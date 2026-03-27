package G3;

import G3.p;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a extends p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f2426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p.b f2427f;

    public a(int i7, String str, List list, p.b bVar) {
        this.f2424c = i7;
        if (str == null) {
            throw new NullPointerException("Null collectionGroup");
        }
        this.f2425d = str;
        if (list == null) {
            throw new NullPointerException("Null segments");
        }
        this.f2426e = list;
        if (bVar == null) {
            throw new NullPointerException("Null indexState");
        }
        this.f2427f = bVar;
    }

    @Override // G3.p
    public String d() {
        return this.f2425d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f2424c == pVar.f() && this.f2425d.equals(pVar.d()) && this.f2426e.equals(pVar.h()) && this.f2427f.equals(pVar.g());
    }

    @Override // G3.p
    public int f() {
        return this.f2424c;
    }

    @Override // G3.p
    public p.b g() {
        return this.f2427f;
    }

    @Override // G3.p
    public List h() {
        return this.f2426e;
    }

    public int hashCode() {
        return ((((((this.f2424c ^ 1000003) * 1000003) ^ this.f2425d.hashCode()) * 1000003) ^ this.f2426e.hashCode()) * 1000003) ^ this.f2427f.hashCode();
    }

    public String toString() {
        return "FieldIndex{indexId=" + this.f2424c + ", collectionGroup=" + this.f2425d + ", segments=" + this.f2426e + ", indexState=" + this.f2427f + "}";
    }
}
