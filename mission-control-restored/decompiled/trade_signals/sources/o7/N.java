package o7;

import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import m7.e;
import m7.m;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class N implements m7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m7.e f22127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22128b;

    public N(m7.e eVar) {
        this.f22127a = eVar;
        this.f22128b = 1;
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
        throw new IllegalArgumentException(name + " is not a valid list index");
    }

    @Override // m7.e
    public int e() {
        return this.f22128b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N)) {
            return false;
        }
        N n8 = (N) obj;
        return AbstractC2304t.b(this.f22127a, n8.f22127a) && AbstractC2304t.b(a(), n8.a());
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
            return this.f22127a;
        }
        throw new IllegalArgumentException(("Illegal index " + i8 + ", " + a() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (this.f22127a.hashCode() * 31) + a().hashCode();
    }

    @Override // m7.e
    public m7.l i() {
        return m.b.f21532a;
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
        return a() + '(' + this.f22127a + ')';
    }

    public /* synthetic */ N(m7.e eVar, AbstractC2296k abstractC2296k) {
        this(eVar);
    }
}
