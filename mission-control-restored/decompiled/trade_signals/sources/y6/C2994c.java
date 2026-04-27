package y6;

import R5.InterfaceC0845b;
import S6.b;

/* JADX INFO: renamed from: y6.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2994c implements b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f24515a;

    public C2994c(boolean z7) {
        this.f24515a = z7;
    }

    @Override // S6.b.c
    public Iterable a(Object obj) {
        return AbstractC2996e.j(this.f24515a, (InterfaceC0845b) obj);
    }
}
