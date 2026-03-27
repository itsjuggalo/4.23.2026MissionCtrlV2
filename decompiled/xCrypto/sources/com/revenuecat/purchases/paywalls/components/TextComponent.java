package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.C0332e;
import J3.C0335h;
import J3.H;
import J3.k0;
import X2.AbstractC0769p;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.FontAlias;
import com.revenuecat.purchases.FontAlias$$serializer;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
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
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class TextComponent implements PaywallComponent {
    private final ColorScheme backgroundColor;
    private final ColorScheme color;
    private final String fontName;
    private final int fontSize;
    private final FontWeight fontWeight;
    private final Integer fontWeightInt;
    private final HorizontalAlignment horizontalAlignment;
    private final Padding margin;
    private final List<ComponentOverride<PartialTextComponent>> overrides;
    private final Padding padding;
    private final Size size;
    private final String text;
    private final Boolean visible;
    public static final Companion Companion = new Companion(null);
    private static final b[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, new C0332e(ComponentOverride.Companion.serializer(PartialTextComponent$$serializer.INSTANCE))};

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return TextComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TextComponent(int i4, String str, ColorScheme colorScheme, Boolean bool, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, int i5, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, List list, k0 k0Var, AbstractC1585j abstractC1585j) {
        this(i4, str, colorScheme, bool, colorScheme2, str2, fontWeight, num, i5, horizontalAlignment, size, padding, padding2, (List<ComponentOverride<PartialTextComponent>>) list, k0Var);
    }

    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    /* JADX INFO: renamed from: getFontName-ARcRonI$annotations, reason: not valid java name */
    public static /* synthetic */ void m161getFontNameARcRonI$annotations() {
    }

    public static /* synthetic */ void getFontSize$annotations() {
    }

    public static /* synthetic */ void getFontWeight$annotations() {
    }

    public static /* synthetic */ void getFontWeightInt$annotations() {
    }

    public static /* synthetic */ void getHorizontalAlignment$annotations() {
    }

    /* JADX INFO: renamed from: getText-z7Tp-4o$annotations, reason: not valid java name */
    public static /* synthetic */ void m162getTextz7Tp4o$annotations() {
    }

    public static final /* synthetic */ void write$Self(TextComponent textComponent, d dVar, e eVar) {
        b[] bVarArr = $childSerializers;
        dVar.u(eVar, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m193boximpl(textComponent.text));
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        dVar.u(eVar, 1, colorScheme$$serializer, textComponent.color);
        if (dVar.j(eVar, 2) || textComponent.visible != null) {
            dVar.E(eVar, 2, C0335h.f929a, textComponent.visible);
        }
        if (dVar.j(eVar, 3) || textComponent.backgroundColor != null) {
            dVar.E(eVar, 3, colorScheme$$serializer, textComponent.backgroundColor);
        }
        if (dVar.j(eVar, 4) || textComponent.fontName != null) {
            FontAlias$$serializer fontAlias$$serializer = FontAlias$$serializer.INSTANCE;
            String str = textComponent.fontName;
            dVar.E(eVar, 4, fontAlias$$serializer, str != null ? FontAlias.m60boximpl(str) : null);
        }
        if (dVar.j(eVar, 5) || textComponent.fontWeight != FontWeight.REGULAR) {
            dVar.u(eVar, 5, FontWeightDeserializer.INSTANCE, textComponent.fontWeight);
        }
        if (dVar.j(eVar, 6) || textComponent.fontWeightInt != null) {
            dVar.E(eVar, 6, H.f874a, textComponent.fontWeightInt);
        }
        if (dVar.j(eVar, 7) || textComponent.fontSize != 15) {
            dVar.u(eVar, 7, FontSizeSerializer.INSTANCE, Integer.valueOf(textComponent.fontSize));
        }
        if (dVar.j(eVar, 8) || textComponent.horizontalAlignment != HorizontalAlignment.CENTER) {
            dVar.u(eVar, 8, HorizontalAlignmentDeserializer.INSTANCE, textComponent.horizontalAlignment);
        }
        if (dVar.j(eVar, 9) || !r.b(textComponent.size, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE))) {
            dVar.u(eVar, 9, Size$$serializer.INSTANCE, textComponent.size);
        }
        if (dVar.j(eVar, 10) || !r.b(textComponent.padding, Padding.Companion.getZero())) {
            dVar.u(eVar, 10, Padding$$serializer.INSTANCE, textComponent.padding);
        }
        if (dVar.j(eVar, 11) || !r.b(textComponent.margin, Padding.Companion.getZero())) {
            dVar.u(eVar, 11, Padding$$serializer.INSTANCE, textComponent.margin);
        }
        if (!dVar.j(eVar, 12) && r.b(textComponent.overrides, AbstractC0769p.g())) {
            return;
        }
        dVar.u(eVar, 12, bVarArr[12], textComponent.overrides);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
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
            boolean r1 = r5 instanceof com.revenuecat.purchases.paywalls.components.TextComponent
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            com.revenuecat.purchases.paywalls.components.TextComponent r5 = (com.revenuecat.purchases.paywalls.components.TextComponent) r5
            java.lang.String r1 = r4.text
            java.lang.String r3 = r5.text
            boolean r1 = com.revenuecat.purchases.paywalls.components.common.LocalizationKey.m196equalsimpl0(r1, r3)
            if (r1 != 0) goto L17
            return r2
        L17:
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r1 = r4.color
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r3 = r5.color
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L22
            return r2
        L22:
            java.lang.Boolean r1 = r4.visible
            java.lang.Boolean r3 = r5.visible
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L2d
            return r2
        L2d:
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r1 = r4.backgroundColor
            com.revenuecat.purchases.paywalls.components.properties.ColorScheme r3 = r5.backgroundColor
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L38
            return r2
        L38:
            java.lang.String r1 = r4.fontName
            java.lang.String r3 = r5.fontName
            if (r1 != 0) goto L44
            if (r3 != 0) goto L42
            r1 = r0
            goto L4b
        L42:
            r1 = r2
            goto L4b
        L44:
            if (r3 != 0) goto L47
            goto L42
        L47:
            boolean r1 = com.revenuecat.purchases.FontAlias.m63equalsimpl0(r1, r3)
        L4b:
            if (r1 != 0) goto L4e
            return r2
        L4e:
            com.revenuecat.purchases.paywalls.components.properties.FontWeight r1 = r4.fontWeight
            com.revenuecat.purchases.paywalls.components.properties.FontWeight r3 = r5.fontWeight
            if (r1 == r3) goto L55
            return r2
        L55:
            java.lang.Integer r1 = r4.fontWeightInt
            java.lang.Integer r3 = r5.fontWeightInt
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L60
            return r2
        L60:
            int r1 = r4.fontSize
            int r3 = r5.fontSize
            if (r1 == r3) goto L67
            return r2
        L67:
            com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment r1 = r4.horizontalAlignment
            com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment r3 = r5.horizontalAlignment
            if (r1 == r3) goto L6e
            return r2
        L6e:
            com.revenuecat.purchases.paywalls.components.properties.Size r1 = r4.size
            com.revenuecat.purchases.paywalls.components.properties.Size r3 = r5.size
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L79
            return r2
        L79:
            com.revenuecat.purchases.paywalls.components.properties.Padding r1 = r4.padding
            com.revenuecat.purchases.paywalls.components.properties.Padding r3 = r5.padding
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L84
            return r2
        L84:
            com.revenuecat.purchases.paywalls.components.properties.Padding r1 = r4.margin
            com.revenuecat.purchases.paywalls.components.properties.Padding r3 = r5.margin
            boolean r1 = kotlin.jvm.internal.r.b(r1, r3)
            if (r1 != 0) goto L8f
            return r2
        L8f:
            java.util.List<com.revenuecat.purchases.paywalls.components.common.ComponentOverride<com.revenuecat.purchases.paywalls.components.PartialTextComponent>> r1 = r4.overrides
            java.util.List<com.revenuecat.purchases.paywalls.components.common.ComponentOverride<com.revenuecat.purchases.paywalls.components.PartialTextComponent>> r5 = r5.overrides
            boolean r5 = kotlin.jvm.internal.r.b(r1, r5)
            if (r5 != 0) goto L9a
            return r2
        L9a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.components.TextComponent.equals(java.lang.Object):boolean");
    }

    public final /* synthetic */ ColorScheme getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ ColorScheme getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: getFontName-ARcRonI, reason: not valid java name */
    public final /* synthetic */ String m163getFontNameARcRonI() {
        return this.fontName;
    }

    public final /* synthetic */ int getFontSize() {
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

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: getText-z7Tp-4o, reason: not valid java name */
    public final /* synthetic */ String m164getTextz7Tp4o() {
        return this.text;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iM197hashCodeimpl = ((LocalizationKey.m197hashCodeimpl(this.text) * 31) + this.color.hashCode()) * 31;
        Boolean bool = this.visible;
        int iHashCode = (iM197hashCodeimpl + (bool == null ? 0 : bool.hashCode())) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode2 = (iHashCode + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        String str = this.fontName;
        int iM64hashCodeimpl = (((iHashCode2 + (str == null ? 0 : FontAlias.m64hashCodeimpl(str))) * 31) + this.fontWeight.hashCode()) * 31;
        Integer num = this.fontWeightInt;
        return ((((((((((((iM64hashCodeimpl + (num != null ? num.hashCode() : 0)) * 31) + Integer.hashCode(this.fontSize)) * 31) + this.horizontalAlignment.hashCode()) * 31) + this.size.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31) + this.overrides.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TextComponent(text=");
        sb.append((Object) LocalizationKey.m198toStringimpl(this.text));
        sb.append(", color=");
        sb.append(this.color);
        sb.append(", visible=");
        sb.append(this.visible);
        sb.append(", backgroundColor=");
        sb.append(this.backgroundColor);
        sb.append(", fontName=");
        String str = this.fontName;
        sb.append((Object) (str == null ? "null" : FontAlias.m65toStringimpl(str)));
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
        sb.append(", overrides=");
        sb.append(this.overrides);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ TextComponent(String str, ColorScheme colorScheme, Boolean bool, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, int i4, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, List list, AbstractC1585j abstractC1585j) {
        this(str, colorScheme, bool, colorScheme2, str2, fontWeight, num, i4, horizontalAlignment, size, padding, padding2, list);
    }

    private TextComponent(int i4, String str, ColorScheme colorScheme, Boolean bool, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, int i5, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, List<ComponentOverride<PartialTextComponent>> list, k0 k0Var) {
        if (3 != (i4 & 3)) {
            AbstractC0325a0.a(i4, 3, TextComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.text = str;
        this.color = colorScheme;
        if ((i4 & 4) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
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
            this.fontWeight = FontWeight.REGULAR;
        } else {
            this.fontWeight = fontWeight;
        }
        if ((i4 & 64) == 0) {
            this.fontWeightInt = null;
        } else {
            this.fontWeightInt = num;
        }
        if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) == 0) {
            this.fontSize = 15;
        } else {
            this.fontSize = i5;
        }
        if ((i4 & 256) == 0) {
            this.horizontalAlignment = HorizontalAlignment.CENTER;
        } else {
            this.horizontalAlignment = horizontalAlignment;
        }
        if ((i4 & 512) == 0) {
            this.size = new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE);
        } else {
            this.size = size;
        }
        if ((i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0) {
            this.padding = Padding.Companion.getZero();
        } else {
            this.padding = padding;
        }
        if ((i4 & 2048) == 0) {
            this.margin = Padding.Companion.getZero();
        } else {
            this.margin = padding2;
        }
        this.overrides = (i4 & 4096) == 0 ? AbstractC0769p.g() : list;
    }

    private TextComponent(String text, ColorScheme color, Boolean bool, ColorScheme colorScheme, String str, FontWeight fontWeight, Integer num, int i4, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding margin, List<ComponentOverride<PartialTextComponent>> overrides) {
        r.f(text, "text");
        r.f(color, "color");
        r.f(fontWeight, "fontWeight");
        r.f(horizontalAlignment, "horizontalAlignment");
        r.f(size, "size");
        r.f(padding, "padding");
        r.f(margin, "margin");
        r.f(overrides, "overrides");
        this.text = text;
        this.color = color;
        this.visible = bool;
        this.backgroundColor = colorScheme;
        this.fontName = str;
        this.fontWeight = fontWeight;
        this.fontWeightInt = num;
        this.fontSize = i4;
        this.horizontalAlignment = horizontalAlignment;
        this.size = size;
        this.padding = padding;
        this.margin = margin;
        this.overrides = overrides;
    }

    public /* synthetic */ TextComponent(String str, ColorScheme colorScheme, Boolean bool, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, int i4, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, List list, int i5, AbstractC1585j abstractC1585j) {
        this(str, colorScheme, (i5 & 4) != 0 ? null : bool, (i5 & 8) != 0 ? null : colorScheme2, (i5 & 16) != 0 ? null : str2, (i5 & 32) != 0 ? FontWeight.REGULAR : fontWeight, (i5 & 64) != 0 ? null : num, (i5 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? 15 : i4, (i5 & 256) != 0 ? HorizontalAlignment.CENTER : horizontalAlignment, (i5 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i5 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? Padding.Companion.getZero() : padding, (i5 & 2048) != 0 ? Padding.Companion.getZero() : padding2, (i5 & 4096) != 0 ? AbstractC0769p.g() : list, null);
    }
}
