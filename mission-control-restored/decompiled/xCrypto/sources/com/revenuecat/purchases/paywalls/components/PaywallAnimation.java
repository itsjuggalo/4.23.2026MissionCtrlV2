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
public final class PaywallAnimation {
    public static final Companion Companion = new Companion(null);
    private final int msDelay;
    private final int msDuration;
    private final AnimationType type;

    public enum AnimationType {
        EASE_IN,
        EASE_OUT,
        EASE_IN_OUT,
        LINEAR;

        public static final Companion Companion = new Companion(null);
        private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

        public static final class Companion {

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.PaywallAnimation$AnimationType$Companion$1, reason: invalid class name */
            public static final class AnonymousClass1 extends s implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return AnimationTypeSerializer.INSTANCE;
                }
            }

            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            private final /* synthetic */ b get$cachedSerializer() {
                return (b) AnimationType.$cachedSerializer$delegate.getValue();
            }

            public final b serializer() {
                return get$cachedSerializer();
            }

            private Companion() {
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return PaywallAnimation$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PaywallAnimation(int i4, AnimationType animationType, int i5, int i6, k0 k0Var) {
        if (7 != (i4 & 7)) {
            AbstractC0325a0.a(i4, 7, PaywallAnimation$$serializer.INSTANCE.getDescriptor());
        }
        this.type = animationType;
        this.msDelay = i5;
        this.msDuration = i6;
    }

    public static /* synthetic */ void getMsDelay$annotations() {
    }

    public static /* synthetic */ void getMsDuration$annotations() {
    }

    public static final /* synthetic */ void write$Self(PaywallAnimation paywallAnimation, d dVar, e eVar) {
        dVar.u(eVar, 0, AnimationTypeSerializer.INSTANCE, paywallAnimation.type);
        dVar.k(eVar, 1, paywallAnimation.msDelay);
        dVar.k(eVar, 2, paywallAnimation.msDuration);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallAnimation)) {
            return false;
        }
        PaywallAnimation paywallAnimation = (PaywallAnimation) obj;
        return this.type == paywallAnimation.type && this.msDelay == paywallAnimation.msDelay && this.msDuration == paywallAnimation.msDuration;
    }

    public final /* synthetic */ int getMsDelay() {
        return this.msDelay;
    }

    public final /* synthetic */ int getMsDuration() {
        return this.msDuration;
    }

    public final /* synthetic */ AnimationType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + Integer.hashCode(this.msDelay)) * 31) + Integer.hashCode(this.msDuration);
    }

    public String toString() {
        return "PaywallAnimation(type=" + this.type + ", msDelay=" + this.msDelay + ", msDuration=" + this.msDuration + ')';
    }

    public PaywallAnimation(AnimationType type, int i4, int i5) {
        r.f(type, "type");
        this.type = type;
        this.msDelay = i4;
        this.msDuration = i5;
    }
}
