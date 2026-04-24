package E6;

import R5.h0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import l6.c;
import n6.AbstractC2428b;
import n6.InterfaceC2429c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2429c f931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n6.g f932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0 f933c;

    public static final class a extends N {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final l6.c f934d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final a f935e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final q6.b f936f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c.EnumC0352c f937g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f938h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f939i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l6.c classProto, InterfaceC2429c nameResolver, n6.g typeTable, h0 h0Var, a aVar) {
            super(nameResolver, typeTable, h0Var, null);
            AbstractC2304t.f(classProto, "classProto");
            AbstractC2304t.f(nameResolver, "nameResolver");
            AbstractC2304t.f(typeTable, "typeTable");
            this.f934d = classProto;
            this.f935e = aVar;
            this.f936f = L.a(nameResolver, classProto.F0());
            c.EnumC0352c enumC0352c = (c.EnumC0352c) AbstractC2428b.f21647f.d(classProto.E0());
            this.f937g = enumC0352c == null ? c.EnumC0352c.CLASS : enumC0352c;
            Boolean boolD = AbstractC2428b.f21648g.d(classProto.E0());
            AbstractC2304t.e(boolD, "get(...)");
            this.f938h = boolD.booleanValue();
            Boolean boolD2 = AbstractC2428b.f21649h.d(classProto.E0());
            AbstractC2304t.e(boolD2, "get(...)");
            this.f939i = boolD2.booleanValue();
        }

        @Override // E6.N
        public q6.c a() {
            return this.f936f.a();
        }

        public final q6.b e() {
            return this.f936f;
        }

        public final l6.c f() {
            return this.f934d;
        }

        public final c.EnumC0352c g() {
            return this.f937g;
        }

        public final a h() {
            return this.f935e;
        }

        public final boolean i() {
            return this.f938h;
        }
    }

    public static final class b extends N {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final q6.c f940d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(q6.c fqName, InterfaceC2429c nameResolver, n6.g typeTable, h0 h0Var) {
            super(nameResolver, typeTable, h0Var, null);
            AbstractC2304t.f(fqName, "fqName");
            AbstractC2304t.f(nameResolver, "nameResolver");
            AbstractC2304t.f(typeTable, "typeTable");
            this.f940d = fqName;
        }

        @Override // E6.N
        public q6.c a() {
            return this.f940d;
        }
    }

    public N(InterfaceC2429c interfaceC2429c, n6.g gVar, h0 h0Var) {
        this.f931a = interfaceC2429c;
        this.f932b = gVar;
        this.f933c = h0Var;
    }

    public abstract q6.c a();

    public final InterfaceC2429c b() {
        return this.f931a;
    }

    public final h0 c() {
        return this.f933c;
    }

    public final n6.g d() {
        return this.f932b;
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + a();
    }

    public /* synthetic */ N(InterfaceC2429c interfaceC2429c, n6.g gVar, h0 h0Var, AbstractC2296k abstractC2296k) {
        this(interfaceC2429c, gVar, h0Var);
    }
}
