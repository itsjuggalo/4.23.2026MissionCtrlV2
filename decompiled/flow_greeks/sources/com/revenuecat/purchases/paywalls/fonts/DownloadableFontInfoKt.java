package com.revenuecat.purchases.paywalls.fonts;

import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.utils.Result;
import kg.c0;
import kotlin.Metadata;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toDownloadableFontInfo", "Lcom/revenuecat/purchases/utils/Result;", "Lcom/revenuecat/purchases/paywalls/fonts/DownloadableFontInfo;", "", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DownloadableFontInfoKt {
    public static final /* synthetic */ Result toDownloadableFontInfo(UiConfig.AppConfig.FontsConfig.FontInfo.Name name) {
        t.f(name, "<this>");
        String url = name.getUrl();
        if (url == null || c0.e0(url)) {
            return new Result.Error("Font URL is empty for " + name.getValue() + ". Cannot download font. Please try to re-upload your font in the RevenueCat dashboard.");
        }
        String hash = name.getHash();
        if (hash == null || c0.e0(hash)) {
            return new Result.Error("Font hash is empty for " + name.getValue() + ". Cannot validate downloaded font. Please try to re-upload your font in the RevenueCat dashboard.");
        }
        String family = name.getFamily();
        if (family == null || c0.e0(family)) {
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
