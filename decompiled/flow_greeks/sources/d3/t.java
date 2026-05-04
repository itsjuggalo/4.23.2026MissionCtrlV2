package d3;

import com.google.android.gms.internal.play_billing.zzbt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzbt f7790a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public zzbt f7791a;

        public /* synthetic */ a(e2 e2Var) {
        }

        public t a() {
            if (this.f7791a != null) {
                return new t(this, null);
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
            this.f7791a = zzbt.zzj(list);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7793b;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f7794a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f7795b;

            public /* synthetic */ a(e2 e2Var) {
            }

            public b a() {
                if ("first_party".equals(this.f7795b)) {
                    throw new IllegalArgumentException("Serialized doc id must be provided for first party products.");
                }
                if (this.f7794a == null) {
                    throw new IllegalArgumentException("Product id must be provided.");
                }
                if (this.f7795b != null) {
                    return new b(this, null);
                }
                throw new IllegalArgumentException("Product type must be provided.");
            }

            public a b(String str) {
                this.f7794a = str;
                return this;
            }

            public a c(String str) {
                this.f7795b = str;
                return this;
            }
        }

        public /* synthetic */ b(a aVar, e2 e2Var) {
            this.f7792a = aVar.f7794a;
            this.f7793b = aVar.f7795b;
        }

        public static a a() {
            return new a(null);
        }

        public final String b() {
            return this.f7792a;
        }

        public final String c() {
            return this.f7793b;
        }
    }

    public /* synthetic */ t(a aVar, e2 e2Var) {
        this.f7790a = aVar.f7791a;
    }

    public static a a() {
        return new a(null);
    }

    public final zzbt b() {
        return this.f7790a;
    }

    public final String c() {
        return ((b) this.f7790a.get(0)).c();
    }
}
