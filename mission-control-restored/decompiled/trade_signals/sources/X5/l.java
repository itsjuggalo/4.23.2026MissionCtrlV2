package X5;

import X5.AbstractC0992h;
import h6.InterfaceC1896e;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends AbstractC0992h implements InterfaceC1896e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f9430c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(q6.f fVar, Object[] values) {
        super(fVar, null);
        AbstractC2304t.f(values, "values");
        this.f9430c = values;
    }

    @Override // h6.InterfaceC1896e
    public List e() {
        Object[] objArr = this.f9430c;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            AbstractC0992h.a aVar = AbstractC0992h.f9427b;
            AbstractC2304t.c(obj);
            arrayList.add(aVar.a(obj, null));
        }
        return arrayList;
    }
}
