package c3;

import X2.AbstractC0757d;
import X2.AbstractC0765l;
import java.io.Serializable;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: c3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0879c extends AbstractC0757d implements InterfaceC0877a, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Enum[] f8322b;

    public C0879c(Enum[] entries) {
        r.f(entries, "entries");
        this.f8322b = entries;
    }

    @Override // X2.AbstractC0755b, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return l((Enum) obj);
        }
        return false;
    }

    @Override // X2.AbstractC0755b
    public int i() {
        return this.f8322b.length;
    }

    @Override // X2.AbstractC0757d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return n((Enum) obj);
        }
        return -1;
    }

    public boolean l(Enum element) {
        r.f(element, "element");
        return ((Enum) AbstractC0765l.z(this.f8322b, element.ordinal())) == element;
    }

    @Override // X2.AbstractC0757d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return o((Enum) obj);
        }
        return -1;
    }

    @Override // X2.AbstractC0757d, java.util.List
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public Enum get(int i4) {
        AbstractC0757d.f5605a.b(i4, this.f8322b.length);
        return this.f8322b[i4];
    }

    public int n(Enum element) {
        r.f(element, "element");
        int iOrdinal = element.ordinal();
        if (((Enum) AbstractC0765l.z(this.f8322b, iOrdinal)) == element) {
            return iOrdinal;
        }
        return -1;
    }

    public int o(Enum element) {
        r.f(element, "element");
        return indexOf(element);
    }
}
