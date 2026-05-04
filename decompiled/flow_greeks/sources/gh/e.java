package gh;

import dd.r;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public /* synthetic */ e(k kVar) {
        this();
    }

    public static /* synthetic */ zg.b c(e eVar, wd.d dVar, List list, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
        }
        if ((i10 & 2) != 0) {
            list = r.k();
        }
        return eVar.b(dVar, list);
    }

    public abstract void a(i iVar);

    public abstract zg.b b(wd.d dVar, List list);

    public abstract zg.a d(wd.d dVar, String str);

    public abstract zg.k e(wd.d dVar, Object obj);

    public e() {
    }
}
