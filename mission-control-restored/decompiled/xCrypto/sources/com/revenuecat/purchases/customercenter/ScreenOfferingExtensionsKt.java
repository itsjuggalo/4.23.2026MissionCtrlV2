package com.revenuecat.purchases.customercenter;

import W2.E;
import W2.m;
import com.revenuecat.purchases.ListenerConversionsCommonKt;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class ScreenOfferingExtensionsKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.customercenter.ScreenOfferingExtensionsKt$resolveOffering$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.customercenter.ScreenOfferingExtensionsKt$resolveOffering$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements k {
        final /* synthetic */ k $onSuccess;
        final /* synthetic */ CustomerCenterConfigData.ScreenOffering $screenOffering;

        /* JADX INFO: renamed from: com.revenuecat.purchases.customercenter.ScreenOfferingExtensionsKt$resolveOffering$2$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.values().length];
                try {
                    iArr[CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.CURRENT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.SPECIFIC.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(CustomerCenterConfigData.ScreenOffering screenOffering, k kVar) {
            super(1);
            this.$screenOffering = screenOffering;
            this.$onSuccess = kVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Offerings) obj);
            return E.f5463a;
        }

        public final void invoke(Offerings offerings) {
            Offering current;
            r.f(offerings, "offerings");
            int i4 = WhenMappings.$EnumSwitchMapping$0[this.$screenOffering.getType().ordinal()];
            if (i4 == 1) {
                current = offerings.getCurrent();
            } else {
                if (i4 != 2) {
                    throw new m();
                }
                String offeringId = this.$screenOffering.getOfferingId();
                current = offeringId != null ? offerings.getAll().get(offeringId) : null;
            }
            this.$onSuccess.invoke(current);
        }
    }

    public static final void resolveOffering(CustomerCenterConfigData.Screen screen, Purchases purchases, k onError, k onSuccess) {
        r.f(screen, "<this>");
        r.f(purchases, "purchases");
        r.f(onError, "onError");
        r.f(onSuccess, "onSuccess");
        CustomerCenterConfigData.ScreenOffering offering = screen.getOffering();
        if (offering == null) {
            onSuccess.invoke(null);
        } else {
            ListenerConversionsCommonKt.getOfferingsWith(purchases, onError, new AnonymousClass2(offering, onSuccess));
        }
    }

    public static /* synthetic */ void resolveOffering$default(CustomerCenterConfigData.Screen screen, Purchases purchases, k kVar, k kVar2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            kVar = AnonymousClass1.INSTANCE;
        }
        resolveOffering(screen, purchases, kVar, kVar2);
    }
}
