package r7;

import java.util.List;
import k7.k;
import kotlin.jvm.internal.AbstractC2296k;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public e() {
    }

    public static /* synthetic */ k7.b c(e eVar, I5.d dVar, List list, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
        }
        if ((i8 & 2) != 0) {
            list = AbstractC2595q.i();
        }
        return eVar.b(dVar, list);
    }

    public abstract void a(i iVar);

    public abstract k7.b b(I5.d dVar, List list);

    public abstract k7.a d(I5.d dVar, String str);

    public abstract k e(I5.d dVar, Object obj);

    public /* synthetic */ e(AbstractC2296k abstractC2296k) {
        this();
    }
}
