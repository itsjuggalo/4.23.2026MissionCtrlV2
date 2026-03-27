package z1;

import android.content.Context;
import t1.AbstractC2653d;
import t1.InterfaceC2651b;

/* JADX INFO: renamed from: z1.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2863h implements InterfaceC2651b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f26006a;

    public C2863h(D5.a aVar) {
        this.f26006a = aVar;
    }

    public static C2863h a(D5.a aVar) {
        return new C2863h(aVar);
    }

    public static String c(Context context) {
        return (String) AbstractC2653d.d(AbstractC2861f.b(context));
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c((Context) this.f26006a.get());
    }
}
