package L5;

import I5.i;
import L5.K0;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.C2470H;
import o5.EnumC2486n;
import o5.InterfaceC2483k;

/* JADX INFO: renamed from: L5.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0676o0 extends H0 implements I5.p, I5.i {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final InterfaceC2483k f5214q;

    /* JADX INFO: renamed from: L5.o0$a */
    public static final class a extends K0.d implements i.a, B5.p {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final C0676o0 f5215j;

        public a(C0676o0 property) {
            AbstractC2304t.f(property, "property");
            this.f5215j = property;
        }

        @Override // I5.m.a
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public C0676o0 m() {
            return this.f5215j;
        }

        public void f0(Object obj, Object obj2, Object obj3) throws J5.a {
            m().q0(obj, obj2, obj3);
        }

        @Override // B5.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) throws J5.a {
            f0(obj, obj2, obj3);
            return C2470H.f21956a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0676o0(AbstractC0654d0 container, R5.Z descriptor) {
        super(container, descriptor);
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(descriptor, "descriptor");
        this.f5214q = AbstractC2484l.b(EnumC2486n.f21975b, new C0674n0(this));
    }

    public static final a n0(C0676o0 c0676o0) {
        return new a(c0676o0);
    }

    @Override // I5.i
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public a h() {
        return (a) this.f5214q.getValue();
    }

    public void q0(Object obj, Object obj2, Object obj3) throws J5.a {
        h().call(obj, obj2, obj3);
    }
}
