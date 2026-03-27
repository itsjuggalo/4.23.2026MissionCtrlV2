package r6;

import F5.AbstractC0556n;
import java.util.List;
import kotlin.jvm.internal.AbstractC2148j;
import p6.e;
import p6.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class P implements p6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p6.e f22842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p6.e f22843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f22844d;

    public /* synthetic */ P(String str, p6.e eVar, p6.e eVar2, AbstractC2148j abstractC2148j) {
        this(str, eVar, eVar2);
    }

    @Override // p6.e
    public String a() {
        return this.f22841a;
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
        throw new IllegalArgumentException(name + " is not a valid map index");
    }

    @Override // p6.e
    public p6.i e() {
        return j.c.f22096a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof P)) {
            return false;
        }
        P p7 = (P) obj;
        return kotlin.jvm.internal.r.b(a(), p7.a()) && kotlin.jvm.internal.r.b(this.f22842b, p7.f22842b) && kotlin.jvm.internal.r.b(this.f22843c, p7.f22843c);
    }

    @Override // p6.e
    public int f() {
        return this.f22844d;
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
        return (((a().hashCode() * 31) + this.f22842b.hashCode()) * 31) + this.f22843c.hashCode();
    }

    @Override // p6.e
    public p6.e i(int i7) {
        if (i7 >= 0) {
            int i8 = i7 % 2;
            if (i8 == 0) {
                return this.f22842b;
            }
            if (i8 == 1) {
                return this.f22843c;
            }
            throw new IllegalStateException("Unreached");
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
        return a() + '(' + this.f22842b + ", " + this.f22843c + ')';
    }

    public P(String str, p6.e eVar, p6.e eVar2) {
        this.f22841a = str;
        this.f22842b = eVar;
        this.f22843c = eVar2;
        this.f22844d = 2;
    }
}
