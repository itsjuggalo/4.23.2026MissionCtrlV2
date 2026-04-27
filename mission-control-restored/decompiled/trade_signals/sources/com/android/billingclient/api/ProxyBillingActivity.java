package com.android.billingclient.api;

import R0.AbstractC0835q0;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.api.a;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.R2;
import com.google.android.gms.internal.play_billing.V;
import com.google.android.gms.internal.play_billing.Y2;

/* JADX INFO: loaded from: classes.dex */
@UsedByReflection("PlatformActivityProxy")
public class ProxyBillingActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ResultReceiver f14654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f14658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f14659f;

    public final R2 a(int i8) {
        return i8 != -1 ? i8 != 0 ? i8 != 3 ? i8 != 4 ? i8 != 5 ? R2.NULL_DATA_WITH_OTHER_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT : R2.NULL_DATA_WITH_ON_CREATE_RUNTIME_EXCEPTION_RESULT_CODE : R2.NULL_DATA_WITH_PLAY_CANCELED_WITHOUT_COMPLETE_ACTION_RESULT_CODE : R2.NULL_DATA_WITH_PLAY_CANCELED_RESULT_CODE : R2.NULL_DATA_WITH_CANCELLED_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT : R2.NULL_DATA_WITH_OK_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT;
    }

    public final Intent b(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    public final Intent c(R2 r22, long j8) {
        Intent intentD = d();
        intentD.putExtra("RESPONSE_CODE", 6);
        intentD.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
        a.C0247a c0247aD = a.d();
        c0247aD.d(6);
        c0247aD.b("An internal error occurred.");
        a aVarA = c0247aD.a();
        int i8 = AbstractC0835q0.f7070a;
        intentD.putExtra("FAILURE_LOGGING_PAYLOAD", AbstractC0835q0.b(r22, 2, aVarA, null, Y2.BROADCAST_ACTION_UNSPECIFIED).a());
        intentD.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
        intentD.putExtra("billingClientTransactionId", j8);
        intentD.putExtra("wasServiceAutoReconnected", this.f14659f);
        return intentD;
    }

    public final Intent d() {
        Intent intent = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d6  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResult(int r6, int r7, android.content.Intent r8) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.ProxyBillingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        int i8;
        super.onCreate(bundle);
        if (bundle != null) {
            V.l("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.f14655b = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
            if (bundle.containsKey("in_app_message_result_receiver")) {
                this.f14654a = (ResultReceiver) bundle.getParcelable("in_app_message_result_receiver");
            }
            this.f14656c = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            this.f14657d = bundle.getInt("activity_code", 100);
            if (bundle.containsKey("billingClientTransactionId")) {
                this.f14658e = bundle.getLong("billingClientTransactionId");
            }
            if (bundle.containsKey("wasServiceAutoReconnected")) {
                this.f14659f = bundle.getBoolean("wasServiceAutoReconnected");
                return;
            }
            return;
        }
        V.l("ProxyBillingActivity", "Launching Play Store billing flow");
        this.f14657d = 100;
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                this.f14656c = true;
                i8 = 110;
                this.f14657d = i8;
            }
        } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
            this.f14654a = (ResultReceiver) getIntent().getParcelableExtra("in_app_message_result_receiver");
            i8 = 101;
            this.f14657d = i8;
        } else {
            pendingIntent = null;
        }
        if (getIntent().hasExtra("billingClientTransactionId")) {
            this.f14658e = getIntent().getLongExtra("billingClientTransactionId", 0L);
        }
        if (getIntent().hasExtra("wasServiceAutoReconnected")) {
            this.f14659f = getIntent().getBooleanExtra("wasServiceAutoReconnected", false);
        }
        try {
            this.f14655b = true;
            startIntentSenderForResult(pendingIntent.getIntentSender(), this.f14657d, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e8) {
            V.n("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", e8);
            ResultReceiver resultReceiver = this.f14654a;
            if (resultReceiver != null) {
                resultReceiver.send(0, null);
            } else {
                Intent intentC = c(R2.INTENT_SENDER_EXCEPTION, this.f14658e);
                if (this.f14656c) {
                    intentC.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                }
                sendBroadcast(intentC);
            }
            this.f14655b = false;
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.f14655b) {
            Intent intentD = d();
            intentD.putExtra("RESPONSE_CODE", 1);
            intentD.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            if (this.f14656c) {
                intentD.putExtra("IS_FIRST_PARTY_PURCHASE", true);
            }
            int i8 = this.f14657d;
            if (i8 == 110 || i8 == 100) {
                intentD.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                intentD.putExtra("billingClientTransactionId", this.f14658e);
            }
            sendBroadcast(intentD);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.f14654a;
        if (resultReceiver != null) {
            bundle.putParcelable("in_app_message_result_receiver", resultReceiver);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.f14655b);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.f14656c);
        bundle.putInt("activity_code", this.f14657d);
        bundle.putLong("billingClientTransactionId", this.f14658e);
        bundle.putBoolean("wasServiceAutoReconnected", this.f14659f);
    }
}
