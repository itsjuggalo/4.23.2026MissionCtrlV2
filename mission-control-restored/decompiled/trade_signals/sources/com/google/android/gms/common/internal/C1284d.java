package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import i2.C1914a;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1284d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Account f14959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f14960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f14961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f14962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f14964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f14965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f14966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C1914a f14967i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f14968j;

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.d$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Account f14969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public w.b f14970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f14971c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f14972d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final C1914a f14973e = C1914a.f18762j;

        public C1284d a() {
            return new C1284d(this.f14969a, this.f14970b, null, 0, null, this.f14971c, this.f14972d, this.f14973e, false);
        }

        public a b(String str) {
            this.f14971c = str;
            return this;
        }

        public final a c(Collection collection) {
            if (this.f14970b == null) {
                this.f14970b = new w.b();
            }
            this.f14970b.addAll(collection);
            return this;
        }

        public final a d(Account account) {
            this.f14969a = account;
            return this;
        }

        public final a e(String str) {
            this.f14972d = str;
            return this;
        }
    }

    public C1284d(Account account, Set set, Map map, int i8, View view, String str, String str2, C1914a c1914a, boolean z7) {
        this.f14959a = account;
        Set setEmptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f14960b = setEmptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f14962d = map;
        this.f14964f = view;
        this.f14963e = i8;
        this.f14965g = str;
        this.f14966h = str2;
        this.f14967i = c1914a == null ? C1914a.f18762j : c1914a;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
        this.f14961c = Collections.unmodifiableSet(hashSet);
    }

    public Account a() {
        return this.f14959a;
    }

    public Account b() {
        Account account = this.f14959a;
        return account != null ? account : new Account(AbstractC1283c.DEFAULT_ACCOUNT, "com.google");
    }

    public Set c() {
        return this.f14961c;
    }

    public String d() {
        return this.f14965g;
    }

    public Set e() {
        return this.f14960b;
    }

    public final C1914a f() {
        return this.f14967i;
    }

    public final Integer g() {
        return this.f14968j;
    }

    public final String h() {
        return this.f14966h;
    }

    public final void i(Integer num) {
        this.f14968j = num;
    }
}
