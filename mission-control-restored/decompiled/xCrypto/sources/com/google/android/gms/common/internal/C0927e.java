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
import u.C1854b;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0927e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Account f9878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f9879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f9880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f9881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f9883f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9884g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f9885h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final U1.a f9886i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f9887j;

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.e$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Account f9888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C1854b f9889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f9890c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f9891d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final U1.a f9892e = U1.a.f5249j;

        public C0927e a() {
            return new C0927e(this.f9888a, this.f9889b, null, 0, null, this.f9890c, this.f9891d, this.f9892e, false);
        }

        public a b(String str) {
            this.f9890c = str;
            return this;
        }

        public final a c(Collection collection) {
            if (this.f9889b == null) {
                this.f9889b = new C1854b();
            }
            this.f9889b.addAll(collection);
            return this;
        }

        public final a d(Account account) {
            this.f9888a = account;
            return this;
        }

        public final a e(String str) {
            this.f9891d = str;
            return this;
        }
    }

    public C0927e(Account account, Set set, Map map, int i4, View view, String str, String str2, U1.a aVar, boolean z4) {
        this.f9878a = account;
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f9879b = setUnmodifiableSet;
        map = map == null ? Collections.EMPTY_MAP : map;
        this.f9881d = map;
        this.f9883f = view;
        this.f9882e = i4;
        this.f9884g = str;
        this.f9885h = str2;
        this.f9886i = aVar == null ? U1.a.f5249j : aVar;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
        this.f9880c = Collections.unmodifiableSet(hashSet);
    }

    public static C0927e a(Context context) {
        return new f.a(context).a();
    }

    public Account b() {
        return this.f9878a;
    }

    public String c() {
        Account account = this.f9878a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    public Account d() {
        Account account = this.f9878a;
        return account != null ? account : new Account(AbstractC0925c.DEFAULT_ACCOUNT, "com.google");
    }

    public Set e() {
        return this.f9880c;
    }

    public Set f(com.google.android.gms.common.api.a aVar) {
        android.support.v4.media.session.b.a(this.f9881d.get(aVar));
        return this.f9879b;
    }

    public String g() {
        return this.f9884g;
    }

    public Set h() {
        return this.f9879b;
    }

    public final U1.a i() {
        return this.f9886i;
    }

    public final Integer j() {
        return this.f9887j;
    }

    public final String k() {
        return this.f9885h;
    }

    public final void l(Integer num) {
        this.f9887j = num;
    }
}
