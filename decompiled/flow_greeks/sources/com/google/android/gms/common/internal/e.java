package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.g;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Account f5677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f5678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f5679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f5680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f5682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f5683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f5684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g6.a f5685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f5686j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Account f5687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public w.b f5688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f5689c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f5690d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final g6.a f5691e = g6.a.f10073j;

        public e a() {
            return new e(this.f5687a, this.f5688b, null, 0, null, this.f5689c, this.f5690d, this.f5691e, false);
        }

        public a b(String str) {
            this.f5689c = str;
            return this;
        }

        public final a c(Account account) {
            this.f5687a = account;
            return this;
        }

        public final a d(Collection collection) {
            if (this.f5688b == null) {
                this.f5688b = new w.b();
            }
            this.f5688b.addAll(collection);
            return this;
        }

        public final a e(String str) {
            this.f5690d = str;
            return this;
        }
    }

    public e(Account account, Set set, Map map, int i10, View view, String str, String str2, g6.a aVar, boolean z10) {
        this.f5677a = account;
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f5678b = setUnmodifiableSet;
        map = map == null ? Collections.EMPTY_MAP : map;
        this.f5680d = map;
        this.f5682f = view;
        this.f5681e = i10;
        this.f5683g = str;
        this.f5684h = str2;
        this.f5685i = aVar == null ? g6.a.f10073j : aVar;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
        this.f5679c = Collections.unmodifiableSet(hashSet);
    }

    public static e a(Context context) {
        return new g.a(context).a();
    }

    public Account b() {
        return this.f5677a;
    }

    public String c() {
        Account account = this.f5677a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    public Account d() {
        Account account = this.f5677a;
        return account != null ? account : new Account(c.DEFAULT_ACCOUNT, "com.google");
    }

    public Set e() {
        return this.f5679c;
    }

    public Set f(com.google.android.gms.common.api.a aVar) {
        android.support.v4.media.session.b.a(this.f5680d.get(aVar));
        return this.f5678b;
    }

    public String g() {
        return this.f5683g;
    }

    public Set h() {
        return this.f5678b;
    }

    public final String i() {
        return this.f5684h;
    }

    public final g6.a j() {
        return this.f5685i;
    }

    public final Integer k() {
        return this.f5686j;
    }

    public final void l(Integer num) {
        this.f5686j = num;
    }
}
