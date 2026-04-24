package androidx.credentials.playservices;

import N1.C0484u;
import W2.E;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.credentials.playservices.HiddenActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import i3.k;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import r1.AbstractC1750g;
import r1.C1745b;
import r1.C1746c;
import r1.C1749f;
import r1.i;
import r1.j;

/* JADX INFO: loaded from: classes.dex */
public class HiddenActivity extends Activity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f6897c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ResultReceiver f6898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6899b;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends s implements k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6901b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i4) {
            super(1);
            this.f6901b = i4;
        }

        public final void a(C1746c c1746c) {
            try {
                HiddenActivity.this.f6899b = true;
                HiddenActivity.this.startIntentSenderForResult(c1746c.i().getIntentSender(), this.f6901b, null, 0, 0, 0, null);
            } catch (IntentSender.SendIntentException e4) {
                HiddenActivity hiddenActivity = HiddenActivity.this;
                ResultReceiver resultReceiver = hiddenActivity.f6898a;
                r.c(resultReceiver);
                hiddenActivity.y(resultReceiver, "GET_UNKNOWN", "During begin sign in, one tap ui intent sender failure: " + e4.getMessage());
            }
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C1746c) obj);
            return E.f5463a;
        }
    }

    public static final class c extends s implements k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6903b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i4) {
            super(1);
            this.f6903b = i4;
        }

        public final void a(j jVar) {
            try {
                HiddenActivity.this.f6899b = true;
                HiddenActivity.this.startIntentSenderForResult(jVar.i().getIntentSender(), this.f6903b, null, 0, 0, 0, null);
            } catch (IntentSender.SendIntentException e4) {
                HiddenActivity hiddenActivity = HiddenActivity.this;
                ResultReceiver resultReceiver = hiddenActivity.f6898a;
                r.c(resultReceiver);
                hiddenActivity.y(resultReceiver, "CREATE_UNKNOWN", "During save password, found UI intent sender failure: " + e4.getMessage());
            }
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((j) obj);
            return E.f5463a;
        }
    }

    public static final class d extends s implements k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6905b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i4) {
            super(1);
            this.f6905b = i4;
        }

        public final void a(PendingIntent result) {
            r.f(result, "result");
            try {
                HiddenActivity.this.f6899b = true;
                HiddenActivity.this.startIntentSenderForResult(result.getIntentSender(), this.f6905b, null, 0, 0, 0, null);
            } catch (IntentSender.SendIntentException e4) {
                HiddenActivity hiddenActivity = HiddenActivity.this;
                ResultReceiver resultReceiver = hiddenActivity.f6898a;
                r.c(resultReceiver);
                hiddenActivity.y(resultReceiver, "CREATE_UNKNOWN", "During public key credential, found IntentSender failure on public key creation: " + e4.getMessage());
            }
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((PendingIntent) obj);
            return E.f5463a;
        }
    }

    public static final class e extends s implements k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6907b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i4) {
            super(1);
            this.f6907b = i4;
        }

        public final void a(PendingIntent pendingIntent) {
            try {
                HiddenActivity.this.f6899b = true;
                HiddenActivity.this.startIntentSenderForResult(pendingIntent.getIntentSender(), this.f6907b, null, 0, 0, 0, null);
            } catch (IntentSender.SendIntentException e4) {
                HiddenActivity hiddenActivity = HiddenActivity.this;
                ResultReceiver resultReceiver = hiddenActivity.f6898a;
                r.c(resultReceiver);
                hiddenActivity.y(resultReceiver, "GET_UNKNOWN", "During get sign-in intent, one tap ui intent sender failure: " + e4.getMessage());
            }
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((PendingIntent) obj);
            return E.f5463a;
        }
    }

    public static final void m(k tmp0, Object obj) {
        r.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void n(HiddenActivity this$0, Exception e4) {
        r.f(this$0, "this$0");
        r.f(e4, "e");
        String str = ((e4 instanceof com.google.android.gms.common.api.b) && O.a.f3098a.a().contains(Integer.valueOf(((com.google.android.gms.common.api.b) e4).getStatusCode()))) ? "GET_INTERRUPTED" : "GET_NO_CREDENTIALS";
        ResultReceiver resultReceiver = this$0.f6898a;
        r.c(resultReceiver);
        this$0.y(resultReceiver, str, "During begin sign in, failure response from one tap: " + e4.getMessage());
    }

    public static final void p(k tmp0, Object obj) {
        r.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void q(HiddenActivity this$0, Exception e4) {
        r.f(this$0, "this$0");
        r.f(e4, "e");
        String str = ((e4 instanceof com.google.android.gms.common.api.b) && O.a.f3098a.a().contains(Integer.valueOf(((com.google.android.gms.common.api.b) e4).getStatusCode()))) ? "CREATE_INTERRUPTED" : "CREATE_UNKNOWN";
        ResultReceiver resultReceiver = this$0.f6898a;
        r.c(resultReceiver);
        this$0.y(resultReceiver, str, "During save password, found password failure response from one tap " + e4.getMessage());
    }

    public static final void s(k tmp0, Object obj) {
        r.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void t(HiddenActivity this$0, Exception e4) {
        r.f(this$0, "this$0");
        r.f(e4, "e");
        String str = ((e4 instanceof com.google.android.gms.common.api.b) && O.a.f3098a.a().contains(Integer.valueOf(((com.google.android.gms.common.api.b) e4).getStatusCode()))) ? "CREATE_INTERRUPTED" : "CREATE_UNKNOWN";
        ResultReceiver resultReceiver = this$0.f6898a;
        r.c(resultReceiver);
        this$0.y(resultReceiver, str, "During create public key credential, fido registration failure: " + e4.getMessage());
    }

    public static final void v(k tmp0, Object obj) {
        r.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void w(HiddenActivity this$0, Exception e4) {
        r.f(this$0, "this$0");
        r.f(e4, "e");
        String str = ((e4 instanceof com.google.android.gms.common.api.b) && O.a.f3098a.a().contains(Integer.valueOf(((com.google.android.gms.common.api.b) e4).getStatusCode()))) ? "GET_INTERRUPTED" : "GET_NO_CREDENTIALS";
        ResultReceiver resultReceiver = this$0.f6898a;
        r.c(resultReceiver);
        this$0.y(resultReceiver, str, "During get sign-in intent, failure response from one tap: " + e4.getMessage());
    }

    public final void l() {
        Task taskAddOnFailureListener;
        C1745b c1745b = (C1745b) getIntent().getParcelableExtra("REQUEST_TYPE");
        int intExtra = getIntent().getIntExtra("ACTIVITY_REQUEST_CODE", 1);
        if (c1745b != null) {
            Task taskBeginSignIn = AbstractC1750g.b(this).beginSignIn(c1745b);
            final b bVar = new b(intExtra);
            taskAddOnFailureListener = taskBeginSignIn.addOnSuccessListener(new OnSuccessListener() { // from class: N.g
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    HiddenActivity.m(bVar, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: N.h
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    HiddenActivity.n(this.f2707a, exc);
                }
            });
        } else {
            taskAddOnFailureListener = null;
        }
        if (taskAddOnFailureListener == null) {
            Log.i("HiddenActivity", "During begin sign in, params is null, nothing to launch for begin sign in");
            finish();
        }
    }

    public final void o() {
        Task taskAddOnFailureListener;
        i iVar = (i) getIntent().getParcelableExtra("REQUEST_TYPE");
        int intExtra = getIntent().getIntExtra("ACTIVITY_REQUEST_CODE", 1);
        if (iVar != null) {
            Task taskSavePassword = AbstractC1750g.a(this).savePassword(iVar);
            final c cVar = new c(intExtra);
            taskAddOnFailureListener = taskSavePassword.addOnSuccessListener(new OnSuccessListener() { // from class: N.c
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    HiddenActivity.p(cVar, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: N.d
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    HiddenActivity.q(this.f2703a, exc);
                }
            });
        } else {
            taskAddOnFailureListener = null;
        }
        if (taskAddOnFailureListener == null) {
            Log.i("HiddenActivity", "During save password, params is null, nothing to launch for create password");
            finish();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        Bundle bundle = new Bundle();
        bundle.putBoolean("FAILURE_RESPONSE", false);
        bundle.putInt("ACTIVITY_REQUEST_CODE", i4);
        bundle.putParcelable("RESULT_DATA", intent);
        ResultReceiver resultReceiver = this.f6898a;
        if (resultReceiver != null) {
            resultReceiver.send(i5, bundle);
        }
        this.f6899b = false;
        finish();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        String stringExtra = getIntent().getStringExtra("TYPE");
        ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("RESULT_RECEIVER");
        this.f6898a = resultReceiver;
        if (resultReceiver == null) {
            finish();
        }
        x(bundle);
        if (this.f6899b) {
            return;
        }
        if (stringExtra != null) {
            switch (stringExtra.hashCode()) {
                case -441061071:
                    if (stringExtra.equals("BEGIN_SIGN_IN")) {
                        l();
                        return;
                    }
                    break;
                case 15545322:
                    if (stringExtra.equals("CREATE_PUBLIC_KEY_CREDENTIAL")) {
                        r();
                        return;
                    }
                    break;
                case 1246634622:
                    if (stringExtra.equals("CREATE_PASSWORD")) {
                        o();
                        return;
                    }
                    break;
                case 1980564212:
                    if (stringExtra.equals("SIGN_IN_INTENT")) {
                        u();
                        return;
                    }
                    break;
            }
        }
        Log.w("HiddenActivity", "Activity handed an unsupported type");
        finish();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        r.f(outState, "outState");
        outState.putBoolean("androidx.credentials.playservices.AWAITING_RESULT", this.f6899b);
        super.onSaveInstanceState(outState);
    }

    public final void r() {
        Task taskAddOnFailureListener;
        C0484u c0484u = (C0484u) getIntent().getParcelableExtra("REQUEST_TYPE");
        int intExtra = getIntent().getIntExtra("ACTIVITY_REQUEST_CODE", 1);
        if (c0484u != null) {
            Task taskD = L1.a.a(this).d(c0484u);
            final d dVar = new d(intExtra);
            taskAddOnFailureListener = taskD.addOnSuccessListener(new OnSuccessListener() { // from class: N.a
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    HiddenActivity.s(dVar, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: N.b
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    HiddenActivity.t(this.f2701a, exc);
                }
            });
        } else {
            taskAddOnFailureListener = null;
        }
        if (taskAddOnFailureListener == null) {
            Log.w("HiddenActivity", "During create public key credential, request is null, so nothing to launch for public key credentials");
            finish();
        }
    }

    public final void u() {
        Task taskAddOnFailureListener;
        C1749f c1749f = (C1749f) getIntent().getParcelableExtra("REQUEST_TYPE");
        int intExtra = getIntent().getIntExtra("ACTIVITY_REQUEST_CODE", 1);
        if (c1749f != null) {
            Task signInIntent = AbstractC1750g.b(this).getSignInIntent(c1749f);
            final e eVar = new e(intExtra);
            taskAddOnFailureListener = signInIntent.addOnSuccessListener(new OnSuccessListener() { // from class: N.e
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    HiddenActivity.v(eVar, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: N.f
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    HiddenActivity.w(this.f2705a, exc);
                }
            });
        } else {
            taskAddOnFailureListener = null;
        }
        if (taskAddOnFailureListener == null) {
            Log.i("HiddenActivity", "During get sign-in intent, params is null, nothing to launch for get sign-in intent");
            finish();
        }
    }

    public final void x(Bundle bundle) {
        if (bundle != null) {
            this.f6899b = bundle.getBoolean("androidx.credentials.playservices.AWAITING_RESULT", false);
        }
    }

    public final void y(ResultReceiver resultReceiver, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("FAILURE_RESPONSE", true);
        bundle.putString("EXCEPTION_TYPE", str);
        bundle.putString("EXCEPTION_MESSAGE", str2);
        resultReceiver.send(Integer.MAX_VALUE, bundle);
        finish();
    }
}
