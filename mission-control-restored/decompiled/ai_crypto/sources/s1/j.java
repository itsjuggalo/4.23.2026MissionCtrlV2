package s1;

import android.content.Context;
import t1.InterfaceC2651b;

/* JADX INFO: loaded from: classes.dex */
public final class j implements InterfaceC2651b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f22984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final D5.a f22985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final D5.a f22986c;

    public j(D5.a aVar, D5.a aVar2, D5.a aVar3) {
        this.f22984a = aVar;
        this.f22985b = aVar2;
        this.f22986c = aVar3;
    }

    public static j a(D5.a aVar, D5.a aVar2, D5.a aVar3) {
        return new j(aVar, aVar2, aVar3);
    }

    public static i c(Context context, B1.a aVar, B1.a aVar2) {
        return new i(context, aVar, aVar2);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c((Context) this.f22984a.get(), (B1.a) this.f22985b.get(), (B1.a) this.f22986c.get());
    }
}
