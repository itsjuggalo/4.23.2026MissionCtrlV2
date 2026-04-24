package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FitModeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls$$serializer;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public interface Background {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Color implements Background {
        public static final Companion Companion = new Companion(null);
        private final ColorScheme value;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return Background$Color$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Color(int i4, ColorScheme colorScheme, k0 k0Var) {
            if (1 != (i4 & 1)) {
                AbstractC0325a0.a(i4, 1, Background$Color$$serializer.INSTANCE.getDescriptor());
            }
            this.value = colorScheme;
        }

        public static /* synthetic */ Color copy$default(Color color, ColorScheme colorScheme, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                colorScheme = color.value;
            }
            return color.copy(colorScheme);
        }

        public final ColorScheme component1() {
            return this.value;
        }

        public final Color copy(ColorScheme value) {
            r.f(value, "value");
            return new Color(value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Color) && r.b(this.value, ((Color) obj).value);
        }

        public final /* synthetic */ ColorScheme getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Color(value=" + this.value + ')';
        }

        public Color(ColorScheme value) {
            r.f(value, "value");
            this.value = value;
        }
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final b serializer() {
            return BackgroundDeserializer.INSTANCE;
        }
    }

    public static final class Unknown implements Background {
        public static final Companion Companion = new Companion(null);
        private final String type;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return Background$Unknown$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Unknown(int i4, String str, k0 k0Var) {
            if (1 != (i4 & 1)) {
                AbstractC0325a0.a(i4, 1, Background$Unknown$$serializer.INSTANCE.getDescriptor());
            }
            this.type = str;
        }

        public static /* synthetic */ Unknown copy$default(Unknown unknown, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = unknown.type;
            }
            return unknown.copy(str);
        }

        public final String component1() {
            return this.type;
        }

        public final Unknown copy(String type) {
            r.f(type, "type");
            return new Unknown(type);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Unknown) && r.b(this.type, ((Unknown) obj).type);
        }

        public final /* synthetic */ String getType() {
            return this.type;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "Unknown(type=" + this.type + ')';
        }

        public Unknown(String type) {
            r.f(type, "type");
            this.type = type;
        }
    }

    public static final class Image implements Background {
        public static final Companion Companion = new Companion(null);
        private final ColorScheme colorOverlay;
        private final FitMode fitMode;
        private final ThemeImageUrls value;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return Background$Image$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Image(int i4, ThemeImageUrls themeImageUrls, FitMode fitMode, ColorScheme colorScheme, k0 k0Var) {
            if (1 != (i4 & 1)) {
                AbstractC0325a0.a(i4, 1, Background$Image$$serializer.INSTANCE.getDescriptor());
            }
            this.value = themeImageUrls;
            if ((i4 & 2) == 0) {
                this.fitMode = FitMode.FILL;
            } else {
                this.fitMode = fitMode;
            }
            if ((i4 & 4) == 0) {
                this.colorOverlay = null;
            } else {
                this.colorOverlay = colorScheme;
            }
        }

        public static /* synthetic */ Image copy$default(Image image, ThemeImageUrls themeImageUrls, FitMode fitMode, ColorScheme colorScheme, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                themeImageUrls = image.value;
            }
            if ((i4 & 2) != 0) {
                fitMode = image.fitMode;
            }
            if ((i4 & 4) != 0) {
                colorScheme = image.colorOverlay;
            }
            return image.copy(themeImageUrls, fitMode, colorScheme);
        }

        public static /* synthetic */ void getColorOverlay$annotations() {
        }

        public static /* synthetic */ void getFitMode$annotations() {
        }

        public static final /* synthetic */ void write$Self(Image image, d dVar, e eVar) {
            dVar.u(eVar, 0, ThemeImageUrls$$serializer.INSTANCE, image.value);
            if (dVar.j(eVar, 1) || image.fitMode != FitMode.FILL) {
                dVar.u(eVar, 1, FitModeDeserializer.INSTANCE, image.fitMode);
            }
            if (!dVar.j(eVar, 2) && image.colorOverlay == null) {
                return;
            }
            dVar.E(eVar, 2, ColorScheme$$serializer.INSTANCE, image.colorOverlay);
        }

        public final ThemeImageUrls component1() {
            return this.value;
        }

        public final FitMode component2() {
            return this.fitMode;
        }

        public final ColorScheme component3() {
            return this.colorOverlay;
        }

        public final Image copy(ThemeImageUrls value, FitMode fitMode, ColorScheme colorScheme) {
            r.f(value, "value");
            r.f(fitMode, "fitMode");
            return new Image(value, fitMode, colorScheme);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Image)) {
                return false;
            }
            Image image = (Image) obj;
            return r.b(this.value, image.value) && this.fitMode == image.fitMode && r.b(this.colorOverlay, image.colorOverlay);
        }

        public final /* synthetic */ ColorScheme getColorOverlay() {
            return this.colorOverlay;
        }

        public final /* synthetic */ FitMode getFitMode() {
            return this.fitMode;
        }

        public final /* synthetic */ ThemeImageUrls getValue() {
            return this.value;
        }

        public int hashCode() {
            int iHashCode = ((this.value.hashCode() * 31) + this.fitMode.hashCode()) * 31;
            ColorScheme colorScheme = this.colorOverlay;
            return iHashCode + (colorScheme == null ? 0 : colorScheme.hashCode());
        }

        public String toString() {
            return "Image(value=" + this.value + ", fitMode=" + this.fitMode + ", colorOverlay=" + this.colorOverlay + ')';
        }

        public Image(ThemeImageUrls value, FitMode fitMode, ColorScheme colorScheme) {
            r.f(value, "value");
            r.f(fitMode, "fitMode");
            this.value = value;
            this.fitMode = fitMode;
            this.colorOverlay = colorScheme;
        }

        public /* synthetic */ Image(ThemeImageUrls themeImageUrls, FitMode fitMode, ColorScheme colorScheme, int i4, AbstractC1585j abstractC1585j) {
            this(themeImageUrls, (i4 & 2) != 0 ? FitMode.FILL : fitMode, (i4 & 4) != 0 ? null : colorScheme);
        }
    }
}
