package com.android.billingclient.api;

import H0.t0;
import com.google.android.gms.internal.play_billing.zzco;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzco f9474a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public zzco f9475a;

        public /* synthetic */ a(t0 t0Var) {
        }

        public g a() {
            if (this.f9475a != null) {
                return new g(this, null);
            }
            throw new IllegalArgumentException("Product list must be set to a non empty list.");
        }

        public a b(List list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Product list cannot be empty.");
            }
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (!"play_pass_subs".equals(bVar.c())) {
                    hashSet.add(bVar.c());
                }
            }
            if (hashSet.size() > 1) {
                throw new IllegalArgumentException("All products should be of the same product type.");
            }
            this.f9475a = zzco.zzk(list);
            return this;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f9477b;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f9478a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f9479b;

            public /* synthetic */ a(t0 t0Var) {
            }

            public b a() {
                if ("first_party".equals(this.f9479b)) {
                    throw new IllegalArgumentException("Serialized doc id must be provided for first party products.");
                }
                if (this.f9478a == null) {
                    throw new IllegalArgumentException("Product id must be provided.");
                }
                if (this.f9479b != null) {
                    return new b(this, null);
                }
                throw new IllegalArgumentException("Product type must be provided.");
            }

            public a b(String str) {
                this.f9478a = str;
                return this;
            }

            public a c(String str) {
                this.f9479b = str;
                return this;
            }
        }

        public /* synthetic */ b(a aVar, t0 t0Var) {
            this.f9476a = aVar.f9478a;
            this.f9477b = aVar.f9479b;
        }

        public static a a() {
            return new a(null);
        }

        public final String b() {
            return this.f9476a;
        }

        public final String c() {
            return this.f9477b;
        }
    }

    public /* synthetic */ g(a aVar, t0 t0Var) {
        this.f9474a = aVar.f9475a;
    }

    public static a a() {
        return new a(null);
    }

    public final zzco b() {
        return this.f9474a;
    }

    public final String c() {
        return ((b) this.f9474a.get(0)).c();
    }
}
