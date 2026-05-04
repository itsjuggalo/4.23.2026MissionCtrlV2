package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.c;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0094a f5466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f5467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5468c;

    /* JADX INFO: renamed from: com.google.android.gms.common.api.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class AbstractC0094a extends e {
        @Deprecated
        public f buildClient(Context context, Looper looper, com.google.android.gms.common.internal.e eVar, Object obj, g.b bVar, g.c cVar) {
            return buildClient(context, looper, eVar, obj, (com.google.android.gms.common.api.internal.f) bVar, (com.google.android.gms.common.api.internal.n) cVar);
        }

        public f buildClient(Context context, Looper looper, com.google.android.gms.common.internal.e eVar, Object obj, com.google.android.gms.common.api.internal.f fVar, com.google.android.gms.common.api.internal.n nVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface d {
        public static final C0095a J = new C0095a(null);

        /* JADX INFO: renamed from: com.google.android.gms.common.api.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0095a implements d {
            public /* synthetic */ C0095a(byte[] bArr) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class e {
        public static final int API_PRIORITY_GAMES = 1;
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        public static final int API_PRIORITY_PLUS = 2;

        public List<Scope> getImpliedScopes(Object obj) {
            return Collections.EMPTY_LIST;
        }

        public int getPriority() {
            return API_PRIORITY_OTHER;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface f extends b {
        void connect(c.InterfaceC0097c interfaceC0097c);

        void disconnect();

        void disconnect(String str);

        m5.d[] getAvailableFeatures();

        String getEndpointPackageName();

        String getLastDisconnectMessage();

        int getMinApkVersion();

        void getRemoteService(com.google.android.gms.common.internal.k kVar, Set set);

        Set getScopesForConnectionlessNonSignIn();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(c.e eVar);

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g extends c {
    }

    public a(String str, AbstractC0094a abstractC0094a, g gVar) {
        com.google.android.gms.common.internal.s.l(abstractC0094a, "Cannot construct an Api with a null ClientBuilder");
        com.google.android.gms.common.internal.s.l(gVar, "Cannot construct an Api with a null ClientKey");
        this.f5468c = str;
        this.f5466a = abstractC0094a;
        this.f5467b = gVar;
    }

    public final AbstractC0094a a() {
        return this.f5466a;
    }

    public final c b() {
        return this.f5467b;
    }

    public final String c() {
        return this.f5468c;
    }
}
