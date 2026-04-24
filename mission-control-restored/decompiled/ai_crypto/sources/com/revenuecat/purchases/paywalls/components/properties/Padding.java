package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.internal.AbstractC2148j;
import n6.b;
import p6.e;
import q6.d;
import r6.k0;

/* JADX INFO: loaded from: classes2.dex */
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
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
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
        this(0.0d, 0.0d, 0.0d, 0.0d, 15, (AbstractC2148j) null);
    }

    public static final /* synthetic */ void write$Self(Padding padding, d dVar, e eVar) {
        if (dVar.C(eVar, 0) || Double.compare(padding.top, 0.0d) != 0) {
            dVar.l(eVar, 0, padding.top);
        }
        if (dVar.C(eVar, 1) || Double.compare(padding.bottom, 0.0d) != 0) {
            dVar.l(eVar, 1, padding.bottom);
        }
        if (dVar.C(eVar, 2) || Double.compare(padding.leading, 0.0d) != 0) {
            dVar.l(eVar, 2, padding.leading);
        }
        if (!dVar.C(eVar, 3) && Double.compare(padding.trailing, 0.0d) == 0) {
            return;
        }
        dVar.l(eVar, 3, padding.trailing);
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

    public Padding(double d7, double d8, double d9, double d10) {
        this.top = d7;
        this.bottom = d8;
        this.leading = d9;
        this.trailing = d10;
    }

    public /* synthetic */ Padding(int i7, double d7, double d8, double d9, double d10, k0 k0Var) {
        if ((i7 & 1) == 0) {
            this.top = 0.0d;
        } else {
            this.top = d7;
        }
        if ((i7 & 2) == 0) {
            this.bottom = 0.0d;
        } else {
            this.bottom = d8;
        }
        if ((i7 & 4) == 0) {
            this.leading = 0.0d;
        } else {
            this.leading = d9;
        }
        if ((i7 & 8) == 0) {
            this.trailing = 0.0d;
        } else {
            this.trailing = d10;
        }
    }

    public /* synthetic */ Padding(double d7, double d8, double d9, double d10, int i7, AbstractC2148j abstractC2148j) {
        this((i7 & 1) != 0 ? 0.0d : d7, (i7 & 2) != 0 ? 0.0d : d8, (i7 & 4) != 0 ? 0.0d : d9, (i7 & 8) == 0 ? d10 : 0.0d);
    }
}
