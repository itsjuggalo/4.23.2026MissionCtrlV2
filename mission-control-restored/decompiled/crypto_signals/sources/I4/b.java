package I4;

import R4.p;
import a5.w0;
import f5.w;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f646a;

    public /* synthetic */ b(int i) {
        this.f646a = i;
    }

    @Override // R4.p
    public final Object invoke(Object obj, Object obj2) {
        c cVar;
        switch (this.f646a) {
            case 0:
                String acc = (String) obj;
                g element = (g) obj2;
                kotlin.jvm.internal.j.e(acc, "acc");
                kotlin.jvm.internal.j.e(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
            case 1:
                i acc2 = (i) obj;
                g element2 = (g) obj2;
                kotlin.jvm.internal.j.e(acc2, "acc");
                kotlin.jvm.internal.j.e(element2, "element");
                i iVarMinusKey = acc2.minusKey(element2.getKey());
                j jVar = j.f650a;
                if (iVarMinusKey == jVar) {
                    return element2;
                }
                e eVar = e.f649a;
                f fVar = (f) iVarMinusKey.get(eVar);
                if (fVar == null) {
                    cVar = new c(element2, iVarMinusKey);
                } else {
                    i iVarMinusKey2 = iVarMinusKey.minusKey(eVar);
                    if (iVarMinusKey2 == jVar) {
                        return new c(fVar, element2);
                    }
                    cVar = new c(fVar, new c(element2, iVarMinusKey2));
                }
                return cVar;
            case 2:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 3:
                return ((i) obj).plus((g) obj2);
            case 4:
                return ((i) obj).plus((g) obj2);
            case 5:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
            case 6:
                g gVar = (g) obj2;
                if (!(gVar instanceof w0)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? gVar : Integer.valueOf(iIntValue + 1);
            case 7:
                w0 w0Var = (w0) obj;
                g gVar2 = (g) obj2;
                if (w0Var != null) {
                    return w0Var;
                }
                if (gVar2 instanceof w0) {
                    return (w0) gVar2;
                }
                return null;
            default:
                return (w) obj;
        }
    }
}
