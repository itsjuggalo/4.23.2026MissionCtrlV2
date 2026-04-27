package i1;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class X implements c1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V2.a f12212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V2.a f12213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V2.a f12214c;

    public X(V2.a aVar, V2.a aVar2, V2.a aVar3) {
        this.f12212a = aVar;
        this.f12213b = aVar2;
        this.f12214c = aVar3;
    }

    public static X a(V2.a aVar, V2.a aVar2, V2.a aVar3) {
        return new X(aVar, aVar2, aVar3);
    }

    public static W c(Context context, String str, int i4) {
        return new W(context, str, i4);
    }

    @Override // V2.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public W get() {
        return c((Context) this.f12212a.get(), (String) this.f12213b.get(), ((Integer) this.f12214c.get()).intValue());
    }
}
