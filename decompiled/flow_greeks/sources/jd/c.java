package jd;

import dd.d;
import dd.n;
import java.io.Serializable;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends d implements a, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Enum[] f14310b;

    public c(Enum[] entries) {
        t.f(entries, "entries");
        this.f14310b = entries;
    }

    @Override // dd.b
    public int c() {
        return this.f14310b.length;
    }

    @Override // dd.b, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return f((Enum) obj);
        }
        return false;
    }

    public boolean f(Enum element) {
        t.f(element, "element");
        return ((Enum) n.I(this.f14310b, element.ordinal())) == element;
    }

    @Override // dd.d, java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Enum get(int i10) {
        d.f7994a.b(i10, this.f14310b.length);
        return this.f14310b[i10];
    }

    @Override // dd.d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return p((Enum) obj);
        }
        return -1;
    }

    @Override // dd.d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return q((Enum) obj);
        }
        return -1;
    }

    public int p(Enum element) {
        t.f(element, "element");
        int iOrdinal = element.ordinal();
        if (((Enum) n.I(this.f14310b, iOrdinal)) == element) {
            return iOrdinal;
        }
        return -1;
    }

    public int q(Enum element) {
        t.f(element, "element");
        return p(element);
    }
}
