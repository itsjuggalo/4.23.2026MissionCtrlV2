package xf;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h2 f24973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f24974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c1 f24975c;

    public g0(h2 howThisTypeIsUsed, Set set, c1 c1Var) {
        kotlin.jvm.internal.t.f(howThisTypeIsUsed, "howThisTypeIsUsed");
        this.f24973a = howThisTypeIsUsed;
        this.f24974b = set;
        this.f24975c = c1Var;
    }

    public abstract c1 a();

    public abstract h2 b();

    public abstract Set c();

    public abstract g0 d(fe.l1 l1Var);

    public abstract int hashCode();
}
