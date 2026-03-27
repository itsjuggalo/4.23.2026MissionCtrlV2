package com.android.billingclient.api;

import com.android.billingclient.api.d;
import com.revenuecat.purchases.google.ErrorsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final d f9490A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final d f9491B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final d f9492C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final d f9493D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final d f9494E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final d f9495F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final d f9496G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f9497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f9498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f9499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f9500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f9501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f9502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f9503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f9504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f9505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f9506j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d f9507k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f9508l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f9509m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d f9510n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f9511o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f9512p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final d f9513q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d f9514r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final d f9515s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final d f9516t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final d f9517u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f9518v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final d f9519w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final d f9520x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final d f9521y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final d f9522z;

    static {
        d.a aVarC = d.c();
        aVarC.c(3);
        aVarC.b(ErrorsKt.IN_APP_BILLING_LESS_THAN_3_ERROR_MESSAGE);
        f9497a = aVarC.a();
        d.a aVarC2 = d.c();
        aVarC2.c(3);
        aVarC2.b("Google Play In-app Billing API version is less than 9");
        f9498b = aVarC2.a();
        d.a aVarC3 = d.c();
        aVarC3.c(3);
        aVarC3.b("Billing service unavailable on device.");
        f9499c = aVarC3.a();
        d.a aVarC4 = d.c();
        aVarC4.c(2);
        aVarC4.b("Billing service unavailable on device.");
        f9500d = aVarC4.a();
        d.a aVarC5 = d.c();
        aVarC5.c(5);
        aVarC5.b("Client is already in the process of connecting to billing service.");
        f9501e = aVarC5.a();
        d.a aVarC6 = d.c();
        aVarC6.c(5);
        aVarC6.b("The list of SKUs can't be empty.");
        f9502f = aVarC6.a();
        d.a aVarC7 = d.c();
        aVarC7.c(5);
        aVarC7.b("SKU type can't be empty.");
        f9503g = aVarC7.a();
        d.a aVarC8 = d.c();
        aVarC8.c(5);
        aVarC8.b("Product type can't be empty.");
        f9504h = aVarC8.a();
        d.a aVarC9 = d.c();
        aVarC9.c(-2);
        aVarC9.b("Client does not support extra params.");
        f9505i = aVarC9.a();
        d.a aVarC10 = d.c();
        aVarC10.c(5);
        aVarC10.b("Invalid purchase token.");
        f9506j = aVarC10.a();
        d.a aVarC11 = d.c();
        aVarC11.c(6);
        aVarC11.b("An internal error occurred.");
        f9507k = aVarC11.a();
        d.a aVarC12 = d.c();
        aVarC12.c(5);
        aVarC12.b("SKU can't be null.");
        aVarC12.a();
        d.a aVarC13 = d.c();
        aVarC13.c(0);
        f9508l = aVarC13.a();
        d.a aVarC14 = d.c();
        aVarC14.c(-1);
        aVarC14.b("Service connection is disconnected.");
        f9509m = aVarC14.a();
        d.a aVarC15 = d.c();
        aVarC15.c(2);
        aVarC15.b("Timeout communicating with service.");
        f9510n = aVarC15.a();
        d.a aVarC16 = d.c();
        aVarC16.c(-2);
        aVarC16.b("Client does not support subscriptions.");
        f9511o = aVarC16.a();
        d.a aVarC17 = d.c();
        aVarC17.c(-2);
        aVarC17.b("Client does not support subscriptions update.");
        f9512p = aVarC17.a();
        d.a aVarC18 = d.c();
        aVarC18.c(-2);
        aVarC18.b("Client does not support get purchase history.");
        f9513q = aVarC18.a();
        d.a aVarC19 = d.c();
        aVarC19.c(-2);
        aVarC19.b("Client does not support price change confirmation.");
        f9514r = aVarC19.a();
        d.a aVarC20 = d.c();
        aVarC20.c(-2);
        aVarC20.b("Play Store version installed does not support cross selling products.");
        f9515s = aVarC20.a();
        d.a aVarC21 = d.c();
        aVarC21.c(-2);
        aVarC21.b("Client does not support multi-item purchases.");
        f9516t = aVarC21.a();
        d.a aVarC22 = d.c();
        aVarC22.c(-2);
        aVarC22.b("Client does not support offer_id_token.");
        f9517u = aVarC22.a();
        d.a aVarC23 = d.c();
        aVarC23.c(-2);
        aVarC23.b("Client does not support ProductDetails.");
        f9518v = aVarC23.a();
        d.a aVarC24 = d.c();
        aVarC24.c(-2);
        aVarC24.b("Client does not support in-app messages.");
        f9519w = aVarC24.a();
        d.a aVarC25 = d.c();
        aVarC25.c(-2);
        aVarC25.b("Client does not support user choice billing.");
        aVarC25.a();
        d.a aVarC26 = d.c();
        aVarC26.c(-2);
        aVarC26.b("Play Store version installed does not support external offer.");
        f9520x = aVarC26.a();
        d.a aVarC27 = d.c();
        aVarC27.c(-2);
        aVarC27.b("Play Store version installed does not support multi-item purchases with season pass in one cart.");
        f9521y = aVarC27.a();
        d.a aVarC28 = d.c();
        aVarC28.c(5);
        aVarC28.b("Unknown feature");
        f9522z = aVarC28.a();
        d.a aVarC29 = d.c();
        aVarC29.c(-2);
        aVarC29.b("Play Store version installed does not support get billing config.");
        f9490A = aVarC29.a();
        d.a aVarC30 = d.c();
        aVarC30.c(-2);
        aVarC30.b("Query product details with serialized docid is not supported.");
        f9491B = aVarC30.a();
        d.a aVarC31 = d.c();
        aVarC31.c(4);
        aVarC31.b("Item is unavailable for purchase.");
        f9492C = aVarC31.a();
        d.a aVarC32 = d.c();
        aVarC32.c(-2);
        aVarC32.b("Query product details with developer specified account is not supported.");
        f9493D = aVarC32.a();
        d.a aVarC33 = d.c();
        aVarC33.c(-2);
        aVarC33.b("Play Store version installed does not support alternative billing only.");
        f9494E = aVarC33.a();
        d.a aVarC34 = d.c();
        aVarC34.c(5);
        aVarC34.b("To use this API you must specify a PurchasesUpdateListener when initializing a BillingClient.");
        f9495F = aVarC34.a();
        d.a aVarC35 = d.c();
        aVarC35.c(6);
        aVarC35.b("An error occurred while retrieving billing override.");
        f9496G = aVarC35.a();
    }

    public static d a(int i4, String str) {
        d.a aVarC = d.c();
        aVarC.c(i4);
        aVarC.b(str);
        return aVarC.a();
    }
}
