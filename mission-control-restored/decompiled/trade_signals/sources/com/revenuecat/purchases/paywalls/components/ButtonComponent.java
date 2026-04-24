package com.revenuecat.purchases.paywalls.components;

import I5.d;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import java.lang.annotation.Annotation;
import k7.b;
import k7.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import kotlin.jvm.internal.O;
import m7.e;
import o5.AbstractC2484l;
import o5.EnumC2486n;
import o5.InterfaceC2483k;
import o7.AbstractC2504f0;
import o7.C2498c0;
import o7.t0;
import o7.x0;

/* JADX INFO: loaded from: classes.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0005\u001d\u001e\u001c\u001f B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0011\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ(\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010HÁ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "action", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "stack", "<init>", "(Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;Lcom/revenuecat/purchases/paywalls/components/StackComponent;)V", "", "seen1", "Lo7/t0;", "serializationConstructorMarker", "(ILcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;Lcom/revenuecat/purchases/paywalls/components/StackComponent;Lo7/t0;)V", "self", "Ln7/d;", "output", "Lm7/e;", "serialDesc", "Lo5/H;", "write$Self$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/paywalls/components/ButtonComponent;Ln7/d;Lm7/e;)V", "write$Self", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "getAction", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "getStack", "()Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "Companion", "$serializer", "Action", "Destination", "UrlMethod", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class ButtonComponent implements PaywallComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Action action;
    private final StackComponent stack;

    @InternalRevenueCatAPI
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "", "Companion", "NavigateBack", "NavigateTo", "RestorePurchases", "Unknown", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$NavigateBack;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$NavigateTo;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$RestorePurchases;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$Unknown;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Action {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$Companion;", "", "<init>", "()V", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final b serializer() {
                return ActionSerializer.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$NavigateBack;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "<init>", "()V", "Lk7/b;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
        public static final class NavigateBack implements Action {
            public static final NavigateBack INSTANCE = new NavigateBack();
            private static final /* synthetic */ InterfaceC2483k $cachedSerializer$delegate = AbstractC2484l.b(EnumC2486n.f21975b, AnonymousClass1.INSTANCE);

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.ButtonComponent$Action$NavigateBack$1, reason: invalid class name */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public static final class AnonymousClass1 extends AbstractC2306v implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return new C2498c0("com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.NavigateBack", NavigateBack.INSTANCE, new Annotation[0]);
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

        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002%$B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0011\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ(\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eHÁ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0015¨\u0006&"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$NavigateTo;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", FirebaseAnalytics.Param.DESTINATION, "<init>", "(Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;)V", "", "seen1", "Lo7/t0;", "serializationConstructorMarker", "(ILcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;Lo7/t0;)V", "self", "Ln7/d;", "output", "Lm7/e;", "serialDesc", "Lo5/H;", "write$Self$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$NavigateTo;Ln7/d;Lm7/e;)V", "write$Self", "component1", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "copy", "(Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;)Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$NavigateTo;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "getDestination", "Companion", "$serializer", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
        public static final /* data */ class NavigateTo implements Action {
            private final Destination destination;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final b[] $childSerializers = {new h("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination", O.b(Destination.class), new d[]{O.b(Destination.CustomerCenter.class), O.b(Destination.PrivacyPolicy.class), O.b(Destination.Sheet.class), O.b(Destination.Terms.class), O.b(Destination.Unknown.class), O.b(Destination.Url.class)}, new b[]{new C2498c0("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.CustomerCenter", Destination.CustomerCenter.INSTANCE, new Annotation[0]), ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, ButtonComponent$Destination$Terms$$serializer.INSTANCE, new C2498c0("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Unknown", Destination.Unknown.INSTANCE, new Annotation[0]), ButtonComponent$Destination$Url$$serializer.INSTANCE}, new Annotation[0])};

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$NavigateTo$Companion;", "", "<init>", "()V", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$NavigateTo;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
            public static final class Companion {
                private Companion() {
                }

                public final b serializer() {
                    return ButtonComponent$Action$NavigateTo$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
                    this();
                }
            }

            public /* synthetic */ NavigateTo(int i8, Destination destination, t0 t0Var) {
                if (1 != (i8 & 1)) {
                    AbstractC2504f0.a(i8, 1, ButtonComponent$Action$NavigateTo$$serializer.INSTANCE.getDescriptor());
                }
                this.destination = destination;
            }

            public static /* synthetic */ NavigateTo copy$default(NavigateTo navigateTo, Destination destination, int i8, Object obj) {
                if ((i8 & 1) != 0) {
                    destination = navigateTo.destination;
                }
                return navigateTo.copy(destination);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Destination getDestination() {
                return this.destination;
            }

            public final NavigateTo copy(Destination destination) {
                AbstractC2304t.f(destination, "destination");
                return new NavigateTo(destination);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateTo) && AbstractC2304t.b(this.destination, ((NavigateTo) other).destination);
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
                AbstractC2304t.f(destination, "destination");
                this.destination = destination;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$RestorePurchases;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "<init>", "()V", "Lk7/b;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
        public static final class RestorePurchases implements Action {
            public static final RestorePurchases INSTANCE = new RestorePurchases();
            private static final /* synthetic */ InterfaceC2483k $cachedSerializer$delegate = AbstractC2484l.b(EnumC2486n.f21975b, AnonymousClass1.INSTANCE);

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.ButtonComponent$Action$RestorePurchases$1, reason: invalid class name */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public static final class AnonymousClass1 extends AbstractC2306v implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return new C2498c0("com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.RestorePurchases", RestorePurchases.INSTANCE, new Annotation[0]);
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

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$Unknown;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "<init>", "()V", "Lk7/b;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
        public static final class Unknown implements Action {
            public static final Unknown INSTANCE = new Unknown();
            private static final /* synthetic */ InterfaceC2483k $cachedSerializer$delegate = AbstractC2484l.b(EnumC2486n.f21975b, AnonymousClass1.INSTANCE);

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.ButtonComponent$Action$Unknown$1, reason: invalid class name */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public static final class AnonymousClass1 extends AbstractC2306v implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return new C2498c0("com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.Unknown", Unknown.INSTANCE, new Annotation[0]);
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Companion;", "", "<init>", "()V", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return ButtonComponent$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    @InternalRevenueCatAPI
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0007\u0002\u0003\u0004\u0005\u0006\u0007\b\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "", "Companion", "CustomerCenter", "PrivacyPolicy", "Sheet", "Terms", "Unknown", "Url", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$CustomerCenter;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$PrivacyPolicy;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Terms;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Unknown;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Url;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Destination {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Companion;", "", "<init>", "()V", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final b serializer() {
                return new h("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination", O.b(Destination.class), new d[]{O.b(CustomerCenter.class), O.b(PrivacyPolicy.class), O.b(Sheet.class), O.b(Terms.class), O.b(Unknown.class), O.b(Url.class)}, new b[]{new C2498c0("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.CustomerCenter", CustomerCenter.INSTANCE, new Annotation[0]), ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, ButtonComponent$Destination$Terms$$serializer.INSTANCE, new C2498c0("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Unknown", Unknown.INSTANCE, new Annotation[0]), ButtonComponent$Destination$Url$$serializer.INSTANCE}, new Annotation[0]);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$CustomerCenter;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "<init>", "()V", "Lk7/b;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
        public static final class CustomerCenter implements Destination {
            public static final CustomerCenter INSTANCE = new CustomerCenter();
            private static final /* synthetic */ InterfaceC2483k $cachedSerializer$delegate = AbstractC2484l.b(EnumC2486n.f21975b, AnonymousClass1.INSTANCE);

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.ButtonComponent$Destination$CustomerCenter$1, reason: invalid class name */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public static final class AnonymousClass1 extends AbstractC2306v implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return new C2498c0("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.CustomerCenter", CustomerCenter.INSTANCE, new Annotation[0]);
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

        @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002,+B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0011\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ(\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010HÁ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0018\u001a\u00020\u0002HÆ\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u0010\u0010 \u001a\u00020\bHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b%\u0010&R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010\u001a\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$PrivacyPolicy;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "urlLid", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", FirebaseAnalytics.Param.METHOD, "<init>", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lkotlin/jvm/internal/k;)V", "", "seen1", "Lo7/t0;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lo7/t0;Lkotlin/jvm/internal/k;)V", "self", "Ln7/d;", "output", "Lm7/e;", "serialDesc", "Lo5/H;", "write$Self$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$PrivacyPolicy;Ln7/d;Lm7/e;)V", "write$Self", "component1-z7Tp-4o", "()Ljava/lang/String;", "component1", "component2", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "copy-26kQY28", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$PrivacyPolicy;", "copy", "", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUrlLid-z7Tp-4o", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "getMethod", "Companion", "$serializer", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
        public static final /* data */ class PrivacyPolicy implements Destination {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final UrlMethod method;
            private final String urlLid;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$PrivacyPolicy$Companion;", "", "<init>", "()V", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$PrivacyPolicy;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
            public static final class Companion {
                private Companion() {
                }

                public final b serializer() {
                    return ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
                    this();
                }
            }

            private PrivacyPolicy(int i8, String str, UrlMethod urlMethod, t0 t0Var) {
                if (3 != (i8 & 3)) {
                    AbstractC2504f0.a(i8, 3, ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE.getDescriptor());
                }
                this.urlLid = str;
                this.method = urlMethod;
            }

            /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
            public static /* synthetic */ PrivacyPolicy m102copy26kQY28$default(PrivacyPolicy privacyPolicy, String str, UrlMethod urlMethod, int i8, Object obj) {
                if ((i8 & 1) != 0) {
                    str = privacyPolicy.urlLid;
                }
                if ((i8 & 2) != 0) {
                    urlMethod = privacyPolicy.method;
                }
                return privacyPolicy.m104copy26kQY28(str, urlMethod);
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsRelease(PrivacyPolicy self, n7.d output, e serialDesc) {
                output.B(serialDesc, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m158boximpl(self.urlLid));
                output.B(serialDesc, 1, UrlMethodDeserializer.INSTANCE, self.method);
            }

            /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name and from getter */
            public final String getUrlLid() {
                return this.urlLid;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
            public final PrivacyPolicy m104copy26kQY28(String urlLid, UrlMethod method) {
                AbstractC2304t.f(urlLid, "urlLid");
                AbstractC2304t.f(method, "method");
                return new PrivacyPolicy(urlLid, method, null);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PrivacyPolicy)) {
                    return false;
                }
                PrivacyPolicy privacyPolicy = (PrivacyPolicy) other;
                return LocalizationKey.m161equalsimpl0(this.urlLid, privacyPolicy.urlLid) && this.method == privacyPolicy.method;
            }

            public final /* synthetic */ UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
            public final /* synthetic */ String m105getUrlLidz7Tp4o() {
                return this.urlLid;
            }

            public int hashCode() {
                return (LocalizationKey.m162hashCodeimpl(this.urlLid) * 31) + this.method.hashCode();
            }

            public String toString() {
                return "PrivacyPolicy(urlLid=" + ((Object) LocalizationKey.m163toStringimpl(this.urlLid)) + ", method=" + this.method + ')';
            }

            public /* synthetic */ PrivacyPolicy(int i8, String str, UrlMethod urlMethod, t0 t0Var, AbstractC2296k abstractC2296k) {
                this(i8, str, urlMethod, t0Var);
            }

            private PrivacyPolicy(String urlLid, UrlMethod method) {
                AbstractC2304t.f(urlLid, "urlLid");
                AbstractC2304t.f(method, "method");
                this.urlLid = urlLid;
                this.method = method;
            }

            public /* synthetic */ PrivacyPolicy(String str, UrlMethod urlMethod, AbstractC2296k abstractC2296k) {
                this(str, urlMethod);
            }
        }

        @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000298B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fBM\b\u0011\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0011J(\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015HÁ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b \u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\"\u0010#JF\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010\u001cJ\u0010\u0010'\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003¢\u0006\u0004\b+\u0010,R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010\u001cR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010-\u001a\u0004\b/\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u00100\u001a\u0004\b1\u0010\u001fR \u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\b\u00102\u0012\u0004\b4\u00105\u001a\u0004\b3\u0010!R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u00106\u001a\u0004\b7\u0010#¨\u0006:"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "", DiagnosticsEntry.ID_KEY, "name", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "stack", "", "backgroundBlur", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "size", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/StackComponent;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;)V", "", "seen1", "Lo7/t0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/StackComponent;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;Lo7/t0;)V", "self", "Ln7/d;", "output", "Lm7/e;", "serialDesc", "Lo5/H;", "write$Self$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet;Ln7/d;Lm7/e;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "()Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "component4", "()Z", "component5", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/StackComponent;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;)Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getName", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "getStack", "Z", "getBackgroundBlur", "getBackgroundBlur$annotations", "()V", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "Companion", "$serializer", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
        public static final /* data */ class Sheet implements Destination {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final boolean backgroundBlur;
            private final String id;
            private final String name;
            private final Size size;
            private final StackComponent stack;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet$Companion;", "", "<init>", "()V", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
            public static final class Companion {
                private Companion() {
                }

                public final b serializer() {
                    return ButtonComponent$Destination$Sheet$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
                    this();
                }
            }

            public /* synthetic */ Sheet(int i8, String str, String str2, StackComponent stackComponent, boolean z7, Size size, t0 t0Var) {
                if (31 != (i8 & 31)) {
                    AbstractC2504f0.a(i8, 31, ButtonComponent$Destination$Sheet$$serializer.INSTANCE.getDescriptor());
                }
                this.id = str;
                this.name = str2;
                this.stack = stackComponent;
                this.backgroundBlur = z7;
                this.size = size;
            }

            public static /* synthetic */ Sheet copy$default(Sheet sheet, String str, String str2, StackComponent stackComponent, boolean z7, Size size, int i8, Object obj) {
                if ((i8 & 1) != 0) {
                    str = sheet.id;
                }
                if ((i8 & 2) != 0) {
                    str2 = sheet.name;
                }
                String str3 = str2;
                if ((i8 & 4) != 0) {
                    stackComponent = sheet.stack;
                }
                StackComponent stackComponent2 = stackComponent;
                if ((i8 & 8) != 0) {
                    z7 = sheet.backgroundBlur;
                }
                boolean z8 = z7;
                if ((i8 & 16) != 0) {
                    size = sheet.size;
                }
                return sheet.copy(str, str3, stackComponent2, z8, size);
            }

            public static /* synthetic */ void getBackgroundBlur$annotations() {
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsRelease(Sheet self, n7.d output, e serialDesc) {
                output.g(serialDesc, 0, self.id);
                output.u(serialDesc, 1, x0.f22227a, self.name);
                output.B(serialDesc, 2, StackComponent$$serializer.INSTANCE, self.stack);
                output.t(serialDesc, 3, self.backgroundBlur);
                output.u(serialDesc, 4, Size$$serializer.INSTANCE, self.size);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final StackComponent getStack() {
                return this.stack;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getBackgroundBlur() {
                return this.backgroundBlur;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Size getSize() {
                return this.size;
            }

            public final Sheet copy(String id, String name, StackComponent stack, boolean backgroundBlur, Size size) {
                AbstractC2304t.f(id, "id");
                AbstractC2304t.f(stack, "stack");
                return new Sheet(id, name, stack, backgroundBlur, size);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Sheet)) {
                    return false;
                }
                Sheet sheet = (Sheet) other;
                return AbstractC2304t.b(this.id, sheet.id) && AbstractC2304t.b(this.name, sheet.name) && AbstractC2304t.b(this.stack, sheet.stack) && this.backgroundBlur == sheet.backgroundBlur && AbstractC2304t.b(this.size, sheet.size);
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

            public int hashCode() {
                int iHashCode = this.id.hashCode() * 31;
                String str = this.name;
                int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.stack.hashCode()) * 31) + Boolean.hashCode(this.backgroundBlur)) * 31;
                Size size = this.size;
                return iHashCode2 + (size != null ? size.hashCode() : 0);
            }

            public String toString() {
                return "Sheet(id=" + this.id + ", name=" + this.name + ", stack=" + this.stack + ", backgroundBlur=" + this.backgroundBlur + ", size=" + this.size + ')';
            }

            public Sheet(String id, String str, StackComponent stack, boolean z7, Size size) {
                AbstractC2304t.f(id, "id");
                AbstractC2304t.f(stack, "stack");
                this.id = id;
                this.name = str;
                this.stack = stack;
                this.backgroundBlur = z7;
                this.size = size;
            }
        }

        @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002,+B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0011\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ(\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010HÁ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0018\u001a\u00020\u0002HÆ\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u0010\u0010 \u001a\u00020\bHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b%\u0010&R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010\u001a\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Terms;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "urlLid", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", FirebaseAnalytics.Param.METHOD, "<init>", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lkotlin/jvm/internal/k;)V", "", "seen1", "Lo7/t0;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lo7/t0;Lkotlin/jvm/internal/k;)V", "self", "Ln7/d;", "output", "Lm7/e;", "serialDesc", "Lo5/H;", "write$Self$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Terms;Ln7/d;Lm7/e;)V", "write$Self", "component1-z7Tp-4o", "()Ljava/lang/String;", "component1", "component2", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "copy-26kQY28", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Terms;", "copy", "", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUrlLid-z7Tp-4o", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "getMethod", "Companion", "$serializer", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
        public static final /* data */ class Terms implements Destination {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final UrlMethod method;
            private final String urlLid;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Terms$Companion;", "", "<init>", "()V", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Terms;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
            public static final class Companion {
                private Companion() {
                }

                public final b serializer() {
                    return ButtonComponent$Destination$Terms$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
                    this();
                }
            }

            private Terms(int i8, String str, UrlMethod urlMethod, t0 t0Var) {
                if (3 != (i8 & 3)) {
                    AbstractC2504f0.a(i8, 3, ButtonComponent$Destination$Terms$$serializer.INSTANCE.getDescriptor());
                }
                this.urlLid = str;
                this.method = urlMethod;
            }

            /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
            public static /* synthetic */ Terms m106copy26kQY28$default(Terms terms, String str, UrlMethod urlMethod, int i8, Object obj) {
                if ((i8 & 1) != 0) {
                    str = terms.urlLid;
                }
                if ((i8 & 2) != 0) {
                    urlMethod = terms.method;
                }
                return terms.m108copy26kQY28(str, urlMethod);
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsRelease(Terms self, n7.d output, e serialDesc) {
                output.B(serialDesc, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m158boximpl(self.urlLid));
                output.B(serialDesc, 1, UrlMethodDeserializer.INSTANCE, self.method);
            }

            /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name and from getter */
            public final String getUrlLid() {
                return this.urlLid;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
            public final Terms m108copy26kQY28(String urlLid, UrlMethod method) {
                AbstractC2304t.f(urlLid, "urlLid");
                AbstractC2304t.f(method, "method");
                return new Terms(urlLid, method, null);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Terms)) {
                    return false;
                }
                Terms terms = (Terms) other;
                return LocalizationKey.m161equalsimpl0(this.urlLid, terms.urlLid) && this.method == terms.method;
            }

            public final /* synthetic */ UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
            public final /* synthetic */ String m109getUrlLidz7Tp4o() {
                return this.urlLid;
            }

            public int hashCode() {
                return (LocalizationKey.m162hashCodeimpl(this.urlLid) * 31) + this.method.hashCode();
            }

            public String toString() {
                return "Terms(urlLid=" + ((Object) LocalizationKey.m163toStringimpl(this.urlLid)) + ", method=" + this.method + ')';
            }

            public /* synthetic */ Terms(int i8, String str, UrlMethod urlMethod, t0 t0Var, AbstractC2296k abstractC2296k) {
                this(i8, str, urlMethod, t0Var);
            }

            private Terms(String urlLid, UrlMethod method) {
                AbstractC2304t.f(urlLid, "urlLid");
                AbstractC2304t.f(method, "method");
                this.urlLid = urlLid;
                this.method = method;
            }

            public /* synthetic */ Terms(String str, UrlMethod urlMethod, AbstractC2296k abstractC2296k) {
                this(str, urlMethod);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Unknown;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "<init>", "()V", "Lk7/b;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
        public static final class Unknown implements Destination {
            public static final Unknown INSTANCE = new Unknown();
            private static final /* synthetic */ InterfaceC2483k $cachedSerializer$delegate = AbstractC2484l.b(EnumC2486n.f21975b, AnonymousClass1.INSTANCE);

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.ButtonComponent$Destination$Unknown$1, reason: invalid class name */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public static final class AnonymousClass1 extends AbstractC2306v implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return new C2498c0("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Unknown", Unknown.INSTANCE, new Annotation[0]);
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

        @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002,+B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0011\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ(\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010HÁ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0018\u001a\u00020\u0002HÆ\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u0010\u0010 \u001a\u00020\bHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b%\u0010&R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010\u001a\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Url;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "urlLid", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", FirebaseAnalytics.Param.METHOD, "<init>", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lkotlin/jvm/internal/k;)V", "", "seen1", "Lo7/t0;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lo7/t0;Lkotlin/jvm/internal/k;)V", "self", "Ln7/d;", "output", "Lm7/e;", "serialDesc", "Lo5/H;", "write$Self$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Url;Ln7/d;Lm7/e;)V", "write$Self", "component1-z7Tp-4o", "()Ljava/lang/String;", "component1", "component2", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "copy-26kQY28", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Url;", "copy", "", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUrlLid-z7Tp-4o", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "getMethod", "Companion", "$serializer", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
        public static final /* data */ class Url implements Destination {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final UrlMethod method;
            private final String urlLid;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Url$Companion;", "", "<init>", "()V", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Url;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
            public static final class Companion {
                private Companion() {
                }

                public final b serializer() {
                    return ButtonComponent$Destination$Url$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
                    this();
                }
            }

            private Url(int i8, String str, UrlMethod urlMethod, t0 t0Var) {
                if (3 != (i8 & 3)) {
                    AbstractC2504f0.a(i8, 3, ButtonComponent$Destination$Url$$serializer.INSTANCE.getDescriptor());
                }
                this.urlLid = str;
                this.method = urlMethod;
            }

            /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
            public static /* synthetic */ Url m110copy26kQY28$default(Url url, String str, UrlMethod urlMethod, int i8, Object obj) {
                if ((i8 & 1) != 0) {
                    str = url.urlLid;
                }
                if ((i8 & 2) != 0) {
                    urlMethod = url.method;
                }
                return url.m112copy26kQY28(str, urlMethod);
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsRelease(Url self, n7.d output, e serialDesc) {
                output.B(serialDesc, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m158boximpl(self.urlLid));
                output.B(serialDesc, 1, UrlMethodDeserializer.INSTANCE, self.method);
            }

            /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name and from getter */
            public final String getUrlLid() {
                return this.urlLid;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
            public final Url m112copy26kQY28(String urlLid, UrlMethod method) {
                AbstractC2304t.f(urlLid, "urlLid");
                AbstractC2304t.f(method, "method");
                return new Url(urlLid, method, null);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Url)) {
                    return false;
                }
                Url url = (Url) other;
                return LocalizationKey.m161equalsimpl0(this.urlLid, url.urlLid) && this.method == url.method;
            }

            public final /* synthetic */ UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
            public final /* synthetic */ String m113getUrlLidz7Tp4o() {
                return this.urlLid;
            }

            public int hashCode() {
                return (LocalizationKey.m162hashCodeimpl(this.urlLid) * 31) + this.method.hashCode();
            }

            public String toString() {
                return "Url(urlLid=" + ((Object) LocalizationKey.m163toStringimpl(this.urlLid)) + ", method=" + this.method + ')';
            }

            public /* synthetic */ Url(int i8, String str, UrlMethod urlMethod, t0 t0Var, AbstractC2296k abstractC2296k) {
                this(i8, str, urlMethod, t0Var);
            }

            private Url(String urlLid, UrlMethod method) {
                AbstractC2304t.f(urlLid, "urlLid");
                AbstractC2304t.f(method, "method");
                this.urlLid = urlLid;
                this.method = method;
            }

            public /* synthetic */ Url(String str, UrlMethod urlMethod, AbstractC2296k abstractC2296k) {
                this(str, urlMethod);
            }
        }
    }

    @InternalRevenueCatAPI
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "", "(Ljava/lang/String;I)V", "IN_APP_BROWSER", "EXTERNAL_BROWSER", "DEEP_LINK", "UNKNOWN", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum UrlMethod {
        IN_APP_BROWSER,
        EXTERNAL_BROWSER,
        DEEP_LINK,
        UNKNOWN;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod$Companion;", "", "<init>", "()V", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            private Companion() {
            }

            public final b serializer() {
                return UrlMethodDeserializer.INSTANCE;
            }

            public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
                this();
            }
        }
    }

    public /* synthetic */ ButtonComponent(int i8, Action action, StackComponent stackComponent, t0 t0Var) {
        if (3 != (i8 & 3)) {
            AbstractC2504f0.a(i8, 3, ButtonComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.action = action;
        this.stack = stackComponent;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsRelease(ButtonComponent self, n7.d output, e serialDesc) {
        output.B(serialDesc, 0, ActionSerializer.INSTANCE, self.action);
        output.B(serialDesc, 1, StackComponent$$serializer.INSTANCE, self.stack);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonComponent)) {
            return false;
        }
        ButtonComponent buttonComponent = (ButtonComponent) obj;
        return AbstractC2304t.b(this.action, buttonComponent.action) && AbstractC2304t.b(this.stack, buttonComponent.stack);
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
        AbstractC2304t.f(action, "action");
        AbstractC2304t.f(stack, "stack");
        this.action = action;
        this.stack = stack;
    }
}
