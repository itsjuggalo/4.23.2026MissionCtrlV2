package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import I3.d;
import J3.C0335h;
import J3.H;
import J3.k0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class PartialTimelineComponent implements PartialComponent {
    public static final Companion Companion = new Companion(null);
    private final Integer columnGutter;
    private final TimelineComponent.IconAlignment iconAlignment;
    private final Integer itemSpacing;
    private final Padding margin;
    private final Padding padding;
    private final Size size;
    private final Integer textSpacing;
    private final Boolean visible;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return PartialTimelineComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public PartialTimelineComponent() {
        this((Boolean) null, (Integer) null, (Integer) null, (Integer) null, (TimelineComponent.IconAlignment) null, (Size) null, (Padding) null, (Padding) null, 255, (AbstractC1585j) null);
    }

    public static /* synthetic */ void getColumnGutter$annotations() {
    }

    public static /* synthetic */ void getIconAlignment$annotations() {
    }

    public static /* synthetic */ void getItemSpacing$annotations() {
    }

    public static /* synthetic */ void getTextSpacing$annotations() {
    }

    public static final /* synthetic */ void write$Self(PartialTimelineComponent partialTimelineComponent, d dVar, e eVar) {
        if (dVar.j(eVar, 0) || partialTimelineComponent.visible != null) {
            dVar.E(eVar, 0, C0335h.f929a, partialTimelineComponent.visible);
        }
        if (dVar.j(eVar, 1) || partialTimelineComponent.itemSpacing != null) {
            dVar.E(eVar, 1, H.f874a, partialTimelineComponent.itemSpacing);
        }
        if (dVar.j(eVar, 2) || partialTimelineComponent.textSpacing != null) {
            dVar.E(eVar, 2, H.f874a, partialTimelineComponent.textSpacing);
        }
        if (dVar.j(eVar, 3) || partialTimelineComponent.columnGutter != null) {
            dVar.E(eVar, 3, H.f874a, partialTimelineComponent.columnGutter);
        }
        if (dVar.j(eVar, 4) || partialTimelineComponent.iconAlignment != null) {
            dVar.E(eVar, 4, TimelineIconAlignmentDeserializer.INSTANCE, partialTimelineComponent.iconAlignment);
        }
        if (dVar.j(eVar, 5) || partialTimelineComponent.size != null) {
            dVar.E(eVar, 5, Size$$serializer.INSTANCE, partialTimelineComponent.size);
        }
        if (dVar.j(eVar, 6) || partialTimelineComponent.padding != null) {
            dVar.E(eVar, 6, Padding$$serializer.INSTANCE, partialTimelineComponent.padding);
        }
        if (!dVar.j(eVar, 7) && partialTimelineComponent.margin == null) {
            return;
        }
        dVar.E(eVar, 7, Padding$$serializer.INSTANCE, partialTimelineComponent.margin);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialTimelineComponent)) {
            return false;
        }
        PartialTimelineComponent partialTimelineComponent = (PartialTimelineComponent) obj;
        return r.b(this.visible, partialTimelineComponent.visible) && r.b(this.itemSpacing, partialTimelineComponent.itemSpacing) && r.b(this.textSpacing, partialTimelineComponent.textSpacing) && r.b(this.columnGutter, partialTimelineComponent.columnGutter) && this.iconAlignment == partialTimelineComponent.iconAlignment && r.b(this.size, partialTimelineComponent.size) && r.b(this.padding, partialTimelineComponent.padding) && r.b(this.margin, partialTimelineComponent.margin);
    }

    public final /* synthetic */ Integer getColumnGutter() {
        return this.columnGutter;
    }

    public final /* synthetic */ TimelineComponent.IconAlignment getIconAlignment() {
        return this.iconAlignment;
    }

    public final /* synthetic */ Integer getItemSpacing() {
        return this.itemSpacing;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ Integer getTextSpacing() {
        return this.textSpacing;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.itemSpacing;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.textSpacing;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.columnGutter;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        TimelineComponent.IconAlignment iconAlignment = this.iconAlignment;
        int iHashCode5 = (iHashCode4 + (iconAlignment == null ? 0 : iconAlignment.hashCode())) * 31;
        Size size = this.size;
        int iHashCode6 = (iHashCode5 + (size == null ? 0 : size.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode7 = (iHashCode6 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        return iHashCode7 + (padding2 != null ? padding2.hashCode() : 0);
    }

    public String toString() {
        return "PartialTimelineComponent(visible=" + this.visible + ", itemSpacing=" + this.itemSpacing + ", textSpacing=" + this.textSpacing + ", columnGutter=" + this.columnGutter + ", iconAlignment=" + this.iconAlignment + ", size=" + this.size + ", padding=" + this.padding + ", margin=" + this.margin + ')';
    }

    public /* synthetic */ PartialTimelineComponent(int i4, Boolean bool, Integer num, Integer num2, Integer num3, TimelineComponent.IconAlignment iconAlignment, Size size, Padding padding, Padding padding2, k0 k0Var) {
        if ((i4 & 1) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i4 & 2) == 0) {
            this.itemSpacing = null;
        } else {
            this.itemSpacing = num;
        }
        if ((i4 & 4) == 0) {
            this.textSpacing = null;
        } else {
            this.textSpacing = num2;
        }
        if ((i4 & 8) == 0) {
            this.columnGutter = null;
        } else {
            this.columnGutter = num3;
        }
        if ((i4 & 16) == 0) {
            this.iconAlignment = null;
        } else {
            this.iconAlignment = iconAlignment;
        }
        if ((i4 & 32) == 0) {
            this.size = null;
        } else {
            this.size = size;
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
    }

    public PartialTimelineComponent(Boolean bool, Integer num, Integer num2, Integer num3, TimelineComponent.IconAlignment iconAlignment, Size size, Padding padding, Padding padding2) {
        this.visible = bool;
        this.itemSpacing = num;
        this.textSpacing = num2;
        this.columnGutter = num3;
        this.iconAlignment = iconAlignment;
        this.size = size;
        this.padding = padding;
        this.margin = padding2;
    }

    public /* synthetic */ PartialTimelineComponent(Boolean bool, Integer num, Integer num2, Integer num3, TimelineComponent.IconAlignment iconAlignment, Size size, Padding padding, Padding padding2, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? null : bool, (i4 & 2) != 0 ? null : num, (i4 & 4) != 0 ? null : num2, (i4 & 8) != 0 ? null : num3, (i4 & 16) != 0 ? null : iconAlignment, (i4 & 32) != 0 ? null : size, (i4 & 64) != 0 ? null : padding, (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? null : padding2);
    }
}
