package com.revenuecat.purchases;

import J3.AbstractC0325a0;
import J3.H;
import J3.K;
import J3.k0;
import J3.o0;
import X2.L;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizedVariableLocalizationKeyMapSerializer;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FontStyle;
import com.revenuecat.purchases.paywalls.components.properties.FontStyleDeserializer;
import java.lang.annotation.Annotation;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes.dex */
public final class UiConfig {
    public static final Companion Companion = new Companion(null);
    private final AppConfig app;
    private final Map<LocaleId, Map<VariableLocalizationKey, String>> localizations;
    private final VariableConfig variableConfig;

    public static final class AppConfig {
        private final Map<ColorAlias, ColorScheme> colors;
        private final Map<FontAlias, FontsConfig> fonts;
        public static final Companion Companion = new Companion(null);
        private static final F3.b[] $childSerializers = {new K(ColorAlias$$serializer.INSTANCE, ColorScheme$$serializer.INSTANCE), new K(FontAlias$$serializer.INSTANCE, UiConfig$AppConfig$FontsConfig$$serializer.INSTANCE)};

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final F3.b serializer() {
                return UiConfig$AppConfig$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public static final class FontsConfig {

            /* JADX INFO: renamed from: android, reason: collision with root package name */
            private final FontInfo f11280android;
            public static final Companion Companion = new Companion(null);
            private static final F3.b[] $childSerializers = {new F3.e("com.revenuecat.purchases.UiConfig.AppConfig.FontsConfig.FontInfo", G.b(FontInfo.class), new InterfaceC1716c[]{G.b(FontInfo.GoogleFonts.class), G.b(FontInfo.Name.class)}, new F3.b[]{UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer.INSTANCE, UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer.INSTANCE}, new Annotation[0])};

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                public final F3.b serializer() {
                    return UiConfig$AppConfig$FontsConfig$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public interface FontInfo {
                public static final Companion Companion = Companion.$$INSTANCE;

                public static final class Companion {
                    static final /* synthetic */ Companion $$INSTANCE = new Companion();

                    private Companion() {
                    }

                    public final F3.b serializer() {
                        return new F3.e("com.revenuecat.purchases.UiConfig.AppConfig.FontsConfig.FontInfo", G.b(FontInfo.class), new InterfaceC1716c[]{G.b(GoogleFonts.class), G.b(Name.class)}, new F3.b[]{UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer.INSTANCE, UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer.INSTANCE}, new Annotation[0]);
                    }
                }

                public static final class GoogleFonts implements FontInfo {
                    public static final Companion Companion = new Companion(null);
                    private final String value;

                    public static final class Companion {
                        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                            this();
                        }

                        public final F3.b serializer() {
                            return UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer.INSTANCE;
                        }

                        private Companion() {
                        }
                    }

                    public /* synthetic */ GoogleFonts(int i4, String str, k0 k0Var) {
                        if (1 != (i4 & 1)) {
                            AbstractC0325a0.a(i4, 1, UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer.INSTANCE.getDescriptor());
                        }
                        this.value = str;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof GoogleFonts) && r.b(this.value, ((GoogleFonts) obj).value);
                    }

                    public final /* synthetic */ String getValue() {
                        return this.value;
                    }

                    public int hashCode() {
                        return this.value.hashCode();
                    }

                    public String toString() {
                        return "GoogleFonts(value=" + this.value + ')';
                    }

                    public GoogleFonts(String value) {
                        r.f(value, "value");
                        this.value = value;
                    }
                }

                public static final class Name implements FontInfo {
                    public static final Companion Companion = new Companion(null);
                    private final String family;
                    private final String hash;
                    private final FontStyle style;
                    private final String url;
                    private final String value;
                    private final Integer weight;

                    public static final class Companion {
                        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                            this();
                        }

                        public final F3.b serializer() {
                            return UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer.INSTANCE;
                        }

                        private Companion() {
                        }
                    }

                    public /* synthetic */ Name(int i4, String str, String str2, String str3, String str4, Integer num, FontStyle fontStyle, k0 k0Var) {
                        if (1 != (i4 & 1)) {
                            AbstractC0325a0.a(i4, 1, UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer.INSTANCE.getDescriptor());
                        }
                        this.value = str;
                        if ((i4 & 2) == 0) {
                            this.url = null;
                        } else {
                            this.url = str2;
                        }
                        if ((i4 & 4) == 0) {
                            this.hash = null;
                        } else {
                            this.hash = str3;
                        }
                        if ((i4 & 8) == 0) {
                            this.family = null;
                        } else {
                            this.family = str4;
                        }
                        if ((i4 & 16) == 0) {
                            this.weight = null;
                        } else {
                            this.weight = num;
                        }
                        if ((i4 & 32) == 0) {
                            this.style = null;
                        } else {
                            this.style = fontStyle;
                        }
                    }

                    public static final /* synthetic */ void write$Self(Name name, I3.d dVar, H3.e eVar) {
                        dVar.o(eVar, 0, name.value);
                        if (dVar.j(eVar, 1) || name.url != null) {
                            dVar.E(eVar, 1, o0.f952a, name.url);
                        }
                        if (dVar.j(eVar, 2) || name.hash != null) {
                            dVar.E(eVar, 2, o0.f952a, name.hash);
                        }
                        if (dVar.j(eVar, 3) || name.family != null) {
                            dVar.E(eVar, 3, o0.f952a, name.family);
                        }
                        if (dVar.j(eVar, 4) || name.weight != null) {
                            dVar.E(eVar, 4, H.f874a, name.weight);
                        }
                        if (!dVar.j(eVar, 5) && name.style == null) {
                            return;
                        }
                        dVar.E(eVar, 5, FontStyleDeserializer.INSTANCE, name.style);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof Name)) {
                            return false;
                        }
                        Name name = (Name) obj;
                        return r.b(this.value, name.value) && r.b(this.url, name.url) && r.b(this.hash, name.hash) && r.b(this.family, name.family) && r.b(this.weight, name.weight) && this.style == name.style;
                    }

