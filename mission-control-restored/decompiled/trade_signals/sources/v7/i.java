package v7;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import u7.M;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final M f23925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f23928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f23929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f23930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f23931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f23932h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f23933i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f23934j;

    public i(M canonicalPath, boolean z7, String comment, long j8, long j9, long j10, int i8, Long l8, long j11) {
        AbstractC2304t.f(canonicalPath, "canonicalPath");
        AbstractC2304t.f(comment, "comment");
        this.f23925a = canonicalPath;
        this.f23926b = z7;
        this.f23927c = comment;
        this.f23928d = j8;
        this.f23929e = j9;
        this.f23930f = j10;
        this.f23931g = i8;
        this.f23932h = l8;
        this.f23933i = j11;
        this.f23934j = new ArrayList();
    }

    public final M a() {
        return this.f23925a;
    }

    public final List b() {
        return this.f23934j;
    }

    public final long c() {
        return this.f23929e;
    }

    public final int d() {
        return this.f23931g;
    }

    public final Long e() {
        return this.f23932h;
    }

    public final long f() {
        return this.f23933i;
    }

    public final long g() {
        return this.f23930f;
    }

    public final boolean h() {
        return this.f23926b;
    }

    public /* synthetic */ i(M m8, boolean z7, String str, long j8, long j9, long j10, int i8, Long l8, long j11, int i9, AbstractC2296k abstractC2296k) {
        this(m8, (i9 & 2) != 0 ? false : z7, (i9 & 4) != 0 ? "" : str, (i9 & 8) != 0 ? -1L : j8, (i9 & 16) != 0 ? -1L : j9, (i9 & 32) != 0 ? -1L : j10, (i9 & 64) != 0 ? -1 : i8, (i9 & 128) != 0 ? null : l8, (i9 & 256) == 0 ? j11 : -1L);
    }
}
