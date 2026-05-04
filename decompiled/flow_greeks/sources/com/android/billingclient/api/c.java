package com.android.billingclient.api;

import com.android.billingclient.api.a;
import com.revenuecat.purchases.google.ErrorsKt;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static final a A;
    public static final a B;
    public static final a C;
    public static final a D;
    public static final a E;
    public static final a F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f5149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f5150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f5151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f5152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f5153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f5154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f5155i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f5156j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f5157k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f5158l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f5159m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f5160n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f5161o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f5162p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f5163q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f5164r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f5165s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f5166t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f5167u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f5168v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f5169w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f5170x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f5171y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a f5172z;

    static {
        a.C0091a c0091aD = a.d();
        c0091aD.d(3);
        c0091aD.b(ErrorsKt.IN_APP_BILLING_LESS_THAN_3_ERROR_MESSAGE);
        c0091aD.a();
        a.C0091a c0091aD2 = a.d();
        c0091aD2.d(3);
        c0091aD2.b("Google Play In-app Billing API version is less than 9");
        f5147a = c0091aD2.a();
        a.C0091a c0091aD3 = a.d();
        c0091aD3.d(3);
        c0091aD3.b("Billing service unavailable on device.");
        f5148b = c0091aD3.a();
        a.C0091a c0091aD4 = a.d();
        c0091aD4.d(2);
        c0091aD4.b("Billing service unavailable on device.");
        f5149c = c0091aD4.a();
        a.C0091a c0091aD5 = a.d();
        c0091aD5.d(5);
        c0091aD5.b("Client is already in the process of connecting to billing service.");
        f5150d = c0091aD5.a();
        a.C0091a c0091aD6 = a.d();
        c0091aD6.d(5);
        c0091aD6.b("The list of SKUs can't be empty.");
        c0091aD6.a();
        a.C0091a c0091aD7 = a.d();
        c0091aD7.d(5);
        c0091aD7.b("SKU type can't be empty.");
        c0091aD7.a();
        a.C0091a c0091aD8 = a.d();
        c0091aD8.d(5);
        c0091aD8.b("Product type can't be empty.");
        f5151e = c0091aD8.a();
        a.C0091a c0091aD9 = a.d();
        c0091aD9.d(-2);
        c0091aD9.b("Client does not support extra params.");
        f5152f = c0091aD9.a();
        a.C0091a c0091aD10 = a.d();
        c0091aD10.d(5);
        c0091aD10.b("Invalid purchase token.");
        f5153g = c0091aD10.a();
        a.C0091a c0091aD11 = a.d();
        c0091aD11.d(6);
        c0091aD11.b("An internal error occurred.");
        f5154h = c0091aD11.a();
        a.C0091a c0091aD12 = a.d();
        c0091aD12.d(5);
        c0091aD12.b("SKU can't be null.");
        c0091aD12.a();
        a.C0091a c0091aD13 = a.d();
        c0091aD13.d(0);
        f5155i = c0091aD13.a();
        a.C0091a c0091aD14 = a.d();
        c0091aD14.d(-1);
        c0091aD14.b("Service connection is disconnected.");
        f5156j = c0091aD14.a();
        a.C0091a c0091aD15 = a.d();
        c0091aD15.d(2);
        c0091aD15.b("Timeout communicating with service.");
        f5157k = c0091aD15.a();
        a.C0091a c0091aD16 = a.d();
        c0091aD16.d(-2);
        c0091aD16.b("Client does not support subscriptions.");
        f5158l = c0091aD16.a();
        a.C0091a c0091aD17 = a.d();
        c0091aD17.d(-2);
        c0091aD17.b("Client does not support subscriptions update.");
        f5159m = c0091aD17.a();
        a.C0091a c0091aD18 = a.d();
        c0091aD18.d(-2);
        c0091aD18.b("Client does not support get purchase history.");
        c0091aD18.a();
        a.C0091a c0091aD19 = a.d();
        c0091aD19.d(-2);
        c0091aD19.b("Client does not support price change confirmation.");
        f5160n = c0091aD19.a();
        a.C0091a c0091aD20 = a.d();
        c0091aD20.d(-2);
        c0091aD20.b("Play Store version installed does not support cross selling products.");
        f5161o = c0091aD20.a();
        a.C0091a c0091aD21 = a.d();
        c0091aD21.d(-2);
        c0091aD21.b("Client does not support multi-item purchases.");
        f5162p = c0091aD21.a();
        a.C0091a c0091aD22 = a.d();
        c0091aD22.d(-2);
        c0091aD22.b("Client does not support offer_id_token.");
        f5163q = c0091aD22.a();
        a.C0091a c0091aD23 = a.d();
        c0091aD23.d(-2);
        c0091aD23.b("Client does not support ProductDetails.");
        f5164r = c0091aD23.a();
        a.C0091a c0091aD24 = a.d();
        c0091aD24.d(-2);
        c0091aD24.b("Client does not support in-app messages.");
        f5165s = c0091aD24.a();
        a.C0091a c0091aD25 = a.d();
        c0091aD25.d(-2);
        c0091aD25.b("Client does not support user choice billing.");
        c0091aD25.a();
        a.C0091a c0091aD26 = a.d();
        c0091aD26.d(-2);
        c0091aD26.b("Play Store version installed does not support external offer.");
        f5166t = c0091aD26.a();
        a.C0091a c0091aD27 = a.d();
        c0091aD27.d(-2);
        c0091aD27.b("Play Store version installed does not support multi-item purchases with season pass in one cart.");
        f5167u = c0091aD27.a();
        a.C0091a c0091aD28 = a.d();
        c0091aD28.d(-2);
        c0091aD28.b("Play Store version installed does not support querying AutoPay plan purchase.");
        f5168v = c0091aD28.a();
        a.C0091a c0091aD29 = a.d();
        c0091aD29.d(-2);
        c0091aD29.b("Play Store version installed does not support including suspended subscriptions.");
        f5169w = c0091aD29.a();
        a.C0091a c0091aD30 = a.d();
        c0091aD30.d(5);
        c0091aD30.b("Unknown feature");
        f5170x = c0091aD30.a();
        a.C0091a c0091aD31 = a.d();
        c0091aD31.d(-2);
        c0091aD31.b("Play Store version installed does not support get billing config.");
        f5171y = c0091aD31.a();
        a.C0091a c0091aD32 = a.d();
        c0091aD32.d(-2);
        c0091aD32.b("Query product details with serialized docid is not supported.");
        f5172z = c0091aD32.a();
        a.C0091a c0091aD33 = a.d();
        c0091aD33.d(-2);
        c0091aD33.b("Play Store version installed does not support launching external offer flow.");
        A = c0091aD33.a();
        a.C0091a c0091aD34 = a.d();
        c0091aD34.d(4);
        c0091aD34.b("Item is unavailable for purchase.");
        B = c0091aD34.a();
        a.C0091a c0091aD35 = a.d();
        c0091aD35.d(-2);
        c0091aD35.b("Query product details with developer specified account is not supported.");
        C = c0091aD35.a();
        a.C0091a c0091aD36 = a.d();
        c0091aD36.d(-2);
        c0091aD36.b("Play Store version installed does not support alternative billing only.");
        D = c0091aD36.a();
        a.C0091a c0091aD37 = a.d();
        c0091aD37.d(5);
        c0091aD37.b("To use this API you must specify a PurchasesUpdateListener when initializing a BillingClient.");
        E = c0091aD37.a();
        a.C0091a c0091aD38 = a.d();
        c0091aD38.d(6);
        c0091aD38.b("An error occurred while retrieving billing override.");
        F = c0091aD38.a();
        a.C0091a c0091aD39 = a.d();
        c0091aD39.d(-2);
        c0091aD39.b("Play Store version installed does not support the provided billing program.");
        c0091aD39.a();
    }

    public static a a(int i10, String str) {
        a.C0091a c0091aD = a.d();
        c0091aD.d(i10);
        c0091aD.b(str);
        return c0091aD.a();
    }
}
