package g1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.IdentityCredentialApiHiddenActivity;
import cd.h0;
import com.google.android.gms.identitycredentials.GetCredentialRequest;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import d1.a;
import d1.b;
import g1.c;
import i1.a;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import pd.o;
import x0.w;
import x0.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends d1.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f9940l = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f9941g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public x0.e f9942h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Executor f9943i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CancellationSignal f9944j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f9945k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends v implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9946a = new b();

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

    /* JADX INFO: renamed from: g1.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0176c extends v implements pd.k {
        public C0176c() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(c cVar, y0.h hVar) {
            cVar.q().onError(hVar);
        }

        public final void b(final y0.h e10) {
            t.f(e10, "e");
            Executor executorR = c.this.r();
            final c cVar = c.this;
            executorR.execute(new Runnable() { // from class: g1.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.C0176c.c(cVar, e10);
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
        public d() {
            super(0);
        }

        public static final void b(c cVar) {
            cVar.q().onError(new y0.k("No provider data returned."));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m258invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m258invoke() {
            Executor executorR = c.this.r();
            final c cVar = c.this;
            executorR.execute(new Runnable() { // from class: g1.e
                @Override // java.lang.Runnable
                public final void run() {
                    c.d.b(cVar);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends v implements Function0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x f9950b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(x xVar) {
            super(0);
            this.f9950b = xVar;
        }

        public static final void b(c cVar, x xVar) {
            cVar.q().onResult(xVar);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m259invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m259invoke() {
            Executor executorR = c.this.r();
            final c cVar = c.this;
            final x xVar = this.f9950b;
            executorR.execute(new Runnable() { // from class: g1.f
                @Override // java.lang.Runnable
                public final void run() {
                    c.e.b(cVar, xVar);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f extends v implements Function0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y0.h f9952b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(y0.h hVar) {
            super(0);
            this.f9952b = hVar;
        }

        public static final void b(c cVar, y0.h hVar) {
            x0.e eVarQ = cVar.q();
            if (hVar == null) {
                hVar = new y0.k("Unexpected configuration error");
            }
            eVarQ.onError(hVar);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m260invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m260invoke() {
            Executor executorR = c.this.r();
            final c cVar = c.this;
            final y0.h hVar = this.f9952b;
            executorR.execute(new Runnable() { // from class: g1.g
                @Override // java.lang.Runnable
                public final void run() {
                    c.f.b(cVar, hVar);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g extends v implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellationSignal f9953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f9954b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(CancellationSignal cancellationSignal, c cVar) {
            super(1);
            this.f9953a = cancellationSignal;
            this.f9954b = cVar;
        }

        public final void a(c6.h hVar) {
            if (CredentialProviderPlayServicesImpl.INSTANCE.a(this.f9953a)) {
                return;
            }
            Intent intent = new Intent(this.f9954b.f9941g, (Class<?>) IdentityCredentialApiHiddenActivity.class);
            intent.setFlags(65536);
            c cVar = this.f9954b;
            intent.putExtra("RESULT_RECEIVER", cVar.d(cVar.f9945k));
            intent.putExtra("EXTRA_GET_CREDENTIAL_INTENT", hVar.R());
            this.f9954b.f9941g.startActivity(intent);
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((c6.h) obj);
            return h0.f3852a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class h extends v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Executor f9955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x0.e f9956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ y0.h f9957c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Executor executor, x0.e eVar, y0.h hVar) {
            super(0);
            this.f9955a = executor;
            this.f9956b = eVar;
            this.f9957c = hVar;
        }

        public static final void b(x0.e eVar, y0.h hVar) {
            eVar.onError(hVar);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m261invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m261invoke() {
            Executor executor = this.f9955a;
            final x0.e eVar = this.f9956b;
            final y0.h hVar = this.f9957c;
            executor.execute(new Runnable() { // from class: g1.h
                @Override // java.lang.Runnable
                public final void run() {
                    c.h.b(eVar, hVar);
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
            if (c.this.f(resultData, new a(d1.a.f7493b), c.this.r(), c.this.q(), c.this.f9944j)) {
                return;
            }
            c.this.s(resultData.getInt("ACTIVITY_REQUEST_CODE"), i10, (Intent) resultData.getParcelable("RESULT_DATA"));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        t.f(context, "context");
        this.f9941g = context;
        this.f9945k = new i(new Handler(Looper.getMainLooper()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(pd.k kVar, Object obj) {
        kVar.invoke(obj);
    }

    public static final void v(c cVar, CancellationSignal cancellationSignal, Executor executor, x0.e eVar, Exception e10) {
        t.f(e10, "e");
        d1.b.e(cancellationSignal, new h(executor, eVar, cVar.p(e10)));
    }

    public GetCredentialRequest o(w request) {
        t.f(request, "request");
        ArrayList arrayList = new ArrayList();
        for (x0.g gVar : request.a()) {
        }
        return new GetCredentialRequest(arrayList, w.f24160f.a(request), request.b(), new ResultReceiver(null));
    }

    public final y0.h p(Throwable th) {
        if (!(th instanceof com.google.android.gms.common.api.b)) {
            return new y0.k("Get digital credential failed, failure: " + th);
        }
        int statusCode = ((com.google.android.gms.common.api.b) th).getStatusCode();
        if (statusCode == 16) {
            return new y0.f(th.getMessage());
        }
        if (d1.a.f7493b.c().contains(Integer.valueOf(statusCode))) {
            return new y0.i(th.getMessage());
        }
        return new y0.k("Get digital credential failed, failure: " + th);
    }

    public final x0.e q() {
        x0.e eVar = this.f9942h;
        if (eVar != null) {
            return eVar;
        }
        t.s("callback");
        return null;
    }

    public final Executor r() {
        Executor executor = this.f9943i;
        if (executor != null) {
            return executor;
        }
        t.s("executor");
        return null;
    }

    public final void s(int i10, int i11, Intent intent) {
        a.C0138a c0138a = d1.a.f7493b;
        if (i10 != c0138a.a()) {
            Log.w("DigitalCredentialClient", "Returned request code " + c0138a.a() + " which  does not match what was given " + i10);
            return;
        }
        if (d1.b.g(i11, b.f9946a, new C0176c(), this.f9944j)) {
            return;
        }
        if (intent == null) {
            d1.b.e(this.f9944j, new d());
            return;
        }
        a.c cVar = i1.a.f11525a;
        x xVarB = cVar.b(intent);
        if (xVarB != null) {
            d1.b.e(this.f9944j, new e(xVarB));
        } else {
            d1.b.e(this.f9944j, new f(cVar.a(intent)));
        }
    }

    public void t(w request, final x0.e callback, final Executor executor, final CancellationSignal cancellationSignal) {
        t.f(request, "request");
        t.f(callback, "callback");
        t.f(executor, "executor");
        this.f9944j = cancellationSignal;
        w(callback);
        x(executor);
        if (CredentialProviderPlayServicesImpl.INSTANCE.a(cancellationSignal)) {
            return;
        }
        Task taskA = c6.g.f3697a.a(this.f9941g).a(o(request));
        final g gVar = new g(cancellationSignal, this);
        taskA.addOnSuccessListener(new OnSuccessListener() { // from class: g1.a
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                c.u(gVar, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: g1.b
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                c.v(this.f9936a, cancellationSignal, executor, callback, exc);
            }
        });
    }

    public final void w(x0.e eVar) {
        t.f(eVar, "<set-?>");
        this.f9942h = eVar;
    }

    public final void x(Executor executor) {
        t.f(executor, "<set-?>");
        this.f9943i = executor;
    }
}
