package com.revenuecat.purchases.interfaces;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;

/* JADX INFO: compiled from: PurchaseErrorCallback.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/interfaces/PurchaseErrorCallback;", "", "onError", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "userCancelled", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface PurchaseErrorCallback {
    void onError(PurchasesError error, boolean userCancelled);
}
