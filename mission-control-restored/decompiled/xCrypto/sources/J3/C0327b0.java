package J3;

import H3.e;
import H3.j;
import X2.AbstractC0769p;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import o3.AbstractC1681l;

/* JADX INFO: renamed from: J3.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0327b0 implements H3.e, InterfaceC0339l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C f907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List[] f911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean[] f913h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map f914i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final W2.j f915j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final W2.j f916k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final W2.j f917l;

    /* JADX INFO: renamed from: J3.b0$a */
    public static final class a extends kotlin.jvm.internal.s implements Function0 {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            C0327b0 c0327b0 = C0327b0.this;
            return Integer.valueOf(AbstractC0329c0.a(c0327b0, c0327b0.p()));
        }
    }

    /* JADX INFO: renamed from: J3.b0$b */
    public static final class b extends kotlin.jvm.internal.s implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final F3.b[] invoke() {
            F3.b[] bVarArrChildSerializers;
            C c4 = C0327b0.this.f907b;
            return (c4 == null || (bVarArrChildSerializers = c4.childSerializers()) == null) ? AbstractC0331d0.f922a : bVarArrChildSerializers;
        }
    }

    /* JADX INFO: renamed from: J3.b0$c */
    public static final class c extends kotlin.jvm.internal.s implements i3.k {
        public c() {
            super(1);
        }

        public final CharSequence a(int i4) {
            return C0327b0.this.g(i4) + ": " + C0327b0.this.i(i4).a();
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: J3.b0$d */
    public static final class d extends kotlin.jvm.internal.s implements Function0 {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final H3.e[] invoke() {
            ArrayList arrayList;
            F3.b[] bVarArrTypeParametersSerializers;
            C c4 = C0327b0.this.f907b;
            if (c4 == null || (bVarArrTypeParametersSerializers = c4.typeParametersSerializers()) == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(bVarArrTypeParametersSerializers.length);
                for (F3.b bVar : bVarArrTypeParametersSerializers) {
                    arrayList.add(bVar.getDescriptor());
                }
            }
            return Z.b(arrayList);
        }
    }

    public C0327b0(String serialName, C c4, int i4) {
        kotlin.jvm.internal.r.f(serialName, "serialName");
        this.f906a = serialName;
        this.f907b = c4;
        this.f908c = i4;
        this.f909d = -1;
        String[] strArr = new String[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            strArr[i5] = "[UNINITIALIZED]";
        }
        this.f910e = strArr;
        int i6 = this.f908c;
        this.f911f = new List[i6];
        this.f913h = new boolean[i6];
        this.f914i = X2.L.e();
        W2.l lVar = W2.l.f5481b;
        this.f915j = W2.k.a(lVar, new b());
        this.f916k = W2.k.a(lVar, new d());
        this.f917l = W2.k.a(lVar, new a());
    }

    public static /* synthetic */ void m(C0327b0 c0327b0, String str, boolean z4, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
        }
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        c0327b0.l(str, z4);
    }

    private final int q() {
        return ((Number) this.f917l.getValue()).intValue();
    }

    @Override // H3.e
    public String a() {
        return this.f906a;
    }

    @Override // J3.InterfaceC0339l
    public Set b() {
        return this.f914i.keySet();
    }

    @Override // H3.e
    public boolean c() {
        return e.a.c(this);
    }

    @Override // H3.e
    public int d(String name) {
        kotlin.jvm.internal.r.f(name, "name");
        Integer num = (Integer) this.f914i.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // H3.e
    public H3.i e() {
        return j.a.f766a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0327b0)) {
            return false;
        }
        H3.e eVar = (H3.e) obj;
        if (!kotlin.jvm.internal.r.b(a(), eVar.a()) || !Arrays.equals(p(), ((C0327b0) obj).p()) || f() != eVar.f()) {
            return false;
        }
        int iF = f();
        for (int i4 = 0; i4 < iF; i4++) {
            if (!kotlin.jvm.internal.r.b(i(i4).a(), eVar.i(i4).a()) || !kotlin.jvm.internal.r.b(i(i4).e(), eVar.i(i4).e())) {
                return false;
            }
        }
        return true;
    }

    @Override // H3.e
    public final int f() {
        return this.f908c;
    }

    @Override // H3.e
    public String g(int i4) {
        return this.f910e[i4];
    }

    @Override // H3.e
    public List getAnnotations() {
        List list = this.f912g;
        return list == null ? AbstractC0769p.g() : list;
    }

    @Override // H3.e
    public List h(int i4) {
        List list = this.f911f[i4];
        return list == null ? AbstractC0769p.g() : list;
    }

    public int hashCode() {
        return q();
    }

    @Override // H3.e
    public H3.e i(int i4) {
        return o()[i4].getDescriptor();
    }

    @Override // H3.e
    public boolean isInline() {
        return e.a.b(this);
    }

    @Override // H3.e
    public boolean j(int i4) {
        return this.f913h[i4];
    }

    public final void l(String name, boolean z4) {
        kotlin.jvm.internal.r.f(name, "name");
        String[] strArr = this.f910e;
        int i4 = this.f909d + 1;
        this.f909d = i4;
        strArr[i4] = name;
        this.f913h[i4] = z4;
        this.f911f[i4] = null;
        if (i4 == this.f908c - 1) {
            this.f914i = n();
        }
    }

    public final Map n() {
        HashMap map = new HashMap();
        int length = this.f910e.length;
        for (int i4 = 0; i4 < length; i4++) {
            map.put(this.f910e[i4], Integer.valueOf(i4));
        }
        return map;
    }

    public final F3.b[] o() {
        return (F3.b[]) this.f915j.getValue();
    }

    public final H3.e[] p() {
        return (H3.e[]) this.f916k.getValue();
    }

    public final void r(Annotation annotation) {
        kotlin.jvm.internal.r.f(annotation, "annotation");
        List arrayList = this.f911f[this.f909d];
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            this.f911f[this.f909d] = arrayList;
        }
        arrayList.add(annotation);
    }

    public final void s(Annotation a4) {
        kotlin.jvm.internal.r.f(a4, "a");
        if (this.f912g == null) {
            this.f912g = new ArrayList(1);
        }
        List list = this.f912g;
        kotlin.jvm.internal.r.c(list);
        list.add(a4);
    }

    public String toString() {
        return X2.x.Q(AbstractC1681l.l(0, this.f908c), ", ", a() + '(', ")", 0, null, new c(), 24, null);
    }

    public /* synthetic */ C0327b0(String str, C c4, int i4, int i5, AbstractC1585j abstractC1585j) {
        this(str, (i5 & 2) != 0 ? null : c4, i4);
    }
}
