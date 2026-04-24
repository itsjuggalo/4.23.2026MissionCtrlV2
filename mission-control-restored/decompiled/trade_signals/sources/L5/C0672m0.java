package L5;

import I5.k;
import L5.K0;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.C2470H;
import o5.EnumC2486n;
import o5.InterfaceC2483k;

/* JADX INFO: renamed from: L5.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0672m0 extends E0 implements I5.k {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final InterfaceC2483k f5202q;

    /* JADX INFO: renamed from: L5.m0$a */
    public static final class a extends K0.d implements k.a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final C0672m0 f5203j;

        public a(C0672m0 property) {
            AbstractC2304t.f(property, "property");
            this.f5203j = property;
        }

        @Override // I5.m.a
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public C0672m0 m() {
            return this.f5203j;
        }

        public void f0(Object obj, Object obj2) throws J5.a {
            m().q0(obj, obj2);
        }

        @Override // B5.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws J5.a {
            f0(obj, obj2);
            return C2470H.f21956a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0672m0(AbstractC0654d0 container, R5.Z descriptor) {
        super(container, descriptor);
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(descriptor, "descriptor");
        this.f5202q = AbstractC2484l.b(EnumC2486n.f21975b, new C0670l0(this));
    }

    public static final a n0(C0672m0 c0672m0) {
        return new a(c0672m0);
    }

    @Override // I5.k, I5.i
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public a h() {
        return (a) this.f5202q.getValue();
    }

    public void q0(Object obj, Object obj2) throws J5.a {
        h().call(obj, obj2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0672m0(AbstractC0654d0 container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(signature, "signature");
        this.f5202q = AbstractC2484l.b(EnumC2486n.f21975b, new C0670l0(this));
    }
}
