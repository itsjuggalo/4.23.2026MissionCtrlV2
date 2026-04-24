package R0;

import R0.C0834q;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: R0.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0818i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f6973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.google.android.gms.internal.play_billing.N f6974e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f6975f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6976g;

    /* JADX INFO: renamed from: R0.i$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f6978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f6979c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList f6980d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f6981e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c.a f6982f;

        public /* synthetic */ a(AbstractC0833p0 abstractC0833p0) {
            c.a aVarA = c.a();
            c.a.e(aVarA);
            this.f6982f = aVarA;
        }

        public C0818i a() {
            ArrayList arrayList = this.f6980d;
            boolean z7 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            List list = this.f6979c;
            boolean z8 = (list == null || list.isEmpty()) ? false : true;
            if (!z7 && !z8) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if (z7 && z8) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            AbstractC0833p0 abstractC0833p0 = null;
            if (!z7) {
                List list2 = this.f6979c;
                if (list2 != null) {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        if (((b) it.next()) == null) {
                            throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                        }
                    }
                }
            } else {
                if (this.f6980d.contains(null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                if (this.f6980d.size() > 1) {
                    android.support.v4.media.session.b.a(this.f6980d.get(0));
                    throw null;
                }
            }
            C0818i c0818i = new C0818i(abstractC0833p0);
            if (z7) {
                android.support.v4.media.session.b.a(this.f6980d.get(0));
                throw null;
            }
            c0818i.f6970a = z8 && !((b) this.f6979c.get(0)).b().i().isEmpty();
            c0818i.f6971b = this.f6977a;
            c0818i.f6972c = this.f6978b;
            c0818i.f6973d = this.f6982f.a();
            ArrayList arrayList2 = this.f6980d;
            c0818i.f6975f = arrayList2 != null ? new ArrayList(arrayList2) : new ArrayList();
            c0818i.f6976g = this.f6981e;
            List list3 = this.f6979c;
            c0818i.f6974e = list3 != null ? com.google.android.gms.internal.play_billing.N.H(list3) : com.google.android.gms.internal.play_billing.N.I();
            return c0818i;
        }

        public a b(boolean z7) {
            this.f6981e = z7;
            return this;
        }

        public a c(String str) {
            this.f6977a = str;
            return this;
        }

        public a d(List list) {
            this.f6979c = new ArrayList(list);
            return this;
        }

        public a e(c cVar) {
            this.f6982f = c.c(cVar);
            return this;
        }
    }

    /* JADX INFO: renamed from: R0.i$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0834q f6983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f6984b;

        /* JADX INFO: renamed from: R0.i$b$a */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public C0834q f6985a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f6986b;

            public /* synthetic */ a(AbstractC0833p0 abstractC0833p0) {
            }

            public b a() {
                com.google.android.gms.internal.play_billing.A.c(this.f6985a, "ProductDetails is required for constructing ProductDetailsParams.");
                return new b(this, null);
            }

            public a b(String str) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("offerToken can not be empty");
                }
                this.f6986b = str;
                return this;
            }

            public a c(C0834q c0834q) {
                this.f6985a = c0834q;
                if (c0834q.c() != null) {
                    c0834q.c().getClass();
                    C0834q.b bVarC = c0834q.c();
                    if (bVarC.b() != null) {
                        this.f6986b = bVarC.b();
                    }
                }
                return this;
            }
        }

        public /* synthetic */ b(a aVar, AbstractC0833p0 abstractC0833p0) {
            this.f6983a = aVar.f6985a;
            this.f6984b = aVar.f6986b;
        }

        public static a a() {
            return new a(null);
        }

        public final C0834q b() {
            return this.f6983a;
        }

        public final String c() {
            return this.f6984b;
        }
    }

    /* JADX INFO: renamed from: R0.i$c */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f6988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6989c = 0;

        /* JADX INFO: renamed from: R0.i$c$a */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f6990a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f6991b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f6992c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f6993d = 0;

            public /* synthetic */ a(AbstractC0833p0 abstractC0833p0) {
            }

            public static /* synthetic */ a e(a aVar) {
                aVar.f6992c = true;
                return aVar;
            }

            public c a() {
                AbstractC0833p0 abstractC0833p0 = null;
                boolean z7 = (TextUtils.isEmpty(this.f6990a) && TextUtils.isEmpty(null)) ? false : true;
                boolean zIsEmpty = true ^ TextUtils.isEmpty(this.f6991b);
                if (z7 && zIsEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if (!this.f6992c && !z7 && !zIsEmpty) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                c cVar = new c(abstractC0833p0);
                cVar.f6987a = this.f6990a;
                cVar.f6989c = this.f6993d;
                cVar.f6988b = this.f6991b;
                return cVar;
            }

            public a b(String str) {
                this.f6990a = str;
                return this;
            }

            public a c(String str) {
                this.f6991b = str;
                return this;
            }

            public a d(int i8) {
                this.f6993d = i8;
                return this;
            }

            public final a f(String str) {
                this.f6990a = str;
                return this;
            }
        }

        public /* synthetic */ c(AbstractC0833p0 abstractC0833p0) {
        }

        public static a a() {
            return new a(null);
        }

        public static /* bridge */ /* synthetic */ a c(c cVar) {
            a aVarA = a();
            aVarA.f(cVar.f6987a);
            aVarA.d(cVar.f6989c);
            aVarA.c(cVar.f6988b);
            return aVarA;
        }

        public final int b() {
            return this.f6989c;
        }

        public final String d() {
            return this.f6987a;
        }

        public final String e() {
            return this.f6988b;
        }
    }

    public /* synthetic */ C0818i(AbstractC0833p0 abstractC0833p0) {
    }

    public static a a() {
        return new a(null);
    }

    public int b() {
        return 0;
    }

    public final int c() {
        return this.f6973d.b();
    }

    public long d() {
        return 0L;
    }

    public final com.android.billingclient.api.a e() {
        C0834q.b bVar;
        String str;
        if (this.f6974e.isEmpty()) {
            return com.android.billingclient.api.c.f14692i;
        }
        int i8 = 0;
        b bVar2 = (b) this.f6974e.get(0);
        int i9 = 1;
        while (true) {
            if (i9 < this.f6974e.size()) {
                b bVar3 = (b) this.f6974e.get(i9);
                if (!bVar3.b().f().equals(bVar2.b().f()) && !bVar3.b().f().equals("play_pass_subs")) {
                    str = "All products should have same ProductType.";
                    break;
                }
                i9++;
            } else {
                String strI = bVar2.b().i();
                HashMap map = new HashMap();
                HashSet hashSet = new HashSet();
                com.google.android.gms.internal.play_billing.N n8 = this.f6974e;
                int size = n8.size();
                while (true) {
                    if (i8 < size) {
                        b bVar4 = (b) n8.get(i8);
                        if (bVar4.b().g() != null && bVar4.c() == null) {
                            str = String.format("offerToken is required for constructing ProductDetailsParams for subscriptions. Missing value for product id: %s", bVar4.b().e());
                            break;
                        }
                        if (!map.containsKey(bVar4.b().e())) {
                            map.put(bVar4.b().e(), bVar4);
                            if (!bVar2.b().f().equals("play_pass_subs") && !bVar4.b().f().equals("play_pass_subs") && !strI.equals(bVar4.b().i())) {
                                str = "All products must have the same package name.";
                                break;
                            }
                            i8++;
                        } else {
                            str = String.format("ProductId can not be duplicated. Invalid product id: %s.", bVar4.b().e());
                            break;
                        }
                    } else {
                        Iterator it = hashSet.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                List listD = bVar2.b().d();
                                String strC = bVar2.c();
                                if (strC != null && listD != null) {
                                    Iterator it2 = listD.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            bVar = null;
                                            break;
                                        }
                                        bVar = (C0834q.b) it2.next();
                                        if (strC.equals(bVar.b())) {
                                            break;
                                        }
                                    }
                                    if (bVar != null && bVar.e() != null) {
                                        str = "Both autoPayDetails and autoPayBalanceThreshold is required for constructing ProductDetailsParams for autopay.";
                                    }
                                }
                                return com.android.billingclient.api.c.f14692i;
                            }
                            String str2 = (String) it.next();
                            if (map.containsKey(str2)) {
                                str = String.format("OldProductId must not be one of the products to be purchased. Invalid old product id: %s.", str2);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return com.android.billingclient.api.c.a(5, str);
    }

    public final String f() {
        return this.f6971b;
    }

    public final String g() {
        return this.f6972c;
    }

    public String h() {
        return null;
    }

    public final String i() {
        return this.f6973d.d();
    }

    public final String j() {
        return this.f6973d.e();
    }

    public final ArrayList k() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f6975f);
        return arrayList;
    }

    public final List l() {
        return this.f6974e;
    }

    public final boolean t() {
        return this.f6976g;
    }

    public final boolean u() {
        if (this.f6971b != null || this.f6972c != null || this.f6973d.e() != null || this.f6973d.b() != 0 || this.f6970a || this.f6976g) {
            return true;
        }
        com.google.android.gms.internal.play_billing.N n8 = this.f6974e;
        if (n8 != null) {
            int size = n8.size();
            for (int i8 = 0; i8 < size; i8++) {
            }
        }
        return false;
    }
}
