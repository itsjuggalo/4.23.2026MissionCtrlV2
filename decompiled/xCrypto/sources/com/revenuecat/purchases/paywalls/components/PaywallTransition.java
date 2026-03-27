package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import W2.j;
import W2.k;
import W2.l;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class PaywallTransition {
    public static final Companion Companion = new Companion(null);
    private final PaywallAnimation animation;
    private final DisplacementStrategy displacementStrategy;
    private final TransitionType type;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return PaywallTransition$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public enum DisplacementStrategy {
        GREEDY,
        LAZY;

        public static final Companion Companion = new Companion(null);
        private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

        public static final class Companion {

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.PaywallTransition$DisplacementStrategy$Companion$1, reason: invalid class name */
            public static final class AnonymousClass1 extends s implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return DisplacementStrategyDeserializer.INSTANCE;
                }
            }

            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            private final /* synthetic */ b get$cachedSerializer() {
                return (b) DisplacementStrategy.$cachedSerializer$delegate.getValue();
            }

            public final b serializer() {
                return get$cachedSerializer();
            }

            private Companion() {
            }
        }
    }

    public enum TransitionType {
        FADE,
        FADE_AND_SCALE,
        SCALE,
        SLIDE;

        public static final Companion Companion = new Companion(null);
        private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

        public static final class Companion {

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.PaywallTransition$TransitionType$Companion$1, reason: invalid class name */
            public static final class AnonymousClass1 extends s implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return TransitionTypeSerializer.INSTANCE;
                }
            }

            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            private final /* synthetic */ b get$cachedSerializer() {
                return (b) TransitionType.$cachedSerializer$delegate.getValue();
            }

            public final b serializer() {
                return get$cachedSerializer();
            }

            private Companion() {
            }
        }
    }

    public /* synthetic */ PaywallTransition(int i4, TransitionType transitionType, DisplacementStrategy displacementStrategy, PaywallAnimation paywallAnimation, k0 k0Var) {
        if (2 != (i4 & 2)) {
            AbstractC0325a0.a(i4, 2, PaywallTransition$$serializer.INSTANCE.getDescriptor());
        }
        this.type = (i4 & 1) == 0 ? TransitionType.FADE : transitionType;
        this.displacementStrategy = displacementStrategy;
        if ((i4 & 4) == 0) {
            this.animation = null;
        } else {
            this.animation = paywallAnimation;
        }
    }

    public static /* synthetic */ void getDisplacementStrategy$annotations() {
    }

    public static final /* synthetic */ void write$Self(PaywallTransition paywallTransition, d dVar, e eVar) {
        if (dVar.j(eVar, 0) || paywallTransition.type != TransitionType.FADE) {
            dVar.u(eVar, 0, TransitionTypeSerializer.INSTANCE, paywallTransition.type);
        }
        dVar.u(eVar, 1, DisplacementStrategyDeserializer.INSTANCE, paywallTransition.displacementStrategy);
        if (!dVar.j(eVar, 2) && paywallTransition.animation == null) {
            return;
        }
        dVar.E(eVar, 2, PaywallAnimation$$serializer.INSTANCE, paywallTransition.animation);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallTransition)) {
            return false;
        }
        PaywallTransition paywallTransition = (PaywallTransition) obj;
        return this.type == paywallTransition.type && this.displacementStrategy == paywallTransition.displacementStrategy && r.b(this.animation, paywallTransition.animation);
    }

    public final /* synthetic */ PaywallAnimation getAnimation() {
        return this.animation;
    }

    public final /* synthetic */ DisplacementStrategy getDisplacementStrategy() {
        return this.displacementStrategy;
    }

    public final /* synthetic */ TransitionType getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((this.type.hashCode() * 31) + this.displacementStrategy.hashCode()) * 31;
        PaywallAnimation paywallAnimation = this.animation;
        return iHashCode + (paywallAnimation == null ? 0 : paywallAnimation.hashCode());
    }

    public String toString() {
        return "PaywallTransition(type=" + this.type + ", displacementStrategy=" + this.displacementStrategy + ", animation=" + this.animation + ')';
    }

    public PaywallTransition(TransitionType type, DisplacementStrategy displacementStrategy, PaywallAnimation paywallAnimation) {
        r.f(type, "type");
        r.f(displacementStrategy, "displacementStrategy");
        this.type = type;
        this.displacementStrategy = displacementStrategy;
        this.animation = paywallAnimation;
    }

    public /* synthetic */ PaywallTransition(TransitionType transitionType, DisplacementStrategy displacementStrategy, PaywallAnimation paywallAnimation, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? TransitionType.FADE : transitionType, displacementStrategy, (i4 & 4) != 0 ? null : paywallAnimation);
    }
}
