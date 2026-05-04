package d3;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzbg;
import com.google.android.gms.internal.play_billing.zzbt;
import d3.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f7650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zzbt f7651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f7652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7653g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f7656c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList f7657d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7658e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c.a f7659f;

        public /* synthetic */ a(n1 n1Var) {
            c.a aVarA = c.a();
            c.a.e(aVarA);
            this.f7659f = aVarA;
        }

        public h a() {
            ArrayList arrayList = this.f7657d;
            boolean z10 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            List list = this.f7656c;
            boolean z11 = (list == null || list.isEmpty()) ? false : true;
            if (!z10 && !z11) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if (z10 && z11) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            n1 n1Var = null;
            if (!z10) {
                List list2 = this.f7656c;
                if (list2 != null) {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        if (((b) it.next()) == null) {
                            throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                        }
                    }
                }
            } else {
                if (this.f7657d.contains(null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                if (this.f7657d.size() > 1) {
                    android.support.v4.media.session.b.a(this.f7657d.get(0));
                    throw null;
                }
            }
            h hVar = new h(n1Var);
            if (z10) {
                android.support.v4.media.session.b.a(this.f7657d.get(0));
                throw null;
            }
            hVar.f7647a = z11 && !((b) this.f7656c.get(0)).b().i().isEmpty();
            hVar.f7648b = this.f7654a;
            hVar.f7649c = this.f7655b;
            hVar.f7650d = this.f7659f.a();
            ArrayList arrayList2 = this.f7657d;
            hVar.f7652f = arrayList2 != null ? new ArrayList(arrayList2) : new ArrayList();
            hVar.f7653g = this.f7658e;
            List list3 = this.f7656c;
            hVar.f7651e = list3 != null ? zzbt.zzj(list3) : zzbt.zzk();
            return hVar;
        }

        public a b(boolean z10) {
            this.f7658e = z10;
            return this;
        }

        public a c(String str) {
            this.f7654a = str;
            return this;
        }

        public a d(List list) {
            this.f7656c = new ArrayList(list);
            return this;
        }

        public a e(c cVar) {
            this.f7659f = c.c(cVar);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f7660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7661b;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public p f7662a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f7663b;

            public /* synthetic */ a(n1 n1Var) {
            }

            public b a() {
                zzbg.zzc(this.f7662a, "ProductDetails is required for constructing ProductDetailsParams.");
                return new b(this, null);
            }

            public a b(String str) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("offerToken can not be empty");
                }
                this.f7663b = str;
                return this;
            }

            public a c(p pVar) {
                this.f7662a = pVar;
                if (pVar.c() != null) {
                    pVar.c().getClass();
                    p.b bVarC = pVar.c();
                    if (bVarC.b() != null) {
                        this.f7663b = bVarC.b();
                    }
                }
                return this;
            }
        }

        public /* synthetic */ b(a aVar, n1 n1Var) {
            this.f7660a = aVar.f7662a;
            this.f7661b = aVar.f7663b;
        }

        public static a a() {
            return new a(null);
        }

        public final p b() {
            return this.f7660a;
        }

        public final String c() {
            return this.f7661b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7666c = 0;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f7667a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f7668b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f7669c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f7670d = 0;

            public /* synthetic */ a(n1 n1Var) {
            }

            public static /* synthetic */ a e(a aVar) {
                aVar.f7669c = true;
                return aVar;
            }

            public c a() {
                boolean z10 = true;
                n1 n1Var = null;
                if (TextUtils.isEmpty(this.f7667a) && TextUtils.isEmpty(null)) {
                    z10 = false;
                }
                boolean zIsEmpty = TextUtils.isEmpty(this.f7668b);
                if (z10 && !zIsEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if (!this.f7669c && !z10 && zIsEmpty) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                c cVar = new c(n1Var);
                cVar.f7664a = this.f7667a;
                cVar.f7666c = this.f7670d;
                cVar.f7665b = this.f7668b;
                return cVar;
            }

            public a b(String str) {
                this.f7667a = str;
                return this;
            }

            public a c(String str) {
                this.f7668b = str;
                return this;
            }

            public a d(int i10) {
                this.f7670d = i10;
                return this;
            }

            public final a f(String str) {
                this.f7667a = str;
                return this;
            }
        }

        public /* synthetic */ c(n1 n1Var) {
        }

        public static a a() {
            return new a(null);
        }

        public static /* bridge */ /* synthetic */ a c(c cVar) {
            a aVarA = a();
            aVarA.f(cVar.f7664a);
            aVarA.d(cVar.f7666c);
            aVarA.c(cVar.f7665b);
            return aVarA;
        }

        public final int b() {
            return this.f7666c;
        }

        public final String d() {
            return this.f7664a;
        }

        public final String e() {
            return this.f7665b;
        }
    }

    public /* synthetic */ h(n1 n1Var) {
    }

    public static a a() {
        return new a(null);
    }

    public int b() {
        return 0;
    }

    public final int c() {
        return this.f7650d.b();
    }

    public long d() {
        return 0L;
    }

    public final com.android.billingclient.api.a e() {
        p.b bVar;
        if (this.f7651e.isEmpty()) {
            return com.android.billingclient.api.c.f5155i;
        }
        b bVar2 = (b) this.f7651e.get(0);
        for (int i10 = 1; i10 < this.f7651e.size(); i10++) {
            b bVar3 = (b) this.f7651e.get(i10);
            if (!bVar3.b().f().equals(bVar2.b().f()) && !bVar3.b().f().equals("play_pass_subs")) {
                return com.android.billingclient.api.c.a(5, "All products should have same ProductType.");
            }
        }
        String strI = bVar2.b().i();
        HashMap map = new HashMap();
        HashSet<String> hashSet = new HashSet();
        zzbt zzbtVar = this.f7651e;
        int size = zzbtVar.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar4 = (b) zzbtVar.get(i11);
            if (bVar4.b().g() != null && bVar4.c() == null) {
                return com.android.billingclient.api.c.a(5, String.format("offerToken is required for constructing ProductDetailsParams for subscriptions. Missing value for product id: %s", bVar4.b().e()));
            }
            if (map.containsKey(bVar4.b().e())) {
                return com.android.billingclient.api.c.a(5, String.format("ProductId can not be duplicated. Invalid product id: %s.", bVar4.b().e()));
            }
            map.put(bVar4.b().e(), bVar4);
            if (!bVar2.b().f().equals("play_pass_subs") && !bVar4.b().f().equals("play_pass_subs") && !strI.equals(bVar4.b().i())) {
                return com.android.billingclient.api.c.a(5, "All products must have the same package name.");
            }
        }
        for (String str : hashSet) {
            if (map.containsKey(str)) {
                return com.android.billingclient.api.c.a(5, String.format("OldProductId must not be one of the products to be purchased. Invalid old product id: %s.", str));
            }
        }
        List listD = bVar2.b().d();
        String strC = bVar2.c();
        if (strC != null && listD != null) {
            Iterator it = listD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bVar = null;
                    break;
                }
                bVar = (p.b) it.next();
                if (strC.equals(bVar.b())) {
                    break;
                }
            }
            if (bVar != null && bVar.e() != null) {
                return com.android.billingclient.api.c.a(5, "Both autoPayDetails and autoPayBalanceThreshold is required for constructing ProductDetailsParams for autopay.");
            }
        }
        return com.android.billingclient.api.c.f5155i;
    }

    public final String f() {
        return this.f7648b;
    }

    public final String g() {
        return this.f7649c;
    }

    public String h() {
        return null;
    }

    public final String i() {
        return this.f7650d.d();
    }

    public final String j() {
        return this.f7650d.e();
    }

    public final ArrayList k() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f7652f);
        return arrayList;
    }

    public final List l() {
        return this.f7651e;
    }

    public final boolean t() {
        return this.f7653g;
    }

    public final boolean u() {
        if (this.f7648b != null || this.f7649c != null || this.f7650d.e() != null || this.f7650d.b() != 0 || this.f7647a || this.f7653g) {
            return true;
        }
        zzbt zzbtVar = this.f7651e;
        if (zzbtVar != null) {
            int size = zzbtVar.size();
            for (int i10 = 0; i10 < size; i10++) {
            }
        }
        return false;
    }
}
