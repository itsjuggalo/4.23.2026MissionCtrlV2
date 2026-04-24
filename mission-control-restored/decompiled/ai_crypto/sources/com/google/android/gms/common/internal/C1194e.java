package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.f;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import k2.C2066a;
import u.C2737b;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1194e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Account f11061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f11062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f11063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f11064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f11066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f11067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f11068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C2066a f11069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f11070j;

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.e$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Account f11071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C2737b f11072b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11073c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f11074d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final C2066a f11075e = C2066a.f17556j;

        public C1194e a() {
            return new C1194e(this.f11071a, this.f11072b, null, 0, null, this.f11073c, this.f11074d, this.f11075e, false);
        }

        public a b(String str) {
            this.f11073c = str;
            return this;
        }

        public final a c(Collection collection) {
            if (this.f11072b == null) {
                this.f11072b = new C2737b();
            }
            this.f11072b.addAll(collection);
            return this;
        }

        public final a d(Account account) {
            this.f11071a = account;
            return this;
        }

        public final a e(String str) {
            this.f11074d = str;
            return this;
        }
    }

    public C1194e(Account account, Set set, Map map, int i7, View view, String str, String str2, C2066a c2066a, boolean z7) {
        this.f11061a = account;
        Set setEmptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f11062b = setEmptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f11064d = map;
        this.f11066f = view;
        this.f11065e = i7;
        this.f11067g = str;
        this.f11068h = str2;
        this.f11069i = c2066a == null ? C2066a.f17556j : c2066a;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
        this.f11063c = Collections.unmodifiableSet(hashSet);
    }

    public static C1194e a(Context context) {
        return new f.a(context).a();
    }

    public Account b() {
        return this.f11061a;
    }

    public String c() {
        Account account = this.f11061a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    public Account d() {
        Account account = this.f11061a;
        return account != null ? account : new Account(AbstractC1192c.DEFAULT_ACCOUNT, "com.google");
    }

    public Set e() {
        return this.f11063c;
    }

    public Set f(com.google.android.gms.common.api.a aVar) {
        android.support.v4.media.session.b.a(this.f11064d.get(aVar));
        return this.f11062b;
    }

    public String g() {
        return this.f11067g;
    }

    public Set h() {
        return this.f11062b;
    }

    public final C2066a i() {
        return this.f11069i;
    }

    public final Integer j() {
        return this.f11070j;
    }

    public final String k() {
        return this.f11068h;
    }

    public final void l(Integer num) {
        this.f11070j = num;
    }
}
