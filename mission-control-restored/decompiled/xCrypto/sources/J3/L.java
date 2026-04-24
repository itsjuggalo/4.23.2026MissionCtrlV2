package J3;

import H3.e;
import H3.j;
import X2.AbstractC0769p;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class L implements H3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H3.e f877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f878b;

    public /* synthetic */ L(H3.e eVar, AbstractC1585j abstractC1585j) {
        this(eVar);
    }

    @Override // H3.e
    public boolean c() {
        return e.a.c(this);
    }

    @Override // H3.e
    public int d(String name) {
        kotlin.jvm.internal.r.f(name, "name");
        Integer numM = r3.w.m(name);
        if (numM != null) {
            return numM.intValue();
        }
        throw new IllegalArgumentException(name + " is not a valid list index");
    }

    @Override // H3.e
    public H3.i e() {
        return j.b.f767a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof L)) {
            return false;
        }
        L l4 = (L) obj;
        return kotlin.jvm.internal.r.b(this.f877a, l4.f877a) && kotlin.jvm.internal.r.b(a(), l4.a());
    }

    @Override // H3.e
    public int f() {
        return this.f878b;
    }

    @Override // H3.e
    public String g(int i4) {
        return String.valueOf(i4);
    }

    @Override // H3.e
    public List getAnnotations() {
        return e.a.a(this);
    }

    @Override // H3.e
    public List h(int i4) {
        if (i4 >= 0) {
            return AbstractC0769p.g();
        }
        throw new IllegalArgumentException(("Illegal index " + i4 + ", " + a() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (this.f877a.hashCode() * 31) + a().hashCode();
    }

    @Override // H3.e
    public H3.e i(int i4) {
        if (i4 >= 0) {
            return this.f877a;
        }
        throw new IllegalArgumentException(("Illegal index " + i4 + ", " + a() + " expects only non-negative indices").toString());
    }

    @Override // H3.e
    public boolean isInline() {
        return e.a.b(this);
    }

    @Override // H3.e
    public boolean j(int i4) {
        if (i4 >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i4 + ", " + a() + " expects only non-negative indices").toString());
    }

    public String toString() {
        return a() + '(' + this.f877a + ')';
    }

    public L(H3.e eVar) {
        this.f877a = eVar;
        this.f878b = 1;
    }
}
