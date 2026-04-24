package com.google.firebase.sessions;

import Q2.n;
import Z3.J;
import Z3.L;
import Z3.x;
import Z5.t;
import java.util.Locale;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f12310f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J f12311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final L f12312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public x f12315e;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final j a() {
            return ((b) n.a(Q2.c.f4486a).k(b.class)).a();
        }

        public a() {
        }
    }

    public j(J timeProvider, L uuidGenerator) {
        r.f(timeProvider, "timeProvider");
        r.f(uuidGenerator, "uuidGenerator");
        this.f12311a = timeProvider;
        this.f12312b = uuidGenerator;
        this.f12313c = b();
        this.f12314d = -1;
    }

    public final x a() {
        int i7 = this.f12314d + 1;
        this.f12314d = i7;
        this.f12315e = new x(i7 == 0 ? this.f12313c : b(), this.f12313c, this.f12314d, this.f12311a.a());
        return c();
    }

    public final String b() {
        String string = this.f12312b.next().toString();
        r.e(string, "uuidGenerator.next().toString()");
        String lowerCase = t.w(string, "-", "", false, 4, null).toLowerCase(Locale.ROOT);
        r.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final x c() {
        x xVar = this.f12315e;
        if (xVar != null) {
            return xVar;
        }
        r.s("currentSession");
        return null;
    }
}
