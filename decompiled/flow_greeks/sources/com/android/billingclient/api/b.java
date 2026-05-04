package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.a;
import com.google.android.gms.internal.play_billing.zzac;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzil;
import d3.f;
import d3.g;
import d3.o1;
import d3.p1;
import d3.y0;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends zzac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f5144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p1 f5145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5146c;

    public /* synthetic */ b(g gVar, p1 p1Var, int i10, y0 y0Var) {
        this.f5144a = gVar;
        this.f5145b = p1Var;
        this.f5146c = i10;
    }

    @Override // com.google.android.gms.internal.play_billing.zzad
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            p1 p1Var = this.f5145b;
            zzie zzieVar = zzie.NULL_BUNDLE_FROM_GET_BILLING_CONFIG_SERVICE_CALL;
            a aVar = c.f5154h;
            int i10 = o1.f7730a;
            p1Var.k(o1.b(zzieVar, 13, aVar, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.f5146c);
            this.f5144a.a(aVar, null);
            return;
        }
        int iZzb = zzc.zzb(bundle, "BillingClient");
        String strZzj = zzc.zzj(bundle, "BillingClient");
        a.C0091a c0091aD = a.d();
        c0091aD.d(iZzb);
        c0091aD.b(strZzj);
        if (iZzb != 0) {
            zzc.zzn("BillingClient", "getBillingConfig() failed. Response code: " + iZzb);
            a aVarA = c0091aD.a();
            p1 p1Var2 = this.f5145b;
            zzie zzieVar2 = zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            int i11 = o1.f7730a;
            p1Var2.k(o1.b(zzieVar2, 13, aVarA, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.f5146c);
            this.f5144a.a(aVarA, null);
            return;
        }
        if (!bundle.containsKey("BILLING_CONFIG")) {
            zzc.zzn("BillingClient", "getBillingConfig() returned a bundle with neither an error nor a billing config response");
            c0091aD.d(6);
            a aVarA2 = c0091aD.a();
            p1 p1Var3 = this.f5145b;
            zzie zzieVar3 = zzie.MISSING_BILLING_CONFIG_IN_GET_BILLING_CONFIG_RESPONSE;
            int i12 = o1.f7730a;
            p1Var3.k(o1.b(zzieVar3, 13, aVarA2, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.f5146c);
            this.f5144a.a(aVarA2, null);
            return;
        }
        try {
            this.f5144a.a(c0091aD.a(), new f(bundle.getString("BILLING_CONFIG")));
        } catch (JSONException e10) {
            zzc.zzo("BillingClient", "Got a JSON exception trying to decode BillingConfig. \n Exception: ", e10);
            p1 p1Var4 = this.f5145b;
            zzie zzieVar4 = zzie.ERROR_DECODING_BILLING_CONFIG_DATA;
            a aVar2 = c.f5154h;
            int i13 = o1.f7730a;
            p1Var4.k(o1.b(zzieVar4, 13, aVar2, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.f5146c);
            this.f5144a.a(aVar2, null);
        }
    }
}
