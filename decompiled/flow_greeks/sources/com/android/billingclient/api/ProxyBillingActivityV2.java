package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.h;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzie;
import e.f;
import f.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@UsedByReflection("PlatformActivityProxy")
public class ProxyBillingActivityV2 extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e.c f5129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e.c f5130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e.c f5131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ResultReceiver f5132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ResultReceiver f5133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ResultReceiver f5134f;

    public final void f(e.a aVar) {
        Intent intentA = aVar.a();
        int iC = zzc.zzh(intentA, "ProxyBillingActivityV2").c();
        ResultReceiver resultReceiver = this.f5132d;
        if (resultReceiver != null) {
            resultReceiver.send(iC, intentA == null ? null : intentA.getExtras());
        }
        if (aVar.b() != -1 || iC != 0) {
            zzc.zzn("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + aVar.b() + " and billing's responseCode: " + iC);
        }
        finish();
    }

    public final void g(e.a aVar) {
        Intent intentA = aVar.a();
        int iC = zzc.zzh(intentA, "ProxyBillingActivityV2").c();
        ResultReceiver resultReceiver = this.f5133e;
        if (resultReceiver != null) {
            resultReceiver.send(iC, intentA == null ? null : intentA.getExtras());
        }
        if (aVar.b() != -1 || iC != 0) {
            zzc.zzn("ProxyBillingActivityV2", String.format("External offer dialog finished with resultCode: %s and billing's responseCode: %s", Integer.valueOf(aVar.b()), Integer.valueOf(iC)));
        }
        finish();
    }

    public final void h(e.a aVar) {
        Intent intentA = aVar.a();
        Bundle extras = intentA == null ? null : intentA.getExtras();
        if (aVar.b() != -1) {
            if (extras == null) {
                extras = new Bundle();
            }
            zzc.zzn("ProxyBillingActivityV2", String.format("External offer flow finished with resultCode: %s", Integer.valueOf(aVar.b())));
            extras.putInt("INTERNAL_LOG_ERROR_REASON", zzie.ERROR_IN_ACTIVITY_RESULT.zza());
            extras.putString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS", String.format("External offer flow finished with error resultCode: %s", Integer.valueOf(aVar.b())));
        }
        int iC = zzc.zzh(intentA, "ProxyBillingActivityV2").c();
        ResultReceiver resultReceiver = this.f5134f;
        if (resultReceiver != null) {
            resultReceiver.send(iC, extras);
        } else {
            zzc.zzn("ProxyBillingActivityV2", "External offer flow result receiver is null");
        }
        if (iC != 0) {
            zzc.zzn("ProxyBillingActivityV2", String.format("External offer flow finished with billing responseCode: %s", Integer.valueOf(iC)));
        }
        finish();
    }

    @Override // androidx.activity.h, h0.f, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5129a = registerForActivityResult(new d(), new e.b() { // from class: d3.a2
            @Override // e.b
            public final void a(Object obj) {
                this.f7584a.f((e.a) obj);
            }
        });
        this.f5130b = registerForActivityResult(new d(), new e.b() { // from class: d3.b2
            @Override // e.b
            public final void a(Object obj) {
                this.f7589a.g((e.a) obj);
            }
        });
        this.f5131c = registerForActivityResult(new d(), new e.b() { // from class: d3.c2
            @Override // e.b
            public final void a(Object obj) {
                this.f7601a.h((e.a) obj);
            }
        });
        if (bundle != null) {
            if (bundle.containsKey("alternative_billing_only_dialog_result_receiver")) {
                this.f5132d = (ResultReceiver) bundle.getParcelable("alternative_billing_only_dialog_result_receiver");
            }
            if (bundle.containsKey("external_payment_dialog_result_receiver")) {
                this.f5133e = (ResultReceiver) bundle.getParcelable("external_payment_dialog_result_receiver");
            }
            if (bundle.containsKey("external_offer_flow_result_receiver")) {
                this.f5134f = (ResultReceiver) bundle.getParcelable("external_offer_flow_result_receiver");
                return;
            }
            return;
        }
        zzc.zzm("ProxyBillingActivityV2", "Launching Play Store billing dialog");
        if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
            PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
            this.f5132d = (ResultReceiver) getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
            this.f5129a.a(new f.a(pendingIntent).a());
        } else if (getIntent().hasExtra("external_payment_dialog_pending_intent")) {
            PendingIntent pendingIntent2 = (PendingIntent) getIntent().getParcelableExtra("external_payment_dialog_pending_intent");
            this.f5133e = (ResultReceiver) getIntent().getParcelableExtra("external_payment_dialog_result_receiver");
            this.f5130b.a(new f.a(pendingIntent2).a());
        } else if (getIntent().hasExtra("external_offer_flow_pending_intent")) {
            PendingIntent pendingIntent3 = (PendingIntent) getIntent().getParcelableExtra("external_offer_flow_pending_intent");
            this.f5134f = (ResultReceiver) getIntent().getParcelableExtra("external_offer_flow_result_receiver");
            this.f5131c.a(new f.a(pendingIntent3).a());
        }
    }

    @Override // androidx.activity.h, h0.f, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.f5132d;
        if (resultReceiver != null) {
            bundle.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.f5133e;
        if (resultReceiver2 != null) {
            bundle.putParcelable("external_payment_dialog_result_receiver", resultReceiver2);
        }
        ResultReceiver resultReceiver3 = this.f5134f;
        if (resultReceiver3 != null) {
            bundle.putParcelable("external_offer_flow_result_receiver", resultReceiver3);
        }
    }
}
