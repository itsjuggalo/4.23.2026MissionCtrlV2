package com.android.billingclient.api;

import H0.s0;
import android.os.Bundle;
import com.android.billingclient.api.d;
import com.google.android.gms.internal.play_billing.zze;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public static s0 a(Bundle bundle, String str, String str2) {
        d dVar = k.f9507k;
        if (bundle == null) {
            zze.zzl("BillingClient", String.format("%s got null owned items list", str2));
            return new s0(dVar, 54);
        }
        int iZzb = zze.zzb(bundle, "BillingClient");
        String strZzh = zze.zzh(bundle, "BillingClient");
        d.a aVarC = d.c();
        aVarC.c(iZzb);
        aVarC.b(strZzh);
        d dVarA = aVarC.a();
        if (iZzb != 0) {
            zze.zzl("BillingClient", String.format("%s failed. Response code: %s", str2, Integer.valueOf(iZzb)));
            return new s0(dVarA, 23);
        }
        if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            zze.zzl("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", str2));
            return new s0(dVar, 55);
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        if (stringArrayList == null) {
            zze.zzl("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", str2));
            return new s0(dVar, 56);
        }
        if (stringArrayList2 == null) {
            zze.zzl("BillingClient", String.format("Bundle returned from %s contains null purchases list.", str2));
            return new s0(dVar, 57);
        }
        if (stringArrayList3 != null) {
            return new s0(k.f9508l, 1);
        }
        zze.zzl("BillingClient", String.format("Bundle returned from %s contains null signatures list.", str2));
        return new s0(dVar, 58);
    }
}
