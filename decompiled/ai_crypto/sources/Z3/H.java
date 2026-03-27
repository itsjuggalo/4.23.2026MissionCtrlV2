package Z3;

import android.content.Context;
import c4.InterfaceC1143b;

/* JADX INFO: loaded from: classes.dex */
public final class H implements InterfaceC1143b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f5870a;

    public H(D5.a aVar) {
        this.f5870a = aVar;
    }

    public static H a(D5.a aVar) {
        return new H(aVar);
    }

    public static G c(Context context) {
        return new G(context);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public G get() {
        return c((Context) this.f5870a.get());
    }
}
