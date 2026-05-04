package k8;

import m8.m;
import o8.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f14760d = new e(a.User, null, false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f14761e = new e(a.Server, null, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f14762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f14763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f14764c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        User,
        Server
    }

    public e(a aVar, h hVar, boolean z10) {
        this.f14762a = aVar;
        this.f14763b = hVar;
        this.f14764c = z10;
        m.f(!z10 || c());
    }

    public static e a(h hVar) {
        return new e(a.Server, hVar, true);
    }

    public h b() {
        return this.f14763b;
    }

    public boolean c() {
        return this.f14762a == a.Server;
    }

    public boolean d() {
        return this.f14762a == a.User;
    }

    public boolean e() {
        return this.f14764c;
    }

    public String toString() {
        return "OperationSource{source=" + this.f14762a + ", queryParams=" + this.f14763b + ", tagged=" + this.f14764c + '}';
    }
}
