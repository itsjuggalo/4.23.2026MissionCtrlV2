package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import H3.e;
import I3.d;
import J3.k0;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class Padding {
    private final double bottom;
    private final double leading;
    private final double top;
    private final double trailing;
    public static final Companion Companion = new Companion(null);
    private static final Padding zero = new Padding(0.0d, 0.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private static final Padding f2default = new Padding(10.0d, 10.0d, 20.0d, 20.0d);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final /* synthetic */ Padding getDefault() {
            return Padding.f2default;
        }

        public final /* synthetic */ Padding getZero() {
            return Padding.zero;
        }

        public final b serializer() {
            return Padding$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Padding() {
        this(0.0d, 0.0d, 0.0d, 0.0d, 15, (AbstractC1585j) null);
    }

    public static final /* synthetic */ void write$Self(Padding padding, d dVar, e eVar) {
        if (dVar.j(eVar, 0) || Double.compare(padding.top, 0.0d) != 0) {
            dVar.g(eVar, 0, padding.top);
        }
        if (dVar.j(eVar, 1) || Double.compare(padding.bottom, 0.0d) != 0) {
            dVar.g(eVar, 1, padding.bottom);
        }
        if (dVar.j(eVar, 2) || Double.compare(padding.leading, 0.0d) != 0) {
            dVar.g(eVar, 2, padding.leading);
        }
        if (!dVar.j(eVar, 3) && Double.compare(padding.trailing, 0.0d) == 0) {
            return;
        }
        dVar.g(eVar, 3, padding.trailing);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Padding)) {
            return false;
        }
        Padding padding = (Padding) obj;
        return Double.compare(this.top, padding.top) == 0 && Double.compare(this.bottom, padding.bottom) == 0 && Double.compare(this.leading, padding.leading) == 0 && Double.compare(this.trailing, padding.trailing) == 0;
    }

    public final /* synthetic */ double getBottom() {
        return this.bottom;
    }

    public final /* synthetic */ double getLeading() {
        return this.leading;
    }

    public final /* synthetic */ double getTop() {
        return this.top;
    }

    public final /* synthetic */ double getTrailing() {
        return this.trailing;
    }

    public int hashCode() {
        return (((((Double.hashCode(this.top) * 31) + Double.hashCode(this.bottom)) * 31) + Double.hashCode(this.leading)) * 31) + Double.hashCode(this.trailing);
    }

    public String toString() {
        return "Padding(top=" + this.top + ", bottom=" + this.bottom + ", leading=" + this.leading + ", trailing=" + this.trailing + ')';
    }

    public Padding(double d4, double d5, double d6, double d7) {
        this.top = d4;
        this.bottom = d5;
        this.leading = d6;
        this.trailing = d7;
    }

    public /* synthetic */ Padding(int i4, double d4, double d5, double d6, double d7, k0 k0Var) {
        if ((i4 & 1) == 0) {
            this.top = 0.0d;
        } else {
            this.top = d4;
        }
        if ((i4 & 2) == 0) {
            this.bottom = 0.0d;
        } else {
            this.bottom = d5;
        }
        if ((i4 & 4) == 0) {
            this.leading = 0.0d;
        } else {
            this.leading = d6;
        }
        if ((i4 & 8) == 0) {
            this.trailing = 0.0d;
        } else {
            this.trailing = d7;
        }
    }

    public /* synthetic */ Padding(double d4, double d5, double d6, double d7, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? 0.0d : d4, (i4 & 2) != 0 ? 0.0d : d5, (i4 & 4) != 0 ? 0.0d : d6, (i4 & 8) != 0 ? 0.0d : d7);
    }
}
