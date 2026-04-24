package J3;

import H3.e;
import H3.j;
import X2.AbstractC0769p;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class P implements H3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H3.e f885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final H3.e f886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f887d;

    public /* synthetic */ P(String str, H3.e eVar, H3.e eVar2, AbstractC1585j abstractC1585j) {
        this(str, eVar, eVar2);
    }

    @Override // H3.e
    public String a() {
        return this.f884a;
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
        throw new IllegalArgumentException(name + " is not a valid map index");
    }

    @Override // H3.e
    public H3.i e() {
        return j.c.f768a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof P)) {
            return false;
        }
        P p4 = (P) obj;
        return kotlin.jvm.internal.r.b(a(), p4.a()) && kotlin.jvm.internal.r.b(this.f885b, p4.f885b) && kotlin.jvm.internal.r.b(this.f886c, p4.f886c);
    }

    @Override // H3.e
    public int f() {
        return this.f887d;
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
        return (((a().hashCode() * 31) + this.f885b.hashCode()) * 31) + this.f886c.hashCode();
    }

    @Override // H3.e
    public H3.e i(int i4) {
        if (i4 >= 0) {
            int i5 = i4 % 2;
            if (i5 == 0) {
                return this.f885b;
            }
            if (i5 == 1) {
                return this.f886c;
            }
            throw new IllegalStateException("Unreached");
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
        return a() + '(' + this.f885b + ", " + this.f886c + ')';
    }

    public P(String str, H3.e eVar, H3.e eVar2) {
        this.f884a = str;
        this.f885b = eVar;
        this.f886c = eVar2;
        this.f887d = 2;
    }
}
