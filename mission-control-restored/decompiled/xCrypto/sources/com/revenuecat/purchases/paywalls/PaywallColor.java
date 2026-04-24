package com.revenuecat.purchases.paywalls;

import F3.b;
import H3.d;
import H3.e;
import H3.h;
import I3.f;
import android.graphics.Color;
import android.os.Build;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallColor {
    private final int colorInt;
    private final String stringRepresentation;
    private final Color underlyingColor;

    public static final class Serializer implements b {
        public static final Serializer INSTANCE = new Serializer();
        private static final e descriptor = h.a("PaywallColor", d.i.f742a);

        private Serializer() {
        }

        @Override // F3.b, F3.h, F3.a
        public e getDescriptor() {
            return descriptor;
        }

        @Override // F3.a
        public PaywallColor deserialize(I3.e decoder) {
            r.f(decoder, "decoder");
            return new PaywallColor(decoder.q());
        }

        @Override // F3.h
        public void serialize(f encoder, PaywallColor value) {
            r.f(encoder, "encoder");
            r.f(value, "value");
            encoder.F(value.toString());
        }
    }

    public PaywallColor(String stringRepresentation, Color color) {
        r.f(stringRepresentation, "stringRepresentation");
        this.stringRepresentation = stringRepresentation;
        this.underlyingColor = color;
        this.colorInt = ColorUtilsKt.parseRGBAColor(stringRepresentation);
    }

    public static /* synthetic */ PaywallColor copy$default(PaywallColor paywallColor, String str, Color color, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = paywallColor.stringRepresentation;
        }
        if ((i4 & 2) != 0) {
            color = paywallColor.underlyingColor;
        }
        return paywallColor.copy(str, color);
    }

    public final String component1() {
        return this.stringRepresentation;
    }

    public final Color component2() {
        return this.underlyingColor;
    }

    public final PaywallColor copy(String stringRepresentation, Color color) {
        r.f(stringRepresentation, "stringRepresentation");
        return new PaywallColor(stringRepresentation, color);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallColor)) {
            return false;
        }
        PaywallColor paywallColor = (PaywallColor) obj;
        return r.b(this.stringRepresentation, paywallColor.stringRepresentation) && r.b(this.underlyingColor, paywallColor.underlyingColor);
    }

    public final int getColorInt() {
        return this.colorInt;
    }

    public final String getStringRepresentation() {
        return this.stringRepresentation;
    }

    public final Color getUnderlyingColor() {
        return this.underlyingColor;
    }

    public int hashCode() {
        int iHashCode = this.stringRepresentation.hashCode() * 31;
        Color color = this.underlyingColor;
        return iHashCode + (color == null ? 0 : color.hashCode());
    }

    public String toString() {
        return "PaywallColor(stringRepresentation=" + this.stringRepresentation + ", underlyingColor=" + this.underlyingColor + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallColor(String stringRepresentation) {
        this(stringRepresentation, Build.VERSION.SDK_INT >= 26 ? Color.valueOf(ColorUtilsKt.parseRGBAColor(stringRepresentation)) : null);
        r.f(stringRepresentation, "stringRepresentation");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PaywallColor(int i4) {
        J j4 = J.f13414a;
        String str = String.format(Locale.US, "#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & i4)}, 1));
        r.e(str, "format(locale, format, *args)");
        this(str, Build.VERSION.SDK_INT >= 26 ? Color.valueOf(i4) : null);
    }
}
