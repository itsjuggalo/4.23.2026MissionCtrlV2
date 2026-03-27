package com.android.billingclient.api;

import H0.AbstractC0299d0;
import android.text.TextUtils;
import com.android.billingclient.api.c;
import com.android.billingclient.api.f;
import com.google.android.gms.internal.play_billing.zzbe;
import com.google.android.gms.internal.play_billing.zzco;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0144c f9413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zzco f9414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f9415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9416g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f9418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f9419c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList f9420d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f9421e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public C0144c.a f9422f;

        public /* synthetic */ a(AbstractC0299d0 abstractC0299d0) {
            C0144c.a aVarA = C0144c.a();
            C0144c.a.e(aVarA);
            this.f9422f = aVarA;
        }

        public c a() {
            ArrayList arrayList = this.f9420d;
            boolean z4 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            List list = this.f9419c;
            boolean z5 = (list == null || list.isEmpty()) ? false : true;
            if (!z4 && !z5) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if (z4 && z5) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            AbstractC0299d0 abstractC0299d0 = null;
            if (!z4) {
                this.f9419c.forEach(new Consumer() { // from class: H0.c0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        if (((c.b) obj) == null) {
                            throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                        }
                    }
                });
            } else {
                if (this.f9420d.contains(null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                if (this.f9420d.size() > 1) {
                    android.support.v4.media.session.b.a(this.f9420d.get(0));
                    throw null;
                }
            }
            c cVar = new c(abstractC0299d0);
            if (z4) {
                android.support.v4.media.session.b.a(this.f9420d.get(0));
                throw null;
            }
            cVar.f9410a = z5 && !((b) this.f9419c.get(0)).b().h().isEmpty();
            cVar.f9411b = this.f9417a;
            cVar.f9412c = this.f9418b;
            cVar.f9413d = this.f9422f.a();
            ArrayList arrayList2 = this.f9420d;
            cVar.f9415f = arrayList2 != null ? new ArrayList(arrayList2) : new ArrayList();
            cVar.f9416g = this.f9421e;
            List list2 = this.f9419c;
            cVar.f9414e = list2 != null ? zzco.zzk(list2) : zzco.zzl();
            return cVar;
        }

        public a b(boolean z4) {
            this.f9421e = z4;
            return this;
        }

        public a c(String str) {
            this.f9417a = str;
            return this;
        }

        public a d(List list) {
            this.f9419c = new ArrayList(list);
            return this;
        }

        public a e(C0144c c0144c) {
            this.f9422f = C0144c.c(c0144c);
            return this;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f9423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f9424b;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public f f9425a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f9426b;

            public /* synthetic */ a(AbstractC0299d0 abstractC0299d0) {
            }

            public b a() {
                zzbe.zzc(this.f9425a, "ProductDetails is required for constructing ProductDetailsParams.");
                if (this.f9425a.f() != null) {
                    zzbe.zzc(this.f9426b, "offerToken is required for constructing ProductDetailsParams for subscriptions.");
                }
                return new b(this, null);
            }

            public a b(String str) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("offerToken can not be empty");
                }
                this.f9426b = str;
                return this;
            }

            public a c(f fVar) {
                this.f9425a = fVar;
                if (fVar.c() != null) {
                    fVar.c().getClass();
                    f.b bVarC = fVar.c();
                    if (bVarC.e() != null) {
                        this.f9426b = bVarC.e();
                    }
                }
                return this;
            }
        }

        public /* synthetic */ b(a aVar, AbstractC0299d0 abstractC0299d0) {
            this.f9423a = aVar.f9425a;
            this.f9424b = aVar.f9426b;
        }

        public static a a() {
            return new a(null);
        }

        public final f b() {
            return this.f9423a;
        }

        public final String c() {
            return this.f9424b;
        }
    }

    /* JADX INFO: renamed from: com.android.billingclient.api.c$c, reason: collision with other inner class name */
    public static class C0144c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f9428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9429c = 0;

        /* JADX INFO: renamed from: com.android.billingclient.api.c$c$a */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f9430a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f9431b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f9432c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f9433d = 0;

            public /* synthetic */ a(AbstractC0299d0 abstractC0299d0) {
            }

            public static /* synthetic */ a e(a aVar) {
                aVar.f9432c = true;
                return aVar;
            }

            public C0144c a() {
                boolean z4 = true;
                AbstractC0299d0 abstractC0299d0 = null;
                if (TextUtils.isEmpty(this.f9430a) && TextUtils.isEmpty(null)) {
                    z4 = false;
                }
                boolean zIsEmpty = TextUtils.isEmpty(this.f9431b);
                if (z4 && !zIsEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if (!this.f9432c && !z4 && zIsEmpty) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                C0144c c0144c = new C0144c(abstractC0299d0);
                c0144c.f9427a = this.f9430a;
                c0144c.f9429c = this.f9433d;
                c0144c.f9428b = this.f9431b;
                return c0144c;
            }

            public a b(String str) {
                this.f9430a = str;
                return this;
            }

            public a c(String str) {
                this.f9431b = str;
                return this;
            }

            public a d(int i4) {
                this.f9433d = i4;
                return this;
            }

            public final a f(String str) {
                this.f9430a = str;
                return this;
            }
        }

        public /* synthetic */ C0144c(AbstractC0299d0 abstractC0299d0) {
        }

        public static a a() {
            return new a(null);
        }

        public static /* bridge */ /* synthetic */ a c(C0144c c0144c) {
            a aVarA = a();
            aVarA.f(c0144c.f9427a);
            aVarA.d(c0144c.f9429c);
            aVarA.c(c0144c.f9428b);
            return aVarA;
        }

        public final int b() {
            return this.f9429c;
        }

        public final String d() {
            return this.f9427a;
        }

        public final String e() {
            return this.f9428b;
        }
    }

    public /* synthetic */ c(AbstractC0299d0 abstractC0299d0) {
    }

    public static a a() {
        return new a(null);
    }

    public final int b() {
        return this.f9413d.b();
    }

    public final d c() {
        if (this.f9414e.isEmpty()) {
            return k.f9508l;
        }
        b bVar = (b) this.f9414e.get(0);
        for (int i4 = 1; i4 < this.f9414e.size(); i4++) {
            b bVar2 = (b) this.f9414e.get(i4);
            if (!bVar2.b().e().equals(bVar.b().e()) && !bVar2.b().e().equals("play_pass_subs")) {
                return k.a(5, "All products should have same ProductType.");
            }
        }
        String strH = bVar.b().h();
        HashSet hashSet = new HashSet();
        HashSet<String> hashSet2 = new HashSet();
        zzco zzcoVar = this.f9414e;
        int size = zzcoVar.size();
        for (int i5 = 0; i5 < size; i5++) {
            b bVar3 = (b) zzcoVar.get(i5);
            bVar3.b().e().equals("subs");
            if (hashSet.contains(bVar3.b().d())) {
                return k.a(5, String.format("ProductId can not be duplicated. Invalid product id: %s.", bVar3.b().d()));
            }
            hashSet.add(bVar3.b().d());
            if (!bVar.b().e().equals("play_pass_subs") && !bVar3.b().e().equals("play_pass_subs") && !strH.equals(bVar3.b().h())) {
                return k.a(5, "All products must have the same package name.");
            }
        }
        for (String str : hashSet2) {
            if (hashSet.contains(str)) {
                return k.a(5, String.format("OldProductId must not be one of the products to be purchased. Invalid old product id: %s.", str));
            }
        }
        f.b bVarC = bVar.b().c();
        return (bVarC == null || bVarC.d() == null) ? k.f9508l : k.a(5, "Both autoPayDetails and autoPayBalanceThreshold is required for constructing ProductDetailsParams for autopay.");
    }

    public final String d() {
        return this.f9411b;
    }

    public final String e() {
        return this.f9412c;
    }

    public final String f() {
        return this.f9413d.d();
    }

    public final String g() {
        return this.f9413d.e();
    }

    public final ArrayList h() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f9415f);
        return arrayList;
    }

    public final List i() {
        return this.f9414e;
    }

    public final boolean q() {
        return this.f9416g;
    }

    public final boolean r() {
        return (this.f9411b == null && this.f9412c == null && this.f9413d.e() == null && this.f9413d.b() == 0 && !this.f9414e.stream().anyMatch(new Predicate() { // from class: H0.b0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return false;
            }
        }) && !this.f9410a && !this.f9416g) ? false : true;
    }
}
