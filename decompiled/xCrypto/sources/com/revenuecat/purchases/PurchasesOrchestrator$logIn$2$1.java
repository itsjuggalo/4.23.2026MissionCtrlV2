package com.revenuecat.purchases;

import W2.E;
import com.revenuecat.purchases.common.offerings.OfferingsManager;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.LogInCallback;
import i3.k;
import i3.o;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesOrchestrator$logIn$2$1 extends s implements Function0 {
    final /* synthetic */ LogInCallback $callback;
    final /* synthetic */ String $newAppUserID;
    final /* synthetic */ PurchasesOrchestrator this$0;

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$logIn$2$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements o {
        final /* synthetic */ LogInCallback $callback;
        final /* synthetic */ String $newAppUserID;
        final /* synthetic */ PurchasesOrchestrator this$0;

        /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$logIn$2$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01651 extends s implements Function0 {
            final /* synthetic */ LogInCallback $callback;
            final /* synthetic */ boolean $created;
            final /* synthetic */ CustomerInfo $customerInfo;
            final /* synthetic */ PurchasesOrchestrator this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01651(LogInCallback logInCallback, CustomerInfo customerInfo, boolean z4, PurchasesOrchestrator purchasesOrchestrator) {
                super(0);
                this.$callback = logInCallback;
                this.$customerInfo = customerInfo;
                this.$created = z4;
                this.this$0 = purchasesOrchestrator;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m81invoke();
                return E.f5463a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m81invoke() {
                LogInCallback logInCallback = this.$callback;
                if (logInCallback != null) {
                    logInCallback.onReceived(this.$customerInfo, this.$created);
                }
                this.this$0.customerInfoUpdateHandler.notifyListeners(this.$customerInfo);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PurchasesOrchestrator purchasesOrchestrator, String str, LogInCallback logInCallback) {
            super(2);
            this.this$0 = purchasesOrchestrator;
            this.$newAppUserID = str;
            this.$callback = logInCallback;
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((CustomerInfo) obj, ((Boolean) obj2).booleanValue());
            return E.f5463a;
        }

        public final void invoke(CustomerInfo customerInfo, boolean z4) {
            r.f(customerInfo, "customerInfo");
            PurchasesOrchestrator purchasesOrchestrator = this.this$0;
            purchasesOrchestrator.dispatch(new C01651(this.$callback, customerInfo, z4, purchasesOrchestrator));
            OfferingsManager.fetchAndCacheOfferings$default(this.this$0.offeringsManager, this.$newAppUserID, this.this$0.getState$purchases_defaultsRelease().getAppInBackground(), null, null, 12, null);
            this.this$0.backupManager.dataChanged();
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$logIn$2$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements k {
        final /* synthetic */ LogInCallback $callback;
        final /* synthetic */ PurchasesOrchestrator this$0;

        /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$logIn$2$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements Function0 {
            final /* synthetic */ LogInCallback $callback;
            final /* synthetic */ PurchasesError $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(LogInCallback logInCallback, PurchasesError purchasesError) {
                super(0);
                this.$callback = logInCallback;
                this.$error = purchasesError;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m82invoke();
                return E.f5463a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m82invoke() {
                LogInCallback logInCallback = this.$callback;
                if (logInCallback != null) {
                    logInCallback.onError(this.$error);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(PurchasesOrchestrator purchasesOrchestrator, LogInCallback logInCallback) {
            super(1);
            this.this$0 = purchasesOrchestrator;
            this.$callback = logInCallback;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError error) {
            r.f(error, "error");
            this.this$0.dispatch(new AnonymousClass1(this.$callback, error));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchasesOrchestrator$logIn$2$1(PurchasesOrchestrator purchasesOrchestrator, String str, LogInCallback logInCallback) {
        super(0);
        this.this$0 = purchasesOrchestrator;
        this.$newAppUserID = str;
        this.$callback = logInCallback;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m80invoke();
        return E.f5463a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m80invoke() {
        IdentityManager identityManager = this.this$0.identityManager;
        String str = this.$newAppUserID;
        identityManager.logIn(str, new AnonymousClass1(this.this$0, str, this.$callback), new AnonymousClass2(this.this$0, this.$callback));
    }
}
