package r1;

import java.util.Set;
import o1.C2291c;
import o1.InterfaceC2296h;
import o1.InterfaceC2297i;
import o1.InterfaceC2298j;

/* JADX INFO: loaded from: classes.dex */
public final class q implements InterfaceC2298j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f22433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f22434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f22435c;

    public q(Set set, p pVar, t tVar) {
        this.f22433a = set;
        this.f22434b = pVar;
        this.f22435c = tVar;
    }

    @Override // o1.InterfaceC2298j
    public InterfaceC2297i a(String str, Class cls, C2291c c2291c, InterfaceC2296h interfaceC2296h) {
        if (this.f22433a.contains(c2291c)) {
            return new s(this.f22434b, str, c2291c, interfaceC2296h, this.f22435c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", c2291c, this.f22433a));
    }
}
