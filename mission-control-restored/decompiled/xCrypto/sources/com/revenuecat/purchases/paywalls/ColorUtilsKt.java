package com.revenuecat.purchases.paywalls;

import X2.x;
import android.graphics.Color;
import kotlin.jvm.internal.r;
import r3.AbstractC1753A;
import r3.AbstractC1754a;
import r3.InterfaceC1761h;
import r3.k;

/* JADX INFO: loaded from: classes3.dex */
public final class ColorUtilsKt {
    private static final k rgbaColorRegex = new k("^#([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})?$");

    public static final int colorInt(int i4, int i5, int i6, int i7) {
        return (i4 << 24) | (i5 << 16) | (i6 << 8) | i7;
    }

    public static final int parseRGBAColor(String stringRepresentation) {
        r.f(stringRepresentation, "stringRepresentation");
        InterfaceC1761h interfaceC1761hA = rgbaColorRegex.a(stringRepresentation);
        if (interfaceC1761hA == null) {
            return Color.parseColor(stringRepresentation);
        }
        InterfaceC1761h.b bVarA = interfaceC1761hA.a();
        String str = (String) bVarA.a().b().get(1);
        String str2 = (String) bVarA.a().b().get(2);
        String str3 = (String) bVarA.a().b().get(3);
        Object objK = x.K(interfaceC1761hA.b(), 4);
        String str4 = (String) objK;
        if (str4 == null || AbstractC1753A.U(str4)) {
            objK = null;
        }
        String str5 = (String) objK;
        if (str5 == null) {
            str5 = "FF";
        }
        return colorInt(Integer.parseInt(str5, AbstractC1754a.a(16)), Integer.parseInt(str, AbstractC1754a.a(16)), Integer.parseInt(str2, AbstractC1754a.a(16)), Integer.parseInt(str3, AbstractC1754a.a(16)));
    }
}
