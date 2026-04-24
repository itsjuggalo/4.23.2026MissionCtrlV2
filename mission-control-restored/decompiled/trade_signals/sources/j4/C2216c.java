package j4;

import android.content.Context;
import i4.InterfaceC1923b;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: j4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2216c implements InterfaceC1923b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f20031a;

    public C2216c(InterfaceC2426a interfaceC2426a) {
        this.f20031a = interfaceC2426a;
    }

    public static C2216c a(InterfaceC2426a interfaceC2426a) {
        return new C2216c(interfaceC2426a);
    }

    public static C2215b c(Context context) {
        return new C2215b(context);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C2215b get() {
        return c((Context) this.f20031a.get());
    }
}
