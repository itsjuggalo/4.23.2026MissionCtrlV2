package h1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.HiddenActivity;
import c5.n;
import cd.h0;
import d1.a;
import d1.b;
import h1.a;
import j6.c;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m0;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import pd.o;
import x0.w;
import x0.x;
import y0.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends d1.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0200a f10934l = new C0200a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f10935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public x0.e f10936h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Executor f10937i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CancellationSignal f10938j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j f10939k;

    /* JADX INFO: renamed from: h1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0200a {
        public /* synthetic */ C0200a(k kVar) {
            this();
        }

        public C0200a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends v implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f10940a = new b();

        public b() {
            super(2);
        }

        public final void a(CancellationSignal cancellationSignal, Function0 f10) {
            t.f(f10, "f");
            b.a aVar = d1.b.f7497f;
            d1.b.e(cancellationSignal, f10);
        }

        @Override // pd.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((CancellationSignal) obj, (Function0) obj2);
            return h0.f3852a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends v implements pd.k {
        public c() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(a aVar, y0.h hVar) {
            aVar.n().onError(hVar);
        }

        public final void b(final y0.h e10) {
            t.f(e10, "e");
            Executor executorO = a.this.o();
            final a aVar = a.this;
            executorO.execute(new Runnable() { // from class: h1.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.c.c(aVar, e10);
                }
            });
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((y0.h) obj);
            return h0.f3852a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends v implements Function0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x f10943b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(x xVar) {
            super(0);
            this.f10943b = xVar;
        }

        public static final void b(a aVar, x xVar) {
            aVar.n().onResult(xVar);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m265invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m265invoke() {
            Executor executorO = a.this.o();
            final a aVar = a.this;
            final x xVar = this.f10943b;
            executorO.execute(new Runnable() { // from class: h1.c
                @Override // java.lang.Runnable
                public final void run() {
                    a.d.b(aVar, xVar);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends v implements Function0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m0 f10945b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(m0 m0Var) {
            super(0);
            this.f10945b = m0Var;
        }

        public static final void b(a aVar, m0 m0Var) {
            aVar.n().onError(m0Var.f14947a);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m266invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m266invoke() {
            Executor executorO = a.this.o();
            final a aVar = a.this;
            final m0 m0Var = this.f10945b;
            executorO.execute(new Runnable() { // from class: h1.d
                @Override // java.lang.Runnable
                public final void run() {
                    a.e.b(aVar, m0Var);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f extends v implements Function0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y0.h f10947b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(y0.h hVar) {
            super(0);
            this.f10947b = hVar;
        }

        public static final void b(a aVar, y0.h hVar) {
            aVar.n().onError(hVar);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m267invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m267invoke() {
            Executor executorO = a.this.o();
            final a aVar = a.this;
            final y0.h hVar = this.f10947b;
            executorO.execute(new Runnable() { // from class: h1.e
                @Override // java.lang.Runnable
                public final void run() {
                    a.f.b(aVar, hVar);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g extends v implements Function0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y0.k f10949b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(y0.k kVar) {
            super(0);
            this.f10949b = kVar;
        }

        public static final void b(a aVar, y0.k kVar) {
            aVar.n().onError(kVar);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m268invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m268invoke() {
            Executor executorO = a.this.o();
            final a aVar = a.this;
            final y0.k kVar = this.f10949b;
            executorO.execute(new Runnable() { // from class: h1.f
                @Override // java.lang.Runnable
                public final void run() {
                    a.g.b(aVar, kVar);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class h extends v implements Function0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Exception f10951b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Exception exc) {
            super(0);
            this.f10951b = exc;
        }

        public static final void b(a aVar, Exception exc) {
            aVar.n().onError(exc);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m269invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m269invoke() {
            Executor executorO = a.this.o();
            final a aVar = a.this;
            final Exception exc = this.f10951b;
            executorO.execute(new Runnable() { // from class: h1.g
                @Override // java.lang.Runnable
                public final void run() {
                    a.h.b(aVar, exc);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class i extends v implements Function0 {
        public i() {
            super(0);
        }

        public static final void b(a aVar) {
            aVar.n().onError(new y0.k("Failed to launch the selector UI. Hint: ensure the `context` parameter is an Activity-based context."));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m270invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m270invoke() {
            Executor executorO = a.this.o();
            final a aVar = a.this;
            executorO.execute(new Runnable() { // from class: h1.h
                @Override // java.lang.Runnable
                public final void run() {
                    a.i.b(aVar);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class j extends ResultReceiver {

        /* JADX INFO: renamed from: h1.a$j$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public /* synthetic */ class C0201a extends q implements o {
            public C0201a(Object obj) {
                super(2, obj, a.C0138a.class, "getCredentialExceptionTypeToException", "getCredentialExceptionTypeToException$credentials_play_services_auth_release(Ljava/lang/String;Ljava/lang/String;)Landroidx/credentials/exceptions/GetCredentialException;", 0);
            }

            @Override // pd.o
            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public final y0.h invoke(String str, String str2) {
                return ((a.C0138a) this.receiver).b(str, str2);
            }
        }

        public j(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i10, Bundle resultData) {
            t.f(resultData, "resultData");
            if (a.this.f(resultData, new C0201a(d1.a.f7493b), a.this.o(), a.this.n(), a.this.f10938j)) {
                return;
            }
            a.this.p(resultData.getInt("ACTIVITY_REQUEST_CODE"), i10, (Intent) resultData.getParcelable("RESULT_DATA"));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        t.f(context, "context");
        this.f10935g = context;
        this.f10939k = new j(new Handler(Looper.getMainLooper()));
    }

    public c5.h k(w request) throws l {
        t.f(request, "request");
        if (request.a().size() != 1) {
            throw new l("GetSignInWithGoogleOption cannot be combined with other options.");
        }
        Object obj = request.a().get(0);
        t.d(obj, "null cannot be cast to non-null type com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption");
        j6.b bVar = (j6.b) obj;
        c5.h hVarA = c5.h.R().f(bVar.h()).b(bVar.f()).d(bVar.g()).a();
        t.e(hVarA, "build(...)");
        return hVarA;
    }

    public x l(n response) throws y0.k {
        j6.c cVarM;
        t.f(response, "response");
        if (response.T() != null) {
            cVarM = m(response);
        } else {
            Log.w("GetSignInIntent", "Credential returned but no google Id found");
            cVarM = null;
        }
        if (cVarM != null) {
            return new x(cVarM);
        }
        throw new y0.k("When attempting to convert get response, null credential found");
    }

    public final j6.c m(n response) throws y0.k {
        t.f(response, "response");
        c.a aVar = new c.a();
        String strU = response.U();
        t.e(strU, "getId(...)");
        c.a aVarE = aVar.e(strU);
        try {
            String strT = response.T();
            t.c(strT);
            aVarE.f(strT);
            if (response.v() != null) {
                aVarE.b(response.v());
            }
            if (response.S() != null) {
                aVarE.d(response.S());
            }
            if (response.R() != null) {
                aVarE.c(response.R());
            }
            if (response.p() != null) {
                aVarE.g(response.p());
            }
            if (response.W() != null) {
                aVarE.h(response.W());
            }
            return aVarE.a();
        } catch (Exception unused) {
            throw new y0.k("When attempting to convert get response, null Google ID Token found");
        }
    }

    public final x0.e n() {
        x0.e eVar = this.f10936h;
        if (eVar != null) {
            return eVar;
        }
        t.s("callback");
        return null;
    }

    public final Executor o() {
        Executor executor = this.f10937i;
        if (executor != null) {
            return executor;
        }
        t.s("executor");
        return null;
    }

    public final void p(int i10, int i11, Intent intent) {
        a.C0138a c0138a = d1.a.f7493b;
        if (i10 != c0138a.a()) {
            Log.w("GetSignInIntent", "Returned request code " + c0138a.a() + " which  does not match what was given " + i10);
            return;
        }
        if (d1.b.g(i11, b.f10940a, new c(), this.f10938j)) {
            return;
        }
        try {
            n signInCredentialFromIntent = c5.i.d(this.f10935g).getSignInCredentialFromIntent(intent);
            t.e(signInCredentialFromIntent, "getSignInCredentialFromIntent(...)");
            d1.b.e(this.f10938j, new d(l(signInCredentialFromIntent)));
        } catch (com.google.android.gms.common.api.b e10) {
            m0 m0Var = new m0();
            m0Var.f14947a = new y0.k(e10.getMessage());
            if (e10.getStatusCode() == 16) {
                m0Var.f14947a = new y0.f(e10.getMessage());
            } else if (d1.a.f7493b.c().contains(Integer.valueOf(e10.getStatusCode()))) {
                m0Var.f14947a = new y0.i(e10.getMessage());
            }
            d1.b.e(this.f10938j, new e(m0Var));
        } catch (y0.h e11) {
            d1.b.e(this.f10938j, new f(e11));
        } catch (Throwable th) {
            d1.b.e(this.f10938j, new g(new y0.k(th.getMessage())));
        }
    }

    public void q(w request, x0.e callback, Executor executor, CancellationSignal cancellationSignal) {
        t.f(request, "request");
        t.f(callback, "callback");
        t.f(executor, "executor");
        this.f10938j = cancellationSignal;
        r(callback);
        s(executor);
        if (CredentialProviderPlayServicesImpl.INSTANCE.a(cancellationSignal)) {
            return;
        }
        try {
            c5.h hVarK = k(request);
            Intent intent = new Intent(this.f10935g, (Class<?>) HiddenActivity.class);
            intent.putExtra("REQUEST_TYPE", hVarK);
            c(this.f10939k, intent, "SIGN_IN_INTENT");
            this.f10935g.startActivity(intent);
        } catch (Exception e10) {
            if (e10 instanceof l) {
                d1.b.e(cancellationSignal, new h(e10));
            } else {
                d1.b.e(cancellationSignal, new i());
            }
        }
    }

    public final void r(x0.e eVar) {
        t.f(eVar, "<set-?>");
        this.f10936h = eVar;
    }

    public final void s(Executor executor) {
        t.f(executor, "<set-?>");
        this.f10937i = executor;
    }
}
