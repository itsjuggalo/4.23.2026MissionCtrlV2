package E1;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static Object a(int i8, Object obj, a aVar, c cVar) {
        Object objApply;
        if (i8 < 1) {
            return aVar.apply(obj);
        }
        do {
            objApply = aVar.apply(obj);
            obj = cVar.a(obj, objApply);
            if (obj == null) {
                break;
            }
            i8--;
        } while (i8 >= 1);
        return objApply;
    }
}
