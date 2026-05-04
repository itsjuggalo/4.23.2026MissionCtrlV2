package com.revenuecat.purchases.paywalls;

import android.graphics.Color;
import dd.a0;
import kg.a;
import kg.c0;
import kg.k;
import kg.n;
import kotlin.Metadata;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a7\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\t\u0010\n\"\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "stringRepresentation", "", "parseRGBAColor", "(Ljava/lang/String;)I", "alpha", "red", "green", "blue", "colorInt", "(IIII)I", "Lkg/n;", "rgbaColorRegex", "Lkg/n;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ColorUtilsKt {
    private static final n rgbaColorRegex = new n("^#([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})?$");

    public static final int colorInt(int i10, int i11, int i12, int i13) {
        return (i10 << 24) | (i11 << 16) | (i12 << 8) | i13;
    }

    public static final int parseRGBAColor(String stringRepresentation) {
        t.f(stringRepresentation, "stringRepresentation");
        k kVarA = rgbaColorRegex.a(stringRepresentation);
        if (kVarA == null) {
            return Color.parseColor(stringRepresentation);
        }
        k.b bVarA = kVarA.a();
        String str = (String) bVarA.a().b().get(1);
        String str2 = (String) bVarA.a().b().get(2);
        String str3 = (String) bVarA.a().b().get(3);
        Object objC0 = a0.c0(kVarA.b(), 4);
        String str4 = (String) objC0;
        if (str4 == null || c0.e0(str4)) {
            objC0 = null;
        }
        String str5 = (String) objC0;
        if (str5 == null) {
            str5 = "FF";
        }
        return colorInt(Integer.parseInt(str5, a.a(16)), Integer.parseInt(str, a.a(16)), Integer.parseInt(str2, a.a(16)), Integer.parseInt(str3, a.a(16)));
    }
}
