package n5;

import F5.AbstractC0556n;
import java.util.List;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class H {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f19718c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19720b;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final H a(List pigeonVar_list) {
            kotlin.jvm.internal.r.f(pigeonVar_list, "pigeonVar_list");
            String str = (String) pigeonVar_list.get(0);
            Object obj = pigeonVar_list.get(1);
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
            return new H(str, ((Boolean) obj).booleanValue());
        }

        public a() {
        }
    }

    public H(String str, boolean z7) {
        this.f19719a = str;
        this.f19720b = z7;
    }

    public final String a() {
        return this.f19719a;
    }

    public final List b() {
        return AbstractC0556n.j(this.f19719a, Boolean.valueOf(this.f19720b));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H)) {
            return false;
        }
        H h7 = (H) obj;
        return kotlin.jvm.internal.r.b(this.f19719a, h7.f19719a) && this.f19720b == h7.f19720b;
    }

    public int hashCode() {
        String str = this.f19719a;
        return ((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.f19720b);
    }

    public String toString() {
        return "SharedPreferencesPigeonOptions(fileName=" + this.f19719a + ", useDataStore=" + this.f19720b + ")";
    }
}
