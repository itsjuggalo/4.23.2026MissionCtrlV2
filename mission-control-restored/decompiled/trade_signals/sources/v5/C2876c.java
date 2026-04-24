package v5;

import java.io.Serializable;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2582d;
import p5.AbstractC2592n;

/* JADX INFO: renamed from: v5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2876c extends AbstractC2582d implements InterfaceC2874a, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Enum[] f23898b;

    public C2876c(Enum[] entries) {
        AbstractC2304t.f(entries, "entries");
        this.f23898b = entries;
    }

    public int C(Enum element) {
        AbstractC2304t.f(element, "element");
        return indexOf(element);
    }

    @Override // p5.AbstractC2580b, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return f((Enum) obj);
        }
        return false;
    }

    @Override // p5.AbstractC2580b
    public int d() {
        return this.f23898b.length;
    }

    public boolean f(Enum element) {
        AbstractC2304t.f(element, "element");
        return ((Enum) AbstractC2592n.I(this.f23898b, element.ordinal())) == element;
    }

    @Override // p5.AbstractC2582d, java.util.List
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Enum get(int i8) {
        AbstractC2582d.f22376a.b(i8, this.f23898b.length);
        return this.f23898b[i8];
    }

    @Override // p5.AbstractC2582d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return n((Enum) obj);
        }
        return -1;
    }

    @Override // p5.AbstractC2582d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return C((Enum) obj);
        }
        return -1;
    }

    public int n(Enum element) {
        AbstractC2304t.f(element, "element");
        int iOrdinal = element.ordinal();
        if (((Enum) AbstractC2592n.I(this.f23898b, iOrdinal)) == element) {
            return iOrdinal;
        }
        return -1;
    }
}
