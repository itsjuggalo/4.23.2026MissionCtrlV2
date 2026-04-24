package com.revenuecat.purchases.models;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: RawDataContainer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u0012\u0010\u0003\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/models/RawDataContainer;", "DataType", "", Constants.MessagePayloadKeys.RAW_DATA, "getRawData", "()Ljava/lang/Object;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface RawDataContainer<DataType> {
    DataType getRawData();
}
