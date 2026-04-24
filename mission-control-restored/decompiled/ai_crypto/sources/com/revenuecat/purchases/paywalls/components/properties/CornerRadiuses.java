package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.internal.AbstractC2148j;
import n6.b;
import p6.e;
import q6.d;
import r6.AbstractC2611a0;
import r6.k0;

/* JADX INFO: loaded from: classes2.dex */
@InternalRevenueCatAPI
public interface CornerRadiuses {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final b serializer() {
            return CornerRadiusesSerializer.INSTANCE;
        }
    }

    public static final class Dp implements CornerRadiuses {
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: renamed from: default, reason: not valid java name */
        private static final Dp f1default;
        private static final Dp zero;
        private final double bottomLeading;
        private final double bottomTrailing;
        private final double topLeading;
        private final double topTrailing;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                this();
            }

            public final /* synthetic */ Dp getDefault() {
                return Dp.f1default;
            }

            public final /* synthetic */ Dp getZero() {
                return Dp.zero;
            }

            public final b serializer() {
                return CornerRadiuses$Dp$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        static {
            Dp dp = new Dp(0.0d, 0.0d, 0.0d, 0.0d);
            zero = dp;
            f1default = dp;
        }

        public Dp(double d7, double d8, double d9, double d10) {
            this.topLeading = d7;
            this.topTrailing = d8;
            this.bottomLeading = d9;
            this.bottomTrailing = d10;
        }

        public static /* synthetic */ void getBottomLeading$annotations() {
        }

        public static /* synthetic */ void getBottomTrailing$annotations() {
        }

        public static /* synthetic */ void getTopLeading$annotations() {
        }

        public static /* synthetic */ void getTopTrailing$annotations() {
        }

        public static final /* synthetic */ void write$Self(Dp dp, d dVar, e eVar) {
            dVar.l(eVar, 0, dp.topLeading);
            dVar.l(eVar, 1, dp.topTrailing);
            dVar.l(eVar, 2, dp.bottomLeading);
            dVar.l(eVar, 3, dp.bottomTrailing);
        }

        public final Dp copy(double d7, double d8, double d9, double d10) {
            return new Dp(d7, d8, d9, d10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Dp)) {
                return false;
            }
            Dp dp = (Dp) obj;
            return Double.compare(this.topLeading, dp.topLeading) == 0 && Double.compare(this.topTrailing, dp.topTrailing) == 0 && Double.compare(this.bottomLeading, dp.bottomLeading) == 0 && Double.compare(this.bottomTrailing, dp.bottomTrailing) == 0;
        }

        public final /* synthetic */ double getBottomLeading() {
            return this.bottomLeading;
        }

        public final /* synthetic */ double getBottomTrailing() {
            return this.bottomTrailing;
        }

        public final /* synthetic */ double getTopLeading() {
            return this.topLeading;
        }

        public final /* synthetic */ double getTopTrailing() {
            return this.topTrailing;
        }

        public int hashCode() {
            return (((((Double.hashCode(this.topLeading) * 31) + Double.hashCode(this.topTrailing)) * 31) + Double.hashCode(this.bottomLeading)) * 31) + Double.hashCode(this.bottomTrailing);
        }

        public String toString() {
            return "Dp(topLeading=" + this.topLeading + ", topTrailing=" + this.topTrailing + ", bottomLeading=" + this.bottomLeading + ", bottomTrailing=" + this.bottomTrailing + ')';
        }

        public /* synthetic */ Dp(int i7, double d7, double d8, double d9, double d10, k0 k0Var) {
            if (15 != (i7 & 15)) {
                AbstractC2611a0.a(i7, 15, CornerRadiuses$Dp$$serializer.INSTANCE.getDescriptor());
            }
            this.topLeading = d7;
            this.topTrailing = d8;
            this.bottomLeading = d9;
            this.bottomTrailing = d10;
        }

        public Dp(double d7) {
            this(d7, d7, d7, d7);
        }
    }

    public static final class Percentage implements CornerRadiuses {
        public static final Companion Companion = new Companion(null);
        private final int bottomLeading;
        private final int bottomTrailing;
        private final int topLeading;
        private final int topTrailing;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                this();
            }

            public final b serializer() {
                return CornerRadiuses$Percentage$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public Percentage(int i7, int i8, int i9, int i10) {
            this.topLeading = i7;
            this.topTrailing = i8;
            this.bottomLeading = i9;
            this.bottomTrailing = i10;
        }

        public static /* synthetic */ void getBottomLeading$annotations() {
        }

        public static /* synthetic */ void getBottomTrailing$annotations() {
        }

        public static /* synthetic */ void getTopLeading$annotations() {
        }

        public static /* synthetic */ void getTopTrailing$annotations() {
        }

        public static final /* synthetic */ void write$Self(Percentage percentage, d dVar, e eVar) {
            dVar.t(eVar, 0, percentage.topLeading);
            dVar.t(eVar, 1, percentage.topTrailing);
            dVar.t(eVar, 2, percentage.bottomLeading);
            dVar.t(eVar, 3, percentage.bottomTrailing);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Percentage)) {
                return false;
            }
            Percentage percentage = (Percentage) obj;
            return this.topLeading == percentage.topLeading && this.topTrailing == percentage.topTrailing && this.bottomLeading == percentage.bottomLeading && this.bottomTrailing == percentage.bottomTrailing;
        }

        public final /* synthetic */ int getBottomLeading() {
            return this.bottomLeading;
        }

        public final /* synthetic */ int getBottomTrailing() {
            return this.bottomTrailing;
        }

        public final /* synthetic */ int getTopLeading() {
            return this.topLeading;
        }

        public final /* synthetic */ int getTopTrailing() {
            return this.topTrailing;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.topLeading) * 31) + Integer.hashCode(this.topTrailing)) * 31) + Integer.hashCode(this.bottomLeading)) * 31) + Integer.hashCode(this.bottomTrailing);
        }

        public String toString() {
            return "Percentage(topLeading=" + this.topLeading + ", topTrailing=" + this.topTrailing + ", bottomLeading=" + this.bottomLeading + ", bottomTrailing=" + this.bottomTrailing + ')';
        }

        public /* synthetic */ Percentage(int i7, int i8, int i9, int i10, int i11, k0 k0Var) {
            if (15 != (i7 & 15)) {
                AbstractC2611a0.a(i7, 15, CornerRadiuses$Percentage$$serializer.INSTANCE.getDescriptor());
            }
            this.topLeading = i8;
            this.topTrailing = i9;
            this.bottomLeading = i10;
            this.bottomTrailing = i11;
        }

        public Percentage(int i7) {
            this(i7, i7, i7, i7);
        }
    }
}
