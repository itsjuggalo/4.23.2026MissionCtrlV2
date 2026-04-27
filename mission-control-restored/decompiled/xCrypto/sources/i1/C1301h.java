package i1;

import android.content.Context;

/* JADX INFO: renamed from: i1.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1301h implements c1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V2.a f12230a;

    public C1301h(V2.a aVar) {
        this.f12230a = aVar;
    }

    public static C1301h a(V2.a aVar) {
        return new C1301h(aVar);
    }

    public static String c(Context context) {
        return (String) c1.d.d(AbstractC1299f.b(context));
    }

    @Override // V2.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c((Context) this.f12230a.get());
    }
}
