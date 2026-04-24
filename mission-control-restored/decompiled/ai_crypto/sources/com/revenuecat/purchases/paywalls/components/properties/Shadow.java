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
public final class Shadow {
    public static final Companion Companion = new Companion(null);
    private final ColorScheme color;
    private final double radius;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final double f12981x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final double f12982y;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public final b serializer() {
            return Shadow$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Shadow(int i7, ColorScheme colorScheme, double d7, double d8, double d9, k0 k0Var) {
        if (15 != (i7 & 15)) {
            AbstractC2611a0.a(i7, 15, Shadow$$serializer.INSTANCE.getDescriptor());
        }
        this.color = colorScheme;
        this.radius = d7;
        this.f12981x = d8;
        this.f12982y = d9;
    }

    public static final /* synthetic */ void write$Self(Shadow shadow, d dVar, e eVar) {
        dVar.x(eVar, 0, ColorScheme$$serializer.INSTANCE, shadow.color);
        dVar.l(eVar, 1, shadow.radius);
        dVar.l(eVar, 2, shadow.f12981x);
        dVar.l(eVar, 3, shadow.f12982y);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shadow)) {
            return false;
        }
        Shadow shadow = (Shadow) obj;
        return r.b(this.color, shadow.color) && Double.compare(this.radius, shadow.radius) == 0 && Double.compare(this.f12981x, shadow.f12981x) == 0 && Double.compare(this.f12982y, shadow.f12982y) == 0;
    }

    public final /* synthetic */ ColorScheme getColor() {
        return this.color;
    }

    public final /* synthetic */ double getRadius() {
        return this.radius;
    }

    public final /* synthetic */ double getX() {
        return this.f12981x;
    }

    public final /* synthetic */ double getY() {
        return this.f12982y;
    }

    public int hashCode() {
        return (((((this.color.hashCode() * 31) + Double.hashCode(this.radius)) * 31) + Double.hashCode(this.f12981x)) * 31) + Double.hashCode(this.f12982y);
    }

    public String toString() {
        return "Shadow(color=" + this.color + ", radius=" + this.radius + ", x=" + this.f12981x + ", y=" + this.f12982y + ')';
    }

    public Shadow(ColorScheme color, double d7, double d8, double d9) {
        r.f(color, "color");
        this.color = color;
        this.radius = d7;
        this.f12981x = d8;
        this.f12982y = d9;
    }
}
