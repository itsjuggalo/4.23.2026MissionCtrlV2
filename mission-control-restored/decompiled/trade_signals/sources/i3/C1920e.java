package i3;

import k3.AbstractC2279m;
import m3.h;

/* JADX INFO: renamed from: i3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1920e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1920e f18791d = new C1920e(a.User, null, false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C1920e f18792e = new C1920e(a.Server, null, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f18793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f18794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f18795c;

    /* JADX INFO: renamed from: i3.e$a */
    public enum a {
        User,
        Server
    }

    public C1920e(a aVar, h hVar, boolean z7) {
        this.f18793a = aVar;
        this.f18794b = hVar;
        this.f18795c = z7;
        AbstractC2279m.f(!z7 || c());
    }

    public static C1920e a(h hVar) {
        return new C1920e(a.Server, hVar, true);
    }

    public h b() {
        return this.f18794b;
    }

    public boolean c() {
        return this.f18793a == a.Server;
    }

    public boolean d() {
        return this.f18793a == a.User;
    }

    public boolean e() {
        return this.f18795c;
    }

    public String toString() {
        return "OperationSource{source=" + this.f18793a + ", queryParams=" + this.f18794b + ", tagged=" + this.f18795c + '}';
    }
}
