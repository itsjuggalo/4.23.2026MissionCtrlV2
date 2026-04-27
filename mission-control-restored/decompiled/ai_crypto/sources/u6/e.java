package u6;

import F5.AbstractC0556n;
import java.util.List;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public /* synthetic */ e(AbstractC2148j abstractC2148j) {
        this();
    }

    public static /* synthetic */ n6.b c(e eVar, X5.c cVar, List list, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
        }
        if ((i7 & 2) != 0) {
            list = AbstractC0556n.g();
        }
        return eVar.b(cVar, list);
    }

    public abstract void a(h hVar);

    public abstract n6.b b(X5.c cVar, List list);

    public abstract n6.a d(X5.c cVar, String str);

    public abstract n6.h e(X5.c cVar, Object obj);

    public e() {
    }
}
