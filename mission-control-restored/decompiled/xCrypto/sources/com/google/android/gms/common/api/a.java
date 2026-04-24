package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.InterfaceC0903g;
import com.google.android.gms.common.api.internal.InterfaceC0912p;
import com.google.android.gms.common.internal.AbstractC0925c;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.C0927e;
import com.google.android.gms.common.internal.InterfaceC0933k;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import z1.C1986d;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0145a f9664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f9665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9666c;

    /* JADX INFO: renamed from: com.google.android.gms.common.api.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0145a extends e {
        @Deprecated
        public f buildClient(Context context, Looper looper, C0927e c0927e, Object obj, f.b bVar, f.c cVar) {
            return buildClient(context, looper, c0927e, obj, (InterfaceC0903g) bVar, (InterfaceC0912p) cVar);
        }

        public f buildClient(Context context, Looper looper, C0927e c0927e, Object obj, InterfaceC0903g interfaceC0903g, InterfaceC0912p interfaceC0912p) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface b {
    }

    public static class c {
    }

    public interface d {

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public static final C0146a f9667K = new C0146a(null);

        /* JADX INFO: renamed from: com.google.android.gms.common.api.a$d$a, reason: collision with other inner class name */
        public static final class C0146a implements d {
            public /* synthetic */ C0146a(p pVar) {
            }
        }
    }

    public static abstract class e {
        public static final int API_PRIORITY_GAMES = 1;
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        public static final int API_PRIORITY_PLUS = 2;

        public List<Scope> getImpliedScopes(Object obj) {
            return Collections.EMPTY_LIST;
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public interface f extends b {
        void connect(AbstractC0925c.InterfaceC0148c interfaceC0148c);

        void disconnect();

        void disconnect(String str);

        C1986d[] getAvailableFeatures();

        String getEndpointPackageName();

        String getLastDisconnectMessage();

        int getMinApkVersion();

        void getRemoteService(InterfaceC0933k interfaceC0933k, Set set);

        Set getScopesForConnectionlessNonSignIn();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(AbstractC0925c.e eVar);

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    public static final class g extends c {
    }

    public a(String str, AbstractC0145a abstractC0145a, g gVar) {
        AbstractC0940s.l(abstractC0145a, "Cannot construct an Api with a null ClientBuilder");
        AbstractC0940s.l(gVar, "Cannot construct an Api with a null ClientKey");
        this.f9666c = str;
        this.f9664a = abstractC0145a;
        this.f9665b = gVar;
    }

    public final AbstractC0145a a() {
        return this.f9664a;
    }

    public final c b() {
        return this.f9665b;
    }

    public final String c() {
        return this.f9666c;
    }
}
