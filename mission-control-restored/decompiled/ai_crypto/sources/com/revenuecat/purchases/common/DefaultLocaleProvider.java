package com.revenuecat.purchases.common;

import M.i;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultLocaleProvider implements LocaleProvider {
    @Override // com.revenuecat.purchases.common.LocaleProvider
    public String getCurrentLocalesLanguageTags() {
        String strH = i.d().h();
        r.e(strH, "getDefault().toLanguageTags()");
        return strH;
    }
}
