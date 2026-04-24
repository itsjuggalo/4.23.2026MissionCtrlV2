package com.revenuecat.purchases.customercenter;

import X2.K;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerCenterConfigData$Localization$VariableName$Companion$valueMap$2 extends s implements Function0 {
    public static final CustomerCenterConfigData$Localization$VariableName$Companion$valueMap$2 INSTANCE = new CustomerCenterConfigData$Localization$VariableName$Companion$valueMap$2();

    public CustomerCenterConfigData$Localization$VariableName$Companion$valueMap$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Map<String, CustomerCenterConfigData.Localization.VariableName> invoke() {
        CustomerCenterConfigData.Localization.VariableName[] variableNameArrValues = CustomerCenterConfigData.Localization.VariableName.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC1681l.b(K.b(variableNameArrValues.length), 16));
        for (CustomerCenterConfigData.Localization.VariableName variableName : variableNameArrValues) {
            linkedHashMap.put(variableName.getIdentifier(), variableName);
        }
        return linkedHashMap;
    }
}
