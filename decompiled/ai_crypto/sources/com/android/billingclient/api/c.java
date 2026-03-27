package com.android.billingclient.api;

import Y0.AbstractC0720d0;
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
    public boolean f10595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0177c f10598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zzco f10599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f10600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10601g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f10604c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList f10605d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f10606e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public C0177c.a f10607f;

        public /* synthetic */ a(AbstractC0720d0 abstractC0720d0) {
            C0177c.a aVarA = C0177c.a();
            C0177c.a.e(aVarA);
            this.f10607f = aVarA;
        }

        public c a() {
            ArrayList arrayList = this.f10605d;
            boolean z7 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            List list = this.f10604c;
            boolean z8 = (list == null || list.isEmpty()) ? false : true;
            if (!z7 && !z8) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if (z7 && z8) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            AbstractC0720d0 abstractC0720d0 = null;
            if (!z7) {
                this.f10604c.forEach(new Consumer() { // from class: Y0.c0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        if (((c.b) obj) == null) {
                            throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                        }
                    }
                });
            } else {
                if (this.f10605d.contains(null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                if (this.f10605d.size() > 1) {
                    android.support.v4.media.session.b.a(this.f10605d.get(0));
                    throw null;
                }
            }
            c cVar = new c(abstractC0720d0);
            if (z7) {
                android.support.v4.media.session.b.a(this.f10605d.get(0));
                throw null;
            }
            cVar.f10595a = z8 && !((b) this.f10604c.get(0)).b().h().isEmpty();
            cVar.f10596b = this.f10602a;
            cVar.f10597c = this.f10603b;
            cVar.f10598d = this.f10607f.a();
            ArrayList arrayList2 = this.f10605d;
            cVar.f10600f = arrayList2 != null ? new ArrayList(arrayList2) : new ArrayList();
            cVar.f10601g = this.f10606e;
            List list2 = this.f10604c;
            cVar.f10599e = list2 != null ? zzco.zzk(list2) : zzco.zzl();
            return cVar;
        }

        public a b(boolean z7) {
            this.f10606e = z7;
            return this;
        }

        public a c(String str) {
            this.f10602a = str;
            return this;
        }

        public a d(List list) {
            this.f10604c = new ArrayList(list);
            return this;
        }

        public a e(C0177c c0177c) {
            this.f10607f = C0177c.c(c0177c);
            return this;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f10608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f10609b;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public f f10610a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f10611b;

            public /* synthetic */ a(AbstractC0720d0 abstractC0720d0) {
            }

            public b a() {
                zzbe.zzc(this.f10610a, "ProductDetails is required for constructing ProductDetailsParams.");
                if (this.f10610a.f() != null) {
                    zzbe.zzc(this.f10611b, "offerToken is required for constructing ProductDetailsParams for subscriptions.");
                }
                return new b(this, null);
            }

            public a b(String str) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("offerToken can not be empty");
                }
                this.f10611b = str;
                return this;
            }

            public a c(f fVar) {
                this.f10610a = fVar;
                if (fVar.c() != null) {
                    fVar.c().getClass();
                    f.b bVarC = fVar.c();
                    if (bVarC.e() != null) {
                        this.f10611b = bVarC.e();
                    }
                }
                return this;
            }
        }

        public /* synthetic */ b(a aVar, AbstractC0720d0 abstractC0720d0) {
            this.f10608a = aVar.f10610a;
            this.f10609b = aVar.f10611b;
        }

        public static a a() {
            return new a(null);
        }

        public final f b() {
            return this.f10608a;
        }

        public final String c() {
            return this.f10609b;
        }
    }

    /* JADX INFO: renamed from: com.android.billingclient.api.c$c, reason: collision with other inner class name */
    public static class C0177c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f10614c = 0;

        /* JADX INFO: renamed from: com.android.billingclient.api.c$c$a */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f10615a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f10616b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f10617c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f10618d = 0;

            public /* synthetic */ a(AbstractC0720d0 abstractC0720d0) {
            }

            public static /* synthetic */ a e(a aVar) {
                aVar.f10617c = true;
                return aVar;
            }

            public C0177c a() {
                boolean z7 = true;
                AbstractC0720d0 abstractC0720d0 = null;
                if (TextUtils.isEmpty(this.f10615a) && TextUtils.isEmpty(null)) {
                    z7 = false;
                }
                boolean zIsEmpty = TextUtils.isEmpty(this.f10616b);
                if (z7 && !zIsEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if (!this.f10617c && !z7 && zIsEmpty) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                C0177c c0177c = new C0177c(abstractC0720d0);
                c0177c.f10612a = this.f10615a;
                c0177c.f10614c = this.f10618d;
                c0177c.f10613b = this.f10616b;
                return c0177c;
            }

            public a b(String str) {
                this.f10615a = str;
                return this;
            }

            public a c(String str) {
                this.f10616b = str;
                return this;
            }

            public a d(int i7) {
                this.f10618d = i7;
                return this;
            }

            public final a f(String str) {
                this.f10615a = str;
                return this;
            }
        }

        public /* synthetic */ C0177c(AbstractC0720d0 abstractC0720d0) {
        }

        public static a a() {
            return new a(null);
        }

        public static /* bridge */ /* synthetic */ a c(C0177c c0177c) {
            a aVarA = a();
            aVarA.f(c0177c.f10612a);
            aVarA.d(c0177c.f10614c);
            aVarA.c(c0177c.f10613b);
            return aVarA;
        }

        public final int b() {
            return this.f10614c;
        }

        public final String d() {
            return this.f10612a;
        }

        public final String e() {
            return this.f10613b;
        }
    }

    public /* synthetic */ c(AbstractC0720d0 abstractC0720d0) {
    }

    public static a a() {
        return new a(null);
    }

    public final int b() {
        return this.f10598d.b();
    }

    public final d c() {
        if (this.f10599e.isEmpty()) {
            return k.f10693l;
        }
        b bVar = (b) this.f10599e.get(0);
        for (int i7 = 1; i7 < this.f10599e.size(); i7++) {
            b bVar2 = (b) this.f10599e.get(i7);
            if (!bVar2.b().e().equals(bVar.b().e()) && !bVar2.b().e().equals("play_pass_subs")) {
                return k.a(5, "All products should have same ProductType.");
            }
        }
        String strH = bVar.b().h();
        HashSet hashSet = new HashSet();
        HashSet<String> hashSet2 = new HashSet();
        zzco zzcoVar = this.f10599e;
        int size = zzcoVar.size();
        for (int i8 = 0; i8 < size; i8++) {
            b bVar3 = (b) zzcoVar.get(i8);
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
        return (bVarC == null || bVarC.d() == null) ? k.f10693l : k.a(5, "Both autoPayDetails and autoPayBalanceThreshold is required for constructing ProductDetailsParams for autopay.");
    }

    public final String d() {
        return this.f10596b;
    }

    public final String e() {
        return this.f10597c;
    }

    public final String f() {
        return this.f10598d.d();
    }

    public final String g() {
        return this.f10598d.e();
    }

    public final ArrayList h() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f10600f);
        return arrayList;
    }

    public final List i() {
        return this.f10599e;
    }

    public final boolean q() {
        return this.f10601g;
    }

    public final boolean r() {
        return (this.f10596b == null && this.f10597c == null && this.f10598d.e() == null && this.f10598d.b() == 0 && !this.f10599e.stream().anyMatch(new Predicate() { // from class: Y0.b0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return false;
            }
        }) && !this.f10595a && !this.f10601g) ? false : true;
    }
}
