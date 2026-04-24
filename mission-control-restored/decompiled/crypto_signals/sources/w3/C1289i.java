package w3;

/* JADX INFO: renamed from: w3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1289i implements t3.t {
    @Override // t3.t
    public final t3.s create(t3.e eVar, A3.a aVar) {
        Class superclass = aVar.f61a;
        if (!Enum.class.isAssignableFrom(superclass) || superclass == Enum.class) {
            return null;
        }
        if (!superclass.isEnum()) {
            superclass = superclass.getSuperclass();
        }
        return new C1290j(superclass);
    }
}
