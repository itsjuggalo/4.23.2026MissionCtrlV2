package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zze;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;

/* JADX INFO: loaded from: classes.dex */
public class ProxyBillingActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ResultReceiver f9358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ResultReceiver f9359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9360c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9362f;

    public final Intent a(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    public final Intent b() {
        Intent intent = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResult(int r8, int r9, android.content.Intent r10) {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.ProxyBillingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        super.onCreate(bundle);
        if (bundle != null) {
            zze.zzk("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.f9360c = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
            if (bundle.containsKey(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER)) {
                this.f9358a = (ResultReceiver) bundle.getParcelable(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER);
            } else if (bundle.containsKey("in_app_message_result_receiver")) {
                this.f9359b = (ResultReceiver) bundle.getParcelable("in_app_message_result_receiver");
            }
            this.f9361e = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            this.f9362f = bundle.getInt("activity_code", 100);
            return;
        }
        zze.zzk("ProxyBillingActivity", "Launching Play Store billing flow");
        this.f9362f = 100;
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                this.f9361e = true;
                this.f9362f = 110;
            }
        } else if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
            this.f9358a = (ResultReceiver) getIntent().getParcelableExtra(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER);
        } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
            this.f9359b = (ResultReceiver) getIntent().getParcelableExtra("in_app_message_result_receiver");
            this.f9362f = 101;
        } else {
            pendingIntent = null;
        }
        try {
            this.f9360c = true;
            startIntentSenderForResult(pendingIntent.getIntentSender(), this.f9362f, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e4) {
            zze.zzm("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", e4);
            ResultReceiver resultReceiver = this.f9358a;
            if (resultReceiver != null) {
                resultReceiver.send(6, null);
            } else {
                ResultReceiver resultReceiver2 = this.f9359b;
                if (resultReceiver2 != null) {
                    resultReceiver2.send(0, null);
                } else {
                    Intent intentB = b();
                    if (this.f9361e) {
                        intentB.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                    }
                    intentB.putExtra("RESPONSE_CODE", 6);
                    intentB.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    sendBroadcast(intentB);
                }
            }
            this.f9360c = false;
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.f9360c) {
            Intent intentB = b();
            intentB.putExtra("RESPONSE_CODE", 1);
            intentB.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            int i4 = this.f9362f;
            if (i4 == 110 || i4 == 100) {
                intentB.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
            }
            sendBroadcast(intentB);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.f9358a;
        if (resultReceiver != null) {
            bundle.putParcelable(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER, resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.f9359b;
        if (resultReceiver2 != null) {
            bundle.putParcelable("in_app_message_result_receiver", resultReceiver2);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.f9360c);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.f9361e);
        bundle.putInt("activity_code", this.f9362f);
    }
}
