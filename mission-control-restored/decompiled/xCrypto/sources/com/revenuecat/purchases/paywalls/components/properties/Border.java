package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class Border {
    public static final Companion Companion = new Companion(null);
    private final ColorScheme color;
    private final double width;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return Border$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Border(int i4, ColorScheme colorScheme, double d4, k0 k0Var) {
        if (3 != (i4 & 3)) {
            AbstractC0325a0.a(i4, 3, Border$$serializer.INSTANCE.getDescriptor());
        }
        this.color = colorScheme;
        this.width = d4;
    }

    public static final /* synthetic */ void write$Self(Border border, d dVar, e eVar) {
        dVar.u(eVar, 0, ColorScheme$$serializer.INSTANCE, border.color);
        dVar.g(eVar, 1, border.width);
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

    public Border(ColorScheme color, double d4) {
        r.f(color, "color");
        this.color = color;
        this.width = d4;
    }
}
