package f1;

/* JADX INFO: renamed from: f1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1244b {
    public static Object a(int i4, Object obj, InterfaceC1243a interfaceC1243a, c cVar) {
        Object objApply;
        if (i4 < 1) {
            return interfaceC1243a.apply(obj);
        }
        do {
            objApply = interfaceC1243a.apply(obj);
            obj = cVar.a(obj, objApply);
            if (obj == null) {
                break;
            }
            i4--;
        } while (i4 >= 1);
        return objApply;
    }
}
