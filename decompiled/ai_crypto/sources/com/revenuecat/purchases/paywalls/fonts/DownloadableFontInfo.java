package com.revenuecat.purchases.paywalls.fonts;

import com.revenuecat.purchases.paywalls.components.properties.FontStyle;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class DownloadableFontInfo {
    private final String expectedMd5;
    private final String family;
    private final FontStyle style;
    private final String url;
    private final int weight;

    public DownloadableFontInfo(String url, String expectedMd5, String family, int i7, FontStyle style) {
        r.f(url, "url");
        r.f(expectedMd5, "expectedMd5");
        r.f(family, "family");
        r.f(style, "style");
        this.url = url;
        this.expectedMd5 = expectedMd5;
        this.family = family;
        this.weight = i7;
        this.style = style;
    }

    public static /* synthetic */ DownloadableFontInfo copy$default(DownloadableFontInfo downloadableFontInfo, String str, String str2, String str3, int i7, FontStyle fontStyle, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = downloadableFontInfo.url;
        }
        if ((i8 & 2) != 0) {
            str2 = downloadableFontInfo.expectedMd5;
        }
        String str4 = str2;
        if ((i8 & 4) != 0) {
            str3 = downloadableFontInfo.family;
        }
        String str5 = str3;
        if ((i8 & 8) != 0) {
            i7 = downloadableFontInfo.weight;
        }
        int i9 = i7;
        if ((i8 & 16) != 0) {
            fontStyle = downloadableFontInfo.style;
        }
        return downloadableFontInfo.copy(str, str4, str5, i9, fontStyle);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.expectedMd5;
    }

    public final String component3() {
        return this.family;
    }

    public final int component4() {
        return this.weight;
    }

    public final FontStyle component5() {
        return this.style;
    }

    public final DownloadableFontInfo copy(String url, String expectedMd5, String family, int i7, FontStyle style) {
        r.f(url, "url");
        r.f(expectedMd5, "expectedMd5");
        r.f(family, "family");
        r.f(style, "style");
        return new DownloadableFontInfo(url, expectedMd5, family, i7, style);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadableFontInfo)) {
            return false;
        }
        DownloadableFontInfo downloadableFontInfo = (DownloadableFontInfo) obj;
        return r.b(this.url, downloadableFontInfo.url) && r.b(this.expectedMd5, downloadableFontInfo.expectedMd5) && r.b(this.family, downloadableFontInfo.family) && this.weight == downloadableFontInfo.weight && this.style == downloadableFontInfo.style;
    }

    public final /* synthetic */ String getExpectedMd5() {
        return this.expectedMd5;
    }

    public final /* synthetic */ String getFamily() {
        return this.family;
    }

    public final /* synthetic */ FontStyle getStyle() {
        return this.style;
    }

    public final /* synthetic */ String getUrl() {
        return this.url;
    }

    public final /* synthetic */ int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((((((this.url.hashCode() * 31) + this.expectedMd5.hashCode()) * 31) + this.family.hashCode()) * 31) + Integer.hashCode(this.weight)) * 31) + this.style.hashCode();
    }

    public String toString() {
        return "DownloadableFontInfo(url=" + this.url + ", expectedMd5=" + this.expectedMd5 + ", family=" + this.family + ", weight=" + this.weight + ", style=" + this.style + ')';
    }
}
