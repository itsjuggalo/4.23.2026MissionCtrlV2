package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zze;
import e.AbstractC1221c;
import e.C1219a;
import e.C1224f;
import e.InterfaceC1220b;
import f.C1241d;

/* JADX INFO: loaded from: classes.dex */
public class ProxyBillingActivityV2 extends androidx.activity.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC1221c f9363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AbstractC1221c f9364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ResultReceiver f9365c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ResultReceiver f9366e;

    public final void f(C1219a c1219a) {
        Intent intentA = c1219a.a();
        int iB = zze.zzf(intentA, "ProxyBillingActivityV2").b();
        ResultReceiver resultReceiver = this.f9365c;
        if (resultReceiver != null) {
            resultReceiver.send(iB, intentA == null ? null : intentA.getExtras());
        }
        if (c1219a.b() != -1 || iB != 0) {
            zze.zzl("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + c1219a.b() + " and billing's responseCode: " + iB);
        }
        finish();
    }

    public final void g(C1219a c1219a) {
        Intent intentA = c1219a.a();
        int iB = zze.zzf(intentA, "ProxyBillingActivityV2").b();
        ResultReceiver resultReceiver = this.f9366e;
        if (resultReceiver != null) {
            resultReceiver.send(iB, intentA == null ? null : intentA.getExtras());
        }
        if (c1219a.b() != -1 || iB != 0) {
            zze.zzl("ProxyBillingActivityV2", String.format("External offer dialog finished with resultCode: %s and billing's responseCode: %s", Integer.valueOf(c1219a.b()), Integer.valueOf(iB)));
        }
        finish();
    }

    @Override // androidx.activity.h, w.g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9363a = registerForActivityResult(new C1241d(), new InterfaceC1220b() { // from class: H0.p0
            @Override // e.InterfaceC1220b
            public final void a(Object obj) {
                this.f676a.f((C1219a) obj);
            }
        });
        this.f9364b = registerForActivityResult(new C1241d(), new InterfaceC1220b() { // from class: H0.q0
            @Override // e.InterfaceC1220b
            public final void a(Object obj) {
                this.f679a.g((C1219a) obj);
            }
        });
        if (bundle != null) {
            if (bundle.containsKey("alternative_billing_only_dialog_result_receiver")) {
                this.f9365c = (ResultReceiver) bundle.getParcelable("alternative_billing_only_dialog_result_receiver");
                return;
            } else {
                if (bundle.containsKey("external_payment_dialog_result_receiver")) {
                    this.f9366e = (ResultReceiver) bundle.getParcelable("external_payment_dialog_result_receiver");
                    return;
                }
                return;
            }
        }
        zze.zzk("ProxyBillingActivityV2", "Launching Play Store billing dialog");
        if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
            PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
            this.f9365c = (ResultReceiver) getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
            this.f9363a.a(new C1224f.a(pendingIntent).a());
        } else if (getIntent().hasExtra("external_payment_dialog_pending_intent")) {
            PendingIntent pendingIntent2 = (PendingIntent) getIntent().getParcelableExtra("external_payment_dialog_pending_intent");
            this.f9366e = (ResultReceiver) getIntent().getParcelableExtra("external_payment_dialog_result_receiver");
            this.f9364b.a(new C1224f.a(pendingIntent2).a());
        }
    }

    @Override // androidx.activity.h, w.g, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.f9365c;
        if (resultReceiver != null) {
            bundle.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.f9366e;
        if (resultReceiver2 != null) {
            bundle.putParcelable("external_payment_dialog_result_receiver", resultReceiver2);
        }
    }
}
