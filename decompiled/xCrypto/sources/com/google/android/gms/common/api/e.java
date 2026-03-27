package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.A;
import com.google.android.gms.common.api.internal.AbstractC0901e;
import com.google.android.gms.common.api.internal.AbstractC0910n;
import com.google.android.gms.common.api.internal.AbstractC0914s;
import com.google.android.gms.common.api.internal.AbstractC0920y;
import com.google.android.gms.common.api.internal.AbstractServiceConnectionC0911o;
import com.google.android.gms.common.api.internal.C0896b;
import com.google.android.gms.common.api.internal.C0898c;
import com.google.android.gms.common.api.internal.C0904h;
import com.google.android.gms.common.api.internal.C0909m;
import com.google.android.gms.common.api.internal.F;
import com.google.android.gms.common.api.internal.InterfaceC0918w;
import com.google.android.gms.common.api.internal.P;
import com.google.android.gms.common.api.internal.V;
import com.google.android.gms.common.api.internal.i0;
import com.google.android.gms.common.internal.AbstractC0925c;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.C0927e;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    protected final C0904h zaa;
    private final Context zab;
    private final String zac;
    private final com.google.android.gms.common.api.a zad;
    private final a.d zae;
    private final C0898c zaf;
    private final Looper zag;
    private final int zah;
    private final f zai;
    private final InterfaceC0918w zaj;

    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f9668c = new C0147a().a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0918w f9669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Looper f9670b;

        /* JADX INFO: renamed from: com.google.android.gms.common.api.e$a$a, reason: collision with other inner class name */
        public static class C0147a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public InterfaceC0918w f9671a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Looper f9672b;

            /* JADX WARN: Multi-variable type inference failed */
            public a a() {
                if (this.f9671a == null) {
                    this.f9671a = new C0896b();
                }
                if (this.f9672b == null) {
                    this.f9672b = Looper.getMainLooper();
                }
                return new a(this.f9671a, this.f9672b);
            }

            public C0147a b(Looper looper) {
                AbstractC0940s.l(looper, "Looper must not be null.");
                this.f9672b = looper;
                return this;
            }

            public C0147a c(InterfaceC0918w interfaceC0918w) {
                AbstractC0940s.l(interfaceC0918w, "StatusExceptionMapper must not be null.");
                this.f9671a = interfaceC0918w;
                return this;
            }
        }

        public a(InterfaceC0918w interfaceC0918w, Account account, Looper looper) {
            this.f9669a = interfaceC0918w;
            this.f9670b = looper;
        }
    }

    public e(Activity activity, com.google.android.gms.common.api.a aVar, a.d dVar, a aVar2) {
        this(activity, activity, aVar, dVar, aVar2);
    }

    public f asGoogleApiClient() {
        return this.zai;
    }

    public final AbstractC0901e b(int i4, AbstractC0901e abstractC0901e) {
        abstractC0901e.zak();
        this.zaa.C(this, i4, abstractC0901e);
        return abstractC0901e;
    }

    public final Task c(int i4, AbstractC0920y abstractC0920y) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.D(this, i4, abstractC0920y, taskCompletionSource, this.zaj);
        return taskCompletionSource.getTask();
    }

    public C0927e.a createClientSettingsBuilder() {
        C0927e.a aVar = new C0927e.a();
        aVar.d(null);
        aVar.c(Collections.EMPTY_SET);
        aVar.e(this.zab.getClass().getName());
        aVar.b(this.zab.getPackageName());
        return aVar;
    }

    public Task<Boolean> disconnectService() {
        return this.zaa.w(this);
    }

    public <A extends a.b, T extends AbstractC0901e> T doBestEffortWrite(T t4) {
        b(2, t4);
        return t4;
    }

    public <A extends a.b, T extends AbstractC0901e> T doRead(T t4) {
        b(0, t4);
        return t4;
    }

    @ResultIgnorabilityUnspecified
    @Deprecated
    public <A extends a.b, T extends com.google.android.gms.common.api.internal.r, U extends A> Task<Void> doRegisterEventListener(T t4, U u4) {
        AbstractC0940s.k(t4);
        AbstractC0940s.k(u4);
        throw null;
    }

    @ResultIgnorabilityUnspecified
    public Task<Boolean> doUnregisterEventListener(C0909m.a aVar) {
        return doUnregisterEventListener(aVar, 0);
    }

    public <A extends a.b, T extends AbstractC0901e> T doWrite(T t4) {
        b(1, t4);
        return t4;
    }

    public String getApiFallbackAttributionTag(Context context) {
        return null;
    }

    public final C0898c getApiKey() {
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

    public <L> C0909m registerListener(L l4, String str) {
        return AbstractC0910n.a(l4, this.zag, str);
    }

    public final int zaa() {
        return this.zah;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a.f zab(Looper looper, P p4) {
        C0927e c0927eA = createClientSettingsBuilder().a();
        a.f fVarBuildClient = ((a.AbstractC0145a) AbstractC0940s.k(this.zad.a())).buildClient(this.zab, looper, c0927eA, (Object) this.zae, (f.b) p4, (f.c) p4);
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (fVarBuildClient instanceof AbstractC0925c)) {
            ((AbstractC0925c) fVarBuildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag == null || !(fVarBuildClient instanceof AbstractServiceConnectionC0911o)) {
            return fVarBuildClient;
        }
        android.support.v4.media.session.b.a(fVarBuildClient);
        throw null;
    }

    public final i0 zac(Context context, Handler handler) {
        return new i0(context, handler, createClientSettingsBuilder().a());
    }

    public e(Activity activity, com.google.android.gms.common.api.a aVar, a.d dVar, InterfaceC0918w interfaceC0918w) {
        a.C0147a c0147a = new a.C0147a();
        c0147a.c(interfaceC0918w);
        c0147a.b(activity.getMainLooper());
        this(activity, aVar, dVar, c0147a.a());
    }

    @ResultIgnorabilityUnspecified
    public <TResult, A extends a.b> Task<TResult> doBestEffortWrite(AbstractC0920y abstractC0920y) {
        return c(2, abstractC0920y);
    }

    @ResultIgnorabilityUnspecified
    public <TResult, A extends a.b> Task<TResult> doRead(AbstractC0920y abstractC0920y) {
        return c(0, abstractC0920y);
    }

    @ResultIgnorabilityUnspecified
    public Task<Boolean> doUnregisterEventListener(C0909m.a aVar, int i4) {
        AbstractC0940s.l(aVar, "Listener key cannot be null.");
        return this.zaa.x(this, aVar, i4);
    }

    @ResultIgnorabilityUnspecified
    public <TResult, A extends a.b> Task<TResult> doWrite(AbstractC0920y abstractC0920y) {
        return c(1, abstractC0920y);
    }

    public e(Context context, Activity activity, com.google.android.gms.common.api.a aVar, a.d dVar, a aVar2) {
        String apiFallbackAttributionTag;
        AbstractC0940s.l(context, "Null context is not permitted.");
        AbstractC0940s.l(aVar, "Api must not be null.");
        AbstractC0940s.l(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context2 = (Context) AbstractC0940s.l(context.getApplicationContext(), "The provided context did not have an application context.");
        this.zab = context2;
        if (Build.VERSION.SDK_INT >= 30) {
            apiFallbackAttributionTag = context.getAttributionTag();
        } else {
            apiFallbackAttributionTag = getApiFallbackAttributionTag(context);
        }
        this.zac = apiFallbackAttributionTag;
        this.zad = aVar;
        this.zae = dVar;
        this.zag = aVar2.f9670b;
        C0898c c0898cA = C0898c.a(aVar, dVar, apiFallbackAttributionTag);
        this.zaf = c0898cA;
        this.zai = new V(this);
        C0904h c0904hU = C0904h.u(context2);
        this.zaa = c0904hU;
        this.zah = c0904hU.l();
        this.zaj = aVar2.f9669a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            F.j(activity, c0904hU, c0898cA);
        }
        c0904hU.H(this);
    }

    @ResultIgnorabilityUnspecified
    public <A extends a.b> Task<Void> doRegisterEventListener(AbstractC0914s abstractC0914s) {
        AbstractC0940s.k(abstractC0914s);
        throw null;
    }

    public e(Context context, com.google.android.gms.common.api.a aVar, a.d dVar, a aVar2) {
        this(context, null, aVar, dVar, aVar2);
    }
}
