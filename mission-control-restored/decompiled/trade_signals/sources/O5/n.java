package O5;

import I6.C0627k0;
import I6.S;
import I6.V;
import I6.r0;
import O5.o;
import R5.AbstractC0867y;
import R5.H;
import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import R5.M;
import R5.m0;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.O;
import o5.AbstractC2484l;
import o5.EnumC2486n;
import o5.InterfaceC2483k;
import p5.AbstractC2594p;
import p5.z;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final M f6076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2483k f6077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f6078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f6079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f6080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f6081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f6082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f6083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f6084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f6085j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f6075l = {O.g(new G(n.class, "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), O.g(new G(n.class, "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), O.g(new G(n.class, "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), O.g(new G(n.class, "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), O.g(new G(n.class, "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), O.g(new G(n.class, "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), O.g(new G(n.class, "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), O.g(new G(n.class, "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0))};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f6074k = new b(null);

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6086a;

        public a(int i8) {
            this.f6086a = i8;
        }

        public final InterfaceC0848e a(n types, I5.m property) {
            AbstractC2304t.f(types, "types");
            AbstractC2304t.f(property, "property");
            return types.c(Q6.a.a(property.getName()), this.f6086a);
        }
    }

    public static final class b {
        public b() {
        }

        public final S a(H module) {
            AbstractC2304t.f(module, "module");
            InterfaceC0848e interfaceC0848eB = AbstractC0867y.b(module, o.a.f6207w0);
            if (interfaceC0848eB == null) {
                return null;
            }
            r0 r0VarK = r0.f4460b.k();
            List parameters = interfaceC0848eB.l().getParameters();
            AbstractC2304t.e(parameters, "getParameters(...)");
            Object objU0 = z.u0(parameters);
            AbstractC2304t.e(objU0, "single(...)");
            return V.h(r0VarK, interfaceC0848eB, AbstractC2594p.e(new C0627k0((m0) objU0)));
        }

        public /* synthetic */ b(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public n(H module, M notFoundClasses) {
        AbstractC2304t.f(module, "module");
        AbstractC2304t.f(notFoundClasses, "notFoundClasses");
        this.f6076a = notFoundClasses;
        this.f6077b = AbstractC2484l.b(EnumC2486n.f21975b, new m(module));
        this.f6078c = new a(1);
        this.f6079d = new a(1);
        this.f6080e = new a(1);
        this.f6081f = new a(2);
        this.f6082g = new a(3);
        this.f6083h = new a(1);
        this.f6084i = new a(2);
        this.f6085j = new a(3);
    }

    public static final B6.k f(H h8) {
        return h8.u0(o.f6118x).r();
    }

    public final InterfaceC0848e c(String str, int i8) {
        q6.f fVarL = q6.f.l(str);
        AbstractC2304t.e(fVarL, "identifier(...)");
        InterfaceC0851h interfaceC0851hE = e().e(fVarL, Z5.d.f9777h);
        InterfaceC0848e interfaceC0848e = interfaceC0851hE instanceof InterfaceC0848e ? (InterfaceC0848e) interfaceC0851hE : null;
        return interfaceC0848e == null ? this.f6076a.d(new q6.b(o.f6118x, fVarL), AbstractC2594p.e(Integer.valueOf(i8))) : interfaceC0848e;
    }

    public final InterfaceC0848e d() {
        return this.f6078c.a(this, f6075l[0]);
    }

    public final B6.k e() {
        return (B6.k) this.f6077b.getValue();
    }
}
