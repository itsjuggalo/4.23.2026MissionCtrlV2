package w1;

/* JADX INFO: renamed from: w1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2772b {
    public static Object a(int i7, Object obj, InterfaceC2771a interfaceC2771a, InterfaceC2773c interfaceC2773c) {
        Object objApply;
        if (i7 < 1) {
            return interfaceC2771a.apply(obj);
        }
        do {
            objApply = interfaceC2771a.apply(obj);
            obj = interfaceC2773c.a(obj, objApply);
            if (obj == null) {
                break;
            }
            i7--;
        } while (i7 >= 1);
        return objApply;
    }
}
