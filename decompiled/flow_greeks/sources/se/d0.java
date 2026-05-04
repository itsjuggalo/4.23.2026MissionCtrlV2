package se;

import ef.b;
import fe.g1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ye.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends ie.h0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f20226o = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(d0.class, "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(d0.class, "partToFacade", "getPartToFacade()Ljava/util/HashMap;", 0))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ve.u f20227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final re.k f20228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final df.e f20229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final wf.i f20230j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f20231k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final wf.i f20232l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ge.h f20233m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final wf.i f20234n;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20235a;

        static {
            int[] iArr = new int[a.EnumC0469a.values().length];
            try {
                iArr[a.EnumC0469a.f25376i.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.EnumC0469a.f25373f.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f20235a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(re.k outerContext, ve.u jPackage) {
        super(outerContext.d(), jPackage.e());
        kotlin.jvm.internal.t.f(outerContext, "outerContext");
        kotlin.jvm.internal.t.f(jPackage, "jPackage");
        this.f20227g = jPackage;
        re.k kVarF = re.c.f(outerContext, this, null, 0, 6, null);
        this.f20228h = kVarF;
        this.f20229i = hg.c.a(outerContext.a().b().f().g());
        this.f20230j = kVarF.e().e(new a0(this));
        this.f20231k = new f(kVarF, jPackage, this);
        this.f20232l = kVarF.e().d(new b0(this), dd.r.k());
        this.f20233m = kVarF.a().i().b() ? ge.h.L.b() : re.h.a(kVarF, jPackage);
        this.f20234n = kVarF.e().e(new c0(this));
    }

    public static final Map M0(d0 d0Var) {
        List<String> listA = d0Var.f20228h.a().o().a(d0Var.e().a());
        ArrayList arrayList = new ArrayList();
        for (String str : listA) {
            b.a aVar = ef.b.f8779d;
            ef.c cVarE = of.d.d(str).e();
            kotlin.jvm.internal.t.e(cVarE, "getFqNameForTopLevelClassMaybeWithDollars(...)");
            xe.x xVarA = xe.w.a(d0Var.f20228h.a().j(), aVar.c(cVarE), d0Var.f20229i);
            cd.q qVarA = xVarA != null ? cd.w.a(str, xVarA) : null;
            if (qVarA != null) {
                arrayList.add(qVarA);
            }
        }
        return dd.o0.t(arrayList);
    }

    public static final HashMap R0(d0 d0Var) {
        HashMap map = new HashMap();
        for (Map.Entry entry : d0Var.O0().entrySet()) {
            String str = (String) entry.getKey();
            xe.x xVar = (xe.x) entry.getValue();
            of.d dVarD = of.d.d(str);
            kotlin.jvm.internal.t.e(dVarD, "byInternalName(...)");
            ye.a aVarB = xVar.b();
            int i10 = a.f20235a[aVarB.c().ordinal()];
            if (i10 == 1) {
                String strE = aVarB.e();
                if (strE != null) {
                    map.put(dVarD, of.d.d(strE));
                }
            } else if (i10 == 2) {
                map.put(dVarD, dVarD);
            }
        }
        return map;
    }

    public static final List S0(d0 d0Var) {
        Collection collectionZ = d0Var.f20227g.z();
        ArrayList arrayList = new ArrayList(dd.s.u(collectionZ, 10));
        Iterator it = collectionZ.iterator();
        while (it.hasNext()) {
            arrayList.add(((ve.u) it.next()).e());
        }
        return arrayList;
    }

    public final fe.e N0(ve.g jClass) {
        kotlin.jvm.internal.t.f(jClass, "jClass");
        return this.f20231k.i().k0(jClass);
    }

    public final Map O0() {
        return (Map) wf.m.a(this.f20230j, this, f20226o[0]);
    }

    @Override // fe.n0
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public f q() {
        return this.f20231k;
    }

    public final List Q0() {
        return (List) this.f20232l.invoke();
    }

    @Override // ge.b, ge.a
    public ge.h getAnnotations() {
        return this.f20233m;
    }

    @Override // ie.h0, ie.n, fe.p
    public g1 j() {
        return new xe.y(this);
    }

    @Override // ie.h0, ie.m
    public String toString() {
        return "Lazy Java package fragment: " + e() + " of module " + this.f20228h.a().m();
    }
}
