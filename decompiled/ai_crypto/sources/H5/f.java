package H5;

import E5.E;
import E5.p;
import Q5.o;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {
    public static final void a(o oVar, Object obj, d completion) {
        r.f(oVar, "<this>");
        r.f(completion, "completion");
        d dVarC = I5.b.c(I5.b.a(oVar, obj, completion));
        p.a aVar = p.f1681b;
        dVarC.resumeWith(p.b(E.f1657a));
    }
}
