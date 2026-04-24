package com.revenuecat.purchases.paywalls.components;

import E5.j;
import E5.k;
import E5.l;
import X5.c;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import java.lang.annotation.Annotation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import n6.b;
import n6.e;
import q6.d;
import r6.AbstractC2611a0;
import r6.Y;
import r6.k0;
import r6.o0;

/* JADX INFO: loaded from: classes2.dex */
@InternalRevenueCatAPI
public final class ButtonComponent implements PaywallComponent {
    public static final Companion Companion = new Companion(null);
    private final Action action;
    private final StackComponent stack;

    @InternalRevenueCatAPI
    public interface Action {
        public static final Companion Companion = Companion.$$INSTANCE;

        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final b serializer() {
                return ActionSerializer.INSTANCE;
            }
        }

        public static final class NavigateBack implements Action {
            public static final NavigateBack INSTANCE = new NavigateBack();
            private static final /* synthetic */ j $cachedSerializer$delegate = k.a(l.f1675b, AnonymousClass1.INSTANCE);

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.ButtonComponent$Action$NavigateBack$1, reason: invalid class name */
            public static final class AnonymousClass1 extends s implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return new Y("com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.NavigateBack", NavigateBack.INSTANCE, new Annotation[0]);
                }
            }

            private NavigateBack() {
            }

            private final /* synthetic */ b get$cachedSerializer() {
                return (b) $cachedSerializer$delegate.getValue();
            }

            public final b serializer() {
                return get$cachedSerializer();
            }
        }

        public static final class NavigateTo implements Action {
            private final Destination destination;
            public static final Companion Companion = new Companion(null);
            private static final b[] $childSerializers = {new e("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination", H.b(Destination.class), new c[]{H.b(Destination.CustomerCenter.class), H.b(Destination.PrivacyPolicy.class), H.b(Destination.Sheet.class), H.b(Destination.Terms.class), H.b(Destination.Unknown.class), H.b(Destination.Url.class)}, new b[]{new Y("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.CustomerCenter", Destination.CustomerCenter.INSTANCE, new Annotation[0]), ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, ButtonComponent$Destination$Terms$$serializer.INSTANCE, new Y("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Unknown", Destination.Unknown.INSTANCE, new Annotation[0]), ButtonComponent$Destination$Url$$serializer.INSTANCE}, new Annotation[0])};

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                    this();
                }

                public final b serializer() {
                    return ButtonComponent$Action$NavigateTo$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ NavigateTo(int i7, Destination destination, k0 k0Var) {
                if (1 != (i7 & 1)) {
                    AbstractC2611a0.a(i7, 1, ButtonComponent$Action$NavigateTo$$serializer.INSTANCE.getDescriptor());
                }
                this.destination = destination;
            }

            public static /* synthetic */ NavigateTo copy$default(NavigateTo navigateTo, Destination destination, int i7, Object obj) {
                if ((i7 & 1) != 0) {
                    destination = navigateTo.destination;
                }
                return navigateTo.copy(destination);
            }

            public final Destination component1() {
                return this.destination;
            }

            public final NavigateTo copy(Destination destination) {
                r.f(destination, "destination");
                return new NavigateTo(destination);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof NavigateTo) && r.b(this.destination, ((NavigateTo) obj).destination);
            }

            public final /* synthetic */ Destination getDestination() {
                return this.destination;
            }

            public int hashCode() {
                return this.destination.hashCode();
            }

            public String toString() {
                return "NavigateTo(destination=" + this.destination + ')';
            }

            public NavigateTo(Destination destination) {
                r.f(destination, "destination");
                this.destination = destination;
            }
        }

        public static final class RestorePurchases implements Action {
            public static final RestorePurchases INSTANCE = new RestorePurchases();
            private static final /* synthetic */ j $cachedSerializer$delegate = k.a(l.f1675b, AnonymousClass1.INSTANCE);

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.ButtonComponent$Action$RestorePurchases$1, reason: invalid class name */
            public static final class AnonymousClass1 extends s implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return new Y("com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.RestorePurchases", RestorePurchases.INSTANCE, new Annotation[0]);
                }
            }

            private RestorePurchases() {
            }

            private final /* synthetic */ b get$cachedSerializer() {
                return (b) $cachedSerializer$delegate.getValue();
            }

            public final b serializer() {
                return get$cachedSerializer();
            }
        }

        public static final class Unknown implements Action {
            public static final Unknown INSTANCE = new Unknown();
            private static final /* synthetic */ j $cachedSerializer$delegate = k.a(l.f1675b, AnonymousClass1.INSTANCE);

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.ButtonComponent$Action$Unknown$1, reason: invalid class name */
            public static final class AnonymousClass1 extends s implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return new Y("com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.Unknown", Unknown.INSTANCE, new Annotation[0]);
                }
            }

            private Unknown() {
            }

            private final /* synthetic */ b get$cachedSerializer() {
                return (b) $cachedSerializer$delegate.getValue();
            }

            public final b serializer() {
                return get$cachedSerializer();
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public final b serializer() {
            return ButtonComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @InternalRevenueCatAPI
    public interface Destination {
        public static final Companion Companion = Companion.$$INSTANCE;

        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final b serializer() {
                return new e("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination", H.b(Destination.class), new c[]{H.b(CustomerCenter.class), H.b(PrivacyPolicy.class), H.b(Sheet.class), H.b(Terms.class), H.b(Unknown.class), H.b(Url.class)}, new b[]{new Y("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.CustomerCenter", CustomerCenter.INSTANCE, new Annotation[0]), ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, ButtonComponent$Destination$Terms$$serializer.INSTANCE, new Y("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Unknown", Unknown.INSTANCE, new Annotation[0]), ButtonComponent$Destination$Url$$serializer.INSTANCE}, new Annotation[0]);
            }
        }

        public static final class CustomerCenter implements Destination {
            public static final CustomerCenter INSTANCE = new CustomerCenter();
            private static final /* synthetic */ j $cachedSerializer$delegate = k.a(l.f1675b, AnonymousClass1.INSTANCE);

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.ButtonComponent$Destination$CustomerCenter$1, reason: invalid class name */
            public static final class AnonymousClass1 extends s implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return new Y("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.CustomerCenter", CustomerCenter.INSTANCE, new Annotation[0]);
                }
            }

            private CustomerCenter() {
            }

            private final /* synthetic */ b get$cachedSerializer() {
                return (b) $cachedSerializer$delegate.getValue();
            }

            public final b serializer() {
                return get$cachedSerializer();
            }
        }

        public static final class PrivacyPolicy implements Destination {
            public static final Companion Companion = new Companion(null);
            private final UrlMethod method;
            private final String urlLid;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                    this();
                }

                public final b serializer() {
                    return ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ PrivacyPolicy(int i7, String str, UrlMethod urlMethod, k0 k0Var, AbstractC2148j abstractC2148j) {
                this(i7, str, urlMethod, k0Var);
            }

            /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
            public static /* synthetic */ PrivacyPolicy m104copy26kQY28$default(PrivacyPolicy privacyPolicy, String str, UrlMethod urlMethod, int i7, Object obj) {
                if ((i7 & 1) != 0) {
                    str = privacyPolicy.urlLid;
                }
                if ((i7 & 2) != 0) {
                    urlMethod = privacyPolicy.method;
                }
                return privacyPolicy.m106copy26kQY28(str, urlMethod);
            }

            public static final /* synthetic */ void write$Self(PrivacyPolicy privacyPolicy, d dVar, p6.e eVar) {
                dVar.x(eVar, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m160boximpl(privacyPolicy.urlLid));
                dVar.x(eVar, 1, UrlMethodDeserializer.INSTANCE, privacyPolicy.method);
            }

            /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name */
            public final String m105component1z7Tp4o() {
                return this.urlLid;
            }

            public final UrlMethod component2() {
                return this.method;
            }

            /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
            public final PrivacyPolicy m106copy26kQY28(String urlLid, UrlMethod method) {
                r.f(urlLid, "urlLid");
                r.f(method, "method");
                return new PrivacyPolicy(urlLid, method, null);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof PrivacyPolicy)) {
                    return false;
                }
                PrivacyPolicy privacyPolicy = (PrivacyPolicy) obj;
                return LocalizationKey.m163equalsimpl0(this.urlLid, privacyPolicy.urlLid) && this.method == privacyPolicy.method;
            }

            public final /* synthetic */ UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
            public final /* synthetic */ String m107getUrlLidz7Tp4o() {
                return this.urlLid;
            }

            public int hashCode() {
                return (LocalizationKey.m164hashCodeimpl(this.urlLid) * 31) + this.method.hashCode();
            }

            public String toString() {
                return "PrivacyPolicy(urlLid=" + ((Object) LocalizationKey.m165toStringimpl(this.urlLid)) + ", method=" + this.method + ')';
            }

            public /* synthetic */ PrivacyPolicy(String str, UrlMethod urlMethod, AbstractC2148j abstractC2148j) {
                this(str, urlMethod);
            }

            private PrivacyPolicy(int i7, String str, UrlMethod urlMethod, k0 k0Var) {
                if (3 != (i7 & 3)) {
                    AbstractC2611a0.a(i7, 3, ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE.getDescriptor());
                }
                this.urlLid = str;
                this.method = urlMethod;
            }

            private PrivacyPolicy(String urlLid, UrlMethod method) {
                r.f(urlLid, "urlLid");
                r.f(method, "method");
                this.urlLid = urlLid;
                this.method = method;
            }
        }

        public static final class Sheet implements Destination {
            public static final Companion Companion = new Companion(null);
            private final Background background;
            private final boolean backgroundBlur;
            private final String id;
            private final String name;
            private final Size size;
            private final StackComponent stack;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                    this();
                }

                public final b serializer() {
                    return ButtonComponent$Destination$Sheet$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ Sheet(int i7, String str, String str2, StackComponent stackComponent, Background background, boolean z7, Size size, k0 k0Var) {
                if (63 != (i7 & 63)) {
                    AbstractC2611a0.a(i7, 63, ButtonComponent$Destination$Sheet$$serializer.INSTANCE.getDescriptor());
                }
                this.id = str;
                this.name = str2;
                this.stack = stackComponent;
                this.background = background;
                this.backgroundBlur = z7;
                this.size = size;
            }

            public static /* synthetic */ Sheet copy$default(Sheet sheet, String str, String str2, StackComponent stackComponent, Background background, boolean z7, Size size, int i7, Object obj) {
                if ((i7 & 1) != 0) {
                    str = sheet.id;
                }
                if ((i7 & 2) != 0) {
                    str2 = sheet.name;
                }
                String str3 = str2;
                if ((i7 & 4) != 0) {
                    stackComponent = sheet.stack;
                }
                StackComponent stackComponent2 = stackComponent;
                if ((i7 & 8) != 0) {
                    background = sheet.background;
                }
                Background background2 = background;
                if ((i7 & 16) != 0) {
                    z7 = sheet.backgroundBlur;
                }
                boolean z8 = z7;
                if ((i7 & 32) != 0) {
                    size = sheet.size;
                }
                return sheet.copy(str, str3, stackComponent2, background2, z8, size);
            }

            public static /* synthetic */ void getBackgroundBlur$annotations() {
            }

            public static final /* synthetic */ void write$Self(Sheet sheet, d dVar, p6.e eVar) {
                dVar.m(eVar, 0, sheet.id);
                dVar.r(eVar, 1, o0.f22909a, sheet.name);
                dVar.x(eVar, 2, StackComponent$$serializer.INSTANCE, sheet.stack);
                dVar.r(eVar, 3, BackgroundDeserializer.INSTANCE, sheet.background);
                dVar.w(eVar, 4, sheet.backgroundBlur);
                dVar.r(eVar, 5, Size$$serializer.INSTANCE, sheet.size);
            }

            public final String component1() {
                return this.id;
            }

            public final String component2() {
                return this.name;
            }

            public final StackComponent component3() {
                return this.stack;
            }

            public final Background component4() {
                return this.background;
            }

            public final boolean component5() {
                return this.backgroundBlur;
            }

            public final Size component6() {
                return this.size;
            }

            public final Sheet copy(String id, String str, StackComponent stack, Background background, boolean z7, Size size) {
                r.f(id, "id");
                r.f(stack, "stack");
                return new Sheet(id, str, stack, background, z7, size);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Sheet)) {
                    return false;
                }
                Sheet sheet = (Sheet) obj;
                return r.b(this.id, sheet.id) && r.b(this.name, sheet.name) && r.b(this.stack, sheet.stack) && r.b(this.background, sheet.background) && this.backgroundBlur == sheet.backgroundBlur && r.b(this.size, sheet.size);
            }

            public final /* synthetic */ Background getBackground() {
                return this.background;
            }

            public final /* synthetic */ boolean getBackgroundBlur() {
                return this.backgroundBlur;
            }

            public final /* synthetic */ String getId() {
                return this.id;
            }

            public final /* synthetic */ String getName() {
                return this.name;
            }

            public final /* synthetic */ Size getSize() {
                return this.size;
            }

            public final /* synthetic */ StackComponent getStack() {
                return this.stack;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v11 */
            /* JADX WARN: Type inference failed for: r1v14 */
            /* JADX WARN: Type inference failed for: r1v9, types: [int] */
            public int hashCode() {
                int iHashCode = this.id.hashCode() * 31;
                String str = this.name;
                int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.stack.hashCode()) * 31;
                Background background = this.background;
                int iHashCode3 = (iHashCode2 + (background == null ? 0 : background.hashCode())) * 31;
                boolean z7 = this.backgroundBlur;
                ?? r12 = z7;
                if (z7) {
                    r12 = 1;
                }
                int i7 = (iHashCode3 + r12) * 31;
                Size size = this.size;
                return i7 + (size != null ? size.hashCode() : 0);
            }

            public String toString() {
                return "Sheet(id=" + this.id + ", name=" + this.name + ", stack=" + this.stack + ", background=" + this.background + ", backgroundBlur=" + this.backgroundBlur + ", size=" + this.size + ')';
            }

            public Sheet(String id, String str, StackComponent stack, Background background, boolean z7, Size size) {
                r.f(id, "id");
                r.f(stack, "stack");
                this.id = id;
                this.name = str;
                this.stack = stack;
                this.background = background;
                this.backgroundBlur = z7;
                this.size = size;
            }
        }

        public static final class Terms implements Destination {
            public static final Companion Companion = new Companion(null);
            private final UrlMethod method;
            private final String urlLid;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                    this();
                }

                public final b serializer() {
                    return ButtonComponent$Destination$Terms$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ Terms(int i7, String str, UrlMethod urlMethod, k0 k0Var, AbstractC2148j abstractC2148j) {
                this(i7, str, urlMethod, k0Var);
            }

            /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
            public static /* synthetic */ Terms m108copy26kQY28$default(Terms terms, String str, UrlMethod urlMethod, int i7, Object obj) {
                if ((i7 & 1) != 0) {
                    str = terms.urlLid;
                }
                if ((i7 & 2) != 0) {
                    urlMethod = terms.method;
                }
                return terms.m110copy26kQY28(str, urlMethod);
            }

            public static final /* synthetic */ void write$Self(Terms terms, d dVar, p6.e eVar) {
                dVar.x(eVar, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m160boximpl(terms.urlLid));
                dVar.x(eVar, 1, UrlMethodDeserializer.INSTANCE, terms.method);
            }

            /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name */
            public final String m109component1z7Tp4o() {
                return this.urlLid;
            }

            public final UrlMethod component2() {
                return this.method;
            }

            /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
            public final Terms m110copy26kQY28(String urlLid, UrlMethod method) {
                r.f(urlLid, "urlLid");
                r.f(method, "method");
                return new Terms(urlLid, method, null);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Terms)) {
                    return false;
                }
                Terms terms = (Terms) obj;
                return LocalizationKey.m163equalsimpl0(this.urlLid, terms.urlLid) && this.method == terms.method;
            }

            public final /* synthetic */ UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
            public final /* synthetic */ String m111getUrlLidz7Tp4o() {
                return this.urlLid;
            }

            public int hashCode() {
                return (LocalizationKey.m164hashCodeimpl(this.urlLid) * 31) + this.method.hashCode();
            }

            public String toString() {
                return "Terms(urlLid=" + ((Object) LocalizationKey.m165toStringimpl(this.urlLid)) + ", method=" + this.method + ')';
            }

            public /* synthetic */ Terms(String str, UrlMethod urlMethod, AbstractC2148j abstractC2148j) {
                this(str, urlMethod);
            }

            private Terms(int i7, String str, UrlMethod urlMethod, k0 k0Var) {
                if (3 != (i7 & 3)) {
                    AbstractC2611a0.a(i7, 3, ButtonComponent$Destination$Terms$$serializer.INSTANCE.getDescriptor());
                }
                this.urlLid = str;
                this.method = urlMethod;
            }

            private Terms(String urlLid, UrlMethod method) {
                r.f(urlLid, "urlLid");
                r.f(method, "method");
                this.urlLid = urlLid;
                this.method = method;
            }
        }

        public static final class Unknown implements Destination {
            public static final Unknown INSTANCE = new Unknown();
            private static final /* synthetic */ j $cachedSerializer$delegate = k.a(l.f1675b, AnonymousClass1.INSTANCE);

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.ButtonComponent$Destination$Unknown$1, reason: invalid class name */
            public static final class AnonymousClass1 extends s implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return new Y("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Unknown", Unknown.INSTANCE, new Annotation[0]);
                }
            }

            private Unknown() {
            }

            private final /* synthetic */ b get$cachedSerializer() {
                return (b) $cachedSerializer$delegate.getValue();
            }

            public final b serializer() {
                return get$cachedSerializer();
            }
        }

        public static final class Url implements Destination {
            public static final Companion Companion = new Companion(null);
            private final UrlMethod method;
            private final String urlLid;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                    this();
                }

                public final b serializer() {
                    return ButtonComponent$Destination$Url$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ Url(int i7, String str, UrlMethod urlMethod, k0 k0Var, AbstractC2148j abstractC2148j) {
                this(i7, str, urlMethod, k0Var);
            }

            /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
            public static /* synthetic */ Url m112copy26kQY28$default(Url url, String str, UrlMethod urlMethod, int i7, Object obj) {
                if ((i7 & 1) != 0) {
                    str = url.urlLid;
                }
                if ((i7 & 2) != 0) {
                    urlMethod = url.method;
                }
                return url.m114copy26kQY28(str, urlMethod);
            }

            public static final /* synthetic */ void write$Self(Url url, d dVar, p6.e eVar) {
                dVar.x(eVar, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m160boximpl(url.urlLid));
                dVar.x(eVar, 1, UrlMethodDeserializer.INSTANCE, url.method);
            }

            /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name */
            public final String m113component1z7Tp4o() {
                return this.urlLid;
            }

            public final UrlMethod component2() {
                return this.method;
            }

            /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
            public final Url m114copy26kQY28(String urlLid, UrlMethod method) {
                r.f(urlLid, "urlLid");
                r.f(method, "method");
                return new Url(urlLid, method, null);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Url)) {
                    return false;
                }
                Url url = (Url) obj;
                return LocalizationKey.m163equalsimpl0(this.urlLid, url.urlLid) && this.method == url.method;
            }

            public final /* synthetic */ UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
            public final /* synthetic */ String m115getUrlLidz7Tp4o() {
                return this.urlLid;
            }

            public int hashCode() {
                return (LocalizationKey.m164hashCodeimpl(this.urlLid) * 31) + this.method.hashCode();
            }

            public String toString() {
                return "Url(urlLid=" + ((Object) LocalizationKey.m165toStringimpl(this.urlLid)) + ", method=" + this.method + ')';
            }

            public /* synthetic */ Url(String str, UrlMethod urlMethod, AbstractC2148j abstractC2148j) {
                this(str, urlMethod);
            }

            private Url(int i7, String str, UrlMethod urlMethod, k0 k0Var) {
                if (3 != (i7 & 3)) {
                    AbstractC2611a0.a(i7, 3, ButtonComponent$Destination$Url$$serializer.INSTANCE.getDescriptor());
                }
                this.urlLid = str;
                this.method = urlMethod;
            }

            private Url(String urlLid, UrlMethod method) {
                r.f(urlLid, "urlLid");
                r.f(method, "method");
                this.urlLid = urlLid;
                this.method = method;
            }
        }
    }

    @InternalRevenueCatAPI
    public enum UrlMethod {
        IN_APP_BROWSER,
        EXTERNAL_BROWSER,
        DEEP_LINK,
        UNKNOWN;

        public static final Companion Companion = new Companion(null);
        private static final j $cachedSerializer$delegate = k.a(l.f1675b, Companion.AnonymousClass1.INSTANCE);

        public static final class Companion {

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.ButtonComponent$UrlMethod$Companion$1, reason: invalid class name */
            public static final class AnonymousClass1 extends s implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return UrlMethodDeserializer.INSTANCE;
                }
            }

            public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                this();
            }

            private final /* synthetic */ b get$cachedSerializer() {
                return (b) UrlMethod.$cachedSerializer$delegate.getValue();
            }

            public final b serializer() {
                return get$cachedSerializer();
            }

            private Companion() {
            }
        }
    }

    public /* synthetic */ ButtonComponent(int i7, Action action, StackComponent stackComponent, k0 k0Var) {
        if (3 != (i7 & 3)) {
            AbstractC2611a0.a(i7, 3, ButtonComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.action = action;
        this.stack = stackComponent;
    }

    public static final /* synthetic */ void write$Self(ButtonComponent buttonComponent, d dVar, p6.e eVar) {
        dVar.x(eVar, 0, ActionSerializer.INSTANCE, buttonComponent.action);
        dVar.x(eVar, 1, StackComponent$$serializer.INSTANCE, buttonComponent.stack);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonComponent)) {
            return false;
        }
        ButtonComponent buttonComponent = (ButtonComponent) obj;
        return r.b(this.action, buttonComponent.action) && r.b(this.stack, buttonComponent.stack);
    }

    public final /* synthetic */ Action getAction() {
        return this.action;
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public int hashCode() {
        return (this.action.hashCode() * 31) + this.stack.hashCode();
    }

    public String toString() {
        return "ButtonComponent(action=" + this.action + ", stack=" + this.stack + ')';
    }

    public ButtonComponent(Action action, StackComponent stack) {
        r.f(action, "action");
        r.f(stack, "stack");
        this.action = action;
        this.stack = stack;
    }
}
