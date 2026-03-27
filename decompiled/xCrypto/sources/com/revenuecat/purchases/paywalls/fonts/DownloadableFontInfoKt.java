package com.revenuecat.purchases.paywalls.fonts;

import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.utils.Result;
import kotlin.jvm.internal.r;
import r3.AbstractC1753A;

/* JADX INFO: loaded from: classes3.dex */
public final class DownloadableFontInfoKt {
    public static final /* synthetic */ Result toDownloadableFontInfo(UiConfig.AppConfig.FontsConfig.FontInfo.Name name) {
        r.f(name, "<this>");
        String url = name.getUrl();
        if (url == null || AbstractC1753A.U(url)) {
            return new Result.Error("Font URL is empty for " + name.getValue() + ". Cannot download font. Please try to re-upload your font in the RevenueCat dashboard.");
        }
        String hash = name.getHash();
        if (hash == null || AbstractC1753A.U(hash)) {
            return new Result.Error("Font hash is empty for " + name.getValue() + ". Cannot validate downloaded font. Please try to re-upload your font in the RevenueCat dashboard.");
        }
        String family = name.getFamily();
        if (family == null || AbstractC1753A.U(family)) {
            return new Result.Error("Font family is empty for " + name.getValue() + ". Cannot download font. Please try to re-upload your font in the RevenueCat dashboard.");
        }
        if (name.getWeight() == null) {
            return new Result.Error("Font weight is null for " + name.getValue() + ". Cannot download font. Please try to re-upload your font in the RevenueCat dashboard.");
        }
        if (name.getStyle() != null) {
            return new Result.Success(new DownloadableFontInfo(name.getUrl(), name.getHash(), name.getFamily(), name.getWeight().intValue(), name.getStyle()));
        }
        return new Result.Error("Font style is null for " + name.getValue() + ". Cannot download font. Please try to re-upload your font in the RevenueCat dashboard.");
    }
}
