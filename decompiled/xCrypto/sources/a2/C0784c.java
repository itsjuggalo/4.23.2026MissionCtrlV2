package a2;

import java.io.Serializable;

/* JADX INFO: renamed from: a2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0784c extends t implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z1.e f6126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f6127b;

    public C0784c(Z1.e eVar, t tVar) {
        this.f6126a = (Z1.e) Z1.m.n(eVar);
        this.f6127b = (t) Z1.m.n(tVar);
    }

    @Override // a2.t, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f6127b.compare(this.f6126a.apply(obj), this.f6126a.apply(obj2));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0784c) {
            C0784c c0784c = (C0784c) obj;
            if (this.f6126a.equals(c0784c.f6126a) && this.f6127b.equals(c0784c.f6127b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Z1.i.b(this.f6126a, this.f6127b);
    }

    public String toString() {
        return this.f6127b + ".onResultOf(" + this.f6126a + ")";
    }
}
