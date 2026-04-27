package r6;

import F5.AbstractC0556n;
import java.util.List;
import kotlin.jvm.internal.AbstractC2148j;
import p6.e;
import p6.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class L implements p6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p6.e f22834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22835b;

    public /* synthetic */ L(p6.e eVar, AbstractC2148j abstractC2148j) {
        this(eVar);
    }

    @Override // p6.e
    public boolean c() {
        return e.a.c(this);
    }

    @Override // p6.e
    public int d(String name) {
        kotlin.jvm.internal.r.f(name, "name");
        Integer numI = Z5.s.i(name);
        if (numI != null) {
            return numI.intValue();
        }
        throw new IllegalArgumentException(name + " is not a valid list index");
    }

    @Override // p6.e
    public p6.i e() {
        return j.b.f22095a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof L)) {
            return false;
        }
        L l7 = (L) obj;
        return kotlin.jvm.internal.r.b(this.f22834a, l7.f22834a) && kotlin.jvm.internal.r.b(a(), l7.a());
    }

    @Override // p6.e
    public int f() {
        return this.f22835b;
    }

    @Override // p6.e
    public String g(int i7) {
        return String.valueOf(i7);
    }

    @Override // p6.e
    public List getAnnotations() {
        return e.a.a(this);
    }

    @Override // p6.e
    public List h(int i7) {
        if (i7 >= 0) {
            return AbstractC0556n.g();
        }
        throw new IllegalArgumentException(("Illegal index " + i7 + ", " + a() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (this.f22834a.hashCode() * 31) + a().hashCode();
    }

    @Override // p6.e
    public p6.e i(int i7) {
        if (i7 >= 0) {
            return this.f22834a;
        }
        throw new IllegalArgumentException(("Illegal index " + i7 + ", " + a() + " expects only non-negative indices").toString());
    }

    @Override // p6.e
    public boolean isInline() {
        return e.a.b(this);
    }

    @Override // p6.e
    public boolean j(int i7) {
        if (i7 >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i7 + ", " + a() + " expects only non-negative indices").toString());
    }

    public String toString() {
        return a() + '(' + this.f22834a + ')';
    }

    public L(p6.e eVar) {
        this.f22834a = eVar;
        this.f22835b = 1;
    }
}
