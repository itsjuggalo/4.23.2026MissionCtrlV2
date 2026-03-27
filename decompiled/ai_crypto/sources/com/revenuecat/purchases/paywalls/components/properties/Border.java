package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import n6.b;
import p6.e;
import q6.d;
import r6.AbstractC2611a0;
import r6.k0;

/* JADX INFO: loaded from: classes2.dex */
@InternalRevenueCatAPI
public final class Border {
    public static final Companion Companion = new Companion(null);
    private final ColorScheme color;
    private final double width;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public final b serializer() {
            return Border$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Border(int i7, ColorScheme colorScheme, double d7, k0 k0Var) {
        if (3 != (i7 & 3)) {
            AbstractC2611a0.a(i7, 3, Border$$serializer.INSTANCE.getDescriptor());
        }
        this.color = colorScheme;
        this.width = d7;
    }

    public static final /* synthetic */ void write$Self(Border border, d dVar, e eVar) {
        dVar.x(eVar, 0, ColorScheme$$serializer.INSTANCE, border.color);
        dVar.l(eVar, 1, border.width);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Border)) {
            return false;
        }
        Border border = (Border) obj;
        return r.b(this.color, border.color) && Double.compare(this.width, border.width) == 0;
    }

    public final /* synthetic */ ColorScheme getColor() {
        return this.color;
    }

    public final /* synthetic */ double getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.color.hashCode() * 31) + Double.hashCode(this.width);
    }

    public String toString() {
        return "Border(color=" + this.color + ", width=" + this.width + ')';
    }

    public Border(ColorScheme color, double d7) {
        r.f(color, "color");
        this.color = color;
        this.width = d7;
    }
}
