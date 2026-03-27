package n6;

import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import l6.w;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21675b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f21676c = new h(AbstractC2595q.i());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f21677a;

    public static final class a {
        public a() {
        }

        public final h a(w table) {
            AbstractC2304t.f(table, "table");
            if (table.w() == 0) {
                return b();
            }
            List listX = table.x();
            AbstractC2304t.e(listX, "getRequirementList(...)");
            return new h(listX, null);
        }

        public final h b() {
            return h.f21676c;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public h(List list) {
        this.f21677a = list;
    }

    public /* synthetic */ h(List list, AbstractC2296k abstractC2296k) {
        this(list);
    }
}
