package h7;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends e7.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a7.m f11047b;

    public c(String str, a7.m mVar) {
        com.google.android.gms.common.internal.s.e(str);
        this.f11046a = str;
        this.f11047b = mVar;
    }

    public static c c(e7.c cVar) {
        com.google.android.gms.common.internal.s.k(cVar);
        return new c(cVar.b(), null);
    }

    public static c d(a7.m mVar) {
        return new c("eyJlcnJvciI6IlVOS05PV05fRVJST1IifQ==", (a7.m) com.google.android.gms.common.internal.s.k(mVar));
    }

    @Override // e7.d
    public Exception a() {
        return this.f11047b;
    }

    @Override // e7.d
    public String b() {
        return this.f11046a;
    }
}
