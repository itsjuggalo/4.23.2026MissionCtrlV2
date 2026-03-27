package x6;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import w6.Q;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q f25343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f25344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f25345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f25346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f25347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f25348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f25349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f25350h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f25351i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f25352j;

    public i(Q canonicalPath, boolean z7, String comment, long j7, long j8, long j9, int i7, Long l7, long j10) {
        r.f(canonicalPath, "canonicalPath");
        r.f(comment, "comment");
        this.f25343a = canonicalPath;
        this.f25344b = z7;
        this.f25345c = comment;
        this.f25346d = j7;
        this.f25347e = j8;
        this.f25348f = j9;
        this.f25349g = i7;
        this.f25350h = l7;
        this.f25351i = j10;
        this.f25352j = new ArrayList();
    }

    public final Q a() {
        return this.f25343a;
    }

    public final List b() {
        return this.f25352j;
    }

    public final long c() {
        return this.f25347e;
    }

    public final int d() {
        return this.f25349g;
    }

    public final Long e() {
        return this.f25350h;
    }

    public final long f() {
        return this.f25351i;
    }

    public final long g() {
        return this.f25348f;
    }

    public final boolean h() {
        return this.f25344b;
    }

    public /* synthetic */ i(Q q7, boolean z7, String str, long j7, long j8, long j9, int i7, Long l7, long j10, int i8, AbstractC2148j abstractC2148j) {
        this(q7, (i8 & 2) != 0 ? false : z7, (i8 & 4) != 0 ? "" : str, (i8 & 8) != 0 ? -1L : j7, (i8 & 16) != 0 ? -1L : j8, (i8 & 32) != 0 ? -1L : j9, (i8 & 64) != 0 ? -1 : i7, (i8 & 128) != 0 ? null : l7, (i8 & 256) == 0 ? j10 : -1L);
    }
}
