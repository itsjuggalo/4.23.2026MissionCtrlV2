package com.android.billingclient.api;

import R0.AbstractC0803a0;
import R0.AbstractC0835q0;
import R0.C0814g;
import R0.InterfaceC0816h;
import R0.r0;
import android.os.Bundle;
import com.android.billingclient.api.a;
import com.google.android.gms.internal.play_billing.AbstractBinderC1311b;
import com.google.android.gms.internal.play_billing.R2;
import com.google.android.gms.internal.play_billing.V;
import com.google.android.gms.internal.play_billing.Y2;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final class b extends AbstractBinderC1311b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0816h f14675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f14676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14677c;

    public /* synthetic */ b(InterfaceC0816h interfaceC0816h, r0 r0Var, int i8, AbstractC0803a0 abstractC0803a0) {
        this.f14675a = interfaceC0816h;
        this.f14676b = r0Var;
        this.f14677c = i8;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1316c
    public final void a(Bundle bundle) {
        if (bundle == null) {
            r0 r0Var = this.f14676b;
            R2 r22 = R2.NULL_BUNDLE_FROM_GET_BILLING_CONFIG_SERVICE_CALL;
            a aVar = c.f14691h;
            int i8 = AbstractC0835q0.f7070a;
            r0Var.k(AbstractC0835q0.b(r22, 13, aVar, null, Y2.BROADCAST_ACTION_UNSPECIFIED), this.f14677c);
            this.f14675a.a(aVar, null);
            return;
        }
        int iB = V.b(bundle, "BillingClient");
        String strI = V.i(bundle, "BillingClient");
        a.C0247a c0247aD = a.d();
        c0247aD.d(iB);
        c0247aD.b(strI);
        if (iB != 0) {
            V.m("BillingClient", "getBillingConfig() failed. Response code: " + iB);
            a aVarA = c0247aD.a();
            r0 r0Var2 = this.f14676b;
            R2 r23 = R2.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            int i9 = AbstractC0835q0.f7070a;
            r0Var2.k(AbstractC0835q0.b(r23, 13, aVarA, null, Y2.BROADCAST_ACTION_UNSPECIFIED), this.f14677c);
            this.f14675a.a(aVarA, null);
            return;
        }
        if (!bundle.containsKey("BILLING_CONFIG")) {
            V.m("BillingClient", "getBillingConfig() returned a bundle with neither an error nor a billing config response");
            c0247aD.d(6);
            a aVarA2 = c0247aD.a();
            r0 r0Var3 = this.f14676b;
            R2 r24 = R2.MISSING_BILLING_CONFIG_IN_GET_BILLING_CONFIG_RESPONSE;
            int i10 = AbstractC0835q0.f7070a;
            r0Var3.k(AbstractC0835q0.b(r24, 13, aVarA2, null, Y2.BROADCAST_ACTION_UNSPECIFIED), this.f14677c);
            this.f14675a.a(aVarA2, null);
            return;
        }
        try {
            this.f14675a.a(c0247aD.a(), new C0814g(bundle.getString("BILLING_CONFIG")));
        } catch (JSONException e8) {
            V.n("BillingClient", "Got a JSON exception trying to decode BillingConfig. \n Exception: ", e8);
            r0 r0Var4 = this.f14676b;
            R2 r25 = R2.ERROR_DECODING_BILLING_CONFIG_DATA;
            a aVar2 = c.f14691h;
            int i11 = AbstractC0835q0.f7070a;
            r0Var4.k(AbstractC0835q0.b(r25, 13, aVar2, null, Y2.BROADCAST_ACTION_UNSPECIFIED), this.f14677c);
            this.f14675a.a(aVar2, null);
        }
    }
}
