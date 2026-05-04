package e1;

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
import e1.b;
import j6.c;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m0;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import pd.o;
import x0.b0;
import x0.w;
import x0.x;
import x0.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends d1.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f8301l = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f8302g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public x0.e f8303h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Executor f8304i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CancellationSignal f8305j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f8306k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: e1.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0153b extends v implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0153b f8307a = new C0153b();

        public C0153b() {
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
        public static final void c(b bVar, y0.h hVar) {
            bVar.n().onError(hVar);
        }

        public final void b(final y0.h e10) {
            t.f(e10, "e");
            Executor executorO = b.this.o();
            final b bVar = b.this;
            executorO.execute(new Runnable() { // from class: e1.c
                @Override // java.lang.Runnable
                public final void run() {
                    b.c.c(bVar, e10);
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
        public final /* synthetic */ x f8310b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(x xVar) {
            super(0);
            this.f8310b = xVar;
        }

        public static final void b(b bVar, x xVar) {
            bVar.n().onResult(xVar);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m253invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m253invoke() {
            Executor executorO = b.this.o();
            final b bVar = b.this;
            final x xVar = this.f8310b;
            executorO.execute(new Runnable() { // from class: e1.d
                @Override // java.lang.Runnable
                public final void run() {
                    b.d.b(bVar, xVar);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends v implements Function0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m0 f8312b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(m0 m0Var) {
            super(0);
            this.f8312b = m0Var;
        }

        public static final void b(b bVar, m0 m0Var) {
            bVar.n().onError(m0Var.f14947a);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m254invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m254invoke() {
            Executor executorO = b.this.o();
            final b bVar = b.this;
            final m0 m0Var = this.f8312b;
            executorO.execute(new Runnable() { // from class: e1.e
                @Override // java.lang.Runnable
                public final void run() {
                    b.e.b(bVar, m0Var);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f extends v implements Function0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y0.h f8314b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(y0.h hVar) {
            super(0);
            this.f8314b = hVar;
        }

        public static final void b(b bVar, y0.h hVar) {
            bVar.n().onError(hVar);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m255invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m255invoke() {
            Executor executorO = b.this.o();
            final b bVar = b.this;
            final y0.h hVar = this.f8314b;
            executorO.execute(new Runnable() { // from class: e1.f
                @Override // java.lang.Runnable
                public final void run() {
                    b.f.b(bVar, hVar);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g extends v implements Function0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y0.k f8316b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(y0.k kVar) {
            super(0);
            this.f8316b = kVar;
        }

        public static final void b(b bVar, y0.k kVar) {
            bVar.n().onError(kVar);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m256invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m256invoke() {
            Executor executorO = b.this.o();
            final b bVar = b.this;
            final y0.k kVar = this.f8316b;
            executorO.execute(new Runnable() { // from class: e1.g
                @Override // java.lang.Runnable
                public final void run() {
                    b.g.b(bVar, kVar);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class h extends v implements Function0 {
        public h() {
            super(0);
        }

        public static final void b(b bVar) {
            bVar.n().onError(new y0.k("Failed to launch the selector UI. Hint: ensure the `context` parameter is an Activity-based context."));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m257invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m257invoke() {
            Executor executorO = b.this.o();
            final b bVar = b.this;
            executorO.execute(new Runnable() { // from class: e1.h
                @Override // java.lang.Runnable
                public final void run() {
                    b.h.b(bVar);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class i extends ResultReceiver {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public /* synthetic */ class a extends q implements o {
            public a(Object obj) {
                super(2, obj, a.C0138a.class, "getCredentialExceptionTypeToException", "getCredentialExceptionTypeToException$credentials_play_services_auth_release(Ljava/lang/String;Ljava/lang/String;)Landroidx/credentials/exceptions/GetCredentialException;", 0);
            }

            @Override // pd.o
            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public final y0.h invoke(String str, String str2) {
                return ((a.C0138a) this.receiver).b(str, str2);
            }
        }

        public i(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i10, Bundle resultData) {
            t.f(resultData, "resultData");
            if (b.this.f(resultData, new a(d1.a.f7493b), b.this.o(), b.this.n(), b.this.f8305j)) {
                return;
            }
            b.this.p(resultData.getInt("ACTIVITY_REQUEST_CODE"), i10, (Intent) resultData.getParcelable("RESULT_DATA"));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        t.f(context, "context");
        this.f8302g = context;
        this.f8306k = new i(new Handler(Looper.getMainLooper()));
    }

    private final j6.c m(n nVar) {
        c.a aVar = new c.a();
        String strU = nVar.U();
        t.e(strU, "getId(...)");
        c.a aVarE = aVar.e(strU);
        String strT = nVar.T();
        t.c(strT);
        c.a aVarF = aVarE.f(strT);
        if (nVar.v() != null) {
            aVarF.b(nVar.v());
        }
        if (nVar.S() != null) {
            aVarF.d(nVar.S());
        }
        if (nVar.R() != null) {
            aVarF.c(nVar.R());
        }
        if (nVar.p() != null) {
            aVarF.g(nVar.p());
        }
        if (nVar.W() != null) {
            aVarF.h(nVar.W());
        }
        return aVarF.a();
    }

    public c5.c k(w request) {
        t.f(request, "request");
        return e1.a.f8300a.a(request, this.f8302g);
    }

    public x l(n response) throws y0.k {
        x0.c b0Var;
        t.f(response, "response");
        if (response.V() != null) {
            String strU = response.U();
            t.e(strU, "getId(...)");
            String strV = response.V();
            t.c(strV);
            b0Var = new z(strU, strV);
        } else if (response.T() != null) {
            b0Var = m(response);
        } else if (response.X() != null) {
            b0Var = new b0(f1.a.f9275a.c(response));
        } else {
            Log.w("BeginSignIn", "Credential returned but no google Id or password or passkey found");
            b0Var = null;
        }
        if (b0Var != null) {
            return new x(b0Var);
        }
        throw new y0.k("When attempting to convert get response, null credential found");
    }

    public final x0.e n() {
        x0.e eVar = this.f8303h;
        if (eVar != null) {
            return eVar;
        }
        t.s("callback");
        return null;
    }

    public final Executor o() {
        Executor executor = this.f8304i;
        if (executor != null) {
            return executor;
        }
        t.s("executor");
        return null;
    }

    public final void p(int i10, int i11, Intent intent) {
        a.C0138a c0138a = d1.a.f7493b;
        if (i10 != c0138a.a()) {
            Log.w("BeginSignIn", "Returned request code " + c0138a.a() + " which  does not match what was given " + i10);
            return;
        }
        if (d1.b.g(i11, C0153b.f8307a, new c(), this.f8305j)) {
            return;
        }
        try {
            n signInCredentialFromIntent = c5.i.d(this.f8302g).getSignInCredentialFromIntent(intent);
            t.e(signInCredentialFromIntent, "getSignInCredentialFromIntent(...)");
            d1.b.e(this.f8305j, new d(l(signInCredentialFromIntent)));
        } catch (com.google.android.gms.common.api.b e10) {
            m0 m0Var = new m0();
            m0Var.f14947a = new y0.k(e10.getMessage());
            if (e10.getStatusCode() == 16) {
                m0Var.f14947a = new y0.f(e10.getMessage());
            } else if (d1.a.f7493b.c().contains(Integer.valueOf(e10.getStatusCode()))) {
                m0Var.f14947a = new y0.i(e10.getMessage());
            }
            d1.b.e(this.f8305j, new e(m0Var));
        } catch (y0.h e11) {
            d1.b.e(this.f8305j, new f(e11));
        } catch (Throwable th) {
            d1.b.e(this.f8305j, new g(new y0.k(th.getMessage())));
        }
    }

    public void q(w request, x0.e callback, Executor executor, CancellationSignal cancellationSignal) {
        t.f(request, "request");
        t.f(callback, "callback");
        t.f(executor, "executor");
        this.f8305j = cancellationSignal;
        r(callback);
        s(executor);
        if (CredentialProviderPlayServicesImpl.INSTANCE.a(cancellationSignal)) {
            return;
        }
        c5.c cVarK = k(request);
        Intent intent = new Intent(this.f8302g, (Class<?>) HiddenActivity.class);
        intent.putExtra("REQUEST_TYPE", cVarK);
        c(this.f8306k, intent, "BEGIN_SIGN_IN");
        try {
            this.f8302g.startActivity(intent);
        } catch (Exception unused) {
            d1.b.e(cancellationSignal, new h());
        }
    }

    public final void r(x0.e eVar) {
        t.f(eVar, "<set-?>");
        this.f8303h = eVar;
    }

    public final void s(Executor executor) {
        t.f(executor, "<set-?>");
        this.f8304i = executor;
    }
}
