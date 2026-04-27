package d4;

import android.content.Context;
import c4.InterfaceC1143b;

/* JADX INFO: loaded from: classes.dex */
public final class c implements InterfaceC1143b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f13345a;

    public c(D5.a aVar) {
        this.f13345a = aVar;
    }

    public static c a(D5.a aVar) {
        return new c(aVar);
    }

    public static C1464b c(Context context) {
        return new C1464b(context);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1464b get() {
        return c((Context) this.f13345a.get());
    }
}
