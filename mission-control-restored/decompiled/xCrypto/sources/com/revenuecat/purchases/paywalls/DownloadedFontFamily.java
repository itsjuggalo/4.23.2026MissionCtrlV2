package com.revenuecat.purchases.paywalls;

import X2.AbstractC0769p;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class DownloadedFontFamily {
    private final String family;
    private final List<DownloadedFont> fonts;

    public DownloadedFontFamily(String family, List<DownloadedFont> fonts) {
        r.f(family, "family");
        r.f(fonts, "fonts");
        this.family = family;
        this.fonts = fonts;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadedFontFamily)) {
            return false;
        }
        DownloadedFontFamily downloadedFontFamily = (DownloadedFontFamily) obj;
        return r.b(this.family, downloadedFontFamily.family) && r.b(this.fonts, downloadedFontFamily.fonts);
    }

    public final /* synthetic */ String getFamily() {
        return this.family;
    }

    public final /* synthetic */ List getFonts() {
        return this.fonts;
    }

    public int hashCode() {
        return (this.family.hashCode() * 31) + this.fonts.hashCode();
    }

    public String toString() {
        return "DownloadedFontFamily(family=" + this.family + ", fonts=" + this.fonts + ')';
    }

    public /* synthetic */ DownloadedFontFamily(String str, List list, int i4, AbstractC1585j abstractC1585j) {
        this(str, (i4 & 2) != 0 ? AbstractC0769p.g() : list);
    }
}
