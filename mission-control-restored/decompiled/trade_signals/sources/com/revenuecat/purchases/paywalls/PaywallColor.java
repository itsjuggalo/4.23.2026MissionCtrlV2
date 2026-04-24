package com.revenuecat.purchases.paywalls;

import android.graphics.Color;
import android.os.Build;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.util.Arrays;
import java.util.Locale;
import k7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.U;
import m7.d;
import m7.e;
import m7.k;
import n7.f;

/* JADX INFO: loaded from: classes.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallColor;", "", "stringRepresentation", "", "(Ljava/lang/String;)V", "colorInt", "", "(I)V", "underlyingColor", "Landroid/graphics/Color;", "(Ljava/lang/String;Landroid/graphics/Color;)V", "getColorInt", "()I", "getStringRepresentation", "()Ljava/lang/String;", "getUnderlyingColor", "()Landroid/graphics/Color;", "Serializer", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallColor {
    private final int colorInt;
    private final String stringRepresentation;
    private final Color underlyingColor;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallColor$Serializer;", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/PaywallColor;", "<init>", "()V", "Ln7/e;", "decoder", "deserialize", "(Ln7/e;)Lcom/revenuecat/purchases/paywalls/PaywallColor;", "Ln7/f;", "encoder", "value", "Lo5/H;", "serialize", "(Ln7/f;Lcom/revenuecat/purchases/paywalls/PaywallColor;)V", "Lm7/e;", "descriptor", "Lm7/e;", "getDescriptor", "()Lm7/e;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Serializer implements b {
        public static final Serializer INSTANCE = new Serializer();
        private static final e descriptor = k.b("PaywallColor", d.i.f21508a);

        private Serializer() {
        }

        @Override // k7.a
        public PaywallColor deserialize(n7.e decoder) {
            AbstractC2304t.f(decoder, "decoder");
            return new PaywallColor(decoder.q());
        }

        @Override // k7.b, k7.k, k7.a
        public e getDescriptor() {
            return descriptor;
        }

        @Override // k7.k
        public void serialize(f encoder, PaywallColor value) {
            AbstractC2304t.f(encoder, "encoder");
            AbstractC2304t.f(value, "value");
            encoder.E(value.toString());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PaywallColor(int i8) {
        U u8 = U.f20474a;
        String str = String.format(Locale.US, "#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & i8)}, 1));
        AbstractC2304t.e(str, "format(...)");
        this(str, Build.VERSION.SDK_INT >= 26 ? Color.valueOf(i8) : null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallColor)) {
            return false;
        }
        PaywallColor paywallColor = (PaywallColor) obj;
        return AbstractC2304t.b(this.stringRepresentation, paywallColor.stringRepresentation) && AbstractC2304t.b(this.underlyingColor, paywallColor.underlyingColor);
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
        AbstractC2304t.f(stringRepresentation, "stringRepresentation");
    }

    public PaywallColor(String stringRepresentation, Color color) {
        AbstractC2304t.f(stringRepresentation, "stringRepresentation");
        this.stringRepresentation = stringRepresentation;
        this.underlyingColor = color;
        this.colorInt = ColorUtilsKt.parseRGBAColor(stringRepresentation);
    }
}
