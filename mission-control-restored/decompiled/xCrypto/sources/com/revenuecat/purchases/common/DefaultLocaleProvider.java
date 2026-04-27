package com.revenuecat.purchases.common;

import D.g;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultLocaleProvider implements LocaleProvider {
    private String preferredLocaleOverride;

    @Override // com.revenuecat.purchases.common.LocaleProvider
    public String getCurrentLocalesLanguageTags() {
        String str = this.preferredLocaleOverride;
        if (str != null) {
            String strH = g.d().h();
            r.e(strH, "getDefault().toLanguageTags()");
            if (strH.length() != 0) {
                str = str + ',' + strH;
            }
            if (str != null) {
                return str;
            }
        }
        String strH2 = g.d().h();
        r.e(strH2, "getDefault().toLanguageTags()");
        return strH2;
    }

    public final void setPreferredLocaleOverride(String str) {
        this.preferredLocaleOverride = str;
    }
}
