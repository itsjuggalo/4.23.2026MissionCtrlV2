package com.google.firebase.sessions.settings;

import W2.E;
import Z2.e;
import Z2.i;
import a3.AbstractC0787c;
import android.net.Uri;
import b3.InterfaceC0868f;
import b3.l;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.sessions.ApplicationInfo;
import i3.o;
import java.net.URL;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import t3.AbstractC1818i;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteSettingsFetcher implements CrashlyticsSettingsFetcher {
    public static final Companion Companion = new Companion(null);
    private static final String FIREBASE_PLATFORM = "android";
    private static final String FIREBASE_SESSIONS_BASE_URL_STRING = "firebase-settings.crashlytics.com";
    private final ApplicationInfo appInfo;
    private final i blockingDispatcher;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.RemoteSettingsFetcher$doConfigFetch$2, reason: invalid class name */
    @InterfaceC0868f(c = "com.google.firebase.sessions.settings.RemoteSettingsFetcher$doConfigFetch$2", f = "RemoteSettingsFetcher.kt", l = {73, 75, 78}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends l implements o {
        final /* synthetic */ Map<String, String> $headerOptions;
        final /* synthetic */ o $onFailure;
        final /* synthetic */ o $onSuccess;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Map<String, String> map, o oVar, o oVar2, e eVar) {
            super(2, eVar);
            this.$headerOptions = map;
            this.$onSuccess = oVar;
            this.$onFailure = oVar2;
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            return RemoteSettingsFetcher.this.new AnonymousClass2(this.$headerOptions, this.$onSuccess, this.$onFailure, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00cb, code lost:
        
            if (r8.invoke(r1, r7) == r0) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00e0, code lost:
        
            if (r1.invoke(r3, r7) != r0) goto L37;
         */
        @Override // b3.AbstractC0863a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 230
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettingsFetcher.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i3.o
        public final Object invoke(L l4, e eVar) {
            return ((AnonymousClass2) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    public RemoteSettingsFetcher(ApplicationInfo appInfo, @Background i blockingDispatcher) {
        r.f(appInfo, "appInfo");
        r.f(blockingDispatcher, "blockingDispatcher");
        this.appInfo = appInfo;
        this.blockingDispatcher = blockingDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final URL settingsUrl() {
        return new URL(new Uri.Builder().scheme("https").authority(FIREBASE_SESSIONS_BASE_URL_STRING).appendPath("spi").appendPath("v2").appendPath("platforms").appendPath(FIREBASE_PLATFORM).appendPath("gmp").appendPath(this.appInfo.getAppId()).appendPath("settings").appendQueryParameter("build_version", this.appInfo.getAndroidAppInfo().getAppBuildVersion()).appendQueryParameter("display_version", this.appInfo.getAndroidAppInfo().getVersionName()).build().toString());
    }

    @Override // com.google.firebase.sessions.settings.CrashlyticsSettingsFetcher
    public Object doConfigFetch(Map<String, String> map, o oVar, o oVar2, e eVar) {
        Object objG = AbstractC1818i.g(this.blockingDispatcher, new AnonymousClass2(map, oVar, oVar2, null), eVar);
        return objG == AbstractC0787c.e() ? objG : E.f5463a;
    }
}
