package com.android.billingclient.api;

import H0.AbstractC0301e0;
import H0.C0298d;
import H0.InterfaceC0300e;
import H0.InterfaceC0303f0;
import H0.M;
import android.os.Bundle;
import com.android.billingclient.api.d;
import com.google.android.gms.internal.play_billing.zzad;
import com.google.android.gms.internal.play_billing.zze;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final class i extends zzad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0300e f9482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0303f0 f9483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9484c;

    public /* synthetic */ i(InterfaceC0300e interfaceC0300e, InterfaceC0303f0 interfaceC0303f0, int i4, M m4) {
        this.f9482a = interfaceC0300e;
        this.f9483b = interfaceC0303f0;
        this.f9484c = i4;
    }

    @Override // com.google.android.gms.internal.play_billing.zzae
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            InterfaceC0303f0 interfaceC0303f0 = this.f9483b;
            d dVar = k.f9507k;
            interfaceC0303f0.e(AbstractC0301e0.b(63, 13, dVar), this.f9484c);
            this.f9482a.a(dVar, null);
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
            this.f9483b.e(AbstractC0301e0.b(23, 13, dVarA), this.f9484c);
            this.f9482a.a(dVarA, null);
            return;
        }
        if (!bundle.containsKey("BILLING_CONFIG")) {
            zze.zzl("BillingClient", "getBillingConfig() returned a bundle with neither an error nor a billing config response");
            aVarC.c(6);
            d dVarA2 = aVarC.a();
            this.f9483b.e(AbstractC0301e0.b(64, 13, dVarA2), this.f9484c);
            this.f9482a.a(dVarA2, null);
            return;
        }
        try {
            this.f9482a.a(aVarC.a(), new C0298d(bundle.getString("BILLING_CONFIG")));
        } catch (JSONException e4) {
            zze.zzm("BillingClient", "Got a JSON exception trying to decode BillingConfig. \n Exception: ", e4);
            InterfaceC0303f0 interfaceC0303f02 = this.f9483b;
            d dVar2 = k.f9507k;
            interfaceC0303f02.e(AbstractC0301e0.b(65, 13, dVar2), this.f9484c);
            this.f9482a.a(dVar2, null);
        }
    }
}
