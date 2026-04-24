package e6;

import R5.InterfaceC0848e;
import R5.h0;
import h6.InterfaceC1898g;
import j6.AbstractC2259w;
import j6.C2261y;
import j6.InterfaceC2260x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k6.C2284a;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2489q;
import p5.AbstractC2595q;
import p6.C2602e;
import q6.b;
import z6.C3020d;

/* JADX INFO: renamed from: e6.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1677D extends U5.H {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f17199o = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(C1677D.class, "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(C1677D.class, "partToFacade", "getPartToFacade()Ljava/util/HashMap;", 0))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h6.u f17200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d6.k f17201h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C2602e f17202i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final H6.i f17203j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C1704f f17204k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final H6.i f17205l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final S5.h f17206m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final H6.i f17207n;

    /* JADX INFO: renamed from: e6.D$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17208a;

        static {
            int[] iArr = new int[C2284a.EnumC0339a.values().length];
            try {
                iArr[C2284a.EnumC0339a.f20428i.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C2284a.EnumC0339a.f20425f.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f17208a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1677D(d6.k outerContext, h6.u jPackage) {
        super(outerContext.d(), jPackage.e());
        AbstractC2304t.f(outerContext, "outerContext");
        AbstractC2304t.f(jPackage, "jPackage");
        this.f17200g = jPackage;
        d6.k kVarF = d6.c.f(outerContext, this, null, 0, 6, null);
        this.f17201h = kVarF;
        this.f17202i = S6.c.a(outerContext.a().b().f().g());
        this.f17203j = kVarF.e().e(new C1674A(this));
        this.f17204k = new C1704f(kVarF, jPackage, this);
        this.f17205l = kVarF.e().c(new C1675B(this), AbstractC2595q.i());
        this.f17206m = kVarF.a().i().b() ? S5.h.f7663J.b() : d6.h.a(kVarF, jPackage);
        this.f17207n = kVarF.e().e(new C1676C(this));
    }

    public static final Map N0(C1677D c1677d) {
        List<String> listA = c1677d.f17201h.a().o().a(c1677d.e().a());
        ArrayList arrayList = new ArrayList();
        for (String str : listA) {
            b.a aVar = q6.b.f22655d;
            q6.c cVarE = C3020d.d(str).e();
            AbstractC2304t.e(cVarE, "getFqNameForTopLevelClassMaybeWithDollars(...)");
            InterfaceC2260x interfaceC2260xB = AbstractC2259w.b(c1677d.f17201h.a().j(), aVar.c(cVarE), c1677d.f17202i);
            C2489q c2489qA = interfaceC2260xB != null ? o5.w.a(str, interfaceC2260xB) : null;
            if (c2489qA != null) {
                arrayList.add(c2489qA);
            }
        }
        return p5.M.u(arrayList);
    }

    public static final HashMap S0(C1677D c1677d) {
        HashMap map = new HashMap();
        for (Map.Entry entry : c1677d.P0().entrySet()) {
            String str = (String) entry.getKey();
            InterfaceC2260x interfaceC2260x = (InterfaceC2260x) entry.getValue();
            C3020d c3020dD = C3020d.d(str);
            AbstractC2304t.e(c3020dD, "byInternalName(...)");
            C2284a c2284aB = interfaceC2260x.b();
            int i8 = a.f17208a[c2284aB.c().ordinal()];
            if (i8 == 1) {
                String strE = c2284aB.e();
                if (strE != null) {
                    map.put(c3020dD, C3020d.d(strE));
                }
            } else if (i8 == 2) {
                map.put(c3020dD, c3020dD);
            }
        }
        return map;
    }

    public static final List T0(C1677D c1677d) {
        Collection collectionY = c1677d.f17200g.y();
        ArrayList arrayList = new ArrayList(p5.r.s(collectionY, 10));
        Iterator it = collectionY.iterator();
        while (it.hasNext()) {
            arrayList.add(((h6.u) it.next()).e());
        }
        return arrayList;
    }

    public final InterfaceC0848e O0(InterfaceC1898g jClass) {
        AbstractC2304t.f(jClass, "jClass");
        return this.f17204k.i().k0(jClass);
    }

    public final Map P0() {
        return (Map) H6.m.a(this.f17203j, this, f17199o[0]);
    }

    @Override // R5.N
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public C1704f r() {
        return this.f17204k;
    }

    public final List R0() {
        return (List) this.f17205l.invoke();
    }

    @Override // S5.b, S5.a
    public S5.h getAnnotations() {
        return this.f17206m;
    }

    @Override // U5.H, U5.AbstractC0957n, R5.InterfaceC0859p
    public h0 j() {
        return new C2261y(this);
    }

    @Override // U5.H, U5.AbstractC0956m
    public String toString() {
        return "Lazy Java package fragment: " + e() + " of module " + this.f17201h.a().m();
    }
}
