package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.C0332e;
import J3.C0335h;
import J3.k0;
import X2.AbstractC0769p;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class IconComponent implements PaywallComponent {
    private final String baseUrl;
    private final ColorScheme color;
    private final Formats formats;
    private final IconBackground iconBackground;
    private final String iconName;
    private final Padding margin;
    private final List<ComponentOverride<PartialIconComponent>> overrides;
    private final Padding padding;
    private final Size size;
    private final Boolean visible;
    public static final Companion Companion = new Companion(null);
    private static final b[] $childSerializers = {null, null, null, null, null, null, null, null, null, new C0332e(ComponentOverride.Companion.serializer(PartialIconComponent$$serializer.INSTANCE))};

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return IconComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public static final class Formats {
        public static final Companion Companion = new Companion(null);
        private final String webp;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return IconComponent$Formats$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Formats(int i4, String str, k0 k0Var) {
            if (1 != (i4 & 1)) {
                AbstractC0325a0.a(i4, 1, IconComponent$Formats$$serializer.INSTANCE.getDescriptor());
            }
            this.webp = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Formats) && r.b(this.webp, ((Formats) obj).webp);
        }

        public final /* synthetic */ String getWebp() {
            return this.webp;
        }

        public int hashCode() {
            return this.webp.hashCode();
        }

        public String toString() {
            return "Formats(webp=" + this.webp + ')';
        }

        public Formats(String webp) {
            r.f(webp, "webp");
            this.webp = webp;
        }
    }

    public static final class IconBackground {
        public static final Companion Companion = new Companion(null);
        private final Border border;
        private final ColorScheme color;
        private final Shadow shadow;
        private final MaskShape shape;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return IconComponent$IconBackground$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ IconBackground(int i4, ColorScheme colorScheme, MaskShape maskShape, Border border, Shadow shadow, k0 k0Var) {
            if (3 != (i4 & 3)) {
                AbstractC0325a0.a(i4, 3, IconComponent$IconBackground$$serializer.INSTANCE.getDescriptor());
            }
            this.color = colorScheme;
            this.shape = maskShape;
            if ((i4 & 4) == 0) {
                this.border = null;
            } else {
                this.border = border;
            }
            if ((i4 & 8) == 0) {
                this.shadow = null;
            } else {
                this.shadow = shadow;
            }
        }

        public static final /* synthetic */ void write$Self(IconBackground iconBackground, d dVar, e eVar) {
            dVar.u(eVar, 0, ColorScheme$$serializer.INSTANCE, iconBackground.color);
            dVar.u(eVar, 1, MaskShapeDeserializer.INSTANCE, iconBackground.shape);
            if (dVar.j(eVar, 2) || iconBackground.border != null) {
                dVar.E(eVar, 2, Border$$serializer.INSTANCE, iconBackground.border);
            }
            if (!dVar.j(eVar, 3) && iconBackground.shadow == null) {
                return;
            }
            dVar.E(eVar, 3, Shadow$$serializer.INSTANCE, iconBackground.shadow);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IconBackground)) {
                return false;
            }
            IconBackground iconBackground = (IconBackground) obj;
            return r.b(this.color, iconBackground.color) && r.b(this.shape, iconBackground.shape) && r.b(this.border, iconBackground.border) && r.b(this.shadow, iconBackground.shadow);
        }

        public final /* synthetic */ Border getBorder() {
            return this.border;
        }

        public final /* synthetic */ ColorScheme getColor() {
            return this.color;
        }

        public final /* synthetic */ Shadow getShadow() {
            return this.shadow;
        }

        public final /* synthetic */ MaskShape getShape() {
            return this.shape;
        }

        public int hashCode() {
            int iHashCode = ((this.color.hashCode() * 31) + this.shape.hashCode()) * 31;
            Border border = this.border;
            int iHashCode2 = (iHashCode + (border == null ? 0 : border.hashCode())) * 31;
            Shadow shadow = this.shadow;
            return iHashCode2 + (shadow != null ? shadow.hashCode() : 0);
        }

        public String toString() {
            return "IconBackground(color=" + this.color + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ')';
        }

        public IconBackground(ColorScheme color, MaskShape shape, Border border, Shadow shadow) {
            r.f(color, "color");
            r.f(shape, "shape");
            this.color = color;
            this.shape = shape;
            this.border = border;
            this.shadow = shadow;
        }

        public /* synthetic */ IconBackground(ColorScheme colorScheme, MaskShape maskShape, Border border, Shadow shadow, int i4, AbstractC1585j abstractC1585j) {
            this(colorScheme, maskShape, (i4 & 4) != 0 ? null : border, (i4 & 8) != 0 ? null : shadow);
        }
    }

    public /* synthetic */ IconComponent(int i4, String str, String str2, Formats formats, Boolean bool, Size size, ColorScheme colorScheme, Padding padding, Padding padding2, IconBackground iconBackground, List list, k0 k0Var) {
        if (7 != (i4 & 7)) {
            AbstractC0325a0.a(i4, 7, IconComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.baseUrl = str;
        this.iconName = str2;
        this.formats = formats;
        if ((i4 & 8) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i4 & 16) == 0) {
            this.size = new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE);
        } else {
            this.size = size;
        }
        if ((i4 & 32) == 0) {
            this.color = null;
        } else {
            this.color = colorScheme;
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
            this.iconBackground = null;
        } else {
            this.iconBackground = iconBackground;
        }
        if ((i4 & 512) == 0) {
            this.overrides = AbstractC0769p.g();
        } else {
            this.overrides = list;
        }
    }

    public static /* synthetic */ void getBaseUrl$annotations() {
    }

    public static /* synthetic */ void getIconBackground$annotations() {
    }

    public static /* synthetic */ void getIconName$annotations() {
    }

    public static final /* synthetic */ void write$Self(IconComponent iconComponent, d dVar, e eVar) {
        b[] bVarArr = $childSerializers;
        dVar.o(eVar, 0, iconComponent.baseUrl);
        dVar.o(eVar, 1, iconComponent.iconName);
        dVar.u(eVar, 2, IconComponent$Formats$$serializer.INSTANCE, iconComponent.formats);
        if (dVar.j(eVar, 3) || iconComponent.visible != null) {
            dVar.E(eVar, 3, C0335h.f929a, iconComponent.visible);
        }
        if (dVar.j(eVar, 4) || !r.b(iconComponent.size, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE))) {
            dVar.u(eVar, 4, Size$$serializer.INSTANCE, iconComponent.size);
        }
        if (dVar.j(eVar, 5) || iconComponent.color != null) {
            dVar.E(eVar, 5, ColorScheme$$serializer.INSTANCE, iconComponent.color);
        }
        if (dVar.j(eVar, 6) || !r.b(iconComponent.padding, Padding.Companion.getZero())) {
            dVar.u(eVar, 6, Padding$$serializer.INSTANCE, iconComponent.padding);
        }
        if (dVar.j(eVar, 7) || !r.b(iconComponent.margin, Padding.Companion.getZero())) {
            dVar.u(eVar, 7, Padding$$serializer.INSTANCE, iconComponent.margin);
        }
        if (dVar.j(eVar, 8) || iconComponent.iconBackground != null) {
            dVar.E(eVar, 8, IconComponent$IconBackground$$serializer.INSTANCE, iconComponent.iconBackground);
        }
        if (!dVar.j(eVar, 9) && r.b(iconComponent.overrides, AbstractC0769p.g())) {
            return;
        }
        dVar.u(eVar, 9, bVarArr[9], iconComponent.overrides);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IconComponent)) {
            return false;
        }
        IconComponent iconComponent = (IconComponent) obj;
        return r.b(this.baseUrl, iconComponent.baseUrl) && r.b(this.iconName, iconComponent.iconName) && r.b(this.formats, iconComponent.formats) && r.b(this.visible, iconComponent.visible) && r.b(this.size, iconComponent.size) && r.b(this.color, iconComponent.color) && r.b(this.padding, iconComponent.padding) && r.b(this.margin, iconComponent.margin) && r.b(this.iconBackground, iconComponent.iconBackground) && r.b(this.overrides, iconComponent.overrides);
    }

    public final /* synthetic */ String getBaseUrl() {
        return this.baseUrl;
    }

    public final /* synthetic */ ColorScheme getColor() {
        return this.color;
    }

    public final /* synthetic */ Formats getFormats() {
        return this.formats;
    }

    public final /* synthetic */ IconBackground getIconBackground() {
        return this.iconBackground;
    }

    public final /* synthetic */ String getIconName() {
        return this.iconName;
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

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = ((((this.baseUrl.hashCode() * 31) + this.iconName.hashCode()) * 31) + this.formats.hashCode()) * 31;
        Boolean bool = this.visible;
        int iHashCode2 = (((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.size.hashCode()) * 31;
        ColorScheme colorScheme = this.color;
        int iHashCode3 = (((((iHashCode2 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        IconBackground iconBackground = this.iconBackground;
        return ((iHashCode3 + (iconBackground != null ? iconBackground.hashCode() : 0)) * 31) + this.overrides.hashCode();
    }

    public String toString() {
        return "IconComponent(baseUrl=" + this.baseUrl + ", iconName=" + this.iconName + ", formats=" + this.formats + ", visible=" + this.visible + ", size=" + this.size + ", color=" + this.color + ", padding=" + this.padding + ", margin=" + this.margin + ", iconBackground=" + this.iconBackground + ", overrides=" + this.overrides + ')';
    }

    public IconComponent(String baseUrl, String iconName, Formats formats, Boolean bool, Size size, ColorScheme colorScheme, Padding padding, Padding margin, IconBackground iconBackground, List<ComponentOverride<PartialIconComponent>> overrides) {
        r.f(baseUrl, "baseUrl");
        r.f(iconName, "iconName");
        r.f(formats, "formats");
        r.f(size, "size");
        r.f(padding, "padding");
        r.f(margin, "margin");
        r.f(overrides, "overrides");
        this.baseUrl = baseUrl;
        this.iconName = iconName;
        this.formats = formats;
        this.visible = bool;
        this.size = size;
        this.color = colorScheme;
        this.padding = padding;
        this.margin = margin;
        this.iconBackground = iconBackground;
        this.overrides = overrides;
    }

    public /* synthetic */ IconComponent(String str, String str2, Formats formats, Boolean bool, Size size, ColorScheme colorScheme, Padding padding, Padding padding2, IconBackground iconBackground, List list, int i4, AbstractC1585j abstractC1585j) {
        this(str, str2, formats, (i4 & 8) != 0 ? null : bool, (i4 & 16) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i4 & 32) != 0 ? null : colorScheme, (i4 & 64) != 0 ? Padding.Companion.getZero() : padding, (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? Padding.Companion.getZero() : padding2, (i4 & 256) != 0 ? null : iconBackground, (i4 & 512) != 0 ? AbstractC0769p.g() : list);
    }
}
