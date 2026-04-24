package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import I3.d;
import J3.C0335h;
import J3.k0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FitModeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls$$serializer;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class PartialImageComponent implements PartialComponent {
    public static final Companion Companion = new Companion(null);
    private final Border border;
    private final ColorScheme colorOverlay;
    private final FitMode fitMode;
    private final Padding margin;
    private final MaskShape maskShape;
    private final String overrideSourceLid;
    private final Padding padding;
    private final Shadow shadow;
    private final Size size;
    private final ThemeImageUrls source;
    private final Boolean visible;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return PartialImageComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PartialImageComponent(int i4, Boolean bool, ThemeImageUrls themeImageUrls, Size size, String str, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, k0 k0Var, AbstractC1585j abstractC1585j) {
        this(i4, bool, themeImageUrls, size, str, fitMode, maskShape, colorScheme, padding, padding2, border, shadow, k0Var);
    }

    public static /* synthetic */ void getColorOverlay$annotations() {
    }

    public static /* synthetic */ void getFitMode$annotations() {
    }

    public static /* synthetic */ void getMaskShape$annotations() {
    }

    /* JADX INFO: renamed from: getOverrideSourceLid-sa7TU9Q$annotations, reason: not valid java name */
    public static /* synthetic */ void m155getOverrideSourceLidsa7TU9Q$annotations() {
    }

    public static final /* synthetic */ void write$Self(PartialImageComponent partialImageComponent, d dVar, e eVar) {
        if (dVar.j(eVar, 0) || !r.b(partialImageComponent.visible, Boolean.TRUE)) {
            dVar.E(eVar, 0, C0335h.f929a, partialImageComponent.visible);
        }
        if (dVar.j(eVar, 1) || partialImageComponent.source != null) {
            dVar.E(eVar, 1, ThemeImageUrls$$serializer.INSTANCE, partialImageComponent.source);
        }
        if (dVar.j(eVar, 2) || partialImageComponent.size != null) {
            dVar.E(eVar, 2, Size$$serializer.INSTANCE, partialImageComponent.size);
        }
        if (dVar.j(eVar, 3) || partialImageComponent.overrideSourceLid != null) {
            LocalizationKey$$serializer localizationKey$$serializer = LocalizationKey$$serializer.INSTANCE;
            String str = partialImageComponent.overrideSourceLid;
            dVar.E(eVar, 3, localizationKey$$serializer, str != null ? LocalizationKey.m193boximpl(str) : null);
        }
        if (dVar.j(eVar, 4) || partialImageComponent.fitMode != null) {
            dVar.E(eVar, 4, FitModeDeserializer.INSTANCE, partialImageComponent.fitMode);
        }
        if (dVar.j(eVar, 5) || partialImageComponent.maskShape != null) {
            dVar.E(eVar, 5, MaskShapeDeserializer.INSTANCE, partialImageComponent.maskShape);
        }
        if (dVar.j(eVar, 6) || partialImageComponent.colorOverlay != null) {
            dVar.E(eVar, 6, ColorScheme$$serializer.INSTANCE, partialImageComponent.colorOverlay);
        }
        if (dVar.j(eVar, 7) || partialImageComponent.padding != null) {
            dVar.E(eVar, 7, Padding$$serializer.INSTANCE, partialImageComponent.padding);
        }
        if (dVar.j(eVar, 8) || partialImageComponent.margin != null) {
            dVar.E(eVar, 8, Padding$$serializer.INSTANCE, partialImageComponent.margin);
        }
        if (dVar.j(eVar, 9) || partialImageComponent.border != null) {
            dVar.E(eVar, 9, Border$$serializer.INSTANCE, partialImageComponent.border);
        }
        if (!dVar.j(eVar, 10) && partialImageComponent.shadow == null) {
            return;
        }
        dVar.E(eVar, 10, Shadow$$serializer.INSTANCE, partialImageComponent.shadow);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L4
            return r0
        L4:
            boolean r1 = r5 instanceof com.revenuecat.purchases.paywalls.components.PartialImageComponent
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            com.revenuecat.purchases.paywalls.components.PartialImageComponent r5 = (com.revenuecat.purchases.paywalls.components.PartialImageComponent) r5
            java.lang.Boolean r1 = r4.visible
            java.lang.Boolean r3 = r5.visible
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L17
            return r2
        L17:
            com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls r1 = r4.source
            com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls r3 = r5.source
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L22
            return r2
        L22:
            com.revenuecat.purchases.paywalls.components.properties.Size r1 = r4.size
            com.revenuecat.purchases.paywalls.components.properties.Size r3 = r5.size
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L2d
            return r2
        L2d:
            java.lang.String r1 = r4.overrideSourceLid
            java.lang.String r3 = r5.overrideSourceLid
            if (r1 != 0) goto L39
            if (r3 != 0) goto L37
            r1 = r0
            goto L40
        L37:
            r1 = r2
            goto L40
        L39:
            if (r3 != 0) goto L3c
            goto L37
        L3c:
            boolean r1 = com.revenuecat.purchases.paywalls.components.common.LocalizationKey.m196equalsimpl0(r1, r3)
        L40:
            if (r1 != 0) goto L43
            return r2
        L43:
            com.revenuecat.purchases.paywalls.components.properties.FitMode r1 = r4.fitMode
            com.revenuecat.purchases.paywalls.components.properties.FitMode r3 = r5.fitMode
            if (r1 == r3) goto L4a
            return r2
        L4a:
            com.revenuecat.purchases.paywalls.components.properties.MaskShape r1 = r4.maskShape
            com.revenuecat.purchases.paywalls.components.properties.MaskShape r3 = r5.maskShape
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L55
            return r2
        L55:
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r1 = r4.colorOverlay
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r3 = r5.colorOverlay
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L60
            return r2
        L60:
            com.revenuecat.purchases.paywalls.components.properties.Padding r1 = r4.padding
            com.revenuecat.purchases.paywalls.components.properties.Padding r3 = r5.padding
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L6b
            return r2
        L6b:
            com.revenuecat.purchases.paywalls.components.properties.Padding r1 = r4.margin
            com.revenuecat.purchases.paywalls.components.properties.Padding r3 = r5.margin
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L76
            return r2
        L76:
            com.revenuecat.purchases.paywalls.components.properties.Border r1 = r4.border
            com.revenuecat.purchases.paywalls.components.properties.Border r3 = r5.border
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L81
            return r2
        L81:
            com.revenuecat.purchases.paywalls.components.properties.Shadow r1 = r4.shadow
            com.revenuecat.purchases.paywalls.components.properties.Shadow r5 = r5.shadow
            boolean r5 = kotlin.jvm.internal.r.b(r1, r5)
            if (r5 != 0) goto L8c
            return r2
        L8c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.components.PartialImageComponent.equals(java.lang.Object):boolean");
    }

    public final /* synthetic */ Border getBorder() {
        return this.border;
    }

    public final /* synthetic */ ColorScheme getColorOverlay() {
        return this.colorOverlay;
    }

    public final /* synthetic */ FitMode getFitMode() {
        return this.fitMode;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ MaskShape getMaskShape() {
        return this.maskShape;
    }

    /* JADX INFO: renamed from: getOverrideSourceLid-sa7TU9Q, reason: not valid java name */
    public final /* synthetic */ String m156getOverrideSourceLidsa7TU9Q() {
        return this.overrideSourceLid;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Shadow getShadow() {
        return this.shadow;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ ThemeImageUrls getSource() {
        return this.source;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        ThemeImageUrls themeImageUrls = this.source;
        int iHashCode2 = (iHashCode + (themeImageUrls == null ? 0 : themeImageUrls.hashCode())) * 31;
        Size size = this.size;
        int iHashCode3 = (iHashCode2 + (size == null ? 0 : size.hashCode())) * 31;
        String str = this.overrideSourceLid;
        int iM197hashCodeimpl = (iHashCode3 + (str == null ? 0 : LocalizationKey.m197hashCodeimpl(str))) * 31;
        FitMode fitMode = this.fitMode;
        int iHashCode4 = (iM197hashCodeimpl + (fitMode == null ? 0 : fitMode.hashCode())) * 31;
        MaskShape maskShape = this.maskShape;
        int iHashCode5 = (iHashCode4 + (maskShape == null ? 0 : maskShape.hashCode())) * 31;
        ColorScheme colorScheme = this.colorOverlay;
        int iHashCode6 = (iHashCode5 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode7 = (iHashCode6 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        int iHashCode8 = (iHashCode7 + (padding2 == null ? 0 : padding2.hashCode())) * 31;
        Border border = this.border;
        int iHashCode9 = (iHashCode8 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        return iHashCode9 + (shadow != null ? shadow.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PartialImageComponent(visible=");
        sb.append(this.visible);
        sb.append(", source=");
        sb.append(this.source);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", overrideSourceLid=");
        String str = this.overrideSourceLid;
        sb.append((Object) (str == null ? "null" : LocalizationKey.m198toStringimpl(str)));
        sb.append(", fitMode=");
        sb.append(this.fitMode);
        sb.append(", maskShape=");
        sb.append(this.maskShape);
        sb.append(", colorOverlay=");
        sb.append(this.colorOverlay);
        sb.append(", padding=");
        sb.append(this.padding);
        sb.append(", margin=");
        sb.append(this.margin);
        sb.append(", border=");
        sb.append(this.border);
        sb.append(", shadow=");
        sb.append(this.shadow);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ PartialImageComponent(Boolean bool, ThemeImageUrls themeImageUrls, Size size, String str, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, AbstractC1585j abstractC1585j) {
        this(bool, themeImageUrls, size, str, fitMode, maskShape, colorScheme, padding, padding2, border, shadow);
    }

    private PartialImageComponent(int i4, Boolean bool, ThemeImageUrls themeImageUrls, Size size, String str, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, k0 k0Var) {
        this.visible = (i4 & 1) == 0 ? Boolean.TRUE : bool;
        if ((i4 & 2) == 0) {
            this.source = null;
        } else {
            this.source = themeImageUrls;
        }
        if ((i4 & 4) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((i4 & 8) == 0) {
            this.overrideSourceLid = null;
        } else {
            this.overrideSourceLid = str;
        }
        if ((i4 & 16) == 0) {
            this.fitMode = null;
        } else {
            this.fitMode = fitMode;
        }
        if ((i4 & 32) == 0) {
            this.maskShape = null;
        } else {
            this.maskShape = maskShape;
        }
        if ((i4 & 64) == 0) {
            this.colorOverlay = null;
        } else {
            this.colorOverlay = colorScheme;
        }
        if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) == 0) {
            this.padding = null;
        } else {
            this.padding = padding;
        }
        if ((i4 & 256) == 0) {
            this.margin = null;
        } else {
            this.margin = padding2;
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
    }

    private PartialImageComponent(Boolean bool, ThemeImageUrls themeImageUrls, Size size, String str, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow) {
        this.visible = bool;
        this.source = themeImageUrls;
        this.size = size;
        this.overrideSourceLid = str;
        this.fitMode = fitMode;
        this.maskShape = maskShape;
        this.colorOverlay = colorScheme;
        this.padding = padding;
        this.margin = padding2;
        this.border = border;
        this.shadow = shadow;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PartialImageComponent(Boolean bool, ThemeImageUrls themeImageUrls, Size size, String str, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, int i4, AbstractC1585j abstractC1585j) {
        Boolean bool2 = (i4 & 1) != 0 ? Boolean.TRUE : bool;
        ThemeImageUrls themeImageUrls2 = (i4 & 2) != 0 ? null : themeImageUrls;
        Size size2 = (i4 & 4) != 0 ? null : size;
        String str2 = (i4 & 8) != 0 ? null : str;
        FitMode fitMode2 = (i4 & 16) != 0 ? null : fitMode;
        MaskShape maskShape2 = (i4 & 32) != 0 ? null : maskShape;
        ColorScheme colorScheme2 = (i4 & 64) != 0 ? null : colorScheme;
        Padding padding3 = (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? null : padding;
        Padding padding4 = (i4 & 256) != 0 ? null : padding2;
        Border border2 = (i4 & 512) != 0 ? null : border;
        this(bool2, themeImageUrls2, size2, str2, fitMode2, maskShape2, colorScheme2, padding3, padding4, border2, (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0 ? shadow : null, null);
    }
}
