package L5;

import I5.n;
import L5.K0;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.EnumC2486n;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes2.dex */
public class B0 extends K0 implements I5.n {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final InterfaceC2483k f5036o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final InterfaceC2483k f5037p;

    public static final class a extends K0.c implements n.a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final B0 f5038j;

        public a(B0 property) {
            AbstractC2304t.f(property, "property");
            this.f5038j = property;
        }

        @Override // I5.m.a
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public B0 m() {
            return this.f5038j;
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return Y().get();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B0(AbstractC0654d0 container, R5.Z descriptor) {
        super(container, descriptor);
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(descriptor, "descriptor");
        EnumC2486n enumC2486n = EnumC2486n.f21975b;
        this.f5036o = AbstractC2484l.b(enumC2486n, new C0697z0(this));
        this.f5037p = AbstractC2484l.b(enumC2486n, new A0(this));
    }

    public static final a i0(B0 b02) {
        return new a(b02);
    }

    public static final Object l0(B0 b02) {
        return b02.d0(b02.b0(), null, null);
    }

    @Override // I5.n
    public Object get() {
        return d().call(new Object[0]);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    @Override // L5.K0
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public a f0() {
        return (a) this.f5036o.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B0(AbstractC0654d0 container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(signature, "signature");
        EnumC2486n enumC2486n = EnumC2486n.f21975b;
        this.f5036o = AbstractC2484l.b(enumC2486n, new C0697z0(this));
        this.f5037p = AbstractC2484l.b(enumC2486n, new A0(this));
    }
}
