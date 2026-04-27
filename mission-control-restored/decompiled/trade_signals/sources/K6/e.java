package K6;

import R5.G;
import R5.H;
import R5.InterfaceC0856m;
import R5.InterfaceC0858o;
import R5.V;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.InterfaceC2483k;
import p5.AbstractC2595q;
import p5.S;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f4793a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q6.f f4794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List f4795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List f4796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set f4797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final InterfaceC2483k f4798f;

    static {
        q6.f fVarQ = q6.f.q(b.f4784e.b());
        AbstractC2304t.e(fVarQ, "special(...)");
        f4794b = fVarQ;
        f4795c = AbstractC2595q.i();
        f4796d = AbstractC2595q.i();
        f4797e = S.d();
        f4798f = AbstractC2484l.a(d.f4792a);
    }

    public static final O5.g R() {
        return O5.g.f6038h.a();
    }

    public q6.f C0() {
        return f4794b;
    }

    @Override // R5.InterfaceC0856m
    public Object N(InterfaceC0858o visitor, Object obj) {
        AbstractC2304t.f(visitor, "visitor");
        return null;
    }

    @Override // R5.InterfaceC0856m
    public InterfaceC0856m b() {
        return null;
    }

    @Override // R5.H
    public Object f0(G capability) {
        AbstractC2304t.f(capability, "capability");
        return null;
    }

    @Override // S5.a
    public S5.h getAnnotations() {
        return S5.h.f7663J.b();
    }

    @Override // R5.J
    public q6.f getName() {
        return C0();
    }

    @Override // R5.H
    public O5.i q() {
        return (O5.i) f4798f.getValue();
    }

    @Override // R5.H
    public boolean s0(H targetModule) {
        AbstractC2304t.f(targetModule, "targetModule");
        return false;
    }

    @Override // R5.H
    public V u0(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        throw new IllegalStateException("Should not be called!");
    }

    @Override // R5.H
    public Collection v(q6.c fqName, B5.k nameFilter) {
        AbstractC2304t.f(fqName, "fqName");
        AbstractC2304t.f(nameFilter, "nameFilter");
        return AbstractC2595q.i();
    }

    @Override // R5.H
    public List v0() {
        return f4796d;
    }

    @Override // R5.InterfaceC0856m
    public InterfaceC0856m a() {
        return this;
    }
}
