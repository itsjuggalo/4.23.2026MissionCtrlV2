package u7;

import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: u7.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2816i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f23663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final M f23665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f23666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f23667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f23668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f23669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f23670h;

    public C2816i(boolean z7, boolean z8, M m8, Long l8, Long l9, Long l10, Long l11, Map extras) {
        AbstractC2304t.f(extras, "extras");
        this.f23663a = z7;
        this.f23664b = z8;
        this.f23665c = m8;
        this.f23666d = l8;
        this.f23667e = l9;
        this.f23668f = l10;
        this.f23669g = l11;
        this.f23670h = p5.M.w(extras);
    }

    public final Long a() {
        return this.f23668f;
    }

    public final Long b() {
        return this.f23666d;
    }

    public final boolean c() {
        return this.f23664b;
    }

    public final boolean d() {
        return this.f23663a;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f23663a) {
            arrayList.add("isRegularFile");
        }
        if (this.f23664b) {
            arrayList.add("isDirectory");
        }
        if (this.f23666d != null) {
            arrayList.add("byteCount=" + this.f23666d);
        }
        if (this.f23667e != null) {
            arrayList.add("createdAt=" + this.f23667e);
        }
        if (this.f23668f != null) {
            arrayList.add("lastModifiedAt=" + this.f23668f);
        }
        if (this.f23669g != null) {
            arrayList.add("lastAccessedAt=" + this.f23669g);
        }
        if (!this.f23670h.isEmpty()) {
            arrayList.add("extras=" + this.f23670h);
        }
        return p5.z.h0(arrayList, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
    }

    public /* synthetic */ C2816i(boolean z7, boolean z8, M m8, Long l8, Long l9, Long l10, Long l11, Map map, int i8, AbstractC2296k abstractC2296k) {
        this((i8 & 1) != 0 ? false : z7, (i8 & 2) == 0 ? z8 : false, (i8 & 4) != 0 ? null : m8, (i8 & 8) != 0 ? null : l8, (i8 & 16) != 0 ? null : l9, (i8 & 32) != 0 ? null : l10, (i8 & 64) == 0 ? l11 : null, (i8 & 128) != 0 ? p5.M.h() : map);
    }
}
