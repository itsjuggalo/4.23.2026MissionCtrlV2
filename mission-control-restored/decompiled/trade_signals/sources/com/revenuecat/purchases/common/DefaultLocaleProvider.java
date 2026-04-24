package com.revenuecat.purchases.common;

import P.g;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/DefaultLocaleProvider;", "Lcom/revenuecat/purchases/common/LocaleProvider;", "()V", "currentLocalesLanguageTags", "", "getCurrentLocalesLanguageTags", "()Ljava/lang/String;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultLocaleProvider implements LocaleProvider {
    @Override // com.revenuecat.purchases.common.LocaleProvider
    public String getCurrentLocalesLanguageTags() {
        String strE = g.c().e();
        AbstractC2304t.e(strE, "getDefault().toLanguageTags()");
        return strE;
    }
}
