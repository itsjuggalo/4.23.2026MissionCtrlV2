package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.AbstractC0901e;
import com.google.android.gms.common.api.internal.InterfaceC0903g;
import com.google.android.gms.common.api.internal.InterfaceC0912p;
import com.google.android.gms.common.api.internal.InterfaceC0916u;
import com.google.android.gms.common.internal.C0927e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import u.C1853a;
import z1.C1988f;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f9673a = Collections.newSetFromMap(new WeakHashMap());

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Account f9674a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f9677d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f9678e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f9679f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f9680g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Context f9682i;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Looper f9685l;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set f9675b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set f9676c = new HashSet();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map f9681h = new C1853a();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Map f9683j = new C1853a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f9684k = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public C1988f f9686m = C1988f.n();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public a.AbstractC0145a f9687n = U1.d.f5261c;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final ArrayList f9688o = new ArrayList();

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final ArrayList f9689p = new ArrayList();

        public a(Context context) {
            this.f9682i = context;
            this.f9685l = context.getMainLooper();
            this.f9679f = context.getPackageName();
            this.f9680g = context.getClass().getName();
        }

        public final C0927e a() {
            U1.a aVar = U1.a.f5249j;
            Map map = this.f9683j;
            com.google.android.gms.common.api.a aVar2 = U1.d.f5265g;
            if (map.containsKey(aVar2)) {
                aVar = (U1.a) this.f9683j.get(aVar2);
            }
            return new C0927e(this.f9674a, this.f9675b, this.f9681h, this.f9677d, this.f9678e, this.f9679f, this.f9680g, aVar, false);
        }
    }

    public interface b extends InterfaceC0903g {
    }

    public interface c extends InterfaceC0912p {
    }

    public static Set c() {
        Set set = f9673a;
        synchronized (set) {
        }
        return set;
    }

    public abstract AbstractC0901e a(AbstractC0901e abstractC0901e);

    public abstract AbstractC0901e b(AbstractC0901e abstractC0901e);

    public a.f d(a.c cVar) {
        throw new UnsupportedOperationException();
    }

    public abstract Context e();

    public abstract Looper f();

    public boolean g(InterfaceC0916u interfaceC0916u) {
        throw new UnsupportedOperationException();
    }

    public void h() {
        throw new UnsupportedOperationException();
    }
}
