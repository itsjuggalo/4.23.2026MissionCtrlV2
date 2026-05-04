package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.a1;
import com.google.android.gms.common.api.internal.h0;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.api.internal.n0;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.api.internal.x;
import com.google.android.gms.common.api.internal.z;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    protected final com.google.android.gms.common.api.internal.g zaa;
    private final Context zab;
    private final String zac;
    private final v5.a zad;
    private final com.google.android.gms.common.api.a zae;
    private final a.d zaf;
    private final com.google.android.gms.common.api.internal.b zag;
    private final Looper zah;
    private final int zai;
    private final g zaj;
    private final com.google.android.gms.common.api.internal.t zak;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f5486c = new C0096a().a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.gms.common.api.internal.t f5487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Looper f5488b;

        /* JADX INFO: renamed from: com.google.android.gms.common.api.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class C0096a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public com.google.android.gms.common.api.internal.t f5489a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Looper f5490b;

            /* JADX WARN: Multi-variable type inference failed */
            public a a() {
                if (this.f5489a == null) {
                    this.f5489a = new com.google.android.gms.common.api.internal.a();
                }
                if (this.f5490b == null) {
                    this.f5490b = Looper.getMainLooper();
                }
                return new a(this.f5489a, null, this.f5490b, 0 == true ? 1 : 0);
            }

            public C0096a b(Looper looper) {
                com.google.android.gms.common.internal.s.l(looper, "Looper must not be null.");
                this.f5490b = looper;
                return this;
            }

            public C0096a c(com.google.android.gms.common.api.internal.t tVar) {
                com.google.android.gms.common.internal.s.l(tVar, "StatusExceptionMapper must not be null.");
                this.f5489a = tVar;
                return this;
            }
        }

        public a(com.google.android.gms.common.api.internal.t tVar, Account account, Looper looper) {
            this.f5487a = tVar;
            this.f5488b = looper;
        }

        public /* synthetic */ a(com.google.android.gms.common.api.internal.t tVar, Account account, Looper looper, byte[] bArr) {
            this(tVar, null, looper);
        }
    }

    public f(Activity activity, com.google.android.gms.common.api.a aVar, a.d dVar, a aVar2) {
        this(activity, activity, aVar, dVar, aVar2);
    }

    public g asGoogleApiClient() {
        return this.zaj;
    }

    public e.a createClientSettingsBuilder() {
        e.a aVar = new e.a();
        aVar.c(null);
        aVar.d(Collections.EMPTY_SET);
        Context context = this.zab;
        aVar.e(context.getClass().getName());
        aVar.b(context.getPackageName());
        return aVar;
    }

    public Task<Boolean> disconnectService() {
        return this.zaa.u(this);
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d> T doBestEffortWrite(T t10) {
        e(2, t10);
        return t10;
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d> T doRead(T t10) {
        e(0, t10);
        return t10;
    }

    @Deprecated
    public <A extends a.b, T extends com.google.android.gms.common.api.internal.o, U extends x> Task<Void> doRegisterEventListener(T t10, U u10) {
        com.google.android.gms.common.internal.s.k(t10);
        com.google.android.gms.common.internal.s.k(u10);
        throw null;
    }

    public Task<Boolean> doUnregisterEventListener(l.a aVar) {
        return doUnregisterEventListener(aVar, 0);
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d> T doWrite(T t10) {
        e(1, t10);
        return t10;
    }

    public final com.google.android.gms.common.api.internal.d e(int i10, com.google.android.gms.common.api.internal.d dVar) {
        dVar.zak();
        this.zaa.v(this, i10, dVar);
        return dVar;
    }

    public final Task f(int i10, v vVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.w(this, i10, vVar, taskCompletionSource, this.zak);
        return taskCompletionSource.getTask();
    }

    public String getApiFallbackAttributionTag(Context context) {
        return null;
    }

    public final com.google.android.gms.common.api.internal.b getApiKey() {
        return this.zag;
    }

    public a.d getApiOptions() {
        return this.zaf;
    }

    public Context getApplicationContext() {
        return this.zab;
    }

    public String getContextAttributionTag() {
        return this.zac;
    }

    @Deprecated
    public String getContextFeatureId() {
        return this.zac;
    }

    public Looper getLooper() {
        return this.zah;
    }

    public <L> com.google.android.gms.common.api.internal.l registerListener(L l10, String str) {
        return com.google.android.gms.common.api.internal.m.a(l10, this.zah, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a.f zaa(Looper looper, h0 h0Var) {
        com.google.android.gms.common.internal.e eVarA = createClientSettingsBuilder().a();
        a.f fVarBuildClient = ((a.AbstractC0094a) com.google.android.gms.common.internal.s.k(this.zae.a())).buildClient(this.zab, looper, eVarA, (Object) this.zaf, (g.b) h0Var, (g.c) h0Var);
        v5.a aVar = this.zad;
        if (aVar != null && (fVarBuildClient instanceof com.google.android.gms.common.internal.c)) {
            ((com.google.android.gms.common.internal.c) fVarBuildClient).setAttributionSourceWrapper(aVar);
            return fVarBuildClient;
        }
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (fVarBuildClient instanceof com.google.android.gms.common.internal.c)) {
            ((com.google.android.gms.common.internal.c) fVarBuildClient).setAttributionTag(contextAttributionTag);
        }
        return fVarBuildClient;
    }

    public final int zab() {
        return this.zai;
    }

    public final a1 zac(Context context, Handler handler) {
        return new a1(context, handler, createClientSettingsBuilder().a());
    }

    public f(Activity activity, com.google.android.gms.common.api.a aVar, a.d dVar, com.google.android.gms.common.api.internal.t tVar) {
        a.C0096a c0096a = new a.C0096a();
        c0096a.c(tVar);
        c0096a.b(activity.getMainLooper());
        this(activity, aVar, dVar, c0096a.a());
    }

    public <TResult, A extends a.b> Task<TResult> doBestEffortWrite(v vVar) {
        return f(2, vVar);
    }

    public <TResult, A extends a.b> Task<TResult> doRead(v vVar) {
        return f(0, vVar);
    }

    public Task<Boolean> doUnregisterEventListener(l.a aVar, int i10) {
        com.google.android.gms.common.internal.s.l(aVar, "Listener key cannot be null.");
        return this.zaa.y(this, aVar, i10);
    }

    public <TResult, A extends a.b> Task<TResult> doWrite(v vVar) {
        return f(1, vVar);
    }

    public f(Context context, Activity activity, com.google.android.gms.common.api.a aVar, a.d dVar, a aVar2) {
        String apiFallbackAttributionTag;
        com.google.android.gms.common.internal.s.l(context, "Null context is not permitted.");
        com.google.android.gms.common.internal.s.l(aVar, "Api must not be null.");
        com.google.android.gms.common.internal.s.l(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context2 = (Context) com.google.android.gms.common.internal.s.l(context.getApplicationContext(), "The provided context did not have an application context.");
        this.zab = context2;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            apiFallbackAttributionTag = i0.a.c(context);
        } else {
            apiFallbackAttributionTag = getApiFallbackAttributionTag(context);
        }
        this.zac = apiFallbackAttributionTag;
        this.zad = i10 >= 31 ? new v5.a(context.getAttributionSource()) : null;
        this.zae = aVar;
        this.zaf = dVar;
        this.zah = aVar2.f5488b;
        com.google.android.gms.common.api.internal.b bVarA = com.google.android.gms.common.api.internal.b.a(aVar, dVar, apiFallbackAttributionTag);
        this.zag = bVarA;
        this.zaj = new n0(this);
        com.google.android.gms.common.api.internal.g gVarN = com.google.android.gms.common.api.internal.g.n(context2);
        this.zaa = gVarN;
        this.zai = gVarN.o();
        this.zak = aVar2.f5487a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            z.i(activity, gVarN, bVarA);
        }
        gVarN.p(this);
    }

    public <A extends a.b> Task<Void> doRegisterEventListener(com.google.android.gms.common.api.internal.p pVar) {
        com.google.android.gms.common.internal.s.k(pVar);
        throw null;
    }

    public f(Context context, com.google.android.gms.common.api.a aVar, a.d dVar, a aVar2) {
        this(context, null, aVar, dVar, aVar2);
    }
}
