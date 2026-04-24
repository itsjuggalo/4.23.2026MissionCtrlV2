package G6;

import G6.w;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public class G implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w.b f3264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f3265b;

    public G(w.b bVar, w wVar) {
        this.f3264a = bVar;
        this.f3265b = wVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return w.b.P(this.f3264a, this.f3265b);
    }
}
