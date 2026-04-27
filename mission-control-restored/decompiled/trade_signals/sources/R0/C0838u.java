package R0;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: R0.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0838u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.internal.play_billing.N f7072a;

    /* JADX INFO: renamed from: R0.u$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.google.android.gms.internal.play_billing.N f7073a;

        public /* synthetic */ a(G0 g02) {
        }

        public C0838u a() {
            if (this.f7073a != null) {
                return new C0838u(this, null);
            }
            throw new IllegalArgumentException("Product list must be set to a non empty list.");
        }

        public a b(List list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Product list cannot be empty.");
            }
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (!"play_pass_subs".equals(bVar.c())) {
                    hashSet.add(bVar.c());
                }
            }
            if (hashSet.size() > 1) {
                throw new IllegalArgumentException("All products should be of the same product type.");
            }
            this.f7073a = com.google.android.gms.internal.play_billing.N.H(list);
            return this;
        }
    }

    /* JADX INFO: renamed from: R0.u$b */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7075b;

        /* JADX INFO: renamed from: R0.u$b$a */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f7076a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f7077b;

            public /* synthetic */ a(G0 g02) {
            }

            public b a() {
                if ("first_party".equals(this.f7077b)) {
                    throw new IllegalArgumentException("Serialized doc id must be provided for first party products.");
                }
                if (this.f7076a == null) {
                    throw new IllegalArgumentException("Product id must be provided.");
                }
                if (this.f7077b != null) {
                    return new b(this, null);
                }
                throw new IllegalArgumentException("Product type must be provided.");
            }

            public a b(String str) {
                this.f7076a = str;
                return this;
            }

            public a c(String str) {
                this.f7077b = str;
                return this;
            }
        }

        public /* synthetic */ b(a aVar, G0 g02) {
            this.f7074a = aVar.f7076a;
            this.f7075b = aVar.f7077b;
        }

        public static a a() {
            return new a(null);
        }

        public final String b() {
            return this.f7074a;
        }

        public final String c() {
            return this.f7075b;
        }
    }

    public /* synthetic */ C0838u(a aVar, G0 g02) {
        this.f7072a = aVar.f7073a;
    }

    public static a a() {
        return new a(null);
    }

    public final com.google.android.gms.internal.play_billing.N b() {
        return this.f7072a;
    }

    public final String c() {
        return ((b) this.f7072a.get(0)).c();
    }
}
