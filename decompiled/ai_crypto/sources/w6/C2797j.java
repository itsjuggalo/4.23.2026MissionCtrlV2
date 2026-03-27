package w6;

import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: renamed from: w6.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2797j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f25121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f25122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Q f25123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f25124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f25125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f25126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f25127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f25128h;

    public C2797j(boolean z7, boolean z8, Q q7, Long l7, Long l8, Long l9, Long l10, Map extras) {
        kotlin.jvm.internal.r.f(extras, "extras");
        this.f25121a = z7;
        this.f25122b = z8;
        this.f25123c = q7;
        this.f25124d = l7;
        this.f25125e = l8;
        this.f25126f = l9;
        this.f25127g = l10;
        this.f25128h = F5.J.s(extras);
    }

    public final Long a() {
        return this.f25126f;
    }

    public final Long b() {
        return this.f25124d;
    }

    public final boolean c() {
        return this.f25122b;
    }

    public final boolean d() {
        return this.f25121a;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f25121a) {
            arrayList.add("isRegularFile");
        }
        if (this.f25122b) {
            arrayList.add("isDirectory");
        }
        if (this.f25124d != null) {
            arrayList.add("byteCount=" + this.f25124d);
        }
        if (this.f25125e != null) {
            arrayList.add("createdAt=" + this.f25125e);
        }
        if (this.f25126f != null) {
            arrayList.add("lastModifiedAt=" + this.f25126f);
        }
        if (this.f25127g != null) {
            arrayList.add("lastAccessedAt=" + this.f25127g);
        }
        if (!this.f25128h.isEmpty()) {
            arrayList.add("extras=" + this.f25128h);
        }
        return F5.v.R(arrayList, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
    }

    public /* synthetic */ C2797j(boolean z7, boolean z8, Q q7, Long l7, Long l8, Long l9, Long l10, Map map, int i7, AbstractC2148j abstractC2148j) {
        this((i7 & 1) != 0 ? false : z7, (i7 & 2) == 0 ? z8 : false, (i7 & 4) != 0 ? null : q7, (i7 & 8) != 0 ? null : l7, (i7 & 16) != 0 ? null : l8, (i7 & 32) != 0 ? null : l9, (i7 & 64) == 0 ? l10 : null, (i7 & 128) != 0 ? F5.J.e() : map);
    }
}
