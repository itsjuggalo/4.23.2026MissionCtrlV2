package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.C0332e;
import J3.C0335h;
import J3.k0;
import W2.j;
import W2.k;
import W2.l;
import X2.AbstractC0769p;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class TimelineComponent implements PaywallComponent {
    private final int columnGutter;
    private final IconAlignment iconAlignment;
    private final int itemSpacing;
    private final List<Item> items;
    private final Padding margin;
    private final List<ComponentOverride<PartialTimelineComponent>> overrides;
    private final Padding padding;
    private final Size size;
    private final int textSpacing;
    private final Boolean visible;
    public static final Companion Companion = new Companion(null);
    private static final b[] $childSerializers = {null, null, null, null, null, null, null, null, new C0332e(TimelineComponent$Item$$serializer.INSTANCE), new C0332e(ComponentOverride.Companion.serializer(PartialTimelineComponent$$serializer.INSTANCE))};

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return TimelineComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public static final class Connector {
        public static final Companion Companion = new Companion(null);
        private final ColorScheme color;
        private final Padding margin;
        private final int width;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return TimelineComponent$Connector$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Connector(int i4, int i5, Padding padding, ColorScheme colorScheme, k0 k0Var) {
            if (7 != (i4 & 7)) {
                AbstractC0325a0.a(i4, 7, TimelineComponent$Connector$$serializer.INSTANCE.getDescriptor());
            }
            this.width = i5;
            this.margin = padding;
            this.color = colorScheme;
        }

        public static final /* synthetic */ void write$Self(Connector connector, d dVar, e eVar) {
            dVar.k(eVar, 0, connector.width);
            dVar.u(eVar, 1, Padding$$serializer.INSTANCE, connector.margin);
            dVar.u(eVar, 2, ColorScheme$$serializer.INSTANCE, connector.color);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Connector)) {
                return false;
            }
            Connector connector = (Connector) obj;
            return this.width == connector.width && r.b(this.margin, connector.margin) && r.b(this.color, connector.color);
        }

        public final /* synthetic */ ColorScheme getColor() {
            return this.color;
        }

        public final /* synthetic */ Padding getMargin() {
            return this.margin;
        }

        public final /* synthetic */ int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.width) * 31) + this.margin.hashCode()) * 31) + this.color.hashCode();
        }

        public String toString() {
            return "Connector(width=" + this.width + ", margin=" + this.margin + ", color=" + this.color + ')';
        }

        public Connector(int i4, Padding margin, ColorScheme color) {
            r.f(margin, "margin");
            r.f(color, "color");
            this.width = i4;
            this.margin = margin;
            this.color = color;
        }
    }

    public enum IconAlignment {
        Title,
        TitleAndDescription;

        public static final Companion Companion = new Companion(null);
        private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

        public static final class Companion {

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.TimelineComponent$IconAlignment$Companion$1, reason: invalid class name */
            public static final class AnonymousClass1 extends s implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return TimelineIconAlignmentDeserializer.INSTANCE;
                }
            }

            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            private final /* synthetic */ b get$cachedSerializer() {
                return (b) IconAlignment.$cachedSerializer$delegate.getValue();
            }

            public final b serializer() {
                return get$cachedSerializer();
            }

            private Companion() {
            }
        }
    }

    public /* synthetic */ TimelineComponent(int i4, int i5, int i6, int i7, IconAlignment iconAlignment, Boolean bool, Size size, Padding padding, Padding padding2, List list, List list2, k0 k0Var) {
        if (15 != (i4 & 15)) {
            AbstractC0325a0.a(i4, 15, TimelineComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.itemSpacing = i5;
        this.textSpacing = i6;
        this.columnGutter = i7;
        this.iconAlignment = iconAlignment;
        if ((i4 & 16) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i4 & 32) == 0) {
            this.size = new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE);
        } else {
            this.size = size;
        }
        if ((i4 & 64) == 0) {
            this.padding = Padding.Companion.getZero();
        } else {
            this.padding = padding;
        }
        if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) == 0) {
            this.margin = Padding.Companion.getZero();
        } else {
            this.margin = padding2;
        }
        if ((i4 & 256) == 0) {
            this.items = AbstractC0769p.g();
        } else {
            this.items = list;
        }
        if ((i4 & 512) == 0) {
            this.overrides = AbstractC0769p.g();
        } else {
            this.overrides = list2;
        }
    }

    public static /* synthetic */ void getColumnGutter$annotations() {
    }

    public static /* synthetic */ void getIconAlignment$annotations() {
    }

    public static /* synthetic */ void getItemSpacing$annotations() {
    }

    public static /* synthetic */ void getTextSpacing$annotations() {
    }

    public static final /* synthetic */ void write$Self(TimelineComponent timelineComponent, d dVar, e eVar) {
        b[] bVarArr = $childSerializers;
        dVar.k(eVar, 0, timelineComponent.itemSpacing);
        dVar.k(eVar, 1, timelineComponent.textSpacing);
        dVar.k(eVar, 2, timelineComponent.columnGutter);
        dVar.u(eVar, 3, TimelineIconAlignmentDeserializer.INSTANCE, timelineComponent.iconAlignment);
        if (dVar.j(eVar, 4) || timelineComponent.visible != null) {
            dVar.E(eVar, 4, C0335h.f929a, timelineComponent.visible);
        }
        if (dVar.j(eVar, 5) || !r.b(timelineComponent.size, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE))) {
            dVar.u(eVar, 5, Size$$serializer.INSTANCE, timelineComponent.size);
        }
        if (dVar.j(eVar, 6) || !r.b(timelineComponent.padding, Padding.Companion.getZero())) {
            dVar.u(eVar, 6, Padding$$serializer.INSTANCE, timelineComponent.padding);
        }
        if (dVar.j(eVar, 7) || !r.b(timelineComponent.margin, Padding.Companion.getZero())) {
            dVar.u(eVar, 7, Padding$$serializer.INSTANCE, timelineComponent.margin);
        }
        if (dVar.j(eVar, 8) || !r.b(timelineComponent.items, AbstractC0769p.g())) {
            dVar.u(eVar, 8, bVarArr[8], timelineComponent.items);
        }
        if (!dVar.j(eVar, 9) && r.b(timelineComponent.overrides, AbstractC0769p.g())) {
            return;
        }
        dVar.u(eVar, 9, bVarArr[9], timelineComponent.overrides);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimelineComponent)) {
            return false;
        }
        TimelineComponent timelineComponent = (TimelineComponent) obj;
        return this.itemSpacing == timelineComponent.itemSpacing && this.textSpacing == timelineComponent.textSpacing && this.columnGutter == timelineComponent.columnGutter && this.iconAlignment == timelineComponent.iconAlignment && r.b(this.visible, timelineComponent.visible) && r.b(this.size, timelineComponent.size) && r.b(this.padding, timelineComponent.padding) && r.b(this.margin, timelineComponent.margin) && r.b(this.items, timelineComponent.items) && r.b(this.overrides, timelineComponent.overrides);
    }

    public final /* synthetic */ int getColumnGutter() {
        return this.columnGutter;
    }

    public final /* synthetic */ IconAlignment getIconAlignment() {
        return this.iconAlignment;
    }

    public final /* synthetic */ int getItemSpacing() {
        return this.itemSpacing;
    }

    public final /* synthetic */ List getItems() {
        return this.items;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ int getTextSpacing() {
        return this.textSpacing;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.itemSpacing) * 31) + Integer.hashCode(this.textSpacing)) * 31) + Integer.hashCode(this.columnGutter)) * 31) + this.iconAlignment.hashCode()) * 31;
        Boolean bool = this.visible;
        return ((((((((((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.size.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31) + this.items.hashCode()) * 31) + this.overrides.hashCode();
    }

    public String toString() {
        return "TimelineComponent(itemSpacing=" + this.itemSpacing + ", textSpacing=" + this.textSpacing + ", columnGutter=" + this.columnGutter + ", iconAlignment=" + this.iconAlignment + ", visible=" + this.visible + ", size=" + this.size + ", padding=" + this.padding + ", margin=" + this.margin + ", items=" + this.items + ", overrides=" + this.overrides + ')';
    }

    public static final class Item {
        private final Connector connector;
        private final TextComponent description;
        private final IconComponent icon;
        private final List<ComponentOverride<PartialTimelineComponentItem>> overrides;
        private final TextComponent title;
        private final Boolean visible;
        public static final Companion Companion = new Companion(null);
        private static final b[] $childSerializers = {null, null, null, null, null, new C0332e(ComponentOverride.Companion.serializer(PartialTimelineComponentItem$$serializer.INSTANCE))};

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return TimelineComponent$Item$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Item(int i4, TextComponent textComponent, Boolean bool, TextComponent textComponent2, IconComponent iconComponent, Connector connector, List list, k0 k0Var) {
            if (9 != (i4 & 9)) {
                AbstractC0325a0.a(i4, 9, TimelineComponent$Item$$serializer.INSTANCE.getDescriptor());
            }
            this.title = textComponent;
            if ((i4 & 2) == 0) {
                this.visible = null;
            } else {
                this.visible = bool;
            }
            if ((i4 & 4) == 0) {
                this.description = null;
            } else {
                this.description = textComponent2;
            }
            this.icon = iconComponent;
            if ((i4 & 16) == 0) {
                this.connector = null;
            } else {
                this.connector = connector;
            }
            if ((i4 & 32) == 0) {
                this.overrides = AbstractC0769p.g();
            } else {
                this.overrides = list;
            }
        }

        public static final /* synthetic */ void write$Self(Item item, d dVar, e eVar) {
            b[] bVarArr = $childSerializers;
            TextComponent$$serializer textComponent$$serializer = TextComponent$$serializer.INSTANCE;
            dVar.u(eVar, 0, textComponent$$serializer, item.title);
            if (dVar.j(eVar, 1) || item.visible != null) {
                dVar.E(eVar, 1, C0335h.f929a, item.visible);
            }
            if (dVar.j(eVar, 2) || item.description != null) {
                dVar.E(eVar, 2, textComponent$$serializer, item.description);
            }
            dVar.u(eVar, 3, IconComponent$$serializer.INSTANCE, item.icon);
            if (dVar.j(eVar, 4) || item.connector != null) {
                dVar.E(eVar, 4, TimelineComponent$Connector$$serializer.INSTANCE, item.connector);
            }
            if (!dVar.j(eVar, 5) && r.b(item.overrides, AbstractC0769p.g())) {
                return;
            }
            dVar.u(eVar, 5, bVarArr[5], item.overrides);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return r.b(this.title, item.title) && r.b(this.visible, item.visible) && r.b(this.description, item.description) && r.b(this.icon, item.icon) && r.b(this.connector, item.connector) && r.b(this.overrides, item.overrides);
        }

        public final /* synthetic */ Connector getConnector() {
            return this.connector;
        }

        public final /* synthetic */ TextComponent getDescription() {
            return this.description;
        }

        public final /* synthetic */ IconComponent getIcon() {
            return this.icon;
        }

        public final /* synthetic */ List getOverrides() {
            return this.overrides;
        }

        public final /* synthetic */ TextComponent getTitle() {
            return this.title;
        }

        public final /* synthetic */ Boolean getVisible() {
            return this.visible;
        }

        public int hashCode() {
            int iHashCode = this.title.hashCode() * 31;
            Boolean bool = this.visible;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            TextComponent textComponent = this.description;
            int iHashCode3 = (((iHashCode2 + (textComponent == null ? 0 : textComponent.hashCode())) * 31) + this.icon.hashCode()) * 31;
            Connector connector = this.connector;
            return ((iHashCode3 + (connector != null ? connector.hashCode() : 0)) * 31) + this.overrides.hashCode();
        }

        public String toString() {
            return "Item(title=" + this.title + ", visible=" + this.visible + ", description=" + this.description + ", icon=" + this.icon + ", connector=" + this.connector + ", overrides=" + this.overrides + ')';
        }

        public Item(TextComponent title, Boolean bool, TextComponent textComponent, IconComponent icon, Connector connector, List<ComponentOverride<PartialTimelineComponentItem>> overrides) {
            r.f(title, "title");
            r.f(icon, "icon");
            r.f(overrides, "overrides");
            this.title = title;
            this.visible = bool;
            this.description = textComponent;
            this.icon = icon;
            this.connector = connector;
            this.overrides = overrides;
        }

        public /* synthetic */ Item(TextComponent textComponent, Boolean bool, TextComponent textComponent2, IconComponent iconComponent, Connector connector, List list, int i4, AbstractC1585j abstractC1585j) {
            this(textComponent, (i4 & 2) != 0 ? null : bool, (i4 & 4) != 0 ? null : textComponent2, iconComponent, (i4 & 16) != 0 ? null : connector, (i4 & 32) != 0 ? AbstractC0769p.g() : list);
        }
    }

    public TimelineComponent(int i4, int i5, int i6, IconAlignment iconAlignment, Boolean bool, Size size, Padding padding, Padding margin, List<Item> items, List<ComponentOverride<PartialTimelineComponent>> overrides) {
        r.f(iconAlignment, "iconAlignment");
        r.f(size, "size");
        r.f(padding, "padding");
        r.f(margin, "margin");
        r.f(items, "items");
        r.f(overrides, "overrides");
        this.itemSpacing = i4;
        this.textSpacing = i5;
        this.columnGutter = i6;
        this.iconAlignment = iconAlignment;
        this.visible = bool;
        this.size = size;
        this.padding = padding;
        this.margin = margin;
        this.items = items;
        this.overrides = overrides;
    }

    public /* synthetic */ TimelineComponent(int i4, int i5, int i6, IconAlignment iconAlignment, Boolean bool, Size size, Padding padding, Padding padding2, List list, List list2, int i7, AbstractC1585j abstractC1585j) {
        this(i4, i5, i6, iconAlignment, (i7 & 16) != 0 ? null : bool, (i7 & 32) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i7 & 64) != 0 ? Padding.Companion.getZero() : padding, (i7 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? Padding.Companion.getZero() : padding2, (i7 & 256) != 0 ? AbstractC0769p.g() : list, (i7 & 512) != 0 ? AbstractC0769p.g() : list2);
    }
}
