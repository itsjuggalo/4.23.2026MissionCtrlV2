package G6;

import G6.w;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public class K implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w.c f3269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f3270b;

    public K(w.c cVar, w wVar) {
        this.f3269a = cVar;
        this.f3270b = wVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return w.c.p(this.f3269a, this.f3270b);
    }
}
