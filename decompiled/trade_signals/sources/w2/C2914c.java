package w2;

import java.io.Serializable;
import v2.AbstractC2844j;
import v2.AbstractC2848n;
import v2.InterfaceC2840f;

/* JADX INFO: renamed from: w2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2914c extends t implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2840f f24003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f24004b;

    public C2914c(InterfaceC2840f interfaceC2840f, t tVar) {
        this.f24003a = (InterfaceC2840f) AbstractC2848n.n(interfaceC2840f);
        this.f24004b = (t) AbstractC2848n.n(tVar);
    }

    @Override // w2.t, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f24004b.compare(this.f24003a.apply(obj), this.f24003a.apply(obj2));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2914c)) {
            return false;
        }
        C2914c c2914c = (C2914c) obj;
        return this.f24003a.equals(c2914c.f24003a) && this.f24004b.equals(c2914c.f24004b);
    }

    public int hashCode() {
        return AbstractC2844j.b(this.f24003a, this.f24004b);
    }

    public String toString() {
        return this.f24004b + ".onResultOf(" + this.f24003a + ")";
    }
}