                    public final /* synthetic */ String getFamily() {
                        return this.family;
                    }

                    public final /* synthetic */ String getHash() {
                        return this.hash;
                    }

                    public final /* synthetic */ FontStyle getStyle() {
                        return this.style;
                    }

                    public final /* synthetic */ String getUrl() {
                        return this.url;
                    }

                    public final /* synthetic */ String getValue() {
                        return this.value;
                    }

                    public final /* synthetic */ Integer getWeight() {
                        return this.weight;
                    }

                    public int hashCode() {
                        int iHashCode = this.value.hashCode() * 31;
                        String str = this.url;
                        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                        String str2 = this.hash;
                        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                        String str3 = this.family;
                        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                        Integer num = this.weight;
                        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
                        FontStyle fontStyle = this.style;
                        return iHashCode5 + (fontStyle != null ? fontStyle.hashCode() : 0);
                    }

                    public String toString() {
                        return "Name(value=" + this.value + ", url=" + this.url + ", hash=" + this.hash + ", family=" + this.family + ", weight=" + this.weight + ", style=" + this.style + ')';
                    }

                    public Name(String value, String str, String str2, String str3, Integer num, FontStyle fontStyle) {
                        r.f(value, "value");
                        this.value = value;
                        this.url = str;
                        this.hash = str2;
                        this.family = str3;
                        this.weight = num;
                        this.style = fontStyle;
                    }

