package com.revenuecat.purchases.paywalls.components;

import F3.b;
import F3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.B;
import J3.C0332e;
import J3.C0335h;
import J3.k0;
import W2.j;
import W2.k;
import W2.l;
import X2.AbstractC0769p;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Badge$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.Dimension$Horizontal$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension$Vertical$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension$ZLayer$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class StackComponent implements PaywallComponent {
    private final Background background;
    private final ColorScheme backgroundColor;
    private final Badge badge;
    private final Border border;
    private final List<PaywallComponent> components;
    private final Dimension dimension;
    private final Padding margin;
    private final Overflow overflow;
    private final List<ComponentOverride<PartialStackComponent>> overrides;
    private final Padding padding;
    private final Shadow shadow;
    private final Shape shape;
    private final Size size;
    private final Float spacing;
    private final Boolean visible;
    public static final Companion Companion = new Companion(null);
    private static final b[] $childSerializers = {new C0332e(new PaywallComponentSerializer()), null, new e("com.revenuecat.purchases.paywalls.components.properties.Dimension", G.b(Dimension.class), new InterfaceC1716c[]{G.b(Dimension.Horizontal.class), G.b(Dimension.Vertical.class), G.b(Dimension.ZLayer.class)}, new b[]{Dimension$Horizontal$$serializer.INSTANCE, Dimension$Vertical$$serializer.INSTANCE, Dimension$ZLayer$$serializer.INSTANCE}, new Annotation[0]), null, null, null, null, null, null, null, null, null, null, null, new C0332e(ComponentOverride.Companion.serializer(PartialStackComponent$$serializer.INSTANCE))};

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return StackComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public enum Overflow {
        NONE,
        SCROLL;

        public static final Companion Companion = new Companion(null);
        private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

        public static final class Companion {

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.StackComponent$Overflow$Companion$1, reason: invalid class name */
            public static final class AnonymousClass1 extends s implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return StackOverflowDeserializer.INSTANCE;
                }
            }

            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            private final /* synthetic */ b get$cachedSerializer() {
                return (b) Overflow.$cachedSerializer$delegate.getValue();
            }

            public final b serializer() {
                return get$cachedSerializer();
            }

            private Companion() {
            }
        }
    }

    public /* synthetic */ StackComponent(int i4, List list, Boolean bool, Dimension dimension, Size size, Float f4, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, Badge badge, Overflow overflow, List list2, k0 k0Var) {
        if (1 != (i4 & 1)) {
            AbstractC0325a0.a(i4, 1, StackComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.components = list;
        if ((i4 & 2) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i4 & 4) == 0) {
            this.dimension = new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START);
        } else {
            this.dimension = dimension;
        }
        if ((i4 & 8) == 0) {
            this.size = new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE);
        } else {
            this.size = size;
        }
        if ((i4 & 16) == 0) {
            this.spacing = null;
        } else {
            this.spacing = f4;
        }
        if ((i4 & 32) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = colorScheme;
        }
        if ((i4 & 64) == 0) {
            this.background = null;
        } else {
            this.background = background;
        }
        if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) == 0) {
            this.padding = Padding.Companion.getZero();
        } else {
            this.padding = padding;
        }
        if ((i4 & 256) == 0) {
            this.margin = Padding.Companion.getZero();
        } else {
            this.margin = padding2;
        }
        if ((i4 & 512) == 0) {
            this.shape = null;
        } else {
            this.shape = shape;
        }
        if ((i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0) {
            this.border = null;
        } else {
            this.border = border;
        }
        if ((i4 & 2048) == 0) {
            this.shadow = null;
        } else {
            this.shadow = shadow;
        }
        if ((i4 & 4096) == 0) {
            this.badge = null;
        } else {
            this.badge = badge;
        }
        if ((i4 & UserMetadata.MAX_INTERNAL_KEY_SIZE) == 0) {
            this.overflow = null;
        } else {
            this.overflow = overflow;
        }
        this.overrides = (i4 & 16384) == 0 ? AbstractC0769p.g() : list2;
    }

    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    public static final /* synthetic */ void write$Self(StackComponent stackComponent, d dVar, H3.e eVar) {
        b[] bVarArr = $childSerializers;
        dVar.u(eVar, 0, bVarArr[0], stackComponent.components);
        if (dVar.j(eVar, 1) || stackComponent.visible != null) {
            dVar.E(eVar, 1, C0335h.f929a, stackComponent.visible);
        }
        if (dVar.j(eVar, 2) || !r.b(stackComponent.dimension, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START))) {
            dVar.u(eVar, 2, bVarArr[2], stackComponent.dimension);
        }
        if (dVar.j(eVar, 3) || !r.b(stackComponent.size, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE))) {
            dVar.u(eVar, 3, Size$$serializer.INSTANCE, stackComponent.size);
        }
        if (dVar.j(eVar, 4) || stackComponent.spacing != null) {
            dVar.E(eVar, 4, B.f862a, stackComponent.spacing);
        }
        if (dVar.j(eVar, 5) || stackComponent.backgroundColor != null) {
            dVar.E(eVar, 5, ColorScheme$$serializer.INSTANCE, stackComponent.backgroundColor);
        }
        if (dVar.j(eVar, 6) || stackComponent.background != null) {
            dVar.E(eVar, 6, BackgroundDeserializer.INSTANCE, stackComponent.background);
        }
        if (dVar.j(eVar, 7) || !r.b(stackComponent.padding, Padding.Companion.getZero())) {
            dVar.u(eVar, 7, Padding$$serializer.INSTANCE, stackComponent.padding);
        }
        if (dVar.j(eVar, 8) || !r.b(stackComponent.margin, Padding.Companion.getZero())) {
            dVar.u(eVar, 8, Padding$$serializer.INSTANCE, stackComponent.margin);
        }
        if (dVar.j(eVar, 9) || stackComponent.shape != null) {
            dVar.E(eVar, 9, ShapeDeserializer.INSTANCE, stackComponent.shape);
        }
        if (dVar.j(eVar, 10) || stackComponent.border != null) {
            dVar.E(eVar, 10, Border$$serializer.INSTANCE, stackComponent.border);
        }
        if (dVar.j(eVar, 11) || stackComponent.shadow != null) {
            dVar.E(eVar, 11, Shadow$$serializer.INSTANCE, stackComponent.shadow);
        }
        if (dVar.j(eVar, 12) || stackComponent.badge != null) {
            dVar.E(eVar, 12, Badge$$serializer.INSTANCE, stackComponent.badge);
        }
        if (dVar.j(eVar, 13) || stackComponent.overflow != null) {
            dVar.E(eVar, 13, StackOverflowDeserializer.INSTANCE, stackComponent.overflow);
        }
        if (!dVar.j(eVar, 14) && r.b(stackComponent.overrides, AbstractC0769p.g())) {
            return;
        }
        dVar.u(eVar, 14, bVarArr[14], stackComponent.overrides);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StackComponent)) {
            return false;
        }
        StackComponent stackComponent = (StackComponent) obj;
        return r.b(this.components, stackComponent.components) && r.b(this.visible, stackComponent.visible) && r.b(this.dimension, stackComponent.dimension) && r.b(this.size, stackComponent.size) && r.b(this.spacing, stackComponent.spacing) && r.b(this.backgroundColor, stackComponent.backgroundColor) && r.b(this.background, stackComponent.background) && r.b(this.padding, stackComponent.padding) && r.b(this.margin, stackComponent.margin) && r.b(this.shape, stackComponent.shape) && r.b(this.border, stackComponent.border) && r.b(this.shadow, stackComponent.shadow) && r.b(this.badge, stackComponent.badge) && this.overflow == stackComponent.overflow && r.b(this.overrides, stackComponent.overrides);
    }

    public final /* synthetic */ Background getBackground() {
        return this.background;
    }

    public final /* synthetic */ ColorScheme getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ Badge getBadge() {
        return this.badge;
    }

    public final /* synthetic */ Border getBorder() {
        return this.border;
    }

    public final /* synthetic */ List getComponents() {
        return this.components;
    }

    public final /* synthetic */ Dimension getDimension() {
        return this.dimension;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ Overflow getOverflow() {
        return this.overflow;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Shadow getShadow() {
        return this.shadow;
    }

    public final /* synthetic */ Shape getShape() {
        return this.shape;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ Float getSpacing() {
        return this.spacing;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = this.components.hashCode() * 31;
        Boolean bool = this.visible;
        int iHashCode2 = (((((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.dimension.hashCode()) * 31) + this.size.hashCode()) * 31;
        Float f4 = this.spacing;
        int iHashCode3 = (iHashCode2 + (f4 == null ? 0 : f4.hashCode())) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode4 = (iHashCode3 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Background background = this.background;
        int iHashCode5 = (((((iHashCode4 + (background == null ? 0 : background.hashCode())) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        Shape shape = this.shape;
        int iHashCode6 = (iHashCode5 + (shape == null ? 0 : shape.hashCode())) * 31;
        Border border = this.border;
        int iHashCode7 = (iHashCode6 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        int iHashCode8 = (iHashCode7 + (shadow == null ? 0 : shadow.hashCode())) * 31;
        Badge badge = this.badge;
        int iHashCode9 = (iHashCode8 + (badge == null ? 0 : badge.hashCode())) * 31;
        Overflow overflow = this.overflow;
        return ((iHashCode9 + (overflow != null ? overflow.hashCode() : 0)) * 31) + this.overrides.hashCode();
    }

    public String toString() {
        return "StackComponent(components=" + this.components + ", visible=" + this.visible + ", dimension=" + this.dimension + ", size=" + this.size + ", spacing=" + this.spacing + ", backgroundColor=" + this.backgroundColor + ", background=" + this.background + ", padding=" + this.padding + ", margin=" + this.margin + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", badge=" + this.badge + ", overflow=" + this.overflow + ", overrides=" + this.overrides + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StackComponent(List<? extends PaywallComponent> components, Boolean bool, Dimension dimension, Size size, Float f4, ColorScheme colorScheme, Background background, Padding padding, Padding margin, Shape shape, Border border, Shadow shadow, Badge badge, Overflow overflow, List<ComponentOverride<PartialStackComponent>> overrides) {
        r.f(components, "components");
        r.f(dimension, "dimension");
        r.f(size, "size");
        r.f(padding, "padding");
        r.f(margin, "margin");
        r.f(overrides, "overrides");
        this.components = components;
        this.visible = bool;
        this.dimension = dimension;
        this.size = size;
        this.spacing = f4;
        this.backgroundColor = colorScheme;
        this.background = background;
        this.padding = padding;
        this.margin = margin;
        this.shape = shape;
        this.border = border;
        this.shadow = shadow;
        this.badge = badge;
        this.overflow = overflow;
        this.overrides = overrides;
    }

    public /* synthetic */ StackComponent(List list, Boolean bool, Dimension dimension, Size size, Float f4, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, Badge badge, Overflow overflow, List list2, int i4, AbstractC1585j abstractC1585j) {
        this(list, (i4 & 2) != 0 ? null : bool, (i4 & 4) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : dimension, (i4 & 8) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i4 & 16) != 0 ? null : f4, (i4 & 32) != 0 ? null : colorScheme, (i4 & 64) != 0 ? null : background, (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? Padding.Companion.getZero() : padding, (i4 & 256) != 0 ? Padding.Companion.getZero() : padding2, (i4 & 512) != 0 ? null : shape, (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? null : border, (i4 & 2048) != 0 ? null : shadow, (i4 & 4096) != 0 ? null : badge, (i4 & UserMetadata.MAX_INTERNAL_KEY_SIZE) == 0 ? overflow : null, (i4 & 16384) != 0 ? AbstractC0769p.g() : list2);
    }
}
