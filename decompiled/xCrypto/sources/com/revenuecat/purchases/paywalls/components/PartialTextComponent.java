package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import I3.d;
import J3.C0335h;
import J3.H;
import J3.k0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.FontAlias;
import com.revenuecat.purchases.FontAlias$$serializer;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.FontWeightDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignmentDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class PartialTextComponent implements PartialComponent {
    public static final Companion Companion = new Companion(null);
    private final ColorScheme backgroundColor;
    private final ColorScheme color;
    private final String fontName;
    private final Integer fontSize;
    private final FontWeight fontWeight;
    private final Integer fontWeightInt;
    private final HorizontalAlignment horizontalAlignment;
    private final Padding margin;
    private final Padding padding;
    private final Size size;
    private final String text;
    private final Boolean visible;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return PartialTextComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PartialTextComponent(int i4, Boolean bool, String str, ColorScheme colorScheme, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, Integer num2, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, k0 k0Var, AbstractC1585j abstractC1585j) {
        this(i4, bool, str, colorScheme, colorScheme2, str2, fontWeight, num, num2, horizontalAlignment, size, padding, padding2, k0Var);
    }

    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    /* JADX INFO: renamed from: getFontName-ARcRonI$annotations, reason: not valid java name */
    public static /* synthetic */ void m157getFontNameARcRonI$annotations() {
    }

    public static /* synthetic */ void getFontSize$annotations() {
    }

    public static /* synthetic */ void getFontWeight$annotations() {
    }

    public static /* synthetic */ void getFontWeightInt$annotations() {
    }

    public static /* synthetic */ void getHorizontalAlignment$annotations() {
    }

    /* JADX INFO: renamed from: getText-sa7TU9Q$annotations, reason: not valid java name */
    public static /* synthetic */ void m158getTextsa7TU9Q$annotations() {
    }

    public static final /* synthetic */ void write$Self(PartialTextComponent partialTextComponent, d dVar, e eVar) {
        if (dVar.j(eVar, 0) || !r.b(partialTextComponent.visible, Boolean.TRUE)) {
            dVar.E(eVar, 0, C0335h.f929a, partialTextComponent.visible);
        }
        if (dVar.j(eVar, 1) || partialTextComponent.text != null) {
            LocalizationKey$$serializer localizationKey$$serializer = LocalizationKey$$serializer.INSTANCE;
            String str = partialTextComponent.text;
            dVar.E(eVar, 1, localizationKey$$serializer, str != null ? LocalizationKey.m193boximpl(str) : null);
        }
        if (dVar.j(eVar, 2) || partialTextComponent.color != null) {
            dVar.E(eVar, 2, ColorScheme$$serializer.INSTANCE, partialTextComponent.color);
        }
        if (dVar.j(eVar, 3) || partialTextComponent.backgroundColor != null) {
            dVar.E(eVar, 3, ColorScheme$$serializer.INSTANCE, partialTextComponent.backgroundColor);
        }
        if (dVar.j(eVar, 4) || partialTextComponent.fontName != null) {
            FontAlias$$serializer fontAlias$$serializer = FontAlias$$serializer.INSTANCE;
            String str2 = partialTextComponent.fontName;
            dVar.E(eVar, 4, fontAlias$$serializer, str2 != null ? FontAlias.m60boximpl(str2) : null);
        }
        if (dVar.j(eVar, 5) || partialTextComponent.fontWeight != null) {
            dVar.E(eVar, 5, FontWeightDeserializer.INSTANCE, partialTextComponent.fontWeight);
        }
        if (dVar.j(eVar, 6) || partialTextComponent.fontWeightInt != null) {
            dVar.E(eVar, 6, H.f874a, partialTextComponent.fontWeightInt);
        }
        if (dVar.j(eVar, 7) || partialTextComponent.fontSize != null) {
            dVar.E(eVar, 7, FontSizeSerializer.INSTANCE, partialTextComponent.fontSize);
        }
        if (dVar.j(eVar, 8) || partialTextComponent.horizontalAlignment != null) {
            dVar.E(eVar, 8, HorizontalAlignmentDeserializer.INSTANCE, partialTextComponent.horizontalAlignment);
        }
        if (dVar.j(eVar, 9) || partialTextComponent.size != null) {
            dVar.E(eVar, 9, Size$$serializer.INSTANCE, partialTextComponent.size);
        }
        if (dVar.j(eVar, 10) || partialTextComponent.padding != null) {
            dVar.E(eVar, 10, Padding$$serializer.INSTANCE, partialTextComponent.padding);
        }
        if (!dVar.j(eVar, 11) && partialTextComponent.margin == null) {
            return;
        }
        dVar.E(eVar, 11, Padding$$serializer.INSTANCE, partialTextComponent.margin);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004d  */
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
            boolean r1 = r5 instanceof com.revenuecat.purchases.paywalls.components.PartialTextComponent
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            com.revenuecat.purchases.paywalls.components.PartialTextComponent r5 = (com.revenuecat.purchases.paywalls.components.PartialTextComponent) r5
            java.lang.Boolean r1 = r4.visible
            java.lang.Boolean r3 = r5.visible
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L17
            return r2
        L17:
            java.lang.String r1 = r4.text
            java.lang.String r3 = r5.text
            if (r1 != 0) goto L23
            if (r3 != 0) goto L21
            r1 = r0
            goto L2a
        L21:
            r1 = r2
            goto L2a
        L23:
            if (r3 != 0) goto L26
            goto L21
        L26:
            boolean r1 = com.revenuecat.purchases.paywalls.components.common.LocalizationKey.m196equalsimpl0(r1, r3)
        L2a:
            if (r1 != 0) goto L2d
            return r2
        L2d:
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r1 = r4.color
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r3 = r5.color
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L38
            return r2
        L38:
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r1 = r4.backgroundColor
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r3 = r5.backgroundColor
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L43
            return r2
        L43:
            java.lang.String r1 = r4.fontName
            java.lang.String r3 = r5.fontName
            if (r1 != 0) goto L4f
            if (r3 != 0) goto L4d
            r1 = r0
            goto L56
        L4d:
            r1 = r2
            goto L56
        L4f:
            if (r3 != 0) goto L52
            goto L4d
        L52:
            boolean r1 = com.revenuecat.purchases.FontAlias.m63equalsimpl0(r1, r3)
        L56:
            if (r1 != 0) goto L59
            return r2
        L59:
            com.revenuecat.purchases.paywalls.components.properties.FontWeight r1 = r4.fontWeight
            com.revenuecat.purchases.paywalls.components.properties.FontWeight r3 = r5.fontWeight
            if (r1 == r3) goto L60
            return r2
        L60:
            java.lang.Integer r1 = r4.fontWeightInt
            java.lang.Integer r3 = r5.fontWeightInt
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L6b
            return r2
        L6b:
            java.lang.Integer r1 = r4.fontSize
            java.lang.Integer r3 = r5.fontSize
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L76
            return r2
        L76:
            com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment r1 = r4.horizontalAlignment
            com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment r3 = r5.horizontalAlignment
            if (r1 == r3) goto L7d
            return r2
        L7d:
            com.revenuecat.purchases.paywalls.components.properties.Size r1 = r4.size
            com.revenuecat.purchases.paywalls.components.properties.Size r3 = r5.size
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L88
            return r2
        L88:
            com.revenuecat.purchases.paywalls.components.properties.Padding r1 = r4.padding
            com.revenuecat.purchases.paywalls.components.properties.Padding r3 = r5.padding
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L93
            return r2
        L93:
            com.revenuecat.purchases.paywalls.components.properties.Padding r1 = r4.margin
            com.revenuecat.purchases.paywalls.components.properties.Padding r5 = r5.margin
            boolean r5 = kotlin.jvm.internal.r.b(r1, r5)
            if (r5 != 0) goto L9e
            return r2
        L9e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.components.PartialTextComponent.equals(java.lang.Object):boolean");
    }

    public final /* synthetic */ ColorScheme getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ ColorScheme getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: getFontName-ARcRonI, reason: not valid java name */
    public final /* synthetic */ String m159getFontNameARcRonI() {
        return this.fontName;
    }

    public final /* synthetic */ Integer getFontSize() {
        return this.fontSize;
    }

    public final /* synthetic */ FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final /* synthetic */ Integer getFontWeightInt() {
        return this.fontWeightInt;
    }

    public final /* synthetic */ HorizontalAlignment getHorizontalAlignment() {
        return this.horizontalAlignment;
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

    /* JADX INFO: renamed from: getText-sa7TU9Q, reason: not valid java name */
    public final /* synthetic */ String m160getTextsa7TU9Q() {
        return this.text;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.text;
        int iM197hashCodeimpl = (iHashCode + (str == null ? 0 : LocalizationKey.m197hashCodeimpl(str))) * 31;
        ColorScheme colorScheme = this.color;
        int iHashCode2 = (iM197hashCodeimpl + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        ColorScheme colorScheme2 = this.backgroundColor;
        int iHashCode3 = (iHashCode2 + (colorScheme2 == null ? 0 : colorScheme2.hashCode())) * 31;
        String str2 = this.fontName;
        int iM64hashCodeimpl = (iHashCode3 + (str2 == null ? 0 : FontAlias.m64hashCodeimpl(str2))) * 31;
        FontWeight fontWeight = this.fontWeight;
        int iHashCode4 = (iM64hashCodeimpl + (fontWeight == null ? 0 : fontWeight.hashCode())) * 31;
        Integer num = this.fontWeightInt;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.fontSize;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        HorizontalAlignment horizontalAlignment = this.horizontalAlignment;
        int iHashCode7 = (iHashCode6 + (horizontalAlignment == null ? 0 : horizontalAlignment.hashCode())) * 31;
        Size size = this.size;
        int iHashCode8 = (iHashCode7 + (size == null ? 0 : size.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode9 = (iHashCode8 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        return iHashCode9 + (padding2 != null ? padding2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PartialTextComponent(visible=");
        sb.append(this.visible);
        sb.append(", text=");
        String str = this.text;
        sb.append((Object) (str == null ? "null" : LocalizationKey.m198toStringimpl(str)));
        sb.append(", color=");
        sb.append(this.color);
        sb.append(", backgroundColor=");
        sb.append(this.backgroundColor);
        sb.append(", fontName=");
        String str2 = this.fontName;
        sb.append((Object) (str2 != null ? FontAlias.m65toStringimpl(str2) : "null"));
        sb.append(", fontWeight=");
        sb.append(this.fontWeight);
        sb.append(", fontWeightInt=");
        sb.append(this.fontWeightInt);
        sb.append(", fontSize=");
        sb.append(this.fontSize);
        sb.append(", horizontalAlignment=");
        sb.append(this.horizontalAlignment);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", padding=");
        sb.append(this.padding);
        sb.append(", margin=");
        sb.append(this.margin);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ PartialTextComponent(Boolean bool, String str, ColorScheme colorScheme, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, Integer num2, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, AbstractC1585j abstractC1585j) {
        this(bool, str, colorScheme, colorScheme2, str2, fontWeight, num, num2, horizontalAlignment, size, padding, padding2);
    }

    private PartialTextComponent(int i4, Boolean bool, String str, ColorScheme colorScheme, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, Integer num2, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, k0 k0Var) {
        this.visible = (i4 & 1) == 0 ? Boolean.TRUE : bool;
        if ((i4 & 2) == 0) {
            this.text = null;
        } else {
            this.text = str;
        }
        if ((i4 & 4) == 0) {
            this.color = null;
        } else {
            this.color = colorScheme;
        }
        if ((i4 & 8) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = colorScheme2;
        }
        if ((i4 & 16) == 0) {
            this.fontName = null;
        } else {
            this.fontName = str2;
        }
        if ((i4 & 32) == 0) {
            this.fontWeight = null;
        } else {
            this.fontWeight = fontWeight;
        }
        if ((i4 & 64) == 0) {
            this.fontWeightInt = null;
        } else {
            this.fontWeightInt = num;
        }
        if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) == 0) {
            this.fontSize = null;
        } else {
            this.fontSize = num2;
        }
        if ((i4 & 256) == 0) {
            this.horizontalAlignment = null;
        } else {
            this.horizontalAlignment = horizontalAlignment;
        }
        if ((i4 & 512) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0) {
            this.padding = null;
        } else {
            this.padding = padding;
        }
        if ((i4 & 2048) == 0) {
            this.margin = null;
        } else {
            this.margin = padding2;
        }
    }

    private PartialTextComponent(Boolean bool, String str, ColorScheme colorScheme, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, Integer num2, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2) {
        this.visible = bool;
        this.text = str;
        this.color = colorScheme;
        this.backgroundColor = colorScheme2;
        this.fontName = str2;
        this.fontWeight = fontWeight;
        this.fontWeightInt = num;
        this.fontSize = num2;
        this.horizontalAlignment = horizontalAlignment;
        this.size = size;
        this.padding = padding;
        this.margin = padding2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PartialTextComponent(Boolean bool, String str, ColorScheme colorScheme, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, Integer num2, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, int i4, AbstractC1585j abstractC1585j) {
        Boolean bool2 = (i4 & 1) != 0 ? Boolean.TRUE : bool;
        String str3 = (i4 & 2) != 0 ? null : str;
        ColorScheme colorScheme3 = (i4 & 4) != 0 ? null : colorScheme;
        ColorScheme colorScheme4 = (i4 & 8) != 0 ? null : colorScheme2;
        String str4 = (i4 & 16) != 0 ? null : str2;
        FontWeight fontWeight2 = (i4 & 32) != 0 ? null : fontWeight;
        Integer num3 = (i4 & 64) != 0 ? null : num;
        Integer num4 = (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? null : num2;
        HorizontalAlignment horizontalAlignment2 = (i4 & 256) != 0 ? null : horizontalAlignment;
        Size size2 = (i4 & 512) != 0 ? null : size;
        Padding padding3 = (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? null : padding;
        this(bool2, str3, colorScheme3, colorScheme4, str4, fontWeight2, num3, num4, horizontalAlignment2, size2, padding3, (i4 & 2048) == 0 ? padding2 : null, null);
    }
}