                    public /* synthetic */ Name(String str, String str2, String str3, String str4, Integer num, FontStyle fontStyle, int i4, AbstractC1585j abstractC1585j) {
                        this(str, (i4 & 2) != 0 ? null : str2, (i4 & 4) != 0 ? null : str3, (i4 & 8) != 0 ? null : str4, (i4 & 16) != 0 ? null : num, (i4 & 32) != 0 ? null : fontStyle);
                    }
                }
            }

            public /* synthetic */ FontsConfig(int i4, FontInfo fontInfo, k0 k0Var) {
                if (1 != (i4 & 1)) {
                    AbstractC0325a0.a(i4, 1, UiConfig$AppConfig$FontsConfig$$serializer.INSTANCE.getDescriptor());
                }
                this.f11280android = fontInfo;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof FontsConfig) && r.b(this.f11280android, ((FontsConfig) obj).f11280android);
            }

            public final /* synthetic */ FontInfo getAndroid() {
                return this.f11280android;
            }

            public int hashCode() {
                return this.f11280android.hashCode();
            }

            public String toString() {
                return "FontsConfig(android=" + this.f11280android + ')';
            }

            public FontsConfig(FontInfo android2) {
                r.f(android2, "android");
                this.f11280android = android2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AppConfig() {
            this((Map) null, (Map) (0 == true ? 1 : 0), 3, (AbstractC1585j) (0 == true ? 1 : 0));
        }

        public static final /* synthetic */ void write$Self(AppConfig appConfig, I3.d dVar, H3.e eVar) {
            F3.b[] bVarArr = $childSerializers;
            if (dVar.j(eVar, 0) || !r.b(appConfig.colors, L.e())) {
                dVar.u(eVar, 0, bVarArr[0], appConfig.colors);
            }
            if (!dVar.j(eVar, 1) && r.b(appConfig.fonts, L.e())) {
                return;
            }
            dVar.u(eVar, 1, bVarArr[1], appConfig.fonts);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AppConfig)) {
                return false;
            }
            AppConfig appConfig = (AppConfig) obj;
            return r.b(this.colors, appConfig.colors) && r.b(this.fonts, appConfig.fonts);
        }

        public final /* synthetic */ Map getColors() {
            return this.colors;
        }

        public final /* synthetic */ Map getFonts() {
            return this.fonts;
        }

        public int hashCode() {
            return (this.colors.hashCode() * 31) + this.fonts.hashCode();
        }

        public String toString() {
            return "AppConfig(colors=" + this.colors + ", fonts=" + this.fonts + ')';
        }

        public /* synthetic */ AppConfig(int i4, Map map, Map map2, k0 k0Var) {
            this.colors = (i4 & 1) == 0 ? L.e() : map;
            if ((i4 & 2) == 0) {
                this.fonts = L.e();
            } else {
                this.fonts = map2;
            }
        }

        public AppConfig(Map<ColorAlias, ColorScheme> colors, Map<FontAlias, FontsConfig> fonts) {
            r.f(colors, "colors");
            r.f(fonts, "fonts");
            this.colors = colors;
            this.fonts = fonts;
        }

        public /* synthetic */ AppConfig(Map map, Map map2, int i4, AbstractC1585j abstractC1585j) {
            this((i4 & 1) != 0 ? L.e() : map, (i4 & 2) != 0 ? L.e() : map2);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final F3.b serializer() {
            return UiConfig$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public static final class VariableConfig {
        private static final F3.b[] $childSerializers;
        public static final Companion Companion = new Companion(null);
        private final Map<String, String> functionCompatibilityMap;
        private final Map<String, String> variableCompatibilityMap;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final F3.b serializer() {
                return UiConfig$VariableConfig$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        static {
            o0 o0Var = o0.f952a;
            $childSerializers = new F3.b[]{new K(o0Var, o0Var), new K(o0Var, o0Var)};
        }

        /* JADX WARN: Multi-variable type inference failed */
        public VariableConfig() {
            this((Map) null, (Map) (0 == true ? 1 : 0), 3, (AbstractC1585j) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ void getFunctionCompatibilityMap$annotations() {
        }

        public static /* synthetic */ void getVariableCompatibilityMap$annotations() {
        }

        public static final /* synthetic */ void write$Self(VariableConfig variableConfig, I3.d dVar, H3.e eVar) {
            F3.b[] bVarArr = $childSerializers;
            if (dVar.j(eVar, 0) || !r.b(variableConfig.variableCompatibilityMap, L.e())) {
                dVar.u(eVar, 0, bVarArr[0], variableConfig.variableCompatibilityMap);
            }
            if (!dVar.j(eVar, 1) && r.b(variableConfig.functionCompatibilityMap, L.e())) {
                return;
            }
            dVar.u(eVar, 1, bVarArr[1], variableConfig.functionCompatibilityMap);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VariableConfig)) {
                return false;
            }
            VariableConfig variableConfig = (VariableConfig) obj;
            return r.b(this.variableCompatibilityMap, variableConfig.variableCompatibilityMap) && r.b(this.functionCompatibilityMap, variableConfig.functionCompatibilityMap);
        }

        public final /* synthetic */ Map getFunctionCompatibilityMap() {
            return this.functionCompatibilityMap;
        }

        public final /* synthetic */ Map getVariableCompatibilityMap() {
            return this.variableCompatibilityMap;
        }

        public int hashCode() {
            return (this.variableCompatibilityMap.hashCode() * 31) + this.functionCompatibilityMap.hashCode();
        }

        public String toString() {
            return "VariableConfig(variableCompatibilityMap=" + this.variableCompatibilityMap + ", functionCompatibilityMap=" + this.functionCompatibilityMap + ')';
        }

        public /* synthetic */ VariableConfig(int i4, Map map, Map map2, k0 k0Var) {
            this.variableCompatibilityMap = (i4 & 1) == 0 ? L.e() : map;
            if ((i4 & 2) == 0) {
                this.functionCompatibilityMap = L.e();
            } else {
                this.functionCompatibilityMap = map2;
            }
        }

        public VariableConfig(Map<String, String> variableCompatibilityMap, Map<String, String> functionCompatibilityMap) {
            r.f(variableCompatibilityMap, "variableCompatibilityMap");
            r.f(functionCompatibilityMap, "functionCompatibilityMap");
            this.variableCompatibilityMap = variableCompatibilityMap;
            this.functionCompatibilityMap = functionCompatibilityMap;
        }

        public /* synthetic */ VariableConfig(Map map, Map map2, int i4, AbstractC1585j abstractC1585j) {
            this((i4 & 1) != 0 ? L.e() : map, (i4 & 2) != 0 ? L.e() : map2);
        }
    }

    public UiConfig() {
        this((AppConfig) null, (Map) null, (VariableConfig) null, 7, (AbstractC1585j) null);
    }

    public static /* synthetic */ void getLocalizations$annotations() {
    }

    public static /* synthetic */ void getVariableConfig$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void write$Self(UiConfig uiConfig, I3.d dVar, H3.e eVar) {
        int i4 = 3;
        Map map = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        if (dVar.j(eVar, 0) || !r.b(uiConfig.app, new AppConfig(map, (Map) (objArr5 == true ? 1 : 0), i4, (AbstractC1585j) (objArr4 == true ? 1 : 0)))) {
            dVar.u(eVar, 0, UiConfig$AppConfig$$serializer.INSTANCE, uiConfig.app);
        }
        if (dVar.j(eVar, 1) || !r.b(uiConfig.localizations, L.e())) {
            dVar.u(eVar, 1, LocalizedVariableLocalizationKeyMapSerializer.INSTANCE, uiConfig.localizations);
        }
        if (!dVar.j(eVar, 2) && r.b(uiConfig.variableConfig, new VariableConfig((Map) (objArr3 == true ? 1 : 0), (Map) (objArr2 == true ? 1 : 0), i4, (AbstractC1585j) (objArr == true ? 1 : 0)))) {
            return;
        }
        dVar.u(eVar, 2, UiConfig$VariableConfig$$serializer.INSTANCE, uiConfig.variableConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UiConfig)) {
            return false;
        }
        UiConfig uiConfig = (UiConfig) obj;
        return r.b(this.app, uiConfig.app) && r.b(this.localizations, uiConfig.localizations) && r.b(this.variableConfig, uiConfig.variableConfig);
    }

    public final /* synthetic */ AppConfig getApp() {
        return this.app;
    }

    public final /* synthetic */ Map getLocalizations() {
        return this.localizations;
    }

    public final /* synthetic */ VariableConfig getVariableConfig() {
        return this.variableConfig;
    }

    public int hashCode() {
        return (((this.app.hashCode() * 31) + this.localizations.hashCode()) * 31) + this.variableConfig.hashCode();
    }

    public String toString() {
        return "UiConfig(app=" + this.app + ", localizations=" + this.localizations + ", variableConfig=" + this.variableConfig + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ UiConfig(int i4, AppConfig appConfig, Map map, VariableConfig variableConfig, k0 k0Var) {
        int i5 = 3;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        this.app = (i4 & 1) == 0 ? new AppConfig((Map) null, (Map) (0 == true ? 1 : 0), i5, (AbstractC1585j) (0 == true ? 1 : 0)) : appConfig;
        if ((i4 & 2) == 0) {
            this.localizations = L.e();
        } else {
            this.localizations = map;
        }
        if ((i4 & 4) == 0) {
            this.variableConfig = new VariableConfig((Map) (objArr3 == true ? 1 : 0), (Map) (objArr2 == true ? 1 : 0), i5, (AbstractC1585j) (objArr == true ? 1 : 0));
        } else {
            this.variableConfig = variableConfig;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UiConfig(AppConfig app, Map<LocaleId, ? extends Map<VariableLocalizationKey, String>> localizations, VariableConfig variableConfig) {
        r.f(app, "app");
        r.f(localizations, "localizations");
        r.f(variableConfig, "variableConfig");
        this.app = app;
        this.localizations = localizations;
        this.variableConfig = variableConfig;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ UiConfig(AppConfig appConfig, Map map, VariableConfig variableConfig, int i4, AbstractC1585j abstractC1585j) {
        int i5 = 3;
        this((i4 & 1) != 0 ? new AppConfig((Map) null, (Map) (0 == true ? 1 : 0), i5, (AbstractC1585j) (0 == true ? 1 : 0)) : appConfig, (i4 & 2) != 0 ? L.e() : map, (i4 & 4) != 0 ? new VariableConfig((Map) (0 == true ? 1 : 0), (Map) (0 == true ? 1 : 0), i5, (AbstractC1585j) (0 == true ? 1 : 0)) : variableConfig);
    }
}
