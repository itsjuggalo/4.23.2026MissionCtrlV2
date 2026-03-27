package K5;

import F5.AbstractC0545c;
import F5.AbstractC0552j;
import java.io.Serializable;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends AbstractC0545c implements a, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Enum[] f3644b;

    public c(Enum[] entries) {
        r.f(entries, "entries");
        this.f3644b = entries;
    }

    @Override // F5.AbstractC0543a
    public int a() {
        return this.f3644b.length;
    }

    public boolean c(Enum element) {
        r.f(element, "element");
        return ((Enum) AbstractC0552j.y(this.f3644b, element.ordinal())) == element;
    }

    @Override // F5.AbstractC0543a, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return c((Enum) obj);
        }
        return false;
    }

    @Override // F5.AbstractC0545c, java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Enum get(int i7) {
        AbstractC0545c.f2367a.b(i7, this.f3644b.length);
        return this.f3644b[i7];
    }

    public int h(Enum element) {
        r.f(element, "element");
        int iOrdinal = element.ordinal();
        if (((Enum) AbstractC0552j.y(this.f3644b, iOrdinal)) == element) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // F5.AbstractC0545c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return h((Enum) obj);
        }
        return -1;
    }

    public int j(Enum element) {
        r.f(element, "element");
        return indexOf(element);
    }

    @Override // F5.AbstractC0545c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return j((Enum) obj);
        }
        return -1;
    }
}
