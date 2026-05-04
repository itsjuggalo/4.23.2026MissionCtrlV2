package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.api.a;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzil;
import d3.o1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@UsedByReflection("PlatformActivityProxy")
public class ProxyBillingActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ResultReceiver f5123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f5127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5128f;

    public final zzie a(int i10) {
        return i10 != -1 ? i10 != 0 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? zzie.NULL_DATA_WITH_OTHER_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT : zzie.NULL_DATA_WITH_ON_CREATE_RUNTIME_EXCEPTION_RESULT_CODE : zzie.NULL_DATA_WITH_PLAY_CANCELED_WITHOUT_COMPLETE_ACTION_RESULT_CODE : zzie.NULL_DATA_WITH_PLAY_CANCELED_RESULT_CODE : zzie.NULL_DATA_WITH_CANCELLED_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT : zzie.NULL_DATA_WITH_OK_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT;
    }

    public final Intent b(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    public final Intent c(zzie zzieVar, long j10) {
        Intent intentD = d();
        intentD.putExtra("RESPONSE_CODE", 6);
        intentD.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
        a.C0091a c0091aD = a.d();
        c0091aD.d(6);
        c0091aD.b("An internal error occurred.");
        a aVarA = c0091aD.a();
        int i10 = o1.f7730a;
        intentD.putExtra("FAILURE_LOGGING_PAYLOAD", o1.b(zzieVar, 2, aVarA, null, zzil.BROADCAST_ACTION_UNSPECIFIED).zzM());
        intentD.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
        intentD.putExtra("billingClientTransactionId", j10);
        intentD.putExtra("wasServiceAutoReconnected", this.f5128f);
        return intentD;
    }

    public final Intent d() {
        Intent intent = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResult(int r6, int r7, android.content.Intent r8) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.ProxyBillingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        super.onCreate(bundle);
        if (bundle != null) {
            zzc.zzm("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.f5124b = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
            if (bundle.containsKey("in_app_message_result_receiver")) {
                this.f5123a = (ResultReceiver) bundle.getParcelable("in_app_message_result_receiver");
            }
            this.f5125c = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            this.f5126d = bundle.getInt("activity_code", 100);
            if (bundle.containsKey("billingClientTransactionId")) {
                this.f5127e = bundle.getLong("billingClientTransactionId");
            }
            if (bundle.containsKey("wasServiceAutoReconnected")) {
                this.f5128f = bundle.getBoolean("wasServiceAutoReconnected");
                return;
            }
            return;
        }
        zzc.zzm("ProxyBillingActivity", "Launching Play Store billing flow");
        this.f5126d = 100;
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                this.f5125c = true;
                this.f5126d = 110;
            }
        } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
            this.f5123a = (ResultReceiver) getIntent().getParcelableExtra("in_app_message_result_receiver");
            this.f5126d = 101;
        } else {
            pendingIntent = null;
        }
        if (getIntent().hasExtra("billingClientTransactionId")) {
            this.f5127e = getIntent().getLongExtra("billingClientTransactionId", 0L);
        }
        if (getIntent().hasExtra("wasServiceAutoReconnected")) {
            this.f5128f = getIntent().getBooleanExtra("wasServiceAutoReconnected", false);
        }
        try {
            this.f5124b = true;
            startIntentSenderForResult(pendingIntent.getIntentSender(), this.f5126d, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e10) {
            zzc.zzo("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", e10);
            ResultReceiver resultReceiver = this.f5123a;
            if (resultReceiver != null) {
                resultReceiver.send(0, null);
            } else {
                Intent intentC = c(zzie.INTENT_SENDER_EXCEPTION, this.f5127e);
                if (this.f5125c) {
                    intentC.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                }
                sendBroadcast(intentC);
            }
            this.f5124b = false;
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.f5124b) {
            Intent intentD = d();
            intentD.putExtra("RESPONSE_CODE", 1);
            intentD.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            if (this.f5125c) {
                intentD.putExtra("IS_FIRST_PARTY_PURCHASE", true);
            }
            int i10 = this.f5126d;
            if (i10 == 110 || i10 == 100) {
                intentD.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                intentD.putExtra("billingClientTransactionId", this.f5127e);
            }
            sendBroadcast(intentD);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.f5123a;
        if (resultReceiver != null) {
            bundle.putParcelable("in_app_message_result_receiver", resultReceiver);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.f5124b);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.f5125c);
        bundle.putInt("activity_code", this.f5126d);
        bundle.putLong("billingClientTransactionId", this.f5127e);
        bundle.putBoolean("wasServiceAutoReconnected", this.f5128f);
    }
}
