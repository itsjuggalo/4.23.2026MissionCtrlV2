package z1;

import android.content.Context;
import t1.InterfaceC2651b;

/* JADX INFO: loaded from: classes.dex */
public final class X implements InterfaceC2651b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f25988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final D5.a f25989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final D5.a f25990c;

    public X(D5.a aVar, D5.a aVar2, D5.a aVar3) {
        this.f25988a = aVar;
        this.f25989b = aVar2;
        this.f25990c = aVar3;
    }

    public static X a(D5.a aVar, D5.a aVar2, D5.a aVar3) {
        return new X(aVar, aVar2, aVar3);
    }

    public static W c(Context context, String str, int i7) {
        return new W(context, str, i7);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public W get() {
        return c((Context) this.f25988a.get(), (String) this.f25989b.get(), ((Integer) this.f25990c.get()).intValue());
    }
}
