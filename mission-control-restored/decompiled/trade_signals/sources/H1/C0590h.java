package H1;

import android.content.Context;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: H1.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0590h implements B1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f3625a;

    public C0590h(InterfaceC2426a interfaceC2426a) {
        this.f3625a = interfaceC2426a;
    }

    public static C0590h a(InterfaceC2426a interfaceC2426a) {
        return new C0590h(interfaceC2426a);
    }

    public static String c(Context context) {
        return (String) B1.d.d(AbstractC0588f.b(context));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c((Context) this.f3625a.get());
    }
}
