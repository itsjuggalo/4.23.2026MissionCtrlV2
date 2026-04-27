package R5;

import B6.k;
import I6.C0640u;
import I6.N0;
import U5.AbstractC0953j;
import U5.C0959p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;
import y6.AbstractC2996e;

/* JADX INFO: loaded from: classes2.dex */
public final class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H6.n f7208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H f7209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final H6.g f7210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final H6.g f7211d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q6.b f7212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f7213b;

        public a(q6.b classId, List typeParametersCount) {
            AbstractC2304t.f(classId, "classId");
            AbstractC2304t.f(typeParametersCount, "typeParametersCount");
            this.f7212a = classId;
            this.f7213b = typeParametersCount;
        }

        public final q6.b a() {
            return this.f7212a;
        }

        public final List b() {
            return this.f7213b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC2304t.b(this.f7212a, aVar.f7212a) && AbstractC2304t.b(this.f7213b, aVar.f7213b);
        }

        public int hashCode() {
            return (this.f7212a.hashCode() * 31) + this.f7213b.hashCode();
        }

        public String toString() {
            return "ClassRequest(classId=" + this.f7212a + ", typeParametersCount=" + this.f7213b + ')';
        }
    }

    public static final class b extends AbstractC0953j {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f7214i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final List f7215j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final C0640u f7216k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(H6.n storageManager, InterfaceC0856m container, q6.f name, boolean z7, int i8) {
            super(storageManager, container, name, h0.f7249a, false);
            AbstractC2304t.f(storageManager, "storageManager");
            AbstractC2304t.f(container, "container");
            AbstractC2304t.f(name, "name");
            this.f7214i = z7;
            H5.d dVarL = H5.i.l(0, i8);
            ArrayList arrayList = new ArrayList(p5.r.s(dVarL, 10));
            Iterator it = dVarL.iterator();
            while (it.hasNext()) {
                int iC = ((p5.I) it).c();
                S5.h hVarB = S5.h.f7663J.b();
                N0 n02 = N0.f4370e;
                StringBuilder sb = new StringBuilder();
                sb.append('T');
                sb.append(iC);
                arrayList.add(U5.U.S0(this, hVarB, false, n02, q6.f.l(sb.toString()), iC, storageManager));
            }
            this.f7215j = arrayList;
            this.f7216k = new C0640u(this, q0.g(this), p5.Q.c(AbstractC2996e.s(this).q().i()), storageManager);
        }

        @Override // R5.InterfaceC0848e
        public r0 B0() {
            return null;
        }

        @Override // R5.InterfaceC0848e
        public boolean D() {
            return false;
        }

        @Override // R5.D
        public boolean G0() {
            return false;
        }

        @Override // R5.InterfaceC0848e
        public boolean J0() {
            return false;
        }

        @Override // R5.InterfaceC0848e
        public Collection K() {
            return AbstractC2595q.i();
        }

        @Override // R5.D
        public boolean L() {
            return false;
        }

        @Override // R5.InterfaceC0848e
        /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
        public k.b T() {
            return k.b.f219b;
        }

        @Override // R5.InterfaceC0852i
        public boolean M() {
            return this.f7214i;
        }

        @Override // R5.InterfaceC0851h
        /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
        public C0640u l() {
            return this.f7216k;
        }

        @Override // U5.z
        /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
        public k.b R(J6.g kotlinTypeRefiner) {
            AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            return k.b.f219b;
        }

        @Override // R5.InterfaceC0848e
        public InterfaceC0847d S() {
            return null;
        }

        @Override // R5.InterfaceC0848e
        public InterfaceC0848e V() {
            return null;
        }

        @Override // S5.a
        public S5.h getAnnotations() {
            return S5.h.f7663J.b();
        }

        @Override // R5.InterfaceC0848e, R5.D, R5.InterfaceC0860q
        public AbstractC0863u getVisibility() {
            AbstractC0863u PUBLIC = AbstractC0862t.f7261e;
            AbstractC2304t.e(PUBLIC, "PUBLIC");
            return PUBLIC;
        }

        @Override // R5.InterfaceC0848e
        public EnumC0849f i() {
            return EnumC0849f.f7234b;
        }

        @Override // U5.AbstractC0953j, R5.D
        public boolean isExternal() {
            return false;
        }

        @Override // R5.InterfaceC0848e
        public boolean isInline() {
            return false;
        }

        @Override // R5.InterfaceC0848e, R5.D
        public E m() {
            return E.f7197b;
        }

        @Override // R5.InterfaceC0848e
        public Collection n() {
            return p5.S.d();
        }

        @Override // R5.InterfaceC0848e
        public boolean o() {
            return false;
        }

        public String toString() {
            return "class " + getName() + " (not found)";
        }

        @Override // R5.InterfaceC0848e, R5.InterfaceC0852i
        public List w() {
            return this.f7215j;
        }

        @Override // R5.InterfaceC0848e
        public boolean y() {
            return false;
        }
    }

    public M(H6.n storageManager, H module) {
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(module, "module");
        this.f7208a = storageManager;
        this.f7209b = module;
        this.f7210c = storageManager.g(new K(this));
        this.f7211d = storageManager.g(new L(this));
    }

    public static final InterfaceC0848e c(M m8, a aVar) {
        InterfaceC0856m interfaceC0856mD;
        AbstractC2304t.f(aVar, "<destruct>");
        q6.b bVarA = aVar.a();
        List listB = aVar.b();
        if (bVarA.i()) {
            throw new UnsupportedOperationException("Unresolved local class: " + bVarA);
        }
        q6.b bVarE = bVarA.e();
        if (bVarE == null || (interfaceC0856mD = m8.d(bVarE, p5.z.S(listB, 1))) == null) {
            interfaceC0856mD = (InterfaceC0850g) m8.f7210c.invoke(bVarA.f());
        }
        InterfaceC0856m interfaceC0856m = interfaceC0856mD;
        boolean zJ = bVarA.j();
        H6.n nVar = m8.f7208a;
        q6.f fVarH = bVarA.h();
        Integer num = (Integer) p5.z.a0(listB);
        return new b(nVar, interfaceC0856m, fVarH, zJ, num != null ? num.intValue() : 0);
    }

    public static final N e(M m8, q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        return new C0959p(m8.f7209b, fqName);
    }

    public final InterfaceC0848e d(q6.b classId, List typeParametersCount) {
        AbstractC2304t.f(classId, "classId");
        AbstractC2304t.f(typeParametersCount, "typeParametersCount");
        return (InterfaceC0848e) this.f7211d.invoke(new a(classId, typeParametersCount));
    }
}
