package G6;

import G6.w;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public class L implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w.c f3271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f3272b;

    public L(w.c cVar, w wVar) {
        this.f3271a = cVar;
        this.f3272b = wVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return w.c.u(this.f3271a, this.f3272b);
    }
}
