package bf;

import dd.r;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import ze.w;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3348b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f3349c = new h(r.k());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3350a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public final h a(w table) {
            t.f(table, "table");
            if (table.v() == 0) {
                return b();
            }
            List listW = table.w();
            t.e(listW, "getRequirementList(...)");
            return new h(listW, null);
        }

        public final h b() {
            return h.f3349c;
        }

        public a() {
        }
    }

    public /* synthetic */ h(List list, k kVar) {
        this(list);
    }

    public h(List list) {
        this.f3350a = list;
    }
}
