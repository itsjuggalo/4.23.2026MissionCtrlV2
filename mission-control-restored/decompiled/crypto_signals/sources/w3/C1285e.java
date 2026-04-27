package w3;

import java.util.Date;

/* JADX INFO: renamed from: w3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1285e implements t3.t {
    @Override // t3.t
    public final t3.s create(t3.e eVar, A3.a aVar) {
        if (aVar.f61a == Date.class) {
            return new C1288h(AbstractC1287g.f10755a);
        }
        return null;
    }

    public final String toString() {
        return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
    }
}
