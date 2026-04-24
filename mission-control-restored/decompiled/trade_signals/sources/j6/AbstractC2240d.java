package j6;

import E6.EnumC0465d;
import E6.InterfaceC0466e;
import E6.N;
import I6.S;
import R5.h0;
import j6.C2227A;
import j6.InterfaceC2260x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import n6.AbstractC2428b;
import p6.C2606i;
import w6.s;

/* JADX INFO: renamed from: j6.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2240d extends AbstractC2241e implements InterfaceC0466e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final H6.g f20150c;

    /* JADX INFO: renamed from: j6.d$a */
    public static final class a implements InterfaceC2260x.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashMap f20152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2260x f20153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ HashMap f20154d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ HashMap f20155e;

        /* JADX INFO: renamed from: j6.d$a$a, reason: collision with other inner class name */
        public final class C0330a extends b implements InterfaceC2260x.e {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f20156d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0330a(a aVar, C2227A signature) {
                super(aVar, signature);
                AbstractC2304t.f(signature, "signature");
                this.f20156d = aVar;
            }

            @Override // j6.InterfaceC2260x.e
            public InterfaceC2260x.a c(int i8, q6.b classId, h0 source) {
                AbstractC2304t.f(classId, "classId");
                AbstractC2304t.f(source, "source");
                C2227A c2227aE = C2227A.f20120b.e(d(), i8);
                List arrayList = (List) this.f20156d.f20152b.get(c2227aE);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f20156d.f20152b.put(c2227aE, arrayList);
                }
                return AbstractC2240d.this.y(classId, source, arrayList);
            }
        }

        /* JADX INFO: renamed from: j6.d$a$b */
        public class b implements InterfaceC2260x.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final C2227A f20157a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ArrayList f20158b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f20159c;

            public b(a aVar, C2227A signature) {
                AbstractC2304t.f(signature, "signature");
                this.f20159c = aVar;
                this.f20157a = signature;
                this.f20158b = new ArrayList();
            }

            @Override // j6.InterfaceC2260x.c
            public void a() {
                if (!this.f20158b.isEmpty()) {
                    this.f20159c.f20152b.put(this.f20157a, this.f20158b);
                }
            }

            @Override // j6.InterfaceC2260x.c
            public InterfaceC2260x.a b(q6.b classId, h0 source) {
                AbstractC2304t.f(classId, "classId");
                AbstractC2304t.f(source, "source");
                return AbstractC2240d.this.y(classId, source, this.f20158b);
            }

            public final C2227A d() {
                return this.f20157a;
            }
        }

        public a(HashMap map, InterfaceC2260x interfaceC2260x, HashMap map2, HashMap map3) {
            this.f20152b = map;
            this.f20153c = interfaceC2260x;
            this.f20154d = map2;
            this.f20155e = map3;
        }

        @Override // j6.InterfaceC2260x.d
        public InterfaceC2260x.c a(q6.f name, String desc, Object obj) {
            Object objI;
            AbstractC2304t.f(name, "name");
            AbstractC2304t.f(desc, "desc");
            C2227A.a aVar = C2227A.f20120b;
            String strB = name.b();
            AbstractC2304t.e(strB, "asString(...)");
            C2227A c2227aA = aVar.a(strB, desc);
            if (obj != null && (objI = AbstractC2240d.this.I(desc, obj)) != null) {
                this.f20155e.put(c2227aA, objI);
            }
            return new b(this, c2227aA);
        }

        @Override // j6.InterfaceC2260x.d
        public InterfaceC2260x.e b(q6.f name, String desc) {
            AbstractC2304t.f(name, "name");
            AbstractC2304t.f(desc, "desc");
            C2227A.a aVar = C2227A.f20120b;
            String strB = name.b();
            AbstractC2304t.e(strB, "asString(...)");
            return new C0330a(this, aVar.d(strB, desc));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC2240d(H6.n storageManager, InterfaceC2258v kotlinClassFinder) {
        super(kotlinClassFinder);
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(kotlinClassFinder, "kotlinClassFinder");
        this.f20150c = storageManager.g(new C2237a(this));
    }

    public static final Object G(C2243g loadConstantFromProperty, C2227A it) {
        AbstractC2304t.f(loadConstantFromProperty, "$this$loadConstantFromProperty");
        AbstractC2304t.f(it, "it");
        return loadConstantFromProperty.b().get(it);
    }

    public static final Object K(C2243g loadConstantFromProperty, C2227A it) {
        AbstractC2304t.f(loadConstantFromProperty, "$this$loadConstantFromProperty");
        AbstractC2304t.f(it, "it");
        return loadConstantFromProperty.c().get(it);
    }

    public static final C2243g L(AbstractC2240d abstractC2240d, InterfaceC2260x kotlinClass) {
        AbstractC2304t.f(kotlinClass, "kotlinClass");
        return abstractC2240d.H(kotlinClass);
    }

    @Override // j6.AbstractC2241e
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public C2243g q(InterfaceC2260x binaryClass) {
        AbstractC2304t.f(binaryClass, "binaryClass");
        return (C2243g) this.f20150c.invoke(binaryClass);
    }

    public final boolean F(q6.b annotationClassId, Map arguments) {
        AbstractC2304t.f(annotationClassId, "annotationClassId");
        AbstractC2304t.f(arguments, "arguments");
        if (!AbstractC2304t.b(annotationClassId, N5.a.f5879a.a())) {
            return false;
        }
        Object obj = arguments.get(q6.f.l("value"));
        w6.s sVar = obj instanceof w6.s ? (w6.s) obj : null;
        if (sVar == null) {
            return false;
        }
        Object objB = sVar.b();
        s.b.C0427b c0427b = objB instanceof s.b.C0427b ? (s.b.C0427b) objB : null;
        if (c0427b == null) {
            return false;
        }
        return w(c0427b.b());
    }

    public final C2243g H(InterfaceC2260x interfaceC2260x) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        interfaceC2260x.c(new a(map, interfaceC2260x, map3, map2), r(interfaceC2260x));
        return new C2243g(map, map2, map3);
    }

    public abstract Object I(String str, Object obj);

    public final Object J(N n8, l6.n nVar, EnumC0465d enumC0465d, S s8, B5.o oVar) {
        Object objInvoke;
        InterfaceC2260x interfaceC2260xP = p(n8, AbstractC2241e.f20160b.a(n8, true, true, AbstractC2428b.f21627B.d(nVar.b0()), C2606i.f(nVar), v(), u()));
        if (interfaceC2260xP == null) {
            return null;
        }
        C2227A c2227aS = s(nVar, n8.b(), n8.d(), enumC0465d, interfaceC2260xP.b().d().d(C2250n.f20202b.a()));
        if (c2227aS == null || (objInvoke = oVar.invoke(this.f20150c.invoke(interfaceC2260xP), c2227aS)) == null) {
            return null;
        }
        return O5.s.d(s8) ? M(objInvoke) : objInvoke;
    }

    public abstract Object M(Object obj);

    @Override // E6.InterfaceC0466e
    public Object f(N container, l6.n proto, S expectedType) {
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(proto, "proto");
        AbstractC2304t.f(expectedType, "expectedType");
        return J(container, proto, EnumC0465d.PROPERTY, expectedType, C2239c.f20149a);
    }

    @Override // E6.InterfaceC0466e
    public Object i(N container, l6.n proto, S expectedType) {
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(proto, "proto");
        AbstractC2304t.f(expectedType, "expectedType");
        return J(container, proto, EnumC0465d.PROPERTY_GETTER, expectedType, C2238b.f20148a);
    }
}
