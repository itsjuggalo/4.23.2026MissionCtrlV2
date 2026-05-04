package com.revenuecat.purchases.hybridcommon.mappers;

import cd.w;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrency;
import dd.o0;
import io.flutter.plugins.firebase.database.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"map", "", "", "", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrency;", "hybridcommon_bc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyMapperKt {
    public static final Map<String, Object> map(VirtualCurrency virtualCurrency) {
        t.f(virtualCurrency, "<this>");
        return o0.l(w.a("balance", Integer.valueOf(virtualCurrency.getBalance())), w.a("name", virtualCurrency.getName()), w.a(Constants.ERROR_CODE, virtualCurrency.getCode()), w.a("serverDescription", virtualCurrency.getServerDescription()));
    }
}
