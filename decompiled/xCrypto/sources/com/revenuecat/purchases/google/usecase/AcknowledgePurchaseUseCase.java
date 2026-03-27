package com.revenuecat.purchases.google.usecase;

import H0.C0292a;
import H0.InterfaceC0294b;
import W2.E;
import W2.m;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase;
import i3.k;
import i3.o;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class AcknowledgePurchaseUseCase extends BillingClientUseCase<String> {
    private final k onError;
    private final k onReceive;
    private final AcknowledgePurchaseUseCaseParams useCaseParams;
    private final k withConnectedClient;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PostReceiptInitiationSource.values().length];
            try {
                iArr[PostReceiptInitiationSource.RESTORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PostReceiptInitiationSource.PURCHASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PostReceiptInitiationSource.UNSYNCED_ACTIVE_PURCHASES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase$executeAsync$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(AcknowledgePurchaseUseCase this$0, com.android.billingclient.api.d billingResult) {
            r.f(this$0, "this$0");
            r.f(billingResult, "billingResult");
            BillingClientUseCase.processResult$default(this$0, billingResult, this$0.useCaseParams.getPurchaseToken(), null, new AcknowledgePurchaseUseCase$executeAsync$1$1$1(this$0), 4, null);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((com.android.billingclient.api.a) obj);
            return E.f5463a;
        }

        public final void invoke(com.android.billingclient.api.a invoke) {
            r.f(invoke, "$this$invoke");
            C0292a c0292aA = C0292a.b().b(AcknowledgePurchaseUseCase.this.useCaseParams.getPurchaseToken()).a();
            r.e(c0292aA, "newBuilder()\n           …\n                .build()");
            final AcknowledgePurchaseUseCase acknowledgePurchaseUseCase = AcknowledgePurchaseUseCase.this;
            invoke.a(c0292aA, new InterfaceC0294b() { // from class: com.revenuecat.purchases.google.usecase.a
                @Override // H0.InterfaceC0294b
                public final void a(com.android.billingclient.api.d dVar) {
                    AcknowledgePurchaseUseCase.AnonymousClass1.invoke$lambda$0(acknowledgePurchaseUseCase, dVar);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcknowledgePurchaseUseCase(AcknowledgePurchaseUseCaseParams useCaseParams, k onReceive, k onError, k withConnectedClient, o executeRequestOnUIThread) {
        super(useCaseParams, onError, executeRequestOnUIThread);
        r.f(useCaseParams, "useCaseParams");
        r.f(onReceive, "onReceive");
        r.f(onError, "onError");
        r.f(withConnectedClient, "withConnectedClient");
        r.f(executeRequestOnUIThread, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams;
        this.onReceive = onReceive;
        this.onError = onError;
        this.withConnectedClient = withConnectedClient;
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void executeAsync() {
        this.withConnectedClient.invoke(new AnonymousClass1());
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public boolean getBackoffForNetworkErrors() {
        int i4 = WhenMappings.$EnumSwitchMapping$0[this.useCaseParams.getInitiationSource().ordinal()];
        if (i4 == 1 || i4 == 2) {
            return false;
        }
        if (i4 == 3) {
            return true;
        }
        throw new m();
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public String getErrorMessage() {
        return "Error acknowledging purchase";
    }

    public final k getOnError() {
        return this.onError;
    }

    public final k getOnReceive() {
        return this.onReceive;
    }

    public final k getWithConnectedClient() {
        return this.withConnectedClient;
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void onOk(String received) {
        r.f(received, "received");
        this.onReceive.invoke(received);
    }
}
