package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import F3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public interface Dimension {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final b serializer() {
            return new e("com.revenuecat.purchases.paywalls.components.properties.Dimension", G.b(Dimension.class), new InterfaceC1716c[]{G.b(Horizontal.class), G.b(Vertical.class), G.b(ZLayer.class)}, new b[]{Dimension$Horizontal$$serializer.INSTANCE, Dimension$Vertical$$serializer.INSTANCE, Dimension$ZLayer$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    public static final class Horizontal implements Dimension {
        public static final Companion Companion = new Companion(null);
        private final VerticalAlignment alignment;
        private final FlexDistribution distribution;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return Dimension$Horizontal$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Horizontal(int i4, VerticalAlignment verticalAlignment, FlexDistribution flexDistribution, k0 k0Var) {
            if (3 != (i4 & 3)) {
                AbstractC0325a0.a(i4, 3, Dimension$Horizontal$$serializer.INSTANCE.getDescriptor());
            }
            this.alignment = verticalAlignment;
            this.distribution = flexDistribution;
        }

        public static /* synthetic */ Horizontal copy$default(Horizontal horizontal, VerticalAlignment verticalAlignment, FlexDistribution flexDistribution, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                verticalAlignment = horizontal.alignment;
            }
            if ((i4 & 2) != 0) {
                flexDistribution = horizontal.distribution;
            }
            return horizontal.copy(verticalAlignment, flexDistribution);
        }

        public static final /* synthetic */ void write$Self(Horizontal horizontal, d dVar, H3.e eVar) {
            dVar.u(eVar, 0, VerticalAlignmentDeserializer.INSTANCE, horizontal.alignment);
            dVar.u(eVar, 1, FlexDistributionDeserializer.INSTANCE, horizontal.distribution);
        }

        public final VerticalAlignment component1() {
            return this.alignment;
        }

        public final FlexDistribution component2() {
            return this.distribution;
        }

        public final Horizontal copy(VerticalAlignment alignment, FlexDistribution distribution) {
            r.f(alignment, "alignment");
            r.f(distribution, "distribution");
            return new Horizontal(alignment, distribution);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Horizontal)) {
                return false;
            }
            Horizontal horizontal = (Horizontal) obj;
            return this.alignment == horizontal.alignment && this.distribution == horizontal.distribution;
        }

        public final /* synthetic */ VerticalAlignment getAlignment() {
            return this.alignment;
        }

        public final /* synthetic */ FlexDistribution getDistribution() {
            return this.distribution;
        }

        public int hashCode() {
            return (this.alignment.hashCode() * 31) + this.distribution.hashCode();
        }

        public String toString() {
            return "Horizontal(alignment=" + this.alignment + ", distribution=" + this.distribution + ')';
        }

        public Horizontal(VerticalAlignment alignment, FlexDistribution distribution) {
            r.f(alignment, "alignment");
            r.f(distribution, "distribution");
            this.alignment = alignment;
            this.distribution = distribution;
        }
    }

    public static final class Vertical implements Dimension {
        public static final Companion Companion = new Companion(null);
        private final HorizontalAlignment alignment;
        private final FlexDistribution distribution;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return Dimension$Vertical$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Vertical(int i4, HorizontalAlignment horizontalAlignment, FlexDistribution flexDistribution, k0 k0Var) {
            if (3 != (i4 & 3)) {
                AbstractC0325a0.a(i4, 3, Dimension$Vertical$$serializer.INSTANCE.getDescriptor());
            }
            this.alignment = horizontalAlignment;
            this.distribution = flexDistribution;
        }

        public static /* synthetic */ Vertical copy$default(Vertical vertical, HorizontalAlignment horizontalAlignment, FlexDistribution flexDistribution, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                horizontalAlignment = vertical.alignment;
            }
            if ((i4 & 2) != 0) {
                flexDistribution = vertical.distribution;
            }
            return vertical.copy(horizontalAlignment, flexDistribution);
        }

        public static final /* synthetic */ void write$Self(Vertical vertical, d dVar, H3.e eVar) {
            dVar.u(eVar, 0, HorizontalAlignmentDeserializer.INSTANCE, vertical.alignment);
            dVar.u(eVar, 1, FlexDistributionDeserializer.INSTANCE, vertical.distribution);
        }

        public final HorizontalAlignment component1() {
            return this.alignment;
        }

        public final FlexDistribution component2() {
            return this.distribution;
        }

        public final Vertical copy(HorizontalAlignment alignment, FlexDistribution distribution) {
            r.f(alignment, "alignment");
            r.f(distribution, "distribution");
            return new Vertical(alignment, distribution);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Vertical)) {
                return false;
            }
            Vertical vertical = (Vertical) obj;
            return this.alignment == vertical.alignment && this.distribution == vertical.distribution;
        }

        public final /* synthetic */ HorizontalAlignment getAlignment() {
            return this.alignment;
        }

        public final /* synthetic */ FlexDistribution getDistribution() {
            return this.distribution;
        }

        public int hashCode() {
            return (this.alignment.hashCode() * 31) + this.distribution.hashCode();
        }

        public String toString() {
            return "Vertical(alignment=" + this.alignment + ", distribution=" + this.distribution + ')';
        }

        public Vertical(HorizontalAlignment alignment, FlexDistribution distribution) {
            r.f(alignment, "alignment");
            r.f(distribution, "distribution");
            this.alignment = alignment;
            this.distribution = distribution;
        }
    }

    public static final class ZLayer implements Dimension {
        public static final Companion Companion = new Companion(null);
        private final TwoDimensionalAlignment alignment;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return Dimension$ZLayer$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ ZLayer(int i4, TwoDimensionalAlignment twoDimensionalAlignment, k0 k0Var) {
            if (1 != (i4 & 1)) {
                AbstractC0325a0.a(i4, 1, Dimension$ZLayer$$serializer.INSTANCE.getDescriptor());
            }
            this.alignment = twoDimensionalAlignment;
        }

        public static /* synthetic */ ZLayer copy$default(ZLayer zLayer, TwoDimensionalAlignment twoDimensionalAlignment, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                twoDimensionalAlignment = zLayer.alignment;
            }
            return zLayer.copy(twoDimensionalAlignment);
        }

        public final TwoDimensionalAlignment component1() {
            return this.alignment;
        }

        public final ZLayer copy(TwoDimensionalAlignment alignment) {
            r.f(alignment, "alignment");
            return new ZLayer(alignment);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ZLayer) && this.alignment == ((ZLayer) obj).alignment;
        }

        public final /* synthetic */ TwoDimensionalAlignment getAlignment() {
            return this.alignment;
        }

        public int hashCode() {
            return this.alignment.hashCode();
        }

        public String toString() {
            return "ZLayer(alignment=" + this.alignment + ')';
        }

        public ZLayer(TwoDimensionalAlignment alignment) {
            r.f(alignment, "alignment");
            this.alignment = alignment;
        }
    }
}
