package dh;

import bh.e;
import bh.m;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class j1 implements bh.e, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f8165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f8168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List[] f8169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f8170g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean[] f8171h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map f8172i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final cd.k f8173j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final cd.k f8174k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final cd.k f8175l;

    public j1(String serialName, e0 e0Var, int i10) {
        kotlin.jvm.internal.t.f(serialName, "serialName");
        this.f8164a = serialName;
        this.f8165b = e0Var;
        this.f8166c = i10;
        this.f8167d = -1;
        String[] strArr = new String[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            strArr[i11] = "[UNINITIALIZED]";
        }
        this.f8168e = strArr;
        int i12 = this.f8166c;
        this.f8169f = new List[i12];
        this.f8171h = new boolean[i12];
        this.f8172i = dd.o0.h();
        cd.n nVar = cd.n.f3864b;
        this.f8173j = cd.l.a(nVar, new Function0() { // from class: dh.g1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return j1.s(this.f8146a);
            }
        });
        this.f8174k = cd.l.a(nVar, new Function0() { // from class: dh.h1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return j1.z(this.f8153a);
            }
        });
        this.f8175l = cd.l.a(nVar, new Function0() { // from class: dh.i1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(j1.f(this.f8159a));
            }
        });
    }

    public static final int f(j1 j1Var) {
        return k1.a(j1Var, j1Var.u());
    }

    public static /* synthetic */ void q(j1 j1Var, String str, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        j1Var.g(str, z10);
    }

    public static final zg.b[] s(j1 j1Var) {
        zg.b[] bVarArrChildSerializers;
        e0 e0Var = j1Var.f8165b;
        return (e0Var == null || (bVarArrChildSerializers = e0Var.childSerializers()) == null) ? l1.f8182a : bVarArrChildSerializers;
    }

    private final int v() {
        return ((Number) this.f8175l.getValue()).intValue();
    }

    public static final CharSequence y(j1 j1Var, int i10) {
        return j1Var.m(i10) + ": " + j1Var.o(i10).i();
    }

    public static final bh.e[] z(j1 j1Var) {
        ArrayList arrayList;
        zg.b[] bVarArrTypeParametersSerializers;
        e0 e0Var = j1Var.f8165b;
        if (e0Var == null || (bVarArrTypeParametersSerializers = e0Var.typeParametersSerializers()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(bVarArrTypeParametersSerializers.length);
            for (zg.b bVar : bVarArrTypeParametersSerializers) {
                arrayList.add(bVar.getDescriptor());
            }
        }
        return d1.b(arrayList);
    }

    @Override // dh.l
    public Set a() {
        return this.f8172i.keySet();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j1)) {
            return false;
        }
        bh.e eVar = (bh.e) obj;
        if (!kotlin.jvm.internal.t.b(i(), eVar.i()) || !Arrays.equals(u(), ((j1) obj).u()) || l() != eVar.l()) {
            return false;
        }
        int iL = l();
        for (int i10 = 0; i10 < iL; i10++) {
            if (!kotlin.jvm.internal.t.b(o(i10).i(), eVar.o(i10).i()) || !kotlin.jvm.internal.t.b(o(i10).h(), eVar.o(i10).h())) {
                return false;
            }
        }
        return true;
    }

    public final void g(String name, boolean z10) {
        kotlin.jvm.internal.t.f(name, "name");
        String[] strArr = this.f8168e;
        int i10 = this.f8167d + 1;
        this.f8167d = i10;
        strArr[i10] = name;
        this.f8171h[i10] = z10;
        this.f8169f[i10] = null;
        if (i10 == this.f8166c - 1) {
            this.f8172i = r();
        }
    }

    @Override // bh.e
    public List getAnnotations() {
        List list = this.f8170g;
        return list == null ? dd.r.k() : list;
    }

    @Override // bh.e
    public bh.l h() {
        return m.a.f3402a;
    }

    public int hashCode() {
        return v();
    }

    @Override // bh.e
    public String i() {
        return this.f8164a;
    }

    @Override // bh.e
    public boolean isInline() {
        return e.a.b(this);
    }

    @Override // bh.e
    public boolean j() {
        return e.a.c(this);
    }

    @Override // bh.e
    public int k(String name) {
        kotlin.jvm.internal.t.f(name, "name");
        Integer num = (Integer) this.f8172i.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // bh.e
    public final int l() {
        return this.f8166c;
    }

    @Override // bh.e
    public String m(int i10) {
        return this.f8168e[i10];
    }

    @Override // bh.e
    public List n(int i10) {
        List list = this.f8169f[i10];
        return list == null ? dd.r.k() : list;
    }

    @Override // bh.e
    public bh.e o(int i10) {
        return t()[i10].getDescriptor();
    }

    @Override // bh.e
    public boolean p(int i10) {
        return this.f8171h[i10];
    }

    public final Map r() {
        HashMap map = new HashMap();
        int length = this.f8168e.length;
        for (int i10 = 0; i10 < length; i10++) {
            map.put(this.f8168e[i10], Integer.valueOf(i10));
        }
        return map;
    }

    public final zg.b[] t() {
        return (zg.b[]) this.f8173j.getValue();
    }

    public String toString() {
        return dd.a0.i0(vd.l.l(0, this.f8166c), ", ", i() + '(', ")", 0, null, new pd.k() { // from class: dh.f1
            @Override // pd.k
            public final Object invoke(Object obj) {
                return j1.y(this.f8142a, ((Integer) obj).intValue());
            }
        }, 24, null);
    }

    public final bh.e[] u() {
        return (bh.e[]) this.f8174k.getValue();
    }

    public final void w(Annotation annotation) {
        kotlin.jvm.internal.t.f(annotation, "annotation");
        List arrayList = this.f8169f[this.f8167d];
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            this.f8169f[this.f8167d] = arrayList;
        }
        arrayList.add(annotation);
    }

    public final void x(Annotation a10) {
        kotlin.jvm.internal.t.f(a10, "a");
        if (this.f8170g == null) {
            this.f8170g = new ArrayList(1);
        }
        List list = this.f8170g;
        kotlin.jvm.internal.t.c(list);
        list.add(a10);
    }

    public /* synthetic */ j1(String str, e0 e0Var, int i10, int i11, kotlin.jvm.internal.k kVar) {
        this(str, (i11 & 2) != 0 ? null : e0Var, i10);
    }
}
