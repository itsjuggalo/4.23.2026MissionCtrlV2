package com.revenuecat.purchases.customercenter;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.AbstractC0351y;
import J3.C0332e;
import J3.C0335h;
import J3.K;
import J3.k0;
import J3.o0;
import W2.j;
import W2.k;
import W2.l;
import W2.m;
import X2.L;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer;
import com.revenuecat.purchases.paywalls.PaywallColor;
import io.flutter.Build;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import p2.C1698D;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerCenterConfigData {
    public static final Companion Companion = new Companion(null);
    private final Appearance appearance;
    private final String lastPublishedAppVersion;
    private final Localization localization;
    private final Map<Screen.ScreenType, Screen> screens;
    private final Support support;

    public static final class Appearance {
        public static final Companion Companion = new Companion(null);
        private final ColorInformation dark;
        private final ColorInformation light;

        public static final class ColorInformation {
            public static final Companion Companion = new Companion(null);
            private final PaywallColor accentColor;
            private final PaywallColor backgroundColor;
            private final PaywallColor buttonBackgroundColor;
            private final PaywallColor buttonTextColor;
            private final PaywallColor textColor;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                public final b serializer() {
                    return CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public ColorInformation() {
                this((PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, 31, (AbstractC1585j) null);
            }

            public static /* synthetic */ ColorInformation copy$default(ColorInformation colorInformation, PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    paywallColor = colorInformation.accentColor;
                }
                if ((i4 & 2) != 0) {
                    paywallColor2 = colorInformation.textColor;
                }
                if ((i4 & 4) != 0) {
                    paywallColor3 = colorInformation.backgroundColor;
                }
                if ((i4 & 8) != 0) {
                    paywallColor4 = colorInformation.buttonTextColor;
                }
                if ((i4 & 16) != 0) {
                    paywallColor5 = colorInformation.buttonBackgroundColor;
                }
                PaywallColor paywallColor6 = paywallColor5;
                PaywallColor paywallColor7 = paywallColor3;
                return colorInformation.copy(paywallColor, paywallColor2, paywallColor7, paywallColor4, paywallColor6);
            }

            public static /* synthetic */ void getAccentColor$annotations() {
            }

            public static /* synthetic */ void getBackgroundColor$annotations() {
            }

            public static /* synthetic */ void getButtonBackgroundColor$annotations() {
            }

            public static /* synthetic */ void getButtonTextColor$annotations() {
            }

            public static /* synthetic */ void getTextColor$annotations() {
            }

            public static final /* synthetic */ void write$Self(ColorInformation colorInformation, d dVar, e eVar) {
                if (dVar.j(eVar, 0) || colorInformation.accentColor != null) {
                    dVar.E(eVar, 0, PaywallColor.Serializer.INSTANCE, colorInformation.accentColor);
                }
                if (dVar.j(eVar, 1) || colorInformation.textColor != null) {
                    dVar.E(eVar, 1, PaywallColor.Serializer.INSTANCE, colorInformation.textColor);
                }
                if (dVar.j(eVar, 2) || colorInformation.backgroundColor != null) {
                    dVar.E(eVar, 2, PaywallColor.Serializer.INSTANCE, colorInformation.backgroundColor);
                }
                if (dVar.j(eVar, 3) || colorInformation.buttonTextColor != null) {
                    dVar.E(eVar, 3, PaywallColor.Serializer.INSTANCE, colorInformation.buttonTextColor);
                }
                if (!dVar.j(eVar, 4) && colorInformation.buttonBackgroundColor == null) {
                    return;
                }
                dVar.E(eVar, 4, PaywallColor.Serializer.INSTANCE, colorInformation.buttonBackgroundColor);
            }

            public final PaywallColor component1() {
                return this.accentColor;
            }

            public final PaywallColor component2() {
                return this.textColor;
            }

            public final PaywallColor component3() {
                return this.backgroundColor;
            }

            public final PaywallColor component4() {
                return this.buttonTextColor;
            }

            public final PaywallColor component5() {
                return this.buttonBackgroundColor;
            }

            public final ColorInformation copy(PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5) {
                return new ColorInformation(paywallColor, paywallColor2, paywallColor3, paywallColor4, paywallColor5);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ColorInformation)) {
                    return false;
                }
                ColorInformation colorInformation = (ColorInformation) obj;
                return r.b(this.accentColor, colorInformation.accentColor) && r.b(this.textColor, colorInformation.textColor) && r.b(this.backgroundColor, colorInformation.backgroundColor) && r.b(this.buttonTextColor, colorInformation.buttonTextColor) && r.b(this.buttonBackgroundColor, colorInformation.buttonBackgroundColor);
            }

            public final PaywallColor getAccentColor() {
                return this.accentColor;
            }

            public final PaywallColor getBackgroundColor() {
                return this.backgroundColor;
            }

            public final PaywallColor getButtonBackgroundColor() {
                return this.buttonBackgroundColor;
            }

            public final PaywallColor getButtonTextColor() {
                return this.buttonTextColor;
            }

            public final PaywallColor getTextColor() {
                return this.textColor;
            }

            public int hashCode() {
                PaywallColor paywallColor = this.accentColor;
                int iHashCode = (paywallColor == null ? 0 : paywallColor.hashCode()) * 31;
                PaywallColor paywallColor2 = this.textColor;
                int iHashCode2 = (iHashCode + (paywallColor2 == null ? 0 : paywallColor2.hashCode())) * 31;
                PaywallColor paywallColor3 = this.backgroundColor;
                int iHashCode3 = (iHashCode2 + (paywallColor3 == null ? 0 : paywallColor3.hashCode())) * 31;
                PaywallColor paywallColor4 = this.buttonTextColor;
                int iHashCode4 = (iHashCode3 + (paywallColor4 == null ? 0 : paywallColor4.hashCode())) * 31;
                PaywallColor paywallColor5 = this.buttonBackgroundColor;
                return iHashCode4 + (paywallColor5 != null ? paywallColor5.hashCode() : 0);
            }

            public String toString() {
                return "ColorInformation(accentColor=" + this.accentColor + ", textColor=" + this.textColor + ", backgroundColor=" + this.backgroundColor + ", buttonTextColor=" + this.buttonTextColor + ", buttonBackgroundColor=" + this.buttonBackgroundColor + ')';
            }

            public /* synthetic */ ColorInformation(int i4, PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, k0 k0Var) {
                if ((i4 & 1) == 0) {
                    this.accentColor = null;
                } else {
                    this.accentColor = paywallColor;
                }
                if ((i4 & 2) == 0) {
                    this.textColor = null;
                } else {
                    this.textColor = paywallColor2;
                }
                if ((i4 & 4) == 0) {
                    this.backgroundColor = null;
                } else {
                    this.backgroundColor = paywallColor3;
                }
                if ((i4 & 8) == 0) {
                    this.buttonTextColor = null;
                } else {
                    this.buttonTextColor = paywallColor4;
                }
                if ((i4 & 16) == 0) {
                    this.buttonBackgroundColor = null;
                } else {
                    this.buttonBackgroundColor = paywallColor5;
                }
            }

            public ColorInformation(PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5) {
                this.accentColor = paywallColor;
                this.textColor = paywallColor2;
                this.backgroundColor = paywallColor3;
                this.buttonTextColor = paywallColor4;
                this.buttonBackgroundColor = paywallColor5;
            }

            public /* synthetic */ ColorInformation(PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, int i4, AbstractC1585j abstractC1585j) {
                this((i4 & 1) != 0 ? null : paywallColor, (i4 & 2) != 0 ? null : paywallColor2, (i4 & 4) != 0 ? null : paywallColor3, (i4 & 8) != 0 ? null : paywallColor4, (i4 & 16) != 0 ? null : paywallColor5);
            }
        }

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return CustomerCenterConfigData$Appearance$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Appearance() {
            this((ColorInformation) null, (ColorInformation) (0 == true ? 1 : 0), 3, (AbstractC1585j) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ Appearance copy$default(Appearance appearance, ColorInformation colorInformation, ColorInformation colorInformation2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                colorInformation = appearance.light;
            }
            if ((i4 & 2) != 0) {
                colorInformation2 = appearance.dark;
            }
            return appearance.copy(colorInformation, colorInformation2);
        }

        public static final /* synthetic */ void write$Self(Appearance appearance, d dVar, e eVar) {
            if (dVar.j(eVar, 0) || appearance.light != null) {
                dVar.E(eVar, 0, CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE, appearance.light);
            }
            if (!dVar.j(eVar, 1) && appearance.dark == null) {
                return;
            }
            dVar.E(eVar, 1, CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE, appearance.dark);
        }

        public final ColorInformation component1() {
            return this.light;
        }

        public final ColorInformation component2() {
            return this.dark;
        }

        public final Appearance copy(ColorInformation colorInformation, ColorInformation colorInformation2) {
            return new Appearance(colorInformation, colorInformation2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Appearance)) {
                return false;
            }
            Appearance appearance = (Appearance) obj;
            return r.b(this.light, appearance.light) && r.b(this.dark, appearance.dark);
        }

        public final ColorInformation getDark() {
            return this.dark;
        }

        public final ColorInformation getLight() {
            return this.light;
        }

        public int hashCode() {
            ColorInformation colorInformation = this.light;
            int iHashCode = (colorInformation == null ? 0 : colorInformation.hashCode()) * 31;
            ColorInformation colorInformation2 = this.dark;
            return iHashCode + (colorInformation2 != null ? colorInformation2.hashCode() : 0);
        }

        public String toString() {
            return "Appearance(light=" + this.light + ", dark=" + this.dark + ')';
        }

        public /* synthetic */ Appearance(int i4, ColorInformation colorInformation, ColorInformation colorInformation2, k0 k0Var) {
            if ((i4 & 1) == 0) {
                this.light = null;
            } else {
                this.light = colorInformation;
            }
            if ((i4 & 2) == 0) {
                this.dark = null;
            } else {
                this.dark = colorInformation2;
            }
        }

        public Appearance(ColorInformation colorInformation, ColorInformation colorInformation2) {
            this.light = colorInformation;
            this.dark = colorInformation2;
        }

        public /* synthetic */ Appearance(ColorInformation colorInformation, ColorInformation colorInformation2, int i4, AbstractC1585j abstractC1585j) {
            this((i4 & 1) != 0 ? null : colorInformation, (i4 & 2) != 0 ? null : colorInformation2);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return CustomerCenterConfigData$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public static final class HelpPath {
        private final String actionIdentifier;
        private final PathDetail.FeedbackSurvey feedbackSurvey;
        private final String id;
        private final OpenMethod openMethod;
        private final PathDetail.PromotionalOffer promotionalOffer;
        private final String title;
        private final PathType type;
        private final String url;
        public static final Companion Companion = new Companion(null);
        private static final b[] $childSerializers = {null, null, PathType.Companion.serializer(), null, null, null, OpenMethod.Companion.serializer(), null};

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return CustomerCenterConfigData$HelpPath$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public enum OpenMethod {
            IN_APP,
            EXTERNAL;

            public static final Companion Companion = new Companion(null);
            private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

            public static final class Companion {

                /* JADX INFO: renamed from: com.revenuecat.purchases.customercenter.CustomerCenterConfigData$HelpPath$OpenMethod$Companion$1, reason: invalid class name */
                public static final class AnonymousClass1 extends s implements Function0 {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    public AnonymousClass1() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final b invoke() {
                        return AbstractC0351y.b("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.OpenMethod", OpenMethod.values());
                    }
                }

                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                private final /* synthetic */ b get$cachedSerializer() {
                    return (b) OpenMethod.$cachedSerializer$delegate.getValue();
                }

                public final b serializer() {
                    return get$cachedSerializer();
                }

                private Companion() {
                }
            }
        }

        public static abstract class PathDetail {
            public static final Companion Companion = new Companion(null);
            private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

            public static final class Companion {

                /* JADX INFO: renamed from: com.revenuecat.purchases.customercenter.CustomerCenterConfigData$HelpPath$PathDetail$Companion$1, reason: invalid class name */
                public static final class AnonymousClass1 extends s implements Function0 {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    public AnonymousClass1() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final b invoke() {
                        return new F3.e("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathDetail", G.b(PathDetail.class), new InterfaceC1716c[]{G.b(FeedbackSurvey.class), G.b(PromotionalOffer.class)}, new b[]{CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE}, new Annotation[0]);
                    }
                }

                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                private final /* synthetic */ b get$cachedSerializer() {
                    return (b) PathDetail.$cachedSerializer$delegate.getValue();
                }

                public final b serializer() {
                    return get$cachedSerializer();
                }

                private Companion() {
                }
            }

            public static final class FeedbackSurvey extends PathDetail {
                private final List<Option> options;
                private final String title;
                public static final Companion Companion = new Companion(null);
                private static final b[] $childSerializers = {null, new C0332e(CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer.INSTANCE)};

                public static final class Companion {
                    public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                        this();
                    }

                    public final b serializer() {
                        return CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE;
                    }

                    private Companion() {
                    }
                }

                public static final class Option {
                    public static final Companion Companion = new Companion(null);
                    private final String id;
                    private final PromotionalOffer promotionalOffer;
                    private final String title;

                    public static final class Companion {
                        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                            this();
                        }

                        public final b serializer() {
                            return CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer.INSTANCE;
                        }

                        private Companion() {
                        }
                    }

                    public /* synthetic */ Option(int i4, String str, String str2, PromotionalOffer promotionalOffer, k0 k0Var) {
                        if (3 != (i4 & 3)) {
                            AbstractC0325a0.a(i4, 3, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer.INSTANCE.getDescriptor());
                        }
                        this.id = str;
                        this.title = str2;
                        if ((i4 & 4) == 0) {
                            this.promotionalOffer = null;
                        } else {
                            this.promotionalOffer = promotionalOffer;
                        }
                    }

                    public static /* synthetic */ Option copy$default(Option option, String str, String str2, PromotionalOffer promotionalOffer, int i4, Object obj) {
                        if ((i4 & 1) != 0) {
                            str = option.id;
                        }
                        if ((i4 & 2) != 0) {
                            str2 = option.title;
                        }
                        if ((i4 & 4) != 0) {
                            promotionalOffer = option.promotionalOffer;
                        }
                        return option.copy(str, str2, promotionalOffer);
                    }

                    public static /* synthetic */ void getPromotionalOffer$annotations() {
                    }

                    public static final /* synthetic */ void write$Self(Option option, d dVar, e eVar) {
                        dVar.o(eVar, 0, option.id);
                        dVar.o(eVar, 1, option.title);
                        if (!dVar.j(eVar, 2) && option.promotionalOffer == null) {
                            return;
                        }
                        dVar.E(eVar, 2, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, option.promotionalOffer);
                    }

                    public final String component1() {
                        return this.id;
                    }

                    public final String component2() {
                        return this.title;
                    }

                    public final PromotionalOffer component3() {
                        return this.promotionalOffer;
                    }

                    public final Option copy(String id, String title, PromotionalOffer promotionalOffer) {
                        r.f(id, "id");
                        r.f(title, "title");
                        return new Option(id, title, promotionalOffer);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof Option)) {
                            return false;
                        }
                        Option option = (Option) obj;
                        return r.b(this.id, option.id) && r.b(this.title, option.title) && r.b(this.promotionalOffer, option.promotionalOffer);
                    }

                    public final String getId() {
                        return this.id;
                    }

                    public final PromotionalOffer getPromotionalOffer() {
                        return this.promotionalOffer;
                    }

                    public final String getTitle() {
                        return this.title;
                    }

                    public int hashCode() {
                        int iHashCode = ((this.id.hashCode() * 31) + this.title.hashCode()) * 31;
                        PromotionalOffer promotionalOffer = this.promotionalOffer;
                        return iHashCode + (promotionalOffer == null ? 0 : promotionalOffer.hashCode());
                    }

                    public String toString() {
                        return "Option(id=" + this.id + ", title=" + this.title + ", promotionalOffer=" + this.promotionalOffer + ')';
                    }

                    public Option(String id, String title, PromotionalOffer promotionalOffer) {
                        r.f(id, "id");
                        r.f(title, "title");
                        this.id = id;
                        this.title = title;
                        this.promotionalOffer = promotionalOffer;
                    }

                    public /* synthetic */ Option(String str, String str2, PromotionalOffer promotionalOffer, int i4, AbstractC1585j abstractC1585j) {
                        this(str, str2, (i4 & 4) != 0 ? null : promotionalOffer);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public /* synthetic */ FeedbackSurvey(int i4, String str, List list, k0 k0Var) {
                    super(i4, k0Var);
                    if (3 != (i4 & 3)) {
                        AbstractC0325a0.a(i4, 3, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE.getDescriptor());
                    }
                    this.title = str;
                    this.options = list;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ FeedbackSurvey copy$default(FeedbackSurvey feedbackSurvey, String str, List list, int i4, Object obj) {
                    if ((i4 & 1) != 0) {
                        str = feedbackSurvey.title;
                    }
                    if ((i4 & 2) != 0) {
                        list = feedbackSurvey.options;
                    }
                    return feedbackSurvey.copy(str, list);
                }

                public static final /* synthetic */ void write$Self(FeedbackSurvey feedbackSurvey, d dVar, e eVar) {
                    PathDetail.write$Self(feedbackSurvey, dVar, eVar);
                    b[] bVarArr = $childSerializers;
                    dVar.o(eVar, 0, feedbackSurvey.title);
                    dVar.u(eVar, 1, bVarArr[1], feedbackSurvey.options);
                }

                public final String component1() {
                    return this.title;
                }

                public final List<Option> component2() {
                    return this.options;
                }

                public final FeedbackSurvey copy(String title, List<Option> options) {
                    r.f(title, "title");
                    r.f(options, "options");
                    return new FeedbackSurvey(title, options);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof FeedbackSurvey)) {
                        return false;
                    }
                    FeedbackSurvey feedbackSurvey = (FeedbackSurvey) obj;
                    return r.b(this.title, feedbackSurvey.title) && r.b(this.options, feedbackSurvey.options);
                }

                public final List<Option> getOptions() {
                    return this.options;
                }

                public final String getTitle() {
                    return this.title;
                }

                public int hashCode() {
                    return (this.title.hashCode() * 31) + this.options.hashCode();
                }

                public String toString() {
                    return "FeedbackSurvey(title=" + this.title + ", options=" + this.options + ')';
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public FeedbackSurvey(String title, List<Option> options) {
                    super(null);
                    r.f(title, "title");
                    r.f(options, "options");
                    this.title = title;
                    this.options = options;
                }
            }

            public static final class PromotionalOffer extends PathDetail {
                private static final b[] $childSerializers;
                public static final Companion Companion = new Companion(null);
                private final String androidOfferId;
                private final Map<String, CrossProductPromotion> crossProductPromotions;
                private final boolean eligible;
                private final Map<String, String> productMapping;
                private final String subtitle;
                private final String title;

                public static final class Companion {
                    public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                        this();
                    }

                    public final b serializer() {
                        return CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE;
                    }

                    private Companion() {
                    }
                }

                public static final class CrossProductPromotion {
                    public static final Companion Companion = new Companion(null);
                    private final String storeOfferIdentifier;
                    private final String targetProductId;

                    public static final class Companion {
                        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                            this();
                        }

                        public final b serializer() {
                            return CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer.INSTANCE;
                        }

                        private Companion() {
                        }
                    }

                    public /* synthetic */ CrossProductPromotion(int i4, String str, String str2, k0 k0Var) {
                        if (3 != (i4 & 3)) {
                            AbstractC0325a0.a(i4, 3, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer.INSTANCE.getDescriptor());
                        }
                        this.storeOfferIdentifier = str;
                        this.targetProductId = str2;
                    }

                    public static /* synthetic */ void getStoreOfferIdentifier$annotations() {
                    }

                    public static /* synthetic */ void getTargetProductId$annotations() {
                    }

                    public static final /* synthetic */ void write$Self(CrossProductPromotion crossProductPromotion, d dVar, e eVar) {
                        dVar.o(eVar, 0, crossProductPromotion.storeOfferIdentifier);
                        dVar.o(eVar, 1, crossProductPromotion.targetProductId);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof CrossProductPromotion)) {
                            return false;
                        }
                        CrossProductPromotion crossProductPromotion = (CrossProductPromotion) obj;
                        return r.b(this.storeOfferIdentifier, crossProductPromotion.storeOfferIdentifier) && r.b(this.targetProductId, crossProductPromotion.targetProductId);
                    }

                    public final String getStoreOfferIdentifier() {
                        return this.storeOfferIdentifier;
                    }

                    public final String getTargetProductId() {
                        return this.targetProductId;
                    }

                    public int hashCode() {
                        return (this.storeOfferIdentifier.hashCode() * 31) + this.targetProductId.hashCode();
                    }

                    public String toString() {
                        return "CrossProductPromotion(storeOfferIdentifier=" + this.storeOfferIdentifier + ", targetProductId=" + this.targetProductId + ')';
                    }

                    public CrossProductPromotion(String storeOfferIdentifier, String targetProductId) {
                        r.f(storeOfferIdentifier, "storeOfferIdentifier");
                        r.f(targetProductId, "targetProductId");
                        this.storeOfferIdentifier = storeOfferIdentifier;
                        this.targetProductId = targetProductId;
                    }
                }

                static {
                    o0 o0Var = o0.f952a;
                    $childSerializers = new b[]{null, null, null, null, new K(o0Var, o0Var), new K(o0Var, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer.INSTANCE)};
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public /* synthetic */ PromotionalOffer(int i4, String str, boolean z4, String str2, String str3, Map map, Map map2, k0 k0Var) {
                    super(i4, k0Var);
                    if (31 != (i4 & 31)) {
                        AbstractC0325a0.a(i4, 31, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE.getDescriptor());
                    }
                    this.androidOfferId = str;
                    this.eligible = z4;
                    this.title = str2;
                    this.subtitle = str3;
                    this.productMapping = map;
                    if ((i4 & 32) == 0) {
                        this.crossProductPromotions = L.e();
                    } else {
                        this.crossProductPromotions = map2;
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ PromotionalOffer copy$default(PromotionalOffer promotionalOffer, String str, boolean z4, String str2, String str3, Map map, Map map2, int i4, Object obj) {
                    if ((i4 & 1) != 0) {
                        str = promotionalOffer.androidOfferId;
                    }
                    if ((i4 & 2) != 0) {
                        z4 = promotionalOffer.eligible;
                    }
                    if ((i4 & 4) != 0) {
                        str2 = promotionalOffer.title;
                    }
                    if ((i4 & 8) != 0) {
                        str3 = promotionalOffer.subtitle;
                    }
                    if ((i4 & 16) != 0) {
                        map = promotionalOffer.productMapping;
                    }
                    if ((i4 & 32) != 0) {
                        map2 = promotionalOffer.crossProductPromotions;
                    }
                    Map map3 = map;
                    Map map4 = map2;
                    return promotionalOffer.copy(str, z4, str2, str3, map3, map4);
                }

                public static /* synthetic */ void getAndroidOfferId$annotations() {
                }

                public static /* synthetic */ void getCrossProductPromotions$annotations() {
                }

                public static /* synthetic */ void getProductMapping$annotations() {
                }

                public static final /* synthetic */ void write$Self(PromotionalOffer promotionalOffer, d dVar, e eVar) {
                    PathDetail.write$Self(promotionalOffer, dVar, eVar);
                    b[] bVarArr = $childSerializers;
                    dVar.o(eVar, 0, promotionalOffer.androidOfferId);
                    dVar.y(eVar, 1, promotionalOffer.eligible);
                    dVar.o(eVar, 2, promotionalOffer.title);
                    dVar.o(eVar, 3, promotionalOffer.subtitle);
                    dVar.u(eVar, 4, bVarArr[4], promotionalOffer.productMapping);
                    if (!dVar.j(eVar, 5) && r.b(promotionalOffer.crossProductPromotions, L.e())) {
                        return;
                    }
                    dVar.u(eVar, 5, bVarArr[5], promotionalOffer.crossProductPromotions);
                }

                public final String component1() {
                    return this.androidOfferId;
                }

                public final boolean component2() {
                    return this.eligible;
                }

                public final String component3() {
                    return this.title;
                }

                public final String component4() {
                    return this.subtitle;
                }

                public final Map<String, String> component5() {
                    return this.productMapping;
                }

                public final Map<String, CrossProductPromotion> component6() {
                    return this.crossProductPromotions;
                }

                public final PromotionalOffer copy(String androidOfferId, boolean z4, String title, String subtitle, Map<String, String> productMapping, Map<String, CrossProductPromotion> crossProductPromotions) {
                    r.f(androidOfferId, "androidOfferId");
                    r.f(title, "title");
                    r.f(subtitle, "subtitle");
                    r.f(productMapping, "productMapping");
                    r.f(crossProductPromotions, "crossProductPromotions");
                    return new PromotionalOffer(androidOfferId, z4, title, subtitle, productMapping, crossProductPromotions);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof PromotionalOffer)) {
                        return false;
                    }
                    PromotionalOffer promotionalOffer = (PromotionalOffer) obj;
                    return r.b(this.androidOfferId, promotionalOffer.androidOfferId) && this.eligible == promotionalOffer.eligible && r.b(this.title, promotionalOffer.title) && r.b(this.subtitle, promotionalOffer.subtitle) && r.b(this.productMapping, promotionalOffer.productMapping) && r.b(this.crossProductPromotions, promotionalOffer.crossProductPromotions);
                }

                public final String getAndroidOfferId() {
                    return this.androidOfferId;
                }

                public final Map<String, CrossProductPromotion> getCrossProductPromotions() {
                    return this.crossProductPromotions;
                }

                public final boolean getEligible() {
                    return this.eligible;
                }

                public final Map<String, String> getProductMapping() {
                    return this.productMapping;
                }

                public final String getSubtitle() {
                    return this.subtitle;
                }

                public final String getTitle() {
                    return this.title;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v1, types: [int] */
                /* JADX WARN: Type inference failed for: r1v10 */
                /* JADX WARN: Type inference failed for: r1v11 */
                public int hashCode() {
                    int iHashCode = this.androidOfferId.hashCode() * 31;
                    boolean z4 = this.eligible;
                    ?? r12 = z4;
                    if (z4) {
                        r12 = 1;
                    }
                    return ((((((((iHashCode + r12) * 31) + this.title.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.productMapping.hashCode()) * 31) + this.crossProductPromotions.hashCode();
                }

                public String toString() {
                    return "PromotionalOffer(androidOfferId=" + this.androidOfferId + ", eligible=" + this.eligible + ", title=" + this.title + ", subtitle=" + this.subtitle + ", productMapping=" + this.productMapping + ", crossProductPromotions=" + this.crossProductPromotions + ')';
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ PromotionalOffer copy$default(PromotionalOffer promotionalOffer, String str, boolean z4, String str2, String str3, Map map, int i4, Object obj) {
                    if ((i4 & 1) != 0) {
                        str = promotionalOffer.androidOfferId;
                    }
                    if ((i4 & 2) != 0) {
                        z4 = promotionalOffer.eligible;
                    }
                    if ((i4 & 4) != 0) {
                        str2 = promotionalOffer.title;
                    }
                    if ((i4 & 8) != 0) {
                        str3 = promotionalOffer.subtitle;
                    }
                    if ((i4 & 16) != 0) {
                        map = promotionalOffer.productMapping;
                    }
                    Map map2 = map;
                    String str4 = str2;
                    return promotionalOffer.copy(str, z4, str4, str3, map2);
                }

                public final PromotionalOffer copy(String androidOfferId, boolean z4, String title, String subtitle, Map<String, String> productMapping) {
                    r.f(androidOfferId, "androidOfferId");
                    r.f(title, "title");
                    r.f(subtitle, "subtitle");
                    r.f(productMapping, "productMapping");
                    return copy(androidOfferId, z4, title, subtitle, productMapping, L.e());
                }

                public /* synthetic */ PromotionalOffer(String str, boolean z4, String str2, String str3, Map map, Map map2, int i4, AbstractC1585j abstractC1585j) {
                    this(str, z4, str2, str3, map, (i4 & 32) != 0 ? L.e() : map2);
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public PromotionalOffer(String androidOfferId, boolean z4, String title, String subtitle, Map<String, String> productMapping, Map<String, CrossProductPromotion> crossProductPromotions) {
                    super(null);
                    r.f(androidOfferId, "androidOfferId");
                    r.f(title, "title");
                    r.f(subtitle, "subtitle");
                    r.f(productMapping, "productMapping");
                    r.f(crossProductPromotions, "crossProductPromotions");
                    this.androidOfferId = androidOfferId;
                    this.eligible = z4;
                    this.title = title;
                    this.subtitle = subtitle;
                    this.productMapping = productMapping;
                    this.crossProductPromotions = crossProductPromotions;
                }

                /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
                public PromotionalOffer(String androidOfferId, boolean z4, String title, String subtitle, Map<String, String> productMapping) {
                    this(androidOfferId, z4, title, subtitle, productMapping, L.e());
                    r.f(androidOfferId, "androidOfferId");
                    r.f(title, "title");
                    r.f(subtitle, "subtitle");
                    r.f(productMapping, "productMapping");
                }
            }

            public /* synthetic */ PathDetail(AbstractC1585j abstractC1585j) {
                this();
            }

            private PathDetail() {
            }

            public /* synthetic */ PathDetail(int i4, k0 k0Var) {
            }

            public static final /* synthetic */ void write$Self(PathDetail pathDetail, d dVar, e eVar) {
            }
        }

        public enum PathType {
            MISSING_PURCHASE,
            REFUND_REQUEST,
            CHANGE_PLANS,
            CANCEL,
            CUSTOM_URL,
            CUSTOM_ACTION,
            UNKNOWN;

            public static final Companion Companion = new Companion(null);
            private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

            public static final class Companion {

                /* JADX INFO: renamed from: com.revenuecat.purchases.customercenter.CustomerCenterConfigData$HelpPath$PathType$Companion$1, reason: invalid class name */
                public static final class AnonymousClass1 extends s implements Function0 {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    public AnonymousClass1() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final b invoke() {
                        return AbstractC0351y.b("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathType", PathType.values());
                    }
                }

                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                private final /* synthetic */ b get$cachedSerializer() {
                    return (b) PathType.$cachedSerializer$delegate.getValue();
                }

                public final b serializer() {
                    return get$cachedSerializer();
                }

                private Companion() {
                }
            }
        }

        public /* synthetic */ HelpPath(int i4, String str, String str2, PathType pathType, PathDetail.PromotionalOffer promotionalOffer, PathDetail.FeedbackSurvey feedbackSurvey, String str3, OpenMethod openMethod, String str4, k0 k0Var) {
            if (7 != (i4 & 7)) {
                AbstractC0325a0.a(i4, 7, CustomerCenterConfigData$HelpPath$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.title = str2;
            this.type = pathType;
            if ((i4 & 8) == 0) {
                this.promotionalOffer = null;
            } else {
                this.promotionalOffer = promotionalOffer;
            }
            if ((i4 & 16) == 0) {
                this.feedbackSurvey = null;
            } else {
                this.feedbackSurvey = feedbackSurvey;
            }
            if ((i4 & 32) == 0) {
                this.url = null;
            } else {
                this.url = str3;
            }
            if ((i4 & 64) == 0) {
                this.openMethod = null;
            } else {
                this.openMethod = openMethod;
            }
            if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) == 0) {
                this.actionIdentifier = null;
            } else {
                this.actionIdentifier = str4;
            }
        }

        public static /* synthetic */ HelpPath copy$default(HelpPath helpPath, String str, String str2, PathType pathType, PathDetail.PromotionalOffer promotionalOffer, PathDetail.FeedbackSurvey feedbackSurvey, String str3, OpenMethod openMethod, String str4, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = helpPath.id;
            }
            if ((i4 & 2) != 0) {
                str2 = helpPath.title;
            }
            if ((i4 & 4) != 0) {
                pathType = helpPath.type;
            }
            if ((i4 & 8) != 0) {
                promotionalOffer = helpPath.promotionalOffer;
            }
            if ((i4 & 16) != 0) {
                feedbackSurvey = helpPath.feedbackSurvey;
            }
            if ((i4 & 32) != 0) {
                str3 = helpPath.url;
            }
            if ((i4 & 64) != 0) {
                openMethod = helpPath.openMethod;
            }
            if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0) {
                str4 = helpPath.actionIdentifier;
            }
            OpenMethod openMethod2 = openMethod;
            String str5 = str4;
            PathDetail.FeedbackSurvey feedbackSurvey2 = feedbackSurvey;
            String str6 = str3;
            return helpPath.copy(str, str2, pathType, promotionalOffer, feedbackSurvey2, str6, openMethod2, str5);
        }

        public static /* synthetic */ void getActionIdentifier$annotations() {
        }

        public static /* synthetic */ void getFeedbackSurvey$annotations() {
        }

        public static /* synthetic */ void getOpenMethod$annotations() {
        }

        public static /* synthetic */ void getPromotionalOffer$annotations() {
        }

        public static final /* synthetic */ void write$Self(HelpPath helpPath, d dVar, e eVar) {
            b[] bVarArr = $childSerializers;
            dVar.o(eVar, 0, helpPath.id);
            dVar.o(eVar, 1, helpPath.title);
            dVar.u(eVar, 2, bVarArr[2], helpPath.type);
            if (dVar.j(eVar, 3) || helpPath.promotionalOffer != null) {
                dVar.E(eVar, 3, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, helpPath.promotionalOffer);
            }
            if (dVar.j(eVar, 4) || helpPath.feedbackSurvey != null) {
                dVar.E(eVar, 4, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE, helpPath.feedbackSurvey);
            }
            if (dVar.j(eVar, 5) || helpPath.url != null) {
                dVar.E(eVar, 5, o0.f952a, helpPath.url);
            }
            if (dVar.j(eVar, 6) || helpPath.openMethod != null) {
                dVar.E(eVar, 6, bVarArr[6], helpPath.openMethod);
            }
            if (!dVar.j(eVar, 7) && helpPath.actionIdentifier == null) {
                return;
            }
            dVar.E(eVar, 7, o0.f952a, helpPath.actionIdentifier);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.title;
        }

        public final PathType component3() {
            return this.type;
        }

        public final PathDetail.PromotionalOffer component4() {
            return this.promotionalOffer;
        }

        public final PathDetail.FeedbackSurvey component5() {
            return this.feedbackSurvey;
        }

        public final String component6() {
            return this.url;
        }

        public final OpenMethod component7() {
            return this.openMethod;
        }

        public final String component8() {
            return this.actionIdentifier;
        }

        public final HelpPath copy(String id, String title, PathType type, PathDetail.PromotionalOffer promotionalOffer, PathDetail.FeedbackSurvey feedbackSurvey, String str, OpenMethod openMethod, String str2) {
            r.f(id, "id");
            r.f(title, "title");
            r.f(type, "type");
            return new HelpPath(id, title, type, promotionalOffer, feedbackSurvey, str, openMethod, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HelpPath)) {
                return false;
            }
            HelpPath helpPath = (HelpPath) obj;
            return r.b(this.id, helpPath.id) && r.b(this.title, helpPath.title) && this.type == helpPath.type && r.b(this.promotionalOffer, helpPath.promotionalOffer) && r.b(this.feedbackSurvey, helpPath.feedbackSurvey) && r.b(this.url, helpPath.url) && this.openMethod == helpPath.openMethod && r.b(this.actionIdentifier, helpPath.actionIdentifier);
        }

        public final String getActionIdentifier() {
            return this.actionIdentifier;
        }

        public final PathDetail.FeedbackSurvey getFeedbackSurvey() {
            return this.feedbackSurvey;
        }

        public final String getId() {
            return this.id;
        }

        public final OpenMethod getOpenMethod() {
            return this.openMethod;
        }

        public final PathDetail.PromotionalOffer getPromotionalOffer() {
            return this.promotionalOffer;
        }

        public final String getTitle() {
            return this.title;
        }

        public final PathType getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int iHashCode = ((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.type.hashCode()) * 31;
            PathDetail.PromotionalOffer promotionalOffer = this.promotionalOffer;
            int iHashCode2 = (iHashCode + (promotionalOffer == null ? 0 : promotionalOffer.hashCode())) * 31;
            PathDetail.FeedbackSurvey feedbackSurvey = this.feedbackSurvey;
            int iHashCode3 = (iHashCode2 + (feedbackSurvey == null ? 0 : feedbackSurvey.hashCode())) * 31;
            String str = this.url;
            int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            OpenMethod openMethod = this.openMethod;
            int iHashCode5 = (iHashCode4 + (openMethod == null ? 0 : openMethod.hashCode())) * 31;
            String str2 = this.actionIdentifier;
            return iHashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "HelpPath(id=" + this.id + ", title=" + this.title + ", type=" + this.type + ", promotionalOffer=" + this.promotionalOffer + ", feedbackSurvey=" + this.feedbackSurvey + ", url=" + this.url + ", openMethod=" + this.openMethod + ", actionIdentifier=" + this.actionIdentifier + ')';
        }

        public HelpPath(String id, String title, PathType type, PathDetail.PromotionalOffer promotionalOffer, PathDetail.FeedbackSurvey feedbackSurvey, String str, OpenMethod openMethod, String str2) {
            r.f(id, "id");
            r.f(title, "title");
            r.f(type, "type");
            this.id = id;
            this.title = title;
            this.type = type;
            this.promotionalOffer = promotionalOffer;
            this.feedbackSurvey = feedbackSurvey;
            this.url = str;
            this.openMethod = openMethod;
            this.actionIdentifier = str2;
        }

        public /* synthetic */ HelpPath(String str, String str2, PathType pathType, PathDetail.PromotionalOffer promotionalOffer, PathDetail.FeedbackSurvey feedbackSurvey, String str3, OpenMethod openMethod, String str4, int i4, AbstractC1585j abstractC1585j) {
            this(str, str2, pathType, (i4 & 8) != 0 ? null : promotionalOffer, (i4 & 16) != 0 ? null : feedbackSurvey, (i4 & 32) != 0 ? null : str3, (i4 & 64) != 0 ? null : openMethod, (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? null : str4);
        }
    }

    public static final class Localization {
        private static final b[] $childSerializers;
        public static final Companion Companion = new Companion(null);
        private final String locale;
        private final Map<String, String> localizedStrings;

        public enum CommonLocalizedString {
            NO_THANKS,
            NO_SUBSCRIPTIONS_FOUND,
            TRY_CHECK_RESTORE,
            RESTORE_PURCHASES,
            CANCEL,
            BILLING_CYCLE,
            CURRENT_PRICE,
            EXPIRED,
            EXPIRES,
            NEXT_BILLING_DATE,
            REFUND_CANCELED,
            REFUND_ERROR_GENERIC,
            REFUND_GRANTED,
            REFUND_STATUS,
            SUB_EARLIEST_EXPIRATION,
            SUB_EARLIEST_RENEWAL,
            SUB_EXPIRED,
            CONTACT_SUPPORT,
            DEFAULT_BODY,
            DEFAULT_SUBJECT,
            DISMISS,
            UPDATE_WARNING_TITLE,
            UPDATE_WARNING_DESCRIPTION,
            UPDATE_WARNING_UPDATE,
            UPDATE_WARNING_IGNORE,
            PLEASE_CONTACT_SUPPORT,
            APPLE_SUBSCRIPTION_MANAGE,
            GOOGLE_SUBSCRIPTION_MANAGE,
            AMAZON_SUBSCRIPTION_MANAGE,
            PLATFORM_MISMATCH,
            GOING_TO_CHECK_PURCHASES,
            CHECK_PAST_PURCHASES,
            PURCHASES_RECOVERED,
            PURCHASES_RECOVERED_EXPLANATION,
            PURCHASES_NOT_RECOVERED,
            PURCHASES_NOT_FOUND,
            PURCHASES_RESTORING,
            MANAGE_SUBSCRIPTION,
            YOU_HAVE_PROMO,
            YOU_HAVE_LIFETIME,
            WEB_SUBSCRIPTION_MANAGE,
            FREE,
            NEVER,
            FREE_TRIAL_THEN_PRICE,
            SINGLE_PAYMENT_THEN_PRICE,
            DISCOUNTED_RECURRING_THEN_PRICE,
            FREE_TRIAL_SINGLE_PAYMENT_THEN_PRICE,
            FREE_TRIAL_DISCOUNTED_THEN_PRICE,
            DONE,
            RENEWS_ON_DATE_FOR_PRICE,
            RENEWS_ON_DATE,
            PURCHASE_INFO_EXPIRED_ON_DATE,
            PURCHASE_INFO_EXPIRES_ON_DATE,
            ACTIVE,
            BADGE_CANCELLED,
            BADGE_FREE_TRIAL,
            BADGE_FREE_TRIAL_CANCELLED,
            BADGE_LIFETIME,
            APP_STORE,
            MAC_APP_STORE,
            GOOGLE_PLAY_STORE,
            AMAZON_STORE,
            WEB_STORE,
            UNKNOWN_STORE,
            CARD_STORE_PROMOTIONAL,
            RESUBSCRIBE,
            TYPE_SUBSCRIPTION,
            TYPE_ONE_TIME_PURCHASE,
            BUY_SUBSCRIPTION,
            LAST_CHARGE_WAS,
            NEXT_BILLING_DATE_ON;

            public static final Companion Companion = new Companion(null);
            private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

            public static final class Companion {

                /* JADX INFO: renamed from: com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization$CommonLocalizedString$Companion$1, reason: invalid class name */
                public static final class AnonymousClass1 extends s implements Function0 {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    public AnonymousClass1() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final b invoke() {
                        return AbstractC0351y.a("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization.CommonLocalizedString", CommonLocalizedString.values(), new String[]{"no_thanks", "no_subscriptions_found", "try_check_restore", "restore_purchases", "cancel", "billing_cycle", "current_price", "expired", "expires", "next_billing_date", "refund_canceled", "refund_error_generic", "refund_granted", "refund_status", "sub_earliest_expiration", "sub_earliest_renewal", "sub_expired", "contact_support", "default_body", "default_subject", "dismiss", "update_warning_title", "update_warning_description", "update_warning_update", "update_warning_ignore", "please_contact_support", "apple_subscription_manage", "google_subscription_manage", "amazon_subscription_manage", "platform_mismatch", "going_to_check_purchases", "check_past_purchases", "purchases_recovered", "purchases_recovered_explanation", "purchases_not_recovered", "purchases_not_found", "purchases_restoring", "manage_subscription", "you_have_promo", "you_have_lifetime", "web_subscription_manage", "free", "never", "free_trial_then_price", "single_payment_then_price", "discounted_recurring_then_price", "free_trial_single_payment_then_price", "free_trial_discounted_then_price", "done", "renews_on_date_for_price", "renews_on_date", "purchase_info_expired_on_date", "purchase_info_expires_on_date", "active", "badge_cancelled", "badge_free_trial", "badge_free_trial_cancelled", "badge_lifetime", "app_store", "mac_app_store", "google_play_store", "amazon_store", "web_store", "unknown_store", "card_store_promotional", "resubscribe", "type_subscription", "type_one_time_purchase", "buy_subscription", "last_charge_was", "next_billing_date_on"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, null);
                    }
                }

                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                private final /* synthetic */ b get$cachedSerializer() {
                    return (b) CommonLocalizedString.$cachedSerializer$delegate.getValue();
                }

                public final b serializer() {
                    return get$cachedSerializer();
                }

                private Companion() {
                }
            }

            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[CommonLocalizedString.values().length];
                    try {
                        iArr[CommonLocalizedString.NO_THANKS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[CommonLocalizedString.NO_SUBSCRIPTIONS_FOUND.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[CommonLocalizedString.TRY_CHECK_RESTORE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[CommonLocalizedString.RESTORE_PURCHASES.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[CommonLocalizedString.CANCEL.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[CommonLocalizedString.BILLING_CYCLE.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[CommonLocalizedString.CURRENT_PRICE.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr[CommonLocalizedString.EXPIRED.ordinal()] = 8;
                    } catch (NoSuchFieldError unused8) {
                    }
                    try {
                        iArr[CommonLocalizedString.EXPIRES.ordinal()] = 9;
                    } catch (NoSuchFieldError unused9) {
                    }
                    try {
                        iArr[CommonLocalizedString.NEXT_BILLING_DATE.ordinal()] = 10;
                    } catch (NoSuchFieldError unused10) {
                    }
                    try {
                        iArr[CommonLocalizedString.REFUND_CANCELED.ordinal()] = 11;
                    } catch (NoSuchFieldError unused11) {
                    }
                    try {
                        iArr[CommonLocalizedString.REFUND_ERROR_GENERIC.ordinal()] = 12;
                    } catch (NoSuchFieldError unused12) {
                    }
                    try {
                        iArr[CommonLocalizedString.REFUND_GRANTED.ordinal()] = 13;
                    } catch (NoSuchFieldError unused13) {
                    }
                    try {
                        iArr[CommonLocalizedString.REFUND_STATUS.ordinal()] = 14;
                    } catch (NoSuchFieldError unused14) {
                    }
                    try {
                        iArr[CommonLocalizedString.SUB_EARLIEST_EXPIRATION.ordinal()] = 15;
                    } catch (NoSuchFieldError unused15) {
                    }
                    try {
                        iArr[CommonLocalizedString.SUB_EARLIEST_RENEWAL.ordinal()] = 16;
                    } catch (NoSuchFieldError unused16) {
                    }
                    try {
                        iArr[CommonLocalizedString.SUB_EXPIRED.ordinal()] = 17;
                    } catch (NoSuchFieldError unused17) {
                    }
                    try {
                        iArr[CommonLocalizedString.CONTACT_SUPPORT.ordinal()] = 18;
                    } catch (NoSuchFieldError unused18) {
                    }
                    try {
                        iArr[CommonLocalizedString.DEFAULT_BODY.ordinal()] = 19;
                    } catch (NoSuchFieldError unused19) {
                    }
                    try {
                        iArr[CommonLocalizedString.DEFAULT_SUBJECT.ordinal()] = 20;
                    } catch (NoSuchFieldError unused20) {
                    }
                    try {
                        iArr[CommonLocalizedString.DISMISS.ordinal()] = 21;
                    } catch (NoSuchFieldError unused21) {
                    }
                    try {
                        iArr[CommonLocalizedString.UPDATE_WARNING_TITLE.ordinal()] = 22;
                    } catch (NoSuchFieldError unused22) {
                    }
                    try {
                        iArr[CommonLocalizedString.UPDATE_WARNING_DESCRIPTION.ordinal()] = 23;
                    } catch (NoSuchFieldError unused23) {
                    }
                    try {
                        iArr[CommonLocalizedString.UPDATE_WARNING_UPDATE.ordinal()] = 24;
                    } catch (NoSuchFieldError unused24) {
                    }
                    try {
                        iArr[CommonLocalizedString.UPDATE_WARNING_IGNORE.ordinal()] = 25;
                    } catch (NoSuchFieldError unused25) {
                    }
                    try {
                        iArr[CommonLocalizedString.PLATFORM_MISMATCH.ordinal()] = 26;
                    } catch (NoSuchFieldError unused26) {
                    }
                    try {
                        iArr[CommonLocalizedString.PLEASE_CONTACT_SUPPORT.ordinal()] = 27;
                    } catch (NoSuchFieldError unused27) {
                    }
                    try {
                        iArr[CommonLocalizedString.APPLE_SUBSCRIPTION_MANAGE.ordinal()] = 28;
                    } catch (NoSuchFieldError unused28) {
                    }
                    try {
                        iArr[CommonLocalizedString.GOOGLE_SUBSCRIPTION_MANAGE.ordinal()] = 29;
                    } catch (NoSuchFieldError unused29) {
                    }
                    try {
                        iArr[CommonLocalizedString.AMAZON_SUBSCRIPTION_MANAGE.ordinal()] = 30;
                    } catch (NoSuchFieldError unused30) {
                    }
                    try {
                        iArr[CommonLocalizedString.GOING_TO_CHECK_PURCHASES.ordinal()] = 31;
                    } catch (NoSuchFieldError unused31) {
                    }
                    try {
                        iArr[CommonLocalizedString.CHECK_PAST_PURCHASES.ordinal()] = 32;
                    } catch (NoSuchFieldError unused32) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASES_RECOVERED.ordinal()] = 33;
                    } catch (NoSuchFieldError unused33) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASES_RECOVERED_EXPLANATION.ordinal()] = 34;
                    } catch (NoSuchFieldError unused34) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASES_NOT_RECOVERED.ordinal()] = 35;
                    } catch (NoSuchFieldError unused35) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASES_NOT_FOUND.ordinal()] = 36;
                    } catch (NoSuchFieldError unused36) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASES_RESTORING.ordinal()] = 37;
                    } catch (NoSuchFieldError unused37) {
                    }
                    try {
                        iArr[CommonLocalizedString.MANAGE_SUBSCRIPTION.ordinal()] = 38;
                    } catch (NoSuchFieldError unused38) {
                    }
                    try {
                        iArr[CommonLocalizedString.YOU_HAVE_PROMO.ordinal()] = 39;
                    } catch (NoSuchFieldError unused39) {
                    }
                    try {
                        iArr[CommonLocalizedString.YOU_HAVE_LIFETIME.ordinal()] = 40;
                    } catch (NoSuchFieldError unused40) {
                    }
                    try {
                        iArr[CommonLocalizedString.WEB_SUBSCRIPTION_MANAGE.ordinal()] = 41;
                    } catch (NoSuchFieldError unused41) {
                    }
                    try {
                        iArr[CommonLocalizedString.FREE.ordinal()] = 42;
                    } catch (NoSuchFieldError unused42) {
                    }
                    try {
                        iArr[CommonLocalizedString.NEVER.ordinal()] = 43;
                    } catch (NoSuchFieldError unused43) {
                    }
                    try {
                        iArr[CommonLocalizedString.FREE_TRIAL_THEN_PRICE.ordinal()] = 44;
                    } catch (NoSuchFieldError unused44) {
                    }
                    try {
                        iArr[CommonLocalizedString.SINGLE_PAYMENT_THEN_PRICE.ordinal()] = 45;
                    } catch (NoSuchFieldError unused45) {
                    }
                    try {
                        iArr[CommonLocalizedString.DISCOUNTED_RECURRING_THEN_PRICE.ordinal()] = 46;
                    } catch (NoSuchFieldError unused46) {
                    }
                    try {
                        iArr[CommonLocalizedString.FREE_TRIAL_SINGLE_PAYMENT_THEN_PRICE.ordinal()] = 47;
                    } catch (NoSuchFieldError unused47) {
                    }
                    try {
                        iArr[CommonLocalizedString.FREE_TRIAL_DISCOUNTED_THEN_PRICE.ordinal()] = 48;
                    } catch (NoSuchFieldError unused48) {
                    }
                    try {
                        iArr[CommonLocalizedString.DONE.ordinal()] = 49;
                    } catch (NoSuchFieldError unused49) {
                    }
                    try {
                        iArr[CommonLocalizedString.RENEWS_ON_DATE_FOR_PRICE.ordinal()] = 50;
                    } catch (NoSuchFieldError unused50) {
                    }
                    try {
                        iArr[CommonLocalizedString.RENEWS_ON_DATE.ordinal()] = 51;
                    } catch (NoSuchFieldError unused51) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASE_INFO_EXPIRED_ON_DATE.ordinal()] = 52;
                    } catch (NoSuchFieldError unused52) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASE_INFO_EXPIRES_ON_DATE.ordinal()] = 53;
                    } catch (NoSuchFieldError unused53) {
                    }
                    try {
                        iArr[CommonLocalizedString.ACTIVE.ordinal()] = 54;
                    } catch (NoSuchFieldError unused54) {
                    }
                    try {
                        iArr[CommonLocalizedString.BADGE_CANCELLED.ordinal()] = 55;
                    } catch (NoSuchFieldError unused55) {
                    }
                    try {
                        iArr[CommonLocalizedString.BADGE_FREE_TRIAL.ordinal()] = 56;
                    } catch (NoSuchFieldError unused56) {
                    }
                    try {
                        iArr[CommonLocalizedString.BADGE_FREE_TRIAL_CANCELLED.ordinal()] = 57;
                    } catch (NoSuchFieldError unused57) {
                    }
                    try {
                        iArr[CommonLocalizedString.BADGE_LIFETIME.ordinal()] = 58;
                    } catch (NoSuchFieldError unused58) {
                    }
                    try {
                        iArr[CommonLocalizedString.APP_STORE.ordinal()] = 59;
                    } catch (NoSuchFieldError unused59) {
                    }
                    try {
                        iArr[CommonLocalizedString.MAC_APP_STORE.ordinal()] = 60;
                    } catch (NoSuchFieldError unused60) {
                    }
                    try {
                        iArr[CommonLocalizedString.GOOGLE_PLAY_STORE.ordinal()] = 61;
                    } catch (NoSuchFieldError unused61) {
                    }
                    try {
                        iArr[CommonLocalizedString.AMAZON_STORE.ordinal()] = 62;
                    } catch (NoSuchFieldError unused62) {
                    }
                    try {
                        iArr[CommonLocalizedString.WEB_STORE.ordinal()] = 63;
                    } catch (NoSuchFieldError unused63) {
                    }
                    try {
                        iArr[CommonLocalizedString.UNKNOWN_STORE.ordinal()] = 64;
                    } catch (NoSuchFieldError unused64) {
                    }
                    try {
                        iArr[CommonLocalizedString.CARD_STORE_PROMOTIONAL.ordinal()] = 65;
                    } catch (NoSuchFieldError unused65) {
                    }
                    try {
                        iArr[CommonLocalizedString.RESUBSCRIBE.ordinal()] = 66;
                    } catch (NoSuchFieldError unused66) {
                    }
                    try {
                        iArr[CommonLocalizedString.TYPE_SUBSCRIPTION.ordinal()] = 67;
                    } catch (NoSuchFieldError unused67) {
                    }
                    try {
                        iArr[CommonLocalizedString.TYPE_ONE_TIME_PURCHASE.ordinal()] = 68;
                    } catch (NoSuchFieldError unused68) {
                    }
                    try {
                        iArr[CommonLocalizedString.BUY_SUBSCRIPTION.ordinal()] = 69;
                    } catch (NoSuchFieldError unused69) {
                    }
                    try {
                        iArr[CommonLocalizedString.LAST_CHARGE_WAS.ordinal()] = 70;
                    } catch (NoSuchFieldError unused70) {
                    }
                    try {
                        iArr[CommonLocalizedString.NEXT_BILLING_DATE_ON.ordinal()] = 71;
                    } catch (NoSuchFieldError unused71) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public final String getDefaultValue() {
                switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                    case 1:
                        return "No, thanks";
                    case 2:
                        return "No Subscriptions found";
                    case 3:
                        return "We can try checking your Apple account for any previous purchases";
                    case 4:
                        return "Restore purchases";
                    case 5:
                        return "Cancel";
                    case 6:
                        return "Billing cycle";
                    case 7:
                        return "Current price";
                    case 8:
                        return "Expired";
                    case 9:
                        return "Expires";
                    case 10:
                        return "Next billing date";
                    case 11:
                        return "Refund canceled";
                    case 12:
                        return "An error occurred while processing the refund request. Please try again.";
                    case 13:
                        return "Refund granted successfully!";
                    case 14:
                        return "Refund status";
                    case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                        return "This is your subscription with the earliest expiration date.";
                    case 16:
                        return "This is your subscription with the earliest billing date.";
                    case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                        return "This subscription has expired.";
                    case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                        return "Contact support";
                    case 19:
                        return "Please describe your issue or question.";
                    case FirestoreIndexValueWriter.INDEX_TYPE_TIMESTAMP /* 20 */:
                        return "Support Request";
                    case Build.API_LEVELS.API_21 /* 21 */:
                        return "Dismiss";
                    case Build.API_LEVELS.API_22 /* 22 */:
                        return "Update available";
                    case Build.API_LEVELS.API_23 /* 23 */:
                        return "Downloading the latest version of the app may help solve the problem.";
                    case 24:
                        return "Update";
                    case 25:
                        return "Continue";
                    case Build.API_LEVELS.API_26 /* 26 */:
                        return "Platform mismatch";
                    case Build.API_LEVELS.API_27 /* 27 */:
                        return "Please contact support to manage your subscription.";
                    case Build.API_LEVELS.API_28 /* 28 */:
                        return "You can manage your subscription by using the App Store app on an Apple device.";
                    case Build.API_LEVELS.API_29 /* 29 */:
                        return "You have an active subscription from the Google Play Store";
                    case 30:
                        return "You have an active subscription from the Amazon Appstore. You can manage your subscription in the Amazon Appstore app.";
                    case Build.API_LEVELS.API_31 /* 31 */:
                        return "Let's take a look! We're going to check your account for missing purchases.";
                    case 32:
                        return "Check past purchases";
                    case Build.API_LEVELS.API_33 /* 33 */:
                        return "Purchases restored";
                    case Build.API_LEVELS.API_34 /* 34 */:
                        return "We restored your past purchases and applied them to your account.";
                    case Build.API_LEVELS.API_35 /* 35 */:
                        return "We could not find any purchases with your account. If you think this is an error, please contact support.";
                    case Build.API_LEVELS.API_36 /* 36 */:
                        return "No past purchases";
                    case FirestoreIndexValueWriter.INDEX_TYPE_REFERENCE /* 37 */:
                        return "Restoring...";
                    case 38:
                        return "Manage your subscription";
                    case 39:
                        return "You've been granted a subscription that doesn't renew";
                    case 40:
                        return "Your active lifetime subscription";
                    case 41:
                        return "You have an active subscription that was purchased on the web. You can manage your subscription using the button below.";
                    case 42:
                        return "Free";
                    case 43:
                        return "Never";
                    case 44:
                        return "First {{ sub_offer_duration }} free, then {{ price }}";
                    case FirestoreIndexValueWriter.INDEX_TYPE_GEOPOINT /* 45 */:
                        return "{{ sub_offer_duration }} for {{ sub_offer_price }}, then {{ price }}";
                    case 46:
                        return "{{ sub_offer_price }} during {{ sub_offer_duration }}, then {{ price }}";
                    case 47:
                        return "Try {{ sub_offer_duration }} for free, then {{ sub_offer_duration_2 }} for {{ sub_offer_price_2 }}, and {{ price }} thereafter";
                    case 48:
                        return "Try {{ sub_offer_duration }} for free, then {{ sub_offer_price_2 }} during {{ sub_offer_duration_2 }}, and {{ price }} thereafter";
                    case 49:
                        return "Done";
                    case FirestoreIndexValueWriter.INDEX_TYPE_ARRAY /* 50 */:
                        return "Your next charge is {{ price }} on {{ date }}.";
                    case 51:
                        return "Renews on {{ date }}";
                    case 52:
                        return "Expired on {{ date }}";
                    case FirestoreIndexValueWriter.INDEX_TYPE_VECTOR /* 53 */:
                        return "Expires on {{ date }}";
                    case 54:
                        return "Active";
                    case FirestoreIndexValueWriter.INDEX_TYPE_MAP /* 55 */:
                        return "Cancelled";
                    case 56:
                        return "Free Trial";
                    case 57:
                        return "Cancelled Trial";
                    case 58:
                        return "Lifetime";
                    case 59:
                        return "App Store";
                    case FirestoreIndexValueWriter.INDEX_TYPE_REFERENCE_SEGMENT /* 60 */:
                        return "Mac App Store";
                    case 61:
                        return "Google Play Store";
                    case 62:
                        return "Amazon Store";
                    case 63:
                        return "Web";
                    case UserMetadata.MAX_ATTRIBUTES /* 64 */:
                        return "Unknown";
                    case 65:
                        return "Via Support";
                    case 66:
                        return "Resubscribe";
                    case 67:
                        return "Subscription";
                    case 68:
                        return "One time purchase";
                    case 69:
                        return "Buy Subscription";
                    case 70:
                        return "Last charge: {{ price }}";
                    case 71:
                        return "Next billing date: {{ date }}";
                    default:
                        throw new m();
                }
            }
        }

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return CustomerCenterConfigData$Localization$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public enum VariableName {
            PRICE("price"),
            SUB_OFFER_DURATION("sub_offer_duration"),
            SUB_OFFER_DURATION_2("sub_offer_duration_2"),
            SUB_OFFER_PRICE("sub_offer_price"),
            SUB_OFFER_PRICE_2("sub_offer_price_2");

            private final String identifier;
            public static final Companion Companion = new Companion(null);
            private static final j valueMap$delegate = k.b(CustomerCenterConfigData$Localization$VariableName$Companion$valueMap$2.INSTANCE);

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                private final Map<String, VariableName> getValueMap() {
                    return (Map) VariableName.valueMap$delegate.getValue();
                }

                public final VariableName valueOfIdentifier(String identifier) {
                    r.f(identifier, "identifier");
                    return getValueMap().get(identifier);
                }

                private Companion() {
                }
            }

            VariableName(String str) {
                this.identifier = str;
            }

            public final String getIdentifier() {
                return this.identifier;
            }
        }

        static {
            o0 o0Var = o0.f952a;
            $childSerializers = new b[]{null, new K(o0Var, o0Var)};
        }

        public /* synthetic */ Localization(int i4, String str, Map map, k0 k0Var) {
            if (3 != (i4 & 3)) {
                AbstractC0325a0.a(i4, 3, CustomerCenterConfigData$Localization$$serializer.INSTANCE.getDescriptor());
            }
            this.locale = str;
            this.localizedStrings = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Localization copy$default(Localization localization, String str, Map map, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = localization.locale;
            }
            if ((i4 & 2) != 0) {
                map = localization.localizedStrings;
            }
            return localization.copy(str, map);
        }

        public static /* synthetic */ void getLocalizedStrings$annotations() {
        }

        public static final /* synthetic */ void write$Self(Localization localization, d dVar, e eVar) {
            b[] bVarArr = $childSerializers;
            dVar.o(eVar, 0, localization.locale);
            dVar.u(eVar, 1, bVarArr[1], localization.localizedStrings);
        }

        public final String commonLocalizedString(CommonLocalizedString key) {
            r.f(key, "key");
            Map<String, String> map = this.localizedStrings;
            String lowerCase = key.name().toLowerCase(Locale.ROOT);
            r.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            String str = map.get(lowerCase);
            return str == null ? key.getDefaultValue() : str;
        }

        public final String component1() {
            return this.locale;
        }

        public final Map<String, String> component2() {
            return this.localizedStrings;
        }

        public final Localization copy(String locale, Map<String, String> localizedStrings) {
            r.f(locale, "locale");
            r.f(localizedStrings, "localizedStrings");
            return new Localization(locale, localizedStrings);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Localization)) {
                return false;
            }
            Localization localization = (Localization) obj;
            return r.b(this.locale, localization.locale) && r.b(this.localizedStrings, localization.localizedStrings);
        }

        public final String getLocale() {
            return this.locale;
        }

        public final Map<String, String> getLocalizedStrings() {
            return this.localizedStrings;
        }

        public int hashCode() {
            return (this.locale.hashCode() * 31) + this.localizedStrings.hashCode();
        }

        public String toString() {
            return "Localization(locale=" + this.locale + ", localizedStrings=" + this.localizedStrings + ')';
        }

        public Localization(String locale, Map<String, String> localizedStrings) {
            r.f(locale, "locale");
            r.f(localizedStrings, "localizedStrings");
            this.locale = locale;
            this.localizedStrings = localizedStrings;
        }
    }

    public static final class Screen {
        private final ScreenOffering offering;
        private final List<HelpPath> paths;
        private final String subtitle;
        private final String title;
        private final ScreenType type;
        public static final Companion Companion = new Companion(null);
        private static final b[] $childSerializers = {ScreenType.Companion.serializer(), null, null, null, null};

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return CustomerCenterConfigData$Screen$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public enum ScreenType {
            MANAGEMENT,
            NO_ACTIVE,
            UNKNOWN;

            public static final Companion Companion = new Companion(null);
            private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

            public static final class Companion {

                /* JADX INFO: renamed from: com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Screen$ScreenType$Companion$1, reason: invalid class name */
                public static final class AnonymousClass1 extends s implements Function0 {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    public AnonymousClass1() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final b invoke() {
                        return AbstractC0351y.b("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Screen.ScreenType", ScreenType.values());
                    }
                }

                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                private final /* synthetic */ b get$cachedSerializer() {
                    return (b) ScreenType.$cachedSerializer$delegate.getValue();
                }

                public final b serializer() {
                    return get$cachedSerializer();
                }

                private Companion() {
                }
            }
        }

        public /* synthetic */ Screen(int i4, ScreenType screenType, String str, String str2, List list, ScreenOffering screenOffering, k0 k0Var) {
            if (11 != (i4 & 11)) {
                AbstractC0325a0.a(i4, 11, CustomerCenterConfigData$Screen$$serializer.INSTANCE.getDescriptor());
            }
            this.type = screenType;
            this.title = str;
            if ((i4 & 4) == 0) {
                this.subtitle = null;
            } else {
                this.subtitle = str2;
            }
            this.paths = list;
            if ((i4 & 16) == 0) {
                this.offering = null;
            } else {
                this.offering = screenOffering;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Screen copy$default(Screen screen, ScreenType screenType, String str, String str2, List list, ScreenOffering screenOffering, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                screenType = screen.type;
            }
            if ((i4 & 2) != 0) {
                str = screen.title;
            }
            if ((i4 & 4) != 0) {
                str2 = screen.subtitle;
            }
            if ((i4 & 8) != 0) {
                list = screen.paths;
            }
            if ((i4 & 16) != 0) {
                screenOffering = screen.offering;
            }
            ScreenOffering screenOffering2 = screenOffering;
            String str3 = str2;
            return screen.copy(screenType, str, str3, list, screenOffering2);
        }

        public static /* synthetic */ void getPaths$annotations() {
        }

        public static /* synthetic */ void getSubtitle$annotations() {
        }

        public static final /* synthetic */ void write$Self(Screen screen, d dVar, e eVar) {
            dVar.u(eVar, 0, $childSerializers[0], screen.type);
            dVar.o(eVar, 1, screen.title);
            if (dVar.j(eVar, 2) || screen.subtitle != null) {
                dVar.E(eVar, 2, EmptyStringToNullSerializer.INSTANCE, screen.subtitle);
            }
            dVar.u(eVar, 3, HelpPathsSerializer.INSTANCE, screen.paths);
            if (!dVar.j(eVar, 4) && screen.offering == null) {
                return;
            }
            dVar.E(eVar, 4, CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE, screen.offering);
        }

        public final ScreenType component1() {
            return this.type;
        }

        public final String component2() {
            return this.title;
        }

        public final String component3() {
            return this.subtitle;
        }

        public final List<HelpPath> component4() {
            return this.paths;
        }

        public final ScreenOffering component5() {
            return this.offering;
        }

        public final Screen copy(ScreenType type, String title, String str, List<HelpPath> paths, ScreenOffering screenOffering) {
            r.f(type, "type");
            r.f(title, "title");
            r.f(paths, "paths");
            return new Screen(type, title, str, paths, screenOffering);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Screen)) {
                return false;
            }
            Screen screen = (Screen) obj;
            return this.type == screen.type && r.b(this.title, screen.title) && r.b(this.subtitle, screen.subtitle) && r.b(this.paths, screen.paths) && r.b(this.offering, screen.offering);
        }

        public final ScreenOffering getOffering() {
            return this.offering;
        }

        public final List<HelpPath> getPaths() {
            return this.paths;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final String getTitle() {
            return this.title;
        }

        public final ScreenType getType() {
            return this.type;
        }

        public int hashCode() {
            int iHashCode = ((this.type.hashCode() * 31) + this.title.hashCode()) * 31;
            String str = this.subtitle;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.paths.hashCode()) * 31;
            ScreenOffering screenOffering = this.offering;
            return iHashCode2 + (screenOffering != null ? screenOffering.hashCode() : 0);
        }

        public String toString() {
            return "Screen(type=" + this.type + ", title=" + this.title + ", subtitle=" + this.subtitle + ", paths=" + this.paths + ", offering=" + this.offering + ')';
        }

        public Screen(ScreenType type, String title, String str, List<HelpPath> paths, ScreenOffering screenOffering) {
            r.f(type, "type");
            r.f(title, "title");
            r.f(paths, "paths");
            this.type = type;
            this.title = title;
            this.subtitle = str;
            this.paths = paths;
            this.offering = screenOffering;
        }

        public /* synthetic */ Screen(ScreenType screenType, String str, String str2, List list, ScreenOffering screenOffering, int i4, AbstractC1585j abstractC1585j) {
            this(screenType, str, (i4 & 4) != 0 ? null : str2, list, (i4 & 16) != 0 ? null : screenOffering);
        }
    }

    public static final class ScreenOffering {
        private final String buttonText;
        private final String offeringId;
        private final ScreenOfferingType type;
        public static final Companion Companion = new Companion(null);
        private static final b[] $childSerializers = {ScreenOfferingType.Companion.serializer(), null, null};

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public enum ScreenOfferingType {
            CURRENT("CURRENT"),
            SPECIFIC("SPECIFIC");

            private final String value;
            public static final Companion Companion = new Companion(null);
            private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

            public static final class Companion {

                /* JADX INFO: renamed from: com.revenuecat.purchases.customercenter.CustomerCenterConfigData$ScreenOffering$ScreenOfferingType$Companion$1, reason: invalid class name */
                public static final class AnonymousClass1 extends s implements Function0 {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    public AnonymousClass1() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final b invoke() {
                        return AbstractC0351y.a("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.ScreenOffering.ScreenOfferingType", ScreenOfferingType.values(), new String[]{"CURRENT", "SPECIFIC"}, new Annotation[][]{null, null}, null);
                    }
                }

                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                private final /* synthetic */ b get$cachedSerializer() {
                    return (b) ScreenOfferingType.$cachedSerializer$delegate.getValue();
                }

                public final b serializer() {
                    return get$cachedSerializer();
                }

                private Companion() {
                }
            }

            ScreenOfferingType(String str) {
                this.value = str;
            }

            public final String getValue() {
                return this.value;
            }
        }

        public /* synthetic */ ScreenOffering(int i4, ScreenOfferingType screenOfferingType, String str, String str2, k0 k0Var) {
            if (1 != (i4 & 1)) {
                AbstractC0325a0.a(i4, 1, CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE.getDescriptor());
            }
            this.type = screenOfferingType;
            if ((i4 & 2) == 0) {
                this.offeringId = null;
            } else {
                this.offeringId = str;
            }
            if ((i4 & 4) == 0) {
                this.buttonText = null;
            } else {
                this.buttonText = str2;
            }
        }

        public static /* synthetic */ ScreenOffering copy$default(ScreenOffering screenOffering, ScreenOfferingType screenOfferingType, String str, String str2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                screenOfferingType = screenOffering.type;
            }
            if ((i4 & 2) != 0) {
                str = screenOffering.offeringId;
            }
            if ((i4 & 4) != 0) {
                str2 = screenOffering.buttonText;
            }
            return screenOffering.copy(screenOfferingType, str, str2);
        }

        public static /* synthetic */ void getButtonText$annotations() {
        }

        public static /* synthetic */ void getOfferingId$annotations() {
        }

        public static final /* synthetic */ void write$Self(ScreenOffering screenOffering, d dVar, e eVar) {
            dVar.u(eVar, 0, $childSerializers[0], screenOffering.type);
            if (dVar.j(eVar, 1) || screenOffering.offeringId != null) {
                dVar.E(eVar, 1, o0.f952a, screenOffering.offeringId);
            }
            if (!dVar.j(eVar, 2) && screenOffering.buttonText == null) {
                return;
            }
            dVar.E(eVar, 2, o0.f952a, screenOffering.buttonText);
        }

        public final ScreenOfferingType component1() {
            return this.type;
        }

        public final String component2() {
            return this.offeringId;
        }

        public final String component3() {
            return this.buttonText;
        }

        public final ScreenOffering copy(ScreenOfferingType type, String str, String str2) {
            r.f(type, "type");
            return new ScreenOffering(type, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScreenOffering)) {
                return false;
            }
            ScreenOffering screenOffering = (ScreenOffering) obj;
            return this.type == screenOffering.type && r.b(this.offeringId, screenOffering.offeringId) && r.b(this.buttonText, screenOffering.buttonText);
        }

        public final String getButtonText() {
            return this.buttonText;
        }

        public final String getOfferingId() {
            return this.offeringId;
        }

        public final ScreenOfferingType getType() {
            return this.type;
        }

        public int hashCode() {
            int iHashCode = this.type.hashCode() * 31;
            String str = this.offeringId;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.buttonText;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "ScreenOffering(type=" + this.type + ", offeringId=" + this.offeringId + ", buttonText=" + this.buttonText + ')';
        }

        public ScreenOffering(ScreenOfferingType type, String str, String str2) {
            r.f(type, "type");
            this.type = type;
            this.offeringId = str;
            this.buttonText = str2;
        }

        public /* synthetic */ ScreenOffering(ScreenOfferingType screenOfferingType, String str, String str2, int i4, AbstractC1585j abstractC1585j) {
            this(screenOfferingType, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? null : str2);
        }
    }

    public static final class Support {
        public static final Companion Companion = new Companion(null);
        private final String email;
        private final Boolean shouldWarnCustomerToUpdate;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return CustomerCenterConfigData$Support$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Support() {
            this((String) null, (Boolean) (0 == true ? 1 : 0), 3, (AbstractC1585j) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ Support copy$default(Support support, String str, Boolean bool, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = support.email;
            }
            if ((i4 & 2) != 0) {
                bool = support.shouldWarnCustomerToUpdate;
            }
            return support.copy(str, bool);
        }

        public static /* synthetic */ void getEmail$annotations() {
        }

        public static /* synthetic */ void getShouldWarnCustomerToUpdate$annotations() {
        }

        public static final /* synthetic */ void write$Self(Support support, d dVar, e eVar) {
            if (dVar.j(eVar, 0) || support.email != null) {
                dVar.E(eVar, 0, EmptyStringToNullSerializer.INSTANCE, support.email);
            }
            if (!dVar.j(eVar, 1) && support.shouldWarnCustomerToUpdate == null) {
                return;
            }
            dVar.E(eVar, 1, C0335h.f929a, support.shouldWarnCustomerToUpdate);
        }

        public final String component1() {
            return this.email;
        }

        public final Boolean component2() {
            return this.shouldWarnCustomerToUpdate;
        }

        public final Support copy(String str, Boolean bool) {
            return new Support(str, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Support)) {
                return false;
            }
            Support support = (Support) obj;
            return r.b(this.email, support.email) && r.b(this.shouldWarnCustomerToUpdate, support.shouldWarnCustomerToUpdate);
        }

        public final String getEmail() {
            return this.email;
        }

        public final Boolean getShouldWarnCustomerToUpdate() {
            return this.shouldWarnCustomerToUpdate;
        }

        public int hashCode() {
            String str = this.email;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Boolean bool = this.shouldWarnCustomerToUpdate;
            return iHashCode + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "Support(email=" + this.email + ", shouldWarnCustomerToUpdate=" + this.shouldWarnCustomerToUpdate + ')';
        }

        public /* synthetic */ Support(int i4, String str, Boolean bool, k0 k0Var) {
            if ((i4 & 1) == 0) {
                this.email = null;
            } else {
                this.email = str;
            }
            if ((i4 & 2) == 0) {
                this.shouldWarnCustomerToUpdate = null;
            } else {
                this.shouldWarnCustomerToUpdate = bool;
            }
        }

        public Support(String str, Boolean bool) {
            this.email = str;
            this.shouldWarnCustomerToUpdate = bool;
        }

        public /* synthetic */ Support(String str, Boolean bool, int i4, AbstractC1585j abstractC1585j) {
            this((i4 & 1) != 0 ? null : str, (i4 & 2) != 0 ? null : bool);
        }
    }

    public /* synthetic */ CustomerCenterConfigData(int i4, Map map, Appearance appearance, Localization localization, Support support, String str, k0 k0Var) {
        if (15 != (i4 & 15)) {
            AbstractC0325a0.a(i4, 15, CustomerCenterConfigData$$serializer.INSTANCE.getDescriptor());
        }
        this.screens = map;
        this.appearance = appearance;
        this.localization = localization;
        this.support = support;
        if ((i4 & 16) == 0) {
            this.lastPublishedAppVersion = null;
        } else {
            this.lastPublishedAppVersion = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomerCenterConfigData copy$default(CustomerCenterConfigData customerCenterConfigData, Map map, Appearance appearance, Localization localization, Support support, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            map = customerCenterConfigData.screens;
        }
        if ((i4 & 2) != 0) {
            appearance = customerCenterConfigData.appearance;
        }
        if ((i4 & 4) != 0) {
            localization = customerCenterConfigData.localization;
        }
        if ((i4 & 8) != 0) {
            support = customerCenterConfigData.support;
        }
        if ((i4 & 16) != 0) {
            str = customerCenterConfigData.lastPublishedAppVersion;
        }
        String str2 = str;
        Localization localization2 = localization;
        return customerCenterConfigData.copy(map, appearance, localization2, support, str2);
    }

    public static /* synthetic */ void getLastPublishedAppVersion$annotations() {
    }

    public static /* synthetic */ void getScreens$annotations() {
    }

    public static final /* synthetic */ void write$Self(CustomerCenterConfigData customerCenterConfigData, d dVar, e eVar) {
        dVar.u(eVar, 0, ScreenMapSerializer.INSTANCE, customerCenterConfigData.screens);
        dVar.u(eVar, 1, CustomerCenterConfigData$Appearance$$serializer.INSTANCE, customerCenterConfigData.appearance);
        dVar.u(eVar, 2, CustomerCenterConfigData$Localization$$serializer.INSTANCE, customerCenterConfigData.localization);
        dVar.u(eVar, 3, CustomerCenterConfigData$Support$$serializer.INSTANCE, customerCenterConfigData.support);
        if (!dVar.j(eVar, 4) && customerCenterConfigData.lastPublishedAppVersion == null) {
            return;
        }
        dVar.E(eVar, 4, EmptyStringToNullSerializer.INSTANCE, customerCenterConfigData.lastPublishedAppVersion);
    }

    public final Map<Screen.ScreenType, Screen> component1() {
        return this.screens;
    }

    public final Appearance component2() {
        return this.appearance;
    }

    public final Localization component3() {
        return this.localization;
    }

    public final Support component4() {
        return this.support;
    }

    public final String component5() {
        return this.lastPublishedAppVersion;
    }

    public final CustomerCenterConfigData copy(Map<Screen.ScreenType, Screen> screens, Appearance appearance, Localization localization, Support support, String str) {
        r.f(screens, "screens");
        r.f(appearance, "appearance");
        r.f(localization, "localization");
        r.f(support, "support");
        return new CustomerCenterConfigData(screens, appearance, localization, support, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomerCenterConfigData)) {
            return false;
        }
        CustomerCenterConfigData customerCenterConfigData = (CustomerCenterConfigData) obj;
        return r.b(this.screens, customerCenterConfigData.screens) && r.b(this.appearance, customerCenterConfigData.appearance) && r.b(this.localization, customerCenterConfigData.localization) && r.b(this.support, customerCenterConfigData.support) && r.b(this.lastPublishedAppVersion, customerCenterConfigData.lastPublishedAppVersion);
    }

    public final Appearance getAppearance() {
        return this.appearance;
    }

    public final String getLastPublishedAppVersion() {
        return this.lastPublishedAppVersion;
    }

    public final Localization getLocalization() {
        return this.localization;
    }

    public final Screen getManagementScreen() {
        return this.screens.get(Screen.ScreenType.MANAGEMENT);
    }

    public final Screen getNoActiveScreen() {
        return this.screens.get(Screen.ScreenType.NO_ACTIVE);
    }

    public final Map<Screen.ScreenType, Screen> getScreens() {
        return this.screens;
    }

    public final Support getSupport() {
        return this.support;
    }

    public int hashCode() {
        int iHashCode = ((((((this.screens.hashCode() * 31) + this.appearance.hashCode()) * 31) + this.localization.hashCode()) * 31) + this.support.hashCode()) * 31;
        String str = this.lastPublishedAppVersion;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CustomerCenterConfigData(screens=" + this.screens + ", appearance=" + this.appearance + ", localization=" + this.localization + ", support=" + this.support + ", lastPublishedAppVersion=" + this.lastPublishedAppVersion + ')';
    }

    public CustomerCenterConfigData(Map<Screen.ScreenType, Screen> screens, Appearance appearance, Localization localization, Support support, String str) {
        r.f(screens, "screens");
        r.f(appearance, "appearance");
        r.f(localization, "localization");
        r.f(support, "support");
        this.screens = screens;
        this.appearance = appearance;
        this.localization = localization;
        this.support = support;
        this.lastPublishedAppVersion = str;
    }

    public /* synthetic */ CustomerCenterConfigData(Map map, Appearance appearance, Localization localization, Support support, String str, int i4, AbstractC1585j abstractC1585j) {
        this(map, appearance, localization, support, (i4 & 16) != 0 ? null : str);
    }
}
