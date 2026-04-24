package x1;

import android.content.Context;
import t1.AbstractC2653d;
import t1.InterfaceC2651b;
import y1.AbstractC2839f;
import y1.x;
import z1.InterfaceC2859d;

/* JADX INFO: loaded from: classes.dex */
public final class i implements InterfaceC2651b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f25289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final D5.a f25290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final D5.a f25291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D5.a f25292d;

    public i(D5.a aVar, D5.a aVar2, D5.a aVar3, D5.a aVar4) {
        this.f25289a = aVar;
        this.f25290b = aVar2;
        this.f25291c = aVar3;
        this.f25292d = aVar4;
    }

    public static i a(D5.a aVar, D5.a aVar2, D5.a aVar3, D5.a aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static x c(Context context, InterfaceC2859d interfaceC2859d, AbstractC2839f abstractC2839f, B1.a aVar) {
        return (x) AbstractC2653d.d(h.a(context, interfaceC2859d, abstractC2839f, aVar));
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public x get() {
        return c((Context) this.f25289a.get(), (InterfaceC2859d) this.f25290b.get(), (AbstractC2839f) this.f25291c.get(), (B1.a) this.f25292d.get());
    }
}
