package com.revenuecat.purchases.paywalls.components.properties;

import X5.c;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.r;
import n6.b;
import n6.e;
import q6.d;
import r6.AbstractC2611a0;
import r6.k0;

/* JADX INFO: loaded from: classes2.dex */
@InternalRevenueCatAPI
public final class ColorScheme {
    private static final b[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final ColorInfo dark;
    private final ColorInfo light;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public final b serializer() {
            return ColorScheme$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        c cVarB = H.b(ColorInfo.class);
        c[] cVarArr = {H.b(ColorInfo.Alias.class), H.b(ColorInfo.Gradient.Linear.class), H.b(ColorInfo.Gradient.Radial.class), H.b(ColorInfo.Hex.class)};
        ColorInfo$Alias$$serializer colorInfo$Alias$$serializer = ColorInfo$Alias$$serializer.INSTANCE;
        ColorInfo$Gradient$Linear$$serializer colorInfo$Gradient$Linear$$serializer = ColorInfo$Gradient$Linear$$serializer.INSTANCE;
        ColorInfo$Gradient$Radial$$serializer colorInfo$Gradient$Radial$$serializer = ColorInfo$Gradient$Radial$$serializer.INSTANCE;
        ColorInfo$Hex$$serializer colorInfo$Hex$$serializer = ColorInfo$Hex$$serializer.INSTANCE;
        $childSerializers = new b[]{new e("com.revenuecat.purchases.paywalls.components.properties.ColorInfo", cVarB, cVarArr, new b[]{colorInfo$Alias$$serializer, colorInfo$Gradient$Linear$$serializer, colorInfo$Gradient$Radial$$serializer, colorInfo$Hex$$serializer}, new Annotation[0]), new e("com.revenuecat.purchases.paywalls.components.properties.ColorInfo", H.b(ColorInfo.class), new c[]{H.b(ColorInfo.Alias.class), H.b(ColorInfo.Gradient.Linear.class), H.b(ColorInfo.Gradient.Radial.class), H.b(ColorInfo.Hex.class)}, new b[]{colorInfo$Alias$$serializer, colorInfo$Gradient$Linear$$serializer, colorInfo$Gradient$Radial$$serializer, colorInfo$Hex$$serializer}, new Annotation[0])};
    }

    public /* synthetic */ ColorScheme(int i7, ColorInfo colorInfo, ColorInfo colorInfo2, k0 k0Var) {
        if (1 != (i7 & 1)) {
            AbstractC2611a0.a(i7, 1, ColorScheme$$serializer.INSTANCE.getDescriptor());
        }
        this.light = colorInfo;
        if ((i7 & 2) == 0) {
            this.dark = null;
        } else {
            this.dark = colorInfo2;
        }
    }

    public static final /* synthetic */ void write$Self(ColorScheme colorScheme, d dVar, p6.e eVar) {
        b[] bVarArr = $childSerializers;
        dVar.x(eVar, 0, bVarArr[0], colorScheme.light);
        if (!dVar.C(eVar, 1) && colorScheme.dark == null) {
            return;
        }
        dVar.r(eVar, 1, bVarArr[1], colorScheme.dark);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColorScheme)) {
            return false;
        }
        ColorScheme colorScheme = (ColorScheme) obj;
        return r.b(this.light, colorScheme.light) && r.b(this.dark, colorScheme.dark);
    }

    public final /* synthetic */ ColorInfo getDark() {
        return this.dark;
    }

    public final /* synthetic */ ColorInfo getLight() {
        return this.light;
    }

    public int hashCode() {
        int iHashCode = this.light.hashCode() * 31;
        ColorInfo colorInfo = this.dark;
        return iHashCode + (colorInfo == null ? 0 : colorInfo.hashCode());
    }

    public String toString() {
        return "ColorScheme(light=" + this.light + ", dark=" + this.dark + ')';
    }

    public ColorScheme(ColorInfo light, ColorInfo colorInfo) {
        r.f(light, "light");
        this.light = light;
        this.dark = colorInfo;
    }

    public /* synthetic */ ColorScheme(ColorInfo colorInfo, ColorInfo colorInfo2, int i7, AbstractC2148j abstractC2148j) {
        this(colorInfo, (i7 & 2) != 0 ? null : colorInfo2);
    }
}
