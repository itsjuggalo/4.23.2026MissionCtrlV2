package com.revenuecat.purchases.google;

import com.revenuecat.purchases.common.LogIntent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/revenuecat/purchases/common/LogWrapperKt$log$fullMessageBuilder$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class BillingWrapper$onPurchasesUpdated$$inlined$log$1 extends v implements Function0 {
    final /* synthetic */ com.android.billingclient.api.a $billingResult$inlined;
    final /* synthetic */ LogIntent $intent;
    final /* synthetic */ List $notNullPurchasesList$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingWrapper$onPurchasesUpdated$$inlined$log$1(LogIntent logIntent, com.android.billingclient.api.a aVar, List list) {
        super(0);
        this.$intent = logIntent;
        this.$billingResult$inlined = aVar;
        this.$notNullPurchasesList$inlined = list;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0073  */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String invoke() {
        /*
            r12 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.revenuecat.purchases.common.LogIntent r1 = r12.$intent
            java.util.List r2 = r1.getEmojiList()
            r9 = 62
            r10 = 0
            java.lang.String r3 = ""
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r1 = dd.a0.i0(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0.append(r1)
            r1 = 32
            r0.append(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.android.billingclient.api.a r2 = r12.$billingResult$inlined
            java.lang.String r2 = com.revenuecat.purchases.google.BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(r2)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            r3 = 1
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r3)
            java.lang.String r3 = "BillingWrapper purchases failed to update: %s"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            java.lang.String r3 = "format(...)"
            kotlin.jvm.internal.t.e(r2, r3)
            r1.append(r2)
            java.util.List r2 = r12.$notNullPurchasesList$inlined
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L4d
        L4b:
            r3 = r2
            goto L4f
        L4d:
            r2 = 0
            goto L4b
        L4f:
            if (r3 == 0) goto L73
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = " Purchases:"
            r2.append(r4)
            com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$2$2$1 r9 = com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$2$2$1.INSTANCE
            r10 = 30
            r11 = 0
            java.lang.String r4 = ", "
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r3 = dd.a0.i0(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            if (r2 != 0) goto L75
        L73:
            java.lang.String r2 = " No purchases received"
        L75:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$$inlined$log$1.invoke():java.lang.String");
    }
}
