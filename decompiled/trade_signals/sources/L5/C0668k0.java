package L5;

import I5.j;
import L5.K0;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.C2470H;
import o5.EnumC2486n;
import o5.InterfaceC2483k;

/* JADX INFO: renamed from: L5.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0668k0 extends B0 implements I5.j {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final InterfaceC2483k f5195q;

    /* JADX INFO: renamed from: L5.k0$a */
    public static final class a extends K0.d implements j.a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final C0668k0 f5196j;

        public a(C0668k0 property) {
            AbstractC2304t.f(property, "property");
            this.f5196j = property;
        }

        @Override // I5.m.a
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public C0668k0 m() {
            return this.f5196j;
        }

        public void f0(Object obj) throws J5.a {
            m().q0(obj);
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws J5.a {
            f0(obj);
            return C2470H.f21956a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0668k0(AbstractC0654d0 container, R5.Z descriptor) {
        super(container, descriptor);
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(descriptor, "descriptor");
        this.f5195q = AbstractC2484l.b(EnumC2486n.f21975b, new C0666j0(this));
    }

    public static final a n0(C0668k0 c0668k0) {
        return new a(c0668k0);
    }

    @Override // I5.j, I5.i
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public a h() {
        return (a) this.f5195q.getValue();
    }

    public void q0(Object obj) throws J5.a {
        h().call(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0668k0(AbstractC0654d0 container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(signature, "signature");
        this.f5195q = AbstractC2484l.b(EnumC2486n.f21975b, new C0666j0(this));
    }
}
