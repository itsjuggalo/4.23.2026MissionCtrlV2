package I6;

import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.EnumC2486n;
import o5.InterfaceC2483k;

/* JADX INFO: renamed from: I6.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0627k0 extends C0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R5.m0 f4435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2483k f4436b;

    public C0627k0(R5.m0 typeParameter) {
        AbstractC2304t.f(typeParameter, "typeParameter");
        this.f4435a = typeParameter;
        this.f4436b = AbstractC2484l.b(EnumC2486n.f21975b, new C0625j0(this));
    }

    public static final S d(C0627k0 c0627k0) {
        return AbstractC0629l0.b(c0627k0.f4435a);
    }

    @Override // I6.B0
    public B0 a(J6.g kotlinTypeRefiner) {
        AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // I6.B0
    public N0 b() {
        return N0.f4372g;
    }

    @Override // I6.B0
    public boolean c() {
        return true;
    }

    public final S f() {
        return (S) this.f4436b.getValue();
    }

    @Override // I6.B0
    public S getType() {
        return f();
    }
}
