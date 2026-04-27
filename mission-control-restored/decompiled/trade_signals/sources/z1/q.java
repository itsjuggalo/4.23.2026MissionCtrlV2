package z1;

import java.util.Set;
import w1.C2900c;
import w1.InterfaceC2905h;
import w1.InterfaceC2906i;
import w1.InterfaceC2907j;

/* JADX INFO: loaded from: classes.dex */
public final class q implements InterfaceC2907j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f24714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f24715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f24716c;

    public q(Set set, p pVar, t tVar) {
        this.f24714a = set;
        this.f24715b = pVar;
        this.f24716c = tVar;
    }

    @Override // w1.InterfaceC2907j
    public InterfaceC2906i a(String str, Class cls, InterfaceC2905h interfaceC2905h) {
        return b(str, cls, C2900c.b("proto"), interfaceC2905h);
    }

    @Override // w1.InterfaceC2907j
    public InterfaceC2906i b(String str, Class cls, C2900c c2900c, InterfaceC2905h interfaceC2905h) {
        if (this.f24714a.contains(c2900c)) {
            return new s(this.f24715b, str, c2900c, interfaceC2905h, this.f24716c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", c2900c, this.f24714a));
    }
}
