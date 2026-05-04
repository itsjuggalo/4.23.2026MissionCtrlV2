package ie;

import com.google.firebase.analytics.FirebaseAnalytics;
import fe.g1;
import fe.q1;
import io.flutter.Build;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import qf.k;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class q extends j {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u1 f12413i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final qf.k f12414j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final wf.i f12415k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ge.h f12416l;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends qf.l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final wf.g f12417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final wf.g f12418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final wf.i f12419d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ q f12420e;

        /* JADX INFO: renamed from: ie.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0232a implements pd.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q f12421a;

            public C0232a(q qVar) {
                this.f12421a = qVar;
            }

            @Override // pd.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection invoke(ef.f fVar) {
                return a.this.m(fVar);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class b implements pd.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q f12423a;

            public b(q qVar) {
                this.f12423a = qVar;
            }

            @Override // pd.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection invoke(ef.f fVar) {
                return a.this.n(fVar);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class c implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q f12425a;

            public c(q qVar) {
                this.f12425a = qVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection invoke() {
                return a.this.l();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class d extends jf.m {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Set f12427a;

            public d(Set set) {
                this.f12427a = set;
            }

            public static /* synthetic */ void f(int i10) {
                Object[] objArr = new Object[3];
                if (i10 == 1) {
                    objArr[0] = "fromSuper";
                } else if (i10 != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i10 == 1 || i10 == 2) {
                    objArr[2] = "conflict";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // jf.n
            public void a(fe.b bVar) {
                if (bVar == null) {
                    f(0);
                }
                jf.o.K(bVar, null);
                this.f12427a.add(bVar);
            }

            @Override // jf.m
            public void e(fe.b bVar, fe.b bVar2) {
                if (bVar == null) {
                    f(1);
                }
                if (bVar2 == null) {
                    f(2);
                }
            }
        }

        public a(q qVar, wf.n nVar) {
            if (nVar == null) {
                h(0);
            }
            this.f12420e = qVar;
            this.f12417b = nVar.i(new C0232a(qVar));
            this.f12418c = nVar.i(new b(qVar));
            this.f12419d = nVar.e(new c(qVar));
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static /* synthetic */ void h(int r13) {
            /*
                Method dump skipped, instruction units count: 346
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ie.q.a.h(int):void");
        }

        @Override // qf.l, qf.k
        public Collection a(ef.f fVar, ne.b bVar) {
            if (fVar == null) {
                h(1);
            }
            if (bVar == null) {
                h(2);
            }
            Collection collection = (Collection) this.f12418c.invoke(fVar);
            if (collection == null) {
                h(3);
            }
            return collection;
        }

        @Override // qf.l, qf.k
        public Set b() {
            Set set = (Set) this.f12420e.f12415k.invoke();
            if (set == null) {
                h(17);
            }
            return set;
        }

        @Override // qf.l, qf.k
        public Collection c(ef.f fVar, ne.b bVar) {
            if (fVar == null) {
                h(5);
            }
            if (bVar == null) {
                h(6);
            }
            Collection collection = (Collection) this.f12417b.invoke(fVar);
            if (collection == null) {
                h(7);
            }
            return collection;
        }

        @Override // qf.l, qf.k
        public Set d() {
            Set set = (Set) this.f12420e.f12415k.invoke();
            if (set == null) {
                h(19);
            }
            return set;
        }

        @Override // qf.l, qf.k
        public Set f() {
            Set set = Collections.EMPTY_SET;
            if (set == null) {
                h(18);
            }
            return set;
        }

        @Override // qf.l, qf.n
        public Collection g(qf.d dVar, pd.k kVar) {
            if (dVar == null) {
                h(13);
            }
            if (kVar == null) {
                h(14);
            }
            Collection collection = (Collection) this.f12419d.invoke();
            if (collection == null) {
                h(15);
            }
            return collection;
        }

        public final Collection l() {
            HashSet hashSet = new HashSet();
            for (ef.f fVar : (Set) this.f12420e.f12415k.invoke()) {
                ne.d dVar = ne.d.f17049p;
                hashSet.addAll(c(fVar, dVar));
                hashSet.addAll(a(fVar, dVar));
            }
            return hashSet;
        }

        public final Collection m(ef.f fVar) {
            if (fVar == null) {
                h(8);
            }
            return p(fVar, o().c(fVar, ne.d.f17049p));
        }

        public final Collection n(ef.f fVar) {
            if (fVar == null) {
                h(4);
            }
            return p(fVar, o().a(fVar, ne.d.f17049p));
        }

        public final qf.k o() {
            qf.k kVarQ = ((xf.r0) this.f12420e.k().c().iterator().next()).q();
            if (kVarQ == null) {
                h(9);
            }
            return kVarQ;
        }

        public final Collection p(ef.f fVar, Collection collection) {
            if (fVar == null) {
                h(10);
            }
            if (collection == null) {
                h(11);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            jf.o.f14337f.v(fVar, collection, Collections.EMPTY_SET, this.f12420e, new d(linkedHashSet));
            return linkedHashSet;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(wf.n nVar, fe.e eVar, xf.r0 r0Var, ef.f fVar, wf.i iVar, ge.h hVar, g1 g1Var) {
        super(nVar, eVar, fVar, g1Var, false);
        if (nVar == null) {
            z0(6);
        }
        if (eVar == null) {
            z0(7);
        }
        if (r0Var == null) {
            z0(8);
        }
        if (fVar == null) {
            z0(9);
        }
        if (iVar == null) {
            z0(10);
        }
        if (hVar == null) {
            z0(11);
        }
        if (g1Var == null) {
            z0(12);
        }
        this.f12416l = hVar;
        this.f12413i = new xf.u(this, Collections.EMPTY_LIST, Collections.singleton(r0Var), nVar);
        this.f12414j = new a(this, nVar);
        this.f12415k = iVar;
    }

    public static q L0(wf.n nVar, fe.e eVar, ef.f fVar, wf.i iVar, ge.h hVar, g1 g1Var) {
        if (nVar == null) {
            z0(0);
        }
        if (eVar == null) {
            z0(1);
        }
        if (fVar == null) {
            z0(2);
        }
        if (iVar == null) {
            z0(3);
        }
        if (hVar == null) {
            z0(4);
        }
        if (g1Var == null) {
            z0(5);
        }
        return new q(nVar, eVar, eVar.s(), fVar, iVar, hVar, g1Var);
    }

    private static /* synthetic */ void z0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 14:
            case 15:
            case 16:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
            case 20:
            case Build.API_LEVELS.API_21 /* 21 */:
            case Build.API_LEVELS.API_22 /* 22 */:
            case Build.API_LEVELS.API_23 /* 23 */:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 14:
            case 15:
            case 16:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
            case 20:
            case Build.API_LEVELS.API_21 /* 21 */:
            case Build.API_LEVELS.API_22 /* 22 */:
            case Build.API_LEVELS.API_23 /* 23 */:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = "name";
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
            case 20:
            case Build.API_LEVELS.API_21 /* 21 */:
            case Build.API_LEVELS.API_22 /* 22 */:
            case Build.API_LEVELS.API_23 /* 23 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i10) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                objArr[1] = "getTypeConstructor";
                break;
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case Build.API_LEVELS.API_21 /* 21 */:
                objArr[1] = "getAnnotations";
                break;
            case Build.API_LEVELS.API_22 /* 22 */:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case Build.API_LEVELS.API_23 /* 23 */:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i10) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
            case 20:
            case Build.API_LEVELS.API_21 /* 21 */:
            case Build.API_LEVELS.API_22 /* 22 */:
            case Build.API_LEVELS.API_23 /* 23 */:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 14:
            case 15:
            case 16:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
            case 20:
            case Build.API_LEVELS.API_21 /* 21 */:
            case Build.API_LEVELS.API_22 /* 22 */:
            case Build.API_LEVELS.API_23 /* 23 */:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // fe.e
    public boolean E() {
        return false;
    }

    @Override // fe.d0
    public boolean E0() {
        return false;
    }

    @Override // fe.e
    public boolean H0() {
        return false;
    }

    @Override // ie.z
    public qf.k I(yf.g gVar) {
        if (gVar == null) {
            z0(13);
        }
        qf.k kVar = this.f12414j;
        if (kVar == null) {
            z0(14);
        }
        return kVar;
    }

    @Override // fe.e
    public Collection K() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            z0(23);
        }
        return list;
    }

    @Override // fe.d0
    public boolean N() {
        return false;
    }

    @Override // fe.i
    public boolean P() {
        return false;
    }

    @Override // fe.e
    public fe.d S() {
        return null;
    }

    @Override // fe.e
    public qf.k T() {
        k.b bVar = k.b.f19087b;
        if (bVar == null) {
            z0(15);
        }
        return bVar;
    }

    @Override // fe.e
    public fe.e V() {
        return null;
    }

    @Override // ge.a
    public ge.h getAnnotations() {
        ge.h hVar = this.f12416l;
        if (hVar == null) {
            z0(21);
        }
        return hVar;
    }

    @Override // fe.e, fe.d0, fe.q
    public fe.u getVisibility() {
        fe.u uVar = fe.t.f9511e;
        if (uVar == null) {
            z0(20);
        }
        return uVar;
    }

    @Override // fe.e
    public fe.f h() {
        fe.f fVar = fe.f.f9476e;
        if (fVar == null) {
            z0(18);
        }
        return fVar;
    }

    @Override // fe.e
    public boolean isInline() {
        return false;
    }

    @Override // fe.h
    public u1 k() {
        u1 u1Var = this.f12413i;
        if (u1Var == null) {
            z0(17);
        }
        return u1Var;
    }

    @Override // fe.e, fe.d0
    public fe.e0 l() {
        fe.e0 e0Var = fe.e0.f9461b;
        if (e0Var == null) {
            z0(19);
        }
        return e0Var;
    }

    @Override // fe.e
    public Collection m() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            z0(16);
        }
        return list;
    }

    @Override // fe.e
    public boolean n() {
        return false;
    }

    public String toString() {
        return "enum entry " + getName();
    }

    @Override // fe.e, fe.i
    public List v() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            z0(22);
        }
        return list;
    }

    @Override // fe.e
    public boolean y() {
        return false;
    }

    @Override // fe.e
    public q1 y0() {
        return null;
    }
}
