package r5;

import R4.p;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e extends kotlin.jvm.internal.i implements p {
    @Override // R4.p
    public final Object invoke(Object obj, Object obj2) {
        n5.d p02 = (n5.d) obj;
        int iIntValue = ((Number) obj2).intValue();
        kotlin.jvm.internal.j.e(p02, "p0");
        f fVar = (f) this.receiver;
        fVar.getClass();
        boolean z6 = !p02.j(iIntValue) && p02.i(iIntValue).g();
        fVar.f9485b = z6;
        return Boolean.valueOf(z6);
    }
}
