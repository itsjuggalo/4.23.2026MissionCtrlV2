package df;

import cf.a;
import dd.a0;
import dd.u0;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a.e f8102h;

    /* JADX WARN: Illegal instructions before constructor call */
    public f(a.e types, String[] strings) {
        Set setN0;
        t.f(types, "types");
        t.f(strings, "strings");
        List listX = types.x();
        if (listX.isEmpty()) {
            setN0 = u0.d();
        } else {
            t.c(listX);
            setN0 = a0.N0(listX);
        }
        List listY = types.y();
        t.e(listY, "getRecordList(...)");
        super(strings, setN0, h.a(listY));
        this.f8102h = types;
    }
}
