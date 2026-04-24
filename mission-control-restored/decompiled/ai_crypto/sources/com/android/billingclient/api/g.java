package com.android.billingclient.api;

import Y0.t0;
import com.google.android.gms.internal.play_billing.zzco;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzco f10659a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public zzco f10660a;

        public /* synthetic */ a(t0 t0Var) {
        }

        public g a() {
            if (this.f10660a != null) {
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
            this.f10660a = zzco.zzk(list);
            return this;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f10662b;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f10663a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f10664b;

            public /* synthetic */ a(t0 t0Var) {
            }

            public b a() {
                if ("first_party".equals(this.f10664b)) {
                    throw new IllegalArgumentException("Serialized doc id must be provided for first party products.");
                }
                if (this.f10663a == null) {
                    throw new IllegalArgumentException("Product id must be provided.");
                }
                if (this.f10664b != null) {
                    return new b(this, null);
                }
                throw new IllegalArgumentException("Product type must be provided.");
            }

            public a b(String str) {
                this.f10663a = str;
                return this;
            }

            public a c(String str) {
                this.f10664b = str;
                return this;
            }
        }

        public /* synthetic */ b(a aVar, t0 t0Var) {
            this.f10661a = aVar.f10663a;
            this.f10662b = aVar.f10664b;
        }

        public static a a() {
            return new a(null);
        }

        public final String b() {
            return this.f10661a;
        }

        public final String c() {
            return this.f10662b;
        }
    }

    public /* synthetic */ g(a aVar, t0 t0Var) {
        this.f10659a = aVar.f10660a;
    }

    public static a a() {
        return new a(null);
    }

    public final zzco b() {
        return this.f10659a;
    }

    public final String c() {
        return ((b) this.f10659a.get(0)).c();
    }
}
