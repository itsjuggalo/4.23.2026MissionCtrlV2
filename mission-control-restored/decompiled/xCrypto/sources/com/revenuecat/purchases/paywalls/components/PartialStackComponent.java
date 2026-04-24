package com.revenuecat.purchases.paywalls.components;

import F3.b;
import F3.e;
import I3.d;
import J3.B;
import J3.C0335h;
import J3.k0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
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
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class PartialStackComponent implements PartialComponent {
    private final Background background;
    private final ColorScheme backgroundColor;
    private final Badge badge;
    private final Border border;
    private final Dimension dimension;
    private final Padding margin;
    private final StackComponent.Overflow overflow;
    private final Padding padding;
    private final Shadow shadow;
    private final Shape shape;
    private final Size size;
    private final Float spacing;
    private final Boolean visible;
    public static final Companion Companion = new Companion(null);
    private static final b[] $childSerializers = {null, new e("com.revenuecat.purchases.paywalls.components.properties.Dimension", G.b(Dimension.class), new InterfaceC1716c[]{G.b(Dimension.Horizontal.class), G.b(Dimension.Vertical.class), G.b(Dimension.ZLayer.class)}, new b[]{Dimension$Horizontal$$serializer.INSTANCE, Dimension$Vertical$$serializer.INSTANCE, Dimension$ZLayer$$serializer.INSTANCE}, new Annotation[0]), null, null, null, null, null, null, null, null, null, null, null};

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return PartialStackComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public PartialStackComponent() {
        this((Boolean) null, (Dimension) null, (Size) null, (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, 8191, (AbstractC1585j) null);
    }

    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    public static final /* synthetic */ void write$Self(PartialStackComponent partialStackComponent, d dVar, H3.e eVar) {
        b[] bVarArr = $childSerializers;
        if (dVar.j(eVar, 0) || !r.b(partialStackComponent.visible, Boolean.TRUE)) {
            dVar.E(eVar, 0, C0335h.f929a, partialStackComponent.visible);
        }
        if (dVar.j(eVar, 1) || partialStackComponent.dimension != null) {
            dVar.E(eVar, 1, bVarArr[1], partialStackComponent.dimension);
        }
        if (dVar.j(eVar, 2) || partialStackComponent.size != null) {
            dVar.E(eVar, 2, Size$$serializer.INSTANCE, partialStackComponent.size);
        }
        if (dVar.j(eVar, 3) || partialStackComponent.spacing != null) {
            dVar.E(eVar, 3, B.f862a, partialStackComponent.spacing);
        }
        if (dVar.j(eVar, 4) || partialStackComponent.backgroundColor != null) {
            dVar.E(eVar, 4, ColorScheme$$serializer.INSTANCE, partialStackComponent.backgroundColor);
        }
        if (dVar.j(eVar, 5) || partialStackComponent.background != null) {
            dVar.E(eVar, 5, BackgroundDeserializer.INSTANCE, partialStackComponent.background);
        }
        if (dVar.j(eVar, 6) || partialStackComponent.padding != null) {
            dVar.E(eVar, 6, Padding$$serializer.INSTANCE, partialStackComponent.padding);
        }
        if (dVar.j(eVar, 7) || partialStackComponent.margin != null) {
            dVar.E(eVar, 7, Padding$$serializer.INSTANCE, partialStackComponent.margin);
        }
        if (dVar.j(eVar, 8) || partialStackComponent.shape != null) {
            dVar.E(eVar, 8, ShapeDeserializer.INSTANCE, partialStackComponent.shape);
        }
        if (dVar.j(eVar, 9) || partialStackComponent.border != null) {
            dVar.E(eVar, 9, Border$$serializer.INSTANCE, partialStackComponent.border);
        }
        if (dVar.j(eVar, 10) || partialStackComponent.shadow != null) {
            dVar.E(eVar, 10, Shadow$$serializer.INSTANCE, partialStackComponent.shadow);
        }
        if (dVar.j(eVar, 11) || partialStackComponent.badge != null) {
            dVar.E(eVar, 11, Badge$$serializer.INSTANCE, partialStackComponent.badge);
        }
        if (!dVar.j(eVar, 12) && partialStackComponent.overflow == null) {
            return;
        }
        dVar.E(eVar, 12, StackOverflowDeserializer.INSTANCE, partialStackComponent.overflow);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialStackComponent)) {
            return false;
        }
        PartialStackComponent partialStackComponent = (PartialStackComponent) obj;
        return r.b(this.visible, partialStackComponent.visible) && r.b(this.dimension, partialStackComponent.dimension) && r.b(this.size, partialStackComponent.size) && r.b(this.spacing, partialStackComponent.spacing) && r.b(this.backgroundColor, partialStackComponent.backgroundColor) && r.b(this.background, partialStackComponent.background) && r.b(this.padding, partialStackComponent.padding) && r.b(this.margin, partialStackComponent.margin) && r.b(this.shape, partialStackComponent.shape) && r.b(this.border, partialStackComponent.border) && r.b(this.shadow, partialStackComponent.shadow) && r.b(this.badge, partialStackComponent.badge) && this.overflow == partialStackComponent.overflow;
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

    public final /* synthetic */ Dimension getDimension() {
        return this.dimension;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ StackComponent.Overflow getOverflow() {
        return this.overflow;
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
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Dimension dimension = this.dimension;
        int iHashCode2 = (iHashCode + (dimension == null ? 0 : dimension.hashCode())) * 31;
        Size size = this.size;
        int iHashCode3 = (iHashCode2 + (size == null ? 0 : size.hashCode())) * 31;
        Float f4 = this.spacing;
        int iHashCode4 = (iHashCode3 + (f4 == null ? 0 : f4.hashCode())) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode5 = (iHashCode4 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Background background = this.background;
        int iHashCode6 = (iHashCode5 + (background == null ? 0 : background.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode7 = (iHashCode6 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        int iHashCode8 = (iHashCode7 + (padding2 == null ? 0 : padding2.hashCode())) * 31;
        Shape shape = this.shape;
        int iHashCode9 = (iHashCode8 + (shape == null ? 0 : shape.hashCode())) * 31;
        Border border = this.border;
        int iHashCode10 = (iHashCode9 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        int iHashCode11 = (iHashCode10 + (shadow == null ? 0 : shadow.hashCode())) * 31;
        Badge badge = this.badge;
        int iHashCode12 = (iHashCode11 + (badge == null ? 0 : badge.hashCode())) * 31;
        StackComponent.Overflow overflow = this.overflow;
        return iHashCode12 + (overflow != null ? overflow.hashCode() : 0);
    }

    public String toString() {
        return "PartialStackComponent(visible=" + this.visible + ", dimension=" + this.dimension + ", size=" + this.size + ", spacing=" + this.spacing + ", backgroundColor=" + this.backgroundColor + ", background=" + this.background + ", padding=" + this.padding + ", margin=" + this.margin + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", badge=" + this.badge + ", overflow=" + this.overflow + ')';
    }

    public /* synthetic */ PartialStackComponent(int i4, Boolean bool, Dimension dimension, Size size, Float f4, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, Badge badge, StackComponent.Overflow overflow, k0 k0Var) {
        this.visible = (i4 & 1) == 0 ? Boolean.TRUE : bool;
        if ((i4 & 2) == 0) {
            this.dimension = null;
        } else {
            this.dimension = dimension;
        }
        if ((i4 & 4) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((i4 & 8) == 0) {
            this.spacing = null;
        } else {
            this.spacing = f4;
        }
        if ((i4 & 16) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = colorScheme;
        }
        if ((i4 & 32) == 0) {
            this.background = null;
        } else {
            this.background = background;
        }
        if ((i4 & 64) == 0) {
            this.padding = null;
        } else {
            this.padding = padding;
        }
        if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) == 0) {
            this.margin = null;
        } else {
            this.margin = padding2;
        }
        if ((i4 & 256) == 0) {
            this.shape = null;
        } else {
            this.shape = shape;
        }
        if ((i4 & 512) == 0) {
            this.border = null;
        } else {
            this.border = border;
        }
        if ((i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0) {
            this.shadow = null;
        } else {
            this.shadow = shadow;
        }
        if ((i4 & 2048) == 0) {
            this.badge = null;
        } else {
            this.badge = badge;
        }
        if ((i4 & 4096) == 0) {
            this.overflow = null;
        } else {
            this.overflow = overflow;
        }
    }

    public PartialStackComponent(Boolean bool, Dimension dimension, Size size, Float f4, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, Badge badge, StackComponent.Overflow overflow) {
        this.visible = bool;
        this.dimension = dimension;
        this.size = size;
        this.spacing = f4;
        this.backgroundColor = colorScheme;
        this.background = background;
        this.padding = padding;
        this.margin = padding2;
        this.shape = shape;
        this.border = border;
        this.shadow = shadow;
        this.badge = badge;
        this.overflow = overflow;
    }

    public /* synthetic */ PartialStackComponent(Boolean bool, Dimension dimension, Size size, Float f4, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, Badge badge, StackComponent.Overflow overflow, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? Boolean.TRUE : bool, (i4 & 2) != 0 ? null : dimension, (i4 & 4) != 0 ? null : size, (i4 & 8) != 0 ? null : f4, (i4 & 16) != 0 ? null : colorScheme, (i4 & 32) != 0 ? null : background, (i4 & 64) != 0 ? null : padding, (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? null : padding2, (i4 & 256) != 0 ? null : shape, (i4 & 512) != 0 ? null : border, (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? null : shadow, (i4 & 2048) != 0 ? null : badge, (i4 & 4096) != 0 ? null : overflow);
    }
}
