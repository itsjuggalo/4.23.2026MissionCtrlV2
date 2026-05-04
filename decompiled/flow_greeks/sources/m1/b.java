package m1;

import kotlin.jvm.internal.t;
import l1.d;
import l1.e;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f15738a;

    public b(k produceNewData) {
        t.f(produceNewData, "produceNewData");
        this.f15738a = produceNewData;
    }

    @Override // l1.e
    public Object a(d dVar, gd.e eVar) {
        return this.f15738a.invoke(dVar);
    }
}
