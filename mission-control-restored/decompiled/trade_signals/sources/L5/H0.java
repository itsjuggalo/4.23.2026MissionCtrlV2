package L5;

import I5.p;
import L5.K0;
import java.lang.reflect.Member;
import kotlin.jvm.internal.AbstractC2291f;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.EnumC2486n;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes2.dex */
public class H0 extends K0 implements I5.p {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final InterfaceC2483k f5052o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final InterfaceC2483k f5053p;

    public static final class a extends K0.c implements p.a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final H0 f5054j;

        public a(H0 property) {
            AbstractC2304t.f(property, "property");
            this.f5054j = property;
        }

        @Override // I5.m.a
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public H0 m() {
            return this.f5054j;
        }

        @Override // B5.o
        public Object invoke(Object obj, Object obj2) {
            return m().l(obj, obj2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H0(AbstractC0654d0 container, R5.Z descriptor) {
        super(container, descriptor);
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(descriptor, "descriptor");
        EnumC2486n enumC2486n = EnumC2486n.f21975b;
        this.f5052o = AbstractC2484l.b(enumC2486n, new F0(this));
        this.f5053p = AbstractC2484l.b(enumC2486n, new G0(this));
    }

    public static final a i0(H0 h02) {
        return new a(h02);
    }

    public static final Member l0(H0 h02) {
        return h02.b0();
    }

    @Override // B5.o
    public Object invoke(Object obj, Object obj2) {
        return l(obj, obj2);
    }

    @Override // I5.p
    public Object l(Object obj, Object obj2) {
        return f0().call(obj, obj2);
    }

    @Override // L5.K0
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public a f0() {
        return (a) this.f5052o.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H0(AbstractC0654d0 container, String name, String signature) {
        super(container, name, signature, AbstractC2291f.NO_RECEIVER);
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(signature, "signature");
        EnumC2486n enumC2486n = EnumC2486n.f21975b;
        this.f5052o = AbstractC2484l.b(enumC2486n, new F0(this));
        this.f5053p = AbstractC2484l.b(enumC2486n, new G0(this));
    }
}
