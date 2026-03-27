package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import I3.d;
import J3.B;
import J3.C0335h;
import J3.H;
import J3.k0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignmentDeserializer;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class PartialCarouselComponent implements PartialComponent {
    public static final Companion Companion = new Companion(null);
    private final CarouselComponent.AutoAdvancePages autoAdvance;
    private final Background background;
    private final ColorScheme backgroundColor;
    private final Border border;
    private final Integer initialPageIndex;
    private final Boolean loop;
    private final Padding margin;
    private final Padding padding;
    private final VerticalAlignment pageAlignment;
    private final CarouselComponent.PageControl pageControl;
    private final Integer pagePeek;
    private final Float pageSpacing;
    private final Shadow shadow;
    private final Shape shape;
    private final Size size;
    private final Boolean visible;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return PartialCarouselComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public PartialCarouselComponent() {
        this((Boolean) null, (Integer) null, (VerticalAlignment) null, (Size) null, (Integer) null, (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (CarouselComponent.PageControl) null, (Boolean) null, (CarouselComponent.AutoAdvancePages) null, 65535, (AbstractC1585j) null);
    }

    public static /* synthetic */ void getAutoAdvance$annotations() {
    }

    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    public static /* synthetic */ void getInitialPageIndex$annotations() {
    }

    public static /* synthetic */ void getPageAlignment$annotations() {
    }

    public static /* synthetic */ void getPageControl$annotations() {
    }

    public static /* synthetic */ void getPagePeek$annotations() {
    }

    public static /* synthetic */ void getPageSpacing$annotations() {
    }

    public static final /* synthetic */ void write$Self(PartialCarouselComponent partialCarouselComponent, d dVar, e eVar) {
        if (dVar.j(eVar, 0) || partialCarouselComponent.visible != null) {
            dVar.E(eVar, 0, C0335h.f929a, partialCarouselComponent.visible);
        }
        if (dVar.j(eVar, 1) || partialCarouselComponent.initialPageIndex != null) {
            dVar.E(eVar, 1, H.f874a, partialCarouselComponent.initialPageIndex);
        }
        if (dVar.j(eVar, 2) || partialCarouselComponent.pageAlignment != null) {
            dVar.E(eVar, 2, VerticalAlignmentDeserializer.INSTANCE, partialCarouselComponent.pageAlignment);
        }
        if (dVar.j(eVar, 3) || partialCarouselComponent.size != null) {
            dVar.E(eVar, 3, Size$$serializer.INSTANCE, partialCarouselComponent.size);
        }
        if (dVar.j(eVar, 4) || partialCarouselComponent.pagePeek != null) {
            dVar.E(eVar, 4, H.f874a, partialCarouselComponent.pagePeek);
        }
        if (dVar.j(eVar, 5) || partialCarouselComponent.pageSpacing != null) {
            dVar.E(eVar, 5, B.f862a, partialCarouselComponent.pageSpacing);
        }
        if (dVar.j(eVar, 6) || partialCarouselComponent.backgroundColor != null) {
            dVar.E(eVar, 6, ColorScheme$$serializer.INSTANCE, partialCarouselComponent.backgroundColor);
        }
        if (dVar.j(eVar, 7) || partialCarouselComponent.background != null) {
            dVar.E(eVar, 7, BackgroundDeserializer.INSTANCE, partialCarouselComponent.background);
        }
        if (dVar.j(eVar, 8) || partialCarouselComponent.padding != null) {
            dVar.E(eVar, 8, Padding$$serializer.INSTANCE, partialCarouselComponent.padding);
        }
        if (dVar.j(eVar, 9) || partialCarouselComponent.margin != null) {
            dVar.E(eVar, 9, Padding$$serializer.INSTANCE, partialCarouselComponent.margin);
        }
        if (dVar.j(eVar, 10) || partialCarouselComponent.shape != null) {
            dVar.E(eVar, 10, ShapeDeserializer.INSTANCE, partialCarouselComponent.shape);
        }
        if (dVar.j(eVar, 11) || partialCarouselComponent.border != null) {
            dVar.E(eVar, 11, Border$$serializer.INSTANCE, partialCarouselComponent.border);
        }
        if (dVar.j(eVar, 12) || partialCarouselComponent.shadow != null) {
            dVar.E(eVar, 12, Shadow$$serializer.INSTANCE, partialCarouselComponent.shadow);
        }
        if (dVar.j(eVar, 13) || partialCarouselComponent.pageControl != null) {
            dVar.E(eVar, 13, CarouselComponent$PageControl$$serializer.INSTANCE, partialCarouselComponent.pageControl);
        }
        if (dVar.j(eVar, 14) || partialCarouselComponent.loop != null) {
            dVar.E(eVar, 14, C0335h.f929a, partialCarouselComponent.loop);
        }
        if (!dVar.j(eVar, 15) && partialCarouselComponent.autoAdvance == null) {
            return;
        }
        dVar.E(eVar, 15, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, partialCarouselComponent.autoAdvance);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialCarouselComponent)) {
            return false;
        }
        PartialCarouselComponent partialCarouselComponent = (PartialCarouselComponent) obj;
        return r.b(this.visible, partialCarouselComponent.visible) && r.b(this.initialPageIndex, partialCarouselComponent.initialPageIndex) && this.pageAlignment == partialCarouselComponent.pageAlignment && r.b(this.size, partialCarouselComponent.size) && r.b(this.pagePeek, partialCarouselComponent.pagePeek) && r.b(this.pageSpacing, partialCarouselComponent.pageSpacing) && r.b(this.backgroundColor, partialCarouselComponent.backgroundColor) && r.b(this.background, partialCarouselComponent.background) && r.b(this.padding, partialCarouselComponent.padding) && r.b(this.margin, partialCarouselComponent.margin) && r.b(this.shape, partialCarouselComponent.shape) && r.b(this.border, partialCarouselComponent.border) && r.b(this.shadow, partialCarouselComponent.shadow) && r.b(this.pageControl, partialCarouselComponent.pageControl) && r.b(this.loop, partialCarouselComponent.loop) && r.b(this.autoAdvance, partialCarouselComponent.autoAdvance);
    }

    public final /* synthetic */ CarouselComponent.AutoAdvancePages getAutoAdvance() {
        return this.autoAdvance;
    }

    public final /* synthetic */ Background getBackground() {
        return this.background;
    }

    public final /* synthetic */ ColorScheme getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ Border getBorder() {
        return this.border;
    }

    public final /* synthetic */ Integer getInitialPageIndex() {
        return this.initialPageIndex;
    }

    public final /* synthetic */ Boolean getLoop() {
        return this.loop;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ VerticalAlignment getPageAlignment() {
        return this.pageAlignment;
    }

    public final /* synthetic */ CarouselComponent.PageControl getPageControl() {
        return this.pageControl;
    }

    public final /* synthetic */ Integer getPagePeek() {
        return this.pagePeek;
    }

    public final /* synthetic */ Float getPageSpacing() {
        return this.pageSpacing;
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

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.initialPageIndex;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        VerticalAlignment verticalAlignment = this.pageAlignment;
        int iHashCode3 = (iHashCode2 + (verticalAlignment == null ? 0 : verticalAlignment.hashCode())) * 31;
        Size size = this.size;
        int iHashCode4 = (iHashCode3 + (size == null ? 0 : size.hashCode())) * 31;
        Integer num2 = this.pagePeek;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Float f4 = this.pageSpacing;
        int iHashCode6 = (iHashCode5 + (f4 == null ? 0 : f4.hashCode())) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode7 = (iHashCode6 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Background background = this.background;
        int iHashCode8 = (iHashCode7 + (background == null ? 0 : background.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode9 = (iHashCode8 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        int iHashCode10 = (iHashCode9 + (padding2 == null ? 0 : padding2.hashCode())) * 31;
        Shape shape = this.shape;
        int iHashCode11 = (iHashCode10 + (shape == null ? 0 : shape.hashCode())) * 31;
        Border border = this.border;
        int iHashCode12 = (iHashCode11 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        int iHashCode13 = (iHashCode12 + (shadow == null ? 0 : shadow.hashCode())) * 31;
        CarouselComponent.PageControl pageControl = this.pageControl;
        int iHashCode14 = (iHashCode13 + (pageControl == null ? 0 : pageControl.hashCode())) * 31;
        Boolean bool2 = this.loop;
        int iHashCode15 = (iHashCode14 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        CarouselComponent.AutoAdvancePages autoAdvancePages = this.autoAdvance;
        return iHashCode15 + (autoAdvancePages != null ? autoAdvancePages.hashCode() : 0);
    }

    public String toString() {
        return "PartialCarouselComponent(visible=" + this.visible + ", initialPageIndex=" + this.initialPageIndex + ", pageAlignment=" + this.pageAlignment + ", size=" + this.size + ", pagePeek=" + this.pagePeek + ", pageSpacing=" + this.pageSpacing + ", backgroundColor=" + this.backgroundColor + ", background=" + this.background + ", padding=" + this.padding + ", margin=" + this.margin + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", pageControl=" + this.pageControl + ", loop=" + this.loop + ", autoAdvance=" + this.autoAdvance + ')';
    }

    public /* synthetic */ PartialCarouselComponent(int i4, Boolean bool, Integer num, VerticalAlignment verticalAlignment, Size size, Integer num2, Float f4, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, CarouselComponent.PageControl pageControl, Boolean bool2, CarouselComponent.AutoAdvancePages autoAdvancePages, k0 k0Var) {
        if ((i4 & 1) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i4 & 2) == 0) {
            this.initialPageIndex = null;
        } else {
            this.initialPageIndex = num;
        }
        if ((i4 & 4) == 0) {
            this.pageAlignment = null;
        } else {
            this.pageAlignment = verticalAlignment;
        }
        if ((i4 & 8) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((i4 & 16) == 0) {
            this.pagePeek = null;
        } else {
            this.pagePeek = num2;
        }
        if ((i4 & 32) == 0) {
            this.pageSpacing = null;
        } else {
            this.pageSpacing = f4;
        }
        if ((i4 & 64) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = colorScheme;
        }
        if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) == 0) {
            this.background = null;
        } else {
            this.background = background;
        }
        if ((i4 & 256) == 0) {
            this.padding = null;
        } else {
            this.padding = padding;
        }
        if ((i4 & 512) == 0) {
            this.margin = null;
        } else {
            this.margin = padding2;
        }
        if ((i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0) {
            this.shape = null;
        } else {
            this.shape = shape;
        }
        if ((i4 & 2048) == 0) {
            this.border = null;
        } else {
            this.border = border;
        }
        if ((i4 & 4096) == 0) {
            this.shadow = null;
        } else {
            this.shadow = shadow;
        }
        if ((i4 & UserMetadata.MAX_INTERNAL_KEY_SIZE) == 0) {
            this.pageControl = null;
        } else {
            this.pageControl = pageControl;
        }
        if ((i4 & 16384) == 0) {
            this.loop = null;
        } else {
            this.loop = bool2;
        }
        if ((i4 & 32768) == 0) {
            this.autoAdvance = null;
        } else {
            this.autoAdvance = autoAdvancePages;
        }
    }

    public PartialCarouselComponent(Boolean bool, Integer num, VerticalAlignment verticalAlignment, Size size, Integer num2, Float f4, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, CarouselComponent.PageControl pageControl, Boolean bool2, CarouselComponent.AutoAdvancePages autoAdvancePages) {
        this.visible = bool;
        this.initialPageIndex = num;
        this.pageAlignment = verticalAlignment;
        this.size = size;
        this.pagePeek = num2;
        this.pageSpacing = f4;
        this.backgroundColor = colorScheme;
        this.background = background;
        this.padding = padding;
        this.margin = padding2;
        this.shape = shape;
        this.border = border;
        this.shadow = shadow;
        this.pageControl = pageControl;
        this.loop = bool2;
        this.autoAdvance = autoAdvancePages;
    }

    public /* synthetic */ PartialCarouselComponent(Boolean bool, Integer num, VerticalAlignment verticalAlignment, Size size, Integer num2, Float f4, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, CarouselComponent.PageControl pageControl, Boolean bool2, CarouselComponent.AutoAdvancePages autoAdvancePages, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? null : bool, (i4 & 2) != 0 ? null : num, (i4 & 4) != 0 ? null : verticalAlignment, (i4 & 8) != 0 ? null : size, (i4 & 16) != 0 ? null : num2, (i4 & 32) != 0 ? null : f4, (i4 & 64) != 0 ? null : colorScheme, (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? null : background, (i4 & 256) != 0 ? null : padding, (i4 & 512) != 0 ? null : padding2, (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? null : shape, (i4 & 2048) != 0 ? null : border, (i4 & 4096) != 0 ? null : shadow, (i4 & UserMetadata.MAX_INTERNAL_KEY_SIZE) != 0 ? null : pageControl, (i4 & 16384) != 0 ? null : bool2, (i4 & 32768) != 0 ? null : autoAdvancePages);
    }
}
