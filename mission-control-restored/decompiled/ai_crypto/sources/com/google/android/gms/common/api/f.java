package com.google.android.gms.common.api;

import P1.C0652f;
import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.AbstractC1167d;
import com.google.android.gms.common.api.internal.InterfaceC1169f;
import com.google.android.gms.common.api.internal.InterfaceC1178o;
import com.google.android.gms.common.api.internal.InterfaceC1182t;
import com.google.android.gms.common.internal.C1194e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import k2.C2066a;
import u.C2736a;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f10858a = Collections.newSetFromMap(new WeakHashMap());

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Account f10859a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f10862d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f10863e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f10864f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f10865g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Context f10867i;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Looper f10870l;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set f10860b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set f10861c = new HashSet();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map f10866h = new C2736a();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Map f10868j = new C2736a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f10869k = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public C0652f f10871m = C0652f.n();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public a.AbstractC0178a f10872n = k2.d.f17568c;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final ArrayList f10873o = new ArrayList();

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final ArrayList f10874p = new ArrayList();

        public a(Context context) {
            this.f10867i = context;
            this.f10870l = context.getMainLooper();
            this.f10864f = context.getPackageName();
            this.f10865g = context.getClass().getName();
        }

        public final C1194e a() {
            C2066a c2066a = C2066a.f17556j;
            Map map = this.f10868j;
            com.google.android.gms.common.api.a aVar = k2.d.f17572g;
            if (map.containsKey(aVar)) {
                c2066a = (C2066a) this.f10868j.get(aVar);
            }
            return new C1194e(this.f10859a, this.f10860b, this.f10866h, this.f10862d, this.f10863e, this.f10864f, this.f10865g, c2066a, false);
        }
    }

    public interface b extends InterfaceC1169f {
    }

    public interface c extends InterfaceC1178o {
    }

    public static Set c() {
        Set set = f10858a;
        synchronized (set) {
        }
        return set;
    }

    public abstract AbstractC1167d a(AbstractC1167d abstractC1167d);

    public abstract AbstractC1167d b(AbstractC1167d abstractC1167d);

    public a.f d(a.c cVar) {
        throw new UnsupportedOperationException();
    }

    public abstract Context e();

    public abstract Looper f();

    public boolean g(InterfaceC1182t interfaceC1182t) {
        throw new UnsupportedOperationException();
    }

    public void h() {
        throw new UnsupportedOperationException();
    }
}
