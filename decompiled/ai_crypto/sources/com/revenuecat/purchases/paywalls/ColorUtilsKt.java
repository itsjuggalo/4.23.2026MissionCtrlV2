package com.revenuecat.purchases.paywalls;

import F5.v;
import Z5.AbstractC0794a;
import Z5.g;
import Z5.i;
import Z5.u;
import android.graphics.Color;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class ColorUtilsKt {
    private static final i rgbaColorRegex = new i("^#([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})?$");

    public static final int colorInt(int i7, int i8, int i9, int i10) {
        return (i7 << 24) | (i8 << 16) | (i9 << 8) | i10;
    }

    public static final int parseRGBAColor(String stringRepresentation) {
        r.f(stringRepresentation, "stringRepresentation");
        g gVarA = rgbaColorRegex.a(stringRepresentation);
        if (gVarA == null) {
            return Color.parseColor(stringRepresentation);
        }
        g.b bVarA = gVarA.a();
        String str = (String) bVarA.a().b().get(1);
        String str2 = (String) bVarA.a().b().get(2);
        String str3 = (String) bVarA.a().b().get(3);
        Object objL = v.L(gVarA.b(), 4);
        String str4 = (String) objL;
        if (str4 == null || u.P(str4)) {
            objL = null;
        }
        String str5 = (String) objL;
        if (str5 == null) {
            str5 = "FF";
        }
        return colorInt(Integer.parseInt(str5, AbstractC0794a.a(16)), Integer.parseInt(str, AbstractC0794a.a(16)), Integer.parseInt(str2, AbstractC0794a.a(16)), Integer.parseInt(str3, AbstractC0794a.a(16)));
    }
}
