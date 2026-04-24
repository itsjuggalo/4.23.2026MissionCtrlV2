package X4;

import a5.l0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3523b;

    public /* synthetic */ c(Object obj, int i) {
        this.f3522a = i;
        this.f3523b = obj;
    }

    @Override // X4.d
    public final Iterator iterator() {
        switch (this.f3522a) {
            case 0:
                return new b(this);
            case 1:
                l0 l0Var = (l0) this.f3523b;
                e eVar = new e();
                eVar.f3526c = F1.h.n(eVar, eVar, l0Var);
                return eVar;
            case 2:
                return (Iterator) this.f3523b;
            default:
                return new Y4.b((String) this.f3523b);
        }
    }
}
