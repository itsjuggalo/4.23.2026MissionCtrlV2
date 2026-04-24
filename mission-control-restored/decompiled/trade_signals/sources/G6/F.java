package G6;

import G6.w;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public class F implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w.b f3262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f3263b;

    public F(w.b bVar, w wVar) {
        this.f3262a = bVar;
        this.f3263b = wVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return w.b.D(this.f3262a, this.f3263b);
    }
}
