package com.revenuecat.purchases.paywalls.components;

import F3.b;
import F3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.Y;
import J3.k0;
import J3.o0;
import W2.j;
import W2.k;
import W2.l;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import java.lang.annotation.Annotation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class ButtonComponent implements PaywallComponent {
    public static final Companion Companion = new Companion(null);
    private final Action action;
    private final StackComponent stack;
    private final PaywallTransition transition;

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
            private static final /* synthetic */ j $cachedSerializer$delegate = k.a(l.f5481b, AnonymousClass1.INSTANCE);

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
            private static final b[] $childSerializers = {new e("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination", G.b(Destination.class), new InterfaceC1716c[]{G.b(Destination.CustomerCenter.class), G.b(Destination.PrivacyPolicy.class), G.b(Destination.Sheet.class), G.b(Destination.Terms.class), G.b(Destination.Unknown.class), G.b(Destination.Url.class)}, new b[]{new Y("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.CustomerCenter", Destination.CustomerCenter.INSTANCE, new Annotation[0]), ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, ButtonComponent$Destination$Terms$$serializer.INSTANCE, new Y("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Unknown", Destination.Unknown.INSTANCE, new Annotation[0]), ButtonComponent$Destination$Url$$serializer.INSTANCE}, new Annotation[0])};

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                public final b serializer() {
                    return ButtonComponent$Action$NavigateTo$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ NavigateTo(int i4, Destination destination, k0 k0Var) {
                if (1 != (i4 & 1)) {
                    AbstractC0325a0.a(i4, 1, ButtonComponent$Action$NavigateTo$$serializer.INSTANCE.getDescriptor());
                }
                this.destination = destination;
            }

            public static /* synthetic */ NavigateTo copy$default(NavigateTo navigateTo, Destination destination, int i4, Object obj) {
                if ((i4 & 1) != 0) {
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
            private static final /* synthetic */ j $cachedSerializer$delegate = k.a(l.f5481b, AnonymousClass1.INSTANCE);

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
            private static final /* synthetic */ j $cachedSerializer$delegate = k.a(l.f5481b, AnonymousClass1.INSTANCE);

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
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
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
                return new e("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination", G.b(Destination.class), new InterfaceC1716c[]{G.b(CustomerCenter.class), G.b(PrivacyPolicy.class), G.b(Sheet.class), G.b(Terms.class), G.b(Unknown.class), G.b(Url.class)}, new b[]{new Y("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.CustomerCenter", CustomerCenter.INSTANCE, new Annotation[0]), ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, ButtonComponent$Destination$Terms$$serializer.INSTANCE, new Y("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Unknown", Unknown.INSTANCE, new Annotation[0]), ButtonComponent$Destination$Url$$serializer.INSTANCE}, new Annotation[0]);
            }
        }

        public static final class CustomerCenter implements Destination {
            public static final CustomerCenter INSTANCE = new CustomerCenter();
            private static final /* synthetic */ j $cachedSerializer$delegate = k.a(l.f5481b, AnonymousClass1.INSTANCE);

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
                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                public final b serializer() {
                    return ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ PrivacyPolicy(int i4, String str, UrlMethod urlMethod, k0 k0Var, AbstractC1585j abstractC1585j) {
                this(i4, str, urlMethod, k0Var);
            }

            /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
            public static /* synthetic */ PrivacyPolicy m137copy26kQY28$default(PrivacyPolicy privacyPolicy, String str, UrlMethod urlMethod, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    str = privacyPolicy.urlLid;
                }
                if ((i4 & 2) != 0) {
                    urlMethod = privacyPolicy.method;
                }
                return privacyPolicy.m139copy26kQY28(str, urlMethod);
            }

            public static final /* synthetic */ void write$Self(PrivacyPolicy privacyPolicy, d dVar, H3.e eVar) {
                dVar.u(eVar, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m193boximpl(privacyPolicy.urlLid));
                dVar.u(eVar, 1, UrlMethodDeserializer.INSTANCE, privacyPolicy.method);
            }

            /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name */
            public final String m138component1z7Tp4o() {
                return this.urlLid;
            }

            public final UrlMethod component2() {
                return this.method;
            }

            /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
            public final PrivacyPolicy m139copy26kQY28(String urlLid, UrlMethod method) {
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
                return LocalizationKey.m196equalsimpl0(this.urlLid, privacyPolicy.urlLid) && this.method == privacyPolicy.method;
            }

            public final /* synthetic */ UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
            public final /* synthetic */ String m140getUrlLidz7Tp4o() {
                return this.urlLid;
            }

            public int hashCode() {
                return (LocalizationKey.m197hashCodeimpl(this.urlLid) * 31) + this.method.hashCode();
            }

            public String toString() {
                return "PrivacyPolicy(urlLid=" + ((Object) LocalizationKey.m198toStringimpl(this.urlLid)) + ", method=" + this.method + ')';
            }

            public /* synthetic */ PrivacyPolicy(String str, UrlMethod urlMethod, AbstractC1585j abstractC1585j) {
                this(str, urlMethod);
            }

            private PrivacyPolicy(int i4, String str, UrlMethod urlMethod, k0 k0Var) {
                if (3 != (i4 & 3)) {
                    AbstractC0325a0.a(i4, 3, ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE.getDescriptor());
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
            private final boolean backgroundBlur;
            private final String id;
            private final String name;
            private final Size size;
            private final StackComponent stack;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                public final b serializer() {
                    return ButtonComponent$Destination$Sheet$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ Sheet(int i4, String str, String str2, StackComponent stackComponent, boolean z4, Size size, k0 k0Var) {
                if (31 != (i4 & 31)) {
                    AbstractC0325a0.a(i4, 31, ButtonComponent$Destination$Sheet$$serializer.INSTANCE.getDescriptor());
                }
                this.id = str;
                this.name = str2;
                this.stack = stackComponent;
                this.backgroundBlur = z4;
                this.size = size;
            }

            public static /* synthetic */ Sheet copy$default(Sheet sheet, String str, String str2, StackComponent stackComponent, boolean z4, Size size, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    str = sheet.id;
                }
                if ((i4 & 2) != 0) {
                    str2 = sheet.name;
                }
                if ((i4 & 4) != 0) {
                    stackComponent = sheet.stack;
                }
                if ((i4 & 8) != 0) {
                    z4 = sheet.backgroundBlur;
                }
                if ((i4 & 16) != 0) {
                    size = sheet.size;
                }
                Size size2 = size;
                StackComponent stackComponent2 = stackComponent;
                return sheet.copy(str, str2, stackComponent2, z4, size2);
            }

            public static /* synthetic */ void getBackgroundBlur$annotations() {
            }

            public static final /* synthetic */ void write$Self(Sheet sheet, d dVar, H3.e eVar) {
                dVar.o(eVar, 0, sheet.id);
                dVar.E(eVar, 1, o0.f952a, sheet.name);
                dVar.u(eVar, 2, StackComponent$$serializer.INSTANCE, sheet.stack);
                dVar.y(eVar, 3, sheet.backgroundBlur);
                dVar.E(eVar, 4, Size$$serializer.INSTANCE, sheet.size);
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

            public final boolean component4() {
                return this.backgroundBlur;
            }

            public final Size component5() {
                return this.size;
            }

            public final Sheet copy(String id, String str, StackComponent stack, boolean z4, Size size) {
                r.f(id, "id");
                r.f(stack, "stack");
                return new Sheet(id, str, stack, z4, size);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Sheet)) {
                    return false;
                }
                Sheet sheet = (Sheet) obj;
                return r.b(this.id, sheet.id) && r.b(this.name, sheet.name) && r.b(this.stack, sheet.stack) && this.backgroundBlur == sheet.backgroundBlur && r.b(this.size, sheet.size);
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
            /* JADX WARN: Type inference failed for: r1v10 */
            /* JADX WARN: Type inference failed for: r1v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v8 */
            public int hashCode() {
                int iHashCode = this.id.hashCode() * 31;
                String str = this.name;
                int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.stack.hashCode()) * 31;
                boolean z4 = this.backgroundBlur;
                ?? r12 = z4;
                if (z4) {
                    r12 = 1;
                }
                int i4 = (iHashCode2 + r12) * 31;
                Size size = this.size;
                return i4 + (size != null ? size.hashCode() : 0);
            }

            public String toString() {
                return "Sheet(id=" + this.id + ", name=" + this.name + ", stack=" + this.stack + ", backgroundBlur=" + this.backgroundBlur + ", size=" + this.size + ')';
            }

            public Sheet(String id, String str, StackComponent stack, boolean z4, Size size) {
                r.f(id, "id");
                r.f(stack, "stack");
                this.id = id;
                this.name = str;
                this.stack = stack;
                this.backgroundBlur = z4;
                this.size = size;
            }
        }

        public static final class Terms implements Destination {
            public static final Companion Companion = new Companion(null);
            private final UrlMethod method;
            private final String urlLid;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                public final b serializer() {
                    return ButtonComponent$Destination$Terms$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ Terms(int i4, String str, UrlMethod urlMethod, k0 k0Var, AbstractC1585j abstractC1585j) {
                this(i4, str, urlMethod, k0Var);
            }

            /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
            public static /* synthetic */ Terms m141copy26kQY28$default(Terms terms, String str, UrlMethod urlMethod, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    str = terms.urlLid;
                }
                if ((i4 & 2) != 0) {
                    urlMethod = terms.method;
                }
                return terms.m143copy26kQY28(str, urlMethod);
            }

            public static final /* synthetic */ void write$Self(Terms terms, d dVar, H3.e eVar) {
                dVar.u(eVar, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m193boximpl(terms.urlLid));
                dVar.u(eVar, 1, UrlMethodDeserializer.INSTANCE, terms.method);
            }

            /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name */
            public final String m142component1z7Tp4o() {
                return this.urlLid;
            }

            public final UrlMethod component2() {
                return this.method;
            }

            /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
            public final Terms m143copy26kQY28(String urlLid, UrlMethod method) {
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
                return LocalizationKey.m196equalsimpl0(this.urlLid, terms.urlLid) && this.method == terms.method;
            }

            public final /* synthetic */ UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
            public final /* synthetic */ String m144getUrlLidz7Tp4o() {
                return this.urlLid;
            }

            public int hashCode() {
                return (LocalizationKey.m197hashCodeimpl(this.urlLid) * 31) + this.method.hashCode();
            }

            public String toString() {
                return "Terms(urlLid=" + ((Object) LocalizationKey.m198toStringimpl(this.urlLid)) + ", method=" + this.method + ')';
            }

            public /* synthetic */ Terms(String str, UrlMethod urlMethod, AbstractC1585j abstractC1585j) {
                this(str, urlMethod);
            }

            private Terms(int i4, String str, UrlMethod urlMethod, k0 k0Var) {
                if (3 != (i4 & 3)) {
                    AbstractC0325a0.a(i4, 3, ButtonComponent$Destination$Terms$$serializer.INSTANCE.getDescriptor());
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
            private static final /* synthetic */ j $cachedSerializer$delegate = k.a(l.f5481b, AnonymousClass1.INSTANCE);

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
                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                public final b serializer() {
                    return ButtonComponent$Destination$Url$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ Url(int i4, String str, UrlMethod urlMethod, k0 k0Var, AbstractC1585j abstractC1585j) {
                this(i4, str, urlMethod, k0Var);
            }

            /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
            public static /* synthetic */ Url m145copy26kQY28$default(Url url, String str, UrlMethod urlMethod, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    str = url.urlLid;
                }
                if ((i4 & 2) != 0) {
                    urlMethod = url.method;
                }
                return url.m147copy26kQY28(str, urlMethod);
            }

            public static final /* synthetic */ void write$Self(Url url, d dVar, H3.e eVar) {
                dVar.u(eVar, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m193boximpl(url.urlLid));
                dVar.u(eVar, 1, UrlMethodDeserializer.INSTANCE, url.method);
            }

            /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name */
            public final String m146component1z7Tp4o() {
                return this.urlLid;
            }

            public final UrlMethod component2() {
                return this.method;
            }

            /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
            public final Url m147copy26kQY28(String urlLid, UrlMethod method) {
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
                return LocalizationKey.m196equalsimpl0(this.urlLid, url.urlLid) && this.method == url.method;
            }

            public final /* synthetic */ UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
            public final /* synthetic */ String m148getUrlLidz7Tp4o() {
                return this.urlLid;
            }

            public int hashCode() {
                return (LocalizationKey.m197hashCodeimpl(this.urlLid) * 31) + this.method.hashCode();
            }

            public String toString() {
                return "Url(urlLid=" + ((Object) LocalizationKey.m198toStringimpl(this.urlLid)) + ", method=" + this.method + ')';
            }

            public /* synthetic */ Url(String str, UrlMethod urlMethod, AbstractC1585j abstractC1585j) {
                this(str, urlMethod);
            }

            private Url(int i4, String str, UrlMethod urlMethod, k0 k0Var) {
                if (3 != (i4 & 3)) {
                    AbstractC0325a0.a(i4, 3, ButtonComponent$Destination$Url$$serializer.INSTANCE.getDescriptor());
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
        private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

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

            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
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

    public /* synthetic */ ButtonComponent(int i4, Action action, StackComponent stackComponent, PaywallTransition paywallTransition, k0 k0Var) {
        if (3 != (i4 & 3)) {
            AbstractC0325a0.a(i4, 3, ButtonComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.action = action;
        this.stack = stackComponent;
        if ((i4 & 4) == 0) {
            this.transition = null;
        } else {
            this.transition = paywallTransition;
        }
    }

    public static final /* synthetic */ void write$Self(ButtonComponent buttonComponent, d dVar, H3.e eVar) {
        dVar.u(eVar, 0, ActionSerializer.INSTANCE, buttonComponent.action);
        dVar.u(eVar, 1, StackComponent$$serializer.INSTANCE, buttonComponent.stack);
        if (!dVar.j(eVar, 2) && buttonComponent.transition == null) {
            return;
        }
        dVar.E(eVar, 2, PaywallTransition$$serializer.INSTANCE, buttonComponent.transition);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonComponent)) {
            return false;
        }
        ButtonComponent buttonComponent = (ButtonComponent) obj;
        return r.b(this.action, buttonComponent.action) && r.b(this.stack, buttonComponent.stack) && r.b(this.transition, buttonComponent.transition);
    }

    public final /* synthetic */ Action getAction() {
        return this.action;
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public final /* synthetic */ PaywallTransition getTransition() {
        return this.transition;
    }

    public int hashCode() {
        int iHashCode = ((this.action.hashCode() * 31) + this.stack.hashCode()) * 31;
        PaywallTransition paywallTransition = this.transition;
        return iHashCode + (paywallTransition == null ? 0 : paywallTransition.hashCode());
    }

    public String toString() {
        return "ButtonComponent(action=" + this.action + ", stack=" + this.stack + ", transition=" + this.transition + ')';
    }

    public ButtonComponent(Action action, StackComponent stack, PaywallTransition paywallTransition) {
        r.f(action, "action");
        r.f(stack, "stack");
        this.action = action;
        this.stack = stack;
        this.transition = paywallTransition;
    }

    public /* synthetic */ ButtonComponent(Action action, StackComponent stackComponent, PaywallTransition paywallTransition, int i4, AbstractC1585j abstractC1585j) {
        this(action, stackComponent, (i4 & 4) != 0 ? null : paywallTransition);
    }
}
