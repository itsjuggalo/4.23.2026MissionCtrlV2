package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import k7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import m7.e;
import n7.d;
import o7.t0;

/* JADX INFO: loaded from: classes.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001e\u001dB/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bB;\b\u0011\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\rJ(\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011HÁ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "", "", "top", "bottom", "leading", "trailing", "<init>", "(DDDD)V", "", "seen1", "Lo7/t0;", "serializationConstructorMarker", "(IDDDDLo7/t0;)V", "self", "Ln7/d;", "output", "Lm7/e;", "serialDesc", "Lo5/H;", "write$Self$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Ln7/d;Lm7/e;)V", "write$Self", "D", "getTop", "()D", "getBottom", "getLeading", "getTrailing", "Companion", "$serializer", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class Padding {
    private final double bottom;
    private final double leading;
    private final double top;
    private final double trailing;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Padding zero = new Padding(0.0d, 0.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private static final Padding f2default = new Padding(10.0d, 10.0d, 20.0d, 20.0d);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00058F¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00058F¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Padding$Companion;", "", "<init>", "()V", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "serializer", "()Lk7/b;", "zero", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "getZero", "()Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "default", "getDefault", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
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

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public Padding() {
        this(0.0d, 0.0d, 0.0d, 0.0d, 15, (AbstractC2296k) null);
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsRelease(Padding self, d output, e serialDesc) {
        if (output.q(serialDesc, 0) || Double.compare(self.top, 0.0d) != 0) {
            output.F(serialDesc, 0, self.top);
        }
        if (output.q(serialDesc, 1) || Double.compare(self.bottom, 0.0d) != 0) {
            output.F(serialDesc, 1, self.bottom);
        }
        if (output.q(serialDesc, 2) || Double.compare(self.leading, 0.0d) != 0) {
            output.F(serialDesc, 2, self.leading);
        }
        if (!output.q(serialDesc, 3) && Double.compare(self.trailing, 0.0d) == 0) {
            return;
        }
        output.F(serialDesc, 3, self.trailing);
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

    public Padding(double d8, double d9, double d10, double d11) {
        this.top = d8;
        this.bottom = d9;
        this.leading = d10;
        this.trailing = d11;
    }

    public /* synthetic */ Padding(double d8, double d9, double d10, double d11, int i8, AbstractC2296k abstractC2296k) {
        this((i8 & 1) != 0 ? 0.0d : d8, (i8 & 2) != 0 ? 0.0d : d9, (i8 & 4) != 0 ? 0.0d : d10, (i8 & 8) == 0 ? d11 : 0.0d);
    }

    public /* synthetic */ Padding(int i8, double d8, double d9, double d10, double d11, t0 t0Var) {
        if ((i8 & 1) == 0) {
            this.top = 0.0d;
        } else {
            this.top = d8;
        }
        if ((i8 & 2) == 0) {
            this.bottom = 0.0d;
        } else {
            this.bottom = d9;
        }
        if ((i8 & 4) == 0) {
            this.leading = 0.0d;
        } else {
            this.leading = d10;
        }
        if ((i8 & 8) == 0) {
            this.trailing = 0.0d;
        } else {
            this.trailing = d11;
        }
    }
}
