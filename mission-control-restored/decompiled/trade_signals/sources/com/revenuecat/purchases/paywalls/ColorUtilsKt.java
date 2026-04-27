package com.revenuecat.purchases.paywalls;

import V6.AbstractC0975a;
import V6.C;
import V6.k;
import V6.n;
import android.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import p5.z;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a7\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\t\u0010\n\"\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "stringRepresentation", "", "parseRGBAColor", "(Ljava/lang/String;)I", "alpha", "red", "green", "blue", "colorInt", "(IIII)I", "LV6/n;", "rgbaColorRegex", "LV6/n;", "purchases_defaultsRelease"}, k = 2, mv = {1, 8, 0})
public final class ColorUtilsKt {
    private static final n rgbaColorRegex = new n("^#([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})?$");

    public static final int colorInt(int i8, int i9, int i10, int i11) {
        return (i8 << 24) | (i9 << 16) | (i10 << 8) | i11;
    }

    public static final int parseRGBAColor(String stringRepresentation) {
        AbstractC2304t.f(stringRepresentation, "stringRepresentation");
        k kVarA = rgbaColorRegex.a(stringRepresentation);
        if (kVarA == null) {
            return Color.parseColor(stringRepresentation);
        }
        k.b bVarA = kVarA.a();
        String str = (String) bVarA.a().b().get(1);
        String str2 = (String) bVarA.a().b().get(2);
        String str3 = (String) bVarA.a().b().get(3);
        Object objB0 = z.b0(kVarA.b(), 4);
        String str4 = (String) objB0;
        if (str4 == null || C.a0(str4)) {
            objB0 = null;
        }
        String str5 = (String) objB0;
        if (str5 == null) {
            str5 = "FF";
        }
        return colorInt(Integer.parseInt(str5, AbstractC0975a.a(16)), Integer.parseInt(str, AbstractC0975a.a(16)), Integer.parseInt(str2, AbstractC0975a.a(16)), Integer.parseInt(str3, AbstractC0975a.a(16)));
    }
}
