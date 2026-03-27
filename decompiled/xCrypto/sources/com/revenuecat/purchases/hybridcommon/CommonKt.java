package com.revenuecat.purchases.hybridcommon;

import W2.E;
import W2.m;
import W2.t;
import X2.AbstractC0768o;
import X2.AbstractC0770q;
import X2.K;
import X2.L;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.AmazonLWAConsentStatus;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.DangerousSettings;
import com.revenuecat.purchases.EntitlementVerificationMode;
import com.revenuecat.purchases.ListenerConversionsCommonKt;
import com.revenuecat.purchases.ListenerConversionsKt;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesConfiguration;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.WebPurchaseRedemption;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.hybridcommon.mappers.CustomerInfoMapperKt;
import com.revenuecat.purchases.hybridcommon.mappers.LogHandlerWithMapping;
import com.revenuecat.purchases.hybridcommon.mappers.MappedProductCategory;
import com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt;
import com.revenuecat.purchases.hybridcommon.mappers.PurchasesErrorKt;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import com.revenuecat.purchases.models.BillingFeature;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.StoreTransaction;
import i3.k;
import i3.o;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import r3.AbstractC1753A;
import r3.x;

/* JADX INFO: loaded from: classes3.dex */
public final class CommonKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getAmazonLWAConsentStatus$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        final /* synthetic */ OnResultAny<Boolean> $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OnResultAny<Boolean> onResultAny) {
            super(1);
            this.$onResult = onResultAny;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$onResult.onError(PurchasesErrorKt.map$default(it, null, 1, null));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getAmazonLWAConsentStatus$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements k {
        final /* synthetic */ OnResultAny<Boolean> $onResult;

        /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getAmazonLWAConsentStatus$2$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AmazonLWAConsentStatus.values().length];
                try {
                    iArr[AmazonLWAConsentStatus.CONSENTED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AmazonLWAConsentStatus.UNAVAILABLE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(OnResultAny<Boolean> onResultAny) {
            super(1);
            this.$onResult = onResultAny;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AmazonLWAConsentStatus) obj);
            return E.f5463a;
        }

