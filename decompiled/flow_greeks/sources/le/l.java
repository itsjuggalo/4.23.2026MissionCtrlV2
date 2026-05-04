package le;

import java.util.ArrayList;
import java.util.List;
import le.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends h implements ve.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f15629c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(ef.f fVar, Object[] values) {
        super(fVar, null);
        kotlin.jvm.internal.t.f(values, "values");
        this.f15629c = values;
    }

    @Override // ve.e
    public List e() {
        Object[] objArr = this.f15629c;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            h.a aVar = h.f15623b;
            kotlin.jvm.internal.t.c(obj);
            arrayList.add(aVar.a(obj, null));
        }
        return arrayList;
    }
}
