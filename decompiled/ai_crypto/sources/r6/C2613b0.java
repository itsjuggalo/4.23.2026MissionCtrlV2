package r6;

import F5.AbstractC0556n;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import p6.e;
import p6.j;

/* JADX INFO: renamed from: r6.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2613b0 implements p6.e, InterfaceC2625l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C f22864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f22867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List[] f22868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f22869g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean[] f22870h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map f22871i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final E5.j f22872j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final E5.j f22873k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final E5.j f22874l;

    /* JADX INFO: renamed from: r6.b0$a */
    public static final class a extends kotlin.jvm.internal.s implements Function0 {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            C2613b0 c2613b0 = C2613b0.this;
            return Integer.valueOf(AbstractC2615c0.a(c2613b0, c2613b0.p()));
        }
    }

    /* JADX INFO: renamed from: r6.b0$b */
    public static final class b extends kotlin.jvm.internal.s implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n6.b[] invoke() {
            n6.b[] bVarArrChildSerializers;
            C c7 = C2613b0.this.f22864b;
            return (c7 == null || (bVarArrChildSerializers = c7.childSerializers()) == null) ? AbstractC2617d0.f22879a : bVarArrChildSerializers;
        }
    }

    /* JADX INFO: renamed from: r6.b0$c */
    public static final class c extends kotlin.jvm.internal.s implements Q5.k {
        public c() {
            super(1);
        }

        public final CharSequence a(int i7) {
            return C2613b0.this.g(i7) + ": " + C2613b0.this.i(i7).a();
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: r6.b0$d */
    public static final class d extends kotlin.jvm.internal.s implements Function0 {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p6.e[] invoke() {
            ArrayList arrayList;
            n6.b[] bVarArrTypeParametersSerializers;
            C c7 = C2613b0.this.f22864b;
            if (c7 == null || (bVarArrTypeParametersSerializers = c7.typeParametersSerializers()) == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(bVarArrTypeParametersSerializers.length);
                for (n6.b bVar : bVarArrTypeParametersSerializers) {
                    arrayList.add(bVar.getDescriptor());
                }
            }
            return Z.b(arrayList);
        }
    }

    public C2613b0(String serialName, C c7, int i7) {
        kotlin.jvm.internal.r.f(serialName, "serialName");
        this.f22863a = serialName;
        this.f22864b = c7;
        this.f22865c = i7;
        this.f22866d = -1;
        String[] strArr = new String[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            strArr[i8] = "[UNINITIALIZED]";
        }
        this.f22867e = strArr;
        int i9 = this.f22865c;
        this.f22868f = new List[i9];
        this.f22870h = new boolean[i9];
        this.f22871i = F5.J.e();
        E5.l lVar = E5.l.f1675b;
        this.f22872j = E5.k.a(lVar, new b());
        this.f22873k = E5.k.a(lVar, new d());
        this.f22874l = E5.k.a(lVar, new a());
    }

    public static /* synthetic */ void m(C2613b0 c2613b0, String str, boolean z7, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
        }
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        c2613b0.l(str, z7);
    }

    private final int q() {
        return ((Number) this.f22874l.getValue()).intValue();
    }

    @Override // p6.e
    public String a() {
        return this.f22863a;
    }

    @Override // r6.InterfaceC2625l
    public Set b() {
        return this.f22871i.keySet();
    }

    @Override // p6.e
    public boolean c() {
        return e.a.c(this);
    }

    @Override // p6.e
    public int d(String name) {
        kotlin.jvm.internal.r.f(name, "name");
        Integer num = (Integer) this.f22871i.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // p6.e
    public p6.i e() {
        return j.a.f22094a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2613b0) {
            p6.e eVar = (p6.e) obj;
            if (kotlin.jvm.internal.r.b(a(), eVar.a()) && Arrays.equals(p(), ((C2613b0) obj).p()) && f() == eVar.f()) {
                int iF = f();
                for (int i7 = 0; i7 < iF; i7++) {
                    if (kotlin.jvm.internal.r.b(i(i7).a(), eVar.i(i7).a()) && kotlin.jvm.internal.r.b(i(i7).e(), eVar.i(i7).e())) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // p6.e
    public final int f() {
        return this.f22865c;
    }

    @Override // p6.e
    public String g(int i7) {
        return this.f22867e[i7];
    }

    @Override // p6.e
    public List getAnnotations() {
        List list = this.f22869g;
        return list == null ? AbstractC0556n.g() : list;
    }

    @Override // p6.e
    public List h(int i7) {
        List list = this.f22868f[i7];
        return list == null ? AbstractC0556n.g() : list;
    }

    public int hashCode() {
        return q();
    }

    @Override // p6.e
    public p6.e i(int i7) {
        return o()[i7].getDescriptor();
    }

    @Override // p6.e
    public boolean isInline() {
        return e.a.b(this);
    }

    @Override // p6.e
    public boolean j(int i7) {
        return this.f22870h[i7];
    }

    public final void l(String name, boolean z7) {
        kotlin.jvm.internal.r.f(name, "name");
        String[] strArr = this.f22867e;
        int i7 = this.f22866d + 1;
        this.f22866d = i7;
        strArr[i7] = name;
        this.f22870h[i7] = z7;
        this.f22868f[i7] = null;
        if (i7 == this.f22865c - 1) {
            this.f22871i = n();
        }
    }

    public final Map n() {
        HashMap map = new HashMap();
        int length = this.f22867e.length;
        for (int i7 = 0; i7 < length; i7++) {
            map.put(this.f22867e[i7], Integer.valueOf(i7));
        }
        return map;
    }

    public final n6.b[] o() {
        return (n6.b[]) this.f22872j.getValue();
    }

    public final p6.e[] p() {
        return (p6.e[]) this.f22873k.getValue();
    }

    public final void r(Annotation annotation) {
        kotlin.jvm.internal.r.f(annotation, "annotation");
        List arrayList = this.f22868f[this.f22866d];
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            this.f22868f[this.f22866d] = arrayList;
        }
        arrayList.add(annotation);
    }

    public final void s(Annotation a7) {
        kotlin.jvm.internal.r.f(a7, "a");
        if (this.f22869g == null) {
            this.f22869g = new ArrayList(1);
        }
        List list = this.f22869g;
        kotlin.jvm.internal.r.c(list);
        list.add(a7);
    }

    public String toString() {
        return F5.v.R(W5.l.l(0, this.f22865c), ", ", a() + '(', ")", 0, null, new c(), 24, null);
    }

    public /* synthetic */ C2613b0(String str, C c7, int i7, int i8, AbstractC2148j abstractC2148j) {
        this(str, (i8 & 2) != 0 ? null : c7, i7);
    }
}
