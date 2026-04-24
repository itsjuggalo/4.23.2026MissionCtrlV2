package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.AbstractC1167d;
import com.google.android.gms.common.api.internal.AbstractC1176m;
import com.google.android.gms.common.api.internal.AbstractC1180q;
import com.google.android.gms.common.api.internal.AbstractC1186x;
import com.google.android.gms.common.api.internal.AbstractC1188z;
import com.google.android.gms.common.api.internal.AbstractServiceConnectionC1177n;
import com.google.android.gms.common.api.internal.C1164a;
import com.google.android.gms.common.api.internal.C1165b;
import com.google.android.gms.common.api.internal.C1170g;
import com.google.android.gms.common.api.internal.C1175l;
import com.google.android.gms.common.api.internal.D;
import com.google.android.gms.common.api.internal.InterfaceC1184v;
import com.google.android.gms.common.api.internal.M;
import com.google.android.gms.common.api.internal.S;
import com.google.android.gms.common.api.internal.f0;
import com.google.android.gms.common.internal.AbstractC1192c;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.common.internal.C1194e;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    protected final C1170g zaa;
    private final Context zab;
    private final String zac;
    private final com.google.android.gms.common.api.a zad;
    private final a.d zae;
    private final C1165b zaf;
    private final Looper zag;
    private final int zah;
    private final f zai;
    private final InterfaceC1184v zaj;

    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f10853c = new C0180a().a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC1184v f10854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Looper f10855b;

        /* JADX INFO: renamed from: com.google.android.gms.common.api.e$a$a, reason: collision with other inner class name */
        public static class C0180a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public InterfaceC1184v f10856a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Looper f10857b;

            /* JADX WARN: Multi-variable type inference failed */
            public a a() {
                if (this.f10856a == null) {
                    this.f10856a = new C1164a();
                }
                if (this.f10857b == null) {
                    this.f10857b = Looper.getMainLooper();
                }
                return new a(this.f10856a, this.f10857b);
            }

            public C0180a b(Looper looper) {
                AbstractC1207s.l(looper, "Looper must not be null.");
                this.f10857b = looper;
                return this;
            }

            public C0180a c(InterfaceC1184v interfaceC1184v) {
                AbstractC1207s.l(interfaceC1184v, "StatusExceptionMapper must not be null.");
                this.f10856a = interfaceC1184v;
                return this;
            }
        }

        public a(InterfaceC1184v interfaceC1184v, Account account, Looper looper) {
            this.f10854a = interfaceC1184v;
            this.f10855b = looper;
        }
    }

    public e(Activity activity, com.google.android.gms.common.api.a aVar, a.d dVar, a aVar2) {
        this(activity, activity, aVar, dVar, aVar2);
    }

    public f asGoogleApiClient() {
        return this.zai;
    }

    public final AbstractC1167d b(int i7, AbstractC1167d abstractC1167d) {
        abstractC1167d.zak();
        this.zaa.C(this, i7, abstractC1167d);
        return abstractC1167d;
    }

    public final Task c(int i7, AbstractC1186x abstractC1186x) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.D(this, i7, abstractC1186x, taskCompletionSource, this.zaj);
        return taskCompletionSource.getTask();
    }

    public C1194e.a createClientSettingsBuilder() {
        C1194e.a aVar = new C1194e.a();
        aVar.d(null);
        aVar.c(Collections.emptySet());
        aVar.e(this.zab.getClass().getName());
        aVar.b(this.zab.getPackageName());
        return aVar;
    }

    public Task<Boolean> disconnectService() {
        return this.zaa.w(this);
    }

    public <A extends a.b, T extends AbstractC1167d> T doBestEffortWrite(T t7) {
        b(2, t7);
        return t7;
    }

    public <A extends a.b, T extends AbstractC1167d> T doRead(T t7) {
        b(0, t7);
        return t7;
    }

    @ResultIgnorabilityUnspecified
    @Deprecated
    public <A extends a.b, T extends AbstractC1180q, U extends AbstractC1188z> Task<Void> doRegisterEventListener(T t7, U u7) {
        AbstractC1207s.k(t7);
        AbstractC1207s.k(u7);
        throw null;
    }

    @ResultIgnorabilityUnspecified
    public Task<Boolean> doUnregisterEventListener(C1175l.a aVar) {
        return doUnregisterEventListener(aVar, 0);
    }

    public <A extends a.b, T extends AbstractC1167d> T doWrite(T t7) {
        b(1, t7);
        return t7;
    }

    public String getApiFallbackAttributionTag(Context context) {
        return null;
    }

    public final C1165b getApiKey() {
        return this.zaf;
    }

    public a.d getApiOptions() {
        return this.zae;
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
        return this.zag;
    }

    public <L> C1175l registerListener(L l7, String str) {
        return AbstractC1176m.a(l7, this.zag, str);
    }

    public final int zaa() {
        return this.zah;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a.f zab(Looper looper, M m7) {
        C1194e c1194eA = createClientSettingsBuilder().a();
        a.f fVarBuildClient = ((a.AbstractC0178a) AbstractC1207s.k(this.zad.a())).buildClient(this.zab, looper, c1194eA, (Object) this.zae, (f.b) m7, (f.c) m7);
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (fVarBuildClient instanceof AbstractC1192c)) {
            ((AbstractC1192c) fVarBuildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag == null || !(fVarBuildClient instanceof AbstractServiceConnectionC1177n)) {
            return fVarBuildClient;
        }
        android.support.v4.media.session.b.a(fVarBuildClient);
        throw null;
    }

    public final f0 zac(Context context, Handler handler) {
        return new f0(context, handler, createClientSettingsBuilder().a());
    }

    public e(Activity activity, com.google.android.gms.common.api.a aVar, a.d dVar, InterfaceC1184v interfaceC1184v) {
        a.C0180a c0180a = new a.C0180a();
        c0180a.c(interfaceC1184v);
        c0180a.b(activity.getMainLooper());
        this(activity, aVar, dVar, c0180a.a());
    }

    @ResultIgnorabilityUnspecified
    public <TResult, A extends a.b> Task<TResult> doBestEffortWrite(AbstractC1186x abstractC1186x) {
        return c(2, abstractC1186x);
    }

    @ResultIgnorabilityUnspecified
    public <TResult, A extends a.b> Task<TResult> doRead(AbstractC1186x abstractC1186x) {
        return c(0, abstractC1186x);
    }

    @ResultIgnorabilityUnspecified
    public Task<Boolean> doUnregisterEventListener(C1175l.a aVar, int i7) {
        AbstractC1207s.l(aVar, "Listener key cannot be null.");
        return this.zaa.x(this, aVar, i7);
    }

    @ResultIgnorabilityUnspecified
    public <TResult, A extends a.b> Task<TResult> doWrite(AbstractC1186x abstractC1186x) {
        return c(1, abstractC1186x);
    }

    public e(Context context, Activity activity, com.google.android.gms.common.api.a aVar, a.d dVar, a aVar2) {
        String apiFallbackAttributionTag;
        AbstractC1207s.l(context, "Null context is not permitted.");
        AbstractC1207s.l(aVar, "Api must not be null.");
        AbstractC1207s.l(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context2 = (Context) AbstractC1207s.l(context.getApplicationContext(), "The provided context did not have an application context.");
        this.zab = context2;
        if (Build.VERSION.SDK_INT >= 30) {
            apiFallbackAttributionTag = context.getAttributionTag();
        } else {
            apiFallbackAttributionTag = getApiFallbackAttributionTag(context);
        }
        this.zac = apiFallbackAttributionTag;
        this.zad = aVar;
        this.zae = dVar;
        this.zag = aVar2.f10855b;
        C1165b c1165bA = C1165b.a(aVar, dVar, apiFallbackAttributionTag);
        this.zaf = c1165bA;
        this.zai = new S(this);
        C1170g c1170gU = C1170g.u(context2);
        this.zaa = c1170gU;
        this.zah = c1170gU.l();
        this.zaj = aVar2.f10854a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            D.j(activity, c1170gU, c1165bA);
        }
        c1170gU.H(this);
    }

    @ResultIgnorabilityUnspecified
    public <A extends a.b> Task<Void> doRegisterEventListener(com.google.android.gms.common.api.internal.r rVar) {
        AbstractC1207s.k(rVar);
        throw null;
    }

    public e(Context context, com.google.android.gms.common.api.a aVar, a.d dVar, a aVar2) {
        this(context, null, aVar, dVar, aVar2);
    }
}
