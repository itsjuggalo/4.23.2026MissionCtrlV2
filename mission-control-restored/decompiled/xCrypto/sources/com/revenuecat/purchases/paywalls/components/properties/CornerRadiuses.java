package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
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
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
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

        public Dp(double d4, double d5, double d6, double d7) {
            this.topLeading = d4;
            this.topTrailing = d5;
            this.bottomLeading = d6;
            this.bottomTrailing = d7;
        }

        public static /* synthetic */ Dp copy$default(Dp dp, double d4, double d5, double d6, double d7, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                d4 = dp.topLeading;
            }
            double d8 = d4;
            if ((i4 & 2) != 0) {
                d5 = dp.topTrailing;
            }
            double d9 = d5;
            if ((i4 & 4) != 0) {
                d6 = dp.bottomLeading;
            }
            return dp.copy(d8, d9, d6, (i4 & 8) != 0 ? dp.bottomTrailing : d7);
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
            dVar.g(eVar, 0, dp.topLeading);
            dVar.g(eVar, 1, dp.topTrailing);
            dVar.g(eVar, 2, dp.bottomLeading);
            dVar.g(eVar, 3, dp.bottomTrailing);
        }

        public final Dp copy(double d4, double d5, double d6, double d7) {
            return new Dp(d4, d5, d6, d7);
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

        public /* synthetic */ Dp(int i4, double d4, double d5, double d6, double d7, k0 k0Var) {
            if (15 != (i4 & 15)) {
                AbstractC0325a0.a(i4, 15, CornerRadiuses$Dp$$serializer.INSTANCE.getDescriptor());
            }
            this.topLeading = d4;
            this.topTrailing = d5;
            this.bottomLeading = d6;
            this.bottomTrailing = d7;
        }

        public Dp(double d4) {
            this(d4, d4, d4, d4);
        }
    }

    public static final class Percentage implements CornerRadiuses {
        public static final Companion Companion = new Companion(null);
        private final int bottomLeading;
        private final int bottomTrailing;
        private final int topLeading;
        private final int topTrailing;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return CornerRadiuses$Percentage$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public Percentage(int i4, int i5, int i6, int i7) {
            this.topLeading = i4;
            this.topTrailing = i5;
            this.bottomLeading = i6;
            this.bottomTrailing = i7;
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
            dVar.k(eVar, 0, percentage.topLeading);
            dVar.k(eVar, 1, percentage.topTrailing);
            dVar.k(eVar, 2, percentage.bottomLeading);
            dVar.k(eVar, 3, percentage.bottomTrailing);
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

        public /* synthetic */ Percentage(int i4, int i5, int i6, int i7, int i8, k0 k0Var) {
            if (15 != (i4 & 15)) {
                AbstractC0325a0.a(i4, 15, CornerRadiuses$Percentage$$serializer.INSTANCE.getDescriptor());
            }
            this.topLeading = i5;
            this.topTrailing = i6;
            this.bottomLeading = i7;
            this.bottomTrailing = i8;
        }

        public Percentage(int i4) {
            this(i4, i4, i4, i4);
        }
    }
}
