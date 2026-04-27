package com.revenuecat.purchases;

import W2.p;
import Z2.k;
import a3.AbstractC0786b;
import a3.AbstractC0787c;
import b3.AbstractC0866d;
import b3.InterfaceC0868f;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CoroutinesExtensionsCommonKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$1, reason: invalid class name */
    @InterfaceC0868f(c = "com.revenuecat.purchases.CoroutinesExtensionsCommonKt", f = "CoroutinesExtensionsCommon.kt", l = {169}, m = "awaitGetProductsResult")
    public static final class AnonymousClass1 extends AbstractC0866d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAwaitGetProductsResult = CoroutinesExtensionsCommonKt.awaitGetProductsResult(null, null, null, this);
            return objAwaitGetProductsResult == AbstractC0787c.e() ? objAwaitGetProductsResult : p.a(objAwaitGetProductsResult);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "com.revenuecat.purchases.CoroutinesExtensionsCommonKt", f = "CoroutinesExtensionsCommon.kt", l = {48}, m = "awaitOfferingsResult")
    public static final class C10791 extends AbstractC0866d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10791(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAwaitOfferingsResult = CoroutinesExtensionsCommonKt.awaitOfferingsResult(null, this);
            return objAwaitOfferingsResult == AbstractC0787c.e() ? objAwaitOfferingsResult : p.a(objAwaitOfferingsResult);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "com.revenuecat.purchases.CoroutinesExtensionsCommonKt", f = "CoroutinesExtensionsCommon.kt", l = {107}, m = "awaitPurchaseResult")
    public static final class C10801 extends AbstractC0866d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10801(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAwaitPurchaseResult = CoroutinesExtensionsCommonKt.awaitPurchaseResult(null, null, this);
            return objAwaitPurchaseResult == AbstractC0787c.e() ? objAwaitPurchaseResult : p.a(objAwaitPurchaseResult);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "com.revenuecat.purchases.CoroutinesExtensionsCommonKt", f = "CoroutinesExtensionsCommon.kt", l = {228}, m = "awaitRestoreResult")
    public static final class C10811 extends AbstractC0866d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10811(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAwaitRestoreResult = CoroutinesExtensionsCommonKt.awaitRestoreResult(null, this);
            return objAwaitRestoreResult == AbstractC0787c.e() ? objAwaitRestoreResult : p.a(objAwaitRestoreResult);
        }
    }

    public static final /* synthetic */ Object awaitGetProducts(Purchases purchases, List list, ProductType productType, Z2.e eVar) throws Throwable {
        k kVar = new k(AbstractC0786b.c(eVar));
        ListenerConversionsCommonKt.getProductsWith(purchases, list, productType, new CoroutinesExtensionsCommonKt$awaitGetProducts$2$2(kVar), new CoroutinesExtensionsCommonKt$awaitGetProducts$2$1(kVar));
        Object objA = kVar.a();
        if (objA == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objA;
    }

    public static /* synthetic */ Object awaitGetProducts$default(Purchases purchases, List list, ProductType productType, Z2.e eVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            productType = null;
        }
        return awaitGetProducts(purchases, list, productType, eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ java.lang.Object awaitGetProductsResult(com.revenuecat.purchases.Purchases r4, java.util.List r5, com.revenuecat.purchases.ProductType r6, Z2.e r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.revenuecat.purchases.CoroutinesExtensionsCommonKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$1 r0 = (com.revenuecat.purchases.CoroutinesExtensionsCommonKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$1 r0 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.L$2
            com.revenuecat.purchases.ProductType r4 = (com.revenuecat.purchases.ProductType) r4
            java.lang.Object r4 = r0.L$1
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r4 = r0.L$0
            com.revenuecat.purchases.Purchases r4 = (com.revenuecat.purchases.Purchases) r4
            W2.q.b(r7)
            goto L6e
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            W2.q.b(r7)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            Z2.k r7 = new Z2.k
            Z2.e r2 = a3.AbstractC0786b.c(r0)
            r7.<init>(r2)
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$2$1 r2 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$2$1
            r2.<init>(r7)
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$2$2 r3 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$2$2
            r3.<init>(r7)
            com.revenuecat.purchases.ListenerConversionsCommonKt.getProductsWith(r4, r5, r6, r2, r3)
            java.lang.Object r7 = r7.a()
            java.lang.Object r4 = a3.AbstractC0787c.e()
            if (r7 != r4) goto L6b
            b3.h.c(r0)
        L6b:
            if (r7 != r1) goto L6e
            return r1
        L6e:
            W2.p r7 = (W2.p) r7
            java.lang.Object r4 = r7.j()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.CoroutinesExtensionsCommonKt.awaitGetProductsResult(com.revenuecat.purchases.Purchases, java.util.List, com.revenuecat.purchases.ProductType, Z2.e):java.lang.Object");
    }

    public static /* synthetic */ Object awaitGetProductsResult$default(Purchases purchases, List list, ProductType productType, Z2.e eVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            productType = null;
        }
        return awaitGetProductsResult(purchases, list, productType, eVar);
    }

    public static final /* synthetic */ Object awaitOfferings(Purchases purchases, Z2.e eVar) throws Throwable {
        k kVar = new k(AbstractC0786b.c(eVar));
        ListenerConversionsCommonKt.getOfferingsWith(purchases, new CoroutinesExtensionsCommonKt$awaitOfferings$2$2(kVar), new CoroutinesExtensionsCommonKt$awaitOfferings$2$1(kVar));
        Object objA = kVar.a();
        if (objA == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objA;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ java.lang.Object awaitOfferingsResult(com.revenuecat.purchases.Purchases r4, Z2.e r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof com.revenuecat.purchases.CoroutinesExtensionsCommonKt.C10791
            if (r0 == 0) goto L13
            r0 = r5
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$1 r0 = (com.revenuecat.purchases.CoroutinesExtensionsCommonKt.C10791) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$1 r0 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.revenuecat.purchases.Purchases r4 = (com.revenuecat.purchases.Purchases) r4
            W2.q.b(r5)
            goto L62
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            W2.q.b(r5)
            r0.L$0 = r4
            r0.label = r3
            Z2.k r5 = new Z2.k
            Z2.e r2 = a3.AbstractC0786b.c(r0)
            r5.<init>(r2)
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$2$1 r2 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$2$1
            r2.<init>(r5)
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$2$2 r3 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$2$2
            r3.<init>(r5)
            com.revenuecat.purchases.ListenerConversionsCommonKt.getOfferingsWith(r4, r2, r3)
            java.lang.Object r5 = r5.a()
            java.lang.Object r4 = a3.AbstractC0787c.e()
            if (r5 != r4) goto L5f
            b3.h.c(r0)
        L5f:
            if (r5 != r1) goto L62
            return r1
        L62:
            W2.p r5 = (W2.p) r5
            java.lang.Object r4 = r5.j()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.CoroutinesExtensionsCommonKt.awaitOfferingsResult(com.revenuecat.purchases.Purchases, Z2.e):java.lang.Object");
    }

    public static final /* synthetic */ Object awaitPurchase(Purchases purchases, PurchaseParams purchaseParams, Z2.e eVar) throws Throwable {
        k kVar = new k(AbstractC0786b.c(eVar));
        purchases.purchase(purchaseParams, ListenerConversionsCommonKt.purchaseCompletedCallback(new CoroutinesExtensionsCommonKt$awaitPurchase$2$1(kVar), new CoroutinesExtensionsCommonKt$awaitPurchase$2$2(kVar)));
        Object objA = kVar.a();
        if (objA == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objA;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ java.lang.Object awaitPurchaseResult(com.revenuecat.purchases.Purchases r4, com.revenuecat.purchases.PurchaseParams r5, Z2.e r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof com.revenuecat.purchases.CoroutinesExtensionsCommonKt.C10801
            if (r0 == 0) goto L13
            r0 = r6
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$1 r0 = (com.revenuecat.purchases.CoroutinesExtensionsCommonKt.C10801) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$1 r0 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.L$1
            com.revenuecat.purchases.PurchaseParams r4 = (com.revenuecat.purchases.PurchaseParams) r4
            java.lang.Object r4 = r0.L$0
            com.revenuecat.purchases.Purchases r4 = (com.revenuecat.purchases.Purchases) r4
            W2.q.b(r6)
            goto L6c
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            W2.q.b(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            Z2.k r6 = new Z2.k
            Z2.e r2 = a3.AbstractC0786b.c(r0)
            r6.<init>(r2)
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$2$1 r2 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$2$1
            r2.<init>(r6)
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$2$2 r3 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$2$2
            r3.<init>(r6)
            com.revenuecat.purchases.interfaces.PurchaseCallback r2 = com.revenuecat.purchases.ListenerConversionsCommonKt.purchaseCompletedCallback(r2, r3)
            r4.purchase(r5, r2)
            java.lang.Object r6 = r6.a()
            java.lang.Object r4 = a3.AbstractC0787c.e()
            if (r6 != r4) goto L69
            b3.h.c(r0)
        L69:
            if (r6 != r1) goto L6c
            return r1
        L6c:
            W2.p r6 = (W2.p) r6
            java.lang.Object r4 = r6.j()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.CoroutinesExtensionsCommonKt.awaitPurchaseResult(com.revenuecat.purchases.Purchases, com.revenuecat.purchases.PurchaseParams, Z2.e):java.lang.Object");
    }

    public static final /* synthetic */ Object awaitRestore(Purchases purchases, Z2.e eVar) throws Throwable {
        k kVar = new k(AbstractC0786b.c(eVar));
        ListenerConversionsCommonKt.restorePurchasesWith(purchases, new CoroutinesExtensionsCommonKt$awaitRestore$2$1(kVar), new CoroutinesExtensionsCommonKt$awaitRestore$2$2(kVar));
        Object objA = kVar.a();
        if (objA == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objA;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ java.lang.Object awaitRestoreResult(com.revenuecat.purchases.Purchases r4, Z2.e r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof com.revenuecat.purchases.CoroutinesExtensionsCommonKt.C10811
            if (r0 == 0) goto L13
            r0 = r5
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$1 r0 = (com.revenuecat.purchases.CoroutinesExtensionsCommonKt.C10811) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$1 r0 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.revenuecat.purchases.Purchases r4 = (com.revenuecat.purchases.Purchases) r4
            W2.q.b(r5)
            goto L62
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            W2.q.b(r5)
            r0.L$0 = r4
            r0.label = r3
            Z2.k r5 = new Z2.k
            Z2.e r2 = a3.AbstractC0786b.c(r0)
            r5.<init>(r2)
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$2$1 r2 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$2$1
            r2.<init>(r5)
            com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$2$2 r3 = new com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$2$2
            r3.<init>(r5)
            com.revenuecat.purchases.ListenerConversionsCommonKt.restorePurchasesWith(r4, r2, r3)
            java.lang.Object r5 = r5.a()
            java.lang.Object r4 = a3.AbstractC0787c.e()
            if (r5 != r4) goto L5f
            b3.h.c(r0)
        L5f:
            if (r5 != r1) goto L62
            return r1
        L62:
            W2.p r5 = (W2.p) r5
            java.lang.Object r4 = r5.j()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.CoroutinesExtensionsCommonKt.awaitRestoreResult(com.revenuecat.purchases.Purchases, Z2.e):java.lang.Object");
    }

    public static final Object awaitStorefrontCountryCode(Purchases purchases, Z2.e eVar) throws Throwable {
        k kVar = new k(AbstractC0786b.c(eVar));
        ListenerConversionsCommonKt.getStorefrontCountryCodeWith(purchases, new CoroutinesExtensionsCommonKt$awaitStorefrontCountryCode$2$2(kVar), new CoroutinesExtensionsCommonKt$awaitStorefrontCountryCode$2$1(kVar));
        Object objA = kVar.a();
        if (objA == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objA;
    }
}
