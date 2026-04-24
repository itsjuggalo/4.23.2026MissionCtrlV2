package L5;

import I5.o;
import L5.K0;
import java.lang.reflect.Member;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.EnumC2486n;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes2.dex */
public class E0 extends K0 implements I5.o {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final InterfaceC2483k f5044o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final InterfaceC2483k f5045p;

    public static final class a extends K0.c implements o.a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final E0 f5046j;

        public a(E0 property) {
            AbstractC2304t.f(property, "property");
            this.f5046j = property;
        }

        @Override // I5.m.a
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public E0 m() {
            return this.f5046j;
        }

        @Override // B5.k
        public Object invoke(Object obj) {
            return m().get(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E0(AbstractC0654d0 container, R5.Z descriptor) {
        super(container, descriptor);
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(descriptor, "descriptor");
        EnumC2486n enumC2486n = EnumC2486n.f21975b;
        this.f5044o = AbstractC2484l.b(enumC2486n, new C0(this));
        this.f5045p = AbstractC2484l.b(enumC2486n, new D0(this));
    }

    public static final a i0(E0 e02) {
        return new a(e02);
    }

    public static final Member l0(E0 e02) {
        return e02.b0();
    }

    @Override // I5.o
    public Object get(Object obj) {
        return f0().call(obj);
    }

    @Override // B5.k
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // L5.K0
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public a f0() {
        return (a) this.f5044o.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E0(AbstractC0654d0 container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(signature, "signature");
        EnumC2486n enumC2486n = EnumC2486n.f21975b;
        this.f5044o = AbstractC2484l.b(enumC2486n, new C0(this));
        this.f5045p = AbstractC2484l.b(enumC2486n, new D0(this));
    }
}
