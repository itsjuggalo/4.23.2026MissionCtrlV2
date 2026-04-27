package M3;

import X2.AbstractC0769p;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public /* synthetic */ e(AbstractC1585j abstractC1585j) {
        this();
    }

    public static /* synthetic */ F3.b c(e eVar, InterfaceC1716c interfaceC1716c, List list, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
        }
        if ((i4 & 2) != 0) {
            list = AbstractC0769p.g();
        }
        return eVar.b(interfaceC1716c, list);
    }

    public abstract void a(h hVar);

    public abstract F3.b b(InterfaceC1716c interfaceC1716c, List list);

    public abstract F3.a d(InterfaceC1716c interfaceC1716c, String str);

    public abstract F3.h e(InterfaceC1716c interfaceC1716c, Object obj);

    public e() {
    }
}
