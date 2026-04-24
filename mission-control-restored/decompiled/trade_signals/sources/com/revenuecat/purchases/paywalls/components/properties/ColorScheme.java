package com.revenuecat.purchases.paywalls.components.properties;

import I5.d;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import java.lang.annotation.Annotation;
import k7.b;
import k7.h;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.O;
import m7.e;
import o7.AbstractC2504f0;
import o7.t0;

/* JADX INFO: loaded from: classes.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u001a\u0019B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0011\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ(\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fHÁ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;", "light", "dark", "<init>", "(Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;)V", "", "seen1", "Lo7/t0;", "serializationConstructorMarker", "(ILcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;Lo7/t0;)V", "self", "Ln7/d;", "output", "Lm7/e;", "serialDesc", "Lo5/H;", "write$Self$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Ln7/d;Lm7/e;)V", "write$Self", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;", "getLight", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;", "getDark", "Companion", "$serializer", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class ColorScheme {
    private static final b[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ColorInfo dark;
    private final ColorInfo light;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme$Companion;", "", "<init>", "()V", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return ColorScheme$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    static {
        d dVarB = O.b(ColorInfo.class);
        d[] dVarArr = {O.b(ColorInfo.Alias.class), O.b(ColorInfo.Gradient.Linear.class), O.b(ColorInfo.Gradient.Radial.class), O.b(ColorInfo.Hex.class)};
        ColorInfo$Alias$$serializer colorInfo$Alias$$serializer = ColorInfo$Alias$$serializer.INSTANCE;
        ColorInfo$Gradient$Linear$$serializer colorInfo$Gradient$Linear$$serializer = ColorInfo$Gradient$Linear$$serializer.INSTANCE;
        ColorInfo$Gradient$Radial$$serializer colorInfo$Gradient$Radial$$serializer = ColorInfo$Gradient$Radial$$serializer.INSTANCE;
        ColorInfo$Hex$$serializer colorInfo$Hex$$serializer = ColorInfo$Hex$$serializer.INSTANCE;
        $childSerializers = new b[]{new h("com.revenuecat.purchases.paywalls.components.properties.ColorInfo", dVarB, dVarArr, new b[]{colorInfo$Alias$$serializer, colorInfo$Gradient$Linear$$serializer, colorInfo$Gradient$Radial$$serializer, colorInfo$Hex$$serializer}, new Annotation[0]), new h("com.revenuecat.purchases.paywalls.components.properties.ColorInfo", O.b(ColorInfo.class), new d[]{O.b(ColorInfo.Alias.class), O.b(ColorInfo.Gradient.Linear.class), O.b(ColorInfo.Gradient.Radial.class), O.b(ColorInfo.Hex.class)}, new b[]{colorInfo$Alias$$serializer, colorInfo$Gradient$Linear$$serializer, colorInfo$Gradient$Radial$$serializer, colorInfo$Hex$$serializer}, new Annotation[0])};
    }

    public /* synthetic */ ColorScheme(int i8, ColorInfo colorInfo, ColorInfo colorInfo2, t0 t0Var) {
        if (1 != (i8 & 1)) {
            AbstractC2504f0.a(i8, 1, ColorScheme$$serializer.INSTANCE.getDescriptor());
        }
        this.light = colorInfo;
        if ((i8 & 2) == 0) {
            this.dark = null;
        } else {
            this.dark = colorInfo2;
        }
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsRelease(ColorScheme self, n7.d output, e serialDesc) {
        b[] bVarArr = $childSerializers;
        output.B(serialDesc, 0, bVarArr[0], self.light);
        if (!output.q(serialDesc, 1) && self.dark == null) {
            return;
        }
        output.u(serialDesc, 1, bVarArr[1], self.dark);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColorScheme)) {
            return false;
        }
        ColorScheme colorScheme = (ColorScheme) obj;
        return AbstractC2304t.b(this.light, colorScheme.light) && AbstractC2304t.b(this.dark, colorScheme.dark);
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
        AbstractC2304t.f(light, "light");
        this.light = light;
        this.dark = colorInfo;
    }

    public /* synthetic */ ColorScheme(ColorInfo colorInfo, ColorInfo colorInfo2, int i8, AbstractC2296k abstractC2296k) {
        this(colorInfo, (i8 & 2) != 0 ? null : colorInfo2);
    }
}
