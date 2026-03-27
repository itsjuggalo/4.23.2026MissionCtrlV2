package J3;

import H3.i;
import H3.j;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: J3.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0349w extends C0327b0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final H3.i f985m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final W2.j f986n;

    /* JADX INFO: renamed from: J3.w$a */
    public static final class a extends kotlin.jvm.internal.s implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ C0349w f989c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i4, String str, C0349w c0349w) {
            super(0);
            this.f987a = i4;
            this.f988b = str;
            this.f989c = c0349w;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final H3.e[] invoke() {
            int i4 = this.f987a;
            H3.e[] eVarArr = new H3.e[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                eVarArr[i5] = H3.h.d(this.f988b + com.amazon.a.a.o.c.a.b.f8816a + this.f989c.g(i5), j.d.f769a, new H3.e[0], null, 8, null);
            }
            return eVarArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0349w(String name, int i4) {
        super(name, null, i4, 2, null);
        kotlin.jvm.internal.r.f(name, "name");
        this.f985m = i.b.f765a;
        this.f986n = W2.k.b(new a(i4, name, this));
    }

    @Override // J3.C0327b0, H3.e
    public H3.i e() {
        return this.f985m;
    }

    @Override // J3.C0327b0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof H3.e)) {
            return false;
        }
        H3.e eVar = (H3.e) obj;
        return eVar.e() == i.b.f765a && kotlin.jvm.internal.r.b(a(), eVar.a()) && kotlin.jvm.internal.r.b(Z.a(this), Z.a(eVar));
    }

    @Override // J3.C0327b0
    public int hashCode() {
        int iHashCode = a().hashCode();
        int iHashCode2 = 1;
        for (String str : H3.g.b(this)) {
            int i4 = iHashCode2 * 31;
            iHashCode2 = i4 + (str != null ? str.hashCode() : 0);
        }
        return (iHashCode * 31) + iHashCode2;
    }

    @Override // J3.C0327b0, H3.e
    public H3.e i(int i4) {
        return t()[i4];
    }

    public final H3.e[] t() {
        return (H3.e[]) this.f986n.getValue();
    }

    @Override // J3.C0327b0
    public String toString() {
        return X2.x.Q(H3.g.b(this), ", ", a() + '(', ")", 0, null, null, 56, null);
    }
}
