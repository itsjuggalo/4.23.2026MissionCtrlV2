package com.google.android.gms.common.api;

import P1.C0650d;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.InterfaceC1169f;
import com.google.android.gms.common.api.internal.InterfaceC1178o;
import com.google.android.gms.common.internal.AbstractC1192c;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.common.internal.C1194e;
import com.google.android.gms.common.internal.InterfaceC1200k;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0178a f10849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f10850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10851c;

    /* JADX INFO: renamed from: com.google.android.gms.common.api.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0178a extends e {
        @Deprecated
        public f buildClient(Context context, Looper looper, C1194e c1194e, Object obj, f.b bVar, f.c cVar) {
            return buildClient(context, looper, c1194e, obj, (InterfaceC1169f) bVar, (InterfaceC1178o) cVar);
        }

        public f buildClient(Context context, Looper looper, C1194e c1194e, Object obj, InterfaceC1169f interfaceC1169f, InterfaceC1178o interfaceC1178o) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface b {
    }

    public static class c {
    }

    public interface d {

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public static final C0179a f10852M = new C0179a(null);

        /* JADX INFO: renamed from: com.google.android.gms.common.api.a$d$a, reason: collision with other inner class name */
        public static final class C0179a implements d {
            public /* synthetic */ C0179a(p pVar) {
            }
        }
    }

    public static abstract class e {
        public static final int API_PRIORITY_GAMES = 1;
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        public static final int API_PRIORITY_PLUS = 2;

        public List<Scope> getImpliedScopes(Object obj) {
            return Collections.emptyList();
        }

        public int getPriority() {
            return API_PRIORITY_OTHER;
        }
    }

    public interface f extends b {
        void connect(AbstractC1192c.InterfaceC0181c interfaceC0181c);

        void disconnect();

        void disconnect(String str);

        C0650d[] getAvailableFeatures();

        String getEndpointPackageName();

        String getLastDisconnectMessage();

        int getMinApkVersion();

        void getRemoteService(InterfaceC1200k interfaceC1200k, Set set);

        Set getScopesForConnectionlessNonSignIn();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(AbstractC1192c.e eVar);

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    public static final class g extends c {
    }

    public a(String str, AbstractC0178a abstractC0178a, g gVar) {
        AbstractC1207s.l(abstractC0178a, "Cannot construct an Api with a null ClientBuilder");
        AbstractC1207s.l(gVar, "Cannot construct an Api with a null ClientKey");
        this.f10851c = str;
        this.f10849a = abstractC0178a;
        this.f10850b = gVar;
    }

    public final AbstractC0178a a() {
        return this.f10849a;
    }

    public final c b() {
        return this.f10850b;
    }

    public final String c() {
        return this.f10851c;
    }
}
