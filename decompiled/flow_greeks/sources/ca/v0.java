package ca;

import aa.m2;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v0 {
    public static m2 c(a7.g gVar, i4.j jVar, AnalyticsConnector analyticsConnector, ga.h hVar, da.a aVar, aa.o oVar, Executor executor) {
        final i4.i iVarA = jVar.a("FIREBASE_INAPPMESSAGING", byte[].class, new i4.h() { // from class: ca.t0
            @Override // i4.h
            public final Object apply(Object obj) {
                return v0.b((byte[]) obj);
            }
        });
        return new m2(new m2.b() { // from class: ca.u0
            @Override // aa.m2.b
            public final void a(byte[] bArr) {
                iVarA.a(i4.d.f(bArr));
            }
        }, analyticsConnector, gVar, hVar, aVar, oVar, executor);
    }

    public static /* synthetic */ byte[] b(byte[] bArr) {
        return bArr;
    }
}
