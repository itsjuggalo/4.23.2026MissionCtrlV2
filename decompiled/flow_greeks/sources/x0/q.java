package x0;

import android.content.Context;
import android.credentials.ClearCredentialStateException;
import android.credentials.ClearCredentialStateRequest;
import android.credentials.Credential;
import android.credentials.CredentialManager;
import android.credentials.GetCredentialException;
import android.credentials.GetCredentialRequest;
import android.credentials.GetCredentialResponse;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.OutcomeReceiver;
import android.util.Log;
import cd.h0;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function0;
import x0.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f24151b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CredentialManager f24152a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends kotlin.jvm.internal.v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x0.e f24153a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(x0.e eVar) {
            super(0);
            this.f24153a = eVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m274invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m274invoke() {
            this.f24153a.onError(new y0.d("Your device doesn't support credential manager"));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements OutcomeReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x0.e f24154a;

        public c(x0.e eVar) {
            this.f24154a = eVar;
        }

        public void a(ClearCredentialStateException error) {
            kotlin.jvm.internal.t.f(error, "error");
            Log.i("CredManProvService", "ClearCredentialStateException error returned from framework");
            this.f24154a.onError(new y0.c(null, 1, null));
        }

        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResult(Void r32) {
            Log.i("CredManProvService", "Clear result returned from framework: ");
            this.f24154a.onResult(r32);
        }

        public /* bridge */ /* synthetic */ void onError(Throwable th) {
            a(r.a(th));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends kotlin.jvm.internal.v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x0.e f24155a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(x0.e eVar) {
            super(0);
            this.f24155a = eVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m275invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m275invoke() {
            this.f24155a.onError(new y0.l("Your device doesn't support credential manager"));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e implements OutcomeReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x0.e f24156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f24157b;

        public e(x0.e eVar, q qVar) {
            this.f24156a = eVar;
            this.f24157b = qVar;
        }

        public void a(GetCredentialException error) {
            kotlin.jvm.internal.t.f(error, "error");
            Log.i("CredManProvService", "GetCredentialResponse error returned from framework");
            this.f24156a.onError(this.f24157b.c(error));
        }

        public void b(GetCredentialResponse response) {
            kotlin.jvm.internal.t.f(response, "response");
            Log.i("CredManProvService", "GetCredentialResponse returned from framework");
            this.f24156a.onResult(this.f24157b.b(response));
        }

        public /* bridge */ /* synthetic */ void onError(Throwable th) {
            a(s.a(th));
        }

        public /* bridge */ /* synthetic */ void onResult(Object obj) {
            b(t.a(obj));
        }
    }

    public q(Context context) {
        kotlin.jvm.internal.t.f(context, "context");
        this.f24152a = p.a(context.getSystemService(Constants.CREDENTIAL));
    }

    public final GetCredentialRequest a(w wVar) {
        n.a();
        GetCredentialRequest.Builder builderA = l.a(w.f24160f.a(wVar));
        for (g gVar : wVar.a()) {
            o.a();
            builderA.addCredentialOption(m.a(gVar.d(), gVar.c(), gVar.b()).setIsSystemProviderRequired(gVar.e()).setAllowedProviders(gVar.a()).build());
        }
        f(wVar, builderA);
        GetCredentialRequest getCredentialRequestBuild = builderA.build();
        kotlin.jvm.internal.t.e(getCredentialRequestBuild, "builder.build()");
        return getCredentialRequestBuild;
    }

    public final x b(GetCredentialResponse response) {
        kotlin.jvm.internal.t.f(response, "response");
        Credential credential = response.getCredential();
        kotlin.jvm.internal.t.e(credential, "response.credential");
        c.a aVar = x0.c.f24129c;
        String type = credential.getType();
        kotlin.jvm.internal.t.e(type, "credential.type");
        Bundle data = credential.getData();
        kotlin.jvm.internal.t.e(data, "credential.data");
        return new x(aVar.b(type, data));
    }

    public final y0.h c(GetCredentialException error) {
        kotlin.jvm.internal.t.f(error, "error");
        String type = error.getType();
        kotlin.jvm.internal.t.e(type, "error.type");
        return b1.a.a(type, error.getMessage());
    }

    public final ClearCredentialStateRequest d() {
        k.a();
        return j.a(new Bundle());
    }

    public final boolean e(Function0 function0) {
        if (this.f24152a != null) {
            return false;
        }
        function0.invoke();
        return true;
    }

    public final void f(w wVar, GetCredentialRequest.Builder builder) {
        if (wVar.b() != null) {
            builder.setOrigin(wVar.b());
        }
    }

    @Override // x0.h
    public boolean isAvailableOnDevice() {
        return Build.VERSION.SDK_INT >= 34 && this.f24152a != null;
    }

    @Override // x0.h
    public void onClearCredential(x0.a request, CancellationSignal cancellationSignal, Executor executor, x0.e callback) {
        kotlin.jvm.internal.t.f(request, "request");
        kotlin.jvm.internal.t.f(executor, "executor");
        kotlin.jvm.internal.t.f(callback, "callback");
        Log.i("CredManProvService", "In CredentialProviderFrameworkImpl onClearCredential");
        if (e(new b(callback))) {
            return;
        }
        c cVar = new c(callback);
        CredentialManager credentialManager = this.f24152a;
        kotlin.jvm.internal.t.c(credentialManager);
        credentialManager.clearCredentialState(d(), cancellationSignal, executor, cVar);
    }

    @Override // x0.h
    public void onGetCredential(Context context, w request, CancellationSignal cancellationSignal, Executor executor, x0.e callback) {
        kotlin.jvm.internal.t.f(context, "context");
        kotlin.jvm.internal.t.f(request, "request");
        kotlin.jvm.internal.t.f(executor, "executor");
        kotlin.jvm.internal.t.f(callback, "callback");
        if (e(new d(callback))) {
            return;
        }
        e eVar = new e(callback, this);
        CredentialManager credentialManager = this.f24152a;
        kotlin.jvm.internal.t.c(credentialManager);
        credentialManager.getCredential(context, a(request), cancellationSignal, executor, eVar);
    }
}
