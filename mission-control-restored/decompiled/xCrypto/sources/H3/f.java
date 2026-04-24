package H3;

import H3.e;
import J3.AbstractC0329c0;
import J3.InterfaceC0339l;
import J3.Z;
import W2.t;
import X2.AbstractC0765l;
import X2.AbstractC0770q;
import X2.D;
import X2.L;
import X2.x;
import i3.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements e, InterfaceC0339l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String[] f748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e[] f749g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List[] f750h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean[] f751i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f752j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e[] f753k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final W2.j f754l;

    public static final class a extends s implements Function0 {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            f fVar = f.this;
            return Integer.valueOf(AbstractC0329c0.a(fVar, fVar.f753k));
        }
    }

    public static final class b extends s implements k {
        public b() {
            super(1);
        }

        public final CharSequence a(int i4) {
            return f.this.g(i4) + ": " + f.this.i(i4).a();
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public f(String serialName, i kind, int i4, List typeParameters, H3.a builder) {
        r.f(serialName, "serialName");
        r.f(kind, "kind");
        r.f(typeParameters, "typeParameters");
        r.f(builder, "builder");
        this.f743a = serialName;
        this.f744b = kind;
        this.f745c = i4;
        this.f746d = builder.c();
        this.f747e = x.e0(builder.f());
        String[] strArr = (String[]) builder.f().toArray(new String[0]);
        this.f748f = strArr;
        this.f749g = Z.b(builder.e());
        this.f750h = (List[]) builder.d().toArray(new List[0]);
        this.f751i = x.b0(builder.g());
        Iterable<D> iterableT0 = AbstractC0765l.t0(strArr);
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(iterableT0, 10));
        for (D d4 : iterableT0) {
            arrayList.add(t.a(d4.b(), Integer.valueOf(d4.a())));
        }
        this.f752j = L.o(arrayList);
        this.f753k = Z.b(typeParameters);
        this.f754l = W2.k.b(new a());
    }

    @Override // H3.e
    public String a() {
        return this.f743a;
    }

    @Override // J3.InterfaceC0339l
    public Set b() {
        return this.f747e;
    }

    @Override // H3.e
    public boolean c() {
        return e.a.c(this);
    }

    @Override // H3.e
    public int d(String name) {
        r.f(name, "name");
        Integer num = (Integer) this.f752j.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // H3.e
    public i e() {
        return this.f744b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        e eVar = (e) obj;
        if (!r.b(a(), eVar.a()) || !Arrays.equals(this.f753k, ((f) obj).f753k) || f() != eVar.f()) {
            return false;
        }
        int iF = f();
        for (int i4 = 0; i4 < iF; i4++) {
            if (!r.b(i(i4).a(), eVar.i(i4).a()) || !r.b(i(i4).e(), eVar.i(i4).e())) {
                return false;
            }
        }
        return true;
    }

    @Override // H3.e
    public int f() {
        return this.f745c;
    }

    @Override // H3.e
    public String g(int i4) {
        return this.f748f[i4];
    }

    @Override // H3.e
    public List getAnnotations() {
        return this.f746d;
    }

    @Override // H3.e
    public List h(int i4) {
        return this.f750h[i4];
    }

    public int hashCode() {
        return l();
    }

    @Override // H3.e
    public e i(int i4) {
        return this.f749g[i4];
    }

    @Override // H3.e
    public boolean isInline() {
        return e.a.b(this);
    }

    @Override // H3.e
    public boolean j(int i4) {
        return this.f751i[i4];
    }

    public final int l() {
        return ((Number) this.f754l.getValue()).intValue();
    }

    public String toString() {
        return x.Q(AbstractC1681l.l(0, f()), ", ", a() + '(', ")", 0, null, new b(), 24, null);
    }
}
