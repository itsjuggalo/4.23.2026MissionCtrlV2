package n5;

import F5.AbstractC0556n;
import java.util.List;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class M {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f19855c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final K f19857b;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final M a(List pigeonVar_list) {
            kotlin.jvm.internal.r.f(pigeonVar_list, "pigeonVar_list");
            String str = (String) pigeonVar_list.get(0);
            Object obj = pigeonVar_list.get(1);
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.StringListLookupResultType");
            return new M(str, (K) obj);
        }

        public a() {
        }
    }

    public M(String str, K type) {
        kotlin.jvm.internal.r.f(type, "type");
        this.f19856a = str;
        this.f19857b = type;
    }

    public final List a() {
        return AbstractC0556n.j(this.f19856a, this.f19857b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof M)) {
            return false;
        }
        M m7 = (M) obj;
        return kotlin.jvm.internal.r.b(this.f19856a, m7.f19856a) && this.f19857b == m7.f19857b;
    }

    public int hashCode() {
        String str = this.f19856a;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.f19857b.hashCode();
    }

    public String toString() {
        return "StringListResult(jsonEncodedValue=" + this.f19856a + ", type=" + this.f19857b + ")";
    }
}
