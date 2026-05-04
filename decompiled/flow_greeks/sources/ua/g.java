package ua;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f22579b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fa.b f22580a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public g(fa.b transportFactoryProvider) {
        kotlin.jvm.internal.t.f(transportFactoryProvider, "transportFactoryProvider");
        this.f22580a = transportFactoryProvider;
    }

    @Override // ua.h
    public void a(i0 sessionEvent) {
        kotlin.jvm.internal.t.f(sessionEvent, "sessionEvent");
        ((i4.j) this.f22580a.get()).b("FIREBASE_APPQUALITY_SESSION", i0.class, i4.c.b("json"), new i4.h() { // from class: ua.f
            @Override // i4.h
            public final Object apply(Object obj) {
                return this.f22577a.c((i0) obj);
            }
        }).a(i4.d.f(sessionEvent));
    }

    public final byte[] c(i0 i0Var) {
        String strB = j0.f22596a.c().b(i0Var);
        kotlin.jvm.internal.t.e(strB, "encode(...)");
        Log.d("FirebaseSessions", "Session Event Type: " + i0Var.b().name());
        byte[] bytes = strB.getBytes(kg.c.f14857b);
        kotlin.jvm.internal.t.e(bytes, "getBytes(...)");
        return bytes;
    }
}