        public final void invoke(AmazonLWAConsentStatus it) {
            r.f(it, "it");
            OnResultAny<Boolean> onResultAny = this.$onResult;
            int i4 = WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
            boolean z4 = true;
            if (i4 != 1) {
                if (i4 != 2) {
                    throw new m();
                }
                z4 = false;
            }
            onResultAny.onReceived(Boolean.valueOf(z4));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getCurrentOfferingForPlacement$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11701 extends s implements k {
        final /* synthetic */ OnNullableResult $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11701(OnNullableResult onNullableResult) {
            super(1);
            this.$onResult = onNullableResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$onResult.onError(PurchasesErrorKt.map$default(it, null, 1, null));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getCurrentOfferingForPlacement$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11712 extends s implements k {
        final /* synthetic */ OnNullableResult $onResult;
        final /* synthetic */ String $placementIdentifier;

        /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getCurrentOfferingForPlacement$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements k {
            final /* synthetic */ OnNullableResult $onResult;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(OnNullableResult onNullableResult) {
                super(1);
                this.$onResult = onNullableResult;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, ? extends Object>) obj);
                return E.f5463a;
            }

            public final void invoke(Map<String, ? extends Object> map) {
                r.f(map, "map");
                this.$onResult.onReceived(map);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11712(String str, OnNullableResult onNullableResult) {
            super(1);
            this.$placementIdentifier = str;
            this.$onResult = onNullableResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Offerings) obj);
            return E.f5463a;
        }

        public final void invoke(Offerings it) {
            r.f(it, "it");
            Offering currentOfferingForPlacement = it.getCurrentOfferingForPlacement(this.$placementIdentifier);
            if (currentOfferingForPlacement != null) {
                OfferingsMapperKt.mapAsync(currentOfferingForPlacement, new AnonymousClass1(this.$onResult));
            } else {
                this.$onResult.onReceived(null);
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getCustomerInfo$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11721 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11721(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$onResult.onError(PurchasesErrorKt.map$default(it, null, 1, null));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getCustomerInfo$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11732 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getCustomerInfo$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements k {
            final /* synthetic */ OnResult $onResult;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(OnResult onResult) {
                super(1);
                this.$onResult = onResult;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, ? extends Object>) obj);
                return E.f5463a;
            }

            public final void invoke(Map<String, ? extends Object> map) {
                r.f(map, "map");
                this.$onResult.onReceived(map);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11732(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CustomerInfo) obj);
            return E.f5463a;
        }

        public final void invoke(CustomerInfo customerInfo) {
            r.f(customerInfo, "customerInfo");
            CustomerInfoMapperKt.mapAsync(customerInfo, new AnonymousClass1(this.$onResult));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getOfferings$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11741 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11741(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$onResult.onError(PurchasesErrorKt.map$default(it, null, 1, null));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getOfferings$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11752 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getOfferings$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements k {
            final /* synthetic */ OnResult $onResult;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(OnResult onResult) {
                super(1);
                this.$onResult = onResult;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, ? extends Object>) obj);
                return E.f5463a;
            }

            public final void invoke(Map<String, ? extends Object> map) {
                r.f(map, "map");
                this.$onResult.onReceived(map);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11752(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Offerings) obj);
            return E.f5463a;
        }

        public final void invoke(Offerings offerings) {
            r.f(offerings, "offerings");
            OfferingsMapperKt.mapAsync(offerings, new AnonymousClass1(this.$onResult));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getPurchaseCompletedFunction$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11761 extends s implements o {
        final /* synthetic */ OnResult $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11761(OnResult onResult) {
            super(2);
            this.$onResult = onResult;
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((StoreTransaction) obj, (CustomerInfo) obj2);
            return E.f5463a;
        }

        public final void invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
            E e4;
            r.f(customerInfo, "customerInfo");
            if (storeTransaction != null) {
                CustomerInfoMapperKt.mapAsync(customerInfo, new CommonKt$getPurchaseCompletedFunction$1$1$1(this.$onResult, storeTransaction));
                e4 = E.f5463a;
            } else {
                e4 = null;
            }
            if (e4 == null) {
                this.$onResult.onError(new ErrorContainer(PurchasesErrorCode.UnsupportedError.getCode(), "Error purchasing. Null transaction returned from a successful non-upgrade purchase.", L.e()));
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getPurchaseErrorFunction$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11771 extends s implements o {
        final /* synthetic */ OnResult $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11771(OnResult onResult) {
            super(2);
            this.$onResult = onResult;
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
            return E.f5463a;
        }

        public final void invoke(PurchasesError error, boolean z4) {
            r.f(error, "error");
            this.$onResult.onError(PurchasesErrorKt.map(error, K.c(t.a("userCancelled", Boolean.valueOf(z4)))));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getStorefront$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11781 extends s implements k {
        final /* synthetic */ k $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11781(k kVar) {
            super(1);
            this.$callback = kVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$callback.invoke(null);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getStorefront$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11792 extends s implements k {
        final /* synthetic */ k $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11792(k kVar) {
            super(1);
            this.$callback = kVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return E.f5463a;
        }

        public final void invoke(String it) {
            r.f(it, "it");
            this.$callback.invoke(K.c(t.a("countryCode", it)));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$logIn$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11801 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11801(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$onResult.onError(PurchasesErrorKt.map$default(it, null, 1, null));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$logIn$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11812 extends s implements o {
        final /* synthetic */ OnResult $onResult;

        /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$logIn$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements k {
            final /* synthetic */ boolean $created;
            final /* synthetic */ OnResult $onResult;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(boolean z4, OnResult onResult) {
                super(1);
                this.$created = z4;
                this.$onResult = onResult;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, ? extends Object>) obj);
                return E.f5463a;
            }

            public final void invoke(Map<String, ? extends Object> map) {
                r.f(map, "map");
                this.$onResult.onReceived(L.g(t.a("customerInfo", map), t.a("created", Boolean.valueOf(this.$created))));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11812(OnResult onResult) {
            super(2);
            this.$onResult = onResult;
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((CustomerInfo) obj, ((Boolean) obj2).booleanValue());
            return E.f5463a;
        }

        public final void invoke(CustomerInfo customerInfo, boolean z4) {
            r.f(customerInfo, "customerInfo");
            CustomerInfoMapperKt.mapAsync(customerInfo, new AnonymousClass1(z4, this.$onResult));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$logOut$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11821 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11821(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$onResult.onError(PurchasesErrorKt.map$default(it, null, 1, null));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$logOut$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11832 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$logOut$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements k {
            final /* synthetic */ OnResult $onResult;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(OnResult onResult) {
                super(1);
                this.$onResult = onResult;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, ? extends Object>) obj);
                return E.f5463a;
            }

            public final void invoke(Map<String, ? extends Object> map) {
                r.f(map, "map");
                this.$onResult.onReceived(map);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11832(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CustomerInfo) obj);
            return E.f5463a;
        }

        public final void invoke(CustomerInfo customerInfo) {
            r.f(customerInfo, "customerInfo");
            CustomerInfoMapperKt.mapAsync(customerInfo, new AnonymousClass1(this.$onResult));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$purchasePackage$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11841 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11841(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$onResult.onError(PurchasesErrorKt.map$default(it, null, 1, null));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$purchasePackage$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11852 extends s implements k {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Boolean $googleIsPersonalizedPrice;
        final /* synthetic */ String $googleOldProductId;
        final /* synthetic */ GoogleReplacementMode $googleReplacementMode;
        final /* synthetic */ OnResult $onResult;
        final /* synthetic */ String $packageIdentifier;
        final /* synthetic */ Map<String, Object> $presentedOfferingContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11852(Map<String, ? extends Object> map, OnResult onResult, Activity activity, String str, GoogleReplacementMode googleReplacementMode, Boolean bool, String str2) {
            super(1);
            this.$presentedOfferingContext = map;
            this.$onResult = onResult;
            this.$activity = activity;
            this.$googleOldProductId = str;
            this.$googleReplacementMode = googleReplacementMode;
            this.$googleIsPersonalizedPrice = bool;
            this.$packageIdentifier = str2;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Offerings) obj);
            return E.f5463a;
        }

        public final void invoke(Offerings offerings) {
            Package r4;
            List<Package> availablePackages;
            Object next;
            r.f(offerings, "offerings");
            PresentedOfferingContext presentedOfferingContext = CommonKt.toPresentedOfferingContext(this.$presentedOfferingContext);
            if (presentedOfferingContext == null) {
                this.$onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, "There is no or invalid presented offering context data provided to make this purchase"), null, 1, null));
                return;
            }
            Offering offering = offerings.get(presentedOfferingContext.getOfferingIdentifier());
            if (offering == null || (availablePackages = offering.getAvailablePackages()) == null) {
                r4 = null;
            } else {
                String str = this.$packageIdentifier;
                Iterator<T> it = availablePackages.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (x.v(((Package) next).getIdentifier(), str, true)) {
                            break;
                        }
                    }
                }
                r4 = (Package) next;
            }
            if (r4 == null) {
                this.$onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "Couldn't find product for package " + this.$packageIdentifier), null, 1, null));
                return;
            }
            PurchaseParams.Builder builder = new PurchaseParams.Builder(this.$activity, r4);
            builder.presentedOfferingContext(presentedOfferingContext);
            String str2 = this.$googleOldProductId;
            if (str2 != null && !AbstractC1753A.U(str2)) {
                builder.oldProductId(this.$googleOldProductId);
                GoogleReplacementMode googleReplacementMode = this.$googleReplacementMode;
                if (googleReplacementMode != null) {
                    builder.googleReplacementMode(googleReplacementMode);
                }
            }
            Boolean bool = this.$googleIsPersonalizedPrice;
            if (bool != null) {
                builder.isPersonalizedPrice(bool.booleanValue());
            }
            ListenerConversionsCommonKt.purchaseWith(Purchases.Companion.getSharedInstance(), builder.build(), CommonKt.getPurchaseErrorFunction(this.$onResult), CommonKt.getPurchaseCompletedFunction(this.$onResult));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$purchaseProduct$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11861 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11861(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$onResult.onError(PurchasesErrorKt.map$default(it, null, 1, null));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$purchaseProduct$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11872 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11872(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$onResult.onError(PurchasesErrorKt.map$default(it, null, 1, null));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$purchaseSubscriptionOption$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11881 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11881(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$onResult.onError(PurchasesErrorKt.map$default(it, null, 1, null));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$restorePurchases$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11891 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11891(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$onResult.onError(PurchasesErrorKt.map$default(it, null, 1, null));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$restorePurchases$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11902 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$restorePurchases$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements k {
            final /* synthetic */ OnResult $onResult;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(OnResult onResult) {
                super(1);
                this.$onResult = onResult;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, ? extends Object>) obj);
                return E.f5463a;
            }

            public final void invoke(Map<String, ? extends Object> map) {
                r.f(map, "map");
                this.$onResult.onReceived(map);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11902(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CustomerInfo) obj);
            return E.f5463a;
        }

        public final void invoke(CustomerInfo customerInfo) {
            r.f(customerInfo, "customerInfo");
            CustomerInfoMapperKt.mapAsync(customerInfo, new AnonymousClass1(this.$onResult));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$setLogHandlerWithOnResult$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11911 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11911(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Map<String, String>) obj);
            return E.f5463a;
        }

        public final void invoke(Map<String, String> logDetails) {
            r.f(logDetails, "logDetails");
            this.$onResult.onReceived(logDetails);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$syncAttributesAndOfferingsIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11921 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11921(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$onResult.onError(PurchasesErrorKt.map$default(it, null, 1, null));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$syncAttributesAndOfferingsIfNeeded$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11932 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$syncAttributesAndOfferingsIfNeeded$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements k {
            final /* synthetic */ OnResult $onResult;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(OnResult onResult) {
                super(1);
                this.$onResult = onResult;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, ? extends Object>) obj);
                return E.f5463a;
            }

            public final void invoke(Map<String, ? extends Object> map) {
                r.f(map, "map");
                this.$onResult.onReceived(map);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11932(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Offerings) obj);
            return E.f5463a;
        }

        public final void invoke(Offerings it) {
            r.f(it, "it");
            OfferingsMapperKt.mapAsync(it, new AnonymousClass1(this.$onResult));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$syncPurchases$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11941 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11941(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$onResult.onError(PurchasesErrorKt.map$default(it, null, 1, null));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$syncPurchases$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11952 extends s implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$syncPurchases$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements k {
            final /* synthetic */ OnResult $onResult;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(OnResult onResult) {
                super(1);
                this.$onResult = onResult;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, ? extends Object>) obj);
                return E.f5463a;
            }

            public final void invoke(Map<String, ? extends Object> map) {
                r.f(map, "map");
                this.$onResult.onReceived(map);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11952(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CustomerInfo) obj);
            return E.f5463a;
        }

        public final void invoke(CustomerInfo customerInfo) {
            r.f(customerInfo, "customerInfo");
            CustomerInfoMapperKt.mapAsync(customerInfo, new AnonymousClass1(this.$onResult));
        }
    }

    public static final void canMakePayments(Context context, List<Integer> features, final OnResultAny<Boolean> onResult) {
        r.f(context, "context");
        r.f(features, "features");
        r.f(onResult, "onResult");
        ArrayList arrayList = new ArrayList();
        try {
            BillingFeature[] billingFeatureArrValues = BillingFeature.values();
            ArrayList arrayList2 = new ArrayList(AbstractC0770q.q(features, 10));
            Iterator<T> it = features.iterator();
            while (it.hasNext()) {
                arrayList2.add(billingFeatureArrValues[((Number) it.next()).intValue()]);
            }
            arrayList.addAll(arrayList2);
            Purchases.Companion.canMakePayments(context, arrayList, new Callback() { // from class: com.revenuecat.purchases.hybridcommon.b
                @Override // com.revenuecat.purchases.interfaces.Callback
                public final void onReceived(Object obj) {
                    CommonKt.canMakePayments$lambda$3(onResult, (Boolean) obj);
                }
            });
        } catch (IndexOutOfBoundsException unused) {
            onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.UnknownError, "Invalid feature type passed to canMakePayments."), null, 1, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void canMakePayments$lambda$3(OnResultAny onResult, Boolean it) {
        r.f(onResult, "$onResult");
        r.e(it, "it");
        onResult.onReceived(it);
    }

    public static final Map<String, Map<String, Object>> checkTrialOrIntroductoryPriceEligibility(List<String> productIdentifiers) {
        r.f(productIdentifiers, "productIdentifiers");
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(productIdentifiers, 10));
        Iterator<T> it = productIdentifiers.iterator();
        while (it.hasNext()) {
            arrayList.add(t.a((String) it.next(), L.g(t.a("status", 0), t.a(com.amazon.a.a.o.b.f8755c, "Status indeterminate."))));
        }
        return L.o(arrayList);
    }

    public static final void configure(Context context, String apiKey, String str, PlatformInfo platformInfo) {
        r.f(context, "context");
        r.f(apiKey, "apiKey");
        r.f(platformInfo, "platformInfo");
        configure$default(context, apiKey, str, null, platformInfo, null, null, null, null, null, null, 2024, null);
    }

    public static /* synthetic */ void configure$default(Context context, String str, String str2, String str3, PlatformInfo platformInfo, Store store, DangerousSettings dangerousSettings, Boolean bool, String str4, Boolean bool2, Boolean bool3, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            str3 = null;
        }
        if ((i4 & 32) != 0) {
            store = Store.PLAY_STORE;
        }
        if ((i4 & 64) != 0) {
            dangerousSettings = new DangerousSettings(true);
        }
        if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0) {
            bool = null;
        }
        if ((i4 & 256) != 0) {
            str4 = null;
        }
        if ((i4 & 512) != 0) {
            bool2 = null;
        }
        if ((i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
            bool3 = null;
        }
        configure(context, str, str2, str3, platformInfo, store, dangerousSettings, bool, str4, bool2, bool3);
    }

    public static final Integer convertToInt(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Double) {
            return Integer.valueOf((int) ((Number) obj).doubleValue());
        }
        return null;
    }

    public static final void errorLog(String message) {
        r.f(message, "message");
        if (Purchases.Companion.getLogLevel().compareTo(LogLevel.ERROR) <= 0) {
            Log.e("PurchasesHybridCommon", message);
        }
    }

    public static final void getAmazonLWAConsentStatus(OnResultAny<Boolean> onResult) {
        r.f(onResult, "onResult");
        ListenerConversionsKt.getAmazonLWAConsentStatusWith(Purchases.Companion.getSharedInstance(), new AnonymousClass1(onResult), new AnonymousClass2(onResult));
    }

    public static final String getAppUserID() {
        return Purchases.Companion.getSharedInstance().getAppUserID();
    }

    public static final void getCurrentOfferingForPlacement(String placementIdentifier, OnNullableResult onResult) {
        r.f(placementIdentifier, "placementIdentifier");
        r.f(onResult, "onResult");
        ListenerConversionsCommonKt.getOfferingsWith(Purchases.Companion.getSharedInstance(), new C11701(onResult), new C11712(placementIdentifier, onResult));
    }

    public static final void getCustomerInfo(OnResult onResult) {
        r.f(onResult, "onResult");
        ListenerConversionsKt.getCustomerInfoWith(Purchases.Companion.getSharedInstance(), new C11721(onResult), new C11732(onResult));
    }

    public static final GoogleReplacementMode getGoogleReplacementMode(Integer num) throws InvalidReplacementModeException {
        GoogleReplacementMode googleReplacementMode = null;
        if (num == null) {
            return null;
        }
        int iIntValue = num.intValue();
        GoogleReplacementMode[] googleReplacementModeArrValues = GoogleReplacementMode.values();
        int length = googleReplacementModeArrValues.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            GoogleReplacementMode googleReplacementMode2 = googleReplacementModeArrValues[i4];
            if (googleReplacementMode2.getPlayBillingClientMode() == iIntValue) {
                googleReplacementMode = googleReplacementMode2;
                break;
            }
            i4++;
        }
        if (googleReplacementMode != null) {
            return googleReplacementMode;
        }
        throw new InvalidReplacementModeException();
    }

    public static final void getOfferings(OnResult onResult) {
        r.f(onResult, "onResult");
        ListenerConversionsCommonKt.getOfferingsWith(Purchases.Companion.getSharedInstance(), new C11741(onResult), new C11752(onResult));
    }

    public static final void getProductInfo(List<String> productIDs, String type, OnResultList onResult) {
        r.f(productIDs, "productIDs");
        r.f(type, "type");
        r.f(onResult, "onResult");
        CommonKt$getProductInfo$onError$1 commonKt$getProductInfo$onError$1 = new CommonKt$getProductInfo$onError$1(onResult);
        CommonKt$getProductInfo$onReceived$1 commonKt$getProductInfo$onReceived$1 = new CommonKt$getProductInfo$onReceived$1(onResult);
        ProductType productTypeMapStringToProductType = mapStringToProductType(type);
        ProductType productType = ProductType.SUBS;
        if (productTypeMapStringToProductType == productType) {
            ListenerConversionsCommonKt.getProductsWith(Purchases.Companion.getSharedInstance(), productIDs, productType, commonKt$getProductInfo$onError$1, commonKt$getProductInfo$onReceived$1);
        } else {
            ListenerConversionsCommonKt.getProductsWith(Purchases.Companion.getSharedInstance(), productIDs, ProductType.INAPP, commonKt$getProductInfo$onError$1, commonKt$getProductInfo$onReceived$1);
        }
    }

    public static final ErrorContainer getPromotionalOffer() {
        return new ErrorContainer(PurchasesErrorCode.UnsupportedError.getCode(), "Android platform doesn't support promotional offers", L.e());
    }

    public static final String getProxyURLString() {
        return String.valueOf(Purchases.Companion.getProxyURL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final o getPurchaseCompletedFunction(OnResult onResult) {
        return new C11761(onResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final o getPurchaseErrorFunction(OnResult onResult) {
        return new C11771(onResult);
    }

    public static final void getStorefront(k callback) {
        r.f(callback, "callback");
        ListenerConversionsCommonKt.getStorefrontCountryCodeWith(Purchases.Companion.getSharedInstance(), new C11781(callback), new C11792(callback));
    }

    public static final void invalidateCustomerInfoCache() {
        Purchases.Companion.getSharedInstance().invalidateCustomerInfoCache();
    }

    public static final boolean isAnonymous() {
        return Purchases.Companion.getSharedInstance().isAnonymous();
    }

    public static final boolean isWebPurchaseRedemptionURL(String urlString) {
        r.f(urlString, "urlString");
        return toWebPurchaseRedemption(urlString) != null;
    }

    public static final void logIn(String appUserID, OnResult onResult) {
        r.f(appUserID, "appUserID");
        r.f(onResult, "onResult");
        ListenerConversionsKt.logInWith(Purchases.Companion.getSharedInstance(), appUserID, new C11801(onResult), new C11812(onResult));
    }

    public static final void logOut(OnResult onResult) {
        r.f(onResult, "onResult");
        ListenerConversionsKt.logOutWith(Purchases.Companion.getSharedInstance(), new C11821(onResult), new C11832(onResult));
    }

    public static final ProductType mapStringToProductType(String type) {
        MappedProductCategory mappedProductCategory;
        r.f(type, "type");
        MappedProductCategory[] mappedProductCategoryArrValues = MappedProductCategory.values();
        int length = mappedProductCategoryArrValues.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                mappedProductCategory = null;
                break;
            }
            mappedProductCategory = mappedProductCategoryArrValues[i4];
            if (x.v(mappedProductCategory.getValue(), type, true)) {
                break;
            }
            i4++;
        }
        if (mappedProductCategory != null) {
            return mappedProductCategory.getToProductType();
        }
        String lowerCase = type.toLowerCase(Locale.ROOT);
        r.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (r.b(lowerCase, "subs")) {
            return ProductType.SUBS;
        }
        if (r.b(lowerCase, "inapp")) {
            return ProductType.INAPP;
        }
        warnLog("Unrecognized product type: " + type + "... Defaulting to INAPP");
        return ProductType.INAPP;
    }

    public static final void purchasePackage(Activity activity, String packageIdentifier, Map<String, ? extends Object> presentedOfferingContext, String str, Integer num, Boolean bool, OnResult onResult) {
        r.f(packageIdentifier, "packageIdentifier");
        r.f(presentedOfferingContext, "presentedOfferingContext");
        r.f(onResult, "onResult");
        try {
            GoogleReplacementMode googleReplacementMode = getGoogleReplacementMode(num);
            if (activity != null) {
                ListenerConversionsCommonKt.getOfferingsWith(Purchases.Companion.getSharedInstance(), new C11841(onResult), new C11852(presentedOfferingContext, onResult, activity, str, googleReplacementMode, bool, packageIdentifier));
            } else {
                onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, "There is no current Activity"), null, 1, null));
            }
        } catch (InvalidReplacementModeException unused) {
            onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.UnknownError, "Invalid google replacement mode passed to purchasePackage."), null, 1, null));
        }
    }

    public static final void purchaseProduct(Activity activity, String productIdentifier, String type, String str, String str2, Integer num, Boolean bool, Map<String, ? extends Object> map, OnResult onResult) {
        r.f(productIdentifier, "productIdentifier");
        r.f(type, "type");
        r.f(onResult, "onResult");
        try {
            GoogleReplacementMode googleReplacementMode = getGoogleReplacementMode(num);
            ProductType productTypeMapStringToProductType = mapStringToProductType(type);
            if (activity == null) {
                onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, "There is no current Activity"), null, 1, null));
                return;
            }
            CommonKt$purchaseProduct$onReceiveStoreProducts$1 commonKt$purchaseProduct$onReceiveStoreProducts$1 = new CommonKt$purchaseProduct$onReceiveStoreProducts$1(activity, map, str2, googleReplacementMode, bool, onResult, productIdentifier, productTypeMapStringToProductType, str);
            ProductType productType = ProductType.SUBS;
            if (productTypeMapStringToProductType != productType) {
                ListenerConversionsCommonKt.getProductsWith(Purchases.Companion.getSharedInstance(), AbstractC0768o.b(productIdentifier), ProductType.INAPP, new C11872(onResult), commonKt$purchaseProduct$onReceiveStoreProducts$1);
            } else {
                ListenerConversionsCommonKt.getProductsWith(Purchases.Companion.getSharedInstance(), AbstractC0768o.b((String) X2.x.H(AbstractC1753A.t0(productIdentifier, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, null))), productType, new C11861(onResult), commonKt$purchaseProduct$onReceiveStoreProducts$1);
            }
        } catch (InvalidReplacementModeException unused) {
            onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.UnknownError, "Invalid google replacement mode passed to purchaseProduct."), null, 1, null));
        }
    }

    public static final void purchaseSubscriptionOption(Activity activity, String productIdentifier, String optionIdentifier, String str, Integer num, Boolean bool, Map<String, ? extends Object> map, OnResult onResult) {
        r.f(productIdentifier, "productIdentifier");
        r.f(optionIdentifier, "optionIdentifier");
        r.f(onResult, "onResult");
        Purchases.Companion companion = Purchases.Companion;
        if (companion.getSharedInstance().getStore() != Store.PLAY_STORE) {
            onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.UnknownError, "purchaseSubscriptionOption() is only supported on the Play Store."), null, 1, null));
            return;
        }
        try {
            GoogleReplacementMode googleReplacementMode = getGoogleReplacementMode(num);
            if (activity == null) {
                onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, "There is no current Activity"), null, 1, null));
            } else {
                ListenerConversionsCommonKt.getProductsWith(companion.getSharedInstance(), AbstractC0768o.b(productIdentifier), ProductType.SUBS, new C11881(onResult), new CommonKt$purchaseSubscriptionOption$onReceiveStoreProducts$1(activity, map, str, bool, onResult, productIdentifier, optionIdentifier, googleReplacementMode));
            }
        } catch (InvalidReplacementModeException unused) {
            onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.UnknownError, "Invalid google replacement mode passed to purchaseSubscriptionOption."), null, 1, null));
        }
    }

    public static final void redeemWebPurchase(String urlString, final OnResult onResult) {
        r.f(urlString, "urlString");
        r.f(onResult, "onResult");
        WebPurchaseRedemption webPurchaseRedemption = toWebPurchaseRedemption(urlString);
        if (webPurchaseRedemption == null) {
            onResult.onError(new ErrorContainer(PurchasesErrorCode.UnsupportedError.getCode(), "Invalid URL for web purchase redemption", L.e()));
        } else {
            Purchases.Companion.getSharedInstance().redeemWebPurchase(webPurchaseRedemption, new RedeemWebPurchaseListener() { // from class: com.revenuecat.purchases.hybridcommon.a
                @Override // com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener
                public final void handleResult(RedeemWebPurchaseListener.Result result) {
                    CommonKt.redeemWebPurchase$lambda$11(onResult, result);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void redeemWebPurchase$lambda$11(OnResult onResult, RedeemWebPurchaseListener.Result result) {
        r.f(onResult, "$onResult");
        r.f(result, "result");
        if (result instanceof RedeemWebPurchaseListener.Result.Success) {
            CustomerInfoMapperKt.mapAsync(((RedeemWebPurchaseListener.Result.Success) result).getCustomerInfo(), new CommonKt$redeemWebPurchase$1$1(onResult, result));
            return;
        }
        if (result instanceof RedeemWebPurchaseListener.Result.Error) {
            onResult.onReceived(L.i(t.a("result", toResultName(result)), t.a(com.google.firebase.messaging.Constants.IPC_BUNDLE_KEY_SEND_ERROR, PurchasesErrorKt.map$default(((RedeemWebPurchaseListener.Result.Error) result).getError(), null, 1, null))));
        } else {
            if (result instanceof RedeemWebPurchaseListener.Result.Expired) {
                onResult.onReceived(L.i(t.a("result", toResultName(result)), t.a("obfuscatedEmail", ((RedeemWebPurchaseListener.Result.Expired) result).getObfuscatedEmail())));
                return;
            }
            if (r.b(result, RedeemWebPurchaseListener.Result.PurchaseBelongsToOtherUser.INSTANCE) ? true : r.b(result, RedeemWebPurchaseListener.Result.InvalidToken.INSTANCE)) {
                onResult.onReceived(L.i(t.a("result", toResultName(result))));
            }
        }
    }

    public static final void restorePurchases(OnResult onResult) {
        r.f(onResult, "onResult");
        ListenerConversionsCommonKt.restorePurchasesWith(Purchases.Companion.getSharedInstance(), new C11891(onResult), new C11902(onResult));
    }

    public static final void setAllowSharingAppStoreAccount(boolean z4) {
        Purchases.Companion.getSharedInstance().setAllowSharingPlayStoreAccount(z4);
    }

    public static final void setDebugLogsEnabled(boolean z4) {
        Purchases.Companion.setDebugLogsEnabled(z4);
    }

    public static final void setLogHandler(k callback) {
        r.f(callback, "callback");
        Purchases.Companion.setLogHandler(new LogHandlerWithMapping(callback));
    }

    public static final void setLogHandlerWithOnResult(OnResult onResult) {
        r.f(onResult, "onResult");
        setLogHandler(new C11911(onResult));
    }

    public static final void setLogLevel(String level) {
        r.f(level, "level");
        try {
            Purchases.Companion.setLogLevel(LogLevel.valueOf(level));
        } catch (IllegalArgumentException unused) {
            warnLog("Unrecognized log level: " + level);
        }
    }

    public static final void setProxyURLString(String str) {
        Purchases.Companion.setProxyURL(str != null ? new URL(str) : null);
    }

    public static final void setPurchasesAreCompletedBy(String purchasesAreCompletedBy) {
        r.f(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        PurchasesAreCompletedBy purchasesAreCompletedBy2 = toPurchasesAreCompletedBy(purchasesAreCompletedBy);
        if (purchasesAreCompletedBy2 != null) {
            Purchases.Companion.getSharedInstance().setPurchasesAreCompletedBy(purchasesAreCompletedBy2);
        }
    }

    public static final void showInAppMessagesIfNeeded(Activity activity) {
        showInAppMessagesIfNeeded$default(activity, null, 2, null);
    }

    public static /* synthetic */ void showInAppMessagesIfNeeded$default(Activity activity, List list, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            list = null;
        }
        showInAppMessagesIfNeeded(activity, list);
    }

    public static final void syncAttributesAndOfferingsIfNeeded(OnResult onResult) {
        r.f(onResult, "onResult");
        ListenerConversionsKt.syncAttributesAndOfferingsIfNeededWith(Purchases.Companion.getSharedInstance(), new C11921(onResult), new C11932(onResult));
    }

    public static final void syncPurchases() {
        Purchases.syncPurchases$default(Purchases.Companion.getSharedInstance(), null, 1, null);
    }

    public static final PresentedOfferingContext toPresentedOfferingContext(Map<String, ? extends Object> map) {
        r.f(map, "<this>");
        Object obj = map.get("offeringIdentifier");
        PresentedOfferingContext.TargetingContext targetingContext = null;
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            return null;
        }
        Object obj2 = map.get("placementIdentifier");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = map.get("targetingContext");
        Map map2 = obj3 instanceof Map ? (Map) obj3 : null;
        if (map2 != null) {
            Integer numConvertToInt = convertToInt(map2.get("revision"));
            Object obj4 = map2.get("ruleId");
            String str3 = obj4 instanceof String ? (String) obj4 : null;
            if (numConvertToInt != null && str3 != null) {
                targetingContext = new PresentedOfferingContext.TargetingContext(numConvertToInt.intValue(), str3);
            }
        }
        return new PresentedOfferingContext(str, str2, targetingContext);
    }

    private static final PurchasesAreCompletedBy toPurchasesAreCompletedBy(String str) {
        try {
            return PurchasesAreCompletedBy.valueOf(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toResultName(RedeemWebPurchaseListener.Result result) {
        if (result instanceof RedeemWebPurchaseListener.Result.Success) {
            return "SUCCESS";
        }
        if (result instanceof RedeemWebPurchaseListener.Result.Error) {
            return "ERROR";
        }
        if (r.b(result, RedeemWebPurchaseListener.Result.PurchaseBelongsToOtherUser.INSTANCE)) {
            return "PURCHASE_BELONGS_TO_OTHER_USER";
        }
        if (r.b(result, RedeemWebPurchaseListener.Result.InvalidToken.INSTANCE)) {
            return "INVALID_TOKEN";
        }
        if (result instanceof RedeemWebPurchaseListener.Result.Expired) {
            return "EXPIRED";
        }
        throw new m();
    }

    private static final WebPurchaseRedemption toWebPurchaseRedemption(String str) {
        try {
            return Purchases.Companion.parseAsWebPurchaseRedemption(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Throwable th) {
            errorLog("Error parsing WebPurchaseRedemption from URL: " + str + ". Error: " + th);
            return null;
        }
    }

    public static final void warnLog(String message) {
        r.f(message, "message");
        if (Purchases.Companion.getLogLevel().compareTo(LogLevel.WARN) <= 0) {
            Log.w("PurchasesHybridCommon", message);
        }
    }

    public static final void configure(Context context, String apiKey, String str, String str2, PlatformInfo platformInfo) {
        r.f(context, "context");
        r.f(apiKey, "apiKey");
        r.f(platformInfo, "platformInfo");
        configure$default(context, apiKey, str, str2, platformInfo, null, null, null, null, null, null, 2016, null);
    }

    public static final void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> list) {
        if (activity == null) {
            errorLog("showInAppMessages called with null activity");
        } else if (list == null) {
            Purchases.showInAppMessagesIfNeeded$default(Purchases.Companion.getSharedInstance(), activity, null, 2, null);
        } else {
            Purchases.Companion.getSharedInstance().showInAppMessagesIfNeeded(activity, list);
        }
    }

    public static final void syncPurchases(OnResult onResult) {
        r.f(onResult, "onResult");
        ListenerConversionsKt.syncPurchasesWith(Purchases.Companion.getSharedInstance(), new C11941(onResult), new C11952(onResult));
    }

    public static final void configure(Context context, String apiKey, String str, String str2, PlatformInfo platformInfo, Store store) {
        r.f(context, "context");
        r.f(apiKey, "apiKey");
        r.f(platformInfo, "platformInfo");
        r.f(store, "store");
        configure$default(context, apiKey, str, str2, platformInfo, store, null, null, null, null, null, 1984, null);
    }

    public static final void configure(Context context, String apiKey, String str, String str2, PlatformInfo platformInfo, Store store, DangerousSettings dangerousSettings) {
        r.f(context, "context");
        r.f(apiKey, "apiKey");
        r.f(platformInfo, "platformInfo");
        r.f(store, "store");
        r.f(dangerousSettings, "dangerousSettings");
        configure$default(context, apiKey, str, str2, platformInfo, store, dangerousSettings, null, null, null, null, 1920, null);
    }

    public static final void configure(Context context, String apiKey, String str, String str2, PlatformInfo platformInfo, Store store, DangerousSettings dangerousSettings, Boolean bool) {
        r.f(context, "context");
        r.f(apiKey, "apiKey");
        r.f(platformInfo, "platformInfo");
        r.f(store, "store");
        r.f(dangerousSettings, "dangerousSettings");
        configure$default(context, apiKey, str, str2, platformInfo, store, dangerousSettings, bool, null, null, null, 1792, null);
    }

    public static final void configure(Context context, String apiKey, String str, String str2, PlatformInfo platformInfo, Store store, DangerousSettings dangerousSettings, Boolean bool, String str3) {
        r.f(context, "context");
        r.f(apiKey, "apiKey");
        r.f(platformInfo, "platformInfo");
        r.f(store, "store");
        r.f(dangerousSettings, "dangerousSettings");
        configure$default(context, apiKey, str, str2, platformInfo, store, dangerousSettings, bool, str3, null, null, 1536, null);
    }

    public static final void configure(Context context, String apiKey, String str, String str2, PlatformInfo platformInfo, Store store, DangerousSettings dangerousSettings, Boolean bool, String str3, Boolean bool2) {
        r.f(context, "context");
        r.f(apiKey, "apiKey");
        r.f(platformInfo, "platformInfo");
        r.f(store, "store");
        r.f(dangerousSettings, "dangerousSettings");
        configure$default(context, apiKey, str, str2, platformInfo, store, dangerousSettings, bool, str3, bool2, null, UserMetadata.MAX_ATTRIBUTE_SIZE, null);
    }

    public static final void configure(Context context, String apiKey, String str, String str2, PlatformInfo platformInfo, Store store, DangerousSettings dangerousSettings, Boolean bool, String str3, Boolean bool2, Boolean bool3) {
        PurchasesAreCompletedBy purchasesAreCompletedBy;
        r.f(context, "context");
        r.f(apiKey, "apiKey");
        r.f(platformInfo, "platformInfo");
        r.f(store, "store");
        r.f(dangerousSettings, "dangerousSettings");
        Purchases.Companion.setPlatformInfo(platformInfo);
        PurchasesConfiguration.Builder builderDangerousSettings = new PurchasesConfiguration.Builder(context, apiKey).appUserID(str).store(store).dangerousSettings(dangerousSettings);
        if (str2 != null && (purchasesAreCompletedBy = toPurchasesAreCompletedBy(str2)) != null) {
            builderDangerousSettings.purchasesAreCompletedBy(purchasesAreCompletedBy);
        }
        if (bool != null) {
            builderDangerousSettings.showInAppMessagesAutomatically(bool.booleanValue());
        }
        if (str3 != null) {
            try {
                builderDangerousSettings.entitlementVerificationMode(EntitlementVerificationMode.valueOf(str3));
            } catch (IllegalArgumentException unused) {
                warnLog("Attempted to configure with unknown verification mode: " + str3 + com.amazon.a.a.o.c.a.b.f8816a);
                E e4 = E.f5463a;
            }
        }
        if (bool2 != null) {
            builderDangerousSettings.pendingTransactionsForPrepaidPlansEnabled(bool2.booleanValue());
        }
        if (bool3 != null) {
            builderDangerousSettings.diagnosticsEnabled(bool3.booleanValue());
        }
        Purchases.Companion.configure(builderDangerousSettings.build());
    }
}
