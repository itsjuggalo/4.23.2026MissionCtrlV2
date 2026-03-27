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
public final class Shadow {
    public static final Companion Companion = new Companion(null);
    private final ColorScheme color;
    private final double radius;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final double f11357x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final double f11358y;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return Shadow$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Shadow(int i4, ColorScheme colorScheme, double d4, double d5, double d6, k0 k0Var) {
        if (15 != (i4 & 15)) {
            AbstractC0325a0.a(i4, 15, Shadow$$serializer.INSTANCE.getDescriptor());
        }
        this.color = colorScheme;
        this.radius = d4;
        this.f11357x = d5;
        this.f11358y = d6;
    }

    public static final /* synthetic */ void write$Self(Shadow shadow, d dVar, e eVar) {
        dVar.u(eVar, 0, ColorScheme$$serializer.INSTANCE, shadow.color);
        dVar.g(eVar, 1, shadow.radius);
        dVar.g(eVar, 2, shadow.f11357x);
        dVar.g(eVar, 3, shadow.f11358y);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shadow)) {
            return false;
        }
        Shadow shadow = (Shadow) obj;
        return r.b(this.color, shadow.color) && Double.compare(this.radius, shadow.radius) == 0 && Double.compare(this.f11357x, shadow.f11357x) == 0 && Double.compare(this.f11358y, shadow.f11358y) == 0;
    }

    public final /* synthetic */ ColorScheme getColor() {
        return this.color;
    }

    public final /* synthetic */ double getRadius() {
        return this.radius;
    }

    public final /* synthetic */ double getX() {
        return this.f11357x;
    }

    public final /* synthetic */ double getY() {
        return this.f11358y;
    }

    public int hashCode() {
        return (((((this.color.hashCode() * 31) + Double.hashCode(this.radius)) * 31) + Double.hashCode(this.f11357x)) * 31) + Double.hashCode(this.f11358y);
    }

    public String toString() {
        return "Shadow(color=" + this.color + ", radius=" + this.radius + ", x=" + this.f11357x + ", y=" + this.f11358y + ')';
    }

    public Shadow(ColorScheme color, double d4, double d5, double d6) {
        r.f(color, "color");
        this.color = color;
        this.radius = d4;
        this.f11357x = d5;
        this.f11358y = d6;
    }
}
