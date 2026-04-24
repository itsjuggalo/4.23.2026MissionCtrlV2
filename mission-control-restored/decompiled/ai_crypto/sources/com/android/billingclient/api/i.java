package com.android.billingclient.api;

import Y0.AbstractC0722e0;
import Y0.C0719d;
import Y0.InterfaceC0721e;
import Y0.InterfaceC0724f0;
import Y0.M;
import android.os.Bundle;
import com.android.billingclient.api.d;
import com.google.android.gms.internal.play_billing.zzad;
import com.google.android.gms.internal.play_billing.zze;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final class i extends zzad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0721e f10667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0724f0 f10668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10669c;

    public /* synthetic */ i(InterfaceC0721e interfaceC0721e, InterfaceC0724f0 interfaceC0724f0, int i7, M m7) {
        this.f10667a = interfaceC0721e;
        this.f10668b = interfaceC0724f0;
        this.f10669c = i7;
    }

    @Override // com.google.android.gms.internal.play_billing.zzae
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            InterfaceC0724f0 interfaceC0724f0 = this.f10668b;
            d dVar = k.f10692k;
            interfaceC0724f0.e(AbstractC0722e0.b(63, 13, dVar), this.f10669c);
            this.f10667a.a(dVar, null);
            return;
        }
        int iZzb = zze.zzb(bundle, "BillingClient");
        String strZzh = zze.zzh(bundle, "BillingClient");
        d.a aVarC = d.c();
        aVarC.c(iZzb);
        aVarC.b(strZzh);
        if (iZzb != 0) {
            zze.zzl("BillingClient", "getBillingConfig() failed. Response code: " + iZzb);
            d dVarA = aVarC.a();
            this.f10668b.e(AbstractC0722e0.b(23, 13, dVarA), this.f10669c);
            this.f10667a.a(dVarA, null);
            return;
        }
        if (!bundle.containsKey("BILLING_CONFIG")) {
            zze.zzl("BillingClient", "getBillingConfig() returned a bundle with neither an error nor a billing config response");
            aVarC.c(6);
            d dVarA2 = aVarC.a();
            this.f10668b.e(AbstractC0722e0.b(64, 13, dVarA2), this.f10669c);
            this.f10667a.a(dVarA2, null);
            return;
        }
        try {
            this.f10667a.a(aVarC.a(), new C0719d(bundle.getString("BILLING_CONFIG")));
        } catch (JSONException e7) {
            zze.zzm("BillingClient", "Got a JSON exception trying to decode BillingConfig. \n Exception: ", e7);
            InterfaceC0724f0 interfaceC0724f02 = this.f10668b;
            d dVar2 = k.f10692k;
            interfaceC0724f02.e(AbstractC0722e0.b(65, 13, dVar2), this.f10669c);
            this.f10667a.a(dVar2, null);
        }
    }
}
