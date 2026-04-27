package o7;

import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import m7.e;
import m7.m;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class S implements m7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m7.e f22141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m7.e f22142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f22143d;

    public S(String str, m7.e eVar, m7.e eVar2) {
        this.f22140a = str;
        this.f22141b = eVar;
        this.f22142c = eVar2;
        this.f22143d = 2;
    }

    @Override // m7.e
    public String a() {
        return this.f22140a;
    }

    @Override // m7.e
    public boolean c() {
        return e.a.c(this);
    }

    @Override // m7.e
    public int d(String name) {
        AbstractC2304t.f(name, "name");
        Integer numN = V6.z.n(name);
        if (numN != null) {
            return numN.intValue();
        }
        throw new IllegalArgumentException(name + " is not a valid map index");
    }

    @Override // m7.e
    public int e() {
        return this.f22143d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof S)) {
            return false;
        }
        S s8 = (S) obj;
        return AbstractC2304t.b(a(), s8.a()) && AbstractC2304t.b(this.f22141b, s8.f22141b) && AbstractC2304t.b(this.f22142c, s8.f22142c);
    }

    @Override // m7.e
    public String f(int i8) {
        return String.valueOf(i8);
    }

    @Override // m7.e
    public List g(int i8) {
        if (i8 >= 0) {
            return AbstractC2595q.i();
        }
        throw new IllegalArgumentException(("Illegal index " + i8 + ", " + a() + " expects only non-negative indices").toString());
    }

    @Override // m7.e
    public List getAnnotations() {
        return e.a.a(this);
    }

    @Override // m7.e
    public m7.e h(int i8) {
        if (i8 >= 0) {
            int i9 = i8 % 2;
            if (i9 == 0) {
                return this.f22141b;
            }
            if (i9 == 1) {
                return this.f22142c;
            }
            throw new IllegalStateException("Unreached".toString());
        }
        throw new IllegalArgumentException(("Illegal index " + i8 + ", " + a() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (((a().hashCode() * 31) + this.f22141b.hashCode()) * 31) + this.f22142c.hashCode();
    }

    @Override // m7.e
    public m7.l i() {
        return m.c.f21533a;
    }

    @Override // m7.e
    public boolean isInline() {
        return e.a.b(this);
    }

    @Override // m7.e
    public boolean j(int i8) {
        if (i8 >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i8 + ", " + a() + " expects only non-negative indices").toString());
    }

    public String toString() {
        return a() + '(' + this.f22141b + ", " + this.f22142c + ')';
    }

    public /* synthetic */ S(String str, m7.e eVar, m7.e eVar2, AbstractC2296k abstractC2296k) {
        this(str, eVar, eVar2);
    }
}
